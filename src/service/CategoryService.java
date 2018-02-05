package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.CategoryDao;
import dao.RecordDao;
import entity.Category;
import entity.Record;

public class CategoryService {
	
	static CategoryDao dao = new CategoryDao();
	
	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		dao.add(c);
	}
	
	public List<Category> list(){
		List<Category> categories = new ArrayList<>();
		categories = dao.list();
		for(Category c:categories) {
			List<Record> rs = new ArrayList<>();
			rs = new RecordDao().list(c.getId());
			c.setRecordNumber(rs.size());
		}
		Collections.sort(categories,(c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
		return categories;
	}
	
	public void update(int id,String name) {
		Category c = new Category();
		c.setId(id);
		c.setName(name);
		dao.update(c);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public void add(Category category) {
		dao.add(category);
	}
	
	public static void main(String args[]) {
		CategoryService cs = new CategoryService();
		List<Category> categories = new ArrayList<>();
		cs.update(1, "test2");
	}

}
