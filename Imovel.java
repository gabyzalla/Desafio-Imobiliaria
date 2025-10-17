import java.time.LocalDate; 

public abstract class Imovel {

    protected String endereco;
    protected String numero;
    protected boolean alugado;

    private Proprietario proprietario;
    private Inquilino inquilino; 
    private double valorAluguelBase;
    private double taxaManutencao; 
    private boolean permitePets;

    public Imovel(String endereco, String numero, Proprietario proprietario,
                  double valorAluguelBase, double taxaManutencao, 
                  boolean permitePets) { 
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.valorAluguelBase = valorAluguelBase;
        this.taxaManutencao = taxaManutencao;
        this.permitePets = permitePets;
        
        this.alugado = false;
        this.inquilino = null;
    }

    public abstract String verificarDisponibilidade();

    public CalculaAluguel calcularAluguel(int meses) {
        double valorMensalTotal = this.valorAluguelBase + this.taxaManutencao;
        double valorTotalFinal = valorMensalTotal * meses;

        return new CalculaAluguel(
            valorAluguelBase, 
            taxaManutencao, 
            meses,
            valorTotalFinal 
        );
    }

    public boolean alugar(Inquilino inquilino, int mesesContrato) { 
        if (this.alugado) {
            return false; 
        }
        this.alugado = true;
        this.inquilino = inquilino;
        return true;
    }

    public void disponibilizar() {
        this.alugado = false;
        this.inquilino = null;
    }
    
    public boolean estaAlugado() { return alugado; }
    public String contatoProprietario() { return proprietario.getNome() + " - Tel: " + proprietario.getTelefone(); }
    public String getEndereco() { return endereco; }
    public String getNumero() { return numero; } 
    public Proprietario getProprietario() { return proprietario; }
    public Inquilino getInquilino() { return inquilino; }
    public boolean isPermitePets() { return permitePets; }
    public double getValorAluguelBase() { return valorAluguelBase; }
    public double getTaxaManutencao() { return taxaManutencao; } 

    public boolean setValorAluguelBase(double novoValor) {
        if (!this.alugado) {
            this.valorAluguelBase = novoValor;
            return true;
        }
        return false; 
    }
}