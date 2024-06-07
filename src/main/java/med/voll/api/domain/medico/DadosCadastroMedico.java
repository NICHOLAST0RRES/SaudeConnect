package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Especialidade.Especialidade;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "ERRO, O NOME DO MEDICO NÃO PODE SER CADASTRADO EM BRANCO")
        String nome,
        @NotBlank(message = "ERRO, O EMAIL DO MEDICO NÃO PODE SER CADASTRADO EM BRANCO ")
        @Email(message = "ERRO, EMAIL INVALIDO")
        String email,

        @NotBlank(message = "ERRO, O TELEFONE DO MEDICO NÃO PODE SER CADASTRADO EM BRANCO ")
        String telefone,
        @NotBlank(message = "ERRO, O CRM DO MEDICO NÃO PODE SER CADASTRADO EM BRANCO ")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull (message = "ERRO, A ESPECIALIDADE DO MEDICO NÃO PODE SER CADASTRADO EM BRANCO ")
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
