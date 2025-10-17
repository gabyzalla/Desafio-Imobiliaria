public class CalculaAluguel {

    private final double valorAluguelBaseMensal;
    private final double taxaManutencaoMensal;
    private final int totalMeses;
    private final double valorTotalPeriodo; 

    public CalculaAluguel(double valorAluguelBaseMensal, double taxaManutencaoMensal, 
                          int totalMeses, double valorTotalPeriodo) {
        this.valorAluguelBaseMensal = valorAluguelBaseMensal;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
        this.totalMeses = totalMeses;
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

    public double getValorTotalPeriodo() {
        return valorTotalPeriodo;
    }
}