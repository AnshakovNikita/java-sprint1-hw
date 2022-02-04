import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    int goal = 10000;
    Converter converter = new Converter(75, 50, 1000);

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    void addSteps(int month, int day, int steps) {
            MonthData data = monthToData.get(month - 1);
                data.saveSteps(day, steps);
    }

    void printStatSteps(int month) {
            MonthData data = monthToData.get(month - 1);
            int stepsSum = 0;
            int stepsMax = 0;
            int averSteps = 0;
            int seria = 0;
            int miniSeria = 0;
            String result = "";

            for (int i = 0; i < data.days.length; i++) {

                stepsSum += data.days[i];

                result += (i +1) + " день: " + data.days[i];
                    if (i != data.days.length -1){
                    result +=", ";
                }

                if (data.days[i] > stepsMax) {
                    stepsMax = data.days[i];
                }

                averSteps = stepsSum / data.days.length;

                if (data.days[i] >= goal) {
                    miniSeria++;
                } else {
                    if (miniSeria > seria) {
                        seria = miniSeria;
                    }
                    miniSeria = 0;
                }
            }
        System.out.println("Количество пройденных шагов по дням:");
        System.out.println(result);
        System.out.println("В этом месяце вы прошли: " + stepsSum + " шагов.");
        System.out.println("Максимальное пройденное количество шагов в месяце: " + stepsMax + " шагов.");
        System.out.println("Среднее количество шагов в день: " + averSteps + ".");
        converter.convert(stepsSum);
        System.out.println("Лучшая серия: " + seria + " дней подряд выполнили цель дня!");
    }

    void changeGoal(int change) {
        if (change > 0) {
            goal = change;
            System.out.println("Цель дня изменилась на " + goal + " шагов.");
        } else {
            System.out.println("Число должно быть положительным.");
        }
    }
}
        class MonthData {

            int days[] = new int[30];

            void saveSteps(int day, int steps) {
                days[day - 1] = steps;
            }
    }
