package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000*60*60*24;
	
	public static java.util.Date util1sql(java.sql.Date d){
		return new java.util.Date(d.getTime());
	}
	
	//使用jdbc做开发的时候用的是sql的类型，所以需要转换一下
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	/**
	 * 获取今天，并把时，分，秒和毫秒都置0，应为通过日期控件获取到的日期，
	 * 就是没有时分秒和毫秒的。
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
	 * 获取月初。使用Calendar获取本月第一天。
	 * 在统计消费一览信息的时候，查看本月的消费数据。
	 * 其实就是从数据库中取把本月第一天到最后一天的数据取出来。
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
	 *获取月末
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
	 * 获取本月一共有多少天
	 */
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay)+1;
	}
	
	/**
	 * 获取本月还剩多少天
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



















