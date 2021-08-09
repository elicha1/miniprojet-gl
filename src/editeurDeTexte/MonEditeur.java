package editeurDeTexte;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class MonEditeur extends JFrame implements ActionListener {

	// enregistrement

	private JFileChooser fc = new JFileChooser();
	//
	private JLabel lab = new JLabel();
	private JMenuBar menuBar = new JMenuBar();

	private JMenu Fichier = new JMenu("Fichier");
	private JMenu Edition = new JMenu("Edition");
	private JMenu MiseEnPage = new JMenu("Mise en page");
	private JMenu Aide = new JMenu("Aide");
	// fichier
	private JMenuItem ouvrir = new JMenuItem("ouvrire");
	private JMenuItem fermer = new JMenuItem("fermer");
	private JMenuItem nouveau = new JMenuItem("nouveau");
	private JMenuItem enregistrer = new JMenuItem("enregistrer");
	private JMenuItem quitter = new JMenuItem("quitter");
	// edition
	private JMenuItem couper = new JMenuItem("couper");
	private JMenuItem copier = new JMenuItem("copier");
	private JMenuItem coller = new JMenuItem("coller");
	private JMenuItem selectionner = new JMenuItem("selectionner");
	private JMenuItem supprimer = new JMenuItem("supprimer");
	// mise en page
	private JMenuItem police = new JMenuItem("police");
	private JMenuItem fondEcran = new JMenuItem("fond d'ecran");
	// elements
	// police
	private JMenuItem taille = new JMenuItem("Taille");
	private JMenuItem t1 = new JMenuItem("7");
	private JMenuItem t2 = new JMenuItem("14");
	private JMenuItem t3 = new JMenuItem("25");
	private JMenuItem couleur = new JMenuItem("couleur");
	private JMenuItem c1 = new JMenuItem("blue");
	private JMenuItem c2 = new JMenuItem("red");
	private JMenuItem c3 = new JMenuItem("black");

	// font d'ecran
	private JMenuItem couleur1 = new JMenuItem("couleur");
	private JMenuItem c11 = new JMenuItem("blue");
	private JMenuItem c12 = new JMenuItem("red");
	private JMenuItem c13 = new JMenuItem("white");

	private JTextArea textZone = new JTextArea(10, 10);
	private JPanel paneau = new JPanel();

	// constructeur
	public MonEditeur()  {

		setSize(400, 200);// grandeur
		setTitle("My Editor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// menu fichier
		Fichier.add(nouveau);
		Fichier.add(ouvrir);
		Fichier.add(enregistrer);
		Fichier.add(quitter);
		// menu edition
		Edition.add(copier);
		Edition.add(coller);
		Edition.add(selectionner);
		Edition.add(supprimer);
		// menu mise en page
		MiseEnPage.add(police);
		MiseEnPage.add(fondEcran);
		//
		police.add(taille);
		police.add(couleur);
		//
		fondEcran.add(couleur1);
		//
		taille.add(t1);
		taille.add(t2);
		taille.add(t3);
		//
		couleur.add(c1);
		couleur.add(c2);
		couleur.add(c3);
		//
		couleur1.add(c11);
		couleur1.add(c12);
		couleur1.add(c13);

		setJMenuBar(menuBar);
	}

	// actions
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == couper)
			textZone.cut();
		if (e.getSource() == coller)
			textZone.paste();
		if (e.getSource() == copier)
			textZone.copy();
		if (e.getSource() == selectionner)
			textZone.selectAll();
	// enregitrement
		if (e.getSource() == enregistrer) {
			try {
				File fichier = fc.getSelectedFile();
				FileWriter outputStream = new FileWriter(fichier.getPath());
				outputStream.write(textZone.getText());
				outputStream.close();
				setTitle("Text Editor-" +fichier.getName());
			} catch (IOException ioe) {
				System.out.println("IOException");
			}
		}
	}

	// Main
	public static void main(String[] args) {
		new MonEditeur();
	}
}