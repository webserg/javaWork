package patterns.visitor;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 18, 2010
 * Time: 4:27:57 PM
 */
public interface Item {
    void accept(Visitor v);
}
