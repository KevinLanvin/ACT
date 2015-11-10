package TSP;

public class main {
		
	public static void main(String[] args) {
		int [][] t = { {0,2,5,7},{7,0,8,1},{2,1,0,9},{2,2,8,0} };
		
		TSP tsp = new TSP(4, t, 45);
		CertificatTSP ctsp = new CertificatTSP(tsp);
		
		ctsp.alea();
		ctsp.display();
	}

}
