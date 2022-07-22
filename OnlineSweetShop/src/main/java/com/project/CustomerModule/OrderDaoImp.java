package com.project.CustomerModule;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class OrderDaoImp implements OrderDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void placeorder(OrderPojo object) {
		String query = "insert into Ordertable(orderid,sweetname,brand) values(?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, object.getOrderid());
			ps.setString(2, object.getSweetname());
			ps.setString(3, object.getBrand());

			ps.executeUpdate();
			ps.close();
			System.out.println("Order placed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void vieworder(int orderid, String sweetname, String brand) {

		String query = "select sweetname,brand,price,offer from sweettable where sweetname='" + sweetname
				+ "' and brand='" + brand + "'";
		String queryone = "select orderid from Ordertable where orderid='" + orderid + "'";
		Connection conn = null;
		try {

			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			Statement stmttwo = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			ResultSet rsOne = stmttwo.executeQuery(queryone);
			boolean orderidgenerated = rsOne.next();
			if (orderidgenerated) {
				System.out.println("Your order is here, verify!");

				while (rs.next()) {
					System.out.println("Sweetname:" + " " + rs.getString(1));
					System.out.println("Brandname:" + " " + rs.getString(2));
					System.out.println("Price:" + " " + rs.getString(3));
					System.out.println("Offer:" + " " + rs.getString(4));
				}
			} else {
				System.out.println("Orderid did not match....!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}