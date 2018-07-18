package br.com.taoshu.service;

import br.com.taoshu.entity.Presenca;
import br.com.taoshu.repository.PresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@Service
@Transactional(readOnly = false)
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

    @Transactional(readOnly = true)
    public List<Presenca> findAll() {
        return presencaRepository.findAll();
    }

    public Presenca persist(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public Presenca update(Presenca presenca) {
        Presenca oldPresenca = presencaRepository.getOne(presenca.getId());
        oldPresenca.setData(presenca.getData());
        oldPresenca.setPresenca(presenca.getPresenca());
        return presencaRepository.save(oldPresenca);
    }

    public void delete(Long id) {
        presencaRepository.deleteById(id);
    }
}
