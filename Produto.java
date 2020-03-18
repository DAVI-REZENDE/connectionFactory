
public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	String getDescricao() {
		return descricao;
	}

	void setId(int id) {
		this.id = id;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("O produto criado foi: %d, %s, %s", this.id, this.nome, this.descricao);
	}
}
