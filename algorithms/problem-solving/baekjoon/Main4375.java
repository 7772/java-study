import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main4375 {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String st = null;
          int count = 0;

          while ((st = br.readLine()) != null) {
               int parsedSt = Integer.parseInt(st);
               long i = 1;
               count = 0;

               while (true) {
                    count++;

                    if (i % parsedSt == 0) {
                         break;
                    }

                    i = ((2 * 5 * i) + 1) % parsedSt;
               }

               System.out.println(count);
          }
     }
}
