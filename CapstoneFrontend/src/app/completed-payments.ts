import { Customer } from "./customer";

export interface CompletedPayments {
    id: number;
    phoneNumber: string;
    status: string;
    Date: Date;
    customer: Customer;
}
