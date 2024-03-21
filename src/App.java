import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean option = true;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File path = new File("banco.db", "rw");
        Header h = new Header(0);
        path.file();

        
        
        Dado movie = new Dado();


        byte[] b;

        try {
            //Cabeçalho
            b = h.toByteArray();
            path.createHeader(b);
        } catch (Exception e) {
            System.out.println("O erro aqui");
            e.printStackTrace();
        }


        while (option) {
            System.out.println("MENU CRUD");
            System.out.println("c - create");
            System.out.println("r - read");
            System.out.println("u - update");
            System.out.println("d - delete");
            System.out.println("ou qualquer outra tecla para encerrar");
            Scanner scan = new Scanner(System.in);

            char entry;
            entry = scan.next().charAt(0);
            
            int id = 0;

            try {                
                
                switch (entry) {
                    

                    case 'c':
                        //l1
                        
                        Dado l1 = new Dado(h.lastID+1, "titulo", "overview", 10, 2, "horror,comedia");
                        b = l1.toByteArray();
                        path.create(b);
                        h.updateID();

                        //l3
                        Dado l3 = new Dado(h.lastID+1, "abuble", "overview", 10, 2, "horror,comedia");
                        b = l3.toByteArray();
                        path.create(b);
                        h.updateID();
                        b = h.toByteArray();
                        path.updateHeader(b);
                        /* 
                        System.out.println("Título");
                        String title = reader.readLine();
                        System.out.println("Overview");
                        String overview = reader.readLine();
                        System.out.println("Popularidade");
                        String input = reader.readLine();
                        int popularity = Integer.parseInt(input);
                        System.out.println("Quantidade de generos");
                        String gen = reader.readLine();
                        int quantityGenre = Integer.parseInt(gen);
                        System.out.println("Generos");
                        String genre = reader.readLine();
                        */

                        

                        break;
                
                    case 'r':
                        movie = new Dado();
                        System.out.println("Informe o ID procurado.");
                        id = scan.nextInt();

                        movie = path.read(movie, id);
                        System.out.println(movie);
                
                        break;

                    case 'u':
                        //movie = new Dado();
                        System.out.println("Informe o ID a ser atualizado.");
                        String stringID = reader.readLine();
                        int updateID = Integer.parseInt(stringID);
                        System.out.println("Título");
                        String title = reader.readLine();
                        System.out.println("Overview");
                        String overview = reader.readLine();
                        System.out.println("Popularidade");
                        String input = reader.readLine();
                        int popularity = Integer.parseInt(input);
                        System.out.println("Quantidade de generos");
                        String gen = reader.readLine();
                        int quantityGenre = Integer.parseInt(gen);
                        System.out.println("Generos");
                        String genre = reader.readLine();

                        movie = new Dado(updateID, title, overview, popularity, quantityGenre, genre);


                        path.update(movie);

                        System.out.println("Dado atualizado");

                        break;

                    case 'd':
                        System.out.println("Informe o ID a ser deletado.");
                        id = scan.nextInt();

                        path.delete(id);
                        break;
                        
                    
                    default:
                        option = false;
                        //fechando o arquivo
                        path.end();
                        System.out.println("Opção inválida");
                    
                        break;
                }


                

            } catch (Exception e) {
                System.out.println("O erro aqui");
                e.printStackTrace();
            }
        }
        
        
    
    }



}
