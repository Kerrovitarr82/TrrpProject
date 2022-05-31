package com.mirea.trpp.project.ui.action.maintenance;

import com.mirea.trpp.project.controller.CsvController;
import com.opencsv.exceptions.CsvException;
import com.mirea.trpp.project.ui.action.IAction;

import java.io.IOException;

public class ExportMaintenanceCsvAction implements IAction {
    private CsvController csvController;

    public ExportMaintenanceCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException {
        csvController.exportMaintenanceCsv();
    }
}
