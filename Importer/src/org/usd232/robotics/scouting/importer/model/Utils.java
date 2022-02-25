package org.usd232.robotics.scouting.importer.model;

public final class Utils {
    private Utils() {
    }

    public static int toInt( final String val ) {
        int rVal = 1;
        try {
            rVal = Integer.parseInt( val );
        }
        catch ( final Throwable e ) {
            e.printStackTrace();
        }

        return rVal;
    }
}
