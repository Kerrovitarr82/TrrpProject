package com.mirea.trpp.project.dao;

import com.mirea.trpp.project.dao.entity.Guest;
import com.mirea.trpp.project.dao.entity.Room;

public interface RoomDao extends AbstractDao<Room> {
    void setGuests(Long id, Guest guest);

    void setGuest(Room room, Guest guest);

    String checkLastThreeGuest(Long id);
}
