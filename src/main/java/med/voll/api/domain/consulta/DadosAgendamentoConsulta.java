package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Especialidade.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
                                       @NotNull(message = "ERRO, MEDICO NÃO INFORMADO") Long id_medico,
                                       @NotNull(message = "ERRO, PACIENTE NÃO INFORMADO")
                                       Long id_paciente,
                                       @NotNull(message = "ERRO, DATA NÃO PODE ESTA EM BRANCO")
                                       @Future(message = "ERRO, PRECISA SER UMA DATA FUTURA")
                                       LocalDateTime data
                                    , Especialidade especialidade) {
}
