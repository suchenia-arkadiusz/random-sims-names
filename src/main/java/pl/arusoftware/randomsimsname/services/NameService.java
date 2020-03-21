package pl.arusoftware.randomsimsname.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.arusoftware.randomsimsname.data.dao.NameDAO;
import pl.arusoftware.randomsimsname.data.entities.Name;
import pl.arusoftware.randomsimsname.data.exceptions.NameNotFoundException;

import java.util.Set;

@Service
public class NameService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NameService.class);

    private NameDAO nameDAO;

    public NameService(NameDAO nameDAO) {
        this.nameDAO = nameDAO;
    }

    public void addName(String name, String genderName) {
        Name.Gender gender = Name.Gender.valueOf(genderName.toUpperCase());
        Name entry = new Name(name, gender, false);
        nameDAO.save(entry);
    }

    public void setIsUsedStatus(String name, boolean isUsed) throws NameNotFoundException {
        try {
            Name entry = nameDAO.getName(name);
            Name newEntry = new Name(entry.getId(), entry.getGender(), isUsed);
            nameDAO.update(newEntry);
        } catch (NameNotFoundException e) {
            LOGGER.error("Exception during set is used status: " + e.getMessage());
            throw e;
        }
    }

    public Name getName(String name) throws NameNotFoundException {
        try {
            return nameDAO.getName(name);
        } catch (NameNotFoundException e) {
            LOGGER.error("Exception during get name: " + e.getMessage());
            throw e;
        }
    }

    public Set<Name> getAllNames() {
        return nameDAO.getAllNames();
    }

    public void deleteName(String name) {
        nameDAO.delete(name);
    }

    public void deleteName(Name name) {
        nameDAO.delete(name);
    }
}
