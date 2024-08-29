package lesson_4.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Светлана", "Ирина"));
        Set<String> setNames = convertListToSet(names);
        System.out.println(setNames);
        System.out.println("Меньшее по алфавиту имя: " + minLengthName(setNames));
        System.out.println();
        List<String> minAndMaxNames = minAndMaxLengthName(setNames);
        System.out.printf("Наименьшее по длине имя: %s\n" +
                "Наибольшее по длине имя: %s", minAndMaxNames.get(0), minAndMaxNames.get(1));
        System.out.println();
        removeNamesByChar(setNames, 'А');
        System.out.println("Коллекция после удаления: " + setNames);

    }

    public static Set<String> convertListToSet(List<String> list) {
        return new HashSet<>(list);
    }

    public static String minLengthName(Set<String> names) {
        return names.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public static List<String> minAndMaxLengthName(Set<String> names) {
        List<String> resultNames = new ArrayList<>();
        resultNames.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        resultNames.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return resultNames;
    }

    public static void removeNamesByChar(Set<String> names, char symbol) {
        names.removeIf(name -> name.toLowerCase().contains(String.valueOf(symbol).toLowerCase()));
    }
}
