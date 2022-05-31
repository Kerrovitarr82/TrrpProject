package com.mirea.trpp.project.ui.action.guest;

import com.mirea.trpp.project.controller.CsvController;
import com.opencsv.exceptions.CsvException;
import com.mirea.trpp.project.ui.action.IAction;

import java.io.IOException;
import java.text.ParseException;

public class ImportGuestsCsvAction implements IAction {
    private CsvController csvController;

    public ImportGuestsCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException, ParseException {
        csvController.importGuestsCsv();
    }
}
