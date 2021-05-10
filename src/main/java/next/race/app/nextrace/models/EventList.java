package next.race.app.nextrace.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class EventList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Event> events;

    public EventList(List<Event> events) {
        this.events = events;
    }

    public EventList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> eventList) {
        this.events = eventList;
    }
}
