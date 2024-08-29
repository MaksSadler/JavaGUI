package lesson_6;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        DescriptiveStatistics stat = new DescriptiveStatistics(array);
        System.out.println("Минимальное значение массива: " + stat.getMin());
        System.out.println("Максимальное значение массива: " + stat.getMax());
        System.out.println("Сумма значений елементов массива: " + stat.getSum());
        System.out.println("Среднее арифметическое значение елементов массива: " + stat.getMean());
        System.out.println();

        System.out.println("Факториал числа 5: " + ArithmeticUtils.factorial(5));
        System.out.println("Наменьшее общее частное чисел 15 и 25: " + ArithmeticUtils.lcm(15,25));
        System.out.println("Наибольший общий делитель чисел 10 и 30: " + ArithmeticUtils.gcd(10,30));
        System.out.println("Является ли число 16 степенью 2: " + ArithmeticUtils.isPowerOfTwo(16));
    }
}
