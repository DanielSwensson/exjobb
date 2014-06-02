
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class IOLib {
    public static String askQuestion(String q){
       boolean succsess = false;
       String input = "";
       while(!succsess){
            System.out.println(q);
            System.out.print("-> ");
            BufferedReader br_input = new BufferedReader(new InputStreamReader(System.in));
            try{
                input = br_input.readLine(); 
                succsess = true;
            }
            catch(Exception ex){System.err.println("\nFelaktig indata:\n"+ex);}
       }
       return input;
    }
    public static int askQuestionInt(String q){
        boolean success = false;
        int num = 0;
        while(!success){
            System.out.println(q);
            System.out.print("-> ");
            BufferedReader br_input = new BufferedReader(new InputStreamReader(System.in));
            try{
                num = Integer.parseInt(br_input.readLine());
                success = true;
            }
            catch(Exception ex){ System.err.println("\nFelaktig indata:\n"+ex);}
        }
        return num;
    }
}
