import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class Filme {
    protected String lapide, title, overview, originalLanguage;
    protected String[] genre;
    protected int id, popularity, quantityGenre;
    protected Date releaseDate;

    public Filme(){
        lapide = "";
        id = 0;
        title = "";
        releaseDate = new Date(0);
        overview = "";
        popularity = 0;
        originalLanguage = "";
        quantityGenre = 0;
        genre = null;
    }

    public Filme(int id, String title, Date releaseDate, String overview, int popularity,
                String originalLanguage, int quantityGenre, String[] genre){
        lapide = "";
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
        this.quantityGenre = quantityGenre;
        this.genre = genre;
    }

    public String toString() {
        return "id: " + this.id + "| name: " + this.title + " | overview: " + this.overview;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReleasedDate() {
        return releaseDate;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setQuantityGenre(int quantityGenre) {
        this.quantityGenre = quantityGenre;
    }

    public int getQuantityGenre() {
        return quantityGenre;
    }

    public String getGenre() {
        String aux = "";
        if (genre.length > 1) {
            for (int i = 0; i < genre.length; i++) {
                aux = aux + genre[i];
                if (i != genre.length - 1) {
                    aux = aux + ',' + ' ';
                }
            }
        } else {
            aux = genre[0];
        }
        return aux;
    }
    
    public void setGenre(String[] genre) {
        this.genre = genre;
    }


    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(this.lapide);
        dos.writeInt(this.id);
        dos.writeUTF(this.title);
        dos.writeUTF(this.overview);
        dos.writeInt(this.popularity);
        dos.writeUTF(this.originalLanguage);
        dos.writeInt(this.quantityGenre);
        //dos.writeUTF(this.genre);
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
        this.originalLanguage = dis.readUTF();
        this.quantityGenre = dis.readInt();
        //this.genre = dis.readUTF();
    }


}