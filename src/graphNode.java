public class graphNode {

	private int nodeID;
	private graphNode next;
	
	public graphNode( int id){
		nodeID = id;
		next =null;
	}
	
	public graphNode(){
		nodeID =-999;
		next=null;
	};

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public graphNode getNext() {
		return next;
	}

	public void setNext(graphNode next) {
		this.next = next;
	}
}
