package Graph;
import java.util.*;

public class ListGraph<N> implements Graph<N> {
	private Map<N, List<Edge<N>>> nodes = new HashMap<N, List<Edge<N>>>();

	public void add(N node)  {
		if (!nodes.containsKey(node))
			nodes.put(node, new ArrayList<Edge<N>>());
		else{
		}
	}
	
	public boolean NodeExists(N node){
		if(nodes.containsKey(node))
			return true;
		else{
			return false;
		}
	}

	public void connect(N from, N to, String n, int v) {
		List<Edge<N>> fromList = nodes.get(from);
		List<Edge<N>> toList = nodes.get(to);
		if (fromList == null || toList == null)
			throw new NoSuchElementException("connect");
		if(v < 0){
			throw new IllegalArgumentException("Negativt vŠrde");
		}
		Edge<N> e1 = new Edge<N>(to, n, v);
		fromList.add(e1);
		Edge<N> e2 = new Edge<N>(from, n, v);
		toList.add(e2);

	}
	
	public Set<N> getNodes(){
		return new HashSet<N>(nodes.keySet());
		
	}
	
	public List<Edge<N>> getEdgesFrom(N stad){
		List<Edge<N>> fromList = nodes.get(stad);
		if (fromList == null)
			throw new NoSuchElementException("Get Edges from");
		return fromList;	
	}
	
	public List<Edge<N>> getEdgesBetween(N from, N to){
		if(!nodes.containsKey(from)|| (!nodes.containsKey(to)))
			throw new NoSuchElementException("Between");
		
		List<Edge<N>> between = new ArrayList<Edge<N>>();
		for(Edge<N> e : nodes.get(from)) {
			if (e.getDest().equals(to)){
				between.add(e);
			}
		}
		
				
		return between;

	}
	
	public String toString(){
		String str="";
		for(Map.Entry<N, List<Edge<N>>> n : nodes.entrySet()){
			str += n.getKey() + ": ";
		for(Edge<N> e : n.getValue())
			str += e.toString() + " ";
		str += "\n";
		}
		
		return str;
		
	}
	
	public void EraseAll(){
		nodes.clear();
	}
	
	public Edge<N> GetEdge(N from,String vald){
		Edge<N> valda = null;
		for(Edge<N> e : nodes.get(from)) {
			if (e.toString().equals(vald)){
				valda = e;
			}
		}	
		return valda;
	}
	

	
	public Map<N, List<Edge<N>>> getGraph(){
		return nodes;
	}


	
}
