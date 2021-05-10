package next.race.app.nextrace.repositories;

import next.race.app.nextrace.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
