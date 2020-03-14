import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("delete from produto where id > ?");
		stm.setInt(1, 5);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("A quantidade de linahs modificadas foram: " + linhasModificadas);
		
	}
	
}
