package obj5;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Graficos extends JPanel implements ActionListener{
	
	Timer timer = new Timer(10, this);
	
	Particulas[] particles;
	ArrayList<Particulas> particlesList;
	int count;
	
	
	QuadRectangle quad;
	int tamanhoParticulas = Obj5.tamanhoParticula;
	boolean usarQuadTree = true;
	
	long tempozero = 0;
	long tempo = 0;
        int contador = 0;
	
	public Graficos()
	{
		timer.start();
		particles = Obj5.particulas;
		count = Obj5.numeroParticulas;
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (tempozero != 0)
        {
        	long processTime = System.currentTimeMillis() - tempozero;
        	tempo += processTime;
        	contador++;
        	
        	if (contador == 50)
        	{
                    calcularTempoMedio();
        		
        	}
        }
        
        tempozero = System.currentTimeMillis();
        
    	quad = new QuadRectangle(0, 0, 800, 800);  
    	particlesList = new ArrayList<Particulas>();
        
        for (int i = 0; i < count; i++)
		{
        	particles[i].desenharQuadradinhos(g);
        	particlesList.add(particles[i]);
        	
        	if (particles[i].collision)
        	{
        		particles[i].timecounter++;
        		if (particles[i].timecounter == 30)
        		{
        			particles[i].collision = false;
        			particles[i].timecounter = 0;
        		}
        			
        	}
        }
        
    
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			SeraQueColidiu();
				
		 for (int i = 0; i < count; i++)
			{
	        	particles[i].moverQuadradinhos();
	        	repaint();
			}
		
		 
	}

        
        
	private void SeraQueColidiu() {
		
		for (int i = 0; i < particles.length; i++)
		{
			for (int j = i + 1; j < particles.length; j++)
			{
				//verificando a colisão de duas bolinhas
				if ((particles[j].x - particles[i].x) * (particles[j].x - particles[i].x) +
						(particles[j].y - particles[i].y) * (particles[j].y - particles[i].y) <=
						tamanhoParticulas* tamanhoParticulas)
				{
					particles[i].collision = true;
				    particles[j].collision = true;
				
					if (particles[i].velocityX != particles[j].velocityX)
					{
                                            
                                            
                                                particles[i].velocityX *= -1;
                                                particles[j].velocityX *= -1;
						
					}
							
					if (particles[i].velocityY != particles[j].velocityY)
					{ 
                                            particles[i].velocityY *= -1;
                                            particles[j].velocityY *= -1;
						
					}
				}
	
			}
			
		
		}
		
	}
        
       private void calcularTempoMedio(){
           
           float tempoo = tempo / 50;
           System.out.println("O tempo médio das ultimas 50 colisoes foi de " + tempoo  + " milissegundos.");
          
       }

}

