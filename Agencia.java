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
}
