package br.ucsal.domain;

/**
 * 
 * @author Lucas Moreno Dantas Santos
 * */
public class Node {
	private String info;
	private Node proximo;
	
	public Node(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public Node getProximo() {
		return this.proximo;
	}
	
	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

}
