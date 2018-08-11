import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
 
public class SimpleSlickGame extends BasicGame 
	{ 
        int count = 0;
        Image background;
        Image background2;
        Image currBackground;
        int backgroundcheck = 0;
	
		public SimpleSlickGame() {
				super("SimpleSlickGame"); 
	    } 
		
		@Override 
	    public void init(GameContainer container) 
	    	throws SlickException {
			
			 background = new Image("assets/Background.jpg");
			 background2 = new Image("assets/Background2.jpg");
			 currBackground = background;

		} 
	    
	    @Override public void update(GameContainer gc, int delta) 
	    throws SlickException {
	    	
            Input input = gc.getInput();
          
	        if(input.isKeyDown(Input.KEY_UP))
	        {
	        	count++;
	        }
	 
	        if(input.isKeyDown(Input.KEY_DOWN))
	        {
	        	count--;
	        }
	        
	        if(input.isKeyPressed(Input.KEY_ESCAPE))
	        {
	        	System.exit(0);
	        }
	        if(input.isKeyPressed(Input.KEY_C))
	        {
				if (backgroundcheck == 0) {
	        		currBackground = background2;
	        		backgroundcheck = 1;
	        	} else {
	        		currBackground = background;
	        		backgroundcheck = 0;
	        	}
	        }
	    } 
	    
	    @Override public void render(GameContainer container, Graphics g) 
	    throws SlickException { 
	    	currBackground.draw(0,0);
	    	g.drawString("Count = " + count, 100, 100); 
	    	
	    } 
	    
	    public static void main(String[] args) { 
	    	
	    	try { 
	    		AppGameContainer app = new AppGameContainer(new SimpleSlickGame()); 
	    		app.setDisplayMode(800, 600, false);
	            app.start();

	    		
	    	} catch (SlickException e) { 
	    		e.printStackTrace(); 
	    	} 
	    }
}

