package pl.arusoftware.randomsimsname.data.dao;

import org.springframework.stereotype.Service;
import pl.arusoftware.randomsimsname.data.entities.Name;
import pl.arusoftware.randomsimsname.data.exceptions.NameNotFoundException;
import pl.arusoftware.randomsimsname.data.repositories.NameRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NameDAO {
    private NameRepository repository;

    public NameDAO(NameRepository repository) {
        this.repository = repository;
    }

    public Name save(Name name) {
        return repository.save(name);
    }

    public Name update(Name name) {
        return repository.save(name);
    }

    public Name getName(String name) throws NameNotFoundException {
        return repository.findById(name).orElseThrow(() -> new NameNotFoundException("Name \"" + name + "\" not found"));
    }

    public Set<Name> getAllNames() {
        Set<Name> result = new HashSet<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public List<Name> getNamesByGender(Name.Gender gender) {
        return repository.getAllByGenderAndIsUsedEquals(gender, false);
    }

    public void delete(String name) {
        repository.deleteById(name);
    }

    public void delete(Name name) {
        repository.delete(name);
    }
}
