package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

/**
 * ����ģʽ������
 */

public class SpendPanel extends WorkingPanel{
	public static SpendPanel instance = new SpendPanel();
	
	JLabel lMonthSpend = new JLabel("��������");
	JLabel lTodaySpend = new JLabel("��������");
	JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	JLabel lMonthLeft = new JLabel("����ʣ��");
	JLabel lDayAvgAvailable = new JLabel("�վ�����");
	JLabel lMonthLeftDay = new JLabel("������ĩ");
	
	JLabel vMonthSpend = new JLabel("");
	JLabel vTodaySpend = new JLabel("");
	JLabel vAvgSpendPerDay = new JLabel("");
	JLabel vMonthAvailable = new JLabel("");
	JLabel vDayAvgAvailable = new JLabel("");
	JLabel vMonthLeftDay = new JLabel("");
	
	CircleProgressBar bar;
	
	private SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend,lTodaySpend,lAvgSpendPerDay,lMonthLeft,
				lDayAvgAvailable,lMonthLeftDay,vAvgSpendPerDay,vMonthAvailable,vDayAvgAvailable,vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend,vTodaySpend);
		
		vMonthSpend.setFont(new Font("΢���ź�",Font.BOLD,23));
		vTodaySpend.setFont(new Font("΢���ź�",Font.BOLD,23));
		
		this.add(center(),BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}
	
	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(),BorderLayout.WEST);
		p.add(center2(),BorderLayout.CENTER);
		
		return p;
	}
	
	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));
		
		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);
		
		return p;
	}
	
	private JPanel west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		
		return p;
	}
	
	private JComponent center2() {
		return bar;
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		SpendPage spend = new SpendService().getSpendPage();
		
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vMonthAvailable.setText(spend.monthAvailable);
		vDayAvgAvailable.setText(spend.dayAvgAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);
		
		bar.setProgress(spend.usagePercentage);
		if(spend.isOverSpend) {
			vMonthAvailable.setForeground(ColorUtil.warningColor);
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		}else {
			vMonthAvailable.setForeground(ColorUtil.grayColor);
			vMonthSpend.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
		}
		bar.setForeground(ColorUtil.getByPercentage(spend.usagePercentage));
	}
	
	public static void main(String args[]) {
		GUIUtil.showPanel(SpendPanel.instance);
	}

}
