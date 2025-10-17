public class Apartamento extends Imovel {

    private String numeroApartamento;

    public Apartamento(String endereco, String numeroPredio, String numeroApartamento, Proprietario proprietario,
                       double valorAluguelBase, double taxaManutencao, 
                       boolean permitePets) { 
        super(endereco, numeroPredio, proprietario, valorAluguelBase, taxaManutencao, permitePets);
        this.numeroApartamento = numeroApartamento;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    @Override
    public String verificarDisponibilidade() {
        String infoBase = "O apartamento de numero " + getNumeroApartamento() + 
                          " (Predio em " + getEndereco() + ", " + getNumero() + ")";
        
        if (estaAlugado()) {
             return infoBase + " esta alugado."; 
        } else {
            return infoBase + " esta disponivel.";
        }
    }
}