import java.io.PrintWriter;

public class edgeList {

	private edgeNode head;
	private edgeNode tail;
	private int size;
	
	
	public edgeList(){
		head =new edgeNode();
		tail=head;
		size=1;
	}
	
	public void insert(edgeNode n){
		edgeNode current=head;
		while(current.getNext()!=null && n.getEdgeCost()>=current.getNext().getEdgeCost())
			current=current.getNext();
		n.setNext(current.getNext());
		current.setNext(n);
		size++;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public edgeNode delete(){
		edgeNode temp=head;
		head=head.getNext();
		size--;
		return temp;
	}
	
	public void print(PrintWriter pw){
		edgeNode current =head.getNext();
		while(current!=null){
			pw.print(current.getNi()+" "+current.getNj()+" "+current.getEdgeCost());
			pw.println();
			current=current.getNext();
		}
	}
	
	public edgeNode getHead() {
		return head;
	}

	public void setHead(edgeNode head) {
		this.head = head;
	}

	public edgeNode getTail() {
		return tail;
	}

	public void setTail(edgeNode tail) {
		this.tail = tail;
	}

	public boolean isEmpty(){
		if (size==1) return true;
		else
			return false;
	}
	
	public void append(edgeNode n){
		tail.setNext(n);
		tail=n;
		size++;
	}
	
	public edgeNode specificDelete(edgeNode n){
		edgeNode find = head;
		while((find.getNext().getEdgeCost()!=n.getEdgeCost())){
			find=find.getNext();
		}
		edgeNode ret=find.getNext();
		//System.out.println(ret.getNi()+" "+ret.getNj()+" "+ret.getEdgeCost());
		if(ret.getNext()!=null)
		find.setNext(ret.getNext());
		size--;
		return ret;
	}
}
