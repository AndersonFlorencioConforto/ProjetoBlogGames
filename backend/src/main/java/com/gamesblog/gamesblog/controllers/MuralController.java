package com.gamesblog.gamesblog.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamesblog.gamesblog.dtos.MuralDTO;
import com.gamesblog.gamesblog.dtos.MuralDtoUser;
import com.gamesblog.gamesblog.services.MuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mural")
public class MuralController {

    @Autowired
    private MuralService service;

    @GetMapping
    public ResponseEntity<Page<MuralDTO>> findAll(Pageable pageable){
        Page<MuralDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/user")
    public ResponseEntity<MuralDTO> findMuralUserId(@RequestParam(value = "userId", defaultValue = "0") Long userId)  {
        MuralDTO mural = service.findByUserId(userId);
        return ResponseEntity.ok().body(mural);
    }

    @PostMapping
    public ResponseEntity<MuralDTO> save(@Valid @RequestBody MuralDtoUser dto2) throws Exception {
        MuralDTO dto = service.insert(dto2);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MuralDTO> update(@PathVariable Long id,@Valid @RequestBody MuralDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}