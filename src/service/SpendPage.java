package service;

public class SpendPage {
	
	//��������
	public String monthSpend;
	//��������
	public String todaySpend;
	//�վ�����
	public String avgSpendPerDay;
	//����ʣ��
	public String monthAvailable;
	//�վ�����
	public String dayAvgAvailable;
	//������ĩ
	public String monthLeftDay;
	//ʹ�ñ���
	public int usagePercentage;
	//�Ƿ�֧
	public boolean isOverSpend = false;
	
	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable,
			int dayAvgAvailable, int monthLeftDay, int usagePercentage) {
		this.monthSpend = Integer.toString(monthSpend);
		this.todaySpend = Integer.toString(todaySpend);
		this.avgSpendPerDay = Integer.toString(avgSpendPerDay);
		this.monthAvailable = Integer.toString(monthAvailable);
		this.dayAvgAvailable = Integer.toString(dayAvgAvailable);
		this.monthLeftDay = Integer.toString(monthLeftDay);
		this.usagePercentage = usagePercentage;
	}

	public SpendPage() {
	}
	
	

}
