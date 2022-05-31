package com.mirea.trpp.project.ui.action.maintenance;

import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.ui.action.IAction;

import java.text.ParseException;

public class PrintAllMaintenanceAction implements IAction {
    private MaintenanceController maintenanceController;

    public PrintAllMaintenanceAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() throws ParseException {
        maintenanceController.getAll();
    }
}
