import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetadataTestSpec {

    @Test
    public void metadataShouldReturnTrueIfFileIsEmpty(){
        Metadata metadata = new Metadata("untitled_goose_game.exe", "Report on goose behaviour", "0", "b87078849a142e1b00db02744b4848a6");
        boolean actual = metadata.fileIsEmpty();
        assertTrue(actual);
    }

    @Test
    public void metadataShouldReturnFalseIfFileIsNotEmpty(){
        Metadata metadata = new Metadata("untitled_goose_game.exe", "Report on goose behaviour", "4830800", "b87078849a142e1b00db02744b4848a6");
        boolean actual = metadata.fileIsEmpty();
        assertFalse(actual);
    }

    @Test
    public void metadataShouldReturnTrueIfFileIsExecutable(){
        Metadata metadata = new Metadata("untitled_goose_game.exe", "Report on goose behaviour", "4830800", "b87078849a142e1b00db02744b4848a6");
        boolean actual = metadata.isExecutable();
        assertTrue(actual);
    }

    @Test
    public void metadataShouldReturnFalseIfFileIsNotExecutable(){
        Metadata metadata = new Metadata("imposter-goose_game.pdf", "Report on goose behaviour", "4830800", "b87078849a142e1b00db02744b4848a6");
        boolean actual = metadata.isExecutable();
        assertFalse(actual);
    }
}
