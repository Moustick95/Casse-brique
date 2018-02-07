package Jeux;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


public class Interface extends JFrame {	

	private Panneau pan = new Panneau();
	
	public Interface(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width = (int)dimension.getWidth();
		this.setTitle("Ma premi�re fen�tre Java");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setSize(width, height-50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		KeyAdapter listener = new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ESCAPE)
                System.exit(0);
            }
        };
        this.addKeyListener(listener);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}

	public void go() {
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = true;
		boolean backY = true;
		
		if (pan.posSourisX() < this.getWidth() - 90)
			x = pan.posSourisX()+45;
		else
			x = this.getWidth()-45;
		pan.setPosX(x);
		y = pan.getHeight()-38;
		pan.setPosY(y);

		while (true) {
			// Si la coordonn�e x est inf�rieure � 1, on avance
			if (x < 0)
				backX = false;
			// Si la coordonn�e x est sup�rieure � la taille du Panneau moins la taille du rond, on recule
			if (x > pan.getWidth()-13)
				backX = true;
			// Idem pour l'axe y
			if (y < 1)
				backY = false;
			if ( (y > pan.getHeight()-38 && y < pan.getHeight()-13) && (x == pan.posSourisX()-7)) {
				backX = true;
				backY = true;
			}
			if ( (y > pan.getHeight()-38 && y < pan.getHeight()-13) && (x == pan.posSourisX()+90)) {
				backX = false;
				backY = true;
			}
			if (y == pan.getHeight()-38 && (x > pan.posSourisX()-10 && x < pan.posSourisX()+90))
				backY = true;
			if (y > pan.getHeight()+10) {
				if (pan.posSourisX() < this.getWidth() - 90)
					x = pan.posSourisX()+45;
				else
					x = this.getWidth()-45;
				pan.setPosX(x);
				y = pan.getHeight()-38;
				pan.setPosY(y);
				backY = true;
				backX = false;
			}

		    // Si on avance, on incr�mente la coordonn�e
		    // backX est un bool�en, donc !backX revient � �crire
		    // if (backX == false)
		    if (!backX)
		    	pan.setPosX(++x);
		    // Sinon, on d�cr�mente
		    else
		        pan.setPosX(--x);
		    // Idem pour l'axe Y
		    if (!backY)
		        pan.setPosY(++y);
		    else
		        pan.setPosY(--y);
		    // On redessine notre Panneau
		    pan.repaint();
		    // Comme on dit : la pause s'impose ! Ici, trois milli�mes de seconde
		    try {
		    	Thread.sleep(5);
		    } catch (InterruptedException e) {
		    	e.printStackTrace();
		    }
	  }
   }
}