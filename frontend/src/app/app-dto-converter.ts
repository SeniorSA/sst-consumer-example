import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import * as moment from 'moment';

import { ContractType } from './enumerations/contract-type.enum';
import { ESocialCategoryType } from './enumerations/e-social-category-type.enum';
import { EmployeeType } from './enumerations/employee-type.enum';
import { GenderType } from './enumerations/gender-type.enum';
import { IntegrationType } from './enumerations/integration-type.enum';
import { MaritalStatusType } from './enumerations/marital-status-type.enum';
import { SituationType } from './enumerations/situation-type.enum';

export class AppDtoConverter {
  constructor() {}

  static convertToViewListPendencies(pendenciesList: any) {
    if (pendenciesList && pendenciesList.length) {
      pendenciesList.forEach(pendencie => {
        if (pendencie && pendencie.receiptDate) {
          pendencie.receiptDate = this.convertDateTime(pendencie.receiptDate);
        }
      });
    }
    return pendenciesList && pendenciesList.length ? pendenciesList : [];
  }

  static convertToViewPendencies(
    pendencie: any,
    pendenciesFormGroup: FormGroup,
    formBuilder: FormBuilder
  ) {
    if (pendencie && !pendencie.workstation) {
      pendencie.workstation = [];
    }
    if (pendencie && !pendencie.shift) {
      pendencie.shift = [];
    }
    if (pendencie && !pendencie.jobPosition) {
      pendencie.jobPosition = [];
    }
    if (pendencie && !pendencie.department) {
      pendencie.department = [];
    }
    if (pendencie && !pendencie.costCenter) {
      pendencie.costCenter = [];
    }
    if (pendencie && !pendencie.companyBranch) {
      pendencie.companyBranch = [];
    }
    if (pendencie && !pendencie.company) {
      pendencie.company = [];
    }
    if (pendencie && !pendencie.deficiency) {
      pendencie.deficiency = [];
    }
    pendenciesFormGroup.patchValue({ employee: pendencie });
    if (pendencie && pendencie.esocialCategoryType) {
      pendenciesFormGroup
        .get('employee')
        .get('eSocialCategoryType')
        .setValue(pendencie.esocialCategoryType);
    }
    if (pendencie && pendencie.esocialRegistration) {
      pendenciesFormGroup
        .get('employee')
        .get('eSocialRegistration')
        .setValue(pendencie.esocialRegistration);
    }
    if (pendencie && pendencie.integrationType) {
      pendenciesFormGroup
        .get('integrationType')
        .setValue(pendencie.integrationType);
    }
    if (pendencie && pendencie.receiptDate) {
      pendenciesFormGroup.get('receiptDate').setValue(pendencie.receiptDate);
    }

    this.convertPendencieDate(pendencie, pendenciesFormGroup);
    this.convertPendencieEnum(pendencie, pendenciesFormGroup);

    if (pendencie && pendencie.deficiency && pendencie.deficiency.length) {
      const df = [...pendencie.deficiency];
      df.map(deficiency => {
        deficiency.isMainDeficiency = this.convertBooleanToString(
          deficiency.isMainDeficiency
        );
        deficiency.isRehabilitated = this.convertBooleanToString(
          deficiency.isRehabilitated
        );
        if (deficiency.dateWhen) {
          deficiency.dateWhen = this.convertDate(deficiency.dateWhen);
        }
        (<FormArray>pendenciesFormGroup.get('employee').get('deficiency')).push(
          formBuilder.control(deficiency)
        );
      });
    }

    pendenciesFormGroup
      .get('employee')
      .get('isDeficient')
      .setValue(this.convertBooleanToString(pendencie.isDeficient));
  }

  static convertPendencieDate(pendencie: any, pendenciesFormGroup: FormGroup) {
    if (pendencie && pendencie.birthday) {
      pendenciesFormGroup
        .get('employee')
        .get('birthday')
        .setValue(this.convertDate(pendencie.birthday));
    }
    if (pendencie && pendencie.hireDate) {
      pendenciesFormGroup
        .get('employee')
        .get('hireDate')
        .setValue(this.convertDate(pendencie.hireDate));
    }
    if (
      pendencie &&
      pendencie.companyBranch &&
      pendencie.companyBranch.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('companyBranch')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.companyBranch.dateWhen));
    }
    if (pendencie && pendencie.costCenter && pendencie.costCenter.dateWhen) {
      pendenciesFormGroup
        .get('employee')
        .get('costCenter')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.costCenter.dateWhen));
    }
    if (pendencie && pendencie.department && pendencie.department.dateWhen) {
      pendenciesFormGroup
        .get('employee')
        .get('department')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.department.dateWhen));
    }
    if (pendencie && pendencie.jobPosition && pendencie.jobPosition.dateWhen) {
      pendenciesFormGroup
        .get('employee')
        .get('jobPosition')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.jobPosition.dateWhen));
    }
    if (pendencie && pendencie.shift && pendencie.shift.dateWhen) {
      pendenciesFormGroup
        .get('employee')
        .get('shift')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.shift.dateWhen));
    }
    if (pendencie && pendencie.workstation && pendencie.workstation.dateWhen) {
      pendenciesFormGroup
        .get('employee')
        .get('workstation')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.workstation.dateWhen));
    }
    if (pendencie && pendencie.dismissalDate) {
      pendenciesFormGroup
        .get('employee')
        .get('dismissalDate')
        .setValue(this.convertDateTime(pendencie.dismissalDate));
    }
  }

  static convertBooleanToString(value) {
    if (value == null || value === undefined || value === '') {
      return '';
    } else {
      return value ? 'Sim' : 'Não';
    }
  }

  static convertDateTime(date) {
    return date ? moment(date, 'YYYY-MM-DDTHH:mm:ssZ').format('L LTS') : '';
  }

  static convertDate(date) {
    return date ? moment(date, 'YYYY-MM-DD').format('L') : '';
  }

  static convertPendencieEnum(pendencie: any, pendenciesFormGroup: FormGroup) {
    if (pendencie && pendencie.integrationType) {
      pendenciesFormGroup
        .get('integrationType')
        .setValue(IntegrationType[pendencie.integrationType]);
    }
    if (pendencie && pendencie.genderType) {
      pendenciesFormGroup
        .get('employee')
        .get('genderType')
        .setValue(GenderType[pendencie.genderType]);
    }
    if (pendencie && pendencie.maritalStatusType) {
      pendenciesFormGroup
        .get('employee')
        .get('maritalStatusType')
        .setValue(MaritalStatusType[pendencie.maritalStatusType]);
    }
    if (pendencie && pendencie.contractType) {
      pendenciesFormGroup
        .get('employee')
        .get('contractType')
        .setValue(ContractType[pendencie.contractType]);
    }
    if (pendencie && pendencie.esocialCategoryType) {
      pendenciesFormGroup
        .get('employee')
        .get('eSocialCategoryType')
        .setValue(ESocialCategoryType[pendencie.esocialCategoryType]);
    }
    if (pendencie && pendencie.employeeType) {
      pendenciesFormGroup
        .get('employee')
        .get('employeeType')
        .setValue(EmployeeType[pendencie.employeeType]);
    }
    if (pendencie && pendencie.situationType) {
      pendenciesFormGroup
        .get('employee')
        .get('situationType')
        .setValue(SituationType[pendencie.situationType]);
    }
  }
}
