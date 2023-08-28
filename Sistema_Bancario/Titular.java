import java.util.UUID;

public class Titular {
    private String id;
    private String nome;
    private String telefone;
    private String endereco;

    public Titular(String nome, String telefone, String endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nEndereço: " + endereco;
    }
}
