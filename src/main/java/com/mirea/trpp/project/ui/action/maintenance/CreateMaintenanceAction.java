package com.mirea.trpp.project.ui.action.maintenance;

import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.ui.action.IAction;

public class CreateMaintenanceAction implements IAction {
    private MaintenanceController maintenanceController;

    public CreateMaintenanceAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() {
        maintenanceController.createMaintenance();
    }
}
