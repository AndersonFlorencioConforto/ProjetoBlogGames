package com.gamesblog.gamesblog.controllers;

import com.gamesblog.gamesblog.dtos.ComentsDTO;
import com.gamesblog.gamesblog.dtos.ComentsDTONotGames;
import com.gamesblog.gamesblog.services.ComentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/coments")
public class ComentsController {

    @Autowired
    private ComentsService service;

    @GetMapping
    public ResponseEntity<Page<ComentsDTO>> findAll(Pageable pageable) {
        Page<ComentsDTO> page = service.findAllPage(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComentsDTO> findById(@PathVariable Long id){
        ComentsDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ComentsDTO> insert(@Valid @RequestBody ComentsDTONotGames dto){
        ComentsDTO entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComentsDTO> update(@PathVariable Long id,@Valid @RequestBody ComentsDTONotGames dto){
        ComentsDTO entity = service.update(id,dto);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
