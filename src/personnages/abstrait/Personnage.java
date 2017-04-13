package personnages.abstrait;

public abstract class Personnage {
	private String nom;
	private int vie;
	private int force;
	private static int nbPersonnages = 0;
	//private int numeroPersonnage;
	
	public String getNom(){
		return this.nom;
	}
	
	public int getVie(){
		return this.vie;
	}
	
	public int getForce(){
		return this.force;
	}
	
	public void setForce(int f){
		this.force = f;
	}
	
	public Personnage(){
		this.nom = "" + nbPersonnages;
		nbPersonnages++;
		this.force = 10;
		this.vie = 100;
	}
	
	public Personnage(String nom){
		this.nom = nom;
		this.force = 10;
		this.vie = 100;
	}
	
	public void perte(int degats){
		this.vie -= degats;
	}
	
	public boolean estVivant(){
		return this.vie == 0;
	}
	
	public void attaque(Vivant v){
		v.perte(this.getForce());
		this.force++;
	}
	
	public void subitAttaque(Vivant v){
		this.perte(v.getForce());
	}
	
	public String toString(){
		return "Je s'appelle " + this.nom 
				+ ", je possède encore " + this.vie 
				+ " points de vie et ma force actuelle est de " + this.force 
				+ "."; 
	}
}
