import java.util.Scanner;

public class DepositCalculate {
    double getCalculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        int places = 2;

        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return setRandom(pay, places);
    }
    double getCalculateSimplePercent(double amount, double yearRate,
                                             int depositPeriod) {
        return setRandom(amount+amount * yearRate * depositPeriod, 2);
    }
    double setRandom(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void investMoney() {
        int period;
        int action;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;

        if (action == 1) {
            out = getCalculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            out = getCalculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + "г. увеличится до " + out);
    }

    public static void main(String[] args) {
        new DepositCalculate().investMoney();
    }
}
