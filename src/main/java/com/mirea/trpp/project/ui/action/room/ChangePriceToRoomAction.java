package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

public class ChangePriceToRoomAction implements IAction {
    private RoomController roomController;

    public ChangePriceToRoomAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.changePriceToRoom();
    }
}
