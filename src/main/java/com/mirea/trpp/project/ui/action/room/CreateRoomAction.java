package com.mirea.trpp.project.ui.action.room;

import com.mirea.trpp.project.controller.RoomController;
import com.mirea.trpp.project.ui.action.IAction;

import java.io.IOException;

public class CreateRoomAction implements IAction {
    private RoomController roomController;

    public CreateRoomAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws IOException {
        roomController.createRoom();
    }
}
