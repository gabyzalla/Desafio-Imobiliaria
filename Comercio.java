public class Comercio extends Imovel {

    private String tipoNegocioPermitido; 

    public Comercio(String endereco, String numero, Proprietario proprietario,
                    double valorAluguelBase, double taxaManutencao, 
                    boolean permitePets, String tipoNegocioPermitido) { 
        super(endereco, numero, proprietario, valorAluguelBase, taxaManutencao, permitePets);
        this.tipoNegocioPermitido = tipoNegocioPermitido;
    }

    public String getTipoNegocioPermitido() {
        return tipoNegocioPermitido;
    }

    @Override
    public String verificarDisponibilidade() {
        String infoBase = "O ponto comercial (tipo: " + getTipoNegocioPermitido() + 
                          ") em " + getEndereco() + ", " + getNumero();
        
        if (estaAlugado()) {
            return infoBase + " esta alugado."; 
        } else {
            return infoBase + " esta disponivel.";
        }
    }
}