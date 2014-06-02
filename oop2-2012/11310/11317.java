/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

import java.util.Scanner;

/**
 *
 * @author Robin Hem
 */
public class Query {
    
    public String askQuestion(String type, String question, String errorMsg){
        Scanner keyboard = new Scanner(System.in);
        type = type.toLowerCase();
        boolean done = false;
        String retval = null;
        

        if(type.equals("string"))
        {
            do{
                System.out.print(question);
                String input = keyboard.nextLine();
                if(!input.equals("")){
                    retval = input;
                    done = true;
                }
                else{System.out.println(errorMsg);}
            }while(!done);
        }
        else if(type.equals("int")){
            do{
                System.out.print(question);
                try{ int tmpInt = Integer.parseInt(keyboard.nextLine());
                    retval = Integer.toString(tmpInt);
                    done = true;}
                catch(java.lang.Exception e){
                    System.out.print(errorMsg);
                }
            }while(!done);
        }
        else if(type.equals("double")){
            do{
                System.out.print(question);
                try{ Double tmpDouble = Double.parseDouble(keyboard.nextLine());
                    retval = Double.toString(tmpDouble);
                    done = true;}
                catch(java.lang.Exception e){
                    System.out.print(errorMsg);
                }
            }while(!done);

        }

        return retval;
        
    }

}
