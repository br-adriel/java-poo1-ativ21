import java.util.ArrayList;
import java.util.stream.*;

/**
 * @author Adriel Faria dos Santos
 * @version 0.1
 */
public class Banco
{
    private String codigo;
    private String nome;
    private ArrayList<Agencia> agencias;
    
    public Banco(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.agencias = new ArrayList<Agencia>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }

    public void addAgencia(Agencia agencia) {
        this.agencias.add(agencia);
    }

    public void removeAgencia(Agencia agencia) {
        this.agencias.remove(agencia);
    }
    
    public double saldoTotal() {
        return agencias.stream().mapToDouble(a -> a.saldoTotal()).sum();
    }
    
    public void renderContasPoupanca(double porcentagem) {
        agencias.stream().forEach(a -> a.renderContasPoupanca(porcentagem));
    }
}
