package next.race.app.nextrace.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String localTime;
    private String cetTime;

    @ManyToOne
    private EventList list_of_events;

    public Event(String type, Date date, String localTime, String cetTime, EventList list_of_events) {
        this.type = type;
        this.date = date;
        this.localTime = localTime;
        this.cetTime = cetTime;
        this.list_of_events = list_of_events;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getCetTime() {
        return cetTime;
    }

    public void setCetTime(String cetTime) {
        this.cetTime = cetTime;
    }

    public EventList getList_of_events() {
        return list_of_events;
    }

    public void setList_of_events(EventList eventList) {
        this.list_of_events = eventList;
    }
}
