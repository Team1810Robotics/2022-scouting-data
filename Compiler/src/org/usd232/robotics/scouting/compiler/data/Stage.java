package org.usd232.robotics.scouting.compiler.data;

public enum Stage {
    ZERO( "Zero", 0 ), ONE( "One", 1 ), TWO( "Two", 2 ), THREE( "Three", 3 );

    private final String label;
    private final int index;

    Stage( final String label, final int index ) {
        this.label = label; this.index = index;
    }

    public static final Stage fromValue( String valIn ) {
        for ( Stage val : Stage.values() ) {
            if ( val.label.equalsIgnoreCase( valIn ) ) {
                return val;
            }
        }

        return null;
    }

    public static final Stage fromIndex( int valIn ) {
        for ( Stage val : Stage.values() ) {
            if ( val.index == valIn ) {
                return val;
            }
        }

        return null;
    }

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }
}
