package graphs;

import java.util.*;
interface Graph<N>{
	void add(N node);
	void connect(N from, N to, String how, int weight);
	Set<N> getNodes();
	List<Edge<N>> getEdgesFrom(N n);
	List<Edge<N>> getEdgesBetween(N a, N b);
}