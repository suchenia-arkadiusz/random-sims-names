package pl.arusoftware.randomsimsname.controllers.data.response;

public class NameResponse {
    private String name;
    private String gender;
    private boolean isUsed;

    public NameResponse() {}

    public NameResponse(String name, String gender, boolean isUsed) {
        this.name = name;
        this.gender = gender;
        this.isUsed = isUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
