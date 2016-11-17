import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class primMST {
	
	private int N;
	private int totalCost;
	private int graphNodeIDArry[];
	private edgeList elist = new edgeList();
	private graphList setA = new graphList();
	private graphList setB = new graphList();
	private edgeList MSTofG = new edgeList();
	private Scanner scan;
	private PrintWriter pw, pw2;
	
	public primMST(String arg1, String arg2, String arg3)throws IOException{
		scan = new Scanner(new FileReader(arg1));
		pw = new PrintWriter(new FileWriter(arg2));
		pw2 = new PrintWriter(new FileWriter(arg3));
		N=Integer.parseInt(scan.next());
		totalCost=0;
		graphNodeIDArry = new int [N+1];
		for(int i=0; i<graphNodeIDArry.length;i++){
			graphNodeIDArry[i]=0;
		}
		while(scan.hasNext()){
			edgeNode node = new edgeNode(Integer.parseInt(scan.next()),Integer.parseInt(scan.next()),Integer.parseInt(scan.next()));
			elist.insert(node);
			graphNodeIDArry[node.getNi()]++;
			graphNodeIDArry[node.getNj()]++;
		}
		printIDArry();
		elist.print(pw2);
	};
	
	public void printIDArry(){
		for(int i=0; i<graphNodeIDArry.length;i++){
			pw2.print(graphNodeIDArry[i]+ " ");
		}
		pw2.println();
	}
	
	public void assignA_B(){
		for(int i=0;i<graphNodeIDArry.length;i++){
			if(graphNodeIDArry[i]!=0){
				if(i==1){
					setA.append(i);
				}
				else{
					setB.append(i);
				}
			}
		}
		setA.print(pw2);
		setB.print(pw2);
	}
	
	public void prims(){
		while(!setB.isEmpty()){
			//temp =elist;
			edgeNode start = elist.getHead().getNext();
			while(start!=null){
			//	System.out.println(difference(start.getNi(),start.getNj()));
				if((isitInA(start.getNi())&& isitInB(start.getNj()))||(isitInA(start.getNj())&& isitInB(start.getNi()))){
					//System.out.println(difference(start.getNi(),start.getNj()));
					graphNode deleteLocation = setB.getHead().getNext();
					while(deleteLocation!=null){
						if(deleteLocation.getNodeID()==start.getNj()){
							int x= setB.delete(start.getNj());
							setA.append(x);
						}
						else if(deleteLocation.getNodeID()==start.getNi()){
							int x = setB.delete(start.getNi());
							setA.append(x);
						}
						deleteLocation =deleteLocation.getNext();
					}
					//System.out.println(start.getNi()+" "+start.getNj()+" "+start.getEdgeCost());
					totalCost+=start.getEdgeCost();
					//edgeNode e=(temp.specificDelete(start));
					edgeNode e = new edgeNode(start.getNi(),start.getNj(),start.getEdgeCost());
					MSTofG.append(e);
					//System.out.println(e.getNi()+" "+e.getNj()+" "+e.getEdgeCost());
					break;
				}
				pw2.println("SetA and SetB so far: ");
				setA.print(pw2);
				setB.print(pw2);
				start=start.getNext();
				//System.out.println("hello");
				//pw2.println(start.getNi()+" "+start.getNj()+start.getEdgeCost());
				pw2.println("Cost table so far: ");
				MSTofG.print(pw2);
				pw2.print("Cost so far : "+ totalCost);
				pw2.println();
				pw2.println();
			}
		}
		pw.println("Final MSTofG: ");
		pw.println(MSTofG.getSize());
		MSTofG.print(pw);
		setA.print(pw2);
		setB.print(pw2);
		//elist.print(pw);
		pw.print("final total Cost: "+totalCost);
	}
	
	public boolean isitInA(int x){
		graphNode current = setA.getHead().getNext();
		while(current!=null){
			if(current.getNodeID()==x)
				return true;
			current=current.getNext();
		}
		return false;
	}
	
	public boolean isitInB(int x){
		graphNode current =setB.getHead().getNext();
		while(current!=null){
			if(current.getNodeID()==x)
				return true;
			current=current.getNext();
		}
		return false;
	}
	
	public boolean isitinB(int x){
		graphNode point = setB.getHead().getNext();
		while(point!=null){
			if(point.getNodeID()==x)
				return true;
			point=point.getNext();
		}
		return false;
	}
	
	public void closeIO(){
		scan.close();
		pw.close();
		pw2.close();
	}
}
