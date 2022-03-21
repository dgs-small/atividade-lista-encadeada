package br.ucsal.teste;

import br.ucsal.domain.ListaDaTurma;
/**
 * 
 * @author Lucas Moreno Dantas Santos
 * */
public class Main {

	public static void main(String[] args) {
		ListaDaTurma lista = new ListaDaTurma();
		// a)
		lista.inserirInicio("Professor - Hamilton");
		// b)
		lista.inserirNoFinal("Aluno - Lucas");
		lista.inserirNoFinal("Aluno - João");
		lista.inserirNoFinal("Aluno - Lyla");
		lista.inserirNoFinal("Aluno - Carlos");
		lista.inserirNoFinal("Aluno - Julie");
		lista.inserirNoFinal("Aluno - Maria");
		//c)
		System.out.println(lista);
		lista.imprimirLista();
		
		//d
		lista.removerPorIndice(4);
		System.out.println(lista);
		lista.imprimirLista();
		
		// e)
		lista.pesquisarNaLista("Aluno - Leonidas");
		
		lista.removerElementoFinal();
		System.out.println(lista);
		lista.imprimirLista();

	}

}
