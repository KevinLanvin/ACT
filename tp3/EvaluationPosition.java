package tp3;

import java.util.ArrayList;

public class EvaluationPosition {

	
	
	public int evaluationNaive(Configuration c){
		System.out.println("Entering configuration : " + c);
		if(c.isMinimal())
			return 0;
		ArrayList<Configuration> successeurs = this.successeurs(c);
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		for(Configuration c2 : successeurs)
			newValues.add(evaluationNaive(c2));
		
		if(this.containsNegative(newValues))
			return this.negativeCase(newValues);
		else
			return this.positiveCase(newValues);
	}

	
	public ArrayList<Configuration> successeurs(Configuration c){
		ArrayList<Configuration> result = new ArrayList<Configuration>();
		for(int i=1; i < c.getM();++i)
			if(i < c.getI())
				result.add(new Configuration(c.getM()-i,c.getN(),c.getI()-i,c.getJ()));
			else 
				result.add(new Configuration(i, c.getN(), c.getI(), c.getJ()));
			

		for(int j=1; j < c.getN();++j)
			if(j < c.getJ())
				result.add(new Configuration(c.getM(),c.getN()-j,c.getI(),c.getJ()-j));
			else 
				result.add(new Configuration(c.getM(), j, c.getI(), c.getJ()));
			
		return result;
	}
	
	private boolean containsNegative(ArrayList<Integer> list){
		for(Integer i : list){
			if (i<0)
				return true;
		}
		return false;
	}
	
	private int negativeCase(ArrayList<Integer> list){
		int max=-list.size();
		for(Integer i : list)
			if (i<0)
				max= Math.max(i, max);
		return -(max -1);		
	}
	
	private int positiveCase (ArrayList<Integer> list){
		int max = 0;
		for(Integer i : list)
			max = Math.max(i,max);
		return -(max +1);
	
	}
	
}
