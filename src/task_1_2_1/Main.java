package task_1_2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println(prepareForPrint(intList));
        System.out.println(new StreamMain().prepareForPrint(intList));
    }

    public static String prepareForPrint(List<Integer> sourceList) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : sourceList) {
            if (integer > 0 && integer % 2 == 0) {
                list.add(integer);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list.toString();
    }
}
