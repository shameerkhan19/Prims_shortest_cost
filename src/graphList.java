import java.io.PrintWriter;

public class graphList {

	private graphNode head;
	private graphNode tail;
	private int size;
	
	public graphList(){
		head= new graphNode();
		tail= head;
		size=1;
	}
	
	public void append(int x){
		graphNode n = new graphNode(x);
		if(head==null){
			head= n;
			tail=head;
			size++;
		}
		tail.setNext(n);
		tail=n;
		size++;
	}
	
	public int delete(int x){
		graphNode current=head;
		while(current.getNext().getNodeID()!=x)
			current=current.getNext();
		int target = current.getNext().getNodeID();
		current.setNext(current.getNext().getNext());
		size--;
		return target;
	}
	
	public void print(PrintWriter pw){
		graphNode current =head;
		while(current!=null){
			pw.print(current.getNodeID()+ " ");
			current=current.getNext();
		}
		pw.println();
	}

	public graphNode getHead() {
		return head;
	}

	public void setHead(graphNode head) {
		this.head = head;
	}

	public graphNode getTail() {
		return tail;
	}

	public void setTail(graphNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	boolean isEmpty(){
		if(size==1)return true;
		else 
			return false;
	}
}
