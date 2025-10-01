package leetcode.programmingSkills.basicImplementation;

public class RepeatedSubString {

    public static boolean repeatedSubstringPattern(String s) {

        // String Searching/Matching algorithm
        // Using Divisors
        int len = s.length();

        for(int i =1; i <= len/2; i++) {
            if(len%i == 0) {
                StringBuilder pattern = new StringBuilder();
                int num_repeats = len/i;
                for(int j=0; j< num_repeats; j ++) {
                    pattern.append(s.substring(0,i));
                }
                if(s.equals(pattern.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String sub = "abababab";

        System.out.println("Is it a substringPattern: "+ repeatedSubstringPattern(sub));
    }
}
