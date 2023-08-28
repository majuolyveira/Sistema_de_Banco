import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static Banco instanciaUnica = new Banco();
    private List<Titular> titulares;
    private List<Conta> contas;

    private Banco() {
        titulares = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public static Banco getInstancia() {
        return instanciaUnica;
    }

    public void adicionarTitular(Titular titular) {
        titulares.add(titular);
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Titular> getTitulares() {
        return titulares;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
