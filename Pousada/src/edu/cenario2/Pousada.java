package edu.cenario2;

public class Pousada {

	private String nome;
	private String cidade;
	private String estado;
	private double precoPernoite;
	private int quantidadeQuartos;
	private int[] quartos;
	
	public Pousada(String nome, String cidade, String estado, double precoPernoite, int quantidadeQuartos) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.precoPernoite = precoPernoite;
		this.quantidadeQuartos = quantidadeQuartos;
		
		quartos = new int[this.quantidadeQuartos];
		
		for (int i = 0; i < quartos.length; i++) {
			quartos[i] = 0;
		}
		
//		Pousada politanos = new Pousada("Politanos", "Salvador", "Bahia", 58.75, 38);
//		politanos.quartos = new int[politanos.quantidadeQuartos];
//		for (int i = 0; i < politanos.quartos.length; i++) {
//			politanos.quartos[i] = 0;
//		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecoPernoite() {
		return precoPernoite;
	}
	public void setPrecoPernoite(double precoPernoite) {
		this.precoPernoite = precoPernoite;
	}
	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}
	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}
	public int[] getQuatos() {
		return quartos;
	}
	public void setQuatos(int[] quatos) {
		this.quartos = quatos;
	}
	
	public boolean ocuparQuarto(int numeroDoQuarto) {
		numeroDoQuarto = numeroDoQuarto -1;
		if(getQuatos()[numeroDoQuarto] == 0) {
			
			getQuatos()[numeroDoQuarto] = 1;
			return true;
		}
			return false;	
	}
	
	public int desocuparQuarto(int numeroDoQuarto) {
		numeroDoQuarto = numeroDoQuarto -1;
		return getQuatos()[numeroDoQuarto];
	}
	
	public int totalQuartosLivres() {
		int contador = 0;
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] == 0) {
				contador = contador + 1;
			}
		}return contador;
	}
	
	public int totalQuartosOcupados() {
		int contador = 0;
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] == 1) {
				contador = contador + 1;
			}
		}return contador;
	}
	
	public int[] quartosLivres() {
		int cont = 0;
		int[] quartosLivres = new int[totalQuartosLivres()];
		
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] == 0) {
				quartosLivres[cont] = i + 1;
				cont ++;
			}
		}return quartosLivres;
	}
	
	public int[] quartosOcupados() {
		int cont = 0;
		int[] quartosOcupados = new int[totalQuartosOcupados()];
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] == 1) {
				quartosOcupados[cont] = i + 1;
				cont ++;
			}
		}return quartosOcupados;
	}
	
	public double valorParaFaturar() {
		double faturamento = totalQuartosOcupados() * precoPernoite;
		return faturamento;
	}
}
