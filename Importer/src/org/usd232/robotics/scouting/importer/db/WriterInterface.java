/**
 *
 */
package org.usd232.robotics.scouting.importer.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import org.usd232.robotics.scouting.importer.model.DataModel;
import org.usd232.robotics.scouting.importer.model.DataModelKey;

/**
 *
 */
public interface WriterInterface {
    void writeData( Map<DataModelKey, DataModel> data ) throws IOException, SQLException;
}
