package Jeux;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class Panneau extends JPanel {
	private int posX = -50;
	private int posY = -50;
	
	public void Initialisation() {
		paintComponent(null);
	}
	
	public void paintComponent(Graphics g){
		//Fond noir
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
		int resistance = 0;
        for (int d = this.getHeight()/10; d < this.getHeight()/5*3; d += 50) {
        	for (int t = this.getWidth()/20; t < this.getWidth()/20*19; t += 50) {
				int aleatoire =(int) (Math.random() * 4 );
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
				
				g.fillRect(t, d, 35, 10);
        	}
        }
				joueur1(g,this.PosSourisX());
	}  
	
	public int PosSourisX() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		return x;
	}
	
	//Tssdf
	/*public void mousePressed(MouseEvent e,Graphics g) {
        int x = e.getX();
        int y = e.getY();
        g.fillRect(x, y, 50, 70);
        g.drawRect(x, y, 50, 70);
        repaint();
    }*/
	
	public void joueur1(Graphics g,int x) {
		g.setColor(Color.white);
		g.fillRect(x,this.getHeight()-25,90,7);
		g.drawRect(x,this.getHeight()-25,90,7);
	}
        
        //Cercle rouge
        g.setColor(Color.red);
        g.fillOval(posX, posY, 13, 13);
      }

      public int getPosX() {
        return posX;
      }

      public void setPosX(int posX) {
        this.posX = posX;
      }

      public int getPosY() {
        return posY;
      }

      public void setPosY(int posY) {
        this.posY = posY;
      }
	
}