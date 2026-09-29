package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        arrayedit();
        secretnum();
    };

    public static void arrayedit() {
        int[] array = {1, 2, 3, 4, 5};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Текущий массив: " + Arrays.toString(array));
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить элемент");
        System.out.println("2. Удалить элемент");

        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Неверный выбор. Введите 1 или 2");
            return;
        }

        if (choice == 1) {
            System.out.print("Введите целое число для добавления: ");
            int value = scanner.nextInt();

            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = value;
        } else {
            System.out.print("Введите индекс элемента для удаления: ");
            int index = scanner.nextInt();

            if (index < 0 || index >= array.length) {
                System.out.println("Ошибка: индекс выходит за границы массива");
                return;
            }

            int[] newArray = new int[array.length - 1];

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(
                    array, index + 1,
                    newArray, index,
                    array.length - index - 1
            );

            array = newArray;
        }

            System.out.println("Новый массив: " + Arrays.toString(array));
    };
    public static void secretnum() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;

        while (attempts < 10) {
            int guess;

            while (true) {
                System.out.print("Введите число от 1 до 100: ");
                guess = scanner.nextInt();

                if (guess >= 1 && guess <= 100) {
                    break;
                }

                System.out.println(
                        "Ошибка: число должно быть в диапазоне от 1 до 100"
                );
            }

            attempts++;

            if (guess < secretNumber) {
                System.out.println("Моё число больше");
            } else if (guess > secretNumber) {
                System.out.println("Моё число меньше");
            } else {
                System.out.println("Поздравляю! Вы угадали!");
                System.out.println("Вы угадали за " + attempts + " попыток");
                return;
            }
        }

        System.out.println(
                "Вы исчерпали все попытки. Загаданное число было "
                        + secretNumber
        );
    }
    }
