package service;

public class SpendPage {
	
	//本月消费
	public String monthSpend;
	//今日消费
	public String todaySpend;
	//日均消费
	public String avgSpendPerDay;
	//本月剩余
	public String monthAvailable;
	//日均可用
	public String dayAvgAvailable;
	//距离月末
	public String monthLeftDay;
	//使用比例
	public int usagePercentage;
	//是否超支
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
