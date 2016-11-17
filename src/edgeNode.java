
public class edgeNode {

	private int Ni;
	private int Nj;
	private int edgeCost;
	private edgeNode next;
	boolean flag;
	
	
	public edgeNode(){
		Ni=-999;
		Nj=-999;
		edgeCost=-999;
		next= null;
		flag=false;
	}
	
	public edgeNode (int i, int j, int cost){
		Ni=i;
		Nj=j;
		edgeCost=cost;
		next=null;
		flag=false;
	}

	public int getNi() {
		return Ni;
	}

	public void setNi(int ni) {
		Ni = ni;
	}

	public int getNj() {
		return Nj;
	}

	public void setNj(int nj) {
		Nj = nj;
	}

	public int getEdgeCost() {
		return edgeCost;
	}

	public void setEdgeCost(int edgeCost) {
		this.edgeCost = edgeCost;
	}

	public edgeNode getNext() {
		return next;
	}

	public void setNext(edgeNode next) {
		this.next = next;
	}
	
}
