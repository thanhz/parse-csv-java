import model.Metadata;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetadataTestSpec {

    @Test
    public void metadataShouldReturnExtensionOfFile(){
        Metadata metadata = new Metadata("untitled_goose_game.exe", "Report on goose behaviour", "4830800", "b87078849a142e1b00db02744b4848a6");
        String actual = metadata.getExtension();
        assertEquals(actual, ".exe");
    }

    @Test
    public void metadataShouldReturnExtensionOfNonExecutableFile(){
        Metadata metadata = new Metadata("imposter-goose_game.xlms", "Report on goose behaviour", "4830800", "b87078849a142e1b00db02744b4848a6");
        String actual = metadata.getExtension();
        assertEquals(actual, ".xlms");
    }
}
