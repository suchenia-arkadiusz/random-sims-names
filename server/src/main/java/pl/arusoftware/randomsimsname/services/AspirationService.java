package pl.arusoftware.randomsimsname.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.arusoftware.randomsimsname.data.dao.AspirationDAO;
import pl.arusoftware.randomsimsname.data.entities.Aspiration;
import pl.arusoftware.randomsimsname.data.exceptions.AspirationNotFoundException;

import java.util.List;
import java.util.Random;

@Service
public class AspirationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspirationService.class);
    private static final Random RAND = new Random();

    private final AspirationDAO aspirationDAO;

    public AspirationService(AspirationDAO aspirationDAO) {
        this.aspirationDAO = aspirationDAO;
    }

    public void addAspiration(String name, String description, String categoryName, String bonus, String dlcName, boolean isChild,
                              boolean isTeenager) {
        Aspiration.Category category = Aspiration.Category.valueOf(categoryName.toUpperCase());
        Aspiration entry = new Aspiration(name, description, category, bonus, dlcName, isChild, isTeenager);
        aspirationDAO.save(entry);
    }

    public void addAspirations(List<Aspiration> aspirations) {
        aspirationDAO.saveAll(aspirations);
    }

    public Aspiration getAspiration(String name) throws AspirationNotFoundException {
        try {
            return aspirationDAO.getAspiration(name);
        } catch (AspirationNotFoundException e) {
            LOGGER.error("Exception during get aspiration: {}", e.getMessage());
            throw e;
        }
    }

    public List<Aspiration> getAllAspirations() {
        return aspirationDAO.getAllAspirations();
    }

    public List<Aspiration> getAllAspirationsForChild() {
        return aspirationDAO.getAllForChild();
    }

    public List<Aspiration> getAllAspirationForTeenager() {
        return aspirationDAO.getAllForTeenager();
    }

    public Aspiration getRandomAspiration() {
        List<Aspiration> entries = aspirationDAO.getAllAspirations();
        List<Aspiration> childEntries = aspirationDAO.getAllForChild();
        entries.removeAll(childEntries);
        if (entries.isEmpty()) {
            return new Aspiration();
        }
        int index = RAND.nextInt(entries.size());
        return entries.get(index);
    }

    public Aspiration getRandomAspirationForChild() {
        List<Aspiration> entries = aspirationDAO.getAllForChild();
        int index = RAND.nextInt(entries.size());
        return entries.get(index);
    }

    public Aspiration getRandomAspirationForTeenager() {
        List<Aspiration> entries = aspirationDAO.getAllForTeenager();
        int index = RAND.nextInt(entries.size());
        return entries.get(index);
    }

    public void deleteAspiration(String name) throws AspirationNotFoundException {
        try {
            aspirationDAO.delete(name);
        } catch (Exception e) {
            LOGGER.error("Error during delete name: {}", e.getMessage());
            throw new AspirationNotFoundException("Aspiration \"" + name + "\" not found");
        }
    }

    public void deleteAspiration(Aspiration aspiration) {
        aspirationDAO.delete(aspiration);
    }
}
