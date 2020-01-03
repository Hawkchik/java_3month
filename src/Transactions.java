import java.math.BigDecimal;

public class Transactions {
    Integer price;
    String type;
    Integer count;


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transactions(Integer price, String type, Integer count) {
        this.price = price;
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return   price + " "+ type  +
                " " + count;
    }
}
