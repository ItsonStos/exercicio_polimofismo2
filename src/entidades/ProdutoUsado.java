package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataFabricacao;
	
	public ProdutoUsado() {
	}
	

	public ProdutoUsado(String nome, double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}


	public ProdutoUsado(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	//Etiqueta de preco
	@Override
	public String EtiquetaPreco() {
		return super.getNome() 
				+ " (used) $ " 
				+ String.format("%.2f", super.getPreco())
				+ " (Data de fabricação: "
				+ sdf.format(dataFabricacao)
				+ ")";
	}
	
}
