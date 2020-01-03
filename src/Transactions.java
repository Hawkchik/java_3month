import java.math.BigDecimal;

public class Transactions {
    Integer price;
    Integer queue;
    Integer count;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(String type) {
        this.queue = queue;
    }

    public Transactions(Integer price, Integer queue, Integer count) {
        this.price = price;
        this.queue = queue;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Цена: " + price + " Очередь: "+ queue  +
                " Количество: " + count;
    }
}
