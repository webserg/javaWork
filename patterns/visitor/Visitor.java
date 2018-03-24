package patterns.visitor;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 18, 2010
 * Time: 4:29:13 PM
 */
public interface Visitor {
    void visit(ItemA item);

    void visit(ItemB item);
}
