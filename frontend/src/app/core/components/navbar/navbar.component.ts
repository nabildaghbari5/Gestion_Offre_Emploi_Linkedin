import {Component, OnInit} from '@angular/core';
import {SideBarService, SubMenuItem} from "../../services/sideBar.service";


@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {


    menu: SubMenuItem[] | null = null;
    selectedIndex: number | null = null;
    sBselectedIndex: number | null = null;
    subMenu: SubMenuItem[] | null = null;

    constructor(private sideBarService: SideBarService) {

    }

    ngOnInit() {
        // get menu
        this.sideBarService.activeSubMenu$.subscribe((data: any) => {
            this.menu = data.menu
            this.subMenu = null;
            // check if there is an active sub menu and display it after user refresh
            if (data.refresh) {
                const menuString = sessionStorage.getItem("expandedSubMenu");
                if (menuString) {
                    this.subMenu = JSON.parse(menuString);
                }
                // check if there is a selected menu item
                const selectedItemIndex = sessionStorage.getItem("selectedItemIndex");
                if (selectedItemIndex) {
                    this.selectedIndex = Number(selectedItemIndex);
                }
                //
                const selectedSubItemIndex = sessionStorage.getItem("selectedSubItemIndex");
                if (selectedSubItemIndex) {
                    this.sBselectedIndex = Number(selectedSubItemIndex);
                }
            }
        })
    }

    selectItem(subMenu: any, index: number) {
        this.subMenu = subMenu;
        this.selectedIndex = index;
        sessionStorage.setItem("expandedSubMenu", JSON.stringify(subMenu));
        sessionStorage.setItem("selectedItemIndex", String(this.selectedIndex));
    }

    selectSubMenuItem(item: any, index: number) {
        this.sBselectedIndex = index
        sessionStorage.setItem("selectedSubItemIndex", String(this.sBselectedIndex));

    }
}
