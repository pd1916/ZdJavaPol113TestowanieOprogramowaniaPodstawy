package pl.sdacademy.unit.test.basic.exercises.task5_dogrywka;

public class CarRepository {
    private Car[] cars = new Car[0];

    public Car[] getAllCars() {
        return cars;
    }

    public Car[] findByAge(int age) {
        int amountOfFoundCars = 0;
        for(Car car : cars) {
            if(car.getAge() == age) {
                amountOfFoundCars++;
            }
        }

        Car[] foundPeople = new Car[amountOfFoundCars];
        for (int i = 0, j = 0; i < cars.length; i++) {
            if (cars[i].getAge() == age) {
                foundPeople[j] = cars[i];
                j++;
            }
        }

        return foundPeople;
    }

    public void add(Car car) {
        Car[] updatedCars = new Car[cars.length + 1];
        for (int i = 0; i < cars.length; i++) {
            updatedCars[i] = cars[i];
        }
        updatedCars[cars.length] = car;
        cars = updatedCars;
    }

    public Car[] findByName(String name) {
        int amountOfFoundCars = 0;
        for(Car car : cars) {
            if(car.getName().equals(name)) {
                amountOfFoundCars++;
            }
        }
        Car[] foundPeople = new Car[amountOfFoundCars];
        for (int i = 0, j = 0; i < cars.length; i++) {
            if (cars[i].getName().equals(name)) {
                foundPeople[j] = cars[i];
                j++;
            }
        }
        return foundPeople;
    }
}