/*Author: Fredrik Birath Hasselgren
 * 
 *Den här klassen innehåller programmets main metod och dess huvudklass "handler".
 *Handler sköter programmets menysystem samt anropar metoder beroende på användares val i programmet
 */
package valuegister;


/**
 *
 * @author driatic
 */
public class Valuegister {

    public static void main(String[] args) {
        Handler h = new Handler();//skapa en instants av handler
        for(;;){//Loopa i evighet, avslutning av programmet sker i Handler klassen
            h.choice();//låt användare göra val i handler tills den väljer att avsluta
        }
    }
}
