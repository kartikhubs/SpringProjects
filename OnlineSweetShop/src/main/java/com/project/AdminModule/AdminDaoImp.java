package com.project.AdminModule;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImp implements AdminDao {

	@Autowired // Dependency injection(Autowiring)
	SweetPojo sweetdetails;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; // JDBC api to connect to the database

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void logging(AdminPojo dobj) { // inserting details into admintable in FIRST database
		String query = "Insert into admintable(userid,username,password) values(?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, dobj.getUserid());
			ps.setString(2, dobj.getUsername());
			ps.setInt(3, dobj.getPassword());
			ps.executeUpdate(); // exceuteUpdate() method executes the prepared statement
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

}
