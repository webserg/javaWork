package thread.caches;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/14/11 2:58 PM
 */
public class KeyObject {

    private String key;


    public KeyObject(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyObject keyObject = (KeyObject) o;

        if (key != null ? !key.equals(keyObject.key) : keyObject.key != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "KeyObject{" +
                "key='" + key + '\'' +
                '}';
    }
}
