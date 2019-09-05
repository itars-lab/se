package pl.qa.selenium.data;

import org.jooq.tools.csv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * note!!!
 * Data provider returns a two-dimensional object to the test method and the test method will invoke M times
 * in an M * N type of object array. For example, if the DataProvider returns an array of 3*3 objects,
 * the corresponding test case will be invoked three times with three parameters.
 *
 */
public class CredentialsDataProvider {

    //Read data from csv file
    private static Object[][] readCsvData() {
        String csvFilePath = "";
        ArrayList<Object[]> dataList = new ArrayList<>();
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(csvFilePath));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Object[] record = {line[0], line[1], Boolean.parseBoolean(line[2])};
                dataList.add(record);
            }
            reader.close();

            return dataList.toArray(new Object[dataList.size()][]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
