import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BankAccountService } from '../service/bank-account.service';

@Component({
  selector: 'app-bank-account-withdrawal',
  templateUrl: './bank-account-withdrawal.component.html',
  styleUrls: ['./bank-account-withdrawal.component.css']
})
export class BankAccountWithdrawalComponent implements OnInit {

  constructor(
    private accountService : BankAccountService,
    private router: Router 
    ) { }

  ngOnInit(): void {
  }

  withdrawalAmount : number;
  errorMessage : string;

  withdrawal() {
    if(this.withdrawalAmount) {
      this.accountService.withdrawal(this.withdrawalAmount).subscribe(response => {
        this.router.navigate(['/history'])
      },
      err => this.errorMessage = err.error.message);
    }
  }
}
