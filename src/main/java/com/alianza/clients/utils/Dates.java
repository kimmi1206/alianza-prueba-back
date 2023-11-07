package com.alianza.clients.utils;

import java.time.LocalDate;
import java.time.ZoneId;

public class Dates {

    public static LocalDate getCurrentDate(){
        return LocalDate.now(ZoneId.of("America/Bogota"));
    }
}
