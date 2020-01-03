import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Operations {

    Deque<Transactions> queuesell = new ArrayDeque<>();
    Deque<Transactions> queuebuy = new ArrayDeque<>();

    public boolean sell(Transactions transactions) {
        if (checkersell()) {
            removebuy(transactions.price);
        }
        queuesell.addFirst(transactions);

        return true;
    }


    public boolean buy(Transactions transactions) {
        if (checkerbuy()){
            removesell(transactions.price);
        }       queuebuy.addFirst(transactions);

        return true;
    }

    public boolean checkersell() {
        boolean a = true;
        if (queuebuy.isEmpty()||queuesell.isEmpty()) {
             a = false;
        }
        return a;
    }

    public void removebuy(Integer price) {

        if (queuebuy.getFirst().price >= price) {
            queuesell.removeFirst();
            queuebuy.removeFirst();
        }

    }

    public void removesell(Integer price) {

        if (queuesell.getFirst().price <= price) {
            queuesell.removeFirst();
            queuebuy.removeFirst();

        }
    }


    public boolean checkerbuy() {
        boolean a = true;
        if (queuesell.isEmpty()||queuebuy.isEmpty()) {
             a = false;
        }
        return a;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "queuesell=" + queuesell +
                ", queuebuy=" + queuebuy +
                '}';
    }
}
