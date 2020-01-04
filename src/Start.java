import java.math.BigDecimal;
import java.util.Formatter;

public class Start {
    public static void main(String[] args) {
        Investor Erik = new Investor("Erik", 5000000);
        Investor Ivan = new Investor("Ivan", 1000000);
        Investor Dmitriy = new Investor("Dmitriy", 250000);
        Investor Anton = new Investor("Anton", 125000);
        Investor Danila = new Investor("Danila", 225000);

       // System.out.println("Выберите имя");

        Operations operations = new Operations();


        Transactions transactions = new Transactions(12,0,1);
        Transactions transactions2 = new Transactions(30,1,3);
        Transactions transactions3 = new Transactions(40,2,4);
        Transactions transactions4 = new Transactions(50,3,3);
        Transactions transactions5 = new Transactions(60,4,5);

        operations.sell(transactions);
        operations.removeSell();
        operations.sell(transactions2);
        operations.removeSell();
        operations.sell(transactions3);
        operations.removeSell();
        System.out.println("Покупка "+operations.queuebuy);
        System.out.println("Продажа "+ operations.queuesell);

        operations.sell(transactions4);
        operations.removeSell();
        operations.buy(transactions5);
        System.out.println("Покупка "+operations.queuebuy);
        System.out.println("Продажа "+ operations.queuesell);
        operations.removeBuy();
        //operations.sell(transactions4);
        //operations.removeSell(transactions5);


        System.out.println("Покупка "+operations.queuebuy);
        System.out.println("Продажа "+ operations.queuesell);

        //operations.sell(transactions3);
       // operations.buy(transactions2);
        //operations.buy(transactions);

       // operations.checkerbuy(transactions2.price,transactions2.type);
       // System.out.println("Покупка "+operations.queuebuy);
       // System.out.println("Продажа "+ operations.queuesell);

    }
}
