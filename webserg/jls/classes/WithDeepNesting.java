package webserg.jls.classes;

/**
 * User: webserg
 * Date: 19.12.12
 */
public class WithDeepNesting {
    boolean toBe;
    WithDeepNesting(boolean b) { toBe = b; }
    class Nested {
        boolean theQuestion;
        class DeeplyNested {
            DeeplyNested(){
                theQuestion = toBe || !toBe;
            }
        }
    }

    public static void main(String[] args) {
        WithDeepNesting wn = new WithDeepNesting(true);
        Nested.DeeplyNested nn = new WithDeepNesting(true).new Nested().new DeeplyNested();
    }
}
