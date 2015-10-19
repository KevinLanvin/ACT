public class Main {
	
	
	public static void main(String[] args) {
		Configuration c = new Configuration(5,5,3,2);
		EvaluationPosition e = new EvaluationPosition(6,6,6,6);
		System.out.println(e.evaluationDynamique(c));
	}
}
