import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        //GET EACH LINE OF CSV AND ASSIGN TO METADATA OBJECT
        Parser csvParser = new CsvParser();
        List<Metadata> records = csvParser.parseFile("src/main/resources/example-file-metadata.csv");

        //FILE WHICH ARE EMPTY (SIZE = 0)
        System.out.println("---FILES WHICH ARE EMPTY (SIZE = 0)---");
        for (Metadata record : records) {
            if (record.getSize().equals("0")) {
                System.out.println(record.getFilename());
            }
        }

        //FILE WHICH ARE EXECUTABLE (.EXE)
        System.out.println("---FILE WHICH ARE EXECUTABLE (.EXE)---");
        records.stream()
                .filter(metadata -> metadata.getExtension().contains(".exe"))
                .forEach(data -> System.out.println(data.getFilename()));


        //FILE WHICH ARE DUPLICATES (SAME CHECKSUM)
        System.out.println("---FILE WHICH ARE DUPLICATES (SAME CHECKSUM)---");
        //Group by checksum
        Map<String, List<Metadata>> groupByChecksumMap = records.stream().collect(Collectors.groupingBy(Metadata::getChecksum));
        //Print out values containing duplicates
        groupByChecksumMap.forEach((key, value) -> {
            if (value.size() > 1) {
                System.out.println(key + " ");
                value.forEach(data -> System.out.print(data.getFilename() + ", "));
                System.out.println("\n");
                //System.out.println(key + " " + value);
            }
        });

    }

}
