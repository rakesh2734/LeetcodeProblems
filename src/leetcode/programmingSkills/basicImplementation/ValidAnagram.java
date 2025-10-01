package leetcode.programmingSkills.basicImplementation;

/* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
* typically using all the original letters exactly once.
* */
public class ValidAnagram {

    private static boolean isAnagram(String s, String t) {

        String s1 = s
                .chars()
                .sorted()
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String t1= t.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        return s1.equals(t1);
    }


    public static void main(String[] args) {

    }
}
