package org.usd232.robotics.scouting.compiler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.usd232.robotics.scouting.compiler.data.DataModel;
import org.usd232.robotics.scouting.compiler.data.DataModelKey;
import org.usd232.robotics.scouting.compiler.data.dao.DataModelDao;
import org.usd232.robotics.scouting.compiler.data.dao.DataModelDaoImpl;

/**
 * Read data action class.
 *
 * @author Michael Sheehan
 */
public final class ReadData {
    /**
     * Read the new data items, merge into existing master file (if any), and return value indicating success or
     * failure.
     *
     * @param newDataFolderPath Path to folder where new data files can be found.
     * @param dataDao           Data DAO to write new elements to.
     * @return 0 if all worked well another number if failure.
     * @since 2019
     */
    public static int readNewData( final String newDataFolderPath, final DataModelDao masterDataDao ) {
        try {
            final File[] listOfFiles = new File( newDataFolderPath ).listFiles();
            if ( listOfFiles != null && listOfFiles.length > 0 ) {
                // Read all entries from all files in new data folder into memoery.
                final Map<DataModelKey, DataModel> dataModelMap = new HashMap<>();
                for ( final File currFile : listOfFiles ) {
                    if ( currFile.isFile() ) {
                        dataModelMap.putAll( new DataModelDaoImpl( currFile ).readDataModels() );
                    }
                }

                // Copy new entries into the master data file.
                for ( final Map.Entry<DataModelKey, DataModel> entry : dataModelMap.entrySet() ) {
                    masterDataDao.appendDataModel( entry.getValue() );
                }
            }
        }
        catch ( final Exception e ) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    /**
     * Reads the master data file and returns it as a Map with DataModelKeys and Data Models.
     *
     * @param dataDao Data DAO to read with.
     * @return Data as a Map<DataModelKey, DataModel>.
     * @since 2019
     */
    public static Map<DataModelKey, DataModel> readMasterData( final DataModelDao dataDao ) {
        try {
            return dataDao.readDataModels();
        }
        catch ( final Exception e ) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }

    private ReadData() {
    }
}
