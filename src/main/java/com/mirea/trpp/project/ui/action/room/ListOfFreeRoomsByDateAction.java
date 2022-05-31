package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

import java.text.ParseException;

public class ListOfFreeRoomsByDateAction implements IAction {
    private RoomController roomController;

    public ListOfFreeRoomsByDateAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws ParseException {
        roomController.listOfFreeRoomsByDate();
    }
}
