package personnages.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La classe Afficheur permet d'afficher dans une fenêtre 
 * un tableau d'images avec un niveau associé (%), 
 *  les images sont toutes de même taille.
 * @author M2103-Team
 */
public class Afficheur extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int largeurNiveau = 50;
	private ImageIcon[][] images;
	private int hauteurImage, largeurImage;
	private int[][] niveaux;
	private int lignes, colonnes;

	/**
	 * Constructeur de la classe Afficheur 
	 * les données sont fournies sous forme de tableaux 2D
	 * @param titre  le titre de la fenêtre
	 * @param chemins  chemins des fichiers images
	 * @param niveaux  le tableau des valeurs des niveaux associés
	 */
	public Afficheur(String titre, String[][] chemins, int[][] niveaux) {
		lignes = chemins.length;
		colonnes = chemins[0].length;
		JFrame fenetre = new JFrame();
		images = new ImageIcon[lignes][colonnes];
		this.niveaux = niveaux;
		for (int i = 0; i < lignes; i++) { for (int j = 0; j < colonnes; j++) { images[i][j] = new ImageIcon(chemins[i][j]); } }

		hauteurImage = images[0][0].getIconHeight() + 2;
		largeurImage = images[0][0].getIconWidth() + 2;

		fenetre.setTitle(titre);
		fenetre.setSize(colonnes * (largeurImage + largeurNiveau) + 50, lignes * hauteurImage + 50);
		fenetre.setLocationRelativeTo(null);
		fenetre.setLayout(new FlowLayout());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setPreferredSize(new Dimension(colonnes * (largeurImage + largeurNiveau), lignes * (hauteurImage)));
		this.setBackground(Color.BLACK);
		fenetre.getContentPane().add(this);
		fenetre.setVisible(true);
	}

	/* (non-Javadoc)  @see javax.swing.JComponent#paintComponent(java.awt.Graphics)  */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int left = 2, top = 1, n = 0;
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				g.drawImage(images[i][j].getImage(), left, top, null);
				left += largeurImage;
				g.setColor(Color.RED);
				n = niveaux[i][j];
				g.fillRect(left + 5, top + 100-n, 40,n);
				left += largeurNiveau;
			}
			left = 2;
			top += hauteurImage;
		}
	}

	/**
	 * Méthode permettant de modifier les niveaux, et de réafficher
	 * @param niveaux  tableau des pourcentages
	 */
	public void setNiveaux(int[][] niveaux) {
		try { Thread.sleep(500l); } catch (Exception e) { }
		this.niveaux = niveaux;
		repaint();
	}

	/**
	 * Retourne le tableau d'entiers, pourcentages représentant les niveaux
	 * @return le tableau de pourcentages
	 */
	public int[][] getNiveaux() { return niveaux; }

	/**
	 * Méthode d'affichage
	 */
	public void affichage() { repaint(); }

}