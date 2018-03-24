package collections;


public class ZeroDemo1 {

    // filter input array and throw away values
    // that are less than minval or greater than
    // maxval

    static int[] filterData(int indata[], int minval, int maxval) {

        // check parameters for errors

        if (indata == null) {
            throw new NullPointerException("indata is null");
        }
        if (maxval < minval) {
            throw new IllegalArgumentException("maxval < minval");
        }

        // count number of valid values
        // in input array

        int validcnt = 0;
        for (int i = 0; i < indata.length; i++) {
            if (indata[i] >= minval && indata[i] <= maxval) {
                validcnt++;
            }
        }

        // if no valid values, return null
        int outdata[] = new int[validcnt];
        if (validcnt == 0) {
        } else

            // copy valid values to new array
            // and return it


            for (int i = 0, j = 0; i < indata.length; i++) {
                if (indata[i] >= minval && indata[i] <= maxval) {
                    outdata[j++] = indata[i];
                }
            }
        return outdata;
    }

    public static void main(String args[]) {

        // set up test array of integers

        int indata[] = new int[]{1, 3, -17, 8, 59};

        // filter out values not in the range 1-10

        int outdata1[] = filterData(indata, 1, 10);
        for (int i = 0; i < outdata1.length; i++) {
            System.out.println(outdata1[i]);
        }

        // filter out values not
        // in the range 100-200

        int outdata2[] = filterData(indata, 100, 200);
        for (int i = 0; i < outdata2.length; i++) {
            System.out.println(outdata2[i]);
        }
    }
}