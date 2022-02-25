package org.usd232.robotics.scouting.compiler.data.dao;

/**
 * Header enum used to populate CSV file header.
 *
 * @author Michael Sheehan
 *
 */
public enum HeaderEnum {
    MatchId( "Match Id" ), TeamId( "Team Id" ), AllianceColor( "Alliance Color" ), StartupBalls( "Startup Balls" ),
    ScouterName("Scouter Name"), PassedAutoLine( "Passed Auto Line" ), AutoPowerCellsLower( "Auto Power Cells Lower" ),
    AutoPowerCellsOuter( "Auto Power Cells Outer" ), AutoPowerCellsInner( "Auto Power Cells Inner" ),
    TeleopPowerCellsLower( "Teleop Power Cells Lower" ), TeleopPowerCellsOuter( "Teleop Power Cells Outer" ),
    TeleopPowerCellsInner( "Teleop Power Cells Inner" ), TeleopCanSpinWheel( "Can Spin Wheel" ),
    TeleopCanChooseCorrectColor( "Can Choose Correct Color" ), TeleopCanTrench( "Can Go Through Trench"),
    TeleopCanBar("Can Go Over bar"), TeleopCanPickupBalls("Can Pickup Balls Off Ground"), TeleopStageReached( "Stage Reached" ),
    GrabBarPosition( "Grab Bar Position" ), Won( "Won" );

    private final String value;

    HeaderEnum( final String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
