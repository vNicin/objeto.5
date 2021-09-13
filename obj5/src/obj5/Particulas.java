package obj5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Particulas {
	
	public int x;
	public int y;
	public int tamanho;
	public int velocityX;
	public int velocityY;
	
	
	

	public Particulas(int startX, int startY, int diameter)
	{
		x = startX;
		y = startY;
		tamanho = diameter;
		Random random = new Random();
                velocityX = random. nextInt(3)+1;
                velocityY = random. nextInt(3)+1;
		
		
	}
	
}