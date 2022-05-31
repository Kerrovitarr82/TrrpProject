package com.mirea.trpp.project.service;

import com.mirea.trpp.project.dao.entity.Guest;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.ParseException;

public interface ImportGuestsCsvService extends AbstractService<Guest> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException, ParseException;
}
