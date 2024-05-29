package med.voll.api.domain.consulta;


import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// essa classe service é responsavel pelas regras de negocio
@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

   /* esse parametro em dados tras apenas o id do medico e do paciente, porem precisamos da
    entidade medico/paciente inteiros para fazer o relacionamento na tabela, observe na linha 45.  */

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados ) {

        // precisamos verificar primeiro se o id do paciente esta vindo.
        if(!pacienteRepository.existsById(dados.id_paciente())){
            throw new ValidacaoConsulta("Id do Paciente informado não existe no banco de dados.");
        }

        // como a escolha do medico é opcional, primeiro se verifica se ele veio e dps se ele existe.
        if (dados.id_medico() !=  null &&  !medicoRepository.existsById(dados.id_medico())){
            throw new ValidacaoConsulta("Id do Medico informado não existe no banco de dados.");
        }

        validadores.forEach(v -> v.validar(dados));


        // por isso precisamos trazer a entidade medico e coloca-la em uma variavel.
        var paciente = pacienteRepository.getReferenceById(dados.id_paciente());

        // o mesmo com medicos.
        var medico = escolherMedico(dados);

        // criando a entidade consulta, passando os parametros de medico, paciente e data.
        var consulta = new Consulta(null, medico, paciente, dados.data());

        // salvando no banco.
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.id_medico() !=null ){
            return medicoRepository.getReferenceById(dados.id_medico());

        }
        if(dados.especialidade() == null){

            throw new ValidacaoConsulta("Especialidade é obrigatoria quando o medico não foi escolhido");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade(), dados.data());

    }


}
