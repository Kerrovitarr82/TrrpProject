package com.mirea.trpp.project.controller.impl;

import com.mirea.trpp.project.service.ExportMaintenanceCsvService;
import com.mirea.trpp.project.service.ImportMaintenancesCsvService;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.mirea.trpp.project.controller.CsvController;
import com.mirea.trpp.project.service.ExportGuestCsvService;
import com.mirea.trpp.project.service.ExportRoomCsvService;
import com.mirea.trpp.project.service.ImportGuestsCsvService;
import com.mirea.trpp.project.service.ImportRoomsCsvService;

import java.io.IOException;
import java.text.ParseException;

public class CsvControllerImpl implements CsvController {
    private ExportRoomCsvService exportRoomCsvService;
    private ExportGuestCsvService exportGuestCsvService;
    private ExportMaintenanceCsvService exportMaintenanceCsvService;
    private ImportRoomsCsvService importRoomsCsvService;
    private ImportGuestsCsvService importGuestsCsvService;
    private ImportMaintenancesCsvService importMaintenancesCsvService;

    public CsvControllerImpl(ExportRoomCsvService exportRoomCsvService,
                             ExportGuestCsvService exportGuestCsvService,
                             ExportMaintenanceCsvService exportMaintenanceCsvService,
                             ImportRoomsCsvService importRoomsCsvService,
                             ImportGuestsCsvService importGuestsCsvService,
                             ImportMaintenancesCsvService importMaintenancesCsvService) {
        this.exportRoomCsvService = exportRoomCsvService;
        this.exportGuestCsvService = exportGuestCsvService;
        this.exportMaintenanceCsvService = exportMaintenanceCsvService;
        this.importRoomsCsvService = importRoomsCsvService;
        this.importGuestsCsvService = importGuestsCsvService;
        this.importMaintenancesCsvService = importMaintenancesCsvService;
    }

    @Override
    public void importRoomsCsv() throws IOException, CsvValidationException, ParseException {
        importRoomsCsvService.importCsv("task-7/src/main/java/com/senla/hoteladmin/roomsImport.csv");
    }

    @Override
    public void importGuestsCsv() throws IOException, CsvValidationException, ParseException {
        importGuestsCsvService.importCsv("task-7/src/main/java/com/senla/hoteladmin/guestsImport.csv");
    }

    @Override
    public void importMaintenancesCsv() throws IOException, CsvValidationException {
        importMaintenancesCsvService.importCsv("task-7/src/main/java/com/senla/hoteladmin/maintenancesImport.csv");
    }

    @Override
    public void exportRoomCsv() throws IOException, CsvException {
        exportRoomCsvService.exportCsv("task-7/src/main/java/com/senla/hoteladmin/roomsExport.csv");
    }

    @Override
    public void exportGuestCsv() throws IOException, CsvException {
        exportGuestCsvService.exportCsv("task-7/src/main/java/com/senla/hoteladmin/guestsExport.csv");
    }

    @Override
    public void exportMaintenanceCsv() throws IOException, CsvException {
        exportMaintenanceCsvService.exportCsv("task-7/src/main/java/com/senla/hoteladmin/maintenancesExport.csv");
    }
}
