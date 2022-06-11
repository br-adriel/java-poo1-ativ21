import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.*;
import java.util.List;

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
    private ArrayList<Registro> registros;
    private LocalDateTime ultimaManutencao;
    
    public Conta() {
        this.saldo = 0;
        registros = new ArrayList<Registro>();
        ultimaManutencao = LocalDateTime.of(2000, 1, 1, 12, 0, 0, 0);
    }
    
    public Conta(double saldo) {
        this();
        this.saldo = saldo;
    }
    
    public Conta(double saldo, double limite) {
        this();
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public Conta(String codigo, String tipo, double saldo, double limite) {
        this();
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
        registros.add(new Registro("saque", -1 * valor));
        return true;
    }
    
    public double verSaldo() {
        return getSaldo();
    }
    
    public void depositar(double valor) {
        saldo += valor;
        registros.add(new Registro("deposito", valor));
    }
    
     public void transferir(double valor, Conta c) {
        if (valor > 0 && valor <= saldo + limite) {
            this.saldo -= valor;
            c.saldo += valor;
            this.registros.add(new Registro("transferencia", -1 * valor));
            c.registros.add(new Registro("transferencia", valor));
        }
    }
    
    public ArrayList<Registro> extrato(int dias) {
        LocalDateTime limite = LocalDateTime.now().minusDays(dias);
        
        List<Registro> lista = registros.stream().filter(r -> r.getData().isAfter(limite)).collect(Collectors.toList());
        return new ArrayList<Registro>(lista);
    }
    
    public void descontarTaxaManutencao(double taxa) {
        boolean proibidoDescontar = ultimaManutencao.getMonth().equals(LocalDateTime.now().getMonth());
        proibidoDescontar = proibidoDescontar && ultimaManutencao.getYear() == LocalDateTime.now().getYear();
        if (taxa > 0 && !proibidoDescontar) {
            this.saldo -= taxa;
            this.registros.add(new Registro("taxa de manuntencao", -1 * taxa));
            ultimaManutencao = LocalDateTime.now();
        }
    }
    
    public void render(double porcentagem) {
        saldo += porcentagem * saldo;
    }
}
