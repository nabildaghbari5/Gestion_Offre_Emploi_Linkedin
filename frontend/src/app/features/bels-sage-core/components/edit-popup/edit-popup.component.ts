import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit-popup',
  templateUrl: './edit-popup.component.html',
  styleUrls: ['./edit-popup.component.scss']
})
export class EditPopupComponent implements OnInit{

  propertyTemp: any;
  possibleValues!: string;
  constructor(
      public dialogRef: MatDialogRef<EditPopupComponent>,
      @Inject(MAT_DIALOG_DATA) public property: any) {}

  ngOnInit() {
    this.propertyTemp =  Object.assign({}, this.property);
    if(this.propertyTemp.possiblevaleproperty !== null){
      this.possibleValues = this.propertyTemp.possiblevaleproperty.split(',');
    }
  }

  update() {
    this.dialogRef.close(this.propertyTemp);
  }
}
