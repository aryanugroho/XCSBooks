package control;

import java.util.ArrayList;
import java.util.List;
import model.LivroNovo;

public class TestListBooks {

	public List<LivroNovo> listaLivro;
	
	public TestListBooks() {
		// TODO Auto-generated constructor stub
		listaLivro = new ArrayList<LivroNovo>();
		LivroNovo livro = new LivroNovo(1, 1, 10.0, "123456789", "Conde de MonteCristo",
				"Miguel Rosa", "Atica");
		listaLivro.add(livro);
		livro = new LivroNovo(2, 3, 15.0, "998745612", "Dom Casmurro",
				"Machado de Assis", "Moderna");
		listaLivro.add(livro);
		livro = new LivroNovo(3, 3, 13.0, "97745612", "Memorias do Sargento de Milicias",
				"Machado de Assis", "Moderna");
		listaLivro.add(livro);
	}

}
