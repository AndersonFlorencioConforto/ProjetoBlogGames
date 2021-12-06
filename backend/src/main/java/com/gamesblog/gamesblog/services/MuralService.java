package com.gamesblog.gamesblog.services;

import com.gamesblog.gamesblog.dtos.GameDTO;
import com.gamesblog.gamesblog.dtos.MuralDTO;
import com.gamesblog.gamesblog.dtos.MuralDtoUser;
import com.gamesblog.gamesblog.models.Game;
import com.gamesblog.gamesblog.models.Mural;
import com.gamesblog.gamesblog.models.User;
import com.gamesblog.gamesblog.repositories.GameRepository;
import com.gamesblog.gamesblog.repositories.MuralRepository;
import com.gamesblog.gamesblog.repositories.UserRepository;
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
public class MuralService {

    @Autowired
    private MuralRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<MuralDTO> findAll(Pageable pageable) {
        Page<Mural> page = repository.findAll(pageable);
        return page.map(x -> new MuralDTO(x, x.getGames()));
    }

    @Transactional(readOnly = true)
    public MuralDTO findByUserId(Long userId)  {
        try {
            Optional<User> user = userRepository.findById(userId);
            if(user.isEmpty()) {
                throw new ResourceNotFoundException("Usuário não encontrado");
            }
            Mural mural = repository.find(user);
            return new MuralDTO(mural,mural.getGames());
        } catch (NullPointerException e ){
            throw new ResourceNotFoundException("Usuário ainda não tem um mural vinculado");
        }
    }


    @Transactional
    public MuralDTO insert(MuralDtoUser dto) {
        Mural entity = new Mural();
        User user = userRepository.getOne(dto.getUser().getId());
        entity.setUser(user);
        entity.setUser(dto.getUser());
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new MuralDTO(entity,entity.getGames());
    }

    @Transactional
    public MuralDTO update(Long id, MuralDTO dto) {
        try {
            Mural entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new MuralDTO(entity);
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

    //Método para transformar entity em dto.
    private void copyDtoToEntity(MuralDTO dto, Mural entity) {
        entity.setName(dto.getName());
        entity.getGames().clear();
        for (GameDTO catDto : dto.getGames()) {
            Game game = gameRepository.getOne(catDto.getId());
            entity.getGames().add(game);
        }

    }
}
