
/**
 *
 * @author Faris-Abuali
 */
public class IntrviewFreightos {

    public static void printS(String str, int n) {

        StringBuilder sBuilder = new StringBuilder();
        int counter = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            j = 0;
            counter = 0;
            sBuilder = new StringBuilder("");

            while (j < str.length()) {
                counter++; // increase the occurences of the currentChar
                char currentChar = str.charAt(j);
                if (j < str.length() - 1) {
                    char nextChar = str.charAt(j + 1);

                    if (nextChar != currentChar) {
                        // then the chain of matching adjacent equivalent char is broken:
                        sBuilder.append(counter).append(currentChar);
                        counter = 0; // reset the counter
                    }
                } 
                else {
                    // then the currentChar is the last char in the string, no nextChar to be compared with.
                    sBuilder.append(counter).append(currentChar);
                    counter = 0; // reset the counter
                }
                j++;
            } // end while

            System.out.println(sBuilder); // print the resulting string for this iteration
            str = sBuilder.toString(); // the new string
        } // end for loop

    } // end function

    public static void main(String[] args) {

        printS("1", 4);

        /*
            IN: printS("1", 4)
            OUT:
                11
                21
                1211
                111221
            

            IN: printS("1", 5)
            OUT:
                11
                21
                1211
                111221
                312211
         */
    }

} // end class
