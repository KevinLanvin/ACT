import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Immeuble {
	public int g,h,d;

	public Immeuble(int g, int h, int d) {
		super();
		this.g = g;
		this.h = h;
		this.d = d;
	}
	
	public List<Point> generateLine(){
		List<Point> ligne = new ArrayList<Point>();
		ligne.add(new Point(g,h));
		ligne.add(new Point(d,0));
		return ligne;
	}
}
