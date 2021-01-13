import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankAccountHistoryComponent } from './bank-account-history.component';

describe('BankAccountHistoryComponent', () => {
  let component: BankAccountHistoryComponent;
  let fixture: ComponentFixture<BankAccountHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankAccountHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankAccountHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
