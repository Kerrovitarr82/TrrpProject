package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

public class RoomDetailsAction implements IAction {
    private RoomController roomController;

    public RoomDetailsAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.roomDetails();
    }
}
