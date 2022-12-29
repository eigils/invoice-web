package com.mycompany.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJdbcRepositories - import implicite grâce à la dependencie spring-boot-starter-data-jdbc
//@EnableJpaRepositories - import implicite grâce à la dependencie spring-boot-starter-data-jpa
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
