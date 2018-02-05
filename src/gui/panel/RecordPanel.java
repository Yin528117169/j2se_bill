package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import gui.model.DateChooserJButton;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel{
	static {
		GUIUtil.useLNF();
	}
	public static RecordPanel instance = new RecordPanel();
	
	JLabel lSpend = new JLabel("花费（￥）");
	JLabel lCategory = new JLabel("分类");
	JLabel lComment = new JLabel("备注");
	JLabel lDate = new JLabel("日期");
	
	public JTextField tfSpend = new JTextField("0");
	
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
	public JTextField tfComment = new JTextField();
	public DateChooserJButton dateButton = new DateChooserJButton();
	
	public List<Category> cs = new CategoryService().list();
	
	JButton bSubmit = new JButton("记一笔");
	
	public RecordPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 2,gap,gap));
		
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(dateButton);
		
		pSubmit.add(bSubmit);
		
		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);
		
		addListener();
		
	}
	
	public Category getSelectedCategory() {
		int index = cbCategory.getSelectedIndex();
		return cs.get(index);
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener l = new RecordListener();
		bSubmit.addActionListener(l);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		cbModel.cs = new CategoryService().list();
		cbCategory.updateUI();
		resetInput();
		tfSpend.grabFocus();
	}
	
	public void resetInput() {
		tfSpend.setText("0");
		tfComment.setText("");
		if(0!=cbModel.cs.size())
			cbCategory.setSelectedIndex(0);
		dateButton.setDate(new Date());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.showPanel(RecordPanel.instance);

	}

}
