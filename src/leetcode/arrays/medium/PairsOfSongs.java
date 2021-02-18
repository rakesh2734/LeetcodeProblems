package leetcode.arrays.medium;

public class PairsOfSongs {

    public int numPairsDivisibleBy60(int[] time) {

        int remainders[] = new int[60];
        int pointer = 0;

        for (int t : time) {
            if (t % 60 == 0) {
                pointer += remainders[0];
            } else {
                pointer += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return pointer;

    }

    public static void main(String[] args) {
        PairsOfSongs pairsOfSongs = new PairsOfSongs();
        int[] time = {30,20,150,100,40};
        int count = pairsOfSongs.numPairsDivisibleBy60(time);
        System.out.println("Count of pairs: " + count);
    }

}
