import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Investor Erik = new Investor("Erik", 500000);
        Investor Ivan = new Investor("Ivan", 1000000);
        Investor Dmitriy = new Investor("Dmitriy", 250000);
        Investor Anton = new Investor("Anton", 125000);
        Investor Danila = new Investor("Danila", 225000);
        // System.out.println("Выберите имя");
        Integer capital = Erik.getAmount();
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        Integer amount = 0;
        Integer moneyCash = 0;
        while (capital > (amount)) {
            System.out.println("Введите цену");
            int Price = scanner.nextInt();
            System.out.println("Введите количество акций");
            int Count = scanner.nextInt();
            moneyCash = capital - amount;
            amount += Price * Count;

            if (amount > capital) {
                System.out.println("Слишком большая сумма");
                System.out.println(moneyCash);
                amount -= Price * Count;
            }
            if (capital == amount) {
                break;
            }
        }
        System.out.println("Увы закончились деньги...");
/*

        Transactions transactions = new Transactions(12, 0, 1);
        Transactions transactions2 = new Transactions(30, 1, 3);
        Transactions transactions3 = new Transactions(40, 2, 4);
        Transactions transactions4 = new Transactions(50, 3, 3);
        Transactions transactions5 = new Transactions(60, 4, 3);
*/


        System.out.println("Покупка " + operations.queuebuy);
        System.out.println("Продажа " + operations.queuesell);


        System.out.println("Количество потраченных денег: " + operations.removeBuy());
        //operations.sell(transactions4);
        //operations.removeSell(transactions5);


        System.out.println("Покупка " + operations.queuebuy);
        System.out.println("Продажа " + operations.queuesell);


        // System.out.println("Покупка "+operations.queuebuy);
        // System.out.println("Продажа "+ operations.queuesell);

    }
}
