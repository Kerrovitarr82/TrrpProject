package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

public class AddToRoomAction implements IAction {
    private RoomController roomController;

    public AddToRoomAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.addToRoom();
    }
}
