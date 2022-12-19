package com.mycompany.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class InvoiceWebApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(InvoiceWebApplication.class, args);
		/*DataSource ds = context.getBean(DataSource.class);
		Connection connection = null;

		try {
			connection = ds.getConnection();
			System.out.println("success");
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE");
			while (resultSet.next()) {
				System.out.println(resultSet.getLong("INVOICE_NUMBER") + " | " + resultSet.getString("CUSTOMER_NAME"));
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};*/

	}

}
