package javaSwingProject;

public class Estadia {
	Responsavel responsavel;
	Crianca crianca;
	int tempoUtilizado;
	
	public Estadia(Responsavel responsavel, Crianca crianca, int tempoUlizado) {
		this.responsavel = responsavel;
		this.crianca = crianca;
		this.tempoUtilizado = tempoUlizado;
	}
	

  public double calcularCusto() {
	  double custoPorMinuto = 1.50;
	  double custoTotal = tempoUtilizado * custoPorMinuto;
	  
	  if(tempoUtilizado > 60) {
		  custoTotal *= 0.85; // Desconto de 15% para mais de 60 min 
	  }else if(tempoUtilizado > 40) {
		  custoTotal *= 0.90; // Desconto de 10% para mais de 40 min 
	  }
	  else if(tempoUtilizado > 20) {
		  custoTotal *= 0.95; // Desconto de 5% para mais de 40 min 
	  }
	 
	 return custoTotal;
  }
}
