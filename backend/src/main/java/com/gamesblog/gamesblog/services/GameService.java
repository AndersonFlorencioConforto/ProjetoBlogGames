package com.gamesblog.gamesblog.services;

import com.gamesblog.gamesblog.dtos.GameDTO;
import com.gamesblog.gamesblog.models.Game;
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
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public Page<GameDTO> findAllPage(Pageable pageable) {
        Page<Game> page = repository.findAll(pageable);
        return page.map(game -> new GameDTO(game));
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> obj = repository.findById(id);
        Game entity = obj.orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));
        return new GameDTO(entity);
    }

    @Transactional
    public GameDTO insert(GameDTO dto) {
        Game entity = new Game();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new GameDTO(entity);
    }

    @Transactional
    public GameDTO update(Long id, GameDTO dto) {
        try {
            Game entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new GameDTO(entity);
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

    private void copyDtoToEntity(GameDTO dto, Game entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setNote(dto.getNote());
        entity.setPhoto(dto.getPhoto());
    }


}
