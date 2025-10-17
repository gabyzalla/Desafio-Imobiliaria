public class Casa extends Imovel {

    public Casa(String endereco, String numero, Proprietario proprietario,
                double valorAluguelBase, double taxaManutencao, 
                boolean permitePets) { 
        super(endereco, numero, proprietario, valorAluguelBase, taxaManutencao, permitePets);
    }

    @Override
    public String verificarDisponibilidade() {
        String infoBase = "A casa em " + getEndereco() + ", " + getNumero();
        
        if (estaAlugado()) {
            return infoBase + " esta alugada."; 
        } else {
            return infoBase + " esta disponivel.";
        }
    }
}