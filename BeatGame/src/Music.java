import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
		private Player player;  // javzzoom의 라이브러리
		private boolean isLoop; // 곡의 반복 or 1회 재생 설정
		private File file;
		private FileInputStream fis;
		private BufferedInputStream bis;
		
		public Music(String foldername, String name, boolean isLoop) {
			try {
				this.isLoop = isLoop;
				file = new File(Main.class.getResource("./" + foldername + "/" + name).toURI());
				fis = new FileInputStream(file); // 노래파일 불러옴
				bis = new BufferedInputStream(fis); //파일을 버퍼에 담음
				player = new Player(bis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public int getTime() { //노래의 시간 위치 반환
			if(player == null)
				return 0;
			return player.getPosition();
		}
		
		public void close() { // 음악 종료
			isLoop = false;
			player.close();
			this.interrupt(); //스레드 일시정지
		}
		
		@Override
		public void run() {
			try {
				do {
					player.play(); // 곡 재생
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					player = new Player(bis);
				}while(isLoop);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
