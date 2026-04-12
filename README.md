# Assignment #2. Physical & Logical Data Structures (Banking System) 

**Student:** Yerkebulan Korganbek  
**Group:** IT - 2501
# Project Overview
This project simulates a banking environment to demonstrate the practical application of various data structures. It features three distinct interfaces: a Customer Bank Menu, an ATM Interface, and an Admin Panel.
# Part 1. Logical Data Structures
**Tasks 1 & 5** 
<img width="1748" height="498" alt="image" src="https://github.com/user-attachments/assets/827c5324-522e-4b0f-9def-7d5f61dbad64" />
<img width="1748" height="521" alt="image" src="https://github.com/user-attachments/assets/acfdfd67-da25-4476-b894-14f3d4089bff" />
<img width="1748" height="290" alt="image" src="https://github.com/user-attachments/assets/7c7c6899-cc49-490e-9304-549415d8cec2" />
<img width="1748" height="282" alt="image" src="https://github.com/user-attachments/assets/2f4dcefd-2d90-4172-a616-014ba0031d9b" />
<img width="1740" height="241" alt="image" src="https://github.com/user-attachments/assets/3762cde5-3fc8-49a1-89e5-af27a17f79a9" />
<img width="1747" height="388" alt="image" src="https://github.com/user-attachments/assets/acc4ad3e-5e4b-462c-b3cb-6f15e24520ff" />
<img width="1757" height="202" alt="image" src="https://github.com/user-attachments/assets/bed32408-9d83-4171-b024-f6a32c46ff15" />
<img width="1755" height="407" alt="image" src="https://github.com/user-attachments/assets/5c0a3337-ccb2-409c-a61b-e91b62bf2bd1" />
<img width="1751" height="338" alt="image" src="https://github.com/user-attachments/assets/12c464c5-5a75-4f66-ada0-76b0a8c70665" />
<img width="1746" height="329" alt="image" src="https://github.com/user-attachments/assets/9ec6afbd-8fab-4de7-836f-57a2d8ae3e95" />
<img width="1749" height="332" alt="image" src="https://github.com/user-attachments/assets/782d30fc-b3f5-46b8-894c-fa6010565e4a" />
<img width="1741" height="330" alt="image" src="https://github.com/user-attachments/assets/07e3c9cf-05e5-41ff-bde4-5a44b4fef375" />

# 1. LinkedList: The Account Database (Task 1)
For the main storage of active bank accounts, I utilized a LinkedList<BankAccount>.

Why LinkedList? In a real-world bank, the number of customers is constantly changing. A LinkedList allows for dynamic memory allocation, meaning we can add or remove accounts efficiently without the overhead of resizing a fixed-capacity array.

Functionality: It supports O(n) searching for accounts by username and O(1) insertion for new approved accounts.

# 2. Stack: Transaction History & Undo Logic (Task 3)
To track user actions (deposits, withdrawals, payments), I implemented a Stack<String>.

Theory (LIFO): A Stack follows the Last-In, First-Out principle. This is the ideal structure for an "Undo" feature because the most recent transaction is always at the "top" of the stack.

Operations: * push(): Records a new transaction.

pop(): Removes the latest transaction to "undo" an action.

peek(): Allows the admin to view the most recent activity without removing it.

# 3. Queue: Request & Bill Processing (Tasks 4 & 5)
I utilized two separate Queue structures to manage pending operations: accountRequests and billQueue.

Theory (FIFO): A Queue follows the First-In, First-Out principle. This ensures "fairness" in the banking system—the first customer to request an account or submit a bill is the first one to be processed by the administrator.

**Application:**

Account Queue: Holds new applications until an Admin approves them, moving them from the Queue into the main LinkedList.

Bill Queue: Manages utility payments in the order they were received, preventing data congestion during high-traffic periods.


# Part 2. Physical Data Structures 
**Task 6**


<img width="472" height="403" alt="image" src="https://github.com/user-attachments/assets/c8fe66c4-1731-40bf-b2a5-d32790a6f98e" />


Unlike the dynamic LinkedList, this task demonstrates the use of a physical structure with a fixed size.

Structure: BankAccount[3]

Function: Stores and prints three predefined accounts.

# Part 3. Mini Banking Menu
<img width="271" height="181" alt="image" src="https://github.com/user-attachments/assets/7ece9cd2-97be-4739-86f5-d5e3c6b04427" />


<img width="363" height="204" alt="image" src="https://github.com/user-attachments/assets/ce5928cc-ef5a-41ca-933e-26afbec13637" />


<img width="319" height="152" alt="image" src="https://github.com/user-attachments/assets/f1873e45-3b34-4b91-85eb-ed74d0bfd651" />


<img width="439" height="300" alt="image" src="https://github.com/user-attachments/assets/7f052120-40f5-4f14-9047-676ef97e1b02" />


This is the "Full System" where all logical structures are integrated into a single user-friendly menu.

**Available Interfaces**


Bank Menu: Submit requests, deposit/withdraw, and submit bills.

ATM Menu: Quick balance checks and cash withdrawals.

Admin Panel: Process queues (Accounts/Bills), view all users, and undo mistakes.



