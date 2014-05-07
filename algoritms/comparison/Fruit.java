package algoritms.comparison;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 4:48:45 PM
 */
public class Fruit implements Comparable<Fruit>{
    protected String name;
    protected Double size;

    public Fruit(String name, Double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Fruit o) {
        return size > o.size ? 1 : size < o.size ? -1 : 0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        if (name != null ? !name.equals(fruit.name) : fruit.name != null) return false;
        if (size != null ? !size.equals(fruit.size) : fruit.size != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Fruit");
        sb.append("{name='").append(name).append('\'');
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
