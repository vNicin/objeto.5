package obj5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Particulas {
	
	public int x;
	public int y;
	public int tamanho;
	public int tamanhoMain;
	public int velocityX;
	public int velocityY;
	public Graphics2D g2D;
	public boolean collision = false;
	public int timecounter = 0;
	
	

	public Particulas(int startX, int startY, int diameter)
	{
		x = startX;
		y = startY;
		tamanho = diameter;
                tamanhoMain = Obj5.tamanho;
		Random random = new Random();
                velocityX = random. nextInt(3)+1;
                velocityY = random. nextInt(3)+1;
		
		
	}
	
	public void desenharQuadradinhos(Graphics g)
	{   
         g2D = (Graphics2D) g;
        
        if (collision){
            g2D.setColor(Color.pink);
        }else{
             g2D.setColor(Color.black);
        }
       
        
        g2D.fillRect(x, y, tamanho, tamanho);
	}
	
	public void moverQuadradinhos()
	{
            //checa se os quadradinhos estão colidindo com as "bordas" do painel gerado anteriormente no eixo y
            if (y >= tamanhoMain - tamanho || y <= 0)
		{
			collision = true;
                       mudarVelocidade(1);
			
		}
            //checa se os quadradinhos estão colidindo com as "bordas" do painel gerado anteriormente no eixo x
		if (x >= tamanhoMain - tamanho || x <= 0)
		{
			collision = true;
                        
			mudarVelocidade(0);
		}
		
		
		
		x += velocityX;
		y += velocityY;
	}

        
        public void mudarVelocidade(int a){
            
            if(a==1){
                if (y >= tamanhoMain - tamanho){
				velocityY = -1;
			
			if (y <= 0)
				velocityY = 1;
            }
                
            if(a==0){
                if (x >=tamanhoMain - tamanho)
				velocityX = -1;
			
			if (x <= 0)
				velocityX = 1;
            }
            
        }

}
}