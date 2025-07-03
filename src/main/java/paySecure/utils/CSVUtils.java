package paySecure.utils;


import java.io.FileReader;
import java.util.*;

import com.opencsv.CSVReader;

public class CSVUtils {
    public static List<Map<String, String>> readCSV(String path) {
    	
    	String csvFilePath ="C:\\Users\\LENOVO\\eclipse-workspace\\paySecure\\src\\test\\resources\\csv\\Transaction Report (2).csv";
    	
        List<Map<String, String>> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath ))) {
            String[] headers = reader.readNext(); // Read header row
            String[] row;
            while ((row = reader.readNext()) != null) {
                Map<String, String> record = new HashMap<>();
                for (int i = 1; i < headers.length; i++) {
                    record.put(headers[i].trim(), row[i].trim());
                }
                records.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}

