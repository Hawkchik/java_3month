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
        if (checkerSell() && checkerBuy() && transactions.price < queuesell.getFirst().price) {

            queuesell.addFirst(transactions);
        } else queuesell.addLast(transactions);
        Collections.sort((LinkedList) queuesell, new ComparatorQueueSell());
        return true;
    }

    // метод покупки
    public boolean buy(Transactions transactions) {

        if (checkerBuy() && checkerSell() && transactions.price > queuebuy.getFirst().price) {
            queuebuy.addFirst(transactions);
        } else queuebuy.addLast(transactions);
        Collections.sort((LinkedList) queuebuy, new ComparatorQueueBuy());
        return true;
    }

    // проверка на пустоту
    public boolean checkerSell() {
        boolean a = true;
        if (queuesell.isEmpty()) {
            a = false;
        }
        return a;
    }

    // проверка на пустоту
    public boolean checkerBuy() {
        boolean a = true;
        if (queuebuy.isEmpty()) {
            a = false;
        }
        return a;
    }

    // метод удаления продажи
    public void removeSell() {
        int a = 0; // Переменная для подсчёта количества акций
        int b = 0;  // переменная для количества денег
        while (checkerBuy() && checkerSell() && queuebuy.getFirst().price >= queuebuy.getFirst().price) {
            a = queuebuy.getFirst().count - queuesell.getFirst().count;
            if (a == 0) {
                queuebuy.removeFirst();
                b = queuebuy.getFirst().getCount() * queuebuy.getFirst().getPrice();
                queuesell.removeFirst();
            } else if (a < 0) {
                b += queuebuy.getFirst().getCount() * queuebuy.getFirst().getPrice();
                queuebuy.removeFirst();
                queuesell.getFirst().setCount(Math.abs(a));
            } else if (checkerSell()) {
                assert queuebuy.peekFirst() != null;
                queuebuy.peekFirst().setCount(a);
                b += a * queuebuy.peekFirst().getPrice();
                queuesell.removeFirst();

            }
        }


    }

    // метод удаления покупки
    public int removeBuy() {
        int a = 0; // Переменная для подсчёта количества акций
        int b = 0;  // переменная для количества денег
        while (checkerSell() && checkerBuy() && queuesell.getFirst().price <= queuebuy.getFirst().price) {
            a = queuesell.getFirst().count - queuebuy.getFirst().count;
            if (a == 0) {
                queuebuy.removeFirst();
                b = queuesell.getFirst().getCount() * queuesell.getFirst().getPrice();
                queuesell.removeFirst();
            } else if (a < 0) {
                b += queuesell.getFirst().getCount() * queuesell.getFirst().getPrice();
                queuesell.removeFirst();
                queuebuy.getFirst().setCount(Math.abs(a));
            } else if (checkerSell()) {
                assert queuesell.peekFirst() != null;
                queuesell.peekFirst().setCount(a);
                b += a * queuesell.peekFirst().getPrice();
                queuebuy.removeFirst();

            }
        }
        return b;

    }

    // Переопределение метода отрисовки
    @Override
    public String toString() {
        return queuebuy + " " + queuesell;
    }



    // Метод проверки стринги на число

    public boolean number (String number) {
        boolean numeric = true;
        numeric=number.matches("-?\\d+(\\.\\d+)?");
        if (numeric) return true;
        else return false;

    }
}
