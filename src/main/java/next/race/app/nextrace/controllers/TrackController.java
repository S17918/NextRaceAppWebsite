package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.models.Country;
import next.race.app.nextrace.models.Track;
import next.race.app.nextrace.repositories.CategoryRepository;
import next.race.app.nextrace.repositories.CountryRepository;
import next.race.app.nextrace.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/nextraceapp")
@Controller
public class TrackController {


    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(path="/track")
    public String track(Model model){
        Track track = new Track();
        model.addAttribute("track", track);
        model.addAttribute("tracks", trackRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        return "track";
    }

    @RequestMapping(path="/track/add")
    public String add_track(Model model) throws IOException {
        Track track = new Track();

        model.addAttribute("track", track);
        model.addAttribute("country_list", countryRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "add_track";
    }

    @PostMapping("/track/add/succes")
    public String addTrack(Track track, Model model){
        trackRepository.save(track);

        model.addAttribute("track", trackRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());

        return "redirect:/nextraceapp/track";
    }

    @GetMapping("/track/edit/{id}")
    public String editTrack(@PathVariable("id") long id, Model model){
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid track id: " + id));

        model.addAttribute("country_list", countryRepository.findAll());
        model.addAttribute("track", track);
        model.addAttribute("tracks", trackRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        return("edit_track");
    }

    @PostMapping("/track/update/{id}")
    public String updateTrack(@PathVariable("id") long id, Track track, Model model){
        track.setId(id);
        trackRepository.save(track);

        model.addAttribute("track", trackRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());

        return "redirect:/nextraceapp/track";
    }

    @GetMapping("/track/delete/{id}")
    public String deleteTrack(@PathVariable("id") long id, Model model){
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid track id: " + id));

        trackRepository.delete(track);
        model.addAttribute("tracks", trackRepository.findAll());
        return "redirect:/nextraceapp/track";
    }
}
