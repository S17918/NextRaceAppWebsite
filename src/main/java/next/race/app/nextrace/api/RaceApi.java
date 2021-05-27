package next.race.app.nextrace.api;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.models.Event;
import next.race.app.nextrace.models.Race;
import next.race.app.nextrace.models.Track;
import next.race.app.nextrace.repositories.CategoryRepository;
import next.race.app.nextrace.repositories.RaceRepository;
import next.race.app.nextrace.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RequestMapping("/api")
@RestController
public class RaceApi {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/races")
    public List<Race> getRaces(){
        return raceRepository.sortByDate();
    }

    @GetMapping("/races/{year}/{month}")
    public List<Race> getRacesByDate(@PathVariable("year") String year, @PathVariable("month") String month){
        String date = year + '-' + month;
        List<Race> raceByDate = raceRepository.findByDate(date);
        return raceByDate;
    }


    @GetMapping("/races/category/{cat_name}")
    public List<Race> getRacesByCategory(@PathVariable("cat_name") String cat_name){

            List<Race> raceByCategory = raceRepository.findByCategoryName(cat_name);
            return raceByCategory;
    }

    @GetMapping("/races/country/{country_name}")
    public List<Race> getRacesByCountry(@PathVariable("country_name") String country_name){

        List<Race> raceByCountry = raceRepository.findByCountryName(country_name);
        return raceByCountry;
    }

    @GetMapping("/races/track/{track_name}")
    public List<Race> getRacesByTrack(@PathVariable("track_name") String track_name){

        List<Race> raceByTrack = raceRepository.findByTrackName(track_name);
        return raceByTrack;
    }

    @GetMapping("/tracks")
    public List<Track> getTracks(){
        return (List<Track>) trackRepository.findAll();
    }
    @GetMapping("/tracks/{country}")
    public List<Track> getTrackByCountry(@PathVariable("country") String country){

        List<Track> trackByCountry = trackRepository.findByCountry(country);
        return trackByCountry;
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
}
