
public class Main {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 5; // 노트가 떨어지는 속도 '원하는 속도로 조정'
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2; // 노트 등장부터 판정라인까지 2초
	
	public static void main(String[] args) {
		new BeatGame();
	}
}
