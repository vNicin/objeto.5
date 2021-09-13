package obj5;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	Graficos graficos = new Graficos();
	
	public Frame(int width, int height)
	{
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(graficos);
		this.setVisible(true);
	}

}