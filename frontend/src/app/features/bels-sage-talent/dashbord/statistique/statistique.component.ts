import { Component, OnInit } from '@angular/core';
import { DashboardStats } from '../model/dashboard';
import { DashboardService } from '../service/dashboard.service';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.scss']
})
export class StatistiqueComponent implements OnInit {
  dashboardStats: DashboardStats | null = null;
  loading = true;
  error: string | null = null;

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
      this.loadDashboardData();
  }

  loadDashboardData(): void {
      this.loading = true;
      this.dashboardService.getDashboardStats().pipe(
          finalize(() => this.loading = false)
      ).subscribe({
          next: (data) => {
              this.dashboardStats = data;
              console.log(data)
              this.error = null;
          },
          error: (error) => {
              console.error('Erreur lors du chargement des données:', error);
              this.error = 'Erreur lors du chargement des données du tableau de bord';
          }
      });
  }

  getStatusClass(status: string): string {
      status = status.toLowerCase();
      switch (status) {
          case 'en attente':
              return 'status-en-attente';
          case 'accepte':
          case 'accepté':
              return 'status-accepte';
          case 'refuse':
          case 'refusé':
              return 'status-refuse';
          default:
              return 'status-en-attente';
      }
  }

  formatDate(date: string): string {
      return new Date(date).toLocaleDateString('fr-FR');
  }

  formatDateTime(date: string): string {
      return new Date(date).toLocaleString('fr-FR');
  }
}