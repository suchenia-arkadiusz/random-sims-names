package pl.arusoftware.randomsimsname.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLES")
public class Name {
    @Id
    private String id;

    private Gender gender;

    private Boolean isUsed;

    public static Name createEmptyName() {
        return new Name("Empty name", Gender.MALE, false);
    }

    public Name() {}

    public Name(String id, Gender gender, Boolean isUsed) {
        this.id = id;
        this.gender = gender;
        this.isUsed = isUsed;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
