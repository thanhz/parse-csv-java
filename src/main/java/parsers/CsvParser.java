package parsers;

import model.Metadata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements Parser {

    public List<Metadata> parseFile(String filepath) {
        List<Metadata> records = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            String header = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.toLowerCase().split("\\s*,\\s*");

                String filename = values[0];
                String description = values[1];
                String size = values[2];
                String checksum = values[3];

                Metadata metadata = new Metadata(filename, description, size, checksum);
                records.add(metadata);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //records.forEach(System.out::println);
        return records;
    }
}
