package task_1_2_1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public String prepareForPrint(List<Integer> list) {
        return list.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .toString();
    }
}
