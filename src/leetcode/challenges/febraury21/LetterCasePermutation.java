package leetcode.challenges.febraury21;

import java.util.ArrayList;
import java.util.List;

/*Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
*/
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        int len = S.length();

        List<String> permutations = new ArrayList<>();

        int max = 1 << len;

        S = S.toLowerCase();

        for(int i =0 ; i<max; i++){
            char combination[] = S.toCharArray();
            for(int j =0; j<len; j++){
                if(((i >> j) & 1) == 1)
                    combination[j] = (char) (combination[j] -32);
            }
            String val = String.valueOf(combination);
            permutations.add(val);
        }

        return permutations;

    }

    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        String S = "acdc";
        List<String> output = obj.letterCasePermutation(S);
        System.out.println("output array" + output);

    }
}
