package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel{
	static {
		GUIUtil.useLNF();
	}
	public static BackupPanel instance = new BackupPanel();
	
	JButton bbackup = new JButton("±¸·Ý");
	
	private BackupPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bbackup);
		add(bbackup);
		
		addListener();
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		BackupListener l = new BackupListener();
		bbackup.addActionListener(l);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.showPanel(BackupPanel.instance);
	}

}
