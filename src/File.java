import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
    protected String database, mode;
    //long p1 = arq.getFilePointer();
    //long p;
    long pos = 0;
    long fileSize = 0;
    int len;
    RandomAccessFile arq;

    public File(){

    }

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

    public void updateHeader(byte[] data) throws IOException{
        arq.seek(0);
        arq.write(data);
    }

    public Header getID(Header h) throws IOException{
        byte[] lid;
        arq.seek(0);
        len = arq.readInt();
        lid = new byte[len];
        arq.read(lid);
        h.fromByteArray(lid);
        return h;
    }

    public void create(byte[] data) throws IOException{
        arq.writeInt(data.length);
        arq.write(data);
    }   

    public Dado read(Dado movie, int id) throws IOException{
        pos = 0;
        arq.seek(0);
        int lid = arq.readInt();
        if(lid < id) {
            System.out.println("Não existe esse ID");
        }
        else{
            fileSize = arq.length();
            pos = pos+4;
            while (arq.getFilePointer() < fileSize) {
                arq.seek(pos);
                int len = arq.readInt();

                pos = pos + 6;
                arq.seek(pos);
                char lapide = (char) arq.read();

                if(lapide != '*'){
                    pos = pos + 1;
                    arq.seek(pos);
                    byte[] readed;
                    readed = new byte[len];
                    arq.read(readed);
                    movie.fromByteArray(readed);
                    
                    if(movie.id == id){
                        return movie;
                    }
                    else {
                        pos = pos + (len-3);
                    }                
                }
            }
        }  
        return null;
    }

    public void update() {

    }

    public void delete(int id) throws IOException {
        pos = 4;
        arq.seek(pos);
        fileSize = arq.length();
        while (arq.getFilePointer() < fileSize) {
            len = arq.readInt();

            pos = pos + 6;
            arq.seek(pos);
            char lapide = (char) arq.read();

            if(lapide != '*'){
                pos = pos + 1;
                arq.seek(pos);
                
                int rid = arq.readInt();
                    
                if(rid == id){
                    pos = pos - 1;
                    arq.seek(pos);
                    arq.writeChar('*');
                    break;
                }
                else {
                    pos = pos + (len-3);
                }                

            }

        }
    }

    public void end() throws IOException{
        arq.close();
    }
}
