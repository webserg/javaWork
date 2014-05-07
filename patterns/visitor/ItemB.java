package patterns.visitor;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 18, 2010
 * Time: 4:28:19 PM
 */
public class ItemB implements Item{
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ItemB");
        sb.append("{result='").append(result).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
