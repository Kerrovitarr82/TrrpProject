package com.mirea.trpp.project.controller.impl;

import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.dao.entity.Maintenance;
import com.mirea.trpp.project.service.GuestService;
import com.mirea.trpp.project.service.MaintenanceService;
import com.mirea.trpp.project.service.RoomService;
import com.mirea.trpp.project.util.PrettyPrinterUtil;
import com.mirea.trpp.project.util.ReaderUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

public class MaintenanceControllerImpl implements MaintenanceController {
    private RoomService roomService;
    private GuestService guestService;
    private MaintenanceService maintenanceService;

    public MaintenanceControllerImpl(RoomService roomService, GuestService guestService, MaintenanceService maintenanceService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.maintenanceService = maintenanceService;
    }

    @Override
    public void createMaintenance() {
        Maintenance maintenance = new Maintenance();
        System.out.print("������� �������� ������: ");
        String name = ReaderUtil.readLine();
        maintenance.setName(name);
        System.out.print("������� ���� ������: ");
        int price = ReaderUtil.readInt();
        maintenance.setPrice(price);
        maintenanceService.create(maintenance);
        System.out.println("������ �������!");
    }

    @Override
    public void changePriceToMaintenance() {
        System.out.print("������� id ������: ");
        Long id = ReaderUtil.readLong();
        System.out.print("������� ����� ���� ������: ");
        int price = ReaderUtil.readInt();
        maintenanceService.changePriceToMaintenance(id, price);
        System.out.println("���� ��������!");
    }

    @Override
    public void addMaintenanceToGuest() throws ParseException {
        System.out.print("������� id ������: ");
        Long idMaintenance = ReaderUtil.readLong();
        System.out.print("������� id �����: ");
        Long idGuest = ReaderUtil.readLong();
        System.out.print("������� ���� � ������� ��.��.����: ");
        Calendar calendar = ReaderUtil.dateReadInDdMmYyyyFormat();
        maintenanceService.addMaintenanceToGuest(idMaintenance, idGuest, calendar);
        System.out.println("������ ��������� �����!");
    }

    @Override
    public void getMaintenanceSortedByPrice() {
        maintenanceService.getMaintenanceSortedByPrice().forEach(System.out::println);
    }

    @Override
    public void getMaintenancesForGuestSortedByPriceByDate() {
        System.out.print("������� id �����: ");
        Long id = ReaderUtil.readLong();
        maintenanceService.getMaintenancesForGuestSortedByPriceThenByDate(id).forEach(System.out::println);
    }

    @Override
    public void getAll() {
        PrettyPrinterUtil.printFunc(maintenanceService.getAll());
    }

    @Override
    public void maintenanceSerialization(String fileName) throws IOException {
        maintenanceService.maintenanceSerialization(fileName);
    }

    @Override
    public void maintenanceDeserialization(String fileName) throws IOException, ClassNotFoundException {
        maintenanceService.maintenanceDeserialization(fileName);
    }
}
