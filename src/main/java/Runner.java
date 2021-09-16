import model.Metadata;
import parsers.CsvParser;
import parsers.Parser;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        //GET EACH LINE OF CSV AND ASSIGN TO METADATA OBJECT
        Parser csvParser = new CsvParser();
        List<Metadata> records = csvParser.parseFile("src/main/resources/example-file-metadata.csv");
        //CREATE A QUERY OBJECT
        MetadataQuery query = new MetadataQuery();
        //RUN QUERIES
        query.getEmptyFiles(records);
        query.getFileWithExtension(records,"exe");
        query.getDuplicates(records);

    }

}
