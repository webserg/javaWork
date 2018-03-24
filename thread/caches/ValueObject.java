package thread.caches;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/14/11 2:56 PM
 */
public class ValueObject {
    private KeyObject key;
    private String data;

    public ValueObject(KeyObject key, String data) {
        this.key = key;
        this.data = data;
    }

    public KeyObject getKey() {
        return key;
    }

    public void setKey(KeyObject key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueObject that = (ValueObject) o;

        if (!data.equals(that.data)) return false;
        if (!key.equals(that.key)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }
}
