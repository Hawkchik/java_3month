import java.math.BigDecimal;
import java.util.*;

public class Operations {

    Deque<Transactions> queuesell = new LinkedList<Transactions>();
    Deque<Transactions> queuebuy = new LinkedList<Transactions>();

    class ComparatorQueueSell implements Comparator<Transactions> {
        @Override
        public int compare(Transactions t1, Transactions t2) {
            if (t1.getPrice() < t2.getPrice()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    class ComparatorQueueBuy implements Comparator<Transactions> {
        @Override
        public int compare(Transactions t1, Transactions t2) {
            if (t1.getPrice() < t2.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public boolean sell(Transactions transactions) {
        if (checkerSell()) {

            removeBuy(transactions);
        }

        if (checkerSell() && transactions.price < queuesell.getFirst().price) {

            queuesell.addFirst(transactions);
        }
        queuesell.addLast(transactions);
        Collections.sort((LinkedList) queuesell, new ComparatorQueueSell());

        return true;
    }


    public boolean buy(Transactions transactions) {
        if (checkerBuy()) {

            removeSell(transactions.price);
        }

        if (checkerBuy() && transactions.price > queuebuy.getFirst().price) {
            queuebuy.addFirst(transactions);
        }
        queuebuy.addLast(transactions);
        Collections.sort((LinkedList) queuebuy, new ComparatorQueueBuy());

        return true;
    }


    public boolean checkerSell() {
        boolean a = true;
        if (queuebuy.isEmpty() || queuesell.isEmpty()) {
            a = false;
        }
        return a;
    }


    public boolean checkerBuy() {
        boolean a = true;
        if (queuesell.isEmpty() || queuebuy.isEmpty()) {
            a = false;
        }
        return a;
    }

    public void removeSell(Integer price) {
        if (queuesell.getFirst().price <= price) {
            queuesell.removeFirst();
            queuebuy.removeFirst();

        }
    }


    public void removeBuy(Transactions transactions) {
        if (queuebuy.getFirst().price >= transactions.price) {
            queuesell.removeFirst();
            queuebuy.removeFirst();
          }

    }


    @Override
    public String toString() {
        return "Operations{" +
                "queuesell=" + queuesell +
                ", queuebuy=" + queuebuy +
                '}';
    }
}
