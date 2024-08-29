package lesson_4.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Светлана", "Ирина"));
        System.out.println(names);
        sortedByAlphabet(names);
        System.out.println(names);
        sortedByLength(names);
        System.out.println(names);
        reverseList(names);
        System.out.println(names);
    }

    public static void sortedByAlphabet(List<String> list) {
        Collections.sort(list);
    }

    public static void sortedByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
    }

    public static void reverseList(List<String> list) {
        Collections.reverse(list);
    }
}
