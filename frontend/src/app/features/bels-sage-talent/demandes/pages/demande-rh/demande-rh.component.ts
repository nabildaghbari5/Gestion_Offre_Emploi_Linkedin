import { Component, OnInit, TemplateRef } from '@angular/core';
import { Demande } from '../../models/demande';
import { DemandeService } from '../../service/demande.service';
import { ImageProcessingService } from '../../service/image-processing.service';
import { map } from 'rxjs';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EntretienService } from '../../../entretiens/service/entretien.service';
import { TestEvaluationService } from '../../service/test-evaluation.service';

@Component({
  selector: 'app-demande-rh',
  templateUrl: './demande-rh.component.html',
  styleUrls: ['./demande-rh.component.scss']
})
export class DemandeRhComponent implements OnInit {
  listDemande: any[]=[];
  filteredListDemande: any[] = [];
  selectedDemandeId!: number;
  demandeSelected: any;  
  detailCandidature:boolean=false;
   searchNom: string = '';
   searchPrenom: string = '';
   selectedStatus: string = '';
   interviewLocation: string = '';
   interviewDate!:Date;

   showEvaluation = false;
   showButton=false;
  constructor(
    private router:Router,
    private demandeService:DemandeService,
    private imageProcessingService:ImageProcessingService,
    private modalService: NgbModal ,
    private entretienService:EntretienService, 
    private testEvoluation:TestEvaluationService
  ) { }

  ngOnInit(): void {
    this.findAllDemande();
  }




  openLaunchInterviewModal(content: TemplateRef<any>, demandeId: number) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
    this.selectedDemandeId=demandeId; 
  }

  submitEntretien(modal: any) {
    console.log('Lieu de l\'entretien:', this.interviewLocation);
        const entretienData = {
      request: { id: this.selectedDemandeId }, 
      lieu: this.interviewLocation, 
      date: this.interviewDate
     };
     console.log(entretienData)
      this.entretienService.create(entretienData).subscribe({
      next: (response) => {
        this.router.navigate(["/features/talent/entretiens/list_entretien"]);
      },
      error: (error) => {
        console.error('Erreur lors de la création de l\'entretien:', error);
      }
    });
    modal.dismiss(); 
  }
  filterDemande() {
    // Réinitialisation des demandes filtrées si aucune entrée
    if (!this.searchNom && !this.searchPrenom && !this.selectedStatus) {
      this.filteredListDemande = [...this.listDemande];
    } else {
      this.filteredListDemande = this.listDemande.filter(demande => {
        // Vérification du nom
        const matchesNom = this.searchNom 
          ? demande.nom?.toLowerCase().includes(this.searchNom.toLowerCase()) 
          : true;
  
        // Vérification du prénom
        const matchesPrenom = this.searchPrenom 
          ? demande.prenom?.toLowerCase().includes(this.searchPrenom.toLowerCase()) 
          : true;
  
        // Vérification du statut
        const matchesStatus = this.selectedStatus 
          ? demande.status?.toLowerCase() === this.selectedStatus.toLowerCase() 
          : true;
  
        return matchesNom && matchesPrenom && matchesStatus;
      });
    }
  
     this.searchNom = '';
     this.searchPrenom = '';
     this.selectedStatus = '';
  }
  findAllDemande(){
    this.demandeService.findAll()
    .pipe(
      map((result: Array<Demande>) => {
        result = result.map(demande => this.imageProcessingService.createImageDemande(demande));
        console.log(result);
        this.filteredListDemande=[...result];
        return result;
      })
     )
      .subscribe(
      (data) => {
          this.listDemande=data;
          console.log(data) ;
       }
     )
   }
  selectedDemande(demandeId:number){
    this.detailCandidature=true;
    this.selectedDemandeId =demandeId ; 
   this.demandeService.findById(demandeId).subscribe(
    (data) => {
      this.demandeSelected=data ;
      console.log(this.demandeSelected) ;   
    }
  )   
  }  

  updateStatusDemande(deamndeId:number , newStatus: string){
     this.demandeService.updateStatusDemande(deamndeId ,newStatus ).subscribe(
       (data) => {
         console.log('Statut du demande mis à jour', data);
         this.findAllDemande();
         this.detailCandidature=false;
         this.router.navigate(["/features/talent/demandes/candidatures"]);
       }, 
       (error) => {
         console.error('Erreur lors de la mise à jour du statut du deamnde', error);
       }
     )  
     
   }

   retour(){
    this.detailCandidature=false;
   }

}
