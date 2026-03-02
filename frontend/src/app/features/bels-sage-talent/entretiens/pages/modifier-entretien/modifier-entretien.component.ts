import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EntretienService } from '../../service/entretien.service';

@Component({
  selector: 'app-modifier-entretien',
  templateUrl: './modifier-entretien.component.html',
  styleUrls: ['./modifier-entretien.component.scss']
})
export class ModifierEntretienComponent implements OnInit {

   entretienId!:number;
   entretienForm!:FormGroup
  constructor(
    private router:Router,
    private routerActiveted:ActivatedRoute, 
    private formBuilder:FormBuilder,
    private entretienService:EntretienService
  ){}

  ngOnInit(): void {
    this.routerActiveted.params.subscribe(params =>{
      this.entretienId = +params['id'];
      this.chargeEntretien(this.entretienId)
    } )
    this.entretienForm = this.formBuilder.group({
      id: ['', Validators.required],
      date: ['', Validators.required],
      status: ['', Validators.required], 
      lieu: ['', Validators.required],
    })
  }


  chargeEntretien(id:number){
    this.entretienService.findById(id).subscribe({
      next:(data)=>{
        this.entretienForm.patchValue(data);
      }
    })
  }

  modifierEntretien(){
     const formData= this.entretienForm.value ; 
     this.entretienService.update(this.entretienId , formData).subscribe({
      next:(data) => {
        this.router.navigate(["/features/talent/entretiens/list_entretien"])
      }
     })
  }

  annuler(){ 
    this.router.navigate(["/features/talent/entretiens/list_entretien"])
  }
}
