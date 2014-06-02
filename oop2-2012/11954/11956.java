class Apparater extends Pryl {
 private int slitage;
 private int pris;
 
     public Apparater(String namn, int pris, int slitage) {
         super(namn);
         this.pris=pris;
         this.slitage = slitage;
     }
     public int getVärde(){
         if (slitage==10)
             return pris; 
         else if(slitage==9) 
             return pris*90/100;
         else if(slitage==8) 
             return pris*80/100;
         else if(slitage==7) 
             return pris*70/100;
         else if(slitage==6) 
             return pris*60/100;
         else if(slitage==5) 
             return pris*50/100;
         else if(slitage==4) 
             return pris*40/100;
         else if(slitage==3) 
             return pris*30/100;
         else if(slitage==2) 
             return pris*20/100;
         else if(slitage==1) 
             return pris*10/100;
         return pris;
     }
} 