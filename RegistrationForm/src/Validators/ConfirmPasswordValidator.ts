import { AbstractControl } from '@angular/forms';

export function confirmPassValidator(control:AbstractControl):{[key:string]:boolean} | null
{
    const passwordV=control.get("Password");
    const confirmPasswordV=control.get("ConfirmPassword");

    if(passwordV?.value!=confirmPasswordV?.value){
        return {'mismatchname':true}
    }else{

    return null;
    }
}
