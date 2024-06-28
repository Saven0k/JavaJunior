package Seminar2.Homework;
import java.util.Date;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateProcessor {

    public static void processRandomDate(Object obj){
        for (Field declaredField: obj.getClass().getDeclaredFields()){
            if (declaredField.isAnnotationPresent(RandomDate.class)) {
                RandomDate annotation = declaredField.getAnnotation(RandomDate.class);
                long min = annotation.min();
                long max = annotation.max();

                declaredField.setAccessible(true);

                try {
                    declaredField.set(obj, new Date(ThreadLocalRandom.current().nextLong(min,max)));
                } catch (IllegalAccessException e){
                    System.out.println(e.getMessage()) ;
                }
            }
        }
    }
}
