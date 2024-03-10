import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
    protected String database, mode;

    public File(String database, String mode){
        this.database = database;
        this.mode = mode;
    }

    public void create(byte[] data) throws IOException{

        RandomAccessFile arq = new RandomAccessFile(database, mode);
        arq.write(data);
        arq.close();
    }   
}
