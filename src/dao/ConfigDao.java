package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Config;
import util.DBUtil;

public class ConfigDao {
	
	public int getTotal() {
		int total = 0;
		try(Connection c = DBUtil.getConnection();Statement s = c.createStatement();){
			
			String sql = "select count(*) from config";
			
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt(1);
			}
			
			System.out.println("total:"+total);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public void add(Config config) {
		String sql = "insert into config values(null,?,?)";
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setString(1,config.getKey());
			ps.setString(2, config.getValue());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				config.setId(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Config config) {
		String sql = "update config set key_=?,value=? where id=?";
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setString(1, config.getKey());
			ps.setString(2, config.getValue());
			ps.setInt(3, config.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try(Connection c = DBUtil.getConnection();Statement s = c.createStatement();){
			
			String sql = "delete from config where id=" + id;
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Config get(int id) {
		Config config = null;
		try(Connection c = DBUtil.getConnection();Statement s = c.createStatement();){
			
			String sql = "select * from config where id=" + id;
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				config = new Config();
				String key = rs.getString("key_");
				String value = rs.getString("value");
				config.setKey(key);
				config.setValue(value);
				config.setId(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	//查询全部
	public List<Config> list(){
		return list(0,Short.MAX_VALUE);
	}
	
	//分页查询
	public List<Config> list(int start,int count){
		List<Config> configs = new ArrayList<>();
		
		String sql = "select * from config order by id desc limit ?,?";
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Config config = new Config();
				int id = rs.getInt(1);
				String key = rs.getString("key_");
				String value = rs.getString("value");
				config.setId(id);
				config.setKey(key);
				config.setValue(value);
				configs.add(config);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configs;
	}
	
	public Config getByKey(String key) {
		Config config = null;
		String sql = "select * from config where key_=?";
		
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				config = new Config();
				int id = rs.getInt("id");
				String value = rs.getString("value");
				config.setKey(key);
				config.setValue(value);
			    config.setId(id);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	public static void main(String args[]){
		ConfigDao dao = new ConfigDao();
		Config c1 = dao.getByKey("budget");
		Config c2 = dao.getByKey("mysqlPath");
		System.out.println(c1.getValue());
		System.out.println(c2.getValue());
	}

}
























