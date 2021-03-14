package pl.arusoftware.randomsimsname.data.dao;

import org.springframework.stereotype.Service;
import pl.arusoftware.randomsimsname.data.entities.Aspiration;
import pl.arusoftware.randomsimsname.data.exceptions.AspirationNotFoundException;
import pl.arusoftware.randomsimsname.data.repositories.AspirationRepository;

import java.util.List;

@Service
public class AspirationDAO {
    private AspirationRepository repository;

    public AspirationDAO(AspirationRepository repository) {
        this.repository = repository;
    }

    public Aspiration save(Aspiration aspiration) {
        return repository.save(aspiration);
    }

    public List<Aspiration> saveAll(List<Aspiration> aspirations) {
        return (List<Aspiration>) repository.saveAll(aspirations);
    }

    public Aspiration update(Aspiration aspiration) {
        return repository.save(aspiration);
    }

    public Aspiration getAspiration(String name) throws AspirationNotFoundException {
        return repository.findById(name).orElseThrow(() -> new AspirationNotFoundException("Aspiration \"" + name + "\" not found"));
    }

    public List<Aspiration> getAllAspirations() {
        return repository.findAllByOrderByCategoryAsc();
    }

    public List<Aspiration> getAllForChild() {
        return repository.findAllByIsChildTrueOrderByCategoryAsc();
    }

    public List<Aspiration> getAllForTeenager() {
        return repository.findAllByIsTeenagerTrueOrderByCategoryAsc();
    }

    public void delete(String name) {
        repository.deleteById(name);
    }

    public void delete(Aspiration aspiration) {
        repository.delete(aspiration);
    }
}
