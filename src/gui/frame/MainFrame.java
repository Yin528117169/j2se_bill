package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame {
	public static MainFrame instance = new MainFrame();
	
	private MainFrame() {
		this.setSize(500, 450);
		this.setTitle("’À±æ");
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		instance.setVisible(true);
	}

}
