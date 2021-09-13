package obj5;

import java.util.Random;
import javax.swing.JFrame;

public class Obj5 {
	
	public static int tamanho = 800;
        public static int numeroParticulas =1000;
	static int tamanhoParticula = 7;
	public static Particulas[] particulas;
	

	public static void main(String[] args) {

		particulas = new Particulas[numeroParticulas];
		
		for (int i = 0; i < numeroParticulas; i++)
		{
                    Random random = new Random();
                    int startX = random. nextInt(tamanho - tamanhoParticula); 
                    int startY = random. nextInt(tamanho - tamanhoParticula); 
                    particulas[i] = new Particulas(startX, startY, tamanhoParticula);
		}
		
		
		Frame frame = new Frame(tamanho, tamanho);
	}
}


