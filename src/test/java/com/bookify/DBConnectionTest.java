package com.bookify;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import com.bookify.util.DBConnection;

/**
 * This class is responsible for testing the DBConnection class.
 * It ensures that the database connection is correctly established and managed.
 *
 * @author Ayon-SSP
 */
public class DBConnectionTest {

	@Test
	public void testDBConnectioObjectCreated() {
		assertNotNull(DBConnection.getDBConnection());
	}
	
	@Test
	public void testConnectionIsOpen() {
		assertNotNull(DBConnection.getDBConnection().getConnection());
	}
	
	@Test
	public void testConnectionIsClosed() {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();
			connection.close();
			assertNotNull(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
