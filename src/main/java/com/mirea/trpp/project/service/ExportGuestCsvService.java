package com.mirea.trpp.project.service;

import com.mirea.trpp.project.dao.entity.Guest;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public interface ExportGuestCsvService extends AbstractService<Guest> {
    void exportCsv(String pathToCsv) throws IOException, CsvException;
}
