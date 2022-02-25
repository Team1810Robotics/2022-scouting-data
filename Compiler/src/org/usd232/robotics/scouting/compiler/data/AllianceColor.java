package org.usd232.robotics.scouting.compiler.data;

/**
 * Enum of alliance colors.
 *
 * @author Michael Sheehan
 *
 */
public enum AllianceColor {
    RED( 0, "Red" ), BLUE( 1, "Blue" );

    private final String label;
    private final int index;

    AllianceColor( final int index, final String label ) {
        this.label = label;
        this.index = index;
    }

    public static AllianceColor forIndex( final int indexIn ) {
        for ( AllianceColor val : AllianceColor.values() ) {
            if ( val.index == indexIn ) {
                return val;
            }
        }

        return null;
    }

    public static AllianceColor forLabel( final String valIn ) {
        for ( AllianceColor val : AllianceColor.values() ) {
            if ( val.label.equalsIgnoreCase(valIn) ) {
                return val;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return label;
    }

    public int getIndex() {
        return index;
    }
}
