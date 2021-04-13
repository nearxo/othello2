package othello2;

import java.awt.EventQueue;

public class Eseste {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brillitos frame = new brillitos();
					frame.iniciarBotones();
					frame.pintar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
