package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/nextraceapp")
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path="/category")
    public String category(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";
    }

    @RequestMapping(path="/category/add")
    public String add_category(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "add_category";
    }

    @PostMapping("/category/add/succes")
    public String addCategory(Category category, Model model){
        categoryRepository.save(category);

        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        return "redirect:/nextraceapp/category";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable("id") long id, Model model){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + id));

        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());

        return("edit_category");
    }

    @PostMapping("/category/update/{id}")
    public String updateCategory(@PathVariable("id") long id, Category category, Model model){
        category.setId(id);
        categoryRepository.save(category);

        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        return "redirect:/nextraceapp/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + id));

        categoryRepository.delete(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect:/nextraceapp/category";
    }

}
