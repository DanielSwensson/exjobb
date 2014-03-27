package graphs;

import java.util.*;

public class GraphMethods<N>{	
	public static <N>
		boolean pathExists(Graph<N> graf, N from, N to){
			Set<N> visit = new HashSet<N>();
			visit.add(from);
			deepSearch(graf,from,visit);
			if (visit.contains(to)) return true;
			else return false;
	}
	public static <N>
		void deepSearch(Graph<N> g, N a, Set<N> visit){
			List<Edge<N>> edges = g.getEdgesFrom(a);
			for (Edge<N> e : edges){
				if (!visit.contains(e.getDest())){
					visit.add(e.getDest());
					deepSearch(g,e.getDest(),visit);
				}
			}
		}
	public static <N>
		void dijkstra(Graph<N> graf, N nod, Set<N> noder, Map<N,Integer> vikt,Map<N,Boolean> best,Map<N,Edge<N>> via){
			List <Edge<N>> edges = graf.getEdgesFrom(nod);
			for (Edge<N> e : edges){
				if (vikt.get(nod)+e.getWeight()<vikt.get(e.getDest()) && !best.get(e.getDest())){
					vikt.put(e.getDest(),new Integer(e.getWeight())+vikt.get(nod));
					via.put(e.getDest(),e);
				}
			}
			Integer low = Integer.MAX_VALUE;
			N next = null;
			for (N n: noder){
				if (vikt.get(n)<low && !best.get(n)){ 
				next = n;
				low = vikt.get(n);}
			}		
			if (next!=null){
				best.put(next,Boolean.TRUE);
				
				dijkstra(graf,next,noder,vikt,best,via);
				}
		}
	public static <N>
		List<Edge<N>> shortestPath(Graph<N> graf, N from, N to){
			List<Edge<N>> lol = new ArrayList<Edge<N>>();
			if (pathExists(graf,from,to)){
				Map<N,Integer> vikt = new HashMap<N,Integer>();
				Map<N,Boolean> best = new HashMap<N,Boolean>();
				Map<N,Edge<N>> via 	= new HashMap<N,Edge<N>>();
				Set<N> noder 		= new HashSet<N>();
				noder.add(from);
				deepSearch(graf,from,noder);
				
				for (N nod : noder){
					vikt.put(nod,Integer.MAX_VALUE);
					best.put(nod,Boolean.FALSE);
					via.put(nod,null);
				}
				vikt.put(from,new Integer(0));
				best.put(from,new Boolean(true));
				
				dijkstra(graf,from,noder,vikt,best,via);
				
				N noden = to;
				while (via.get(noden)!=null){ 
				lol.add(0,via.get(noden)); 
				noden = via.get(noden).getSource(); 
				}
			}
			return lol;}
}



