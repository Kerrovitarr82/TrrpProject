package com.mirea.trpp.project.ui;

import com.mirea.trpp.project.controller.CsvController;
import com.mirea.trpp.project.controller.GuestController;
import com.mirea.trpp.project.controller.MaintenanceController;
import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.guest.DeleteGuestAction;
import com.mirea.trpp.project.ui.action.guest.ExportGuestCsvAction;
import com.mirea.trpp.project.ui.action.guest.GetGuestSortedByNameByEvicDateAction;
import com.mirea.trpp.project.ui.action.guest.GetTotalPriceForGuestAction;
import com.mirea.trpp.project.ui.action.guest.ImportGuestsCsvAction;
import com.mirea.trpp.project.ui.action.guest.TotalNumberOfGuestsAction;
import com.mirea.trpp.project.ui.action.maintenance.AddMaintenanceToGuestAction;
import com.mirea.trpp.project.ui.action.maintenance.ChangePriceToMaintenanceAction;
import com.mirea.trpp.project.ui.action.maintenance.CreateMaintenanceAction;
import com.mirea.trpp.project.ui.action.maintenance.ExportMaintenanceCsvAction;
import com.mirea.trpp.project.ui.action.maintenance.GetMaintenanceForGuestSortedByPriceByDateAction;
import com.mirea.trpp.project.ui.action.maintenance.GetMaintenanceSortedByPriceAction;
import com.mirea.trpp.project.ui.action.maintenance.ImportMaintenancesCsvAction;
import com.mirea.trpp.project.ui.action.maintenance.PrintAllMaintenanceAction;
import com.mirea.trpp.project.ui.action.room.AddToRoomAction;
import com.mirea.trpp.project.ui.action.room.ChangePriceToRoomAction;
import com.mirea.trpp.project.ui.action.room.ChangeStatusAction;
import com.mirea.trpp.project.ui.action.room.CreateRoomAction;
import com.mirea.trpp.project.ui.action.room.DeleteFromRoomAction;
import com.mirea.trpp.project.ui.action.room.ExportRoomCsvAction;
import com.mirea.trpp.project.ui.action.room.GetAllRoomSortedByPriceByMaxGuestsByStarsAction;
import com.mirea.trpp.project.ui.action.room.GetFreeRoomSortedByPriceByMaxGuestsByStarsAction;
import com.mirea.trpp.project.ui.action.room.GetLastThreeGuestAction;
import com.mirea.trpp.project.ui.action.room.GetRoomHistoryAction;
import com.mirea.trpp.project.ui.action.room.ImportRoomCsvAction;
import com.mirea.trpp.project.ui.action.room.ListOfFreeRoomsByDateAction;
import com.mirea.trpp.project.ui.action.room.RoomDetailsAction;
import com.mirea.trpp.project.ui.action.room.SwitchCanChangeStatusAction;
import com.mirea.trpp.project.ui.action.room.TotalNumberOfFreeRoomsAction;

import java.util.Collections;

public class Builder {
    private Menu rootMenu = new Menu();
    private Menu roomSectionMenu = new Menu();
    private Menu guestSectionMenu = new Menu();
    private Menu maintenanceSectionMenu = new Menu();
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;
    private CsvController csvController;

    public Builder(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController, CsvController csvController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
        this.csvController = csvController;
    }

