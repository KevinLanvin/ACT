import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class ConstructeurLigneToits {
	
	public List<Point> generateLineFromBuildings (List<Immeuble> liste){
		if(liste.size()>1){
			List<Immeuble> l1 = liste.subList(0, liste.size()/2);
			List<Immeuble> l2 = liste.subList(liste.size()/2, liste.size());
			return this.fusionne(this.generateLineFromBuildings(l1), this.generateLineFromBuildings(l2));
		}
		else
			return liste.get(0).generateLine();
	}
	

	public List<Point> fusionne (List<Point> l1 , List<Point> l2){
		
		List<Point> l3 = this.initializeLigneFrom(l1,l2);
		//Suppression des points inutiles
		for(int i=1; i<l3.size(); ++i){
			//Suppression des points de même abscisse de hauteur différente (on garde la plus grande hauteur
			if(l3.get(i).x == l3.get(i-1).x){
				if(l3.get(i).y <= l3.get(i-1).y)
					l3.remove(i);
				else 
					l3.remove(i-1);
			}
			//Suppression des points consécutifs de même hauteur
			if(l3.get(i).y == l3.get(i-1).y)
				l3.remove(i-1);
		}
		return l3;
	}
	
	private List<Point> initializeLigneFrom(List<Point> l1, List<Point> l2){
		List<Point> l3 = new ArrayList<Point>();
		int i=0;
		int j=0;
		while(i<l1.size() || j < l2.size()){
			if(j==l2.size()){
				l3.add(l1.get(i));
				++i;
			} else if (i==l1.size()){
				l3.add(l2.get(j));
				++j;
			} else if (l1.get(i).x < l2.get(j).x){
				if(this.detectCrossLines(i,j,l1,l2)){
					//S'il y a croisement en descente, on supprime le point precedent qui sera sous la ligne et on ajoute le point correspondant au croisement
					if(l2.get(j-1).x >= l1.get(i-1).x)
						l3.remove(l2.get(j-1));
					l3.add(new Point(l1.get(i).x,l2.get(j-1).y));
				}else if(j==0 || l1.get(i).y >= l2.get(j-1).y)
					//On ne l'ajoute que si le point est au dessus du précédent de l'autre ligne
					//Sinon, soit il est inutile, soit il forme un croisement de lignes (déjà traité)
					l3.add(l1.get(i));
				++i;
			} else if (l1.get(i).x > l2.get(j).x){
				if(this.detectCrossLines(j, i, l2, l1)){
					if(l1.get(i-1).x >= l2.get(j-1).x)
						l3.remove(l1.get(i-1));
					l3.add(new Point(l2.get(j).x,l1.get(i-1).y));
				}else if(i==0 || l2.get(j).y >= l1.get(i-1).y)
					l3.add(l2.get(j));
				++j;
			} else { //les points en i et j sont à la même abscisse. On garde le plus haut des deux et on ignore l'autre
				if(l1.get(i).y > l2.get(j).y)
					l3.add(l1.get(i));
				else 
					l3.add(l2.get(j));
				++i; ++j;
			}
		}
		return l3;
	}
	
	private boolean detectCrossLines(int currentIndex, int otherListIndex, List<Point>currentList, List<Point> otherList){
		try {
			int horizontalHeight	= otherList.get(otherListIndex-1).y;
			int lastHeight			= currentList.get(currentIndex-1).y;
			int currentHeight		= currentList.get(currentIndex).y;
			return (lastHeight > horizontalHeight && horizontalHeight > currentHeight) ;
		} catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
	}

	public static void main(String[] args) {
		ConstructeurLigneToits constructeur = new ConstructeurLigneToits();
		List<Immeuble> l1 = new ArrayList<Immeuble>();
		
		l1.add(new Immeuble(1,11,5));
		l1.add(new Immeuble(3,6,7));
		l1.add(new Immeuble(3,13,9));
		l1.add(new Immeuble(12,7,16));
		l1.add(new Immeuble(16,3,25));
		l1.add(new Immeuble(19,18,22));
		
		
		List<Point> l3 = constructeur.generateLineFromBuildings(l1);
		System.out.print("{");
		for(Point p : l3)
			System.out.print("("+p.x+","+p.y+")");
		System.out.println("}");
				
		
	}
	
}
