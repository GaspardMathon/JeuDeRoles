package personnages.abstrait;

import personnages.concret.Element;

public interface Magicien extends Vivant{
	
	public void attaque(Magicien m);
	
	public void subitAttaque(Magicien m);
	
	public Element getElement();
}
