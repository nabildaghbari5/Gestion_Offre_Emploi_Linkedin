import {
    AfterViewInit,
    Component,
    OnDestroy,
} from '@angular/core';
import { Router } from '@angular/router'; // Importer Router
import { SideBarService } from "../../services/sideBar.service";

interface MenuItem {
    name: string;
    icon: string;
    route: string;
}

const MENU_ITEMS_RH: MenuItem[] = [
    { name: 'Tableau de bord', icon: 'fa-solid fa-chart-line', route: '/features/talent/dashboard/statistique' },
    { name: 'Offres', icon: 'fa-solid fa-briefcase', route: '/features/talent/offre/list-offre' },
    { name: 'Candidatures', icon: 'fa-solid fa-file-alt', route: '/features/talent/demandes/candidatures' },
    { name: 'Entretiens', icon: 'fa-solid fa-user-tie', route: '/features/talent/entretiens/list_entretien' },
    
    // Ajouter d'autres éléments spécifiques pour RH
];

const MENU_ITEMS_CANDIDAT: MenuItem[] = [
    { name: 'Announcement', icon: 'fa-solid fa-bullhorn', route: '/features/talent/offre/Announcement_Actuel' },
    { name: 'Mes candidatures', icon: 'fa-solid fa-briefcase', route: '/features/talent/demandes/mycandidatures' },
];

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements AfterViewInit, OnDestroy {
    mediaQueryListener!: () => void;
    mediaQuery = window.matchMedia("(max-width: 767px)");

    menuItems: MenuItem[] = [];
    selectedIndex: number | null = null;

    constructor(public sideBarService: SideBarService, private router: Router) {} // Injecter Router

    ngAfterViewInit() {
        this.mediaQueryListener = () => {
            this.sideBarService.showSidebar = !this.mediaQuery.matches;
            this.sideBarService.isSmallScreen = this.mediaQuery.matches;
        };
        this.mediaQueryListener();
        this.mediaQuery.addEventListener("change", this.mediaQueryListener);

        // Récupérer le rôle de l'utilisateur depuis localStorage
        this.getUserProfile();
    }
 

    getUserProfile(){
        const userProfileString = localStorage.getItem("userProfile");
          if (userProfileString) {
            const userProfile = JSON.parse(userProfileString);
            const userRole = userProfile.userRole;
            this.menuItems = this.getMenuItemsByRole(userRole);
          } else {
            const userRole = ''; // ou toute autre valeur par défaut que vous préférez
          }
      }

    getMenuItemsByRole(role: string | null): MenuItem[] {
        if (role === 'RH') {
            return MENU_ITEMS_RH;
        } else if (role === 'Candidat') {
            return MENU_ITEMS_CANDIDAT;
        }
        // Retourner un menu vide ou un menu par défaut si le rôle n'est pas reconnu
        return [];
    }

    selectMenu(index: number) {
        this.selectedIndex = index;
        const selectedItem = this.menuItems[index];
        if (selectedItem && selectedItem.route) {
            this.router.navigate([selectedItem.route]); // Naviguer vers la route spécifiée
        }
        sessionStorage.setItem("selectedMenuIndex", String(index));
    }

    ngOnDestroy() {
        this.mediaQuery.removeEventListener("change", this.mediaQueryListener);
    }
}
