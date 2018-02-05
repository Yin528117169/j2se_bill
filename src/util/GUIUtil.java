package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JComponent.AccessibleJComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	
	//img的文件路径
	private static String imageFolder = "D:/Work/Workplace/hutuBill/img";
	
	//设置图标的工具类
	public static void setImageIcon(JButton b,String fileName,String tip) {
		ImageIcon img = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		b.setIcon(img);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}
	
	//设置颜色的工具类
	public static void setColor(Color color,JComponent... cs) {
		for(JComponent c:cs) {
			c.setForeground(color);
		}
	}
	
	//拉伸比例工具类
	public static void showPanel(JPanel p,double strechRate) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}
	
	//展示面板的工具类
	public static void showPanel(JPanel p) {
		showPanel(p,0.85);
	}
	
	//判断是否为数字的工具类
	public static boolean checkNumber(JTextField tf,String input) {
		if(!checkEmpty(tf,input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input+"需要是整数");
			tf.grabFocus();
			return false;
		}
	}
	
	//判断是否为0的工具类
	public static boolean checkZero(JTextField tf,String input) {
		if(!checkNumber(tf,input))
			return false;
		String text = tf.getText().trim();
		
		if(Integer.parseInt(text)==0) {
			JOptionPane.showMessageDialog(null, input+"不能为零");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	//判断是否为空的工具类:空的时候return false
	public static boolean checkEmpty(JTextField tf,String input) {
		String text = tf.getText().trim();
		if(0 == text.length()) {
			JOptionPane.showMessageDialog(null, input+"不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	//得到整数的工具类
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	
	public static void useLNF() {
		try {
			String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
			javax.swing.UIManager.setLookAndFeel(lookAndFeel);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
