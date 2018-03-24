package webserg.pazzlers.ch8.hack;

import webserg.pazzlers.ch8.click.CodeTalk;

public class TypeIt {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ClickIt clickIt = new ClickIt();
        clickIt.doIt();
    }

    private static class ClickIt extends CodeTalk {
        protected void printMessage() {
            System.out.println("Hack");
        }
    }

}
