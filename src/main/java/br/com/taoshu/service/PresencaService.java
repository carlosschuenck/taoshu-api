package br.com.taoshu.service;

import br.com.taoshu.entity.Presenca;
import br.com.taoshu.repository.PresencaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@Service
@Transactional
public class PresencaService {

    private final PresencaRepository presencaRepository;

    public PresencaService(PresencaRepository presencaRepository) {
        this.presencaRepository = presencaRepository;
    }

    @Transactional(readOnly = true)
    public List<Presenca> buscarTodos() {
        return presencaRepository.findAll();
    }

    public Presenca inserir(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public Presenca atualizar(Presenca presenca) {
        Presenca ultimaVersao = presencaRepository.getOne(presenca.getId());
        ultimaVersao.setData(presenca.getData());
        ultimaVersao.setPresenca(presenca.getPresenca());
        return presencaRepository.save(ultimaVersao);
    }

    public void deletar(Long id) {
        presencaRepository.deleteById(id);
    }
}
