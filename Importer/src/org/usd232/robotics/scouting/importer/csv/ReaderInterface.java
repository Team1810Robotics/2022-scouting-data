/**
 *
 */
package org.usd232.robotics.scouting.importer.csv;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.usd232.robotics.scouting.importer.model.DataModel;
import org.usd232.robotics.scouting.importer.model.DataModelKey;

/**
 *
 */
public interface ReaderInterface {
    Map<DataModelKey, DataModel> readDataModels( File file ) throws IOException;
}
