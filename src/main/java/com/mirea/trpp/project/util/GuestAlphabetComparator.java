package com.mirea.trpp.project.util;

import com.mirea.trpp.project.dao.entity.Guest;

import java.util.Comparator;

public class GuestAlphabetComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
