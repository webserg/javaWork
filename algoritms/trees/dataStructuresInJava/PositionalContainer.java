package algoritms.trees.dataStructuresInJava;

public interface PositionalContainer extends InspectablePositionalContainer {
    void swapElements(Position v, Position w);

    public Object replaceElement(Position v, Object e);
}
