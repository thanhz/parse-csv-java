import model.Metadata;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetadataQuery {

    public void getEmptyFiles(List<Metadata> records) {
        System.out.println("---FILES WHICH ARE EMPTY (SIZE = 0)---");
        for (Metadata record : records) {
            if (record.getSize().equals("0")) {
                System.out.println(record.getFilename());
            }
        }
    }

    public void getFileWithExtension(List<Metadata> records, String extension) {
        System.out.println("---FILE WHICH ARE " + "(" + extension + ")---");
        records.stream()
                .filter(metadata -> metadata.getExtension().contains(extension))
                .forEach(data -> System.out.println(data.getFilename()));

    }

    public void getDuplicates(List<Metadata> records) {
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
