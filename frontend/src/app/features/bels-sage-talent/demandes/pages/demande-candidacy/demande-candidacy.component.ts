import { Component, OnInit } from '@angular/core';
import { DemandeService } from '../../service/demande.service';

@Component({
  selector: 'app-demande-candidacy',
  templateUrl: './demande-candidacy.component.html',
  styleUrls: ['./demande-candidacy.component.scss']
})
export class DemandeCandidacyComponent  implements OnInit {
  candidateId: any;
  listDemande!: any;

  constructor(
    private demandeService:DemandeService,
  ) { }

  ngOnInit(): void {
    this.getUserProfile();
    this.findDemandeByCandidatId();
  }

  getUserProfile(){
    const userProfileString = localStorage.getItem("userProfile");
      if (userProfileString) {
        const userProfile = JSON.parse(userProfileString);
        this.candidateId = userProfile.id;
      } else {
        this.candidateId = ''; // ou toute autre valeur par défaut que vous préférez
      }
  }

  findDemandeByCandidatId(){
    if(this.candidateId){
      this.demandeService.findAllByCandidatId(this.candidateId).subscribe(
        (data) => {
          this.listDemande =data ;
          console.log(data);
        }
      )
    }else{
      console.log('candidat not found');
    }
  }


}
