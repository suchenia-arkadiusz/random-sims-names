package pl.arusoftware.randomsimsname.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLES")
public class Name {
    @Id
    private String name;

    private Gender gender;

    private Boolean isUsed;

    public Name() {}

    public Name(String name, Gender gender, Boolean isUsed) {
        this.name = name;
        this.gender = gender;
        this.isUsed = isUsed;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
