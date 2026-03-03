package com.library.observer;

import com.library.model.Reservation;

public interface Observer {
    void update(Reservation reservation);
}