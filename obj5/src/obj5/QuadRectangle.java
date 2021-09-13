package obj5;

public class QuadRectangle {
	public int x;
	public int y;
	public int width;
	public int height;
	
	public QuadRectangle(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	public boolean ContainsParticle(Particulas particula)
	{
		boolean possui ;
                if((particula.x + Obj5.tamanhoParticula > x && particula.x < x + width && particula.y + Obj5.tamanhoParticula > y && particula.y < y + height)){
                    return true;
                }else{
                    return false;
                }
		
	}
}