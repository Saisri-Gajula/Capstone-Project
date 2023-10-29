import { Customer } from "./customer";

export interface Reminders {
    reminder_id: number;
    reminder_level: number;
    phoneNumber: string;
    dueDate: Date;
    status: string;
    customer: Customer;
    dueamount: number;
}
