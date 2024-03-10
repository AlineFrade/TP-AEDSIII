import java.io.RandomAccessFile;
import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws Exception {
        Dado l1 = new Dado("a", 1, "titulo", "overview", 10, 15, 5, "pt-br", 2, "horror,comedia", "lalala");
        Dado l2 = new Dado();

        Dado l3 = new Dado("a", 2, "abuble", "overview", 10, 15, 5, "pt-br", 2, "horror,comedia", "lalala");
        Dado l4 = new Dado();

        Header h = new Header(2);

        File path = new File("banco.db", "rw");
        

        byte[] b;
        int len;
        try {

            /* ESCRITA */
            b = h.toByteArray();
            path.create(b);
            //arq.write(b);

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
        

            
            arq.close();
            */
        

        } catch (Exception e) {
            System.out.println("O erro aqui");
            e.printStackTrace();
        }
        
        
    
    }



}
