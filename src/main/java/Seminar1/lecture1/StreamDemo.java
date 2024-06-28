package Seminar1.lecture1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StreamDemo{
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0,100);
            if (ThreadLocalRandom.current().nextBoolean()){
                randomInt = -randomInt;
            }
            ints.add(randomInt);
        }

        // Все положительные четные числа, которые есть в ints, умножить на 4 и распечатать их в консоль.

        ints.stream()
                .filter(it -> it % 2 == 0)
                .filter(it -> it > 0)
                .map(it -> it * 4)
                .forEach(it -> System.out.println(it));
    }
}
