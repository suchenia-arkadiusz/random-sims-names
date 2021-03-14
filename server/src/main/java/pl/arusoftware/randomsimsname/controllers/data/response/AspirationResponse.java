package pl.arusoftware.randomsimsname.controllers.data.response;

public class AspirationResponse {
    String name;
    String description;
    String bonus;
    String category;
    String dlcName;
    boolean isChild;
    boolean isTeenager;

    public AspirationResponse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDlcName() {
        return dlcName;
    }

    public void setDlcName(String dlcName) {
        this.dlcName = dlcName;
    }

    public boolean getIsChild() {
        return isChild;
    }

    public void setIsChild(boolean child) {
        isChild = child;
    }

    public boolean getIsTeenager() {
        return isTeenager;
    }

    public void setIsTeenager(boolean teenager) {
        isTeenager = teenager;
    }
}
