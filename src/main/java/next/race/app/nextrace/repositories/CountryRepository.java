package next.race.app.nextrace.repositories;

import next.race.app.nextrace.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
