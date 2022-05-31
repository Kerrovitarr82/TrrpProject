package com.mirea.trpp.project.dao.impl;

import com.mirea.trpp.project.dao.MaintenanceDao;
import com.mirea.trpp.project.dao.entity.Maintenance;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {
    @Override
    public void update(Long id, Maintenance entity) {
        Maintenance maintenance = getById(id);
        maintenance.setName(entity.getName());
        maintenance.setPrice(entity.getPrice());
    }
}
