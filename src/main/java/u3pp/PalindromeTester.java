package u3pp;

public class PalindromeTester {

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reverse += s.charAt(i);
        }
        s = s.toLowerCase();
        reverse = reverse.toLowerCase();
        if(s.equals(reverse)){
        return true;
     } else{
        return false;
     }

    }
}
