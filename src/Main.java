import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();



        while (true) {

            printMenu();
            int paragraph = scanner.nextInt();

            if (paragraph == 1) {
                System.out.println("Введите месяц:");
                int month;
                    while (true) {
                        month = scanner.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.println("Введите месяц от 1 до 12!");
                        } else {
                            break;
                        }
                    }
                System.out.println("Введите день от 1 до 30:");
                int day;
                    while (true){
                        day = scanner.nextInt();
                        if (day < 1 || day > 30) {
                            System.out.println("Неверный формат! Введите день от 1 до 30:");
                        } else {
                            break;
                        }
                    }
                System.out.println("Введите количество пройденных шагов:");
                int steps;
                    while (true){
                        steps = scanner.nextInt();
                        if (steps < 0) {
                            System.out.println("Количество шагов не может быть отрицательным! Введите количество шагов:");
                        } else {
                            break;
                        }
                    }
                stepTracker.addSteps(month, day, steps);
            } else if (paragraph == 2) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                stepTracker.printStatSteps(month);
            } else if (paragraph == 3) {
                System.out.println("Введите новую цель по количеству шагов в день:");
                int change = scanner.nextInt();
                stepTracker.changeGoal(change);
            } else if (paragraph == 4) {
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
        public static void printMenu() {
            System.out.println("1.Ввести количество шагов за определённый день.");
            System.out.println("2.Напечатать статистику за определённый месяц.");
            System.out.println("3.Изменить цель по количеству шагов в день.");
            System.out.println("4.Выйти из приложения.");
        }
}

