import { Customer } from "./customer";

export interface Duepayments {
    id: number,
    dueDate : Date;
    customer : Customer;
}
