package algoritms;

public class RevertString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "0123456789";
        StringBuffer sb = new StringBuffer();
        for(int i=s.length() - 1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }

}
