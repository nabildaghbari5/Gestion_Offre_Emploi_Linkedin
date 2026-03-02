import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CompanyService } from '../../services/company.service';
import { TreeNode } from 'primeng/api';

@Component({
  selector: 'app-view-chart-organization',
  templateUrl: './view-chart-organization.component.html',
  styleUrls: ['./view-chart-organization.component.scss']
})
export class ViewChartOrganizationComponent implements OnInit {

  organizationData: TreeNode[] | undefined;

  constructor(
    public dialog: MatDialog,
    private companyService: CompanyService
  ) {}

  ngOnInit(): void {
    const companyId = 1;  // You can replace this with dynamic data
    this.companyService.visualizeGroupOrganization(companyId).subscribe((data: any) => {
      this.processHierarchyData(data);
    });
  }

  processHierarchyData(data: any): void {
    if (data.group) {
      this.organizationData = [
        {
          label: data.group.namecompany,
          type: 'company',
          styleClass: 'p-company',
          expanded: true,
          data: {
            name: data.group.topExecutive ? `${data.group.topExecutive.firstnameemployee} ${data.group.topExecutive.lastnameemployee}` : 'No topExecutive'
          },
          children: data.companies.map((company: any) => ({
            label: company.namecompany,
            type: 'company',
            styleClass: 'p-company',
            expanded: true,
            data: {
              name: company.topExecutive ? `${company.topExecutive.firstnameemployee} ${company.topExecutive.lastnameemployee}` : 'No topExecutive'
            },
            children: [
              ...data.departments
                .filter((dept: any) => dept.associatedcompany.idcompany === company.idcompany)
                .map((department: any) => ({
                  label: department.namedepartment,
                  type: 'department',
                  styleClass: 'p-department',
                  expanded: true,
                  data: {
                    name: department.managerdepartement ? `${department.managerdepartement.firstnameemployee} ${department.managerdepartement.lastnameemployee}` : 'No Manager'
                  }
                }))
            ]
          }))
        }
      ];
    } else if (data.company) {
      this.organizationData = [
        {
          label: data.company.namecompany,
          type: 'company',
          styleClass: 'p-company',
          expanded: true,
          data: {
            name: data.company.topExecutive ? `${data.company.topExecutive.firstnameemployee} ${data.company.topExecutive.lastnameemployee}` : 'No topExecutive'
          },
          children: [
            ...data.departments.map((department: any) => ({
              label: department.namedepartment,
              type: 'department',
              styleClass: 'p-department',
              expanded: true,
              data: {
                name: department.managerdepartement ? `${department.managerdepartement.firstnameemployee} ${department.managerdepartement.lastnameemployee}` : 'No Manager'
              }
            })),
            ...data.associatedCompanies.map((company: any) => ({
              label: company.namecompany,
              type: 'company',
              styleClass: 'p-company',
              expanded: true,
              data: {
                name: company.topExecutive ? `${company.topExecutive.firstnameemployee} ${company.topExecutive.lastnameemployee}` : 'No topExecutive'
              }
            }))
          ]
        }
      ];
    }
  }
}
