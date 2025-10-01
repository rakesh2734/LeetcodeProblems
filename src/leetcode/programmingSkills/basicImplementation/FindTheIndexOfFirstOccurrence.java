package leetcode.programmingSkills.basicImplementation;

/* Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
* Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
*/
public class FindTheIndexOfFirstOccurrence {

    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        // String Matching
        // Using sliding window technique
        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart+i))
                    break;

                if(i == m-1)
                    return windowStart;
            }
        }

        return -1;
    }

}
