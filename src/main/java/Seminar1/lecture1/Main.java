package Seminar1.lecture1;

import Seminar1.Homework.Department;
import Seminar1.Homework.Person;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 0. Скопировать классы Person и Department из ....
 * 1. Реализовать методы ниже....
 *
 */


public class Main {
    public static void main(String[] args) {
        List<Department> departments = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
                departments.add(new Department("Department #" + i));
        }

        List<Person> persons = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Department randomDepartmentIndex = departments.get(ThreadLocalRandom.current().nextInt(departments.size()));

            Person person = new Person();
            person.setName("Person #" + i);
            person.setAge(ThreadLocalRandom.current().nextInt(25,50));
            person.setSalary(ThreadLocalRandom.current().nextDouble(100_000,200_000));
            person.setDepartment(randomDepartmentIndex);
            persons.add(person);
        }

        System.out.println("Колличество сотрудников старше 36 лет и с зарплатой больше 12-000:" + countPerson(persons,36, 12_000));
        System.out.println("Средняя зарпалата в департаменте номер 3: " + avarageSalary(persons, 3).getAsDouble());
        System.out.println("Сотрудники сгрупированные по департаменту: " + groupByDepartment(persons));
        System.out.println("Имена сотрудников сгрупированных по депортаменту: " + groupNameByDepartment(persons));
        System.out.println("Максимальные зарплаты по депортаментам: " + maxSalaryByDepartment(persons));


    }

    // Найти количество сотрудников, старше x лет,  с зарпалтой больше d
    static int countPerson(List<Person> persons, int x, double y) {
        return (int)  persons.stream()
                .filter(it -> it.getAge() > x)
                .filter(it -> it.getSalary() > y)
                .count();
    }

    // Найти среднюю запрату сотрудников, в департаменте X
    static OptionalDouble avarageSalary(List<Person> persons, int x) {
        return persons.stream()
                .filter(ts -> ts.getDepartment().toString().contains(String.valueOf(x)))
                .mapToDouble(Person::getSalary)
                .average();
    }

    // Сгрупировать сотрудников по департаменту
    static Map<Department, List<Person>> groupByDepartment(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.toList()));
    }
//
    // Сгрупировать имена сотрудников по департаменту
    static Map<Department, List<String>> groupNameByDepartment(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.mapping(Person::getName, Collectors.toList())));
    }

    // Найти максимальные зарпалты по отедалам
    static Map<Department, Double> maxSalaryByDepartment(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getDepartment,
                        Collectors.mapping(Person::getSalary, Collectors.maxBy(Comparator.reverseOrder()))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().map(Double::valueOf).orElse(0.0)
                ));
    }

//    // Найти сотрудников с минимальными запратами в своем отделе(всех в лист)
//    static List<Person> minSalaryByDepartment(List<Person> persons) {
//        return persons.stream()
//                // Попробывать попробывал, ничего не вышло
//    }

}