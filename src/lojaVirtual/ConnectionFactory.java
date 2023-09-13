package lojaVirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource; 
	
	public ConnectionFactory() {
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost/NOMEDADATABASE?useTimezone=true&serverTimezone=UTC");
		combo.setUser("USUARIO");
		combo.setPassword("SENHA");
		
		combo.setMaxPoolSize(15);
		
		this.dataSource = combo;
	}
	
	public Connection recuperarConexao() throws SQLException{
		return this.dataSource.getConnection();
				
	}
}
