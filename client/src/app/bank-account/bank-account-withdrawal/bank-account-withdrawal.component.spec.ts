import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankAccountWithdrawalComponent } from './bank-account-withdrawal.component';

describe('BankAccountWithdrawalComponent', () => {
  let component: BankAccountWithdrawalComponent;
  let fixture: ComponentFixture<BankAccountWithdrawalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankAccountWithdrawalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankAccountWithdrawalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
