package br.ucsal.domain;
/**
 * 
 * @author Lucas Moreno Dantas Santos
 * */
public class ListaDaTurma {
	
	Node primeiroNode = null;
	int totalDeNodes = 0;
	
	//Insere um elemento no inicio da lista
	public void inserirInicio(String info) {
	    Node inserido = new Node(info);
	    inserido.setProximo(primeiroNode);
	    primeiroNode = inserido;
	    totalDeNodes++;
	}
	
	
	public void inserirNoFinal(String info) {
		if (this.totalDeNodes == 0) {
			inserirInicio(info);
		} else {
			Node inserido = new Node(info);
			Node node = primeiroNode;
			for (int i = 0; i < this.totalDeNodes-1; i++) {
				node = node.getProximo();
			}
			node.setProximo(inserido);;
			totalDeNodes++;
		}
	}
	
	//Insere um elemento em uma posi��o indicada pelo usu�rio
	public void inserirNaPosicao(int indice, String info) {
		if (indice > this.totalDeNodes) {
			System.out.println("O �ndice informado � maior que o tamanho da lista");
			return;
		}
		if (indice == 0) {
			inserirInicio(info);
		} else if (indice == this.totalDeNodes) {
			inserirNoFinal(info);
		} else {
			Node inserido = new Node(info);
			Node no = buscarPorIndice(indice);
			
			inserido.setProximo(no);
			no.setProximo(inserido); 
			totalDeNodes++;
		}
	}
	
	public void removerElementoInicio() {
		this.primeiroNode = primeiroNode.getProximo();
		this.totalDeNodes--;
		System.out.println("Removido");
	}
	
	public void removerElementoFinal() {
		Node penultimoNode = this.buscarPorIndice(totalDeNodes - 1);
		penultimoNode.setProximo(null);
		this.totalDeNodes--;
		System.out.println("Removido");
	}
	
	//Remove um elemento da lista na posi��o indicada pelo �ndice
	public void removerPorIndice(int indice) {
		if (indice > this.totalDeNodes) {
			System.out.println("O �ndice informado � maior que o tamanho da lista");
			return;
		}
		if (this.totalDeNodes == 0) {
			System.out.println("N�o foi poss�vel realizar a opera��o. A lista est� vazia.");
			return;
		} 
		if (this.totalDeNodes == 1) {
			removerElementoInicio();
		} else {
			Node anterior = buscarPorIndice(indice - 1);
			Node atual = anterior.getProximo();
			anterior.setProximo(atual.getProximo());
			this.totalDeNodes--;
			System.out.println("Removido");
		}
	}
	
	//M�todo que percorre toda a lista, comparando a String passada como 
	//argumento com o conte�do armazenado no n� atual, retornando se existe
	//ou n�o na lista
	public void pesquisarNaLista(String nome) {
		Node no = primeiroNode;
		for (int i = 0; i < this.totalDeNodes; i++) {
			
			if (no.getInfo().equals(nome)) {
				System.out.println("O nome informado est� na lista");
				return;
			}
			no = no.getProximo();
		}
		if (no == null) {
			System.out.println("O nome informado n�o est� na lista");
		}
	}

	// Recebe um indice pelo usu�rio e retorna o endere�o de mem�ria de um Node 
	private Node buscarPorIndice(int indice) {
		
		if (indice >=0 && indice < this.totalDeNodes) {
			Node node = primeiroNode;
			for (int i = 0; i < indice; i++) {
				node = node.getProximo();
			}
			return node;
		} else {
			throw new IllegalArgumentException("A posi��o informada n�o existe");
		}
	}
	
	// M�todo que retorna o total de elementos da lista, e apresenta todo o conte�do sequencialmente, caso haja algum elemento na lista
	@Override
	public String toString() {
		
		if (this.totalDeNodes == 0) {
			return "A lista est� vazia";
		}
		
		StringBuilder str = new StringBuilder("Tamanho da Lista da Turma : (" + totalDeNodes + ")\n");
//		Node ponteiroAtual = primeiroNode;
//		
//		for (int i = 0; i < this.totalDeNodes; i++) {
//			str.append(ponteiroAtual.getInfo());
//			str.append(", ");
//			ponteiroAtual = ponteiroAtual.getProximo();
//		}
//		str.append("]");
		
		return str.toString();
	}
	
	//M�todo que imprime todos os nomes inseridos na lista
	public void imprimirLista() {
		Node node = this.primeiroNode;
		for (int i = 0; i < this.totalDeNodes; i++) {
			System.out.print(node.getInfo() + ", ");
			node = node.getProximo();
		}
		System.out.println();
	}
}
