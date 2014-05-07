package java8.lambda;

import java.time.LocalDate;

/**
 * User: webserg
 * Date: 20.12.12
 */
public class  Student {
    public String name;
    public Integer score;
    public int gradYear;
    public enum Sex {
        MALE, FEMALE
    }

    LocalDate birthday;
    Sex gender;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, int gradYear) {
        this.name = name;
        this.score = score;
        this.gradYear = gradYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", gradYear=" + gradYear +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
}
