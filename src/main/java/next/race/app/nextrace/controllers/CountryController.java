package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.models.Country;
import next.race.app.nextrace.repositories.CategoryRepository;
import next.race.app.nextrace.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/nextraceapp")
@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path="/country")
    public String country(Model model){
        Category category = new Category();
        Country country = new Country();
        model.addAttribute("country", country);
        model.addAttribute("countries", countryRepository.findAll());
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "country";
    }

    @RequestMapping(path="/country/add")
    public String add_country(Model model){
        Country country = new Country();
        Category category = new Category();
        model.addAttribute("country", country);
        model.addAttribute("countries", countryRepository.findAll());
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "add_country";
    }

    @PostMapping("/country/add/succes")
    public String addCountry(Country country, Model model){
        countryRepository.save(country);

        model.addAttribute("country", countryRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());

        return "redirect:/nextraceapp/country";
    }

    @GetMapping("/country/edit/{id}")
    public String editCountry(@PathVariable("id") long id, Model model){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country id: " + id));

        Category category = new Category();

        model.addAttribute("country", country);
        model.addAttribute("countries", countryRepository.findAll());
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());

        return("edit_country");
    }

    @PostMapping("/country/update/{id}")
    public String updateCategory(@PathVariable("id") long id, Country country, Model model){
        country.setId(id);
        countryRepository.save(country);

        model.addAttribute("country", countryRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());

        return "redirect:/nextraceapp/country";
    }

    @GetMapping("/country/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country id: " + id));

        countryRepository.delete(country);
        model.addAttribute("countries", countryRepository.findAll());
        return "redirect:/nextraceapp/country";
    }
}
