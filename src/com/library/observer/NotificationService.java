package com.library.observer;

import com.library.model.Reservation;

public class NotificationService implements Observer {

    @Override
    public void update(Reservation reservation) {
        System.out.println(
                "🔔 Book '" +
                        reservation.getBook().getTitle() +
                        "' is available for " +
                        reservation.getPatron().getName()
        );
    }
}