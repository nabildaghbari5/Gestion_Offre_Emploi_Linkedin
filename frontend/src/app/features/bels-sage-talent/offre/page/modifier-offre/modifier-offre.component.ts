import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServEntrepriseService } from '../../service/serv-entreprise.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-modifier-offre',
  templateUrl: './modifier-offre.component.html',
  styleUrls: ['./modifier-offre.component.scss']
})
export class ModifierOffreComponent  implements OnInit {
  offreId!: number;
  serviceEntrepriseForm!:FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router:Router,
    private offreService:ServEntrepriseService,
    private formBuilder:FormBuilder
  ) {}

  ngOnInit() {
    // Récupérer l'ID de l'offre depuis les paramètres de l'URL
    this.route.params.subscribe(params => {
      this.offreId = +params['id']; // Le '+' convertit la chaîne en nombre
      this.chargerOffre(this.offreId); // Appel à une méthode pour charger les données de l'offre
    });

    this.serviceEntrepriseForm=this.formBuilder.group({
      id: ['', Validators.required],
      title: ['', Validators.required],
      description: ['', Validators.required],
      technologies: ['', Validators.required],
      endDate: ['', [Validators.required]],
      publicationDate: ['',  [Validators.required]],
    })
  }

  chargerOffre(id: number) {
     this.offreService.findById(id).subscribe({
      next:(data)=> {
        this.serviceEntrepriseForm.patchValue(data);
      }
     })
  }

  modiferOffre() {
    const formData: any = this.serviceEntrepriseForm.value;  
      // Mode ajout
      this.offreService.save(null, formData).subscribe({
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