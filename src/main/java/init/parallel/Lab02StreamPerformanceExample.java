package init.parallel;

import java.util.ArrayList;
import java.util.List;

public class Lab02StreamPerformanceExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            numbers.add(i);
        }

        long seqStartTime = System.nanoTime();
        numbers.stream()
                .mapToLong(Lab02StreamPerformanceExample:: performCalculation)
                .sum();
        long seqEndTime = System.nanoTime();
        long seqExecutionTime = seqEndTime - seqStartTime;

        System.out.println("Seq Stream Execution time "+seqExecutionTime);


        long parStartTime = System.nanoTime();
        numbers.stream()
                .parallel()
                .mapToLong(Lab02StreamPerformanceExample:: performCalculation)
                .sum();
        long parEndTime = System.nanoTime();
        long parExecutionTime = parEndTime - parStartTime;

        System.out.println("Par Stream Execution time "+parExecutionTime);
    }

    private static long performCalculation(int number) {
        long fact = 1;
        for (int i = 0; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
