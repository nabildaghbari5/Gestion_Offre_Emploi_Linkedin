import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { PhoneCountryCode } from '../../constants/phone-country-code';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  @Input() formGroup!: FormGroup;
  @Output() formValidityChange = new EventEmitter<boolean>();

  typesContact = ["Email", "Phone", "Mobile"];
  relations = ["Father", "Mother", "Brother", "Sister", "Son", "Uncle", "Aunt"];
  countryPhoneCodes: string[] = Object.values(PhoneCountryCode);
  filteredCountryCodes: string[] = this.countryPhoneCodes;
  valueChanged = false;
  showCountryCode = false;
  valueContactPlaceholder = "Phone";
  searchCountryControl = new FormControl();

  constructor() { }

  ngOnInit() {
    if (!this.formGroup.controls['typecontact'].value) {
      this.formGroup.patchValue({ typecontact: 'Phone' });
    }

    this.updateUIBasedOnContactType(this.formGroup.controls['typecontact'].value);

    this.searchCountryControl.valueChanges.subscribe(value => {
      this.filterCountryCodes(value);
    });

    this.formGroup.statusChanges.subscribe(status => {
      this.formValidityChange.emit(this.formGroup.valid);
    });

    // Update the UI if the typecontact value changes from the form control
    this.formGroup.controls['typecontact'].valueChanges.subscribe(value => {
      this.updateUIBasedOnContactType(value);
    });
  }

  checked(event: any) {
    this.valueChanged = event.checked;
  }

  onContactTypeChange(event: any) {
    this.updateUIBasedOnContactType(event.value);
  }

  private updateUIBasedOnContactType(typecontact: string) {
    this.valueContactPlaceholder = typecontact;
    this.showCountryCode = typecontact === 'Phone' || typecontact === 'Mobile';
  }

  getCountryNameByCode(code: string): string {
    for (const [key, value] of Object.entries(PhoneCountryCode)) {
      if (value === code) {
        return key.replace(/_/g, ' ');
      }
    }
    return ''; 
  }

  private filterCountryCodes(value: string) {
    if (value) {
      const filterValue = value.toLowerCase();
      this.filteredCountryCodes = this.countryPhoneCodes.filter(code =>
        this.getCountryNameByCode(code).toLowerCase().includes(filterValue) ||
        code.includes(filterValue)
      );
    } else {
      this.filteredCountryCodes = this.countryPhoneCodes;
    }
  }
}
