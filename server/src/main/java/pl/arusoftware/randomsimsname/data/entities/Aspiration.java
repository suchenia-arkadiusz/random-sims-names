package pl.arusoftware.randomsimsname.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASPIRATIONS")
public class Aspiration {
    @Id
    private String id;
    private String description;
    private Category category;
    private String bonus;
    private String dlcName;
    private boolean isChild;
    private boolean isTeenager;

    public Aspiration() {
    }

    public Aspiration(String id, String description, Category category, String bonus, String dlcName, boolean isChild, boolean isTeenager) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.bonus = bonus;
        this.dlcName = dlcName;
        this.isChild = isChild;
        this.isTeenager = isTeenager;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public String getBonus() {
        return bonus;
    }

    public String getDlcName() {
        return dlcName;
    }

    public boolean isChild() {
        return isChild;
    }

    public boolean isTeenager() {
        return isTeenager;
    }

    public enum Category {
        DEVIATION, FORTUNE, FOOD, CREATIVITY, LOCALIZATION, LOVE, NATURE, POPULARITY, FAMILY, SPORT, KNOWLEDGE, ANIMAL, MOTORIC, SOCIAL,
        MENTAL
    }
}
