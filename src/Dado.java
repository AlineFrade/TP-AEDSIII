import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Dado {
    protected String lapide, title, overview, genre;
    protected int id, popularity, quantityGenre;


    public Dado(){

    }

    public Dado(int id, String title, String overview, int popularity,
                int quantityGenre, String genre) throws IOException{
        lapide = "-";
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.quantityGenre = quantityGenre;
        this.genre = genre;
    }

    public String toString() {
        return "id: " + this.id + " | name: " + this.title + " | overview: " + this.overview + " | popularidade: " + popularity + " | quantidade de generos: " + quantityGenre + " | generos: " + genre;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(this.lapide);
        dos.writeInt(this.id);
        dos.writeUTF(this.title);
        dos.writeUTF(this.overview);
        dos.writeInt(this.popularity);
        dos.writeInt(this.quantityGenre);
        dos.writeUTF(this.genre);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        //this.lapide = dis.readUTF();
        this.id = dis.readInt();
        this.title = dis.readUTF();
        this.overview = dis.readUTF();
        this.popularity = dis.readInt();
        this.quantityGenre = dis.readInt();
        this.genre = dis.readUTF();
    }


}