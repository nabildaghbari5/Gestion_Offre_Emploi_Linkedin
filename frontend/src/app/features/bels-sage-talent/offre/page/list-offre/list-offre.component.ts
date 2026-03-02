import { Component, OnInit } from '@angular/core';
import { ServEntrepriseService } from '../../service/serv-entreprise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-offre',
  templateUrl: './list-offre.component.html',
  styleUrls: ['./list-offre.component.scss']
})
export class ListOffreComponent implements OnInit {
  offers: any[] = [];
  filteredOffers: any[] = []; // Ajout de la liste pour les résultats filtrés
  searchTitle: string = '';
  searchStartDate: string = '';
  searchEndDate: string = '';

  constructor(
    private offreService: ServEntrepriseService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.findAllOffre();
  }

  // Récupérer toutes les offres et initialiser la liste filtrée
  findAllOffre() {
    this.offreService.findAll().subscribe({
      next: (data) => {
        this.offers = data;
        this.filteredOffers = [...this.offers]; // Copier toutes les offres dans filteredOffers
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des offres :', err);
      }
    });
  }

  // Appliquer le filtre
  applyFilter() {
    if (!this.searchTitle && !this.searchStartDate && !this.searchEndDate) {
      // Si aucun filtre n'est défini, réinitialiser la liste filtrée avec toutes les offres
      this.filteredOffers = [...this.offers];
    } else {
      // Appliquer les filtres
      this.filteredOffers = this.offers.filter(offer => {
        const matchesTitle = this.searchTitle ? offer.title.toLowerCase().includes(this.searchTitle.toLowerCase()) : true;
        
        // Convertir les dates en objets Date pour effectuer la comparaison
        const offerPublicationDate = new Date(offer.publicationDate);
        const offerEndDate = new Date(offer.endDate);
  
        const matchesStartDate = this.searchStartDate ? offerPublicationDate >= new Date(this.searchStartDate) : true;
        const matchesEndDate = this.searchEndDate ? offerEndDate <= new Date(this.searchEndDate) : true;
  
        return matchesTitle && matchesStartDate && matchesEndDate;
      });
    }

    this.searchTitle = '';
  this.searchStartDate = '';
  this.searchEndDate= '';
  }
  

  // Rediriger vers la page d'édition
  editOffer(id: number) {
    this.router.navigate(["/features/talent/offre/modifier", id]);
  }

  // Supprimer une offre
  deleteOffer(id: number) {
    this.offreService.delete(id).subscribe({
      next: () => {
        this.findAllOffre();
      },
      error: (err) => {
        console.error('Erreur lors de la suppression de l\'offre :', err);
      }
    });
  }
}
