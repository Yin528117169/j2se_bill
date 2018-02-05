package service;

import java.util.Date;

import dao.RecordDao;
import entity.Category;
import entity.Record;

public class RecordService {
	
	RecordDao dao = new RecordDao();
	
	public void add(int spend,Category category,String comment,Date date) {
		Record record = new Record();
		record.setSpend(spend);
		record.setCid(category.getId());
		record.setComment(comment);
		record.setDate(date);
		dao.add(record);
	}

}
