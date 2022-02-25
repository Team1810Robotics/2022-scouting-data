package org.usd232.robotics.scouting.importer.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.usd232.robotics.scouting.importer.model.DataModel;
import org.usd232.robotics.scouting.importer.model.DataModelKey;
import org.usd232.robotics.scouting.importer.model.EndingLevel;
import org.usd232.robotics.scouting.importer.model.GamePiece;
import org.usd232.robotics.scouting.importer.model.StartingLevel;
import org.usd232.robotics.scouting.importer.model.Utils;

public class DataReader implements ReaderInterface {
    @SuppressWarnings("deprecation")
	private static final CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(HeaderEnum.class).withTrim()
                    .withIgnoreEmptyLines();

    public Map<DataModelKey, DataModel> readDataModels(final File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("Could not find file '" + file.getAbsolutePath() + "'.");
        }
        final Map<DataModelKey, DataModel> rVal = new TreeMap<>();
        try (final Reader reader = new FileReader(file);
                        @SuppressWarnings("deprecation")
						final CSVParser csvParser = new CSVParser(reader, csvFormat.withSkipHeaderRecord())) {
            System.out.println("Starting to read data from " + file.getAbsolutePath() + ".");
            for (final CSVRecord rec : csvParser) {
                final DataModelKey key = new DataModelKey();
                key.setMatchID(Utils.toInt(rec.get(0)));
                key.setTeamID(Utils.toInt(rec.get(1)));
                final DataModel data = new DataModel();
                int pos = 0;
                data.setMatchID(Utils.toInt(rec.get(pos++)));
                data.setTeamID(Utils.toInt(rec.get(pos++)));
                data.setStartingLevel(StartingLevel.valueOf(rec.get(pos++)));
                data.setStartingPiece(GamePiece.valueOf(rec.get(pos++)));
                data.setLeftPlatform(Boolean.valueOf(rec.get(pos++)));
                data.setSandstormCargoHatches(Utils.toInt(rec.get(pos++)));
                data.setSandstormCargoBalls(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket1Hatches(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket1Balls(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket2Hatches(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket2Balls(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket3Hatches(Utils.toInt(rec.get(pos++)));
                data.setSandstormRocket3Balls(Utils.toInt(rec.get(pos++)));
                data.setTeleopCargoHatches(Utils.toInt(rec.get(pos++)));
                data.setTeleopCargoBalls(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket1Hatches(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket1Balls(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket2Hatches(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket2Balls(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket3Hatches(Utils.toInt(rec.get(pos++)));
                data.setTeleopRocket3Balls(Utils.toInt(rec.get(pos++)));
                data.setEndingLevel(EndingLevel.valueOf(rec.get(pos++)));
                data.setWonMatch(Boolean.valueOf(rec.get(pos++)));
                data.setHatchesFromStation(Boolean.valueOf(rec.get(pos++)));
                data.setHatchesFromGround(Boolean.valueOf(rec.get(pos++)));
                data.setBallsFromStation(Boolean.valueOf(rec.get(pos++)));
                data.setBallsFromGround(Boolean.valueOf(rec.get(pos++)));
                data.setGeneralComments(rec.get(pos++));
                rVal.put(key, data);
                System.out.println("Read data for Team " + data.getTeamID() + ", Match " + data.getMatchID());
            }
        }
        return rVal;
    }
}