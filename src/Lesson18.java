import java.util.*;

public class Lesson18 {
    public static void main(String[] args) {
        System.out.println("Введите предложение");
        Scanner scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        Map<String, Integer> words = new TreeMap<>();
        int v = 1;
        for (String c : b.split(" ")) {
            words.put(c, v++);
        }

        System.out.println(words);

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            // если максимум не определен или очередное значение ещё больше
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry; // то присваем максимуму новое значение
            }
        }
        System.out.println("Всего слов в строке " + maxEntry.getValue());



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

    }
}
