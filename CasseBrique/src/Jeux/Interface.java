package Jeux;
import javax.swing.JFrame;


public class Interface extends JFrame {
	
  public Interface(){                
    this.setTitle("Ma premi�re fen�tre Java");
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau());
    this.setVisible(true);
  }
  
}