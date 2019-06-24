package atividadesubmarino;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String cep;
    private String email;



    public Cliente(String cpf, String nome, String endereco, String cep, String email) {
        this.cep=cep;
        this.cpf=cpf;
        this.email=email;
        this.endereco=endereco;
        this.nome=nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }
}
