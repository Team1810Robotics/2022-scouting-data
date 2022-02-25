package org.usd232.robotics.scouting.compiler.data;

import org.apache.commons.csv.CSVRecord;

/**
 * Utility class.
 *
 * @author Michael Sheehan
 */
public final class Utils {
    private Utils() {
    }

    /**
     * Convert a column of a record to an int.
     *
     * @param rec Record to read from.
     * @param pos Column to read (as String) and convert to an int.
     * @return int value.
     */
    public static int toInt( final CSVRecord rec, final int pos ) {
        int rVal = 0;
        try {
            rVal = Integer.parseInt( rec.get( pos ) );
        }
        catch ( final Throwable e ) {
            e.printStackTrace();
        }

        return rVal;
    }
}
