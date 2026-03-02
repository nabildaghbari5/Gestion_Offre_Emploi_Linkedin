import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ServEntrepriseService } from '../../service/serv-entreprise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-announcement-candidat',
  templateUrl: './announcement-candidat.component.html',
  styleUrls: ['./announcement-candidat.component.scss']
})
export class AnnouncementCandidatComponent implements OnInit {
  listAnnouncement:any[]=[];
  announcementSelected:any 
  candidature: any;
  userConnected: any;
  userConnectedById:any

  constructor(
    private announcementService:ServEntrepriseService,
    private  router:Router
  ) { }

  ngOnInit(): void {
    this.findAll();
   
  }   
  findAll(){
    this.announcementService.findAll().subscribe(
      (data)=>{
        this.listAnnouncement=data   
      } 
    )
  }  
   
  postuler(id:number){  
    this.router.navigate(["/features/talent/demandes/envoyer_demande" , id])
  }


 
}
