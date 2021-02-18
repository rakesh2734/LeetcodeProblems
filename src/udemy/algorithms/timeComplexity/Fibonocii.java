package udemy.algorithms.timeComplexity;

public class Fibonocii {

    public static int fibonoci(int n){
        if(n < 1) {
            return -2;
        }
        if(n == 1 || n== 2) {
            return n -1;
        } else {
            return fibonoci(n - 1) + fibonoci(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonoci(3));
    }
}
