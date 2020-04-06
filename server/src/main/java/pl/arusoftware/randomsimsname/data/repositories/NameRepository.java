package pl.arusoftware.randomsimsname.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.arusoftware.randomsimsname.data.entities.Name;

import java.util.List;

@Repository
public interface NameRepository extends CrudRepository<Name, String> {
    List<Name> getAllByGenderAndIsUsedEquals(Name.Gender gender, boolean isUsed);
    List<Name> findAllByOrderByIdAsc();
}
