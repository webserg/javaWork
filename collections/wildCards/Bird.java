package collections.wildCards;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:43:37 PM
 */
class Bird extends LiveBeen {
    String name = "Bird";

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Bird");
        sb.append("{name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
