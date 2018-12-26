import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
		private Player player;  // javzzoom�� ���̺귯��
		private boolean isLoop; // ���� �ݺ� or 1ȸ ��� ����
		private File file;
		private FileInputStream fis;
		private BufferedInputStream bis;
		
		public Music(String foldername, String name, boolean isLoop) {
			try {
				this.isLoop = isLoop;
				file = new File(Main.class.getResource("./" + foldername + "/" + name).toURI());
				fis = new FileInputStream(file); // �뷡���� �ҷ���
				bis = new BufferedInputStream(fis); //������ ���ۿ� ����
				player = new Player(bis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public int getTime() { //�뷡�� �ð� ��ġ ��ȯ
			if(player == null)
				return 0;
			return player.getPosition();
		}
		
		public void close() { // ���� ����
			isLoop = false;
			player.close();
			this.interrupt(); //������ �Ͻ�����
		}
		
		@Override
		public void run() {
			try {
				do {
					player.play(); // �� ���
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					player = new Player(bis);
				}while(isLoop);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
