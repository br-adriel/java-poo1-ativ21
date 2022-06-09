import java.time.LocalDateTime;

/**
 * @author Adriel Faria dos Santos
 * @version 0.1
 */
public class Registro
{
    private LocalDateTime data;
    private String operacao;
    private double alteracaoSaldo;
    
    public Registro(String operacao, double alteracaoSaldo) {
        this.data = LocalDateTime.now();
        this.operacao = operacao;
        this.alteracaoSaldo = alteracaoSaldo;   
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public String getOperacao() {
        return operacao;
    }
    
    public double getAlteracaoSaldo() {
        return alteracaoSaldo;
    }
}
