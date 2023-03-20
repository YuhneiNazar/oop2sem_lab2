import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        fun1();
        System.out.println("Виконання першого завдання:");
        zav1();
        System.out.println("Виконання другого завдання:");
        zav2();
        System.out.println("Виконання третього завдання:");
        zav3();
    }

    public static void fun1() {
        int rows = 3, cols = 5;
        int[][] a = new int[rows][cols];
        a = fillArray(rows, cols);
        System.out.println("\nArray1: ");
        printArray(a);
        Sortarray(a);
        System.out.println("\nArray1 sort: ");
        printArray(a);
        System.out.println(" ");
    }

    static int[][] fillArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        // змінна класу Random для генерування значень
        Random rand = new Random(1);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                array[i][j] = rand.nextInt(100);
            }
        }
        return array;
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                System.out.print(" " + array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void Sortarray(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int temp = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < m - i - 1; j++) {
                    if (arr[k][j] > arr[k][j + 1]) {
                        temp = arr[k][j];
                        arr[k][j] = arr[k][j + 1];
                        arr[k][j + 1] = temp;
                    }
                }
            }
        }
    }

    static int[] zav1() {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[21];
        int min = 15;
        int max = 85;
        int menu = 1;
        int range = max - min + 1;

        // Random для генерування значень
        Random rand = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = rand.nextInt(range) + min;
        }

        // цикл перевірки на парність
        System.out.println("Критерій: Парні або індекси кратним 13(1 або 2)");
        menu = sc.nextInt();
        if (menu == 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    System.out.print(" " + array[i] + "\t");
                }
            }

        }  else{
//         Перевірка кратності індекса на 13
                for (int i = 0; i < array.length; ++i) {
                    if ((i % 13 == 0) && (i != 0)) {
                        System.out.print(" " + array[i] + "\t");
                    }
                }

            }
        System.out.println();
        System.out.println();
            return array;

        }
    static int[][] zav2() {
        int[][] array = new int[6][8];
        int min = -26;
        int max = 23;
        int range = max - min + 1;
        // Random для генерування значень
        Random rand = new Random();
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                do {
                    array[i][j] = rand.nextInt(range) + min;
                }
            while (array[i][j] < 0 && array[i][j] % 2 != 0);
            }
        }
        Sortarray(array);
        printArray(array);
        System.out.println();
        return array;
    }

    static class Student {
        String name;
        int course;
        String specialty;
        int physicsGrade;
        int mathGrade;
        int informaticsGrade;

        public Student(String name, int course, String specialty, int physicsGrade, int mathGrade, int informaticsGrade) {
            this.name = name;
            this.course = course;
            this.specialty = specialty;
            this.physicsGrade = physicsGrade;
            this.mathGrade = mathGrade;
            this.informaticsGrade = informaticsGrade;
        }

        public boolean hasOnlyExcellentGrades() {
            return physicsGrade == 5 && mathGrade == 5 && informaticsGrade == 5;
        }
    }
    public static void zav3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість студентів: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введіть дані для студента " + (i + 1) + ":");
            System.out.print("Імя: ");
            String name = scanner.next();
            System.out.print("Курс: ");
            int course = scanner.nextInt();
            System.out.print("Спеціальність: ");
            String specialty = scanner.next();
            System.out.print("Оцінка з фізики: ");
            int physicsGrade = scanner.nextInt();
            System.out.print("Оцінка з математики: ");
            int mathGrade = scanner.nextInt();
            System.out.print("Оцінка з інформатики: ");
            int informaticsGrade = scanner.nextInt();
            students[i] = new Student(name, course, specialty, physicsGrade, mathGrade, informaticsGrade);
        }

        System.out.println("\nТаблиця студентів:");
        System.out.println("Імя\t   Курс\tСпеціальність\tФізика\tМатематика\tІнформатика");
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + "\t" + students[i].course + "\t\t" + students[i].specialty + "\t\t\t  " +
                    students[i].physicsGrade + "\t\t\t" + students[i].mathGrade + "\t\t\t" + students[i].informaticsGrade);
        }

        int countExcellent = 0;
        for (int i = 0; i < n; i++) {
            if (students[i].hasOnlyExcellentGrades()) {
                countExcellent++;
            }
        }
        System.out.println("\nКількість учнів, які мають лише відмінні оцінки: " + countExcellent);
    }
}

