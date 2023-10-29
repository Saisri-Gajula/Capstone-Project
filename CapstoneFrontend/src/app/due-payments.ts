import { Customer } from "./customer";

export interface DuePayments {
    id: number,
    dueDate : Date;
    customer : Customer;
    amount: number;
}
