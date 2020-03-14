import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection con = factory.recuperaConexao()){
		con.setAutoCommit(false);
		
			try (PreparedStatement stm = con.prepareStatement("insert into produto (nome, descricacao) values ( ?, ?)" 
					, Statement.RETURN_GENERATED_KEYS)){
				
				
				adicionarVariavel("Friser","Frizer panasonic", stm);
				adicionarVariavel("Micro Ondas","Micro Ondas cell", stm);
				con.commit();
				
				stm.close();
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
			}
			
		}
		
	}

	private static void adicionarVariavel( String nome, String descricao, PreparedStatement stm) throws SQLException {
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if(nome.equals("Friser")) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}
		
		stm.execute();
		
		
		
			try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}

}
