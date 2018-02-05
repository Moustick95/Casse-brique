package Jeux;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Interface extends JFrame {
	
  public Interface(){    
	//R�cup�re taille de l'�cran
	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)dimension.getHeight();
	int width = (int)dimension.getWidth();
    this.setTitle("Ma premi�re fen�tre Java");
    this.setSize(width, height-50);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau());
    this.setResizable(false);
    this.setVisible(true);
  }
  
}