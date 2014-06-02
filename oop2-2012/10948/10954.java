/*Author: Fredrik Birath Hasselgren
 * 
 *Den här abstrakta klassen representerar en sak som en person kan äga. 
 */
package valuegister;

public abstract class Thing {
   
   private String name;//sakens namn
   
   public Thing(String name){
       this.name = name;
   }
   
   public String getName(){
       return name;
   }
  
   public abstract double getValue();
  

}
