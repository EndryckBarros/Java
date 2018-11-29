package edu.entidade;

import java.util.ArrayList;

import edu.controller.ControleCompra;
import edu.controller.ControleProduto;

public class Principal {
	static ControleProduto CP = new ControleProduto();
	static ControleCompra CC = new ControleCompra();
	
	public static void main(String[] args) {
		
		String[] opcoes = { "Fazer Compra", "Gerenciar Produtos", "Histórico de Compras" };

		boolean continua = true;
		do {
			
			int opcao = Console.mostrarMenu(opcoes, "Selecione uma Opção:", null);

			switch (opcao) {
			case 1:
				menu3();
				break;
			case 2:
				menu2();
				break;
			case 3:
				ArrayList<Compra> compras = new ArrayList<>();
				compras = CC.listarCompras();
				
				if(compras.size() > 0) {
					for(Compra c : compras) {
						System.out.println("Valor: " + c.getValorTotal() + " Produto: " + c.getProduto().getNome() + 
								" Status: " + c.getStatus() + " Forma de Pagamento: " + c.getFormaDePagamento().getNome());
					}	
				}else {
					System.out.println("Nenhuma Compra Realizada");
					System.out.println();
				}
				break;
			case -1:
				System.out.println("Saindo...");
				continua = false;
				break;
			}
		} while (continua);	
	}
	
	public static void menu2() {
		
		
		String[] opcoes = { "Cadastrar Produto", "Listar Produtos", "Buscar Produto" };

		boolean continua = true;
		do {
			
			int opcao = Console.mostrarMenu(opcoes, "Selecione uma Opção:", null);

			switch (opcao) {
			case 1:
				Produto produto = new Produto();
				produto.setNome(Console.recuperaTexto("Informe o Nome do Produto: ")); 
				produto.setValor(Console.recuperaDecimal("Informe o Valor do Produto: "));
				produto = CP.cadastrarProduto(produto.getNome(), produto.getValor());
				
				if(produto == null) {
					System.out.println("Houve um erro ao cadastrar o Produto!");
				}else {
					System.out.println("Produto cadastrado com Sucesso!");
					System.out.println();
				}
				
				break;
			case 2:
				ArrayList<Produto> produtos = new ArrayList<>();
				produtos = CP.listarProdutos();
				if(produtos.size() > 0) {
					for(Produto p : produtos) {
						System.out.println(p.getNome());
					}
				}else {
					System.out.println("Não há Produtos cadastrados!");
				}
				break;
			case 3:
				produto = new Produto();
				produto.setNome(Console.recuperaTexto("Informe o Nome do Produto: ")); 
				produto = CP.buscarProduto(produto.getNome());
				
				if(produto != null) {
					System.out.println("Produto: " + produto.getNome() + 
									  " -- Valor: " + produto.getValor());
				}else {
					System.out.println("Produto não cadastrado!");
				}
				break;
			
			case -1:
				System.out.println("Saindo...");
				continua = false;
				break;
			}
		} while (continua);	
	}

	public static void menu3() {
		Produto produto = new Produto();
		String[] opcoes = { "Dinheiro", "Cheque", "Cartão de Crédito" };
		produto.setNome(Console.recuperaTexto("Informe o Nome do Produto: ")); 
		produto = CP.buscarProduto(produto.getNome());
		
		if(produto != null) {
			int opcao = Console.mostrarMenu(opcoes, "Selecione a Forma de Pagamento:", null);
			
			switch (opcao) {
			case 1:
				PagamentoDinheiro formaDePagamento = new PagamentoDinheiro();
				formaDePagamento.setNome("Dinheiro");
				formaDePagamento.setValor(produto.getValor());
				
				Compra compra = CC.cadastrarCompra(produto, formaDePagamento);
				if(compra.getStatus().equals("APROVADO")) {
					System.out.println("Compra Finalizada com Sucesso! ");
					System.out.println("Valor: " + compra.getValorTotal() + " Produto: " + compra.getProduto().getNome() + 
							" Status: " + compra.getStatus() + " Forma de Pagamento: " + formaDePagamento.getNome());
				}
				break;
			case 2:
				PagamentoCheque pagamentoCheque = new PagamentoCheque();
				pagamentoCheque.setNome("Cheque");
				pagamentoCheque.setBanco(Console.recuperaTexto("Qual o banco do Cheque?").toUpperCase());
				
				compra = CC.cadastrarCompra(produto, pagamentoCheque);
				if(compra.getStatus().equals("APROVADO")) {
					System.out.println("Compra Finalizada com Sucesso! ");
					System.out.println("Valor: " + compra.getValorTotal() + " Produto: " + compra.getProduto().getNome() + 
							" Status: " + compra.getStatus() + " Forma de Pagamento: " + pagamentoCheque.getNome());
				}else {
					System.out.println("Tivemos um problema na conclusão da venda: " + compra.getStatus());
				}
				break;
			case 3:
				PagamentoCartao pagamentoCartao = new PagamentoCartao();
				pagamentoCartao.setNome("Cartão de Crédito");
				pagamentoCartao.setBandeira(Console.recuperaTexto("Qual a Bandeira do cartão?").toUpperCase());
				
				compra = CC.cadastrarCompra(produto, pagamentoCartao);
				if(compra.getStatus().equals("APROVADO")) {
					System.out.println("Compra Finalizada com Sucesso! ");
					System.out.println("Valor: " + compra.getValorTotal() + " Produto: " + compra.getProduto().getNome() + 
							" Status: " + compra.getStatus() + " Forma de Pagamento: " + pagamentoCartao.getNome());
				}else {
					System.out.println("Tivemos um problema na conclusão da venda: " + compra.getStatus());
				}
				
				break;
			case -1:
				
				break;
			}
		}else {
			System.out.println("Produto não cadastrado!");
		}
		
	}
}
