import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CountryService } from '../../services/country.service';

@Component({
  selector: 'app-add-country',
  templateUrl: './add-country.component.html',
  styleUrls: ['./add-country.component.scss']
})
export class AddCountryComponent {
  public formGroup: FormGroup;
  public spinner: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private service: CountryService,
    private route: Router,
  ) {
    this.formGroup = this.formBuilder.group({
      codecountry: [null, Validators.required],
      countrydescription: [null, [Validators.required]],
    });
  }
  get f() {
    return this.formGroup.controls;
  }

  onSubmit(country: any) {
    this.spinner = true;

    this.service.addCountry(country).subscribe(
      (res) => {
        this.spinner = false;
        this.route.navigate(['/features/core/country-management']);
      },
      (error) => {
        console.log(error);
        this.spinner = false;
      }
    );
  }
}
