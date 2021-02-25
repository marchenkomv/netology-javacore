package task_1_2_2;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println(getUnderAgeCount(persons));
        print(getReservistList(persons));
        print(getWorkableList(persons));

    }

    public static long getUnderAgeCount(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
    }

    public static Collection<String> getReservistList(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }

    public static Collection<Person> getWorkableList(Collection<Person> persons) {
        Predicate<Person> predicateMan = person -> person.getAge() <= 65 && person.getSex() == Sex.MAN;
        Predicate<Person> predicateWoman = person -> person.getAge() <= 60 && person.getSex() == Sex.WOMEN;

        return persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(predicateMan.or(predicateWoman))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }

    public static void print(Collection list) {
        list.stream()
                .forEach(System.out::println);
    }
}
