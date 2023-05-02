import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Claim } from '../../model/Complaints/claim.model';
import { ClaimService } from '../../shared/claim.service';
@Component({
  selector: 'app-update-complaints',
  templateUrl: './update-complaints.component.html',
  styles: [
  ]
})
export class UpdateComplaintsComponent implements OnInit {

  id!: number;
  event!: Claim ;
  eventForm!: FormGroup;

  constructor(private route: ActivatedRoute,private router: Router,
    private claimService: ClaimService , private formBuilder: FormBuilder) { }

    ngOnInit() {
      this.route.params.subscribe(params => {
        this.id = +params['id'];
        this.claimService.getClaimId(this.id)
          .subscribe((objet: Claim) => {
            this.event = objet;
            // pré-remplir les champs du formulaire avec les valeurs de l'événement
            this.eventForm = this.formBuilder.group({
              objet: [this.event.objet],
              message: [this.event.message],
              image: [this.event.image],
              typeClaim: [this.event.typeClaim],
      
            });
          });
      });
    }
    

  updateClaim() {
    this.claimService.updateClaim(this.id, this.event)
      .subscribe({
        next: data => {
          console.log(data);
          this.event = new Claim();
          this.gotoList();
        },
        error: error => console.log(error)
      });
  }
  

  onSubmit() {
    this.updateClaim();    
  }

  gotoList() {
    this.router.navigate(['/front']);
  }

}



