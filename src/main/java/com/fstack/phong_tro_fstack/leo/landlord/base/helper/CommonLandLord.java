package com.fstack.phong_tro_fstack.leo.landlord.base.helper;

import java.util.Date;

public class CommonLandLord {
    public static Date getCurrenDate() {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        return date;
    }
}
