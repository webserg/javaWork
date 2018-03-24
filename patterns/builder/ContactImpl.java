package patterns.builder;

public class ContactImpl implements Contact {
    private String firstName;

    private String lastName;

    private String title;

    private String organization;

    public ContactImpl(String newFirstName, String newLastName,
                       String newTitle, String newOrganization) {
        firstName = newFirstName;
        lastName = newLastName;
        title = newTitle;
        organization = newOrganization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String newOrganization) {
        organization = newOrganization;
    }

    public String toString() {
        return firstName + SPACE + lastName;
    }
}
