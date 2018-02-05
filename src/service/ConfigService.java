package service;

import dao.ConfigDao;
import entity.Config;

public class ConfigService {
	
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String default_budget = "500";
	
	static ConfigDao dao = new ConfigDao();
	static {
		init();
	}
	
	public static void init() {
		init(budget,default_budget);
		init(mysqlPath,"");
	}
	
	private static void init(String key,String value) {
		Config config = dao.getByKey(key);
		if(config==null) {
			Config c = new Config();
			c.setKey(key);
			c.setValue(value);
			dao.add(c);
		}
	}
	
	public String get(String key) {
		Config config = dao.getByKey(key);
		return config.getValue();
	}
	
	public void update(String key,String value) {
		Config config = dao.getByKey(key);
		config.setValue(value);
		dao.update(config);
	}
	
	public int getIntBudget() {
		return Integer.parseInt(get(budget));
	}
	
	public static void main(String args[]){
		ConfigService c = new ConfigService();
		System.out.println(c.mysqlPath);
		c.update(c.mysqlPath, "123");
	}

}














