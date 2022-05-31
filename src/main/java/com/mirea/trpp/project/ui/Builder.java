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
        rootMenu.setName("Главное меню");
        Collections.addAll(rootMenu.getMenuItems(),
                new MenuItem("1) Раздел номеров", null, roomSectionMenu),
                new MenuItem("2) Раздел гостей", null, guestSectionMenu),
                new MenuItem("3) Раздел услуг", null, maintenanceSectionMenu),
                new MenuItem("4) Сохранить и выйти", null, null));

        roomSectionMenu.setName("Раздел номеров");
        Collections.addAll(roomSectionMenu.getMenuItems(),
                new MenuItem("1) Создать номер", new CreateRoomAction(roomController), null),
                new MenuItem("2) Добавить гостя в номер", new AddToRoomAction(roomController), null),
                new MenuItem("3) Удалить гостей из номера", new DeleteFromRoomAction(roomController), null),
                new MenuItem("4) Изменить статус номера", new ChangeStatusAction(roomController), null),
                new MenuItem("5) Изменить цену номера", new ChangePriceToRoomAction(roomController), null),
                new MenuItem("6) Изменить возможность менять статус номера", new SwitchCanChangeStatusAction(roomController), null),
                new MenuItem("7) Вывести общее кол-во свободных номеров", new TotalNumberOfFreeRoomsAction(roomController), null),
                new MenuItem("8) Вывести общее кол-во свободных номеров после определенной даты", new ListOfFreeRoomsByDateAction(roomController), null),
                new MenuItem("9) Вывести все номера в сортированном виде", new GetAllRoomSortedByPriceByMaxGuestsByStarsAction(roomController), null),
                new MenuItem("10) Вывести свободные номера в сортированном виде", new GetFreeRoomSortedByPriceByMaxGuestsByStarsAction(roomController), null),
                new MenuItem("11) Вывести последних трех гостей номера", new GetLastThreeGuestAction(roomController), null),
                new MenuItem("12) Вывести историю гостей номера", new GetRoomHistoryAction(roomController), null),
                new MenuItem("13) Вывести детали номера", new RoomDetailsAction(roomController), null),
                new MenuItem("14) Экспорт комнат в csv", new ExportRoomCsvAction(csvController), null),
                new MenuItem("15) Импорт комнат из csv", new ImportRoomCsvAction(csvController), null),
                new MenuItem("16) Выход", null, rootMenu));

        guestSectionMenu.setName("Раздел гостей");
        Collections.addAll(guestSectionMenu.getMenuItems(),
                new MenuItem("1) Удалить гостя", new DeleteGuestAction(guestController), null),
                new MenuItem("2) Получить полную стоимость для гостя", new GetTotalPriceForGuestAction(guestController), null),
                new MenuItem("3) Общее число гостей", new TotalNumberOfGuestsAction(guestController), null),
                new MenuItem("4) Сортировка гостей", new GetGuestSortedByNameByEvicDateAction(guestController), null),
                new MenuItem("5) Экспорт гостей в csv", new ExportGuestCsvAction(csvController), null),
                new MenuItem("6) Импорт гостей из csv", new ImportGuestsCsvAction(csvController), null),
                new MenuItem("7) Выход", null, rootMenu));

        maintenanceSectionMenu.setName("Раздел услуг");
        Collections.addAll(maintenanceSectionMenu.getMenuItems(),
                new MenuItem("1) Добавить услугу", new CreateMaintenanceAction(maintenanceController), null),
                new MenuItem("2) Поменять цену услуги", new ChangePriceToMaintenanceAction(maintenanceController), null),
                new MenuItem("3) Добавить гостю услугу", new AddMaintenanceToGuestAction(maintenanceController), null),
                new MenuItem("4) Все услуги", new PrintAllMaintenanceAction(maintenanceController), null),
                new MenuItem("5) Сортировка услуг", new GetMaintenanceSortedByPriceAction(maintenanceController), null),
                new MenuItem("6) Сортировка услуг гостя", new GetMaintenanceForGuestSortedByPriceByDateAction(maintenanceController), null),
                new MenuItem("7) Экспорт услуг в csv", new ExportMaintenanceCsvAction(csvController), null),
                new MenuItem("8) Импорт услуг из csv", new ImportMaintenancesCsvAction(csvController), null),
                new MenuItem("9) Выход", null, rootMenu));
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
