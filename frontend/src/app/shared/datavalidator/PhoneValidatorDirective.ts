import { Directive } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from '@angular/forms';

@Directive({
  selector: '[appPhoneValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: PhoneValidatorDirective, multi: true}]
})
export class PhoneValidatorDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    const valid = /^[0-9]*$/.test(control.value);
    return valid ? null : { 'phoneInvalid': true };
  }
}
