package tn.cpg.internservice.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import tn.cpg.internservice.impl.ImageModelServiceImpl;
import tn.cpg.internservice.model.ImageModel;

@RestController
@RequestMapping("api/image")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ImageModelController {
	
	private final ImageModelServiceImpl imageModelServiceImpl ; 
	

	@PostMapping("")
    public ResponseEntity<ImageModel> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") String userId) {
        ImageModel uploadedImage = imageModelServiceImpl.processSingleFile(file, userId);
        
        if (uploadedImage != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(uploadedImage);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	
	  @PutMapping("/{id}")
	    public ResponseEntity<ImageModel> updateImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
	        ImageModel updatedImageModel = imageModelServiceImpl.updateImage(id, file);
	        return ResponseEntity.ok(updatedImageModel);
	    }
      
    
    @GetMapping("/user/{userId}")
    public ImageModel getImagesByUserId(@PathVariable String userId) {
        return imageModelServiceImpl.getImagesByUserId(userId);  
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteImageByUserId(@PathVariable Integer id) {
    	imageModelServiceImpl.deleteImageById(id);
    }  
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ImageModel>> getImageById(@PathVariable Integer id) {
    	Optional<ImageModel> response = imageModelServiceImpl.getImageById(id);
    	return new ResponseEntity<>(response, HttpStatus.OK); 
    }
 
}
