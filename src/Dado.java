import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Dado {
    protected String lapide, title, overview, originalLanguage, genre, posterUrl;
    protected int id, popularity, voteCount, voteAverage, quantityGenre;

    public Dado(){

    }

    public Dado(String title, String overview, int popularity,
                int quantityGenre, String genre){
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.quantityGenre = quantityGenre;
        this.genre = genre;
    }

    public String toString() {
        return "id: " + this.id + "| name: " + this.title + " | overview: " + this.overview;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(this.lapide);
        dos.writeInt(this.id);
        dos.writeUTF(this.title);
        dos.writeUTF(this.overview);
        dos.writeInt(this.popularity);
        dos.writeInt(this.voteCount);
        dos.writeInt(this.voteAverage);
        dos.writeUTF(this.originalLanguage);
        dos.writeInt(this.quantityGenre);
        dos.writeUTF(this.genre);
        dos.writeUTF(this.posterUrl);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.lapide = dis.readUTF();
        this.id = dis.readInt();
        this.title = dis.readUTF();
        this.overview = dis.readUTF();
        this.popularity = dis.readInt();
        this.voteCount = dis.readInt();
        this.voteAverage = dis.readInt();
        this.originalLanguage = dis.readUTF();
        this.quantityGenre = dis.readInt();
        this.genre = dis.readUTF();
        this.posterUrl = dis.readUTF();
    }


}