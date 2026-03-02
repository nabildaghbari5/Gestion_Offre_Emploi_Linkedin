package tn.cpg.internservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import tn.cpg.internservice.dto.RequestDto;
import tn.cpg.internservice.dto.StatusDTO;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.impl.ImageModelServiceImpl;
import tn.cpg.internservice.model.ImageModel;
import tn.cpg.internservice.service.RequestService;

@RestController
@RequestMapping("api/demande")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {
 
			private final RequestService requestService ; 
			private final ImageModelServiceImpl imageService ;
			
	 @PostMapping("")
	 public ResponseEntity<RequestDto> create(
			 @RequestPart("demande") RequestDto requestDto ,
			 @RequestParam("announcementId") Integer announcementId ,
			 @RequestPart("imageFile") MultipartFile[] file
			 )throws IOException{
		 Set<ImageModel> images = imageService.uploadImage(file);
		 requestDto.setDocument(images);
		 RequestDto response = requestService.creats(requestDto, announcementId);
		 return new ResponseEntity<RequestDto>(response , HttpStatus.CREATED);
	 }  
	 

     @GetMapping("/{demandeid}")
	 public ResponseEntity<RequestDto> findById(@PathVariable Integer demandeid)  throws NotFoundException {
		RequestDto response = requestService.findById(demandeid);
		return new ResponseEntity<>(response , HttpStatus.OK);
	 }

	 @GetMapping("/getByCandidatId/{candidatId}")
	 public ResponseEntity<List<RequestDto>> findByCandidat(@PathVariable String candidatId ) {
		 List<RequestDto> response = this.requestService.findByCandidatId(candidatId) ;   
		   return new ResponseEntity<List<RequestDto>>(response , HttpStatus.OK) ;
	 }
	 
	 @GetMapping("")
	 public ResponseEntity<List<RequestDto>> findAll(){
		List<RequestDto> response = requestService.findAll(); 
		return new ResponseEntity<List<RequestDto>>(response , HttpStatus.OK);
	 }
	 
	 @PutMapping("/updateStatusDemande/{demandeId}")
	 public ResponseEntity<RequestDto> updateStatus(@PathVariable Integer demandeId , @RequestBody StatusDTO statusDTO ){
		 RequestDto response = requestService.updateStatus(demandeId , statusDTO.getStatus());
		 return new ResponseEntity<RequestDto>(response , HttpStatus.OK);
	 }
	 
	 @GetMapping("/findAllByStatus")
	 public ResponseEntity<List<RequestDto>> findAllByStatus(){
		 List<RequestDto> responseDemandeDtos = requestService.findByStatus();
		 return new ResponseEntity<List<RequestDto>>(responseDemandeDtos , HttpStatus.OK);
	 }
	 

	  
}
