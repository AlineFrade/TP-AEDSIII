/*
public class  Manipulation{
    private String lapide, title, overview, originalLanguage, genre, posterUrl;
    private int id, popularity, voteCount, voteAverage, quantityGente;
    //data
    private Integer age;
    private String phone, address;
    Files.lines(Paths.get("Database.csv")).forEach(System.out::println);

    Files.lines(Paths.get("file.csv"))
     .skip(1)
     .forEach(System.out::println);


    Files.lines(Paths.get("file.csv"))
     .skip(1)
     .map(line -> line.split(";"))
     .map(col-> new User(col[0], col[1], Integer.parseInt(col[2]), col[3], col[4]))
     .forEach(System.out::println);
}
*/