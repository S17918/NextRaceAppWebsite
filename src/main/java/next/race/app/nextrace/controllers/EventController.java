package next.race.app.nextrace.controllers;

import next.race.app.nextrace.models.Category;
import next.race.app.nextrace.models.Country;
import next.race.app.nextrace.models.Event;
import next.race.app.nextrace.models.EventList;
import next.race.app.nextrace.repositories.CategoryRepository;
import next.race.app.nextrace.repositories.EventListRepository;
import next.race.app.nextrace.repositories.EventRepository;
import next.race.app.nextrace.repositories.TrackRepository;
import next.race.app.nextrace.transporters.EventListModelTransporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/nextraceapp")
@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private EventListRepository eventListRepository;

    public List<Event> eventList = new ArrayList<Event>();

    private int position;

    @RequestMapping(path="/race/event/list")
    public String add_race_event_list(Model model){
        Event event = new Event();

        model.addAttribute("events", eventList);
        model.addAttribute("event", event);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());
        return "add_race_event_list";
    }


    @RequestMapping(path="/race/event/add")
    public String add_race_event(Model model){
        Event event = new Event();

        List<String> event_type_list = Arrays.asList("Race", "Sprint Race" ,"Qualifications", "Practice 3", "Practice 2", "Practice 1");

        model.addAttribute("event_type", event_type_list);
        model.addAttribute("events", eventList);
        model.addAttribute("event", event);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());
        return "add_race_event";
    }

    @PostMapping("/race/event/add/succes")
    public String addRaceEvent(Event event, Model model){
        eventRepository.save(event);
        eventList.add(event);

        model.addAttribute("event", eventRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());

        return "redirect:/nextraceapp/race/event/list";
    }

    @RequestMapping("/race/event/submit")
    public String addRaceEventSubmit(){
        EventList eventListModel = new EventList();
        eventListModel.setEvents(eventList);
        eventListRepository.save(eventListModel);
        EventListModelTransporter.setEventList(eventListModel);
        eventList.clear();
        return "redirect:/nextraceapp/race/add";
    }

    @GetMapping("/race/event/delete/{id}")
    public String deleteEvent(@PathVariable("id") long id, Model model){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event id: " + id));

        if(eventList.size() == 1){
            eventList.clear();
        }else{
            for(int x = 0; x < eventList.size(); x++){
                Event old_event = eventList.get(x);
                if(old_event.getId() == event.getId()){
                    eventList.remove(x);
                }
            }
        }
        eventRepository.delete(event);

        model.addAttribute("events", eventList);
        model.addAttribute("event", event);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tracks", trackRepository.findAll());

        return "redirect:/nextraceapp/race/event/list";
    }

    @GetMapping("/race/event/edit/{id}")
    public String editEvent(@PathVariable("id") long id, Model model){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event id: " + id));

        if(eventList.size() == 1){
            eventList.clear();
        }else{
            for(int x = 0; x < eventList.size(); x++){
                Event old_event = eventList.get(x);
                if(old_event.getId() == event.getId()){
                    eventList.remove(x);
                    position = x;
                }
            }
        }

        Category category = new Category();


        List<String> event_type_list = Arrays.asList("Race", "Sprint Race" ,"Qualifications", "Practice 3", "Practice 2", "Practice 1");

        model.addAttribute("event_type", event_type_list);
        model.addAttribute("event", event);
        model.addAttribute("events", eventList);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());

        return("edit_event");
    }

    @PostMapping("/race/event/update/{id}")
    public String updateEvent(@PathVariable("id") long id, Event event, Model model){
        event.setId(id);
        eventRepository.save(event);
        eventList.add(position, event);
        position = -1;

        model.addAttribute("event", eventRepository.findAll());
        model.addAttribute("events", eventList);

        return "redirect:/nextraceapp/race/event/list";
    }
}
