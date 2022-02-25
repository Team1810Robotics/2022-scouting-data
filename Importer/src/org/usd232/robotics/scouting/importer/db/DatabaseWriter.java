/**
 *
 */
package org.usd232.robotics.scouting.importer.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import org.usd232.robotics.scouting.importer.model.DataModel;
import org.usd232.robotics.scouting.importer.model.DataModelKey;

/**
 * @author Connor
 */
public class DatabaseWriter implements WriterInterface {
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/scouting_2019?useUnicode=true&characterEncoding=UTF-8&user=root&password=";

    public DatabaseWriter() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see org.usd232.robotics.scouting.importer.db.WriterInterface#writeData(java.util. Map)
     */
    @Override
    public void writeData(Map<DataModelKey, DataModel> data) throws IOException, SQLException {
        try (final Connection conn = DriverManager.getConnection(connectionUrl)) {
            final String deleteStatement = "DELETE FROM rawdata";
            try (final PreparedStatement preparedStatement = conn.prepareStatement(deleteStatement)) {
                System.out.println("Deleted " + preparedStatement.executeUpdate() + " rows.");
            }
            int piece = 1;
            for (final DataModel currentValue : data.values()) {
                writeDataModel(conn, currentValue);
                System.out.println("Wrote Entry " + piece++ + " of " + data.size() + " : Team " + currentValue.getTeamID()
                                + ", Match " + currentValue.getMatchID() );
            }
        }
    }

    private void writeDataModel(final Connection conn, final DataModel currentValue) throws SQLException {
        final String insertStatement = "INSERT INTO rawdata (MatchID, TeamID, DataPointID, Value) VALUES (?, ?, ?, ?)";
        try (final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {
            preparedStatement.setInt(1, currentValue.getMatchID());
            preparedStatement.setInt(2, currentValue.getTeamID());
            preparedStatement.setInt(3, 3);
            preparedStatement.setString(4, currentValue.getStartingPiece().toString());
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 4);
            preparedStatement.setString(4, currentValue.getStartingLevel().toString());
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 5);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormCargoBalls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 6);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket1Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 7);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket2Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 8);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket3Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 9);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormCargoHatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket1Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 11);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket2Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 12);
            preparedStatement.setString(4, Integer.toString(currentValue.getSandstormRocket3Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 13);
            preparedStatement.setString(4, Boolean.toString(currentValue.isLeftPlatform()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 14);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopCargoBalls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 15);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket1Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 16);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket2Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 17);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket3Balls()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 18);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopCargoHatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 19);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket1Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 20);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket2Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 21);
            preparedStatement.setString(4, Integer.toString(currentValue.getTeleopRocket3Hatches()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 22);
            preparedStatement.setString(4, currentValue.getEndingLevel().toString());
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 23);
            preparedStatement.setString(4, Boolean.toString(currentValue.isWonMatch()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 24);
            preparedStatement.setString(4, Boolean.toString(currentValue.isBallsFromGround()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 25);
            preparedStatement.setString(4, Boolean.toString(currentValue.isBallsFromStation()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 26);
            preparedStatement.setString(4, Boolean.toString(currentValue.isHatchesFromGround()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 27);
            preparedStatement.setString(4, Boolean.toString(currentValue.isHatchesFromStation()));
            preparedStatement.addBatch();
            preparedStatement.setInt(3, 28);
            preparedStatement.setString(4, currentValue.getGeneralComments());
            preparedStatement.addBatch();
            final int[] results = preparedStatement.executeBatch();
            for (int i = 0; i < results.length; i++) {
                if (results[i] != 1) {
                    System.out.println("Row " + i + " of match " + currentValue.getMatchID() + " for team "
                                    + currentValue.getTeamID() + " not inserted.");
                }
            }
        }
    }
}
