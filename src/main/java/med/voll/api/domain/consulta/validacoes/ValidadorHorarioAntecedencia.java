package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;



// classe meia hora antecedencia
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta{

    public void validar( DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoConsulta("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }

}
