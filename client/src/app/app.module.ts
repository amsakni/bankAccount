import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BankAccountDepositComponent } from './bank-account/bank-account-deposit/bank-account-deposit.component';
import { BankAccountWithdrawalComponent } from './bank-account/bank-account-withdrawal/bank-account-withdrawal.component';
import { BankAccountHistoryComponent } from './bank-account/bank-account-history/bank-account-history.component';
import { BankAccountService } from './bank-account/service/bank-account.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    BankAccountDepositComponent,
    BankAccountWithdrawalComponent,
    BankAccountHistoryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [
    BankAccountService,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
