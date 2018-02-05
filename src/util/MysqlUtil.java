package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
	
	public static void backup(String mysqlPath,String backupfile) throws IOException {
		String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s  -hlocalhost -P%d %s -r \"%s\"";
		String command = String.format(commandFormat, mysqlPath,DBUtil.loginName,DBUtil.password,DBUtil.port,DBUtil.database,backupfile);
		
		System.out.println(command);
		
		Runtime.getRuntime().exec(command);
	}
	
	public static void recover(String mysqlPath,String recoverfile) {
		
		try {
			String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s %s ";
			String command = String.format(commandFormat, mysqlPath,DBUtil.loginName,DBUtil.password,DBUtil.database);
			
			Process p = Runtime.getRuntime().exec(command); //�����ⲿ�ĳ���
			OutputStream out = p.getOutputStream();
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
			while((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			writer.flush();
			out.close();
			br.close();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException {
		String mysqlPath = "D:/Work/Environment/MySQL/mysql-5.7.20-winx64";
		String file = "D:/Work/Workplace/hutuBill/sql/hutubill.sql";
		
//		backup(mysqlPath,file);
		recover(mysqlPath,file);
		
	}

}
