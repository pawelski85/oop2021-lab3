package com.company.animals;

import java.util.Comparator;

public class AnimalWeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else if (o1.getWeight() == o2.getWeight()) {
            return 0;
        } else if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
