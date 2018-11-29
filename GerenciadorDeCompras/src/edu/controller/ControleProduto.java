package edu.controller;

import java.util.ArrayList;

import edu.entidade.Produto;

public class ControleProduto {

	public ArrayList<Produto> produtos = new ArrayList<>();
	
	public Produto cadastrarProduto(String nome, double valor) {
		Produto produto = new Produto();
		produto.setNome(nome.toUpperCase());
		produto.setValor(valor);
		produtos.add(produto);
		return produto;
	}
	
	public Produto buscarProduto(String nome) {
		Produto produto = new Produto();
		for(Produto p : produtos) {
			if(p.getNome().equals(nome.toUpperCase())) {
				produto = p;
				return produto;
			}
		}
		return null;
	}
	
	public ArrayList<Produto> listarProdutos(){
		return produtos;
	}
}
