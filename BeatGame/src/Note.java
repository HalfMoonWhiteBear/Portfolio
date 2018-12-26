import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image note1Image = new ImageIcon(Main.class.getResource("./images/note1.png")).getImage();
	private Image note2Image = new ImageIcon(Main.class.getResource("./images/note2.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("D")) {
			x = 200;
		}
		else if(noteType.equals("F")) {
			x = 270;
		}
		else if(noteType.equals("J")) {
			x = 340;
		}
		else if(noteType.equals("K")) {
			x = 410;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("D") || noteType.equals("K"))
			g.drawImage(note1Image, x, y, null);
		else
			g.drawImage(note2Image, x, y, null);
	}
	
	public void drop() {  // 노트 애니메이션
		y += Main.NOTE_SPEED;
		if(y > 620) { // Miss
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) { // 자원 소모 처리 '노트가 없을 때 sleep_time 만큼 쉼'
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt(); //노트 판정이 됐을 경우 노트를 멈춤
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public String judge() { // 노트 판정
		if(y >= 613) {
			close();
			return "Late";
		}
		else if(y >= 600) {
			close();
			return "Good";
		}
		else if(y >= 587) {
			close();
			return "Great";
		}
		else if(y >= 573) {
			close();
			return "Perfact";
		}
		else if(y >= 565) {
			close();
			return "Great";
		}
		else if(y >= 550) {
			close();
			return "Good";
		}
		else if(y >= 535) {
			close();
			return "Fast";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}
}
