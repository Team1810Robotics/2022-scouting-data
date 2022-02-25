package org.usd232.robotics.scouting.importer.model;

/**
 * The class of variables where we store all of our data in.
 */
public class DataModel extends BaseDto {
    //Data for startup screen
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
    /**
     * The starting game piece
     *
     * @since 2019
     */
    private GamePiece startingPiece;
    /**
     * The starting platform level
     *
     * @since 2019
     */
    private StartingLevel startingLevel;

    //Data for sandstorm screen
    /**
     * The amount of balls that the robot puts into the cargo ship during autonomous.
     *
     * @since 2019
     */
    private int sandstormCargoBalls;
    /**
     * The amount of balls that the robot puts into the bottom level of the rocket during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket1Balls;
    /**
     * The amount of balls that the robot puts into the middle level of the rocket during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket2Balls;
    /**
     * The amount of balls that the robot puts into the top level of the rocket during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket3Balls;
    /**
     * The amount of hatches that the robot puts into the cargo ship during autonomous.
     *
     * @since 2019
     */
    private int sandstormCargoHatches;
    /**
     * The amount of hatches that the robot puts into the bottom of the rocket ship during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket1Hatches;
    /**
     * The amount of hatches that the robot puts into the middle of the rocket ship during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket2Hatches;
    /**
     * The amount of hatches that the robot puts into the middle of the rocket ship during autonomous.
     *
     * @since 2019
     */
    private int sandstormRocket3Hatches;
    /**
     * Whether or not the robot left the starting platform during autonomous
     *
     * @since 2019
     */
    private boolean leftPlatform;

    //Data for teleop screen
    /**
     * The amount of balls that the robot puts into the cargo ship during teleop.
     *
     * @since 2019
     */
    private int teleopCargoBalls;
    /**
     * The amount of balls that the robot puts into the bottom of the rocket ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket1Balls;
    /**
     * The amount of balls that the robot puts into the middle of the rocket ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket2Balls;
    /**
     * The amount of balls that the robot puts into the top of the rocket ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket3Balls;
    /**
     * The amount of hatches that the robot puts into the cargo ship during teleop.
     *
     * @since 2019
     */
    private int teleopCargoHatches;
    /**
     * The amount of hatches that the robot puts into the bottom of the rocket ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket1Hatches;
    /**
     * The amount of hatches that the robot puts into the middle of the rocket ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket2Hatches;
    /**
     * The amount of hatches that the robot puts into the bottom of the cargo ship during teleop.
     *
     * @since 2019
     */
    private int teleopRocket3Hatches;
    /**
     * The level that the robot ends the match on.
     *
     * @since 2019
     */
    private EndingLevel endingLevel;

