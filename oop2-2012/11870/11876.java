package prylregister;

class Smycke extends Pryl{
    private boolean isItGold;
    private int nrOfStones;
    private double value;
    public Smycke (String name, boolean Gold, int stones){
        super(name);
        isItGold=Gold;
        nrOfStones=stones;
    }
        public boolean getGold(){
            return isItGold;
        }
        public int getNrOfStones(){
            return nrOfStones;
        }
        @Override
        public double getValue(){
            if (isItGold) {
                value=2000;
            }
            else {
                value=700;
            }

            value+= nrOfStones*500;

            return value;
        }
        @Override
        public String toString(){
            return prylName +"\t"+ getValue()+"\n";
    }
}