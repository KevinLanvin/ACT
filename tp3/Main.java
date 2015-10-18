public class Main {
	
	
	public static void main(String[] args) {
		Configuration c = new Configuration(10,7,7,3);
		EvaluationPosition ep = new EvaluationPosition(11,11,11,11);
		System.out.println(ep.evaluationDynamique(c));
		/*for(int i=1; i <4; ++i){
			c.i =i;
			for(int j=1; j<4; ++j){
				c.j=j;
				if(ep.evaluationDynamique(c)== 4)
					System.out.println("("+i+","+j+")");
			}
		}*/
	}
}
