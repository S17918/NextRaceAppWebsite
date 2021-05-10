package next.race.app.nextrace.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Category category;

    @OneToOne
    private Track track;
    private int laps;
    private String raceName;
    private Boolean tookPlace = false;

    @OneToOne
    private EventList eventList;

    public Race(Category category, Track track, int laps, String raceName, Boolean tookPlace, EventList eventList) {
        this.category = category;
        this.track = track;
        this.laps = laps;
        this.raceName = raceName;
        this.tookPlace = tookPlace;
        this.eventList = eventList;
    }

    public Race() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Boolean getTookPlace() {
        return tookPlace;
    }

    public void setTookPlace(Boolean tookPlace) {
        this.tookPlace = tookPlace;
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    public void setEventList(Optional<EventList> byId) {
    }
}
