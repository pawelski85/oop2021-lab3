package com.company.devices;

import com.company.Transaction;
import com.company.animals.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car extends Device {

    final static Double MAX_FUEL = 1.0;
    public Double engineSize;
    public String fuelType;
    public Double currentFuel = 0.0;

    /**
     * a. Add a List of Human owners to the Car class
     * b. Last element on that list should be the current owner of the car
     */
    public List<Human> owners = new ArrayList<>();

    /**
     * b. Add a list of Transactions to the Car class.
     */
    public List<Transaction> transactions = new ArrayList<>();

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    /**
     * . Change method Car.sell(Human seller, Human buyer, Double price) so that it
     * contains:
     *
     * @param seller
     * @param buyer
     * @param price
     * @throws Exception
     */
    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        /**
         * i. a check if seller has the car in the garage (if not - throw an exception)
         */
        List<Car> forSale = seller.getCars();

        Car soldOne = null;
        for (Car car : forSale) {
            if (car == this) {
                soldOne = car;
                break;
            }
        }

        if (soldOne == null) {
            throw new Exception("seller doesn't have the car in the garage");
        }

        /**
         * d. When selling the car, we should check if the seller is
         * the last owner of the car
         */

        Human lastOwner = soldOne.owners.get(soldOne.owners.size() - 1);
        if (lastOwner != seller) {
            throw new Exception("seller is not the last owner of the car");
        }

        /**
         * ii. a check if buyer has available spots in the garage (if not - throw an
         * exception)
         */
        Car[] inGarage = buyer.garage;
        boolean hasEmptySpot = false;
        for (Car car : inGarage) {
            if (car == null) {
                hasEmptySpot = true;
                break;
            }
        }

        if (hasEmptySpot == false) {
            throw new Exception("buyer hasn't got any available spots in the garage");
        }

        /**
         * iii. a check if buyer has enough cash (if not throw an exception)
         */
        if (buyer.cash < price) {
            throw new Exception("buyer doesn't have enough cash");
        }
        /**
         *  iv. removal of the car from seller's garage
         */

        Car[] garage = seller.garage;
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == soldOne) {
                garage[i] = null;
                break;
            }
        }


        /**
         * v. adding the car to the first available spot in buyer's garage v
         */

        for (int i = 0; i < inGarage.length; i++) {
            if (inGarage[i] == null) {
                inGarage[i] = soldOne;
                break;
            }
        }

        /**
         * vi. money exchange
         */
        seller.cash += price;
        buyer.cash -= price;

        /**
         * vii. information in the console that the transaction has been successful h.
         */
        System.out.println("Car has been sold");

        /**
         * c. Every time a car is sold a new element should be added to the list of owners
         */
        soldOne.owners.add(buyer);

        /**
         * c. Modify method sell to store the transaction in the list.
         */
        Transaction transaction = new Transaction();
        transaction.buyer = buyer;
        transaction.date = new Date();
        transaction.price = price;
        transaction.seller = seller;
        transactions.add(transaction);

    }

    public void refuel() {
        currentFuel = MAX_FUEL;
    }

    /**
     * e. Add a new method to the Car class that checks if a Human has ever been an owner
     * of a car
     *
     * @param human
     * @return
     */
    public boolean everOwn(Human human) {
        for (Human one : owners) {
            if (one == human) {
                return true;
            }
        }
        return false;
    }

    /**
     * f. Add a new method to the Car class that checks if Human A sold the car to
     * Human B
     *
     * @param A
     * @param B
     * @return
     */
    public boolean everSold(Human A, Human B) {
        int i;
        for (i = 0; i < owners.size(); i++) {
            if (owners.get(i) == A) {
                break;
            }
        }


        for (; i < owners.size(); i++) {
            if (owners.get(i) == B) {
                return true;
            }
        }

        return false;
    }

    /**
     * g. Add a new method to the Car class that returns how many times the car has been
     * sold
     * @return
     */
    public int soldTime(){
        return owners.size() - 1;
    }
}
