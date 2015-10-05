package tp3;

public class Main {
	
	
	public static void main(String[] args) {
		Configuration c = new Configuration(10, 7, 7, 3);
		EvaluationPosition ep = new EvaluationPosition();
		System.out.println(ep.evaluationNaive(c));
	}
}
