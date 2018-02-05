package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static RecoverPanel instance = new RecoverPanel();
	
	JButton bbackup = new JButton("¸üÐÂ");
	
	private RecoverPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bbackup);
		add(bbackup);
		
		addListener();
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecoverListener l = new RecoverListener();
		bbackup.addActionListener(l);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
}
