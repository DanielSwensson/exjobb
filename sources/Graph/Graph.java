package Graph;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<N> {

	void add(N node);

	Set<N> getNodes();

	void connect(N from, N to, String n, int v);

	List<Edge<N>> getEdgesFrom(N stad);

	List<Edge<N>> getEdgesBetween(N from, N to);

	String toString();

	void EraseAll();

	boolean NodeExists(N node);

	Edge<N> GetEdge(N from, String vald);

	Map<N, List<Edge<N>>> getGraph();
}