    public void buildMenus() {
        rootMenu.setName("������� ����");
        Collections.addAll(rootMenu.getMenuItems(),
                new MenuItem("1) ������ �������", null, roomSectionMenu),
                new MenuItem("2) ������ ������", null, guestSectionMenu),
                new MenuItem("3) ������ �����", null, maintenanceSectionMenu),
                new MenuItem("4) ��������� � �����", null, null));

        roomSectionMenu.setName("������ �������");
        Collections.addAll(roomSectionMenu.getMenuItems(),
                new MenuItem("1) ������� �����", new CreateRoomAction(roomController), null),
                new MenuItem("2) �������� ����� � �����", new AddToRoomAction(roomController), null),
                new MenuItem("3) ������� ������ �� ������", new DeleteFromRoomAction(roomController), null),
                new MenuItem("4) �������� ������ ������", new ChangeStatusAction(roomController), null),
                new MenuItem("5) �������� ���� ������", new ChangePriceToRoomAction(roomController), null),
                new MenuItem("6) �������� ����������� ������ ������ ������", new SwitchCanChangeStatusAction(roomController), null),
                new MenuItem("7) ������� ����� ���-�� ��������� �������", new TotalNumberOfFreeRoomsAction(roomController), null),
                new MenuItem("8) ������� ����� ���-�� ��������� ������� ����� ������������ ����", new ListOfFreeRoomsByDateAction(roomController), null),
                new MenuItem("9) ������� ��� ������ � ������������� ����", new GetAllRoomSortedByPriceByMaxGuestsByStarsAction(roomController), null),
                new MenuItem("10) ������� ��������� ������ � ������������� ����", new GetFreeRoomSortedByPriceByMaxGuestsByStarsAction(roomController), null),
                new MenuItem("11) ������� ��������� ���� ������ ������", new GetLastThreeGuestAction(roomController), null),
                new MenuItem("12) ������� ������� ������ ������", new GetRoomHistoryAction(roomController), null),
                new MenuItem("13) ������� ������ ������", new RoomDetailsAction(roomController), null),
                new MenuItem("14) ������� ������ � csv", new ExportRoomCsvAction(csvController), null),
                new MenuItem("15) ������ ������ �� csv", new ImportRoomCsvAction(csvController), null),
                new MenuItem("16) �����", null, rootMenu));

        guestSectionMenu.setName("������ ������");
        Collections.addAll(guestSectionMenu.getMenuItems(),
                new MenuItem("1) ������� �����", new DeleteGuestAction(guestController), null),
                new MenuItem("2) �������� ������ ��������� ��� �����", new GetTotalPriceForGuestAction(guestController), null),
                new MenuItem("3) ����� ����� ������", new TotalNumberOfGuestsAction(guestController), null),
                new MenuItem("4) ���������� ������", new GetGuestSortedByNameByEvicDateAction(guestController), null),
                new MenuItem("5) ������� ������ � csv", new ExportGuestCsvAction(csvController), null),
                new MenuItem("6) ������ ������ �� csv", new ImportGuestsCsvAction(csvController), null),
                new MenuItem("7) �����", null, rootMenu));

        maintenanceSectionMenu.setName("������ �����");
        Collections.addAll(maintenanceSectionMenu.getMenuItems(),
                new MenuItem("1) �������� ������", new CreateMaintenanceAction(maintenanceController), null),
                new MenuItem("2) �������� ���� ������", new ChangePriceToMaintenanceAction(maintenanceController), null),
                new MenuItem("3) �������� ����� ������", new AddMaintenanceToGuestAction(maintenanceController), null),
                new MenuItem("4) ��� ������", new PrintAllMaintenanceAction(maintenanceController), null),
                new MenuItem("5) ���������� �����", new GetMaintenanceSortedByPriceAction(maintenanceController), null),
                new MenuItem("6) ���������� ����� �����", new GetMaintenanceForGuestSortedByPriceByDateAction(maintenanceController), null),
                new MenuItem("7) ������� ����� � csv", new ExportMaintenanceCsvAction(csvController), null),
                new MenuItem("8) ������ ����� �� csv", new ImportMaintenancesCsvAction(csvController), null),
                new MenuItem("9) �����", null, rootMenu));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Menu getRoomSectionMenu() {
        return roomSectionMenu;
    }

    public Menu getGuestSectionMenu() {
        return guestSectionMenu;
    }

    public Menu getMaintenanceSectionMenu() {
        return maintenanceSectionMenu;
    }
}
