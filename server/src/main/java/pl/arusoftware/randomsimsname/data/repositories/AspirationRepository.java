package pl.arusoftware.randomsimsname.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.arusoftware.randomsimsname.data.entities.Aspiration;

import java.util.List;

@Repository
public interface AspirationRepository extends CrudRepository<Aspiration, String> {
    List<Aspiration> findAllByOrderByCategoryAsc();
    List<Aspiration> findAllByIsChildTrueOrderByCategoryAsc();
    List<Aspiration> findAllByIsTeenagerTrueOrderByCategoryAsc();
}
