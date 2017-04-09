package personnages.concret;

public enum Arme {
	ARC (1),
	EPEE (2),
	HACHE (3);
	
	private int puissance;
	
	Arme(){
		
	}
	
	Arme(int p){
		this.puissance = p;
	}
	
	public int getPuissance(){
		return this.puissance;
	}
}
