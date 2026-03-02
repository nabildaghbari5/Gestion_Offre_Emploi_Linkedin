package tn.cpg.internservice.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;  
import lombok.RequiredArgsConstructor;
import tn.cpg.internservice.dto.AnnouncementDto;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.impl.AnnouncementServiceImpl;
import tn.cpg.internservice.service.AnnouncementService;

@RestController
@RequestMapping("api/service")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AnnouncementController {
	
	private final AnnouncementService service ;
	private final AnnouncementServiceImpl entMapperImpl ; 
	
	
	@PostMapping("")
	public ResponseEntity<AnnouncementDto> create(@RequestBody @Valid AnnouncementDto dto) {
		AnnouncementDto response = service.create(dto);
		return new  ResponseEntity<>(response , HttpStatus.CREATED);
	}  
	
	
	@PutMapping("/{id}")
	public ResponseEntity<AnnouncementDto> update(@PathVariable Integer id , @RequestBody AnnouncementDto dto ) throws NotFoundException {
		AnnouncementDto response = service.update(id, dto);
		return new ResponseEntity<>(response , HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<AnnouncementDto>> findAll(){
		List<AnnouncementDto> response = service.findAll();
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnnouncementDto> findById(@PathVariable Integer id ) throws NotFoundException {
		AnnouncementDto response = service.findById(id);
		return new ResponseEntity<>(response , HttpStatus.OK);		
	}
	
	
	@GetMapping("/page")
	public ResponseEntity<Page<AnnouncementDto>> findPage(@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "0") int pageNumber) {
		Page<AnnouncementDto> response = entMapperImpl.findPage(pageSize, pageNumber);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws NotFoundException {
		service.delete(id);
		return new ResponseEntity<>(true, HttpStatus.OK); 
	}

}
