import { Injectable } from '@angular/core';
import { FileHandle } from '../models/file-handle.model';
import { DomSanitizer } from '@angular/platform-browser';
import { Demande } from '../models/demande';

@Injectable({
  providedIn: 'root'
})
export class ImageProcessingService {

  constructor( private sanitizer:DomSanitizer) { }

  public createImage(abonnment:any){
    const abonnmentImage:any[] = abonnment.abonnementImage;

    const abonnmentImagesToFileHandel:FileHandle[]=[];

    for(let i=0 ; i<abonnmentImage.length ; i++){
      const imageFileData=abonnmentImage[i];
      const imageBlob =  this.dataURIToBlob(imageFileData.picByte , imageFileData.type);
      const imageFile =  new File([imageBlob] ,imageFileData.name  , {type: imageFileData.type});
      const finalFileHandle:FileHandle={
        file:imageFile,
        url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
      };
      abonnmentImagesToFileHandel.push(finalFileHandle)
    }
    abonnment.abonnementImage=abonnmentImagesToFileHandel;
    return abonnment ; 
  }

  public dataURIToBlob(picBytes:any , imageType:any){
    const byteString = window.atob(picBytes);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer);

    for(let i=0 ; i<byteString.length ; i++){
      int8Array[i] = byteString.charCodeAt(i);
    }

    const blob =new Blob([int8Array] , {type: imageType})
        return blob ;
  
  }



  public sanitizeImageUrl(imageUrl: string): string {
    return this.sanitizer.bypassSecurityTrustUrl(imageUrl) as string;
  }


  public createImageDemande(demande:Demande){
    const abonnmentImage:any[] = demande.document;

    const abonnmentImagesToFileHandel:FileHandle[]=[]; 

    for(let i=0 ; i<abonnmentImage.length ; i++){
      const imageFileData=abonnmentImage[i];
      const imageBlob =  this.dataURIToBlob(imageFileData.picByte , imageFileData.type); 
      const imageFile =  new File([imageBlob] ,imageFileData.name  , {type: imageFileData.type});
      const finalFileHandle:FileHandle={
        file:imageFile,
        url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
      };
      abonnmentImagesToFileHandel.push(finalFileHandle)
    }
    demande.document=abonnmentImagesToFileHandel; 
    return demande ; 
  }


  

  public createImageRapport(demande:any){
    const abonnmentImage:any[] = demande.documentRapoort;

    const abonnmentImagesToFileHandel:FileHandle[]=[]; 

    for(let i=0 ; i<abonnmentImage.length ; i++){
      const imageFileData=abonnmentImage[i];
      const imageBlob =  this.dataURIToBlob(imageFileData.picByte , imageFileData.type); 
      const imageFile =  new File([imageBlob] ,imageFileData.name  , {type: imageFileData.type});
      const finalFileHandle:FileHandle={
        file:imageFile,
        url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
      };
      abonnmentImagesToFileHandel.push(finalFileHandle)
    }
    demande.documentRapoort=abonnmentImagesToFileHandel; 
    return demande ; 
  }


}
