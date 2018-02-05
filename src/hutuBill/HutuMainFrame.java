package hutuBill;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class HutuMainFrame {

	public static void main(String[] args) {
		
		//1.创建界面
		JFrame f= new JFrame();
		f.setSize(500,450);
		f.setTitle("一本糊涂账");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2.创建菜单栏及按钮
		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("消费一览");
		JButton bRecord = new JButton("记一笔");
		JButton bCategory = new JButton("消费分类");
		JButton bReport = new JButton("月消费报表");
		JButton bConfig = new JButton("设置");
		JButton bBackup = new JButton("备份");
		JButton bRecover = new JButton("恢复");
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		
		//3.创建布局：这里有一个JPanel用于显示各种各样的数据，所以预见如果展开代码会很复杂！
		f.setLayout(new BorderLayout());
		f.add(tb,BorderLayout.NORTH);
		f.add(new JPanel(), BorderLayout.CENTER);
		
		f.setVisible(true);
		
		//4.创建按钮的监听器：各种各样的监听器都挤到这儿了，何不把他们放出去？？
		bSpend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bBackup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bRecover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

}