    //Data for comments screen;
    /**
     * Whether or not the robot won the match.
     *
     * @since 2019
     */
    private boolean wonMatch;
    /**
     * Whether or not the robot can pick balls up off of the ground.
     *
     * @since 2019
     */
    private boolean ballsFromGround;
    /**
     * Whether or not the robot can pick balls up from the station.
     *
     * @since 2019
     */
    private boolean ballsFromStation;
    /**
     * Whether or not the robot can pick hatches up off of the ground.
     *
     * @since 2019
     */
    private boolean hatchesFromGround;
    /**
     * Whether or not the robot can pick hatches up from the station.
     *
     * @since 2019
     */
    private boolean hatchesFromStation;
    /**
     * General user-entered comments.
     *
     * @since 2019
     */
    private String generalComments;

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID( int matchID ) {
        this.matchID = matchID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID( int teamID ) {
        this.teamID = teamID;
    }

    public GamePiece getStartingPiece() {
        return startingPiece;
    }

    public void setStartingPiece( GamePiece piece ) {
        this.startingPiece = piece;
    }

    public StartingLevel getStartingLevel() {
        return startingLevel;
    }

    public void setStartingLevel( StartingLevel startingLevel ) {
        this.startingLevel = startingLevel;
    }

    public int getSandstormCargoBalls() {
        return sandstormCargoBalls;
    }

    public void setSandstormCargoBalls( int sandstormCargoBalls ) {
        this.sandstormCargoBalls = sandstormCargoBalls;
    }

    public int getSandstormRocket1Balls() {
        return sandstormRocket1Balls;
    }

    public void setSandstormRocket1Balls( int sandstormRocket1Balls ) {
        this.sandstormRocket1Balls = sandstormRocket1Balls;
    }

    public int getSandstormRocket2Balls() {
        return sandstormRocket2Balls;
    }

    public void setSandstormRocket2Balls( int sandstormRocket2Balls ) {
        this.sandstormRocket2Balls = sandstormRocket2Balls;
    }

    public int getSandstormRocket3Balls() {
        return sandstormRocket3Balls;
    }

    public void setSandstormRocket3Balls( int sandstormRocket3Balls ) {
        this.sandstormRocket3Balls = sandstormRocket3Balls;
    }

    public int getSandstormCargoHatches() {
        return sandstormCargoHatches;
    }

    public void setSandstormCargoHatches( int sandstormCargoHatches ) {
        this.sandstormCargoHatches = sandstormCargoHatches;
    }

    public int getSandstormRocket1Hatches() {
        return sandstormRocket1Hatches;
    }

    public void setSandstormRocket1Hatches( int sandstormRocket1Hatches ) {
        this.sandstormRocket1Hatches = sandstormRocket1Hatches;
    }

    public int getSandstormRocket2Hatches() {
        return sandstormRocket2Hatches;
    }

    public void setSandstormRocket2Hatches( int sandstormRocket2Hatches ) {
        this.sandstormRocket2Hatches = sandstormRocket2Hatches;
    }

    public int getSandstormRocket3Hatches() {
        return sandstormRocket3Hatches;
    }

    public void setSandstormRocket3Hatches( int sandstormRocket3Hatches ) {
        this.sandstormRocket3Hatches = sandstormRocket3Hatches;
    }

    public boolean isLeftPlatform() {
        return leftPlatform;
    }

    public void setLeftPlatform( boolean leftPlatform ) {
        this.leftPlatform = leftPlatform;
    }

    public int getTeleopCargoBalls() {
        return teleopCargoBalls;
    }

    public void setTeleopCargoBalls( int teleopCargoBalls ) {
        this.teleopCargoBalls = teleopCargoBalls;
    }

    public int getTeleopRocket1Balls() {
        return teleopRocket1Balls;
    }

    public void setTeleopRocket1Balls( int teleopRocket1Balls ) {
        this.teleopRocket1Balls = teleopRocket1Balls;
    }

    public int getTeleopRocket2Balls() {
        return teleopRocket2Balls;
    }

    public void setTeleopRocket2Balls( int teleopRocket2Balls ) {
        this.teleopRocket2Balls = teleopRocket2Balls;
    }

    public int getTeleopRocket3Balls() {
        return teleopRocket3Balls;
    }

    public void setTeleopRocket3Balls( int teleopRocket3Balls ) {
        this.teleopRocket3Balls = teleopRocket3Balls;
    }

    public int getTeleopCargoHatches() {
        return teleopCargoHatches;
    }

    public void setTeleopCargoHatches( int teleopCargoHatches ) {
        this.teleopCargoHatches = teleopCargoHatches;
    }

    public int getTeleopRocket1Hatches() {
        return teleopRocket1Hatches;
    }

    public void setTeleopRocket1Hatches( int teleopRocket1Hatches ) {
        this.teleopRocket1Hatches = teleopRocket1Hatches;
    }

    public int getTeleopRocket2Hatches() {
        return teleopRocket2Hatches;
    }

    public void setTeleopRocket2Hatches( int teleopRocket2Hatches ) {
        this.teleopRocket2Hatches = teleopRocket2Hatches;
    }

    public int getTeleopRocket3Hatches() {
        return teleopRocket3Hatches;
    }

    public void setTeleopRocket3Hatches( int teleopRocket3Hatches ) {
        this.teleopRocket3Hatches = teleopRocket3Hatches;
    }

    public EndingLevel getEndingLevel() {
        return endingLevel;
    }

    public void setEndingLevel( EndingLevel endingLevel ) {
        this.endingLevel = endingLevel;
    }

    public boolean isWonMatch() {
        return wonMatch;
    }

    public void setWonMatch( boolean wonMatch ) {
        this.wonMatch = wonMatch;
    }

    public boolean isBallsFromGround() {
        return ballsFromGround;
    }

    public void setBallsFromGround( boolean ballsFromGround ) {
        this.ballsFromGround = ballsFromGround;
    }

    public boolean isBallsFromStation() {
        return ballsFromStation;
    }

    public void setBallsFromStation( boolean ballsFromStation ) {
        this.ballsFromStation = ballsFromStation;
    }

    public boolean isHatchesFromGround() {
        return hatchesFromGround;
    }

    public void setHatchesFromGround( boolean hatchesFromGround ) {
        this.hatchesFromGround = hatchesFromGround;
    }

    public boolean isHatchesFromStation() {
        return hatchesFromStation;
    }

    public void setHatchesFromStation( boolean hatchesFromStation ) {
        this.hatchesFromStation = hatchesFromStation;
    }

    public String getGeneralComments() {
        return generalComments;
    }

    public void setGeneralComments( String generalComments ) {
        this.generalComments = generalComments;
    }
}