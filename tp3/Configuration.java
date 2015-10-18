public class Configuration {
	
	protected int m;
	protected int n;
	protected int i;
	protected int j;
	
	
	public Configuration(int m, int n, int i, int j) {
		this.m = m;
		this.n = n;
		this.i = i;
		this.j = j;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}

	public boolean isMinimal(){
		return this.m==1 && this.n==1;
	}
	
	public String toString(){
		return "("+m+","+n+","+i+","+j+")";
	}
	
}
