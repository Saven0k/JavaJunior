package Seminar1.lecture1;

public class Labdas {

    public static void main(String[] args) {
        // Все интерфейсы находятся в папке java/util/function/

        //Использование интерфейса Runnable через лямбда-вырежение
        Runnable runnable = () -> System.out.println("Hello World!");
        runnable.run();

        //Использование интерфейса Cunsumer через лямбда-вырежение
        Consumer<String> consumer = (arg) -> System.out.println(arg);
        consumer.accept("Hello World!");

        //Использование интерфейса Function через лямбда-вырежение
        Function<String, Integer> function = (arg) -> arg.length();
        System.out.println(function.apply("Hello World!"));


        //Использование интерфейса Supplier через лямбда-вырежение
        Supplier<String> supplier = () -> "Hello !";
        System.out.println(supplier.get());

        //Использование интерфейса BiFunction через лямбда-вырежение
        BiFunction<Integer, Integer, String> biFunction = (arg1, arg2) -> "Hello " + arg1 + " " + arg2;
        System.out.println(biFunction.apply(1, 2));


        //Использование интерфейса Predicate через лямбда-вырежение
        Predicate<String> predicate = (arg) -> arg.length() > 0;
        System.out.println(predicate.test("Hello World!"));
    }


    // Интерфейс Runnable
    // Ничего не принимает, ничего не возвращает
    interface Runnable {
        void run();
    }

    // Интерфейс Consumer - потребитель
    // Принимает обьект любого типа (<T>), ничего не возвращает
    interface Consumer<T> {
        void accept(T t);
    }

    // Интерфейс Function - функция
    // Принимает на вход обьект любого типа (<T>), возвращает обьект типа (<R>) "result"
    interface Function<T, R> {
        R apply(T t);
    }

    // Интерфейс Supplier - поставщик
    // Ничего не принимает, возвращает любой тип (<T>)
    interface Supplier<T> {
        T get();
    }

    // Интерфейс BiFunction
    // Принимает несколько аргументов любого типа <T,U>
    interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }

    // Интерфейс Predicate - утверждение
    // Принимает любой тип данных <T>, возвращает boolean значение
    interface Predicate<T> {
        boolean test(T t);
    }
}
