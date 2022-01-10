package com.gamesblog.gamesblog.services;

import com.gamesblog.gamesblog.dtos.ComentsDTO;
import com.gamesblog.gamesblog.dtos.ComentsDTONotGames;
import com.gamesblog.gamesblog.models.Coment;
import com.gamesblog.gamesblog.models.Game;
import com.gamesblog.gamesblog.repositories.ComentsRepository;
import com.gamesblog.gamesblog.repositories.GameRepository;
import com.gamesblog.gamesblog.services.exceptions.DataBaseException;
import com.gamesblog.gamesblog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ComentsService {

    @Autowired
    private ComentsRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<ComentsDTO> findAllPage(Pageable pageable) {
        Page<Coment> page = repository.findAll(pageable);
        return page.map(Coments -> new ComentsDTO(Coments));
    }

    @Transactional(readOnly = true)
    public ComentsDTO findById(Long id) {
        Optional<Coment> obj = repository.findById(id);
        Coment entity = obj.orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));
        return new ComentsDTO(entity);
    }

    @Transactional
    public ComentsDTO insert(ComentsDTONotGames dto) {
        Coment entity = new Coment();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ComentsDTO(entity);
    }

    @Transactional
    public ComentsDTO update(Long id, ComentsDTONotGames dto) {
        try {
            Coment entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ComentsDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade");
        }
    }

    private void copyDtoToEntity(ComentsDTONotGames dto, Coment entity) {
        entity.setText(dto.getText());
        Game game = gameRepository.getOne(dto.getGame().getId());
        entity.setGame(game);
    }


}
