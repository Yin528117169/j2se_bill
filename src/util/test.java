package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUIUtil.useLNF();
		JPanel p = new JPanel();
	    CircleProgressBar cpb = new CircleProgressBar();
	    cpb.setBackgroundColor(ColorUtil.blueColor);
	    cpb.setProgress(0);
	    JButton b = new JButton("点击");
	    //添加组件
	    p.setLayout(new BorderLayout());
	    p.add(cpb,BorderLayout.CENTER);
	    p.add(b,BorderLayout.SOUTH);
	    GUIUtil.showPanel(p);
	    
	    b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//SwingWorker可以帮助我们在后台执行耗时的任务，而避免阻塞我们的应用程序
				new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						for(int i=0;i<100;i++) {
							cpb.setProgress(i+1);
							cpb.setForegroundColor(ColorUtil.getByPercentage(i+1));
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						return null;
					}
				}.execute();
			}
		});

	}

}
