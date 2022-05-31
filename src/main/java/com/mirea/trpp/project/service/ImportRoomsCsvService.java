package com.mirea.trpp.project.service;

import com.mirea.trpp.project.dao.entity.Room;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.ParseException;

public interface ImportRoomsCsvService extends AbstractService<Room> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException, ParseException;
}
