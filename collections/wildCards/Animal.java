package collections.wildCards;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:43:37 PM
 */
class Animal extends LiveBeen {
    String name = "Animal";

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Animal");
        sb.append("{name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
