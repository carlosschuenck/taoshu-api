package br.com.taoshu.service.impl;

import br.com.taoshu.entity.Presenca;
import br.com.taoshu.repository.PresencaRepository;
import br.com.taoshu.service.IPresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@Service
@Transactional(readOnly = false)
public class PresencaService implements IPresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Presenca> findAll() {
        return presencaRepository.findAll();
    }

    @Override
    public Presenca persist(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    @Override
    public Presenca update(Presenca presenca) {
        Presenca oldPresenca = presencaRepository.getOne(presenca.getId());
        oldPresenca.setData(presenca.getData());
        oldPresenca.setPresenca(presenca.getPresenca());
        return presencaRepository.save(oldPresenca);
    }

    @Override
    public void delete(Long id) {
        presencaRepository.deleteById(id);
    }
}
