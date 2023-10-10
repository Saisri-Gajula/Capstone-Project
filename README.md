# Software Requirements Specification (SRS)

## Table of Contents
1. [Project Details](#1-project-details)
2. [Introduction](#2-introduction)
3. [Functional Requirements](#3-functional-requirements)
3.1 [Dunning Process](#31-dunning-process)
3.2 [Cure Process](#32-cure-process)
4. [Non-Functional Requirements](#4-non-functional-requirements)
5. [Dev/Execution Platform](#5-devexecution-platform)
6. [Workflow Tool](#6-workflow-tool)
7. [References](#7-references)

## 1. Project Details
- **Project Name:** Collection Process Handling
- **Author/Owner:** Vijay Ram

## 2. Introduction
The Collection Process Handling project aims to develop an application for managing the Dunning and Cure processes for customer accounts with overdue payments. The primary goal is to remind customers about unpaid bills, encourage them to make payments, and, when necessary, resolve any issues to reinstate services or clear outstanding balances.

## 3. Functional Requirements

### 3.1 Dunning Process
The Dunning process involves a series of steps to communicate with customers about their overdue payments and encourage them to settle their accounts. It follows this sequence:

#### 3.1.1 Initial Reminder
Shortly after a payment becomes overdue, the company sends an initial reminder or notification to the customer. This reminder informs them of the outstanding balance and the due date, urging them to make a payment.

#### 3.1.2 Follow-Up Reminders
If the customer does not respond or make a payment after the initial reminder, the company sends additional follow-up reminders. These reminders may become progressively more assertive or frequent, depending on the company's policies.

#### 3.1.3 Final Notice
When the account remains unpaid despite multiple reminders, the company may send a final notice or warning. This notice may inform the customer that their services will be suspended or terminated if they do not pay by a specific date.

#### 3.1.4 Service Suspension or Termination
If the customer continues to neglect their payments, the company may suspend or terminate the services associated with the unpaid account. This step is usually a last resort to encourage payment.

### 3.2 Cure Process
The Cure process comes into play when a customer's services have been suspended or terminated due to non-payment. It aims to help the customer resolve the issue and reinstate services. The cure process typically involves the following steps:

#### 3.2.1 Customer Contact
The company contacts the customer to explain the reason for service suspension or termination and provides details on how to cure the issue. This may include making a payment to clear the overdue balance.

#### 3.2.2 Payment Arrangements
In some cases, the company may offer the customer the option to set up a payment arrangement or plan to pay off the outstanding balance in installments.

#### 3.2.3 Customer Support
Customer support representatives assist the customer in resolving any issues related to the overdue payment. They may address billing discrepancies, payment processing problems, or other concerns.

#### 3.2.4 Reinstatement of Services
Once the customer has met the conditions outlined in the cure process (e.g., making a payment or adhering to a payment plan), the company reinstates their services. This may require a certain period of time to process the payment or verify compliance with the cure process terms.

## 4. Non-Functional Requirements
(Include non-functional requirements such as performance, security, scalability, and usability.)


## 5. Dev/Execution Platform
- **Platform:** Billing
- **Full Stack:**
  1. **Front-end:** -Angular
  2. **Backeend:** -Springboot 
  

## 6. Workflow Tool
- **Workflow Tool:** Camunda

## 7. References
- Reference documents and videos: [Reference: ChatGPT]
