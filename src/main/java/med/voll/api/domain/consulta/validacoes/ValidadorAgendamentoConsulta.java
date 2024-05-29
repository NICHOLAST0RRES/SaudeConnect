package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
