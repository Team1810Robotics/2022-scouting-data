package org.usd232.robotics.scouting.importer.model;

public class DataModelKey extends BaseDto implements Comparable<DataModelKey> {
    /**
     * The match number.
     *
     * @since 2019
     */
    private int matchID;
    /**
     * The team number
     *
     * @since 2019
     */
    private int teamID;

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(final int matchID) {
        this.matchID = matchID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(final int teamID) {
        this.teamID = teamID;
    }

    @Override
    public int compareTo(final DataModelKey other) {
        if (other == null) {
            return 1;
        }
        if (this.teamID == other.teamID) {
            return this.matchID - other.matchID;
        }
        return this.teamID - other.teamID;
    }
}
