package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		//les visages
		Visage v1 = new Visage(d);
        Visage v2 = new Visage(d, 100, 100);
        d.ajouterObjet(v1);
        d.ajouterObjet(v2);
        //l'étoile et le polygone fixe
        d.ajouterObjet(new Etoile(200, 100, 90, 2.0f, Color.GREEN, Color.GREEN));
        d.ajouterObjet(new PolygoneRegulier(5, 400, 200, 70, 2.0f, Color.BLACK, Color.BLACK));
// etoile jaune animer jaune
        d.ajouterObjet(new AnimationForme(
                new Etoile(300, 200, 100, 7.0f, Color.YELLOW, Color.YELLOW),
                new MvtCirculaire(500, 200, 200, 0.0, 5))
        );
        //polygone animer gris
        d.ajouterObjet(new AnimationForme(
                new PolygoneRegulier(5, 600, 300, 50, 8.0f, Color.gray, Color.gray),
                new MvtCirculaire(400, 100, 150, 0.0, 7))
        );
      

      

		
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}

	}

}
