package org.usd232.robotics.scouting.importer.csv;

public enum HeaderEnum {
    MatchId( "Match Id" ), TeamId( "Team Id" ), StartingLevel( "Starting Level" ),
    StartingGamePiece( "Starting Game Piece" ), SsLeftPlatform( "Sandstorm Left Platform" ),
    SsCargoshipHatches( "Sandstorm CargoShip Hatches" ), SsCargoshipBalls( "Sandstorm CargoShip Balls" ),
    SsRocket1Hatches( "Sandstorm Rocket Level 1 Hatches" ), SsRocket1Balls( "Sandstorm Rocket Level 1 Balls" ),
    SsRocket2Hatches( "Sandstorm Rocket Level 2 Hatches" ), SsRocket2Balls( "Sandstorm Rocket Level 2 Balls" ),
    SsRocket3Hatches( "Sandstorm Rocket Level 3 Hatches" ), SsRocket3Balls( "Sandstorm Rocket Level 3 Balls" ),
    TeleCargoshipHatches( "Teleop CargoShip Hatches" ), TeleCargoshipBalls( "Teleop CargoShip Balls" ),
    TeleRocket1Hatches( "Teleop Rocket Level 1 Hatches" ), TeleRocket1Balls( "Teleop Rocket Level 1 Balls" ),
    TeleRocket2Hatches( "Teleop Rocket Level 2 Hatches" ), TeleRocket2Balls( "Teleop Rocket Level 2 Balls" ),
    TeleRocket3Hatches( "Teleop Rocket Level 3 Hatches" ), TeleRocket3Balls( "Teleop Rocket Level 3 Balls" ),
    EndingLevel( "Ending Level" ), WonMatch( "Won Match" ), GoodAtStationHatches( "Good At Station Hatches" ),
    GoodAtFloorHatches( "Good At Floor Hatches" ), GoodAtStationBalls( "Good At Station Balls" ),
    GoodAtFloorBalls( "Good At Floor Balls" ), GeneralComments( "General Comments" );
    private final String value;

    HeaderEnum( final String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
