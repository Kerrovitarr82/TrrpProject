package com.mirea.trpp.project.service;

import com.mirea.trpp.project.dao.entity.Guest;

import java.io.IOException;
import java.util.stream.Stream;

public interface GuestService extends AbstractService<Guest> {
    void deleteGuest(Long roomId);

    int getTotalPriceForGuest(Long guestId);

    int totalNumberOfGuests();

    Stream<Guest> getGuestSortedByNameByEvicDate();

    void guestSerialization(String fileName) throws IOException;

    void guestDeserialization(String fileName) throws IOException, ClassNotFoundException;
}
