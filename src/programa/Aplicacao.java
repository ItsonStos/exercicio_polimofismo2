package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		List<Produto> lista = new ArrayList<>(); 
		
		System.out.print("Entre com o numero de produtos: ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do produto #" + i);
			System.out.print("O produto é comum, importado ou usado (c,i,u)? " );
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Taxa Alfandegaria: ");
				double taxa = sc.nextDouble();
				Produto importado = new ProdutoImportado(nome, preco, taxa);
				lista.add(importado);
			}else if(ch == 'u') {
				System.out.print("Data de fabricação: (DD/MM/AAAA):");
				Date dataFabri = sdf.parse(sc.next());
				Produto prodUsado = new ProdutoUsado(nome, preco, dataFabri);
				lista.add(prodUsado);
			} else {
				Produto comum = new Produto(nome, preco);
				lista.add(comum);
			}	
		}
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO: ");
		for (Produto p : lista) {
			System.out.println(p.EtiquetaPreco());
		}
	}

}
