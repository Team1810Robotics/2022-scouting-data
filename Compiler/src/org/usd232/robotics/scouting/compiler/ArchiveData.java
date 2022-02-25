package org.usd232.robotics.scouting.compiler;

import java.io.File;

/**
 * Archive data action class.
 *
 * @author Michael Sheehan
 */
public final class ArchiveData {
    /**
     * Move new data files to archive folder.
     *
     * @param newDataFolderPath Path where new folder data files exists.
     * @param oldDataFolderPath Path where archive data files should be moved to.
     * @return 0 if successful, some other number otherwise.
     */
    public static int archiveTheData( final String newDataFolderPath, final String oldDataFolderPath ) {
        final File[] listOfFiles = new File( newDataFolderPath ).listFiles();
        if ( listOfFiles != null && listOfFiles.length > 0 ) {
            for ( final File file : listOfFiles ) {
                try {
                    if ( file.isFile() ) {
                        file.renameTo( new File( oldDataFolderPath + File.separatorChar + file.getName() ) );
                        file.delete();
                    }
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                    return -1;
                }
            }
        }

        return 0;
    }

    private ArchiveData() {
    }
}
