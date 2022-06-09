
/**
 * @author Adriel Faria dos Santos
 * @version 0.1
 */
public class Conta
{
    private String codigo;
    private String tipo;
    private double saldo;
    private double limite;
    
    public Conta() {
        this.saldo = 0;
    }
    
    public Conta(double saldo) {
        this.saldo = saldo;
    }
    
    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public Conta(String codigo, String tipo, double saldo, double limite) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double getLimite() {
        return limite;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public boolean sacar(double valor) {
        if (valor < 0) return false;
        if (valor > saldo + limite) return false;
        
        saldo -= valor;
        return true;
    }
    
    public double verSaldo() {
        return getSaldo();
    }
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
     public void transferir(double valor, Conta c) {
        if (valor > 0 && valor <= saldo + limite) {
            this.saldo -= valor;
            c.saldo += valor;
        }
    }
}
