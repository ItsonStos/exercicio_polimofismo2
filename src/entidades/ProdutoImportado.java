package entidades;

public class ProdutoImportado extends Produto{
	private double taxaAlfandega;
	
	public ProdutoImportado() {
	}

	public ProdutoImportado(String nome, double preco, double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	// etiqueta de preço	
	public double PrecoTotal() {
		return super.getPreco() + taxaAlfandega;
	}
	
	@Override
	public String EtiquetaPreco() {
		return super.getNome() 
				+ " $ " 
				+ String.format("%.2f", PrecoTotal())
				+ " (Taxa alfandegária: $ "
				+ String.format("%.2f",taxaAlfandega)
				+ ")";
	}
	

}
