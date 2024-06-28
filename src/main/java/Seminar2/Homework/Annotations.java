package Seminar2.Homework;

import java.util.Date;

/**
 1. Создать аннотацию RandomDate со следующими возможностями:
 1.1 Если параметры не заданы, то в поле должна вставляться рандомная дата в диапазоне min, тах.
 1.2 Аннотация должна работать с полем типа java.util.Date.
 1.3 Должна генерить дату в диапазоне (min, max)
 1.4 ** Научиться работать с полями LocalDateTime, LocalDate, Instant, ... (классы java. time.*)
 Реализовать класс RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию.
 */

public class Annotations {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        RandomDateProcessor.processRandomDate(myClass);

        System.out.println(myClass.date);
    }

    private static class MyClass {
        @RandomDate()
        private Date date;
//
//        @RandomDate("yyyy-MM-dd")
//        private Date date2;


    }
}
