package algoritms.trees.dataStructuresInJava;

public interface InspectableTree extends InspectablePositionalContainer{
    Position root();
    Position parent(Position v);
    PositionIterator children(Position v);
    boolean isInternal();
    boolean isExternal();
    boolean isRoot();
}
