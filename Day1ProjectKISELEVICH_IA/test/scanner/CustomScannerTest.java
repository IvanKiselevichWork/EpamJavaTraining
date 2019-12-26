package scanner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomScannerTest {

    private static final double THRESHOLD = .0000001;
    private final static String testFileName = "testFile.txt";

    @After
    public void deleteTestFile() {
        try {
            Files.deleteIfExists(Paths.get(testFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // todo test naming
/*
    int readInteger(InputStream in) throws CustomScannerException
    TESTS
*/
    @Test
    public void readIntegerTest1() throws DataNotFoundException, DataSourceException, IOException {
        String streamData = "dsfasdfasd\ndsasdf\n45\n";
        InputStream in = writeDataToTestFileAndGetInputStream(streamData);

        int expected = 45;
        int result = CustomScanner.readInteger(in);
        in.close();
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataNotFoundException.class)
    public void readIntegerTest2() throws DataNotFoundException, DataSourceException, IOException {
        InputStream in = null;
        try {
            String streamData = "dsfasdfasd\ndsasdf\n45df\n";
            in = writeDataToTestFileAndGetInputStream(streamData);
            CustomScanner.readInteger(in);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Test(expected = DataSourceException.class)
    public void readIntegerTest3() throws DataNotFoundException, DataSourceException, IOException {
        CustomScanner.readDouble(null);
    }
/*
    double readDouble(InputStream in) throws CustomScannerException
    TESTS
*/
    @Test
    public void readDoubleTest1() throws DataNotFoundException, DataSourceException, IOException  {
        String streamData = "dsfasdfasd\ndsasdf\n45.5\n";
        InputStream in = writeDataToTestFileAndGetInputStream(streamData);

        double expected = 45.5;
        double result = CustomScanner.readDouble(in);
        in.close();
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test(expected = DataNotFoundException.class)
    public void readDoubleTest2() throws DataNotFoundException, DataSourceException, IOException {
        InputStream in = null;
        try {
            String streamData = "dsfasdfasd\ndsasdf\n45df\n";
            in = writeDataToTestFileAndGetInputStream(streamData);
            CustomScanner.readDouble(in);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Test(expected = DataSourceException.class)
    public void readDoubleTest3() throws DataNotFoundException, DataSourceException, IOException {
        CustomScanner.readDouble(null);
    }

    // replaced private method to end of file
    /*
        private methods
     */
    private InputStream writeDataToTestFileAndGetInputStream(String data) throws IOException {
        Files.write(Paths.get(testFileName), data.getBytes());
        return new FileInputStream(testFileName);
    }
}

