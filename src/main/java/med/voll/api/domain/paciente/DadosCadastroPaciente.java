package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;

public record DadosCadastroPaciente(
        @NotBlank(message = "ERRO, O NOME DO PACIENTE NÃO PODE SER CADASTRADO EM BRANCO")
        String nome,
        @NotBlank(message = "ERRO, O EMAIL DO PACIENTE NÃO PODE SER CADASTRADO EM BRANCO")
        @Email(message = "ERRO, EMAIL INVALIDO")
        String email,

        @NotBlank (message = "ERRO, O TELEFONE DO PACIENTE NÃO PODE SER CADASTRADO EM BRANCO")
        String telefone,
        @NotBlank (message = "ERRO, O CPF DO PACIENTE NÃO PODE SER CADASTRADO EM BRANCO")
        @Pattern (regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}" , message = "ERRO, O CPF INFORMADO É INVALIDO")
        String cpf,

        @NotNull(message = "ERRO, O ENDEREÇO DO PACIENTE NÃO PODE SER CADASTRADO EM BRANCO")
        @Valid DadosEndereco endereco) {
}
