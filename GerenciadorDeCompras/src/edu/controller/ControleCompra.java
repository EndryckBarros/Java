package edu.controller;

import java.util.ArrayList;

import edu.entidade.Compra;
import edu.entidade.PagamentoCartao;
import edu.entidade.PagamentoCheque;
import edu.entidade.PagamentoDinheiro;
import edu.entidade.Produto;

public class ControleCompra {
	
	public ArrayList<Compra> historico = new ArrayList<>();
	

	public Compra cadastrarCompra(Produto produto, PagamentoDinheiro formaDePagamento) {
		Compra compra = new Compra();
		
		compra.setValorTotal(produto.getValor());
		compra.setProduto(produto);
		compra.setStatus("APROVADO");
		compra.setFormaDePagamento(formaDePagamento);
		
		historico.add(compra);
		return compra;
	}
	
	public Compra cadastrarCompra(Produto produto, PagamentoCartao formaDePagamento) {
		Compra compra = new Compra();
		
		compra.setValorTotal(produto.getValor());
		compra.setProduto(produto);
		compra.setFormaDePagamento(formaDePagamento);
		if(formaDePagamento.getBandeira().equals("AMEX")) {
			compra.setStatus("APROVADO");
		}else {
			compra.setStatus("BANDEIRA NÃO ACEITA");
		}
		historico.add(compra);
		return compra;
	}
	
	public Compra cadastrarCompra(Produto produto, PagamentoCheque formaDePagamento) {
		Compra compra = new Compra();
		
		compra.setValorTotal(produto.getValor());
		compra.setProduto(produto);
		compra.setFormaDePagamento(formaDePagamento);
		if(formaDePagamento.getBanco().equals("CAIXA ECONÔMICA")) {
			compra.setStatus("APROVADO");
		}else {
			compra.setStatus("BANCO NÃO ACEITO");
		}
		historico.add(compra);
		return compra;
	}
	
	public ArrayList<Compra> listarCompras(){
		return historico;
	}
}
