package com.company.devices;

import com.company.animals.Human;

public interface Sellable {
    void sell(Human seller, Human buyer, Double price) throws Exception;
}
