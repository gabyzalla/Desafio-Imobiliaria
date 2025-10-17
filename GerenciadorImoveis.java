import java.util.List;
import java.util.ArrayList;

public class GerenciadorImoveis {

    private final List<Imovel> imoveis = new ArrayList<>();
    
    public Imovel buscarPorEnderecoENumero(String endereco, String numero) {
        String endBusca = endereco.trim().toUpperCase();
        String numBusca = numero.trim().toUpperCase();

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().trim().toUpperCase().equals(endBusca) &&
                imovel.getNumero().trim().toUpperCase().equals(numBusca)) {
                return imovel; 
            }
        }
        return null; 
    }

    public boolean cadastrarImovel(Imovel imovel) {
        Imovel existente = buscarPorEnderecoENumero(imovel.getEndereco(), imovel.getNumero());
        
        if (existente != null) { 
            return false; 
        }
        
        imoveis.add(imovel);
        return true;
    }

    public boolean deletarImovel(String endereco, String numero) {
        Imovel imovel = buscarPorEnderecoENumero(endereco, numero);
        
        if (imovel == null) { 
            return false; 
        }
        
        if (imovel.estaAlugado()) {
            return false; 
        }
        
        imoveis.remove(imovel); 
        return true;
    }

    public boolean alugarImovel(String endereco, String numero, Inquilino inquilino, int mesesContrato) {
        Imovel imovel = buscarPorEnderecoENumero(endereco, numero);
        
        if (imovel == null) { 
            return false; 
        }

        return imovel.alugar(inquilino, mesesContrato); 
    }

    public boolean disponibilizarImovel(String endereco, String numero) {
        Imovel imovel = buscarPorEnderecoENumero(endereco, numero);

        if (imovel == null) { 
            return false; 
        }
        
        if (!imovel.estaAlugado()) {
            return false; 
        }

        imovel.disponibilizar();
        return true;
    }

    public CalculaAluguel calcularAluguel(String endereco, String numero, int meses) {
        Imovel imovel = buscarPorEnderecoENumero(endereco, numero);
        
        if (imovel != null) { 
            return imovel.calcularAluguel(meses);
        }
        return null; 
    }
    
    public List<Imovel> getTodosImoveis() {
        return imoveis;
    }

    public List<Imovel> getImoveisAlugados() {
        List<Imovel> alugados = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.estaAlugado()) {
                alugados.add(imovel);
            }
        }
        return alugados;
    }
    
    public List<Imovel> getImoveisDisponiveis() {
         List<Imovel> disponiveis = new ArrayList<>();
         for (Imovel imovel : imoveis) {
             if (!imovel.estaAlugado()) {
                 disponiveis.add(imovel);
             }
         }
         return disponiveis;
    }
}