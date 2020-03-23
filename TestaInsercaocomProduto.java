import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaocomProduto {

	public static void main(String[] args) throws SQLException {

		Produto comada = new Produto("Computador", "Computador de Mesa");
		
		try(Connection con = new ConnectionFactory().recuperaConexao()){
			String sql = "insert into produto (nome, descricao) values (?, ?)";
			
			try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, comada.getNome());
				pstm.setString(2, comada.getDescricao());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						comada.setId(rst.getInt(1));
					}
				}
			}
		}
		
		System.out.println(comada);
		
	}

}
