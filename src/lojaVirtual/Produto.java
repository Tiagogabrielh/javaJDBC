package lojaVirtual;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String n, String d) {
		super();
		this.nome = n;
		this.descricao = d;
		
	}
	
	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		
		return String.format("O produto é: %d, %s, %s",
				this.id, this.nome, this.descricao);
	}

}
