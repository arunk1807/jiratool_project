package HelperClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import pojo.Jira;

public class HelpingClass {

	public static boolean insertNewUser(String fname, String lname, String mob, String mail, String psswrd) {
		boolean result = false;

		try {

			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con.prepareStatement(
					"insert into userDetails(firstName, lastName, mobile, email, passWordd)" + "values(?,?,?,?,?)");
			pt.setString(1, fname);
			pt.setString(2, lname);
			pt.setString(3, mob);
			pt.setString(4, mail);
			pt.setString(5, psswrd);

			int i = pt.executeUpdate();

			if (i >= 1)
				result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static Connection getMyConnectionObject() {
		
		Connection connection=null;
		String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/FinalProject1?characterEncoding=latin1";
		String uname="root";
		String pwd="root";

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,uname,pwd);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

		
	}

	public static String authenticateUser(String mail, String psswrd) {

		boolean result = false;
		String uname = "";
		try {
			

			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con
					.prepareStatement("select * from userDetails " + "where email=?" + "and passWordd=?");

			pt.setString(1, mail);
			pt.setString(2, psswrd);

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				uname = rs.getString(2);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uname;

	}

	public static boolean createNewJira(String assignee, String reporter, String head, String status, String mail) {

		boolean result = false;

		try {
			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con.prepareStatement(
					"insert into jiraDetails(assignee,reporter,problem,notify,status)" + "values(?,?,?,?,?)");

			pt.setString(1, assignee);
			pt.setString(2, reporter);
			pt.setString(3, head);
			pt.setString(4, status);
			pt.setString(5, mail);

			int i = pt.executeUpdate();

			while (i > 0) {
				result = true;
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static ArrayList<Jira> viewAllTicket() {

		ArrayList<Jira> arrayList = new ArrayList<Jira>();
		try {
			Connection con =HelpingClass.getMyConnectionObject();
			Statement pt = con.createStatement();
			ResultSet rs = pt.executeQuery("select * from jiraDetails");

			Jira jira = null;

			while (rs.next()) {

				jira = new Jira(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				arrayList.add(jira);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;

	}
	public static ArrayList<Jira> viewFilteredTicket(String query, String value) {

		ArrayList<Jira> arrayList = new ArrayList<Jira>();
		try {
			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1, value);
			
			ResultSet rs = pt.executeQuery();

			Jira jira = null;

			while (rs.next()) {

				jira = new Jira(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				arrayList.add(jira);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;

	}

	public static ArrayList<Jira> viewOneTicket(int id) {

		ArrayList<Jira> arrayList = new ArrayList<Jira>();
		try {
			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con.prepareStatement("select * from jiraDetails where Userid=?");
		
			pt.setInt(1, id);
			
		ResultSet rs=pt.executeQuery();
			
			Jira jira = null;

			while (rs.next()) {

				jira = new Jira(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				arrayList.add(jira);
                break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;

	}
	public static ArrayList<String> viewUsers() {

		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			Connection con =HelpingClass.getMyConnectionObject();
			Statement pt = con.createStatement();
			ResultSet rs = pt.executeQuery("select * from userDetails");


			while (rs.next()) {

				arrayList.add(rs.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;

	}

	public static boolean  deleteJira(int id) {
		boolean result = false;
		String uname = "";
		try {
			Connection con =HelpingClass.getMyConnectionObject();
			PreparedStatement pt = con.prepareStatement("delete from jiraDetails where Userid= ?");

			pt.setInt(1, id);
			
			int i=pt.executeUpdate();
			

			while (i>0) {

				result=true;
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	public static boolean UpdateStringJiraTicket(String assignee, String reportee, String problem, String status,
			String notify,int id ) {
		boolean result = false;
			
			try {
				Connection con =HelpingClass.getMyConnectionObject();
				PreparedStatement pt = con.prepareStatement(
						"update jiraDetails set assignee=?,reporter=?,problem=?,notify=?,status=? where Userid=?");
				
				//int j=0;
				pt.setString(1, assignee);
				pt.setString(2, reportee);
				pt.setString(3, problem);
				pt.setString(4, status);
				pt.setString(5, notify);
				pt.setInt(6, id);
				
				int i=pt.executeUpdate();
				

				while (i>0) {

					result=true;
					break;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}


}
