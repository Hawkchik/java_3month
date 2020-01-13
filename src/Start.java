import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Log.txt");
        FileReader fr = new FileReader("Transactions.txt");
        Operations operations = new Operations();
        Scanner scanner2 = new Scanner(fr);
        int k = 0;
        fw.write("Загрузка из файла..." + "\n");
        while (scanner2.hasNextLine()) {
            String line1 = scanner2.nextLine();
            String[] params = line1.split(" ");
            int price = Integer.parseInt(params[0]);
            int count = Integer.parseInt(params[1]);
            Transactions transactions1 = new Transactions(price, k++, count);
            if (params[2].equals("buy")) {
                operations.buy(transactions1);
                fw.write("Создана транзакция с параметрами: " + "Цена: " + price + "Количество акций " + count + "\n");
                int a = operations.removeBuy();
                fw.write("Количество потраченных денег " + a);
            } else if (params[2].equals("sell")) {
                operations.sell(transactions1);
                fw.write("Создана транзакция с параметрами: " + "Цена: " + price + "Количество акций " + count + "\n");
                int b = operations.removeSell();
                fw.write("Количество потраченных денег " + b + "\n");

            }
        }
        fr.close();
        operations.paintGlassBuy((LinkedList) operations.queuebuy);
        operations.paintGlassSell((LinkedList) operations.queuesell);

        Investor Erik = new Investor("Erik", 500000);
        Investor Ivan = new Investor("Ivan", 1000000);
        Investor Dmitriy = new Investor("Dmitriy", 250000);
        Investor Anton = new Investor("Anton", 125000);
        Investor Danila = new Investor("Danila", 225000);
        System.out.println("Выберите Инвестора(наберите число)" + "\n" + "1. Erik" + "\n" + "2. Ivan" + "\n" + "3. Dmitriy" + "\n" + "4. Anton" + "\n" + "5. Danila");
        Scanner scanner = new Scanner(System.in);
        String investorenter = scanner.nextLine();
        int investor = 0;
        Integer capital = 0;

        if (operations.number(investorenter)) {
            investor = Integer.parseInt(investorenter);
        } else {
            System.out.println("Неправильный инвестор");
            fw.write("Неправильный инвестор" + "\n");
        }
        if (investor == 1) {
            capital = Erik.getAmount();
            fw.write("Выбран Эрик" + "\n");
        } else if (investor == 2) {
            capital = Ivan.getAmount();
            fw.write("Выбран Иван" + "\n");
        } else if (investor == 3) {
            capital = Dmitriy.getAmount();
            fw.write("Выбран Дмитрий" + "\n");
        } else if (investor == 4) {
            capital = Anton.getAmount();
            fw.write("Выбран Антон" + "\n");
        } else if (investor == 5) {
            capital = Danila.getAmount();
            fw.write("Выбран Данила" + "\n");
        } else {
            System.out.println("Неправильный инвестор");
            fw.write("Неправильный инвестор" + "\n");
        }

        Integer amount = 0;
        Integer moneyCash = 0;
        Integer i = 0; // счетчик очереди

        while (capital > (amount)) {
            System.out.println("Введите цену акции" + " или завершить программу(Введите End)");
            String priceenter = scanner.nextLine();
            if (priceenter.toUpperCase().equals("END")){
                break;
            }
            fw.write("Введена цена: " + priceenter + "\n");
            int price = 0;
            if (operations.number(priceenter)) {
                price = Integer.parseInt(priceenter);
            } else {
                System.out.println("Неправильная цена");
                fw.write("Неправильная цена" + "\n");
                break;
            }
            System.out.println("Введите количество акций");
            String countenter = scanner.nextLine();
            fw.write("Введено кол-во акций: " + countenter + "\n");
            int count = 0;
            if (operations.number(countenter)) {
                count = Integer.parseInt(countenter);
            } else {
                System.out.println("Неправильная цена");
                fw.write("Неправильная цена" + "\n");
                break;
            }
            System.out.println("1 - Купить" + "\n" + "2 - Продать");
            String typeenter = scanner.nextLine();
            int type = 0;
            fw.write("Выбран тип " + typeenter + "\n");
            if (operations.number(typeenter)) {
                type = Integer.parseInt(typeenter);
            } else {
                System.out.println("Неправильная цена");
                fw.write("Неправильная цена" + "\n");
                break;
            }
            Transactions transactions = new Transactions(price, i++, count);
            if (type == 1) {
                operations.buy(transactions);
                int a = operations.removeBuy();
                fw.write("Количество потраченных денег " + a);
            } else if (type == 2) {
                operations.sell(transactions);
                int b = operations.removeSell();
                fw.write("Количество потраченных денег " + b);
            } else {
                System.out.println("Неправильный выбор");
                fw.write("Неправильный выбор");
            }
            amount += price * count;
            moneyCash = capital - amount;

            operations.paintGlassBuy((LinkedList) operations.queuebuy);
            operations.paintGlassSell((LinkedList) operations.queuesell);
            System.out.println("Остаток денег= " + moneyCash);
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

        fw.close();

        operations.paintGlassBuy((LinkedList) operations.queuebuy);
        operations.paintGlassSell((LinkedList) operations.queuesell);


        System.out.println("Количество потраченных денег: " + operations.removeBuy());


    }

}
