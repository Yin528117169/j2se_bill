package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000*60*60*24;
	
	public static java.util.Date util1sql(java.sql.Date d){
		return new java.util.Date(d.getTime());
	}
	
	//ʹ��jdbc��������ʱ���õ���sql�����ͣ�������Ҫת��һ��
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	/**
	 * ��ȡ���죬����ʱ���֣���ͺ��붼��0��ӦΪͨ�����ڿؼ���ȡ�������ڣ�
	 * ����û��ʱ����ͺ���ġ�
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * ��ȡ�³���ʹ��Calendar��ȡ���µ�һ�졣
	 * ��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ��������ݡ�
	 * ��ʵ���Ǵ����ݿ���ȡ�ѱ��µ�һ�쵽���һ�������ȡ������
	 */
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/**
	 *��ȡ��ĩ
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	
	/**
	 * ��ȡ����һ���ж�����
	 */
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay)+1;
	}
	
	/**
	 * ��ȡ���»�ʣ������
	 */
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMillSeconds = today().getTime();
		return (int)((lastDayMilliSeconds-toDayMillSeconds)/millisecondsOfOneDay)+1;
	}
	
	public static void main(String[] args) {
		Date date = DateUtil.today();
		System.out.println(date);
		Date date2 = DateUtil.util2sql(date);
		System.out.println(date2);
	}

	
	
	
}



















