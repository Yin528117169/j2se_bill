package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CategoryPanel p = CategoryPanel.instance;
		JButton b = (JButton)e.getSource();
		
		if(b==p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if(0==name.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
			}
			new CategoryService().add(name);
		}
		if(b==p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.getId();
			String name = JOptionPane.showInputDialog("修改分类名称",c.getName());
			
			if(0==name.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}
			
			new CategoryService().update(id, name);
		}
		if(b==p.bDelete) {
			Category c = p.getSelectedCategory();
			if(0!=c.getRecordNumber()) {
				JOptionPane.showMessageDialog(p, "分类下有记录，不能删除！");
				return;
			}
			if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确定删除吗？"))
				return;
			int id = c.getId();
			new CategoryService().delete(id);
		}
		p.updateData();
		
	}

}
