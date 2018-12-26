import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(BeatGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.pressK();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(BeatGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.releaseK();
		}
	}

}
