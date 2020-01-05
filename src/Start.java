import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Integer i = 0; // счетчик очереди
        while (capital > (amount)) {
            System.out.println("Введите цену акции");
            String priceenter = scanner.nextLine();
            int price = 0;
            if (operations.number(priceenter)) {
                price = Integer.parseInt(priceenter);
            } else {
                System.out.println("Неправильная цена");
                break;
            }
            System.out.println("Введите количество акций");
            String countenter = scanner.nextLine();
            int count = 0;
            if (operations.number(countenter)) {
                count = Integer.parseInt(countenter);
            } else {
                System.out.println("Неправильная цена");
                break;
            }
            System.out.println("1 - Купить" + "\n" + "2 - Продать");
            String typeenter = scanner.nextLine();
            int type = 0;
            if (operations.number(typeenter)) {
                type = Integer.parseInt(typeenter);
            } else {
                System.out.println("Неправильная цена");
                break;
            }
            Transactions transactions = new Transactions(price, i++, count);
            if (type == 1) {
                operations.buy(transactions);
                operations.removeBuy();
            } else if (type == 2) {
                operations.sell(transactions);
                operations.removeSell();
            } else {
                System.out.println("Неправильный выбор");
            }

            moneyCash = capital - amount;
            amount += price * count;
            System.out.println("Покупка " + operations.queuebuy);
            System.out.println("Продажа " + operations.queuesell);
            if (amount > capital) {
                System.out.println("Слишком большая сумма");
                System.out.println(moneyCash);
                amount -= price * count;
            }
            if (capital == amount) {
                System.out.println("Увы закончились деньги...");
                break;
            }
        }

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


    }

}
