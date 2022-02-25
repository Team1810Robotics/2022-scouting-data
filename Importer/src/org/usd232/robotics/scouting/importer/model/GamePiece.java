package org.usd232.robotics.scouting.importer.model;

/**
 * The game pieces for this year.
 *
 * @since 2019
 */
public enum GamePiece {
    None( "None", 0 ), Ball( "Ball", 1 ), Hatch( "Hatch", 2 );

    private final String thePiece;
    private final int index;

    GamePiece( final String aPiece, final int anIndex ) {
        thePiece = aPiece;
        index = anIndex;
    }

    public static GamePiece forIndex( final int indexIn ) {
        for ( GamePiece currPiece : GamePiece.values() ) {
            if ( currPiece.index == indexIn ) {
                return currPiece;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return thePiece;
    }

    public int getIndex() {
        return index;
    }
}
