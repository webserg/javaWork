package webserg.scjp.devel;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:39:32 PM
 */
public class Circle extends Shape {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    void draw() {
        // TODO Auto-generated method stub

    }

}

abstract class Shape {
    int x;
    int y;

    abstract void draw();

    void setA(int x, int y) {
        this.x = x;
        this.y = y;
    }
}