import java.math.BigDecimal;
import java.util.*;

public class Operations {

    Deque<Transactions> queuesell = new LinkedList<>(); // очередь продажи
    Deque<Transactions> queuebuy = new LinkedList<>();  // очередь покупки

    // компаратор сравнение продажи
    class ComparatorQueueSell implements Comparator<Transactions> {
        @Override
        public int compare(Transactions t1, Transactions t2) {
            int result = 0;
            if (t1.getPrice().compareTo(t2.getPrice()) > 0) result = -1;
            else result = 0;

            if (result == 0) {

                if (t1.getQueue().compareTo(t2.getQueue()) > 0) result = 1;
                else result = 0;

            }
            return result;
        }
    }
    // компаратор сравнение покупки

    class ComparatorQueueBuy implements Comparator<Transactions> {
        @Override
        public int compare(Transactions t1, Transactions t2) {
            int result = 0;

            if (t1.getPrice().compareTo(t2.getPrice()) > 0) result = -1;
            else result = 0;

            if (result == 0) {

                if (t1.getQueue().compareTo(t2.getQueue()) > 0) result = 1;
                else result = 0;

            }
            return result;
        }
    }

    // метод продажи
    public boolean sell(Transactions transactions) {
        if (checkerSell()&&checkerBuy() && transactions.price < queuesell.getFirst().price) {

            queuesell.addFirst(transactions);
        } else queuesell.addLast(transactions);
        Collections.sort((LinkedList) queuesell, new ComparatorQueueSell());
        return true;
    }

    // метод покупки
    public boolean buy(Transactions transactions) {

        if (checkerBuy() && checkerSell()&& transactions.price > queuebuy.getFirst().price) {
            queuebuy.addFirst(transactions);
        }
        queuebuy.addLast(transactions);
        Collections.sort((LinkedList) queuebuy, new ComparatorQueueBuy());
        return true;
    }

    // проверка на пустоту
    public boolean checkerSell() {
        boolean a = true;
        if ( queuebuy.isEmpty()) {
            a = false;
        }
        return a;
    }

    // проверка на пустоту
    public boolean checkerBuy() {
        boolean a = true;
        if ( queuesell.isEmpty()) {
            a = false;
        }
        return a;
    }

    // метод удаления продажи
    public void removeSell(Transactions transactions) {
        Integer a = 0;
        Integer b = 0;
        if (queuesell.getFirst().price <= transactions.price&&checkerSell()) {
            a = queuebuy.getFirst().count - transactions.count;
            queuesell.removeFirst();
            if (a <= 0) {
                queuebuy.removeFirst();
            }
            if (checkerSell()) {
                assert queuebuy.peekFirst() != null;
                b = queuebuy.peekFirst().getCount();
                assert queuebuy.peekFirst() != null;
                queuebuy.peekFirst().setCount(b + a);

            }
        }


    }

    // метод удаления покупки
    public void removeBuy(Transactions transactions) {
        Integer a = 0;
        Integer b = 0;
        if (queuebuy.getFirst().price >= transactions.price&&checkerBuy()) {
            a = queuebuy.getFirst().count - transactions.count;
            queuesell.removeFirst();
            if (a <= 0) {
                queuebuy.removeFirst();
            }
            if (checkerBuy()) {
                assert queuebuy.peekFirst() != null;
                b = queuebuy.peekFirst().getCount();
                assert queuebuy.peekFirst() != null;
                queuebuy.peekFirst().setCount(b + a);

            }
        }

    }

    // Переопределение метода отрисовки
    @Override
    public String toString() {
        return "Operations{" +
                "queuesell=" + queuesell +
                ", queuebuy=" + queuebuy +
                '}';
    }
}
