import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import * as moment from 'moment';

import { ContractType } from './enumerations/contract-type.enum';
import { ESocialCategoryType } from './enumerations/e-social-category-type.enum';
import { EmployeeType } from './enumerations/employee-type.enum';
import { GenderType } from './enumerations/gender-type.enum';
import { IntegrationType } from './enumerations/integration-type.enum';
import { MaritalStatusType } from './enumerations/marital-status-type.enum';
import { SituationType } from './enumerations/situation-type.enum';
import { StatusType } from './enumerations/status-type.enum';
import { OperationType } from './enumerations/operation-type.enum';

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
    if (pendencie && pendencie.employee && !pendencie.employee.workstation) {
      pendencie.employee.workstation = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.shift) {
      pendencie.employee.shift = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.jobPosition) {
      pendencie.employee.jobPosition = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.department) {
      pendencie.employee.department = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.costCenter) {
      pendencie.employee.costCenter = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.companyBranch) {
      pendencie.employee.companyBranch = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.company) {
      pendencie.employee.company = [];
    }
    if (pendencie && pendencie.employee && !pendencie.employee.deficiency) {
      pendencie.employee.deficiency = [];
    }
    pendenciesFormGroup.patchValue(pendencie);
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
    if (pendencie && pendencie.providerCompanyIdentification) {
      pendenciesFormGroup
        .get('employee')
        .get('company')
        .get('providerCompanyIdentification')
        .setValue(pendencie.providerCompanyIdentification);
    }
    if (pendencie && pendencie.receiptDate) {
      pendenciesFormGroup
        .get('employee')
        .get('referenceDateInformation')
        .setValue(pendencie.receiptDate);
    }

    this.convertPendencieDate(pendencie, pendenciesFormGroup);
    this.convertPendencieEnum(pendencie, pendenciesFormGroup);

    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.deficiency &&
      pendencie.employee.deficiency.length
    ) {
      const df = [...pendencie.employee.deficiency];
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
      .setValue(this.convertBooleanToString(pendencie.employee.isDeficient));
  }

  static convertPendencieDate(pendencie: any, pendenciesFormGroup: FormGroup) {
    if (pendencie && pendencie.employee && pendencie.employee.birthday) {
      pendenciesFormGroup
        .get('employee')
        .get('birthday')
        .setValue(this.convertDate(pendencie.employee.birthday));
    }
    if (pendencie && pendencie.employee && pendencie.employee.hireDate) {
      pendenciesFormGroup
        .get('employee')
        .get('hireDate')
        .setValue(this.convertDate(pendencie.employee.hireDate));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.companyBranch &&
      pendencie.companyBranch.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('companyBranch')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.companyBranch.dateWhen));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.costCenter &&
      pendencie.employee.costCenter.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('costCenter')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.costCenter.dateWhen));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.department &&
      pendencie.employee.department.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('department')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.department.dateWhen));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.jobPosition &&
      pendencie.employee.jobPosition.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('jobPosition')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.jobPosition.dateWhen));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.shift &&
      pendencie.employee.shift.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('shift')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.shift.dateWhen));
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.workstation &&
      pendencie.employee.workstation.dateWhen
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('workstation')
        .get('dateWhen')
        .setValue(this.convertDate(pendencie.employee.workstation.dateWhen));
    }
    if (pendencie && pendencie.employee && pendencie.employee.dismissalDate) {
      pendenciesFormGroup
        .get('employee')
        .get('dismissalDate')
        .setValue(this.convertDateTime(pendencie.employee.dismissalDate));
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
    if (pendencie && pendencie.employee && pendencie.employee.genderType) {
      pendenciesFormGroup
        .get('employee')
        .get('genderType')
        .setValue(GenderType[pendencie.employee.genderType]);
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.maritalStatusType
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('maritalStatusType')
        .setValue(MaritalStatusType[pendencie.employee.maritalStatusType]);
    }
    if (pendencie && pendencie.employee && pendencie.employee.contractType) {
      pendenciesFormGroup
        .get('employee')
        .get('contractType')
        .setValue(ContractType[pendencie.employee.contractType]);
    }
    if (
      pendencie &&
      pendencie.employee &&
      pendencie.employee.esocialCategoryType
    ) {
      pendenciesFormGroup
        .get('employee')
        .get('eSocialCategoryType')
        .setValue(ESocialCategoryType[pendencie.employee.esocialCategoryType]);
    }
    if (pendencie && pendencie.employee && pendencie.employee.employeeType) {
      pendenciesFormGroup
        .get('employee')
        .get('employeeType')
        .setValue(EmployeeType[pendencie.employee.employeeType]);
    }
    if (pendencie && pendencie.employee && pendencie.employee.situationType) {
      pendenciesFormGroup
        .get('employee')
        .get('situationType')
        .setValue(SituationType[pendencie.employee.situationType]);
    }
    if (pendencie && pendencie.statusType) {
      pendenciesFormGroup
        .get('statusType')
        .setValue(StatusType[pendencie.statusType]);
    }
    if (pendencie && pendencie.operationType) {
      pendenciesFormGroup
        .get('operationType')
        .setValue(OperationType[pendencie.operationType]);
    }
  }
}
