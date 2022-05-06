package pl.sdacademy.unit.test.basic.exercises.task5_dogrywka;

import java.util.Objects;

public class Car {
    private final String name;
    private final int age;

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return age == car.age && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}