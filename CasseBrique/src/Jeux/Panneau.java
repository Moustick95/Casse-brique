package Jeux;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class Panneau extends JPanel {
	
	public void Initialisation() {
		for (int i = 0; i<3; i++) {
			paintComponent(null);
		}
	}
	
	
	
	
	public void paintComponent(Graphics g){
		int resistance = 0;
        for (int d = 0; d < this.getHeight()/5*4; d+= 15) {
		int aleatoire =(int) (Math.random() * 4 );
		System.out.println(aleatoire);
		switch(aleatoire) {
		default:
			g.setColor(Color.red);
			resistance = 1;
			break;
		case 2:
			g.setColor(Color.green.darker());
			resistance = 2;
			break;
		case 3:
			g.setColor(Color.blue);
			resistance = 3;
			break;
		}

            g.fillRect(0, d, 10, 10);
            d += 15;
        }
	}               
}