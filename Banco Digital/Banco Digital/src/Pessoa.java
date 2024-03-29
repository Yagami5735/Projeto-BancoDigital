import java.time.LocalDate;

public abstract class Pessoa {
    private final String cpf;
    private final String nome;
    private final LocalDate dataNascimento;
    private String endereco;

    public Pessoa(String cpf, String nome, LocalDate dataNascimento, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
