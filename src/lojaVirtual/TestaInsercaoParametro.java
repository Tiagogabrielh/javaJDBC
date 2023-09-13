package lojaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoParametro {

	public static void main(String[] args) throws SQLException {
		
		//String nome = "Mouse'ddddd";
		//String descricao = "Mouse sem fio); delete from Produto;";
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		con.setAutoCommit(false);
		
		try {
		PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("SmarTV","455 pol",stm);
		adicionarVariavel("Play","Play 4",stm);
		
		con.commit();
		stm.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Rollback executado");
			con.rollback();
			
			
		}

		}
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
	stm.setString(1, nome);
	stm.setString(2, descricao);

	stm.execute();
	ResultSet rst = stm.getGeneratedKeys();
	while(rst.next()) {
		Integer id = rst.getInt(1);
		System.out.println("O id criado foi: " + id);
		}
	rst.close();
	}
}
