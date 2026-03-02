import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServEntrepriseService } from '../../service/serv-entreprise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter-offre',
  templateUrl: './ajouter-offre.component.html',
  styleUrls: ['./ajouter-offre.component.scss']
})
export class AjouterOffreComponent implements OnInit {

  serviceEntrepriseForm!:FormGroup;

  constructor(
    private serviceService: ServEntrepriseService,
    private formBuilder:FormBuilder,
    private router :Router
  ) { }

  
  ngOnInit(): void {
    this.serviceEntrepriseForm=this.formBuilder.group({
      offerNumber: ['', Validators.required],
      title: ['', Validators.required],
      description: ['', Validators.required],
      technologies: ['', Validators.required],
      endDate: ['', [Validators.required]],
      publicationDate: ['',  [Validators.required]],
      publishToLinkedIn: [false] // Nouvelle option
    })

  }
 

  saveOffre() {
    const formData: any = this.serviceEntrepriseForm.value;  
      // Mode ajout
      this.serviceService.save(null, formData).subscribe({
        next: () => {
          this.router.navigate(["/features/talent/offre/list-offre"]);
          this.serviceEntrepriseForm.reset();   
          },
        error: error => {
          console.log("Erreur lors de la création de l'abonnement", error);
        }
      });
    
  }
  
  Anuller(){
    this.router.navigate(["/features/talent/offre/list-offre"]);
    this.serviceEntrepriseForm.reset();   
  }


 
}

