package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class GraphMethods<N> {

	
	public static<N> boolean pathExists(Graph<N> g,N from, N to){
		Set<N> bes�kta = new HashSet<N>();
		depthFirstSearch(g, from, bes�kta);
		return bes�kta.contains(to);
	}

	private static<N> void depthFirstSearch(Graph<N> g, N stad,Set<N> bes�kta) {
		bes�kta.add(stad);
			for(Edge<N> e: g.getEdgesFrom(stad))
				if (!bes�kta.contains(e.getDest()))	
					depthFirstSearch(g, e.getDest(),bes�kta);
		
	}
	


		public static <N> List<Edge<N>> shortestPath(Graph<N> graph, N from, N to){
			if(!GraphMethods.pathExists(graph, from, to)){									
				return null;
			}
			List<N> list = new ArrayList<N>();

			Map<N, List<Edge<N>>> hm = new HashMap<N, List<Edge<N>>>(graph.getGraph());			
			Map<N, Table<N>> tableMap = new HashMap<N, Table<N>>();				
			
			
			Collection<N> col = hm.keySet();											
			Iterator<N> itr = col.iterator();											
			while(itr.hasNext())													
				tableMap.put((N) itr.next(), new Table<N>());						
			
			N temp = from;
			
			tableMap.get(temp).setWeight(0);
			boolean run = true;
		
			
			
			while(run){
				run = false;
				if(temp == null)
					break;
				tableMap.get(temp).setBest�md(true);

				for(Edge<N> edge : hm.get(temp)){
					int vikt = edge.GetVikt() + tableMap.get(temp).getWeight();
					if(!tableMap.get(edge.getDest()).getBest�md() && tableMap.get(edge.getDest()).getWeight() > vikt){
						tableMap.get(edge.getDest()).setWeight(vikt);
						tableMap.get(edge.getDest()).addThrough(temp);
					}
				}
				
				
				int min = Integer.MAX_VALUE;

				for(N node : tableMap.keySet()){
					if(tableMap.get(node).getWeight() < min && !tableMap.get(node).getBest�md()){
						min = tableMap.get(node).getWeight();
						temp = node;
						
					}
					if(!tableMap.get(node).getBest�md())
						run = true;
				}
				
			}
		
			
			N node = to;
			list.add(to);
			boolean run2 = true;
			while(run2){
				if(tableMap.get(node).getThrough() != null){
					list.add(tableMap.get(node).getThrough());
					node = tableMap.get(node).getThrough();
				}
				else
					run2 = false;
			}
			
			Collections.reverse(list);
			List<Edge<N>> Edgelist = new ArrayList<Edge<N>>();
			if(list.size()>1){
				for(int i =0; i < list.size()-1; i++){
					int minstv�rde = Integer.MAX_VALUE;
					Edge<N> em = null;
					
					for(Edge<N> e: graph.getEdgesBetween(list.get(i), list.get(i+1))){
						if(e.GetVikt() < minstv�rde){
							em = e;
							minstv�rde = em.GetVikt();
						}
	
					}
					Edgelist.add(em);
					}
			}
			else if(list.size() == 1){
				int minstv�rde = Integer.MAX_VALUE;
				Edge<N> em = null;
					
					for(Edge<N> e: graph.getEdgesBetween(list.get(0), list.get(1))){
						
						if(e.GetVikt() < minstv�rde){
							em = e;
							minstv�rde = em.GetVikt();

						}
				}
					Edgelist.add(em);

			}
			list.clear();
			hm.clear();
			tableMap.clear();
			return Edgelist;
		}
	}
class Table<N>{
	private int weight = Integer.MAX_VALUE;
	private boolean best�md = false;
	private N through = null;
	
	public boolean getBest�md(){
		return best�md;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public void setBest�md(boolean best�md){
		this.best�md = best�md;
	}
	public void addThrough(N node){
		through = node;
	}
	public N getThrough(){
		return through;
	}
}	
	
	

