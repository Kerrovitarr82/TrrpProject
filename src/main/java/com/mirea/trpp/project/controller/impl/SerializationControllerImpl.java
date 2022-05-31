package com.mirea.trpp.project.controller.impl;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.controller.GuestController;
import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.controller.SerializationController;
import com.mirea.trpp.project.util.ReaderUtil;

import java.io.File;
import java.io.IOException;

public class SerializationControllerImpl implements SerializationController {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;

    public SerializationControllerImpl(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
    }

    public static final String PATH_TO_SER_FILE = "task-7/src/main/java/com/senla/hoteladmin/";

    @Override
    public void entitiesSerialization() throws IOException {
        System.out.println("������� ��� ����� � ������� ���� ������������� ������� (� �����������)");
        String fileName = ReaderUtil.readLine();
        roomController.roomSerialization(fileName);
        System.out.println("������� ����������������!");
        System.out.println("������� ��� ����� � ������� ���� ������������� ������ (� �����������)");
        fileName = ReaderUtil.readLine();
        guestController.guestSerialization(fileName);
        System.out.println("����� ����������������!");
        System.out.println("������� ��� ����� � ������� ���� ������������� ������ (� �����������)");
        fileName = ReaderUtil.readLine();
        maintenanceController.maintenanceSerialization(fileName);
        System.out.println("������ ����������������!");

    }

    @Override
    public void entitiesDeserialization() throws IOException, ClassNotFoundException {
        System.out.println("������� ��� ����� �� �������� ���� ��������������� ������� (� �����������)");
        String fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            roomController.roomDeserialization(fileName);
            System.out.println("������� ����������������!");
        }
        System.out.println("������� ��� ����� �� �������� ���� ��������������� ������ (� �����������)");
        fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            guestController.guestDeserialization(fileName);
            System.out.println("����� ����������������!");
        }
        System.out.println("������� ��� ����� �� �������� ���� ��������������� ������ (� �����������)");
        fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            maintenanceController.maintenanceDeserialization(fileName);
            System.out.println("������ ����������������!");
        }
    }
}