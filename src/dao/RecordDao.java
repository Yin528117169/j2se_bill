package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Record;
import util.DBUtil;
import util.DateUtil;

public class RecordDao {
	
	public int getTotal() {
		int total = 0;
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "select count(*) from record";
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
	
	public void add(Record record) {
		String sql = "insert into record values(null,?,?,?,?)";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setInt(1, record.getSpend());
			ps.setInt(2, record.getCid());
			ps.setString(3, record.getComment());
			ps.setDate(4, DateUtil.util2sql(record.getDate()));
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				record.setId(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Record record) {
		String sql = "update record set id=?,spend=?,cid=?,comment=?,date=?";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setInt(1, record.getId());
			ps.setInt(2, record.getSpend());
			ps.setInt(3, record.getCid());
			ps.setString(4, record.getComment());
			ps.setDate(5, DateUtil.util2sql(record.getDate()));
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "delete from record where id="+id;
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Record get(int id) {
		Record record = null;
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "select * from record where id="+id;
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				record = new Record();
				int spend = rs.getInt("spend");
				int cid = rs.getInt("cid");
				String comment = rs.getString("comment");
				Date date = DateUtil.util1sql(rs.getDate("date"));
				record.setId(id);
				record.setSpend(spend);
				record.setCid(cid);
				record.setComment(comment);
				record.setDate(date);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}
	
	public List<Record> list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Record> list(int start,int count){
		List<Record> records = new ArrayList<>();
		String sql = "select * from record order by id limit ?,?";
		
		try(Connection c = DBUtil.getConnection();
		        PreparedStatement ps = c.prepareStatement(sql);){
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Record record = new Record();
				int id = rs.getInt("id");
				int spend = rs.getInt("spend");
				int cid = rs.getInt("cid");
				String comment = rs.getString("comment");
				Date date = DateUtil.util1sql(rs.getDate("date"));
				record.setId(id);
				record.setSpend(spend);
				record.setCid(cid);
				record.setComment(comment);
				record.setDate(date);
				records.add(record);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	//只查某一个分类下的record
	public List<Record> list(int cid){
		List<Record> records = new ArrayList<>();
		
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			String sql = "select * from record where cid="+cid;
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Record record = new Record();
				int id = rs.getInt("id");
				int spend = rs.getInt("spend");
				String comment = rs.getString("comment");
				Date date = DateUtil.util1sql(rs.getDate("date"));
				record.setId(id);
				record.setSpend(spend);
				record.setCid(cid);
				record.setComment(comment);
				record.setDate(date);
				records.add(record);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	public List<Record> listToday(){
		return list(DateUtil.today());
	}
	
	//按日期查询record
	public List<Record> list(Date date){
		List<Record> records = new ArrayList<>();
		
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			
			java.sql.Date sqlDate = DateUtil.util2sql(date);
			String sql = "select * from record where date='"+sqlDate+"'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Record record = new Record();
				int id = rs.getInt("id");
				int spend = rs.getInt("spend");
				int cid = rs.getInt("cid");
				String comment = rs.getString("comment");
				record.setId(id);
				record.setSpend(spend);
				record.setCid(cid);
				record.setComment(comment);
				record.setDate(date);
				records.add(record);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	public List<Record> listThisMonth(){
		return list(DateUtil.monthBegin(),DateUtil.monthEnd());
	}
	
	public List<Record> list(Date start,Date end){
		List<Record> records = new ArrayList<>();
		
		try(Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();){
			java.sql.Date sqlStart = DateUtil.util2sql(start);
			java.sql.Date sqlEnd = DateUtil.util2sql(end);
			String sql = "select * from record where date>='"+sqlStart+"' and date<='"+sqlEnd+"'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Record record = new Record();
				int id = rs.getInt("id");
				int spend = rs.getInt("spend");
				int cid = rs.getInt("cid");
				String comment = rs.getString("comment");
				Date date = DateUtil.util1sql(rs.getDate("date"));
				record.setId(id);
				record.setSpend(spend);
				record.setCid(cid);
				record.setComment(comment);
				record.setDate(date);
				records.add(record);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	public static void main(String args[]) {
		List<Record> records = new ArrayList<>();
		RecordDao dao = new RecordDao();
		
		Date today = DateUtil.today();
		System.out.println(today);
		records = dao.list(today);
		for(Record r:records) {
			System.out.println(r.getComment());
		}
	}
}



















