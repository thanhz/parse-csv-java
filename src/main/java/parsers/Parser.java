package parsers;

import model.Metadata;

import java.util.List;

public interface Parser {

    List<Metadata> parseFile(String path);

}
