package init.programs;

import java.util.Random;

public class Lab02RandomNumberPrinter {

    public static void main(String[] args) {

        Random random = new Random();

        random.ints(10, 0 , 10).forEach(System.out ::println);
    }
}
