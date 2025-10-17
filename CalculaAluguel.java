public class CalculaAluguel {

    private final double valorAluguelBaseMensal;
    private final double taxaManutencaoMensal;
    private final int totalMeses;
    private final double subTotalSemDesconto; 
    private final double percentualDesconto;
    private final double valorDesconto;
    private final double valorTotalPeriodo; 

    public CalculaAluguel(double valorAluguelBaseMensal, double taxaManutencaoMensal, 
                          int totalMeses, double subTotalSemDesconto, 
                          double percentualDesconto, double valorDesconto, 
                          double valorTotalPeriodo) {
        this.valorAluguelBaseMensal = valorAluguelBaseMensal;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
        this.totalMeses = totalMeses;
        this.subTotalSemDesconto = subTotalSemDesconto; 
        this.percentualDesconto = percentualDesconto; 
        this.valorDesconto = valorDesconto;         
        this.valorTotalPeriodo = valorTotalPeriodo;
    }

    public double getValorAluguelBaseMensal() {
        return valorAluguelBaseMensal;
    }
    public double getTaxaManutencaoMensal() {
        return taxaManutencaoMensal;
    }
    public int getTotalMeses() {
        return totalMeses;
    }
    public double getSubTotalSemDesconto() { 
        return subTotalSemDesconto;
    }
    public double getPercentualDesconto() { 
        return percentualDesconto;
    }
    public double getValorDesconto() { 
        return valorDesconto;
    }
    public double getValorTotalPeriodo() {
        return valorTotalPeriodo;
    }
}