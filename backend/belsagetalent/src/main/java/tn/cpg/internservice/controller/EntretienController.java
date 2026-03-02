package tn.cpg.internservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cpg.internservice.dto.EntretienDto;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.service.EntretienService;

import java.util.List;

@RestController
@RequestMapping("api/entretien")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EntretienController  {

     private final EntretienService service ;

    @PostMapping("")
    public ResponseEntity<EntretienDto> create(@RequestBody @Valid EntretienDto dto) {
        EntretienDto response = service.create(dto);
        return new  ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntretienDto> update(@PathVariable Integer id , @RequestBody EntretienDto dto ) throws NotFoundException {
        EntretienDto response = service.update(id, dto);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<EntretienDto>> findAll(){
        List<EntretienDto> response = service.findAll();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EntretienDto> findById(@PathVariable Integer id ) throws NotFoundException {
        EntretienDto response = service.findById(id);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
