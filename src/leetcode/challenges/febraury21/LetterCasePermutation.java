package leetcode.challenges.febraury21;

import java.util.ArrayList;
import java.util.List;

/*Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
*/
public class LetterCasePermutation {

    // Byte code approach but only valid for characters
    public List<String> letterCasePermutation(String S) {
        int len = S.length();

        List<String> permutations = new ArrayList<>();

        int max = 1 << len;

        S = S.toLowerCase();

        for(int i =0 ; i<max; i++){
            char combination[] = S.toCharArray();
            for(int j =0; j<len; j++){
                if(Character.isDigit(combination[j])) continue;
                if(((i >> j) & 1) == 1)
                    combination[j] = (char) (combination[j] -32);
            }
            String val = String.valueOf(combination);
            permutations.add(val);
        }
        return permutations;
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> output = new ArrayList<String>();
        output.add(S);
        StringBuilder str = new StringBuilder(S);
        String regex = "[0-9]+";
        int j = 0;
        int len = S.length();

        for(int i = 0; i < len; i++ ){
            if(Character.isUpperCase(S.charAt(i))) {
                str.append(str.charAt(i));
            }
            else {
                char ch = Character.toUpperCase(S.charAt(i));
                str.append(ch);
            }


        }
        output.add(str.toString());
        return output;
    }

    // recursion as BFS or DFS

    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        String S = "a1b2";
        List<String> output = obj.letterCasePermutation(S);
        System.out.println("output array" + output);

    }
}
