package leetcode.string;

public class Palindrome {
    // Using Naive approach
    private static boolean isPalindrome(String pal) {
        int i =0;
        int j = pal.length() -1;

        while(i < j) {
            if(pal.charAt(i) != pal.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // using recursion
    private static boolean isPalindro(int i, int j, String pal) {

        if(i >=j ){
            return true;
        }

        if(pal.charAt(i) != pal.charAt(j))
            return false;

        return isPalindro(i+1, j-1, pal);
    }

    private static boolean isPalindromeRecursive(String pal) {
        return isPalindro(0, pal.length()-1, pal);
    }


    public static void main(String[] args) {
        // Give string is a palindrome
        String pal = new String("abba");

       boolean isPal = isPalindrome(pal);

       System.out.println("Is the given character a palindrome -"+ isPal);
    }
}
