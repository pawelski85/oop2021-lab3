package com.company;

import com.company.animals.*;
import com.company.devices.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Human me = new Human(1000.0);
        me.firstName = "Jan";
        me.lastName = "Kowalski";
        me.cash = 0.0;

        Car fiat = new Car();
        fiat.engineSize = 1.9;
        fiat.fuelType = "Diesel";
        fiat.setProducer("Fiat");
        fiat.setModel("Bravo");
        fiat.setValue(15784.0);
        fiat.setYearOfProduction(2000);
        me.setCar(fiat, 0);
        ;
        fiat.owners.add(me);

        Car ford = new Car();
        ford.engineSize = 1.9;
        ford.fuelType = "Diesel";
        ford.setProducer("Ford");
        ford.setModel("Ranger");
        ford.setValue(98474.0);
        ford.setYearOfProduction(2008);
        me.setCar(ford, 1);
        ;
        ford.owners.add(me);


        System.out.println("Garage value: " + me.getValues());



        for (Car car : me.getCars()) {
            System.out.println(car.getProducer() + " " + car.getYearOfProduction());
        }


        Human bob = new Human(981000.0);
        bob.cash = 481760.0;
        try {
            fiat.sell(me, bob, 48746.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            ford.sell(me, bob, 568744.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Human humanA = new Human(54898.2);
        humanA.cash = 0.0;
        humanA.firstName = "Bob";
        Human humanB = new Human(5454898.2);
        humanB.cash = 4687898.0;
        humanB.firstName = "Tom";
        Human humanC = new Human(548898.2);
        humanC.cash = 579663454.1;
        humanC.firstName = "Peter";
        Human humanD = new Human(548998.2);
        humanD.cash = 498766854.15;
        humanD.firstName = "James";


        Car toyota = new Car();
        toyota.setYearOfProduction(2007);
        toyota.setProducer("Toyota");
        humanA.setCar(toyota, 0);
        toyota.owners.add(humanA);
        try {
            toyota.sell(humanA, humanB, 489879.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        try {
            toyota.sell(humanB, humanC, 89879.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            toyota.sell(humanA, humanD, 489879.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("how many times the car has been sold: " + toyota.soldTime());



        if (toyota.everSold(humanC, humanB)) {
            System.out.println("humanC sold the car to humanB");
        } else {
            System.out.println("humanC didn't sell the car to humanB");
        }


        for (Transaction transaction : toyota.transactions) {
            System.out.println("Seller: " + transaction.seller.firstName
                    + ", Buyer: " + transaction.buyer.firstName
                    + ", " + transaction.price
                    + ", Date: " + transaction.date.toString());
        }
    }
}
