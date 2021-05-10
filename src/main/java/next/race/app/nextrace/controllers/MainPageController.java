package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.models.Country;
import next.race.app.nextrace.models.Race;
import next.race.app.nextrace.models.Track;
import next.race.app.nextrace.repositories.CategoryRepository;
import next.race.app.nextrace.repositories.CountryRepository;
import next.race.app.nextrace.repositories.RaceRepository;
import next.race.app.nextrace.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(path="/nextraceapp")
    public String NextRaceApp(Model model){
        Track track = new Track();
        Category category = new Category();
        Race race = new Race();
        Country country = new Country();

        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("track", track);
        model.addAttribute("tracks", trackRepository.findAll());
        model.addAttribute("race", race);
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("country", country);
        model.addAttribute("countries", countryRepository.findAll());
        return "main_page";
    }



}
