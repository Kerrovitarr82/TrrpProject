package com.mirea.trpp.project.dao;

import com.mirea.trpp.project.dao.entity.Guest;

public interface GuestDao extends AbstractDao<Guest> {
    void setFirstAndLastDay(Long id, int days);
}
