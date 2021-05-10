package next.race.app.nextrace.repositories;

import next.race.app.nextrace.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
