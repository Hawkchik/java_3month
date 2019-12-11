import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

public class Start {
    public static void main(String[] args) {

        UniqElement one = new UniqElement();

        one.numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            int b = (int) (Math.random() * (9)) + 1;
            one.numbers.add(b);
            //( Math.random() * (b-a) ) + a
        }
        System.out.println(one.numbers);
        Collections.sort(one.numbers);
        System.out.println(one.numbers);
//        ListIterator iterator = one.numbers.listIterator();
        boolean c = false;

        for (int i = 0; i < one.numbers.size() - 1; i++) {

            if (one.numbers.get(i) == one.numbers.get(i + 1)) {
                one.numbers.remove(i);
                c = true;
            } else if (c == true) {
                one.numbers.remove(i - 1);
                c = false;
            } else break;
        }

        System.out.println(one.numbers.get(0));

    }


}
