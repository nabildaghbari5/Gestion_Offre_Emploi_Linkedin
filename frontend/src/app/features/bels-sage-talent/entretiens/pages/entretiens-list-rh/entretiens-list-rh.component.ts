import { Component, OnInit } from '@angular/core';
import { EntretienService } from '../../service/entretien.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entretiens-list-rh',
  templateUrl: './entretiens-list-rh.component.html',
  styleUrls: ['./entretiens-list-rh.component.scss']
})
export class EntretiensListRhComponent  implements OnInit {
  entretienList: any[]=[];
  filteredListEntretien: any[] = [];
  selectedStatus: string = '';
  searchLieu:string='';
  searchDate:string='';
   constructor(
    private entretienService:EntretienService,
    private router:Router
     ) {}

  ngOnInit(): void {
    this.findAllEntretien();

    }

    findAllEntretien(){
      this.entretienService.findAll().subscribe({
        next:(data)=>{
          console.log(data)
          this.entretienList=data; 
          this.filteredListEntretien=[...data];
        }
      })
    }

    filterDemande() {
      // Réinitialisation des demandes filtrées si aucune entrée
      if (!this.searchDate && !this.searchLieu && !this.selectedStatus) {
        this.filteredListEntretien = [...this.entretienList];
      } else {
        this.filteredListEntretien = this.entretienList.filter(entretien => {
          // Vérification du lieu
          const matchesLieu = this.searchLieu
            ? entretien.lieu?.toLowerCase().includes(this.searchLieu.toLowerCase())
            : true;
          
          // Vérification du statut
          const matchesStatus = this.selectedStatus 
            ? entretien.status?.toLowerCase() === this.selectedStatus.toLowerCase()
            : true;
          
          // Comparaison de la date en ignorant les heures pour comparer uniquement la date
          const dateEntretien = new Date(entretien.date);
          const searchDate = new Date(this.searchDate);
          const matchesDateEntretien = this.searchDate 
            ? dateEntretien.toDateString() === searchDate.toDateString()  // Compare uniquement la date (jour, mois, année)
            : true;
    
          return matchesLieu && matchesStatus && matchesDateEntretien;
        });
      }
    
      // Réinitialisation des valeurs de recherche
      this.searchLieu = '';
      this.searchDate = '';
      this.selectedStatus = '';
    }
    

    editEntretien(id:number){
     this.router.navigate(["/features/talent/entretiens/modifier_entretien" , id])
    }

    deleteEntretien(id:number){
     this.entretienService.delete(id).subscribe({
      next:(data)=>{
          this.findAllEntretien();
      }
     })  
    }
}
