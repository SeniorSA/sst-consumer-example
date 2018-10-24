import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import * as moment from 'moment';
import { MessageService } from 'primeng/api';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { AppDtoConverter } from './app-dto-converter';
import { AppService } from './app.service';
import { DeficiencyType } from './enumerations/deficiency-type.enum';
import { IntegrationType } from './enumerations/integration-type.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  pendenciesFormGroup: FormGroup;
  showSideBar = false;
  pendenciesList = [];
  private ngUnsubscribe = new Subject();
  constructor(
    private formBuilder: FormBuilder,
    private appService: AppService,
    private messageService: MessageService
  ) {}
  ngOnInit() {
    moment.locale('pt-BR');
    this.createFormGroup();
    this.getIntegrationData();
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  createFormGroup() {
    this.pendenciesFormGroup = this.formBuilder.group({
      statusType: this.formBuilder.control({ value: null, disabled: true }),
      reasonPendingIntegration: this.formBuilder.control({
        value: null,
        disabled: true
      }),
      integrationType: this.formBuilder.control({
        value: null,
        disabled: true
      }),
      receiptDate: this.formBuilder.control({ value: null, disabled: true }),
      employee: this.formBuilder.group({
        code: this.formBuilder.control({ value: null, disabled: true }),
        name: this.formBuilder.control({ value: null, disabled: true }),
        cpfNumber: this.formBuilder.control({ value: null, disabled: true }),
        nisNumber: this.formBuilder.control({ value: null, disabled: true }),
        eSocialRegistration: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        birthday: this.formBuilder.control({ value: null, disabled: true }),
        genderType: this.formBuilder.control({ value: null, disabled: true }),
        maritalStatusType: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        isDeficient: this.formBuilder.control({ value: null, disabled: true }),
        contractType: this.formBuilder.control({ value: null, disabled: true }),
        hireDate: this.formBuilder.control({ value: null, disabled: true }),
        registrationNumber: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        employeeType: this.formBuilder.control({ value: null, disabled: true }),
        eSocialCategoryType: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        dismissalDate: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        situationType: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        referenceDateInformation: this.formBuilder.control({
          value: null,
          disabled: true
        }),
        company: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          providerCompanyIdentification: this.formBuilder.control({
            value: null,
            disabled: true
          })
        }),
        companyBranch: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          subscriptionType: this.formBuilder.control({
            value: null,
            disabled: true
          }),
          subscriptionNumber: this.formBuilder.control({
            value: null,
            disabled: true
          }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        costCenter: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        workstation: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          structureCode: this.formBuilder.control({
            value: null,
            disabled: true
          }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        department: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          structureCode: this.formBuilder.control({
            value: null,
            disabled: true
          }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        jobPosition: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          structureCode: this.formBuilder.control({
            value: null,
            disabled: true
          }),
          cboCode: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        shift: this.formBuilder.group({
          code: this.formBuilder.control({ value: null, disabled: true }),
          name: this.formBuilder.control({ value: null, disabled: true }),
          dateWhen: this.formBuilder.control({ value: null, disabled: true })
        }),
        deficiency: this.formBuilder.array([])
      })
    });
  }

  viewPendencie(pendencie) {
    this.createFormGroup();
    AppDtoConverter.convertToViewPendencies(
      pendencie,
      this.pendenciesFormGroup,
      this.formBuilder
    );
    this.showSideBar = true;
  }

  closePendencisSidBar() {
    this.showSideBar = false;
  }

  getIntegrationData(update = false) {
    this.appService
      .getPendenciesList()
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(payload => {
        this.pendenciesList = AppDtoConverter.convertToViewListPendencies(
          payload
        );
        if (update) {
          this.messageService.add({
            severity: 'success',
            summary: 'Success Message',
            detail: 'Atualizado com sucesso'
          });
        }
      });
  }

  getTotalDeficiency() {
    return (<FormArray>(
      this.pendenciesFormGroup.get('employee').get('deficiency')
    )).getRawValue().length;
  }

  getDeficiency() {
    return (<FormArray>(
      this.pendenciesFormGroup.get('employee').get('deficiency')
    )).getRawValue();
  }

  public getEnumIntegrationType(integrationType: string) {
    return IntegrationType[integrationType];
  }
  public getEnumDeficiencyType(deficiencyType: string) {
    return DeficiencyType[deficiencyType];
  }
}
