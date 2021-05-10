package next.race.app.nextrace.models;

import javax.persistence.*;
import java.net.URL;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    private Country country;
    private URL layout;
    private String length;
    private String turnCount;
    private String lapRecord;
    private String personRecord;

    public Track(String name, Country country, URL layout, String dlugosc, String turnCount, String lapRecord, String personRecord) {
        this.name = name;
        this.country = country;
        this.layout = layout;
        this.length = dlugosc;
        this.turnCount = turnCount;
        this.lapRecord = lapRecord;
        this.personRecord = personRecord;
    }

    public Track() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public URL getLayout() {
        return layout;
    }

    public void setLayout(URL layout) {
        this.layout = layout;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String dlugosc) {
        this.length = dlugosc;
    }

    public String getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(String iloscZakretow) {
        this.turnCount = iloscZakretow;
    }

    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String rekordOkrazenia) {
        this.lapRecord = rekordOkrazenia;
    }

    public String getPersonRecord() {
        return personRecord;
    }

    public void setPersonRecord(String osobaZRekordem) {
        this.personRecord = osobaZRekordem;
    }
}
