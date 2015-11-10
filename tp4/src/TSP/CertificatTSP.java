package TSP;

import java.util.Random;
import java.io.*;

import classePB.Certificat;

public class CertificatTSP implements Certificat{

	int nbville;
	public int [][] cert;
	
	public CertificatTSP(TSP tsp) {
		this.nbville = tsp.nbVilles;
		cert = new int [tsp.nbVilles+1][2];
	}

	public void saisie() {
		// TODO Auto-generated method stub
		
	}

	public void display() {

		for(int i=0;i<nbville;i++){
			System.out.println(cert[i][0]+" --> "+cert[i][1]);
		}
		
	}

	public void alea() {
		
		boolean [] villes = new boolean[nbville];
		for(int i=0;i<nbville;i=i+1)
			villes[i]=false;
			
		int vDepart=0;
		int vDirection=0;
		
		//choisi une ville de départ
		vDepart = (int)(Math.random() * (nbville));			
		villes[vDepart]=true;
		
		for(int i=0;i<nbville;i=i+1){
			do{
				vDirection = (int)(Math.random() * (nbville));
			}while( vDirection==vDepart&&!villes[vDirection] );
			villes[vDepart]=true;
			
			
			cert[i][0]=vDepart;
			cert[i][1]=vDirection;
			
			vDepart=vDirection;
		}
			

		
	}
	
	public boolean finTournee(boolean[] t){
		for(int i=0;i<nbville;i=i+1)
			if(t[i])
				return false;
		return true;
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public boolean estDernier() {
		// TODO Auto-generated method stub
		return false;
	}

	public void suivant() {
		// TODO Auto-generated method stub
		
	}

	

}
