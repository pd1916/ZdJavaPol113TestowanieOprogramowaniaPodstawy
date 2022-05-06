package pl.sdacademy.unit.test.basic.exercises.task5_dogrywka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {
    private CarRepository carRepository;

    @BeforeEach
    void beforeEach() {
        carRepository = new CarRepository();
    }

    @Test
    void shouldFindAllAddedCars() {
        //given
        Car expectedCar = new Car("BMW", 5);
        //when
        carRepository.add(expectedCar);
        Car[] result = carRepository.getAllCars();
        //then
        assertThat(result.length).isEqualTo(1);
        assertThat(result).containsExactly(expectedCar);
    }

    @Test
    void shouldFindCarsByAge() {
        //given
        Car givenCar1 = new Car("BMW",  5);
        Car givenCar2 = new Car("Mercedes",  5);
        Car givenCar3 = new Car("Audi",  7);
        Car[] expectedResult = new Car[] { givenCar1, givenCar2 };
        int age = 5;
        carRepository.add(givenCar1);
        carRepository.add(givenCar2);
        carRepository.add(givenCar3);
        //when
        Car[] result = carRepository.findByAge(age);
        //then
        assertThat(result.length).isEqualTo(expectedResult.length);
        assertThat(result).containsExactly(expectedResult);
    }

    @Test
    void shouldFindCarsByName() {
        //given
        Car givenCar1 = new Car("BMW",  5);
        Car givenCar2 = new Car("Mercedes",  5);
        Car givenCar3 = new Car("BMW",  7);
        Car[] expectedResult = new Car[] { givenCar1, givenCar3 };
        String name = "BMW";
        //when
        carRepository.add(givenCar1);
        carRepository.add(givenCar2);
        carRepository.add(givenCar3);
        //and
        Car[] result = carRepository.findByName(name);
        //then
        assertThat(result.length).isEqualTo(expectedResult.length);
        assertThat(result).containsExactly(expectedResult);
    }
}