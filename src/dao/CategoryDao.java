package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.DBUtil;

public class CategoryDao {
	
	public int getTotal() {
		int total = 0;
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "select count(*) from category";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public void add(Category category) {
		String sql = "insert into category values(null,?)";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setString(1, category.getName());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				category.setId(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Category category) {
		String sql = "update category set name=? where id=?";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "delete from category where id="+id;
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Category get(int id) {
		Category category = null;
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "select * from category where id="+id;
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				category = new Category();
				String name = rs.getString("name");
				category.setId(id);
				category.setName(name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	
	public List<Category> list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Category> list(int start,int count){
		List<Category> categories = new ArrayList<>();
		String sql = "select * from category order by id limit ?,?";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				category.setId(id);
				category.setName(name);
				categories.add(category);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	public static void main(String args[]) {
		List<Category> cs = new ArrayList<>();
		CategoryDao dao = new CategoryDao();
		Category c = new Category();
		c.setId(1);
		c.setName("test");
		dao.update(c);
	}

}

































