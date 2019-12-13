import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Order {

    public String name;
    public String bank;

    @Override
    public String toString() {
        return
                 name  +
                ' '+ bank + ' '+ amount ;
    }

    public Integer amount;

    public Order() {
    }

    public Order(String name, String bank) {
        this.name = name;
        this.bank = bank;
    }

    public Order(String name, String bank, Integer amount) {
        this.name = name;
        this.bank = bank;
        this.amount = amount;
    }



}
