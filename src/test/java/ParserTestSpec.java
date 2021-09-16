import model.Metadata;
import org.junit.jupiter.api.Test;
import parsers.CsvParser;
import parsers.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTestSpec {

    @Test
    public void csvParserShouldCorrectlyMapRecordsToAMetadataObject() {
        Parser csvParser = new CsvParser();
        Metadata actual = csvParser.parseFile("src/test/resources/metadata-test.csv").get(0);
        Metadata expected = new Metadata("bitcoin.pdf", "to the moon", "48000", "b87078849a142e1b00db02744b4848a6");

        assertEquals(actual.getFilename(), expected.getFilename());
        assertEquals(actual.getDescription(), expected.getDescription());
        assertEquals(actual.getSize(), expected.getSize());
        assertEquals(actual.getChecksum(), expected.getChecksum());
    }
}
