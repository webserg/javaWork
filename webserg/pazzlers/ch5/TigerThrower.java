package webserg.pazzlers.ch5;

class TigerThrower<T extends Throwable> {

    public static void sneakyThrow(Throwable t) {
        new TigerThrower<Error>().sneakyThrow2(t);
    }

    private void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }

}

