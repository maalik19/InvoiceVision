import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { facture } from 'src/Model/facture';
import { MainserviceService } from 'src/Service/mainservice.service';
import { FileUploadService } from 'src/app/services/file-upload.service';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {
  jsonText: string = '';
  dragDropText = 'Drag & drop your invoice here';
  fileName = '';
  fileSize = '';
  uploadButtonText = 'Upload';

  onFileInputChange(event: any): void {
    const files = event.target.files;
    if (files && files.length > 0) {
      this.fileName = files[0].name;
      this.fileSize = (files[0].size / 1024).toFixed(1) + ' KB';
    }
  }
  constructor(private service:MainserviceService,private rooter:Router,private img:FileUploadService) {}


   
  public updateJson() {
    try {
      const parsedJson = JSON.parse(this.jsonText);
  
      const fac1 = new facture(
        parsedJson.client,
        parsedJson.fournisseur,
        parsedJson.telClient,
        parsedJson.telFournisseur,
        parsedJson.totalTTC,
        parsedJson.designation,
        parsedJson.date
      );
      console.log(this.jsonText)
      console.log(fac1)
      this.service.updateJson(fac1).subscribe(res => {
        console.log(res);
      });
    } catch (error) {
      console.error(error);
    }
  }
  fac1(fac1: any) {
    throw new Error('Method not implemented.');
  }
  



  }
