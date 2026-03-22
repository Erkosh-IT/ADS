Part 1: Recursion with Numbers
Task 1. Print Digits of a Number
I have developed a method PrintNUM, which uses recursion to print the digits of a number one by one. The number moves forward by a factor of 10 until it becomes a single-digit number. After the recursion ends, the digits print from left to right using n % 10.
Result:
<img width="1816" height="324" alt="Task1" src="https://github.com/user-attachments/assets/2dc7aebe-0896-4eb1-a59f-5443e26dc9b5" />

Task 2. Average of Elements
I have developed a method Sum, which uses recursion to calculate the average of integers entered from standard input. The integers entered from standard input use a recursive approach without a loop. The next integer is entered using sc.nextInt() and added to the sum. The process ends until there are no more integers to enter.
Result:
<img width="1820" height="311" alt="Task2" src="https://github.com/user-attachments/assets/887ef730-28fb-48b7-bb5d-dfb632a5fdf0" />

Task 3. Prime Number Check
I have developed a method Prime, which uses recursion to determine whether a number is prime or not. The method uses a loop to divide the number by all integers from 2 to n/2. If n <= 1, the method returns false. If the loop ends without a remainder, the method returns true. If n % div == 0, the method returns false.
Results:
<img width="1719" height="202" alt="Task3 example1" src="https://github.com/user-attachments/assets/aed36c7b-9ca8-4d11-b28d-570de4909048" />
<img width="1805" height="304" alt="Task3 example2" src="https://github.com/user-attachments/assets/f3fe5574-e52b-4e9d-a926-789aec4b62f2" />

Task 4. Factorial
I have developed a method, which uses recursion to calculate the factorial of a number. The factorial is defined as n! = n*(n-1)!.
Result:
<img width="1808" height="294" alt="Task4" src="https://github.com/user-attachments/assets/693f03b2-7f3e-4655-88e5-ab02c64cdb48" />

Part 2: Recursion with Sequences
Task 5. Fibonacci Number
I have developed a method fibonacci, which uses additive recursion to find the nth Fibonacci number. The nth Fibonacci number is equal to the sum of the two preceding numbers. The method calls itself twice to find the two preceding Fibonacci numbers.
Results:
<img width="1805" height="292" alt="Task5 example1" src="https://github.com/user-attachments/assets/4223c615-d3a3-4b62-8453-631a358a9817" />
<img width="1813" height="280" alt="Task5 example2" src="https://github.com/user-attachments/assets/8bd80d47-dbe6-4bd2-9201-0d24c2220239" />

Task 6. Power Function
I created the POWER function, which calculates the value of a^n by recursive multiplication. I simply multiply the base number 'a' by the recursive call to POWER(a, n - 1) and do that 'n' times, depending on the depth of the recursion.
Result:
<img width="1809" height="287" alt="Task6" src="https://github.com/user-attachments/assets/9a4522ea-833a-4fcc-a654-7df79936d9a1" />

Task 7. Reverse Output
I created the reverse method, which reads 'n' integers and then reverses the output without the use of arrays and loops. I used a local variable 'current' to hold the value read by 'sc.nextInt()' before the recursive call.
Result:
<img width="1812" height="338" alt="Task7" src="https://github.com/user-attachments/assets/c5ef5763-4608-49bc-bde2-ec34a4138ecd" />

Part 3: Recursion with Strings
Task 8. Check Digits in String
I developed the ALLdigit method, which checks if a string is composed of digits only. To accomplish this, I compared the character at hand and called the method recursively by calling ALLdigit(s, index + 1).
Results:
<img width="1763" height="228" alt="Task8 example1" src="https://github.com/user-attachments/assets/b2d07215-94d1-4bc4-a92b-24370b23378d" />
<img width="1765" height="231" alt="Task8 example2" src="https://github.com/user-attachments/assets/7049e995-530a-4d8c-b6b0-8238e466ee8e" />

Task 9. Count Characters in a StringI developed a count method, which computes the length of a string recursively without using the .length() method of a string object. I added 1 to count(s.substring(1)) by slicing the string until it was empty.
Results:
<img width="1749" height="209" alt="Task9 example1" src="https://github.com/user-attachments/assets/7edf3b54-4264-4fd5-99d1-b7477aa4fbb6" />
<img width="1772" height="220" alt="Task9 example2" src="https://github.com/user-attachments/assets/b6544415-cd79-4c0d-be67-e7eb819610f2" />

Task 10. Greatest Common Divisor (GCD)I solved the problem of computing the greatest common divisor of two integers by implementing the Euclidean method. I recursively called gcd(b, a % b), using the modulus operator until the number was reduced to zero.
Results:
<img width="1760" height="273" alt="Task10 example1" src="https://github.com/user-attachments/assets/572337c0-3687-42c0-8f4f-c588c577b4c6" />
<img width="1754" height="152" alt="Task10 example2" src="https://github.com/user-attachments/assets/11112da1-d0d7-466c-bb81-26c59d8f8381" />
