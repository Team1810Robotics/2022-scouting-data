package org.usd232.robotics.scouting.compiler.data;

/**
 * Bar position Enum
 *
 * @author Michael Sheehan
 */
public enum BarGrabPosition {
    NONE( "None" ), ANGLED_HIGH( "High" ), MIDDLE( "Balanced" );

    private final String barLabel;

    BarGrabPosition( final String barLabel ) {
        this.barLabel = barLabel;
    }

    public static final BarGrabPosition fromValue( final String valIn ) {
        for ( BarGrabPosition val : BarGrabPosition.values() ) {
            if ( val.barLabel.equalsIgnoreCase( valIn ) ) {
                return val;
            }
        }

        return null;
    }

    public String getLabel() {
        return barLabel;
    }

    @Override
    public String toString() {
        return barLabel;
    }
}
