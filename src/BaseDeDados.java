import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class BaseDeDados {
    public static SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
    public static Filme movies = new Filme();

    public static String tratarBase(String str) throws Exception{
        
        movies.setId(Integer.parseInt(str.split(";")[0]));
        movies.setTitle(str.split(";")[1]);
        movies.setReleaseDate(form.parse(str.split(";")[2]));
        movies.setOverview(str.split(";")[3]);
        movies.setPopularity(Integer.parseInt(str.split(";")[4]));
        movies.setOriginalLanguage(str.split(";")[5]);
        movies.setQuantityGenre(Integer.parseInt(str.split(";")[6]));
        movies.setGenre(str.split(";")[7].split(","));
    
        
        return movies.getId() + " " + movies.getTitle() + " " + dateFormat.format(movies.getReleasedDate()) + " " + movies.getOverview() + " " + movies.getPopularity() + " " + movies.getOriginalLanguage() + " " + movies.getQuantityGenre() + " " + movies.getGenre();
    }
}
