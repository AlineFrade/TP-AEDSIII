import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        BaseDeDados bd = new BaseDeDados();
        String[] entrada = new String[10000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("database.db"));
        String linha = "";
        int numEntrada = 0;
        linha = br.readLine();
            while (linha != null) {
                entrada[numEntrada] = linha;
                linha = br.readLine();
                numEntrada++;
            }

            for(int i = 0; i < numEntrada; i++){
                String linhas = bd.tratarBase(entrada[i]);
                buffWrite.append(linhas + "\n");
            }
        br.close();
        buffWrite.close();

        //Filme l1 = new Filme(1, "titulo", 10/05/2024,"overview", 10, "pt-br", 2, "horror,comedia", "lalala");
        Filme l2 = new Filme();
       // Filme l3 = new Filme("a", 2, "abuble", "overview", 10, 15, 5, "pt-br", 2, "horror,comedia", "lalala");
        Filme l4 = new Filme();
        Header h = new Header(1);
        File path = new File("banco.db", "rw");
        
        System.out.println("MENU CRUD");
        System.out.println("c - create");
        System.out.println("r - read");
        System.out.println("u - update");
        System.out.println("d - delete");
        Scanner en = new Scanner(System.in);

        char entry;
        entry = en.next().charAt(0);

        byte[] b;
        try {

            path.file();

            switch (entry) {
                case 'c':
                    System.out.println("Hello world!");
                    break;
            
                default:
                /* ESCRITA */
                //Cabeçalho
                b = h.toByteArray();
                path.createHeader(b);
                //l1
                //b = l1.toByteArray();
                //path.create(b);
                //l3
                //b = l3.toByteArray();
                //path.create(b);

                /* LEITURA */
                l2 = path.read(l2, 4);
                System.out.println(l2);
                l4 = path.read(l4, 80);
                System.out.println(l4);
                    break;
            }

            

            

            /*
            long p1 = arq.getFilePointer();
            b = l1.toByteArray();
            arq.writeInt(b.length);
            arq.write(b);
            

            //long p2 = arq.getFilePointer();
            b = l3.toByteArray();
            arq.writeInt(b.length);
            arq.write(b);
            
            /* LEITURA */
            

            /*arq.seek(4);
            len = arq.readInt();
            b = new byte[len];
            arq.read(b);
            l2.fromByteArray(b);
            System.out.println(l2);
            //System.out.println(p1);

            len = arq.readInt();
            b = new byte[len];
            arq.read(b);
            l4.fromByteArray(b);
            System.out.println(l4);
            //System.out.println(p2);
        

            */
            
            //fechando o arquivo
            path.end();

        } catch (Exception e) {
            System.out.println("O erro aqui");
            e.printStackTrace();
        }
        
        
    
    }



}
