package servicos;

import entidades.Filme;
import entidades.NotaAluguel;
import utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, String tipo) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque");

		NotaAluguel nota = new NotaAluguel();
		if ("extendido".equals(tipo)) {
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(DateUtils.obterDataDifDias(3));
			nota.setPontuacao(2);
		} else {
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(DateUtils.obterDataDifDias(1));
		}

		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
