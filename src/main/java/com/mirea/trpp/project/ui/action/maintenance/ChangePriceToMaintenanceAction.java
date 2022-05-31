package com.mirea.trpp.project.ui.action.maintenance;

import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.ui.action.IAction;

public class ChangePriceToMaintenanceAction implements IAction {
    private MaintenanceController maintenanceController;

    public ChangePriceToMaintenanceAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() {
        maintenanceController.changePriceToMaintenance();
    }
}
