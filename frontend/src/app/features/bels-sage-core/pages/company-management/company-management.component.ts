import {Component, OnInit} from '@angular/core';
import {CompanyService} from "../../services/company.service";
import {Router} from "@angular/router";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
    selector: 'app-company-management',
    templateUrl: './company-management.component.html',
    styleUrls: ['./company-management.component.scss']
})
export class CompanyManagementComponent implements OnInit {
    public dataSource: any[] = [];
    displayedColumns: string[] = ['COMPANY_MANAGEMENT.FISCAL_CODE', 'COMPANY_MANAGEMENT.NAME', 'COMPANY_MANAGEMENT.TYPE', "Address", 'ACTIONS'];
    title = 'COMPANY_MANAGEMENT.TITLE';
    public spinner = false;
    filterForm!: FormGroup;
    public typecompanies: string[] = ['Public company', 'Private company', 'Non profit organization'];

    constructor(private router: Router,
                public dialog: MatDialog,
                private formBuilder: FormBuilder,
                private companyService: CompanyService) {
        this.spinner = true;
        this.filterForm = this.formBuilder.group({
            fiscalcodecompany: null,
            namecompany: null,
            typecompany: null,
            associatedgroup: null
        });

    }

    ngOnInit(): void {
        this.getAll();
    }


    getAll(): void {
        this.spinner = true;
        this.companyService.getAllCompanies().subscribe((result: any[]) => {
            this.spinner = false;
            this.dataSource = result;
        });
    }

    deleteCompany(company: any) {
        const id = company.idcompany;

        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.companyService.deleteCompany(id).subscribe((res) => {
                    this.getAll();
                }, error => {
                    this.dialog.open(DialogComponent, {
                        width: '300px',
                        data: {title: "Error", text: "Error occurred while proceeding"}
                    });
                });
            }
        });
    }


    goToUpdateCompany(company: any) {
        this.router.navigate(['features/core/update-company', company.idcompany])
    }

    filterCompanies() {
        const company = this.filterForm.value;
        if (company.typecompany != null) {
            this.convertTypeCompany(company);
        }
        this.companyService.getFilteredCompanies(company).subscribe(res => {
            this.dataSource = res;
        }, error => {
            this.dialog.open(DialogComponent, {
                width: '300px',
                data: {title: "Error", text: "Error occurred while proceeding", error: true}
            });
        })
    }

    getTypeCompany(typecompany: any) {
        if (typecompany == "public_company") {
            return "Public company";
        } else if (typecompany == "private_company") {
            return "Private company";
        } else {
            return "nonprofit_company";
        }
    }

    convertTypeCompany(company: any) {
        if (company.typecompany == "Public company") {
            company.typecompany = "public_company";
        } else if (company.typecompany == "Private company") {
            company.typecompany = "private_company";
        } else {
            company.typecompany = "nonprofit_company";
        }
    }
}
