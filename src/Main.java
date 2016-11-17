import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			primMST pr = new primMST(args[0],args[1],args[2]);
			pr.assignA_B();
			pr.prims();
			pr.closeIO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
