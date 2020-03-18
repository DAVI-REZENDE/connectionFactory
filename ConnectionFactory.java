import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("Info@1234");
		
		cpds.setMaxPoolSize(15);
		
		this.datasource = cpds;
		
	}

	public Connection recuperaConexao() throws SQLException {
		return this.datasource.getConnection();
				
		
	}

}
