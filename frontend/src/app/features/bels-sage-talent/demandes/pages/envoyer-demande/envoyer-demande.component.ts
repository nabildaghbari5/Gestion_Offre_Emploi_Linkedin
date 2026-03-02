import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Demande, demandeFormData } from '../../models/demande';
import { DemandeService } from '../../service/demande.service';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from 'src/app/features/bels-sage-core/services/user.service';
import { FileHandle } from '../../models/file-handle.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-envoyer-demande',
  templateUrl: './envoyer-demande.component.html',
  styleUrls: ['./envoyer-demande.component.scss']
})
export class EnvoyerDemandeComponent implements OnInit  {

  demandeForm!:FormGroup ;
  candidature!: Demande;
  offreId!:number;
  candidateId!:any
  requestId!:any
  showEvaluation!:boolean
  userProfil!:any|undefined
  showButton=true;
  constructor(
    private formBuilder :FormBuilder,
    private demandeService:DemandeService,
    private sanitizer: DomSanitizer,
    private activateRouter:ActivatedRoute,
    private router:Router


  ) { }


  ngOnInit(): void {
    this.activateRouter.params.subscribe(params => {
     this.offreId = +params["id"]; 
    })
     this.demandeForm = this.formBuilder.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      adresse: ['', Validators.required],
      cin: ['', Validators.required],
      candidateId:['', Validators.required],
      status:['En attente', Validators.required],  
      document: this.formBuilder.array([]),
    })

    this.getUserProfile();
   
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


  onFileSelected(event:any){
    if(event.target.files){
     const file = event.target.files[0];
     const fileHandle :FileHandle={
       file:file ,
       url: this.sanitizer.bypassSecurityTrustUrl(
         window.URL.createObjectURL(file)
       )
     }
     const documentControl = this.demandeForm.get('document');
     if (documentControl instanceof FormArray) {
      documentControl.push(new FormControl(fileHandle));
     }
   }
 }


 
 prepareFormData(demandeFormData: demandeFormData):FormData{
  const formData = new FormData();
  formData.append(
    'demande', 
    new Blob([JSON.stringify(demandeFormData)] , {type:'application/json'})
  );
  if (!demandeFormData.document) {     
  console.error('document est null ou undefined');
  return formData;
}
for (var i = 0; i < demandeFormData.document.length; i++) {
  if (demandeFormData.document[i] && demandeFormData.document[i].file) {
    formData.append(
      'imageFile',
      demandeFormData.document[i].file,
      demandeFormData.document[i].file.name
    );
  } else {
    console.error('Le fichier est null pour document à l\'index', i);
  }
}
console.log('Après la boucle :', demandeFormData.document.length);
  return formData ;
}


  onSaveDemande(){
    if(this.candidateId){
      this.demandeForm.get("candidateId")?.setValue(this.candidateId);
    }
  if(this.demandeForm.valid){
   let formData:demandeFormData = this.demandeForm.value ;
   let documentController = this.demandeForm.get('document') as FormArray ;
    documentController.clear();
   const prepardDemandeFormData = this.prepareFormData(formData)  ;
   console.log(prepardDemandeFormData)
           console.log(formData); 
   this.demandeService.create(prepardDemandeFormData  , this.offreId).subscribe(
     (data)=>{
       this.candidature = data ;
         this.requestId=data.id;
         this.candidateId=data.candidateId ; 
         this.showEvaluation=true ; 
     }  
   )
  }else{  
   console.log('demande form nest pas valide ')
  }    
}

onEvaluationSubmitted(event:any){

}
Anuller(){
  this.router.navigate(["/features/talent/offre/Announcement_Actuel"]);
  this.demandeForm.reset();   
}


}
