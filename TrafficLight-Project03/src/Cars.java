
import java.awt.Graphics;

public class Cars  {
   private String car;
  int x;
  int y;
  int width = 100 ;
  int height =40;
  int speed = 0;
  
  public Cars(int newx, int newy) {
	        x = newx;
	        y = newy;
	    }
  


	public void paintMe(Graphics g) {
		 g.setColor(Color.red); 
		 g.fillRect(x, y, width, height);
	   }

  public int getX() {
	  return x;
  }
  
  public void setX(int newx) {
	  x = newx;
  }
  
  public int getSpeed() {
	  return speed;
  }
  
  public int getY() {
	  return y;
  }
  
}

