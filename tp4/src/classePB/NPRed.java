package classePB;

abstract public class NPRed extends NP{

abstract public NP red();

public CertificatTSP cert() {return red().cert();}

public boolean estCorrect(Certificat cert) {
	return false;//A COMPLETER
	}

}
