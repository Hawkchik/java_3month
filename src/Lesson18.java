import java.util.*;

public class Lesson18 {
    public static void main(String[] args) {
        /*Map <String, String> products = new LinkedHashMap<>();
        products.put("Антон", "Proger");
        products.put("Ivan", "QA Engineer");
        products.put("Dmitriy", "Business-man");

       Set a= products.entrySet();

        for (Map.Entry<String,String> pair: products.entrySet()){
            System.out.println(pair.getKey()+ " works " + pair.getValue());
        }*/
/*
        Map <String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        Integer val4 = map.get("four");
        Integer val5 = map.getOrDefault("five",5);
        Integer val6 = map.get("six");

        System.out.println(val4);
        System.out.println(val5);
        System.out.println(val6);

        System.out.println(map);*/

        Comparator<Order> myComparat = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result = 0;
                if (o1.amount.compareTo(o2.amount) > 0) result = 1;
                if (o1.amount.compareTo(o2.amount) < 0) result = -1;
                else result = 0;

                if (result == 0) {
                    if (o1.name.compareTo(o2.name) < 0) result = -1;
                    if (o1.name.compareTo(o2.name) > 0) result = 1;
                    else result = 0;
                }
                if (result == 0) {
                    if (o1.bank.equals("Sber")) result = -1;
                    if (o1.bank.equals("Alpha")) result = 1;
                    else if (o1.bank.equals("Vtb")) result = 2;
                }
                return result;

            }
        };
        SortedSet<Order> mySet = new TreeSet<>(myComparat);
        mySet.add(new Order("Test", "Sber", 4000));
        mySet.add(new Order("Sergey", "Sber", 500));
        mySet.add(new Order("Test", "Alpha", 4000));
        mySet.add(new Order("Test", "Vtb", 4000));
        mySet.add(new Order("Ivan", "Vtb", 1000));

        System.out.println(mySet);
    }
}
