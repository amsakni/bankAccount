import { Component, OnInit } from '@angular/core';
import { IAccount } from '../model/account.model';
import { BankAccountService } from '../service/bank-account.service';

@Component({
  selector: 'app-bank-account-history',
  templateUrl: './bank-account-history.component.html',
  styleUrls: ['./bank-account-history.component.css']
})
export class BankAccountHistoryComponent implements OnInit {

  constructor(private accountService : BankAccountService) { }


  accountsOperation : IAccount [];
  public myMath = Math;

  ngOnInit(): void {
    this.accountService.getAllOpetations().subscribe(accountsOperation => {
      this.accountsOperation = accountsOperation;
    });
  }

}
