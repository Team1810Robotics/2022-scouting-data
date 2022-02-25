package org.usd232.robotics.scouting.importer.model;

/**
 * The levels that a robot can start the match on.
 *
 * @since 2019
 */
public enum StartingLevel {
    Bottom( "Bottom", 1 ), Middle( "Middle", 2 );

    private final String theLevel;
    private final int index;

    StartingLevel( final String aLevel, final int anIndex ) {
        theLevel = aLevel;
        index = anIndex;
    }

    public static StartingLevel forIndex( final int indexIn ) {
        for ( StartingLevel currLevel : StartingLevel.values() ) {
            if ( currLevel.index == indexIn ) {
                return currLevel;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return theLevel;
    }

    public int getIndex() {
        return index;
    }
}
