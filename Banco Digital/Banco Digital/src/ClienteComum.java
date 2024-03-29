import java.time.LocalDate;

public class ClienteComum extends Pessoa {

    public ClienteComum(String cpf, String nome, LocalDate dataNascimento, String endereco) {
        super(cpf, nome, dataNascimento, endereco);
    }

}
