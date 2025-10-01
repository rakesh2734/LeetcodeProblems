package leetcode;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

    private static String[] data;
//{"rejith#kumar#java#cpp”, “krishna#rao#react#java”, “sam#john#python” };

    Test() {
        String[] testData = new String[]{"rejith#kumar#java#cpp", "krishna#rao#react#java", "sam#java#python"};
        this.data = testData;
    }

    // Person firstName, LastName, list<Skills>
    public static void main(String[] args) {
        Test user = new Test();
        user.getPerson("java");

    }

    public void getPerson(String skill) {

        Arrays.stream(data).map(d -> {
            return Arrays.asList(d.split("#"));
         })
                .filter(list -> list.size() >3 && list.subList(2, list.size()).contains(skill))
                .forEach(System.out::println);
    }

   /* public class Person {
        private String firstName;
        private String lastName;
        private List<String> skills;
    }*/

}
