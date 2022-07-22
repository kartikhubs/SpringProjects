package com.project.CustomerModule;

import java.sql.*;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

public class CustomerDaoImp implements CustomerDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void register(CustomerPojo cobj) {
		String query = "insert into Customertable(uname,password,confirm,city,state,pincode) values(?,?,?,?,?,?)";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cobj.getUname());
			ps.setString(2, cobj.getPassword());
			ps.setString(3, cobj.getConfirm());
			ps.setString(4, cobj.getCity());
			ps.setString(5, cobj.getState());
			ps.setInt(6, cobj.getPincode());
			ps.executeUpdate();
			ps.close();

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

	public boolean login(String uname, String password) {
		String query = "Select uname, password from Customertable where uname='" + uname + "' and password='" + password
				+ "'";

		Connection con = null;
		try {

			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			Resultset rs = (Resultset) stmt.executeQuery(query);
			if (((ResultSet) rs).next()) {
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void showmenu() {
		String query = "select * from sweettable";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while ((rs).next()) {

				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void invoiceAfterOffer(int orderid) {
		String query = "select price,offer from sweettable";
		String querytwo = "select orderid from Ordertable where orderid='" + orderid + "'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			Statement stmttwo = conn.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			ResultSet rsTwo = (ResultSet) stmttwo.executeQuery(querytwo);
			boolean orderidgenerated = rsTwo.next();
			if (orderidgenerated) {
				double price = 0.0;
				double offer = 0.0;
				while ((rs).next()) {
					price = Double.parseDouble(rs.getString(1));
					offer = Double.parseDouble(rs.getString(2));

				}

				price = (price - (price * (offer / 100.0)));
				System.out.println(price);
			} else {
				System.out.println("Incorrect orderid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
