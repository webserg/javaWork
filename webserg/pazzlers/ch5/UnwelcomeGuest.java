package webserg.pazzlers.ch5;

public class UnwelcomeGuest {
    private static final long GUEST_USER_ID = -1;
    private static final long USER_ID = getUserIdOrGuest();

    private static final long getUserIdOrGuest() {
        try {
            return getUserIdFromEnviroment();
        } catch (IdUnavailableException e) {
            return GUEST_USER_ID;
        }
    }

    ;
	/*static{
		try {
			USER_ID = getUserIdFromEnviroment();
		} catch (IdUnavailableException e) {
			USER_ID = GUEST_USER_ID;
			System.out.println("Logging in as guest");
		}
	}*/

    /**
     * @param args
     */
    public static void main(String[] args) {
    }

    private static long getUserIdFromEnviroment() throws IdUnavailableException {
        throw new IdUnavailableException();
    }

}

class IdUnavailableException extends Exception {
    IdUnavailableException() {
    }
}
