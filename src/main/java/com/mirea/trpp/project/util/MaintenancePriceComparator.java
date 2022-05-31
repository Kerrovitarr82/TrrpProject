package com.mirea.trpp.project.util;

import com.mirea.trpp.project.dao.entity.Maintenance;

import java.util.Comparator;

public class MaintenancePriceComparator implements Comparator<Maintenance> {
    @Override
    public int compare(Maintenance o1, Maintenance o2) {
        if (o1.getPrice() >= o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
