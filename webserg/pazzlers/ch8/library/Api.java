package webserg.pazzlers.ch8.library;

public final class Api {
    private String myOwnField = "super";
    private String field = "hello";

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMyOwnField() {
        return myOwnField;
    }

    public void setMyOwnField(String myOwnField) {
        this.myOwnField = myOwnField;
    }
}
