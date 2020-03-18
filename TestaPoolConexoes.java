import java.sql.SQLException;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++){
			con.recuperaConexao();
			System.out.println("Numero da conexao: " + i);
		}
		
	}

}
