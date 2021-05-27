package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.EventList;
import next.race.app.nextrace.models.Race;
import next.race.app.nextrace.repositories.*;
import next.race.app.nextrace.transporters.EventListModelTransporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EventListRepository eventListRepository;

    @RequestMapping(path="/nextraceapp/race")
    public String race(Model model){
        Race race = new Race();
        model.addAttribute("race", race);
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());
        return "race";
    }

    @RequestMapping(path="/nextraceapp/race/add")
    public String add_race(Model model){
        Race race = new Race();

        model.addAttribute("race", race);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());
        return "add_race";
    }

    @PostMapping("/nextraceapp/race/add/succes")
    public String addRace(Race race, Model model){
        EventList eventList = EventListModelTransporter.getEventList();
        race.setEventList(eventList);
        raceRepository.save(race);

        model.addAttribute("race", raceRepository.findAll());
        model.addAttribute("races", raceRepository.findAll());

        return "redirect:/nextraceapp/race";
    }

    @GetMapping("/nextraceapp/race/edit/{id}")
    public String editRace(@PathVariable("id") long id, Model model){
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid race id: " + id));

        EventListModelTransporter.setEventList(race.getEventList());

        model.addAttribute("race", race);
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());

        return("edit_race");
    }

    @PostMapping("/nextraceapp/race/update/{id}")
    public String updateRace(@PathVariable("id") long id, Race race, Model model){
        race.setId(id);
        race.setEventList(EventListModelTransporter.getEventList());
        raceRepository.save(race);

        model.addAttribute("race", raceRepository.findAll());
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());

        return "redirect:/nextraceapp/race";
    }

    @GetMapping("/nextraceapp/race/delete/{id}")
    public String deleteRace(@PathVariable("id") long id, Model model){
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid race id: " + id));

        raceRepository.delete(race);
        model.addAttribute("races", raceRepository.findAll());
        return "redirect:/nextraceapp/race";
    }

}
