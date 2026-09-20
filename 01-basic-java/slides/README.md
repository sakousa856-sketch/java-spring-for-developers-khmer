# Basic Java (Slide Presentations) 🇬🇧

> 🎓 **Basic Java Slide Presentation Series (87 Slides)** for teaching, presentation, and self-study, from introductory concepts to strong Java foundations.

> 🌐 **Language / ភាសា:** [Khmer (ភាសាខ្មែរ)](README.kh.md) | 🇬🇧 **English (README.md)**

[![Slides](https://img.shields.io/badge/Presentation-87%20Slides-blue.svg)](#-table-of-contents)
[![Language](https://img.shields.io/badge/Language-English-blue.svg)](#)
[![Parent](https://img.shields.io/badge/Course-05--Java--and--Spring-orange.svg)](../../../01-books-and-handbooks/05-java-and-spring/README.md)

---

## 📑 Table of Contents

- [1. History of Java](#1-history-of-java) *(Slides 01 - 02)*
- [2. Java Versions](#2-java-versions) *(Slides 03 - 04)*
- [3. Features of Java](#3-features-of-java) *(Slides 05 - 09)*
- [4. First Java Program](#4-first-java-program) *(Slides 10 - 11)*
- [5. How Java Works & Runs](#5-how-java-works--runs) *(Slides 12 - 13)*
- [6. Java Output & Print Methods](#6-java-output--print-methods) *(Slide 14)*
- [7. Java Comments](#7-java-comments) *(Slides 15 - 16)*
- [8. Java Variables](#8-java-variables) *(Slides 17 - 24)*
- [9. Java Data Types](#9-java-data-types) *(Slides 25 - 34)*
- [10. Java Type Casting](#10-java-type-casting) *(Slides 35 - 38)*
- [11. Java User Input](#11-java-user-input) *(Slides 39 - 47)*
- [12. Java Operators](#12-java-operators) *(Slides 48 - 53)*
- [13. Java Mathematics](#13-java-mathematics) *(Slides 54 - 59)*
- [14. Java Strings](#14-java-strings) *(Slides 60 - 65)*
- [15. Java If...Else](#15-java-ifelse) *(Slides 66 - 71)*
- [16. Java Switch Statement](#16-java-switch-statement) *(Slides 72 - 76)*
- [17. Java Loops](#17-java-loops) *(Slides 77 - 83)*
- [18. Java Arrays](#18-java-arrays) *(Slides 84 - 87)*

---

## 1. History of Java

![Slide 01 - History of Java](./assets/slide-01.png "History of Java - Green Project & James Gosling")

### Slide 1 Summary:
- **Java** was conceived by **James Gosling** at **Sun Microsystems** in a research effort called the **Green Project** in **1991**.
- The project was based on C and C++. It was originally named **Oak** after an oak tree outside Gosling's office window.
- The name was later changed to **Java** following coffee break discussions among colleagues.

![Slide 02 - Java and the World Wide Web](./assets/slide-02.png "History of Java - Emergence of World Wide Web")

### Slide 2 Summary:
- Green Project initially faced severe headwinds.
- In **1993**, the explosion of the **World Wide Web (WWW)** showed the Sun team the tremendous power of Java in driving dynamic web applets and pages, reviving the project with great momentum.

---

## 2. Java Versions

![Slide 03 - Java Versions 1.0 & 1.1](./assets/slide-03.png "Java Evolution: 1.0 and 1.1")

### Slide 3 Summary:
- **1995:** Release of **Java 1.0** for the World Wide Web (8 packages, 212 classes).
- **1997:** Release of **Java 1.1** adding UI improvements, event handling, inner classes, and Swing (23 packages, 504 classes).

![Slide 04 - Java Versions 1.3 to 1.6](./assets/slide-04.png "Java Evolution: 1.3 through 1.6")

### Slide 4 Summary:
- **2000:** Java 1.3 introduced the HotSpot Virtual Machine (76 packages, 1,842 classes).
- **2002:** Java 1.4 improved I/O and added XML parsing (135 packages, 2,991 classes).
- **2004:** Java 1.5 (Java 5) brought major language upgrades: generics, enhanced for-loop, annotations, and multithreading improvements (165 packages, 3,000+ classes).
- Subsequent releases like Java 1.6 expanded further to 200+ packages.

---

## 3. Features of Java

![Slide 05 - Simple](./assets/slide-05.png "Features of Java - Simple")
![Slide 06 - OOP & Statically Typed](./assets/slide-06.png "Features of Java - OOP & Statically Typed")
![Slide 07 - Compiled & Portable](./assets/slide-07.png "Features of Java - Compiled, Interpreted & Portable")
![Slide 08 - Multithreaded & Garbage Collected](./assets/slide-08.png "Features of Java - Multithreaded & Garbage Collected")
![Slide 09 - Robust & Secure](./assets/slide-09.png "Features of Java - Robust, Secure & Extensible")

### Summary of Slides 5 to 9:
- **Simple:** Cleaned up C++ complexities; eliminates explicit pointers, unions, header files, and multiple class inheritance.
- **Object Oriented:** Encapsulates state and behavior in classes and objects.
- **Statically Typed:** Variables must have explicit types, verified at compile time.
- **Compiled and Interpreted:** Compiled by `javac` into bytecode (`.class`), executed on any JVM ("Write Once, Run Anywhere").
- **Multithreaded:** Native support for concurrent execution.
- **Garbage Collected:** Automated memory reclamation via the Garbage Collector (GC).
- **Robust & Secure:** Strong type safety, exception handling, and JVM sandbox protection.

---

## 4. First Java Program

![Slide 10 - Example.java](./assets/slide-10.png "First Java Program: Example.java")
![Slide 11 - Anatomy of First Program](./assets/slide-11.png "Main method and System.out.println")

### Code Example:
```java
// This is the first example java program. Save file as "Example.java"
class Example {
    // A Java program begins with a call to main().
    public static void main(String[] args) {
        System.out.println("Java drives the Web.");
    }
}
```

---

## 5. How Java Works & Runs

![Slide 12 - Compilation with javac](./assets/slide-12.png "Compilation via javac")
![Slide 13 - Execution with java](./assets/slide-13.png "Execution via java JVM")

```bash
# 1. Compile source code to bytecode (.class)
javac Example.java

# 2. Run bytecode on JVM
java Example
```

---

## 6. Java Output & Print Methods

![Slide 14 - Java Output](./assets/slide-14.png "Java Output - println vs print")

```java
System.out.println("Hello World"); // Prints with newline
System.out.print("Hello ");        // Prints on same line
System.out.print("World!");        // Continues on same line
```

---

## 7. Java Comments

![Slide 15 - Single-line Comment](./assets/slide-15.png "Single-line comment")
![Slide 16 - Multi-line Comment](./assets/slide-16.png "Multi-line comment")

```java
// Single-line comment

/*
  Multi-line comment
  spans multiple lines
*/

/**
 * Javadoc documentation comment
 */
```

---

## 8. Java Variables

![Slide 17 - Variable Definition](./assets/slide-17.png "Variable Definition")
![Slide 18 - Variable Syntax](./assets/slide-18.png "Variable Declaration Syntax")
![Slide 19 - Naming Rules](./assets/slide-19.png "Naming Rules & Identifiers")
![Slide 20 - Variable Example](./assets/slide-20.png "Variable Examples")
![Slide 21 - Variable Reassignment](./assets/slide-21.png "Variable Reassignment")
![Slide 22 - Final Variables](./assets/slide-22.png "Final Constants")
![Slide 23 - Multiple Variables](./assets/slide-23.png "Multiple Variable Declaration")
![Slide 24 - Display Variables](./assets/slide-24.png "Display Variables")

```java
String name = "Dara";
final double PI = 3.14159; // Constant (immutable)
int x = 5, y = 10, z = 15;
System.out.println("Hello " + name);
```

---

## 9. Java Data Types

![Slide 25 - Data Types Overview](./assets/slide-25.png "Data Types Overview")
![Slide 26 - Primitive Types Table](./assets/slide-26.png "Primitive Data Types")
![Slide 27 - Integer Types: byte & short](./assets/slide-27.png "byte & short")
![Slide 28 - Integer Types: int & long](./assets/slide-28.png "int & long")
![Slide 29 - Floating Point: float & double](./assets/slide-29.png "float & double")
![Slide 30 - Scientific Numbers](./assets/slide-30.png "Scientific numbers e/E")
![Slide 31 - Booleans](./assets/slide-31.png "boolean: true / false")
![Slide 32 - Characters](./assets/slide-32.png "char & ASCII")
![Slide 33 - Strings](./assets/slide-33.png "String reference type")
![Slide 34 - Full Data Types Example](./assets/slide-34.png "Complete Data Types Code")

---

## 10. Java Type Casting

![Slide 35 - Type Casting Concept](./assets/slide-35.png "Type Casting Concept")
![Slide 36 - Widening Casting](./assets/slide-36.png "Widening Casting")
![Slide 37 - Narrowing Casting](./assets/slide-37.png "Narrowing Casting")
![Slide 38 - Calculation Example](./assets/slide-38.png "Real-life Casting Example")

```java
// Widening (Automatic): byte -> short -> char -> int -> long -> float -> double
int myInt = 9;
double myDouble = myInt; // 9.0

// Narrowing (Manual): double -> float -> long -> int -> char -> short -> byte
double d = 9.78;
int i = (int) d; // 9
```

---

## 11. Java User Input

![Slide 39 - Scanner Class](./assets/slide-39.png "Scanner Class")
![Slide 40 - Scanner Methods](./assets/slide-40.png "Scanner Methods")
![Slide 41 - String Input](./assets/slide-41.png "nextLine()")
![Slide 42 - Integer Input](./assets/slide-42.png "nextInt()")
![Slide 43 - Double Input](./assets/slide-43.png "nextDouble()")
![Slide 44 - Float Input](./assets/slide-44.png "nextFloat()")
![Slide 45 - Boolean Input](./assets/slide-45.png "nextBoolean()")
![Slide 46 - Complete Profile Input](./assets/slide-46.png "Complete Input Example")
![Slide 47 - Multi-type Input](./assets/slide-47.png "Multi-input Handling")

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Username: " + userName + ", Age: " + age);
    }
}
```

---

## 12. Java Operators

![Slide 48 - Operators Overview](./assets/slide-48.png "Operators Overview")
![Slide 49 - Arithmetic Operators](./assets/slide-49.png "Arithmetic Operators")
![Slide 50 - Arithmetic Example](./assets/slide-50.png "Arithmetic Example")
![Slide 51 - Increment & Decrement](./assets/slide-51.png "++ and --")
![Slide 52 - Comparison Operators](./assets/slide-52.png "Comparison Operators")
![Slide 53 - Assignment Operators](./assets/slide-53.png "Assignment Operators")

---

## 13. Java Mathematics

![Slide 54 - Math Class](./assets/slide-54.png "Math Class")
![Slide 55 - Common Math Methods](./assets/slide-55.png "Math Methods")
![Slide 56 - Math.max & Math.min](./assets/slide-56.png "max & min")
![Slide 57 - Math.sqrt](./assets/slide-57.png "sqrt")
![Slide 58 - Math.abs](./assets/slide-58.png "abs")
![Slide 59 - Math.random](./assets/slide-59.png "random")

```java
Math.max(5, 10);     // 10
Math.min(5, 10);     // 5
Math.sqrt(64);       // 8.0
Math.abs(-4.7);      // 4.7
int randomNum = (int)(Math.random() * 101); // 0 to 100
```

---

## 14. Java Strings

![Slide 60 - Strings Overview](./assets/slide-60.png "Strings Overview")
![Slide 61 - String length()](./assets/slide-61.png "length()")
![Slide 62 - Case Methods](./assets/slide-62.png "toUpperCase & toLowerCase")
![Slide 63 - indexOf()](./assets/slide-63.png "indexOf()")
![Slide 64 - Concatenation](./assets/slide-64.png "Concatenation")
![Slide 65 - Escape Characters](./assets/slide-65.png "Escape Characters")

---

## 15. Java If...Else

![Slide 66 - If Conditions](./assets/slide-66.png "If Conditions")
![Slide 67 - If Else Syntax](./assets/slide-67.png "If Else Syntax")
![Slide 68 - Simple If Example](./assets/slide-68.png "Simple If")
![Slide 69 - If Else Example](./assets/slide-69.png "If Else")
![Slide 70 - If Else If Example](./assets/slide-70.png "If Else If")
![Slide 71 - Ternary Operator](./assets/slide-71.png "Ternary Operator")

---

## 16. Java Switch Statement

![Slide 72 - Switch Statement](./assets/slide-72.png "Switch Statement")
![Slide 73 - Break & Default](./assets/slide-73.png "break & default")
![Slide 74 - Days of Week Example](./assets/slide-74.png "Switch Days Example")
![Slide 75 - Switch with Default](./assets/slide-75.png "Switch with Default")
![Slide 76 - Multiple Cases Block](./assets/slide-76.png "Multiple Cases")

---

## 17. Java Loops

![Slide 77 - Loops Overview](./assets/slide-77.png "Loops Overview")
![Slide 78 - While Loop](./assets/slide-78.png "While Loop")
![Slide 79 - Do-While Loop](./assets/slide-79.png "Do-While Loop")
![Slide 80 - For Loop Syntax](./assets/slide-80.png "For Loop Syntax")
![Slide 81 - While Example](./assets/slide-81.png "While Loop Example")
![Slide 82 - Do-While Example](./assets/slide-82.png "Do-While Loop Example")
![Slide 83 - For Loop Example](./assets/slide-83.png "For Loop Example")

---

## 18. Java Arrays

![Slide 84 - Array Overview](./assets/slide-84.png "Array Overview")
![Slide 85 - Access & Length](./assets/slide-85.png "Access & Length")
![Slide 86 - Loop Through Array](./assets/slide-86.png "Loop Arrays")
![Slide 87 - Multidimensional Arrays](./assets/slide-87.png "2D Multidimensional Arrays")

---

## 🎯 Related Resources
- 📖 [Core Java Curriculum (Full 18 Lessons)](../../../01-books-and-handbooks/05-java-and-spring/01-course-curriculum/01-basic-java/README.md)
- 💼 [Java & Spring Interview Handbook](../../../01-books-and-handbooks/05-java-and-spring/02-interview-handbook/README.md)
