package graphs;

import java.util.*;

public class ListGraph<N> implements Graph<N>{
	private Map<N,ArrayList<Edge<N>>> noder = new HashMap<N,ArrayList<Edge<N>>>();
	
	public GraphMethods<N> met = new GraphMethods<N>();
	public void add(N nod){
		if (!noder.containsKey(nod)){
		noder.put(nod,new ArrayList<Edge<N>>());}
	}
	
	public void connect(N from, N to, String how, int weight){
		if (!noder.containsKey(from) || !noder.containsKey(to))
			throw new NoSuchElementException("Nod ej i ListGraph");
		if (weight<0) 
			throw new IllegalArgumentException("Vikten är negativ");
			
		List<Edge<N>> flist = noder.get(from);
		List<Edge<N>> tlist = noder.get(to);
		Edge<N> e1 = new Edge<N>(from,to,how,weight);
		Edge<N> e2 = new Edge<N>(to,from,how,weight);
		e1.setMirror(e2);
		e2.setMirror(e1);
		
		flist.add(e1);
		tlist.add(e2);
	}

	public Set<N> getNodes(){
		return new HashSet<N>(noder.keySet());
	}
	
	public List<Edge<N>> getEdgesFrom(N n){
		if (!noder.containsKey(n)) throw new NoSuchElementException();
		return noder.get(n);
	}

	public List<Edge<N>> getEdgesBetween(N a, N b){
		if (!noder.containsKey(a) || !noder.containsKey(b))
			throw new NoSuchElementException("Angiven nod finns ej i graf!");
			
		List<Edge<N>> list1 = getEdgesFrom(a);
		List<Edge<N>> list2 = new ArrayList<Edge<N>>();
		for (Edge<N> e : list1){
			if (e.getDest().equals(b)){
			list2.add(e);
			}
		}
		return list2;}
		
	public String toString(){
		String text = "";
		Set<N> noder = getNodes();
		for (N nod : noder){
			text += nod.toString()+" : ";
			List<Edge<N>> edges = getEdgesFrom(nod);
			for (Edge<N> edge : edges){
				text += edge.toString()+" | ";
			}
			text+="\n";
		}
		return text;
	}
	
	public Map<N,ArrayList<Edge<N>>> retMap(){
		return noder;}
	
}