import java.util.ArrayList;
import java.util.stream.*;

/** 
 * @author Adriel Faria dos Santos
 * @version 0.1
 */
public class Agencia
{
    private String codigo;
    private ArrayList<Conta> contas;
    
    public Agencia(String codigo) {
        this.codigo = codigo;
        this.contas = new ArrayList<Conta>();
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    
    public ArrayList<Conta> getContas() {
        return contas;
    }
    
    public void addConta(Conta conta) {
        contas.add(conta);
    }
    
    public void removeConta(Conta conta) {
        contas.remove(conta);
    }
    
    public double saldoTotal() {
        return contas.stream().mapToDouble(c -> c.getSaldo()).sum();
    }
    
    public Conta pesquisarConta(String codigoConta) {
        return contas.stream().filter(c -> c.getCodigo().equals(codigoConta)).findFirst().get();
    }
    
    public boolean sacar(String conta, double valor) {
        Conta c = pesquisarConta(conta);
        return c.sacar(valor);
    }
    
    public double verSaldo(String conta) {
        Conta c = pesquisarConta(conta);
        return c.getSaldo();
    }
    
    public void transferir(String origem, String destino, double valor) {
        Conta or = pesquisarConta(origem);
        Conta de = pesquisarConta(destino);
        or.transferir(valor, de);
    }
    
    public void depositar(String conta, double valor) {
        Conta c = pesquisarConta(conta);
        c.depositar(valor);
    }
    
    public void descontarTaxaManutencao(double taxa) {
        if (taxa > 0) {
            contas.stream().forEach(c -> c.descontarTaxaManutencao(taxa));
        }
    }
}
