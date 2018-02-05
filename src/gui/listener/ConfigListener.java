package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ConfigPanel p = ConfigPanel.instance;
		if(!GUIUtil.checkEmpty(p.vbudget, "本月预算")) 
			return;
		String mysqlPath = p.vinstall.getText();
		if(0!=mysqlPath.length()) {
			File commandFile = new File(mysqlPath,"bin/mysql.exe");
			if(!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql路径不正确");
				p.vinstall.grabFocus();
				return;
			}
		}
		
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.vbudget.getText());
		cs.update(ConfigService.mysqlPath, p.vinstall.getText());
		
		JOptionPane.showMessageDialog(p, "设置修改成功");
	}

}













