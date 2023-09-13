package lojaVirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		try(Connection con = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			
			listaDeCategorias.stream().forEach(ct -> {
				
				System.out.println(ct.getNome());
				for(Produto produto : ct.getProdutos()) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				
				});
		}

	}

}
