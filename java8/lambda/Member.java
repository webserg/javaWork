package java8.lambda;

import java.util.Calendar;
import java.util.Date;

public class Member {

    public Member(String name, Calendar birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Calendar birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 1;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public static int compareByAge(Member a, Member b) {
        return a.birthday.compareTo(b.birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printMember(){
        toString();
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

