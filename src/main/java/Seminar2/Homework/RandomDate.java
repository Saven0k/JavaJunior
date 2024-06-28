package Seminar2.Homework;
import java.util.Date;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    long min() default 1704056400L;
    long max() default 1735592400L;
//    String value() default "yyyy-MM-dd";
}
