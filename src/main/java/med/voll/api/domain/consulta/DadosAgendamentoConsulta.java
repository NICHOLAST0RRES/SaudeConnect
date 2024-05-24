package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Especialidade.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long id_medico, @NotNull Long id_paciente, @NotNull @Future LocalDateTime data , Especialidade especialidade) {
}
