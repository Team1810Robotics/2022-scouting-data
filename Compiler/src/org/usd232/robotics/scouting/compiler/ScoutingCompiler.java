package org.usd232.robotics.scouting.compiler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.usd232.robotics.scouting.compiler.data.dao.DataModelDao;
import org.usd232.robotics.scouting.compiler.data.dao.DataModelDaoImpl;

/**
 * Scouting compiler command line program.
 *
 * @author Michael Sheehan
 */
public class ScoutingCompiler {
    private static final String USER_HOME_SYS_PROP = "user.home";
    private static final String NEW_DATA_FOLDER_PATH
        = System.getProperty( USER_HOME_SYS_PROP ) + "/Desktop/ScoutingData/New Data/";
    private static final String OLD_DATA_FOLDER_PATH
        = System.getProperty( USER_HOME_SYS_PROP ) + "/Desktop/ScoutingData/Old Data/";
    private static final String MASTER_DATA_FILE_PATH
        = System.getProperty( USER_HOME_SYS_PROP ) + "/Desktop/ScoutingData/MasterData.csv";
    private static final DataModelDao masterDataDao = new DataModelDaoImpl( new File( MASTER_DATA_FILE_PATH ) );

    /**
     * Main entry point.
     *
     * @param args Input arguments - IGNORED.
     */
    public static void main( final String[] args ) {
        checkFolders();
        try ( final Scanner scanner = new Scanner( System.in ) ) {
            while ( true ) {
                System.out.println( "What Would You Like To Do?" );
                System.out.println( "1: Load New Data." );
                System.out.println( "2: Archive Data." );
                System.out.println( "9: Close Program." );

                int result = scanner.nextInt();
                switch ( result ) {
                    case 1:
                        if ( ReadData.readNewData( NEW_DATA_FOLDER_PATH, masterDataDao ) == 0 ) {
                            System.out.println( "New Data Successfully Loaded" );
                        }
                        else {
                            System.out.println( "New Data Failed To Load" );
                        }
                        break;
                    case 2:
                        if ( ArchiveData.archiveTheData( NEW_DATA_FOLDER_PATH, OLD_DATA_FOLDER_PATH ) == 0 ) {
                            System.out.println( "Data Has Successfully Been Archived" );
                        }
                        else {
                            System.out.println( "Data Failed To Be Archived" );
                        }
                        break;
                    case 9:
                        System.exit( 0 );
                        break;
                    default:
                        System.out.println( "Try a valid selection" );
                        break;
                }
            }
        }
    }

    private static void checkFolders() {
        final File newDataFolder = new File( NEW_DATA_FOLDER_PATH );
        if ( !newDataFolder.exists() ) {
            newDataFolder.mkdirs();
        }

        final File oldDataFolder = new File( OLD_DATA_FOLDER_PATH );
        if ( !oldDataFolder.exists() ) {
            oldDataFolder.mkdirs();
        }

        final File masterFile = new File( MASTER_DATA_FILE_PATH );
        if ( !masterFile.exists() ) {
            try {
                masterFile.createNewFile();
            }
            catch ( final IOException e ) {
                e.printStackTrace();
            }
        }
    }

    private ScoutingCompiler() {
    }
}
