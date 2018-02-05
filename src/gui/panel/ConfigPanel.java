package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ConfigDao;
import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static ConfigPanel instance = new ConfigPanel();
	
	public JLabel lbudget = new JLabel("本月预算");
	public JLabel linstall = new JLabel("安装目录");
	public JTextField vbudget = new JTextField();
	public JTextField vinstall = new JTextField();
	public JButton bupdate = new JButton("更新");
	
	private ConfigPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lbudget,linstall);
		GUIUtil.setColor(ColorUtil.blueColor, bupdate);
		setLayout(new BorderLayout());
		add(north(),BorderLayout.NORTH);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bupdate);
		add(pSubmit,BorderLayout.CENTER);
		
		addListener();
	}
	
	private JPanel north() {
		JPanel p = new JPanel();
		int gap = 40;
		p.setLayout(new GridLayout(4, 1,gap,gap));
		p.add(lbudget);
		p.add(vbudget);
		p.add(linstall);
		p.add(vinstall);
		
		return p;
	}
	
	@Override
	public void addListener() {
		ConfigListener l = new ConfigListener();
		bupdate.addActionListener(l);
	}
	
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		String budget = new ConfigService().get("budget");
		String mysqlPath = new ConfigService().get("mysqlPath");
		vbudget.setText(budget);
		vinstall.setText(mysqlPath);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.showPanel(ConfigPanel.instance);
	}

}
