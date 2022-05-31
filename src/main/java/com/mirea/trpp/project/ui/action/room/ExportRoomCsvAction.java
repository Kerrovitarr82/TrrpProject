package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.CsvController;
import com.opencsv.exceptions.CsvException;
import com.mirea.trpp.project.ui.action.IAction;

import java.io.IOException;

public class ExportRoomCsvAction implements IAction {
    private CsvController csvController;

    public ExportRoomCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException {
        csvController.exportRoomCsv();
    }
}
