package com.mirea.trpp.project.service;

import com.mirea.trpp.project.dao.entity.Room;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public interface ExportRoomCsvService extends AbstractService<Room> {
    void exportCsv(String pathToCsv) throws IOException, CsvException;
}
