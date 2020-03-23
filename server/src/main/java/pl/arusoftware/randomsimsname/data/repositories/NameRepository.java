package pl.arusoftware.randomsimsname.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.arusoftware.randomsimsname.data.entities.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, String> {
}
