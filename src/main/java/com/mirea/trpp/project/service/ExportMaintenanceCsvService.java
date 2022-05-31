package com.mirea.trpp.project.service;

import com.opencsv.exceptions.CsvException;
import com.mirea.trpp.project.dao.entity.Maintenance;

import java.io.IOException;

public interface ExportMaintenanceCsvService extends AbstractService<Maintenance> {
    void exportCsv(String pathToCsv) throws IOException, CsvException;
}
