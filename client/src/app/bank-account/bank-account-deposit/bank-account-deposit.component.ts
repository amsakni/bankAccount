import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BankAccountService } from '../service/bank-account.service';

@Component({
  selector: 'app-bank-account-deposit',
  templateUrl: './bank-account-deposit.component.html',
  styleUrls: ['./bank-account-deposit.component.css']
})
export class BankAccountDepositComponent implements OnInit {

  constructor(
    private accountService : BankAccountService,
    private router: Router 
    ) { }

  ngOnInit(): void {
  }

  depositAmount : any;

  deposit() {
    if(this.depositAmount) {
      this.accountService.deposit(this.depositAmount).subscribe(response => {
        this.router.navigate(['/history'])
      });
    }
  }

}
