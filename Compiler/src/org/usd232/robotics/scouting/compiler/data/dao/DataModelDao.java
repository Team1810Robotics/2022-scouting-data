package org.usd232.robotics.scouting.compiler.data.dao;

import java.io.IOException;
import java.util.Map;

import org.usd232.robotics.scouting.compiler.data.DataModel;
import org.usd232.robotics.scouting.compiler.data.DataModelKey;

/**
 * Data Model DAO Interface.
 *
 * @author Michael Sheehan
 *
 */
public interface DataModelDao {
    /**
     * Read all the data models from the data store in order.
     *
     * @return Map of data model keys and corresponding data.
     * @throws IOException Thrown on error.
     */
    Map<DataModelKey, DataModel> readDataModels() throws IOException;

    /**
     * Add a new record to the data store.
     *
     * @param data Data for the new record.
     * @throws IOException Thrown on error.
     */
    void appendDataModel( DataModel data ) throws IOException;

    /**
     * Deletes all the existing data in the data store.
     *
     * @throws IOException Thrown on error.
     */
    void deleteAllDataModels() throws IOException;
}
