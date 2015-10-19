import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EvaluationPosition {

	protected int[][][][] values;

	public EvaluationPosition(int m, int n, int i, int j) {
		values = new int[m][n][i][j];
	}

	
	public Configuration play(Configuration c){
		
		return c;
	}
	
	
	public int evaluationDynamique(Configuration c) {
		int result = this.valueFor(c);
		if (result == 0) {
			result = this.calculateValueOf(c);
			this.storeResultBis(result, c);
		}
		return result;
	}

	private int calculateValueOf(Configuration c) {
		if (c.isMinimal())
			return 0;
		ArrayList<Configuration> successeurs = this.successeurs(c);
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		for (Configuration c2 : successeurs)
			newValues.add(evaluationDynamique(c2));

		if (this.containsNegative(newValues))
			return this.negativeCase(newValues);
		else
			return this.positiveCase(newValues);
	}

	public int evaluationNaive(Configuration c) {
		if (c.isMinimal())
			return 0;
		ArrayList<Configuration> successeurs = this.successeurs(c);
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		for (Configuration c2 : successeurs)
			newValues.add(evaluationNaive(c2));

		if (this.containsNegative(newValues))
			return this.negativeCase(newValues);
		else
			return this.positiveCase(newValues);
	}

	private int valueFor(Configuration c) {
		return values[c.m][c.n][c.i][c.j];
	}

	private void storeResultBis(int r, Configuration c) {
		for (Configuration c1 : this.getConfigsSimilarTo(c))
			this.storeResult(r, c1);
	}

	private Set<Configuration> getConfigsSimilarTo(Configuration c) {
		Set<Configuration> list = new HashSet<Configuration>();

		list.add(c);
		list.add(new Configuration(c.m, c.n, c.i, c.n - c.j + 1));
		list.add(new Configuration(c.m, c.n, c.m - c.i + 1, c.j));
		list.add(new Configuration(c.m, c.n, c.m - c.i + 1, c.n - c.j + 1));
		list.add(new Configuration(c.n, c.m, c.j, c.i));
		list.add(new Configuration(c.n, c.m, c.n - c.j + 1, c.i));
		list.add(new Configuration(c.n, c.m, c.j, c.m - c.i + 1));
		list.add(new Configuration(c.n, c.m, c.n - c.j + 1, c.m - c.i + 1));
		return list;
	}

	private void storeResult(int r, Configuration c) {
		values[c.m][c.n][c.i][c.j] = r;
	}

	private ArrayList<Configuration> successeurs(Configuration c) {
		ArrayList<Configuration> result = new ArrayList<Configuration>();
		for (int i = 1; i < c.getM(); ++i)
			if (i < c.getI())
				result.add(new Configuration(c.getM() - i, c.getN(), c.getI()
						- i, c.getJ()));
			else
				result.add(new Configuration(i, c.getN(), c.getI(), c.getJ()));

		for (int j = 1; j < c.getN(); ++j)
			if (j < c.getJ())
				result.add(new Configuration(c.getM(), c.getN() - j, c.getI(),
						c.getJ() - j));
			else
				result.add(new Configuration(c.getM(), j, c.getI(), c.getJ()));

		return result;
	}

	private boolean containsNegative(ArrayList<Integer> list) {
		for (Integer i : list) {
			if (i <= 0)
				return true;
		}
		return false;
	}

	private int negativeCase(ArrayList<Integer> list) {
		int max = -list.size();
		for (Integer i : list)
			if (i <= 0)
				max = Math.max(i, max);
		return -(max - 1);
	}

	private int positiveCase(ArrayList<Integer> list) {
		int max = 0;
		for (Integer i : list)
			max = Math.max(i, max);
		return -(max + 1);

	}

}
