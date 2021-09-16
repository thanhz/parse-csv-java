public class Metadata {

    private final String filename;
    private final String description;
    private final String size;
    private final String checksum;

    public Metadata(String filename, String description, String size, String checksum) {
        this.filename = filename;
        this.description = description;
        this.size = size;
        this.checksum = checksum;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public String getChecksum() {
        return checksum;
    }

    public String getExtension(){
        return filename.substring(filename.lastIndexOf("."));
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "filename='" + filename + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }
}
