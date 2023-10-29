import { Customer } from "./customer";
import { CustomerComponent } from "./customer/customer.component";

export interface Paymentplan {
    id: number;
    paidamount: number;
    dueamount: number;
    duedate: Date;
    customer: Customer;
}
