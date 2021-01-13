import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankAccountDepositComponent } from './bank-account-deposit.component';

describe('BankAccountDepositComponent', () => {
  let component: BankAccountDepositComponent;
  let fixture: ComponentFixture<BankAccountDepositComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankAccountDepositComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankAccountDepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
