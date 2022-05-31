package com.mirea.trpp.project.service;

import com.opencsv.exceptions.CsvValidationException;
import com.mirea.trpp.project.dao.entity.Maintenance;

import java.io.IOException;

public interface ImportMaintenancesCsvService extends AbstractService<Maintenance> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException;
}
