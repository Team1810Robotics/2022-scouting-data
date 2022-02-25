package org.usd232.robotics.scouting.importer.model;

/**
 * The levels that a robot can end the match on.
 *
 * @since 2019
 */
public enum EndingLevel {
    None( "None", 0 ), Bottom( "Bottom", 1 ), Middle( "Middle", 2 ), Top( "Top", 3 );

    private final String theLevel;
    private final int index;

    EndingLevel( final String aLevel, final int anIndex ) {
        theLevel = aLevel;
        index = anIndex;
    }

    public static EndingLevel forIndex( final int indexIn ) {
        for ( EndingLevel currLevel : EndingLevel.values() ) {
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
