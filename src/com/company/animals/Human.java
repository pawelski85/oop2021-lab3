package com.company.animals;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Human extends Animal {
    public final static String HUMAN_SPECIE = "homo sapiens";
    public final int FINGER_COUNT = 10;
    public String firstName;
    public String lastName;
    public Phone phone;
    public Double cash;
    public String[] fingerNames;
    List<Animal> pets;
    /*
     a. Remove car field from Human class and create an array of
     cars called garage
     */
    // Car car;
    public Car[] garage;
    private Double salary;

    public Human(Double salary) {
        super(HUMAN_SPECIE);
        this.setSalary(salary);
        fingerNames = new String[FINGER_COUNT];


        garage = new Car[10];
    }


    public Human(Double salary, int carNum) {
        this(salary);
        garage = new Car[carNum];
    }



    public Car getCar(int spot) {
        if (spot < 0 || spot >= garage.length) {
            return null;
        }
        return garage[spot];
    }

    public void setCar(Car car, int spot) {
        if (spot >= 0 && spot < garage.length) {
            garage[spot] = car;
        }
    }


    public Double getValues() {
        Double value = 0.0;
        for (Car car : garage) {
            if (car != null) {
                value += car.getValue();
            }
        }
        return value;
    }



    public List<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Car car : garage) {
            if (car != null) {
                cars.add(car);
            }
        }

        List<Car> result = cars.stream().
                sorted((o1, o2) -> {
                    if (o1.getYearOfProduction() == null
                            && o2.getYearOfProduction() == null){
                        return 0;
                    }
                    if (o1.getYearOfProduction() == null){
                        return -1;
                    }
                    if (o2.getYearOfProduction() == null){
                        return 1;
                    }
                    return o1.getYearOfProduction() - o2.getYearOfProduction();
                })
                .toList();
        return result;
        /* return result;*/
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        } else {
            System.out.println("NOBODY WILL PAY FOR WORKING");
            this.salary = 0.0;
        }
    }

    public void addPet(Animal pet) {
        if (pets == null) {
            pets = new ArrayList<Animal>();
        }
        pets.add(pet);
    }

    public List<Animal> getPets() {
        return pets;
    }

}
