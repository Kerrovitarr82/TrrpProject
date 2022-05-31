package com.mirea.trpp.project;

import com.mirea.trpp.project.service.ExportMaintenanceCsvService;
import com.mirea.trpp.project.service.ImportMaintenancesCsvService;
import com.opencsv.exceptions.CsvException;
import com.mirea.trpp.project.controller.CsvController;
import com.mirea.trpp.project.controller.GuestController;
import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.controller.MenuController;
import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.controller.SerializationController;
import com.mirea.trpp.project.controller.impl.CsvControllerImpl;
import com.mirea.trpp.project.controller.impl.GuestControllerImpl;
import com.mirea.trpp.project.controller.impl.MaintenanceControllerImpl;
import com.mirea.trpp.project.controller.impl.MenuControllerImpl;
import com.mirea.trpp.project.controller.impl.RoomControllerImpl;
import com.mirea.trpp.project.controller.impl.SerializationControllerImpl;
import com.mirea.trpp.project.dao.GuestDao;
import com.mirea.trpp.project.dao.MaintenanceDao;
import com.mirea.trpp.project.dao.RoomDao;
import com.mirea.trpp.project.dao.impl.GuestDaoImpl;
import com.mirea.trpp.project.dao.impl.MaintenanceDaoImpl;
import com.mirea.trpp.project.dao.impl.RoomDaoImpl;
import com.mirea.trpp.project.service.ExportGuestCsvService;
import com.mirea.trpp.project.service.ExportRoomCsvService;
import com.mirea.trpp.project.service.GuestService;
import com.mirea.trpp.project.service.ImportGuestsCsvService;
import com.mirea.trpp.project.service.ImportRoomsCsvService;
import com.mirea.trpp.project.service.MaintenanceService;
import com.mirea.trpp.project.service.RoomService;
import com.mirea.trpp.project.service.impl.ExportGuestCsvServiceImpl;
import com.mirea.trpp.project.service.impl.ExportMaintenanceCsvServiceImpl;
import com.mirea.trpp.project.service.impl.ExportRoomCsvServiceImpl;
import com.mirea.trpp.project.service.impl.GuestServiceImpl;
import com.mirea.trpp.project.service.impl.ImportGuestsCsvServiceImpl;
import com.mirea.trpp.project.service.impl.ImportMaintenancesCsvServiceImpl;
import com.mirea.trpp.project.service.impl.ImportRoomsCsvServiceImpl;
import com.mirea.trpp.project.service.impl.MaintenanceServiceImpl;
import com.mirea.trpp.project.service.impl.RoomServiceImpl;
import com.mirea.trpp.project.ui.Builder;
import com.mirea.trpp.project.ui.Navigator;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, CsvException, IOException, ClassNotFoundException {
        RoomDao roomDao = new RoomDaoImpl();
        GuestDao guestDao = new GuestDaoImpl();
        MaintenanceDao maintenanceDao = new MaintenanceDaoImpl();
        RoomService roomService = new RoomServiceImpl(roomDao, roomDao, guestDao, maintenanceDao);
        GuestService guestService = new GuestServiceImpl(guestDao, roomDao, guestDao, maintenanceDao);
        MaintenanceService maintenanceService = new MaintenanceServiceImpl(maintenanceDao, roomDao, guestDao, maintenanceDao);
        ExportRoomCsvService exportRoomCsvService = new ExportRoomCsvServiceImpl(roomDao);
        ExportGuestCsvService exportGuestCsvService = new ExportGuestCsvServiceImpl(guestDao);
        ExportMaintenanceCsvService exportMaintenanceCsvService = new ExportMaintenanceCsvServiceImpl(maintenanceDao);
        ImportRoomsCsvService importRoomsCsvService = new ImportRoomsCsvServiceImpl(roomDao, guestDao, maintenanceDao);
        ImportGuestsCsvService importGuestsCsvService = new ImportGuestsCsvServiceImpl(guestDao, roomDao, maintenanceDao);
        ImportMaintenancesCsvService importMaintenancesCsvService = new ImportMaintenancesCsvServiceImpl(maintenanceDao);
        RoomController roomController = new RoomControllerImpl(roomService, guestService);
        GuestController guestController = new GuestControllerImpl(roomService, guestService);
        MaintenanceController maintenanceController = new MaintenanceControllerImpl(roomService, guestService, maintenanceService);
        CsvController csvController = new CsvControllerImpl(exportRoomCsvService, exportGuestCsvService, exportMaintenanceCsvService, importRoomsCsvService, importGuestsCsvService, importMaintenancesCsvService);
        SerializationController serializationController = new SerializationControllerImpl(roomController, guestController, maintenanceController);
        Builder builder = new Builder(roomController, guestController, maintenanceController, csvController);
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuControllerImpl(builder, navigator, serializationController);

        menuController.afterStart();
        menuController.run();
        menuController.beforeExit();
    }
}
