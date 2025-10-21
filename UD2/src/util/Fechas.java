package util;

import java.sql.Date;

public class Fechas {
    public static Date parsearFecha(String cadenaFecha) {
        Date fecha = null;

        if (cadenaFecha != null && !cadenaFecha.isBlank()) {
            fecha = Date.valueOf(cadenaFecha);
        }

        return fecha;
    }
}
