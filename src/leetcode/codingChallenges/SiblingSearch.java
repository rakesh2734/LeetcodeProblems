package leetcode.codingChallenges;

import java.io.IOException;
import java.util.stream.IntStream;

public class SiblingSearch {
    public static void main(String[] args) throws IOException {

        int[] inputArray = new int[] {1, 2, 3, 4, 5, 6,7};
        int siblingsToFindOf = 6;
        int[] results = findSiblings(inputArray.length, inputArray, siblingsToFindOf);//lenth as array len

        int[] results1 = getSiblings(inputArray,siblingsToFindOf);

        for(int i=0;i<results.length;i++){ //be aware of output arrays item by item. println cant print arrays as well
            System.out.print(String.valueOf(results[i]) + ",");
        }

    }

    public static int[] getSiblings(int[] arr, int x) {
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x) pos = i+1;
        }
        int start = Integer.highestOneBit(pos); // get max power of 2
        int end = start*2-1 >= arr.length ? arr.length: start*2-1;
        return IntStream.range(start-1, end).map(i -> arr[i]).filter(v -> v!=x).toArray();
    }

    public static int[] findSiblings(int input1, int[] input2, int input3) {
        int[] result = new int[] {-1};
        if (input2[0] == input3) {
            return result;
        }

        int siblingFindIndex = -1;
        for(int i=0;i<input2.length;i++){
            if(input2[i]==input3) { //If element at i position is search element
                siblingFindIndex = i;
//                result = new int[]{input2[i-1], input2[i+1]};
                break; // end loop
            }
        }
        if(siblingFindIndex>-1){ //index was found in integer array
            result = new int[]{input2[siblingFindIndex-1],input2[siblingFindIndex+1]}; // add found index+1 as upper sibling and found Index -1 as lower sibling
            //to do -> check if both elements exists so there can be no array out of bounds
        }

        return result;

    }
}
