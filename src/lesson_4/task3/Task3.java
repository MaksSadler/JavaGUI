package lesson_4.task3;


import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("88005553535", "Леха");
        phonebook.put("88005553767", "Макс");
        phonebook.put("89005553765", "Ян");
        phonebook.put("86005553890", "Серый");
        phonebook.put("88005553765", "Тоха");

        System.out.println(findByMinPhoneNumber(phonebook));
        System.out.println();
        System.out.println(findByMaxAlphabetName(phonebook));
    }

    public static String findByMinPhoneNumber(Map<String, String> phonebook) {
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        long number = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("Наименьший номер: %s\n" +
                "Владелец: %s", number, phonebook.get(String.valueOf(number)));
    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook) {
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream().max(
                (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        return String.format("Наибольшее имя в алфавитном порядке: %s\n" +
                "Номер телефона: %s", name.getValue(), name.getKey());
    }
}
