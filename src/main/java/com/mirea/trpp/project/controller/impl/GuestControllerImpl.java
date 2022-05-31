package com.mirea.trpp.project.controller.impl;

import com.mirea.trpp.project.controller.GuestController;
import com.mirea.trpp.project.service.GuestService;
import com.mirea.trpp.project.service.RoomService;
import com.mirea.trpp.project.util.PrettyPrinterUtil;
import com.mirea.trpp.project.util.ReaderUtil;

import java.io.IOException;

public class GuestControllerImpl implements GuestController {
    private RoomService roomService;
    private GuestService guestService;


    public GuestControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void deleteGuest() {
        System.out.print("������� id ������, ������ ������� ���� �������: ");
        Long id = ReaderUtil.readLong();
        guestService.deleteGuest(id);
        System.out.println("�����/� ������/�");
    }

    @Override
    public void getTotalPriceForGuest() {
        System.out.print("������� id �����: ");
        Long id = ReaderUtil.readLong();
        int total = guestService.getTotalPriceForGuest(id);
        System.out.println("������ ��������� ���������� ��� �����: " + total);
    }

    @Override
    public void totalNumberOfGuests() {
        int total = guestService.totalNumberOfGuests();
        System.out.println("����� ���-�� ������: " + total);
        getAllGuests();
    }

    @Override
    public void getGuestSortedByNameByEvicDate() {
        guestService.getGuestSortedByNameByEvicDate().forEach(System.out::println);
    }

    @Override
    public void guestSerialization(String fileName) throws IOException {
        guestService.guestSerialization(fileName);
    }

    @Override
    public void guestDeserialization(String fileName) throws IOException, ClassNotFoundException {
        guestService.guestDeserialization(fileName);
    }

    private void getAllGuests() {
        PrettyPrinterUtil.printFunc(guestService.getAll());
    }
}
