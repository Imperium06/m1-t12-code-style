import java.util.Scanner;

public class DepositCalculate {
    int places = 2;
    double yearRate = 0.06;

    double investComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return setRandom(pay, places);
    }
    
    double investSimplePercent(double amount, double yearRate, int depositPeriod) {
        return setRandom(amount + amount * yearRate * depositPeriod, places);
    }

    double setRandom(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void investMoney() {
        Scanner scanner = new Scanner(System.in);
        double out = 0;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        if (action == 1) {
            out = investSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            out = investComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + "г. увеличится до " + out);
    }

    public static void main(String[] args) {
        new DepositCalculate().investMoney();
    }
}
