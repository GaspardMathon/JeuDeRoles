package personnages.concret;

public enum Element {
	AIR ("Air"),
	EAU ("Eau"),
	FEU ("Feu"),
	TERRE ("Terre");
	
	private String element;
	
	Element(String element){
		this.element = element;
	}
	
	public String toString(){
		return element;
	}
	
	Element(){
		
	}
	
	public boolean estOpposee(Element e){
		return (this == FEU && e == EAU) || (this == EAU && e == FEU) || (this == AIR && e == TERRE) || (this == TERRE && e == AIR);
	}
	
	public Element getOpposee(){
		return this==EAU ? FEU : this==FEU ? EAU : this==TERRE ? AIR : this==AIR ? TERRE : null;
	}
}
