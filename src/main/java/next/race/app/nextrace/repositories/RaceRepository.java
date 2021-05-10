package next.race.app.nextrace.repositories;

import next.race.app.nextrace.models.Race;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RaceRepository extends CrudRepository<Race, Long> {

    @Query(value = "SELECT * FROM race INNER JOIN event_list_events ON race.event_list_id = event_list_events.event_list_id INNER JOIN event ON event_list_events.events_id = event.id INNER JOIN category ON race.category_id = category.id WHERE category_name =:NAME AND event.type = 'Race' ORDER BY event.date ASC;", nativeQuery = true)
    List<Race> findByCategoryName(@Param("NAME") String name);

    @Query(value = "SELECT * FROM race INNER JOIN event_list_events ON race.event_list_id = event_list_events.event_list_id INNER JOIN event ON event_list_events.events_id = event.id INNER JOIN track ON track_id = track.id INNER JOIN country ON country_id = country.id WHERE country_name =:NAME AND event.type = 'Race' ORDER BY event.date ASC;", nativeQuery = true)
    List<Race> findByCountryName(@Param("NAME") String name);

    @Query(value = "SELECT * FROM race INNER JOIN event_list_events ON race.event_list_id = event_list_events.event_list_id INNER JOIN event ON event_list_events.events_id = event.id INNER JOIN track ON track_id = track.id WHERE NAME LIKE %:NAME% AND event.type = 'Race' ORDER BY event.date ASC;", nativeQuery = true)
    List<Race> findByTrackName(@Param("NAME") String name);

    @Query(value = "SELECT * FROM race INNER JOIN event_list_events ON race.event_list_id = event_list_events.event_list_id INNER JOIN event ON event_list_events.events_id = event.id WHERE event.type = 'Race' ORDER BY event.date ASC;", nativeQuery = true)
    List<Race> sortByDate();

}
