package org.usd232.robotics.scouting.importer;

import java.io.File;
import java.util.Map;

import org.usd232.robotics.scouting.importer.csv.DataReader;
import org.usd232.robotics.scouting.importer.csv.ReaderInterface;
import org.usd232.robotics.scouting.importer.db.DatabaseWriter;
import org.usd232.robotics.scouting.importer.db.WriterInterface;
import org.usd232.robotics.scouting.importer.model.DataModel;
import org.usd232.robotics.scouting.importer.model.DataModelKey;

public class Main {
	private static final String filePath = System.getProperty("user.home") + "/Desktop/ScoutingData/MasterData.csv";
	public static void main(String[] args) {
		try {
			final File file = new File(filePath);
			final ReaderInterface reader = new DataReader();
			final Map<DataModelKey, DataModel> dataMap = reader.readDataModels(file);
			System.out.println("There are " + dataMap.size() + " data sets to write. Starting to write them.");
			final WriterInterface writer = new DatabaseWriter();
			writer.writeData(dataMap);
			System.out.println("Finished writing all data to the database");
		} catch(final Exception e) {
			e.printStackTrace();
		}
	}
}
