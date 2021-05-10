package next.race.app.nextrace.repositories;

import next.race.app.nextrace.models.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long> {

    @Query(value = "SELECT * FROM track WHERE NAME =:NAME;", nativeQuery = true)
    List<Track> findByCountry(@Param("NAME") String name);

}
