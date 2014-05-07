package webserg.scjp;


class MyException extends Exception {
}

class MyException2 extends MyException {
}

class Master {
    String doFileStuff() throws MyException2 {
        return "a";
    }
}

public class Slave extends Master {
    public static void main(String[] argv) {
        String s = null;
        try {
            s = new Slave().doFileStuff();
        } catch (Exception e) {
            s = "b";
        }
        System.out.println(s);
    }

    String doFileStuff() throws MyException2 {
        return "b";
    }

}
