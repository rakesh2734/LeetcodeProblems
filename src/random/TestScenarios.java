package random;

public class TestScenarios {

    public static void main(String[] args) {

        String cellKey = "New York:4:00 PM 2SPU9";

        String testString = cellKey.substring(cellKey.indexOf("M") + 2);

        System.out.println("is substring worked=>" + testString);

    }
}
