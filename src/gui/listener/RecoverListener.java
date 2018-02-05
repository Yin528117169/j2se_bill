package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		RecoverPanel p = RecoverPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		
		if(0==mysqlPath.length()) {
			JOptionPane.showMessageDialog(p, "«Îœ»≈‰÷√ª÷∏¥¬∑æ∂£°");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			return;
		}
		
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("hutubill.sql"));
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".sql";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".sql");
			}
		});
		
		int returnVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "ª÷∏¥≥…π¶");	
			}catch(Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "ª÷∏¥ ß∞‹\r\n"+e1.getMessage());
			}
		}
	}

}
