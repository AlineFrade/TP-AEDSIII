import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Dado l1 = new Dado("titulo", "overview", 10, 2, "horror,comedia");
        Dado l2 = new Dado();
        Dado l3 = new Dado("abuble", "overview", 10, 2, "horror,comedia");
        Dado l4 = new Dado();
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

            /* ESCRITA */
            //Cabeçalho
            b = h.toByteArray();
            path.createHeader(b);

            switch (entry) {
                case 'c':
                    //l1
                    b = l1.toByteArray();
                    path.create(b);

                    //l3
                    b = l3.toByteArray();
                    path.create(b);
                    break;
            
                case 'r':

                    break;

                case 'u':

                    break;

                case 'd':

                    break;
                
                default:
                System.out.println("Opção inválida");
                    break;
            }


           
            
            

            /* LEITURA */
            l2 = path.read(l2, 4);
            System.out.println(l2);

            l4 = path.read(l4, 80);
            System.out.println(l4);


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
