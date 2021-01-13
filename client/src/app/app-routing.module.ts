import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router
import { BankAccountDepositComponent } from './bank-account/bank-account-deposit/bank-account-deposit.component';
import { BankAccountHistoryComponent } from './bank-account/bank-account-history/bank-account-history.component';
import { BankAccountWithdrawalComponent } from './bank-account/bank-account-withdrawal/bank-account-withdrawal.component';

const routes: Routes =  [
    { path: 'deposit', component: BankAccountDepositComponent },
    { path: 'withdrawal', component: BankAccountWithdrawalComponent },
    { path: 'history', component: BankAccountHistoryComponent }
  ];

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }