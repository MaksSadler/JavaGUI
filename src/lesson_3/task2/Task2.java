package lesson_3.task2;

import java.util.Arrays;

public class Task2<T> {
    private Object[] array;
    private int size;

    public Task2(int length) {
        this.array = new Object[length];
    }

    public void add(T element) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = element;
    }

    public void delete(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
    }
}
