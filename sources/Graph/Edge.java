package Graph;
public class Edge<N> {
	private N dest;
	private String namn;
	private int vikt;

	public Edge(N dest, String namn, int vikt) {
		this.dest = dest;
		this.namn = namn;
		this.vikt = vikt;
	}

	public N getDest() {
		return dest;
	}

	public String getNamn() {
		return namn;
	}

	public int GetVikt() {
		return vikt;
	}

	public void SetVikt(int v) {
		if (v < 0)
			throw new IllegalArgumentException("Negativt vŠrde");
		else
			vikt = v;
	}

	public String toString() {
		return "Till " + dest + " med " + namn + " tid: " + vikt;
	}
}
