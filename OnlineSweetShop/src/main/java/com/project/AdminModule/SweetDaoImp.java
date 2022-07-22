package com.project.AdminModule;

import java.sql.Connection; //for JDBC connection

import java.sql.PreparedStatement; //query related classes
import java.sql.ResultSet;
import java.sql.SQLException; //exception handling
import java.sql.Statement;

import javax.sql.DataSource;

public class SweetDaoImp implements SweetDao { // interface implementation

	private DataSource dataSource; // object which provides a new way to connect to the database

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void manage(SweetPojo obj) { // insert operation through ADMIN in sweettable table in FIRST database

		String query = "Insert into sweettable(categoryid,sweetname,brand,price,offer) values(?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection(); // getConnection()
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, obj.getCategoryid()); // columnwise insertion
			ps.setString(2, obj.getSweetname());
			ps.setString(3, obj.getBrand());
			ps.setDouble(4, obj.getPrice());
			ps.setDouble(5, obj.getOffer());
			ps.executeUpdate();
			ps.close();

			System.out.println("Sweet details implemented");

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void showcatalogue(int categoryid) {
		String query = "select sweetname from sweettable where categoryid=" + categoryid + "";

		Connection conn = null;
		try {

			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			boolean ans = rs.next();
			if (ans) {

				System.out.print("Sweets with category id:" + categoryid + " " + "are" + " " + rs.getString(1));

			} else {
				System.out.println("Sweets with this categoryid not avaialble today...sorry!");
			}
		} catch (Exception e) {

			System.out.println("This category not available today...sorry!");

		}

	}

	public void showproducts() {
		String query = "select brand from sweettable";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while ((rs).next()) {
				System.out.println(rs.getString(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showmenu() {
		String query = "select * from sweettable";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = (ResultSet) stmt.executeQuery(query); // resultset generates the output columnwise

			while ((rs).next()) {
				System.out.println("\n");
				System.out.println("CategoryId:" + " " + rs.getString(1));
				System.out.println("Sweetname:" + " " + rs.getString(2));
				System.out.println("Brand:" + " " + rs.getString(3));
				System.out.println("Price:" + " " + rs.getString(4));
				System.out.println("Offer:" + " " + rs.getString(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletesweet(int orderid) {
		String query = "delete from Ordertable where orderid='" + orderid + "'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			stmt.execute(query);

			System.out.println("Entry deleted!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showAllorders() {
		String query = "select * from Ordertable";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = (ResultSet) stmt.executeQuery(query); // resultset generates the output columnwise

			while ((rs).next()) {
				System.out.println("\n");
				System.out.println("Orderid:" + " " + rs.getString(1));
				System.out.println("Sweetname:" + " " + rs.getString(2));
				System.out.println("Brand:" + " " + rs.getString(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
