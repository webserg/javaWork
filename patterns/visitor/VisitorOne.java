package patterns.visitor;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 18, 2010
 * Time: 4:29:59 PM
 */
public class VisitorOne implements Visitor{
    @Override
    public void visit(ItemA item) {
        item.setResult("visited by visitor one method 1");
    }

    @Override
    public void visit(ItemB item) {
        item.setResult("visited by visitor one method 2");

    }
}
