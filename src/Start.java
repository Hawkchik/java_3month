import java.math.BigDecimal;

public class Start {
    public static void main(String[] args) {
        Investor Erik = new Investor("Erik", 5000000);
        Investor Ivan = new Investor("Ivan", 1000000);
        Investor Dmitriy = new Investor("Dmitriy", 250000);
        Investor Anton = new Investor("Anton", 125000);
        Investor Danila = new Investor("Danila", 225000);

       // System.out.println("Выберите имя");

        Operations operations = new Operations();


        Transactions transactions = new Transactions(10,"buy",2);
        Transactions transactions2 = new Transactions(12,"buy",2);
        Transactions transactions3 = new Transactions(11,"buy",2);
        operations.buy(transactions);
        operations.buy(transactions2);
        operations.buy(transactions3);
        operations.sell(transactions);
        operations.sell(transactions2);
        operations.sell(transactions3);
       // operations.buy(transactions2);
        //operations.buy(transactions);

       // operations.checkerbuy(transactions2.price,transactions2.type);
        System.out.println(operations.queuebuy);
        System.out.println(operations.queuesell);

    }
}
