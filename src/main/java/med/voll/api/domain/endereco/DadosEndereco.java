package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "ERRO, LOGRADOURO NÃO INFORMADO")
        String logradouro,
        @NotBlank(message = "ERRO, BAIRRO NÃO INFORMADO")
        String bairro,
        @NotBlank(message = "ERRO, CEP NÃO INFORMADO")
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank(message = "ERRO, CIDADE NÃO INFORMADA")
        String cidade,
        @NotBlank(message = "ERRO, UNIDADE FEDERATIVA NÃO INFORMADA")
        String uf,
        String complemento,
        String numero) {
}
