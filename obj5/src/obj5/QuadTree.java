package obj5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class QuadTree {

	QuadRectangle quad;
	int quadCapacity;
	ArrayList<Particulas> particulasDaqui;
	boolean Dividiu;
	
	QuadTree direitaCima;
	QuadTree esquerdaCima;
	QuadTree direitaBaixo;
	QuadTree esquerdaBaixo;
	
	public QuadTree(QuadRectangle boundary, int cap)
	{
		quad = boundary;
		quadCapacity = cap;
		particulasDaqui = new ArrayList<Particulas>();
		Dividiu = false;
	}
	
	void Subdivide (ArrayList<Particulas> particles)
	{
		int x = quad.x;
		int y = quad.y;
		int w = quad.width;
		int h = quad.height;
		
		ArrayList<Particulas> particularBaixoDireita = new ArrayList<Particulas>();
		ArrayList<Particulas> particulasBaixoEsquerda = new ArrayList<Particulas>();
		ArrayList<Particulas> particulasCimaDireita = new ArrayList<Particulas>();
		ArrayList<Particulas> particulasCimaEsquerda = new ArrayList<Particulas>();
		
		QuadRectangle baixoDireita = new QuadRectangle (x + w/2, y, w / 2, h / 2);
		direitaCima = new QuadTree(baixoDireita, quadCapacity);
		
		QuadRectangle baixoEsquerda = new QuadRectangle (x, y, w / 2, h / 2);
		esquerdaCima = new QuadTree(baixoEsquerda, quadCapacity);
		
		QuadRectangle cimaDireita = new QuadRectangle (x + w/2, y + h/2, w / 2, h / 2);
		direitaBaixo = new QuadTree(cimaDireita, quadCapacity);
		
		QuadRectangle cimaEsquerda = new QuadRectangle (x, y + h/2, w / 2, h / 2);
		esquerdaBaixo = new QuadTree(cimaEsquerda, quadCapacity);
		
		for (int i = 0; i < particles.size(); i++)
		{
			if (direitaCima.quad.ContainsParticle(particles.get(i)))
			{
				particularBaixoDireita.add(particles.get(i));
			}
			if (esquerdaCima.quad.ContainsParticle(particles.get(i)))
			{
				particulasBaixoEsquerda.add(particles.get(i));
			} 
			if (direitaBaixo.quad.ContainsParticle(particles.get(i)))
			{
				particulasCimaDireita.add(particles.get(i));
			}
			if (esquerdaBaixo.quad.ContainsParticle(particles.get(i)))
			{
				particulasCimaEsquerda.add(particles.get(i));
			} 	
		}	
			direitaCima.Insert(particularBaixoDireita);
			
			esquerdaCima.Insert(particulasBaixoEsquerda);
			
			direitaBaixo.Insert(particulasCimaDireita);

			esquerdaBaixo.Insert(particulasCimaEsquerda);

		
		Dividiu = true;
	}
	
	public void Insert (ArrayList<Particulas> particles)
	{
		
		
		 
			 if (particles.size() <= quadCapacity)
			 {
					 particulasDaqui = particles;		 
			 }
			 else {
				 if (Dividiu == false)
					 Subdivide (particles);
				 
				
				 
			 }
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(quad.x, quad.y, quad.width, quad.height);
		
		if (Dividiu)
		{
			direitaCima.paint(g);
			esquerdaCima.paint(g);
			direitaBaixo.paint(g);
			esquerdaBaixo.paint(g);
		}
	}
	
	public void QuadradinhoColidiu()
	{
		if (particulasDaqui.size() > 0)
		{
			for (int i = 0; i < particulasDaqui.size(); i++)
			{
				for (int j = i + 1; j < particulasDaqui.size(); j++)
				{	
							if ((particulasDaqui.get(j).x - particulasDaqui.get(i).x) * (particulasDaqui.get(j).x - particulasDaqui.get(i).x) +
							(particulasDaqui.get(j).y - particulasDaqui.get(i).y) * (particulasDaqui.get(j).y - particulasDaqui.get(i).y) <=
							Obj5.tamanhoParticula * Obj5.tamanhoParticula)
							{
								particulasDaqui.get(i).collision = true;
								particulasDaqui.get(j).collision = true;
							    
							   
								
								if (particulasDaqui.get(i).velocityX != particulasDaqui.get(j).velocityX)
								{
									particulasDaqui.get(i).velocityX *= -1;
									particulasDaqui.get(j).velocityX *= -1;
								}
								
								if (particulasDaqui.get(i).velocityY != particulasDaqui.get(j).velocityY)
								{
									particulasDaqui.get(i).velocityY *= -1;
									particulasDaqui.get(j).velocityY *= -1;
								}
							}
				}

			}
		}
		else
		{
			if (Dividiu)
			{
				direitaCima.QuadradinhoColidiu();
				esquerdaCima.QuadradinhoColidiu();
				direitaBaixo.QuadradinhoColidiu();
				esquerdaBaixo.QuadradinhoColidiu();
			}
		}
	}
}

