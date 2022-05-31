package com.mirea.trpp.project.ui.action.guest;

import com.mirea.trpp.project.controller.GuestController;
import com.mirea.trpp.project.ui.action.IAction;

public class GetTotalPriceForGuestAction implements IAction {
    private GuestController guestController;

    public GetTotalPriceForGuestAction(GuestController guestController) {
        this.guestController = guestController;
    }

    @Override
    public void execute() {
        guestController.getTotalPriceForGuest();
    }
}
