package personnages.abstrait;
import java.util.Random;

public interface Vivant {
	static final Random ALEA = new Random();
	
	public void attaque(Vivant v);
	
	public void subitAttaque(Vivant v);
	
	public void perte(int i);
	
	public int getForce();
	
	public boolean estVivant();
}
