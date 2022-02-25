package org.usd232.robotics.scouting.compiler.data.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.BooleanUtils;
import org.usd232.robotics.scouting.compiler.data.AllianceColor;
import org.usd232.robotics.scouting.compiler.data.BarGrabPosition;
import org.usd232.robotics.scouting.compiler.data.DataModel;
import org.usd232.robotics.scouting.compiler.data.DataModelKey;
import org.usd232.robotics.scouting.compiler.data.Stage;
import org.usd232.robotics.scouting.compiler.data.Utils;
import org.usd232.robotics.scouting.compiler.data.TeamNumbers;


/**
 * DAO implementation that reads from and/or writes to a CSV file as its storage medium.
 *
 * @author Michael Sheehan
 */
public final class DataModelDaoImpl implements DataModelDao {
    private static final CSVFormat csvFormat
        = CSVFormat.DEFAULT.withHeader( HeaderEnum.class ).withTrim().withIgnoreEmptyLines();
    private final File csvFileLocation;

    /**
     * Constructor.
     *
     * @param fileLocation File to read/write location.
     */
    public DataModelDaoImpl( final File fileLocation ) {
        super();
        this.csvFileLocation = fileLocation;
    }

    private static void printDataModel( final DataModel data, final CSVPrinter csvPrinter ) throws IOException {
        csvPrinter.printRecord( data.getMatchID(), data.getTeamID() == null ? "null" : Integer.parseInt(data.getTeamID().toString()),
            data.getAllianceColor() == null ? "null" : data.getAllianceColor().toString(), data.getStartingBalls(),
            data.getScouterName() == null ? "null" : data.getScouterName(),
            BooleanUtils.toStringTrueFalse( data.isAutoPassedLine() ), data.getAutoNumPowerCellsLower(),
            data.getAutoNumPowerCellsOuter(), data.getAutoNumPowerCellsInner(), data.getTeleopNumPowerCellsLower(),
            data.getTeleopNumPowerCellsOuter(), data.getTeleopNumPowerCellsInner(),
            BooleanUtils.toStringTrueFalse( data.isTeleopCanSpinWheel() ),
            BooleanUtils.toStringTrueFalse( data.isTeleopColorCorrect() ),
            BooleanUtils.toStringTrueFalse( data.isTeleopTrenchCorrect() ),
            BooleanUtils.toStringTrueFalse( data.isTeleopBarCorrect() ),
            BooleanUtils.toStringTrueFalse( data.isTeleopBallPickupCorrect() ),
            data.getTeleopStageReached() == null ? "null" : data.getTeleopStageReached().getLabel(),
            data.getEndgameBarGrabPosition() == null ? "null" : data.getEndgameBarGrabPosition().getLabel(),
            BooleanUtils.toStringTrueFalse( data.isEndgameWon() ) );
    }

    private static DataModel readDataModel( final CSVRecord rec ) {
        final DataModel data = new DataModel();
        int pos = 0;
        data.setMatchID( Utils.toInt( rec, pos++ ) );
      //  data.setTeamID( TeamNumbers.fromValue( rec, pos++ ) );
        data.setAllianceColor( AllianceColor.forLabel( rec.get( pos++ ) ) );
        data.setStartingBalls( Utils.toInt( rec, pos++ ) );
        data.setNameOfScouter( ( rec.get( pos++ ) ) );
        data.setAutoPassedLine( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setAutoNumPowerCellsLower( Utils.toInt( rec, pos++ ) );
        data.setAutoNumPowerCellsOuter( Utils.toInt( rec, pos++ ) );
        data.setAutoNumPowerCellsInner( Utils.toInt( rec, pos++ ) );
        data.setTeleopNumPowerCellsLower( Utils.toInt( rec, pos++ ) );
        data.setTeleopNumPowerCellsOuter( Utils.toInt( rec, pos++ ) );
        data.setTeleopNumPowerCellsInner( Utils.toInt( rec, pos++ ) );
        data.setTeleopCanSpinWheel( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setTeleopColorCorrect( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setTeleopTrench( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setTeleopBar( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setTeleopBallPickup( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        data.setTeleopStageReached( Stage.fromValue( rec.get( pos++ ) ) );
        data.setEndgameBarGrabPosition( BarGrabPosition.fromValue( rec.get( pos++ ) ) );
        data.setEndgameWon( BooleanUtils.toBoolean( rec.get( pos++ ) ) );
        return data;
    }

    private static DataModelKey readDataModelKey( final CSVRecord rec ) {
        final DataModelKey key = new DataModelKey();
        int pos = 0;
        key.setMatchID( Utils.toInt( rec, pos++ ) );
        key.setTeamID( Utils.toInt( rec, pos++ ) );
        return key;
    }

    @Override
    public Map<DataModelKey, DataModel> readDataModels() throws IOException {
        if ( !csvFileLocation.exists() && !csvFileLocation.createNewFile() ) {
            throw new IOException( "Could not create file '" + csvFileLocation.getAbsolutePath() + "'." );
        }

        final Map<DataModelKey, DataModel> rVal = new LinkedHashMap<>();
        try ( final Reader reader = new FileReader( csvFileLocation );
            final CSVParser csvParser = new CSVParser( reader, csvFormat.withSkipHeaderRecord() ) ) {
            csvParser.forEach( rec -> rVal.put( readDataModelKey( rec ), readDataModel( rec ) ) );
        }

        return rVal;
    }

    @Override
    public void appendDataModel( final DataModel data ) throws IOException {
        final DataModelKey newKey = new DataModelKey();
        newKey.setTeamID( Integer.parseInt( data.getTeamID().getLabel() ) );
        newKey.setMatchID( data.getMatchID() );
        final Map<DataModelKey, DataModel> datas = readDataModels();
        if ( datas.containsKey( newKey ) ) {
            throw new IOException( "Data with key '" + newKey + "' already exists." );
        }

        try ( final BufferedWriter writer = new BufferedWriter( new FileWriter( csvFileLocation ) );
            final CSVPrinter csvPrinter = new CSVPrinter( writer, csvFormat ) ) {
            for ( final DataModel dataOld : datas.values() ) {
                printDataModel( dataOld, csvPrinter );
            }

            printDataModel( data, csvPrinter );
            csvPrinter.flush();
        }
    }

    @Override
    public void deleteAllDataModels() throws IOException {
        if ( csvFileLocation.exists() && !csvFileLocation.delete() ) {
            throw new IOException( "Could not delete file '" + csvFileLocation.getAbsolutePath() + "'." );
        }
    }
}
