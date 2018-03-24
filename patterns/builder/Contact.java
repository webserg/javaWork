package patterns.builder;

import java.io.Serializable;

public interface Contact extends Serializable {
    public static final String SPACE = " ";

    public String getFirstName();

    public void setFirstName(String newFirstName);

    public String getLastName();

    public void setLastName(String newLastName);

    public String getTitle();

    public void setTitle(String newTitle);

    public String getOrganization();

    public void setOrganization(String newOrganization);
}