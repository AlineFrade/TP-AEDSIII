import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
    protected String database, mode;
    //long p1 = arq.getFilePointer();
    long p;
    int len;
    RandomAccessFile arq;

    public File(String database, String mode){
        this.database = database;
        this.mode = mode;
    }

    public void file() throws IOException{
        arq = new RandomAccessFile(database, mode);
    }

    public void createHeader(byte[] data) throws IOException{
        arq.write(data);
    }  

    public void create(byte[] data) throws IOException{
        arq.writeInt(data.length);
        arq.write(data);
    }   

    public Filme read(Filme data, int pos) throws IOException{
        byte[] readed;
        arq.seek(pos);
        len = arq.readInt();
        readed = new byte[len];
        arq.read(readed);
        data.fromByteArray(readed);
        return data;
    }

    public void end() throws IOException{
        arq.close();
    }
}
