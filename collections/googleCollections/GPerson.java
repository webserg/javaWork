package collections.googleCollections;

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 1:02:00 PM
 */
public class GPerson {
    String fname;
    String lname;

    public GPerson(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
