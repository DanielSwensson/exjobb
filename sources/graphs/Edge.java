package graphs;

public class Edge<N>{
	private int weight;
	private N dest;
	private N source;
	private String name;
	private Edge<N> mirror;
	
	public Edge(N from,N to, String how, int v){
		if (v<0) throw new IllegalArgumentException("Negativ Vikt för Edge");
		dest=to;
		name=how;
		weight=v;
		source=from;
	}
	
	public N getSource(){
	return source;}
	
	public void setMirror(Edge<N> m){
		mirror=m;
	}
	
	public N getDest(){
	return dest;}
	
	public Edge<N> getMirror(){
	return mirror;
	}
	
	public int getWeight(){
	return weight;}
	
	public void setWeight(int v){
	weight = v;}
	
	public String getName(){
	return name;}
	
	public void setName(String nyttnamn){
	name=nyttnamn;
	}
	
	public String toString(){
	return getName()+" till "+getDest()+": "+getWeight()+" minut(er).";}
}