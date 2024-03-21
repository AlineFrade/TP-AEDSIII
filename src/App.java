import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean option = true;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // pass the information for the RandomAccessFile
        File path = new File("banco.db", "rw");
        // create the header and set as 0 because there's no udes ID yet
        Header h = new Header(0);
        // create a way to the class File
        path.file();

        
        // variables to be used at CRUD
        Dado movie = new Dado();
        byte[] b;
        int id = 0;

        String title = "", overview = "", input = "", genre = "";
        int popularity = 0, quantityGenre = 0;

        try {
            // HEADER
            b = h.toByteArray();
            path.createHeader(b);
        } catch (Exception e) {
            System.out.println("O erro aqui");
            e.printStackTrace();
        }


        while (option) {
            System.out.println("____________________ MENU CRUD ____________________");
            System.out.println("c - create");
            System.out.println("r - read");
            System.out.println("u - update");
            System.out.println("d - delete");
            System.out.println("ou qualquer outra tecla para encerrar");
            System.out.println("Escolha: ");
            Scanner scan = new Scanner(System.in);
            char entry;
            entry = scan.next().charAt(0);
            
            try {                
                
                switch (entry) {
            
                    // CREATE
                    case 'c':                    
                        // collecting the information about the data to be created 
                        System.out.print("Título: ");
                        title = reader.readLine();
                        System.out.print("Overview: ");
                        overview = reader.readLine();
                        System.out.print("Popularidade: ");
                        input = reader.readLine();
                        popularity = Integer.parseInt(input);
                        System.out.println("Quantidade de generos");
                        input = reader.readLine();
                        quantityGenre = Integer.parseInt(input);
                        System.out.println("Generos");
                        genre = reader.readLine();
                        movie = new Dado(h.lastID+1, title, overview, popularity, quantityGenre, genre);

                        b = movie.toByteArray();
                        path.create(b);
                        h.updateID();
                        b = h.toByteArray();
                        path.updateHeader(b);
                        
                        System.out.println("Dado criado com sucesso.");

                        break;
                
                    // READ
                    case 'r':
                        movie = new Dado();
                        // get the searched ID
                        System.out.print("Informe o ID procurado: ");
                        id = scan.nextInt();

                        movie = path.read(movie, id);
                        System.out.println(movie);
                
                        break;

                    // UPDATE
                    case 'u':
                        // collecting the new information about data file to be updated
                        System.out.print("Informe o ID a ser atualizado: ");
                        String stringID = reader.readLine();
                        int updateID = Integer.parseInt(stringID);
                        System.out.print("Título: ");
                        title = reader.readLine();
                        System.out.print("Overview: ");
                        overview = reader.readLine();
                        System.out.print("Popularidade: ");
                        input = reader.readLine();
                        popularity = Integer.parseInt(input);
                        System.out.println("Quantidade de generos");
                        input = reader.readLine();
                        quantityGenre = Integer.parseInt(input);
                        System.out.println("Generos");
                        genre = reader.readLine();

                        movie = new Dado(updateID, title, overview, popularity, quantityGenre, genre);
                        path.update(movie);
                        System.out.println("Dado atualizado com sucesso.");

                        break;

                    // DELETE
                    case 'd':
                        System.out.print("Informe o ID a ser deletado: ");
                        id = scan.nextInt();

                        path.delete(id);

                        System.out.println("Dado deletado com sucesso.");
                        break;
                        
                    // FINISH THE PROGRAM
                    default:
                        option = false;
                        // close file
                        path.end();
                        System.out.println("Aplicação encerrada com sucesso.");
                    
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERRO:");
                e.printStackTrace();
            }
        }
    
    }

}
