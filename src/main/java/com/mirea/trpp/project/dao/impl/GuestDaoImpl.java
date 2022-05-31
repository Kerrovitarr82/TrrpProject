package com.mirea.trpp.project.dao.impl;

import com.mirea.trpp.project.dao.GuestDao;
import com.mirea.trpp.project.dao.entity.Guest;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {
    @Override
    public void update(Long id, Guest entity) {
        Guest guest = getById(id);
        guest.setName(entity.getName());
        guest.setRoom(entity.getRoom());
        guest.setLastDay(entity.getLastDay());
    }

    @Override
    public void setFirstAndLastDay(Long id, int days) {
        Guest guest = getById(id);
        guest.setFirstDay(new GregorianCalendar());
        guest.setLastDay(new GregorianCalendar());
        guest.getLastDay().add(Calendar.DAY_OF_YEAR, days);
    }


}
