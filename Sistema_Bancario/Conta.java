
public class Conta {
    private String id;
    private Titular titular;
    private double saldo;
    private String agencia;
    private String numero;

    // public Conta(){
    // }
    public Conta(String id, Titular titular, double saldo, String agencia, String numero) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
    }
    

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public void setTitular(Titular titular) {
        this.titular = titular;
    }
    public Titular getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public String toString() {
        return "Titular: " + titular + "  Saldo: " + saldo ;
        
    }
    public void depositar(double valor){
        saldo += valor;
    }

    public boolean sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            System.out.println("Saldo Insuficiente");
            return false;
        }
    }

    public void transferir(Conta destino, double valor){
        if (sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Tranf. realizada");
        } else{
            System.out.println("transf. não realizada");
        }
        
        

    }


}
