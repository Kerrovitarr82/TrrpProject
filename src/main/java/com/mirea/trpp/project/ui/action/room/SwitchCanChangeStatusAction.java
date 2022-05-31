package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

import java.io.IOException;

public class SwitchCanChangeStatusAction implements IAction {
    private RoomController roomController;

    public SwitchCanChangeStatusAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws IOException {
        roomController.switchCanChangeStatus();
    }
}
