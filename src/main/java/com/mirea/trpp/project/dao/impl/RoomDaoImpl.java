package com.mirea.trpp.project.dao.impl;

import com.mirea.trpp.project.dao.RoomDao;
import com.mirea.trpp.project.dao.entity.Guest;
import com.mirea.trpp.project.dao.entity.Room;
import com.mirea.trpp.project.util.GuestDateComparatorDescending;

import java.text.SimpleDateFormat;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {
    @Override
    public void update(Long id, Room entity) {
        Room room = getById(id);
        room.setNumber(entity.getNumber());
        room.setStatus(entity.getStatus());
        room.setPrice(entity.getPrice());
        room.setMaxGuests(entity.getMaxGuests());
        room.setStars(entity.getStars());
    }

    @Override
    public void setGuests(Long id, Guest guest) {
        Room room = getById(id);
        if (guest == null) {
            room.getGuests().clear();
        } else {
            setGuest(room, guest);
        }
    }

    @Override
    public void setGuest(Room room, Guest guest) {
        if (room.getHistoryOfGuests().size() != room.getMaxGuestsInHistory()) {
            room.getGuests().add(guest);
            room.getHistoryOfGuests().addLast(guest);
        } else {
            room.getGuests().add(guest);
            room.getHistoryOfGuests().pollFirst();
            room.getHistoryOfGuests().addLast(guest);
        }
    }

    @Override
    public String checkLastThreeGuest(Long id) {
        Room room = getById(id);
        var wrapper = new Object() {
            String threeGuests = "";
        };
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        room.getHistoryOfGuests().stream().sorted(new GuestDateComparatorDescending()).limit(3).forEach(guest -> {
            wrapper.threeGuests += "Имя: " + guest.getName() +
                    ". Дата заезда: " + simpleDateFormat.format(guest.getFirstDay().getTime()) +
                    ". Дата выезда: " + simpleDateFormat.format(guest.getLastDay().getTime()) + "\n";
        });
        return wrapper.threeGuests.substring(0, wrapper.threeGuests.length() - 1);
    }
}
