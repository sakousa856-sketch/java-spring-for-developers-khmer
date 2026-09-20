# មូលដ្ឋានគ្រឹះ Java (Basic Java Slides Presentation)

> 🎓 **កម្រងស្លាយមេរៀន Basic Java (៨៧ ស្លាយ)** សម្រាប់ការបង្រៀន ការធ្វើបទបង្ហាញ និងស្វ័យសិក្សាភាសា Java ចាប់ពីកម្រិតដំបូងរហូតដល់យល់ដឹងពីមូលដ្ឋានគ្រឹះរឹងមាំ។

[![Slides](https://img.shields.io/badge/Presentation-87%20Slides-blue.svg)](#-មាតិកាស្លាយមេរៀន-table-of-contents)
[![Language](https://img.shields.io/badge/Language-Khmer%20%28%E1%9E%81%E1%9F%82%E1%9E%98%E1%9E%94%E1%9E%97%E1%9E%B8%E1%9E%9F%E1%9E%B8%29-red.svg)](#)
[![Parent](https://img.shields.io/badge/Course-05--Java--and--Spring-orange.svg)](../../../01-books-and-handbooks/05-java-and-spring/README.md)

---

## 📑 មាតិកាស្លាយមេរៀន (Table of Contents)

- [១. ប្រវត្តិនៃ Java (History of Java)](#១-ប្រវត្តិនៃ-java-history-of-java) *(Slides 01 - 02)*
- [២. Version របស់ Java (Java Versions)](#២-version-របស់-java-java-versions) *(Slides 03 - 04)*
- [៣. លក្ខណៈរបស់ Java (Features of Java)](#៣-លក្ខណៈរបស់-java-features-of-java) *(Slides 05 - 09)*
- [៤. កម្មវិធីដំបូង (First Java Program)](#៤-កម្មវិធីដំបូង-first-java-program) *(Slides 10 - 11)*
- [៥. របៀបដំណើរការកូដ Java (How Java Works & Runs)](#៥-របៀបដំណើរការកូដ-java-how-java-works--runs) *(Slides 12 - 13)*
- [៦. Java Output & Print Methods](#៦-java-output--print-methods) *(Slide 14)*
- [៧. Java Comments (កំណត់សម្គាល់)](#៧-java-comments-កំណត់សម្គាល់) *(Slides 15 - 16)*
- [៨. Java Variables (អថេរក្នុង Java)](#៨-java-variables-អថេរក្នុង-java) *(Slides 17 - 24)*
- [៩. Java Data Types (ប្រភេទតម្លៃទិន្នន័យ)](#៩-java-data-types-ប្រភេទតម្លៃទិន្នន័យ) *(Slides 25 - 34)*
- [១០. Java Type Casting (ការបំប្លែងប្រភេទតម្លៃ)](#១០-java-type-casting-ការបំប្លែងប្រភេទតម្លៃ) *(Slides 35 - 38)*
- [១១. Java User Input (ការទទួលទិន្នន័យពី Keyboard)](#១១-java-user-input-ការទទួលទិន្នន័យពី-keyboard) *(Slides 39 - 47)*
- [១២. Java Operators (ប្រមាណវិធីក្នុង Java)](#១២-java-operators-ប្រមាណវិធីក្នុង-java) *(Slides 48 - 53)*
- [១៣. Java Mathematics (Math Class)](#១៣-java-mathematics-math-class) *(Slides 54 - 59)*
- [១៤. Java Strings (ខ្សែអក្សរ)](#១៤-java-strings-ខ្សែអក្សរ) *(Slides 60 - 65)*
- [១៥. Java If...Else (លក្ខខណ្ឌសម្រេចចិត្ត)](#១៥-java-ifelse-លក្ខខណ្ឌសម្រេចចិត្ត) *(Slides 66 - 71)*
- [១៦. Java Switch Statement](#១៦-java-switch-statement) *(Slides 72 - 76)*
- [១៧. Java Loops (រង្វិលជុំ)](#១៧-java-loops-រង្វិលជុំ) *(Slides 77 - 83)*
- [១៨. Java Arrays (អារេ)](#១៨-java-arrays-អារេ) *(Slides 84 - 87)*

---

## ១. ប្រវត្តិនៃ Java (History of Java)

![Slide 01 - ប្រវត្តិនៃ Java](./assets/slide-01.png "ប្រវត្តិនៃ Java - Green Project និងលោក James Gosling")

### សង្ខេបស្លាយទី ១៖
- **Java** ត្រូវបានបង្កើតឡើងដោយលោក **James Gosling** នៅក្រុមហ៊ុន **Sun Microsystems** ក្នុងគម្រោងស្រាវជ្រាវឈ្មោះ **Green Project** ក្នុងឆ្នាំ **១៩៩១**។
- គម្រោងនេះឈរលើមូលដ្ឋានគ្រឹះនៃភាសា C និង C++។ ដំបូងឡើយមានឈ្មោះថា **Oak** (យកតាមឈ្មោះដើម Oak ដែលលោក James Gosling ឃើញតាមបង្អួចការិយាល័យរបស់គាត់)។
- ក្រោយមកឈ្មោះនេះត្រូវបានប្តូរទៅជា **Java** តាមការស្នើសុំរបស់មិត្តរួមការងារ បន្ទាប់ពីពួកគាត់បានចេញពីហាងកាហ្វេ។

![Slide 02 - ប្រវត្តិនៃ Java និង World Wide Web](./assets/slide-02.png "ប្រវត្តិនៃ Java - របកគំហើញជាមួយ World Wide Web")

### សង្ខេបស្លាយទី ២៖
- ដំបូងឡើយការងាររបស់ Green Project ជួបការលំបាកខ្លាំងរហូតដល់សឹងតែដួលរលំ។
- ប៉ុន្តែនៅឆ្នាំ **១៩៩៣** បណ្តាញ **World Wide Web (WWW)** បានលេចធ្លោឡើង ដែលធ្វើឱ្យក្រុមការងារ Sun មើលឃើញពីអានុភាពនៃការប្រើ Java ក្នុងការបង្កើត Web Page ដែលធ្វើឱ្យគម្រោងនេះដំណើរការរស់ឡើងវិញយ៉ាងខ្លាំងក្លា។

---

## ២. Version របស់ Java (Java Versions)

![Slide 03 - Version របស់ Java (1.0 & 1.1)](./assets/slide-03.png "ការវិវត្តនៃ Java Version 1.0 និង 1.1")

### សង្ខេបស្លាយទី ៣៖
- **ឆ្នាំ ១៩៩៥:** ចេញផ្សាយ **Java 1.0** សម្រាប់ប្រើប្រាស់លើ World Wide Web (មាន ៨ Packages និង ២១២ Classes)។
- **ឆ្នាំ ១៩៩៧:** ចេញផ្សាយ **Java 1.1** ពង្រីកសមត្ថភាពបង្កើត User Interface, កែលម្អ Events, Inner Class, និង Swing package (កើនដល់ ២៣ Packages និង ៥០៤ Classes)។

![Slide 04 - Version របស់ Java (1.3, 1.4, 1.5, 1.6)](./assets/slide-04.png "ការវិវត្តនៃ Java Version 1.3 ដល់ 1.6")

### សង្ខេបស្លាយទី ៤៖
- **ឆ្នាំ ២០០០:** Java 1.3 បង្កើត HotSpot Virtual Machine (៧៦ Packages, ១៨៤២ Classes)។
- **ឆ្នាំ ២០០២:** Java 1.4 កែលម្អ I/O និង XML support (១៣៥ Packages, ២៩៩១ Classes)។
- **ឆ្នាំ ២០០៤:** Java 1.5 កែលម្អ Multithreading, Metadata/Annotations (១៦៥ Packages, ជាង ៣០០០ Classes)។
- បន្ទាប់មកទៀត Java 1.6 ត្រូវបានបង្កើតឡើងដោយមានរហូតដល់ ២០០ Packages។

---

## ៣. លក្ខណៈរបស់ Java (Features of Java)

![Slide 05 - លក្ខណៈរបស់ Java: Simple](./assets/slide-05.png "លក្ខណៈរបស់ Java - Simple")

### សង្ខេបស្លាយទី ៥៖
Java មានលក្ខណៈពិសេសចម្បងៗ៖ **Simple, Object Oriented, Statically Typed, Compiled and Interpreted, Architecture Neutral and Portable, Multithreaded, Garbage Collected, Robust, Secure, Built-in Networking & Extensible**។
- **Simple:** អ្នកបង្កើត Java បានកាត់បន្ថយ និងលុបចោលភាពស្មុគស្មាញដែលមិនចាំបាច់ក្នុង C/C++ ដូចជា គ្មាន Pointers ផ្ទាល់, គ្មាន Structures, Unions, Header files ឬ Multiple Inheritance ឡើយ។

![Slide 06 - លក្ខណៈរបស់ Java: OOP & Statically Typed](./assets/slide-06.png "លក្ខណៈរបស់ Java - Object Oriented & Statically Typed")

### សង្ខេបស្លាយទី ៦៖
- **Object Oriented:** ប្រើប្រាស់ Classes ដើម្បីរៀបចំ Code ឱ្យទៅជាសំណុំច្បាស់លាស់ និងបង្កើត Objects។
- **Statically Typed:** គ្រប់អថេរ និង Object ទាំងអស់ត្រូវតែប្រកាសប្រភេទតម្លៃ (Data Type) ឱ្យបានច្បាស់លាស់មុនពេលប្រើប្រាស់ ដែលជួយឱ្យ Compiler ចាប់កំហុសបានតាំងពីមុនពេលដំណើរការកូដ។

![Slide 07 - លក្ខណៈរបស់ Java: Compiled & Portable](./assets/slide-07.png "លក្ខណៈរបស់ Java - Compiled, Interpreted & Portable")

### សង្ខេបស្លាយទី ៧៖
- **Compiled and Interpreted:** កូដ Java ត្រូវបាន Compiler (`javac`) បំប្លែងទៅជា Bytecode (`.class`) រួច JVM ធ្វើការ Interpret ដំណើរការនៅលើម៉ាស៊ីនជាក់ស្តែង។
- **Architecture Neutral & Portable:** "Write Once, Run Anywhere" (WORA) កូដដែល Compile រួចអាចយកទៅ Run លើគ្រប់ Operating System ទាំងអស់ដែលមាន JVM។

![Slide 08 - លក្ខណៈរបស់ Java: Multithreaded & Garbage Collected](./assets/slide-08.png "លក្ខណៈរបស់ Java - Multithreaded & Garbage Collected")

### សង្ខេបស្លាយទី ៨៖
- **Multithreaded:** អនុញ្ញាតឱ្យកម្មវិធីអាចដំណើរការការងារច្រើនក្នុងពេលដំណាលគ្នា (Concurrent Execution)។
- **Garbage Collected:** Java មានប្រព័ន្ធគ្រប់គ្រង Memory ដោយស្វ័យប្រវត្តិ (Garbage Collector - GC) ដោយសម្អាត Memory ចោលចំពោះ Object ណាដែលលែងប្រើប្រាស់។

![Slide 09 - លក្ខណៈរបស់ Java: Robust & Secure](./assets/slide-09.png "លក្ខណៈរបស់ Java - Robust, Secure, Networking & Extensible")

### សង្ខេបស្លាយទី ៩៖
- **Robust:** មានយន្តការគ្រប់គ្រង Exception Handling រឹងមាំ ការពារប្រព័ន្ធកុំឱ្យគាំង។
- **Secure:** ដំណើរការក្នុង JVM Sandbox និងគ្មាន Pointer ចង្អុល Memory ដោយផ្ទាល់ ការពារពីមេរោគ និងការលួចទិន្នន័យ។
- **Built-in Networking & Extensible:** គាំទ្រ TCP/IP, HTTP ស្រាប់ និងអាចពង្រីកសមត្ថភាពបន្ថែមបានយ៉ាងទូលំទូលាយ។

---

## ៤. កម្មវិធីដំបូង (First Java Program)

![Slide 10 - កម្មវិធីដំបូង Java Example](./assets/slide-10.png "កម្មវិធីដំបូង Example.java")

### សង្ខេបស្លាយទី ១០៖
កូដគំរូនៃកម្មវិធី Java ដំបូងគេបង្អស់៖
```java
// This is the first example java program. Save file as "Example.java"
class Example {
    // A Java program begins with a call to main().
    public static void main(String[] args) {
        System.out.println("Java drives the Web.");
    }
}
```

![Slide 11 - ការពន្យល់រចនាសម្ព័ន្ធកូដដំបូង](./assets/slide-11.png "ការពន្យល់ Main Method និង System.out.println")

### សង្ខេបស្លាយទី ១១៖
- **`class Example`:** ប្រកាស Class ឈ្មោះ `Example` (ឈ្មោះ File ត្រូវតែដូចគ្នាគឺ `Example.java`)។
- **`public static void main(String[] args)`:** ចំណុចចាប់ផ្តើមដំបូងនៃកម្មវិធី (Entry Point)។
- **`System.out.println(...)`:** ពាក្យបញ្ជាបញ្ចេញអត្ថបទមកកាន់អេក្រង់ Console និងចុះបន្ទាត់ថ្មី។

---

## ៥. របៀបដំណើរការកូដ Java (How Java Works & Runs)

![Slide 12 - របៀបដំណើរការកូដ Java: Compile](./assets/slide-12.png "ការ Compile កូដដោយ javac")

### សង្ខេបស្លាយទី ១២៖
- សរសេរកូដក្នុង File `Example.java`។
- ប្រើ Command Line ដើម្បី Compile៖
  ```bash
  javac Example.java
  ```
- Compiler នឹងបង្កើត File ថ្មីមួយឈ្មោះ `Example.class` ដែលជា **Bytecode**។

![Slide 13 - របៀបដំណើរការកូដ Java: Run](./assets/slide-13.png "ការដំណើរការ Bytecode តាមរយៈ java")

### សង្ខេបស្លាយទី ១៣៖
- ប្រើ Command ដើម្បី Run នៅលើ Java Virtual Machine (JVM)៖
  ```bash
  java Example
  ```
- លទ្ធផលនឹងបង្ហាញលើអេក្រង់៖ `Java drives the Web.`

---

## ៦. Java Output & Print Methods

![Slide 14 - Java Output](./assets/slide-14.png "Java Output - println vs print")

### សង្ខេបស្លាយទី ១៤៖
- **`System.out.println()`:** បង្ហាញទិន្នន័យរួចចុះបន្ទាត់ថ្មី (New Line)។
- **`System.out.print()`:** បង្ហាញទិន្នន័យនៅលើបន្ទាត់ដដែល ដោយមិនចុះបន្ទាត់ឡើយ។

```java
System.out.println("Hello World"); // ចុះបន្ទាត់ថ្មី
System.out.print("Hello ");        // នៅបន្ទាត់ដដែល
System.out.print("Cambodia!");     // បន្តបន្ទាត់ដដែល
```

---

## ៧. Java Comments (កំណត់សម្គាល់)

![Slide 15 - Java Single-line Comment](./assets/slide-15.png "Java Comment - Single-line")

### សង្ខេបស្លាយទី ១៥៖
- **Single-line Comment (`//`):** ប្រើសម្រាប់កំណត់ចំណាំមួយបន្ទាត់។

```java
// នេះជា Single-line comment
int x = 10; // អថេរ x មានតម្លៃ 10
```

![Slide 16 - Java Multi-line Comment](./assets/slide-16.png "Java Comment - Multi-line")

### សង្ខេបស្លាយទី ១៦៖
- **Multi-line Comment (`/* ... */`):** ប្រើសម្រាប់កំណត់ចំណាំច្រើនបន្ទាត់។
- **Documentation Comment (`/** ... */`):** ប្រើសម្រាប់បង្កើតឯកសារ JavaDoc។

```java
/*
  នេះជា Multi-line comment
  អាចសរសេរបានច្រើនបន្ទាត់
*/
```

---

## ៨. Java Variables (អថេរក្នុង Java)

![Slide 17 - Java Variable និយមន័យ](./assets/slide-17.png "និយមន័យនៃ Java Variable")
![Slide 18 - Java Variable Syntax](./assets/slide-18.png "Syntax នៃការប្រកាស Variable")
![Slide 19 - Java Variable Naming Rules](./assets/slide-19.png "វិធាននៃការដាក់ឈ្មោះ Variable")
![Slide 20 - Java Variable Example](./assets/slide-20.png "ឧទាហរណ៍ជាក់ស្តែងនៃ Variable")
![Slide 21 - Java Variable Reassignment](./assets/slide-21.png "ការផ្លាស់ប្តូរតម្លៃ Variable")
![Slide 22 - Java Final Variables](./assets/slide-22.png "អថេរថេរ Final Constants")
![Slide 23 - Java Multiple Variables](./assets/slide-23.png "ការប្រកាសអថេរច្រើនក្នុងពេលតែមួយ")
![Slide 24 - Java Display Variables](./assets/slide-24.png "ការបង្ហាញតម្លៃអថេរជាមួយ System.out.println")

### សង្ខេបស្លាយទី ១៧ ដល់ ២៤៖
- **Syntax:** `type variableName = value;`
- **វិធានដាក់ឈ្មោះ:** ត្រូវចាប់ផ្តើមដោយអក្សរ, សញ្ញា `$`, ឬ `_` និងគាំទ្រទម្រង់ camelCase។ មិនអាចប្រើប្រាស់ Reserved Keywords របស់ Java ធ្វើជាឈ្មោះអថេរឡើយ។
- **Final Variables:** ប្រើពាក្យគន្លឹះ `final` ដើម្បីកំណត់តម្លៃថេរ (Constant) ដែលមិនអាចកែប្រែបាន។

```java
String name = "Dara";
final double PI = 3.14159; // មិនអាចកែប្រែបាន
int x = 5, y = 10, z = 15; // ប្រកាសច្រើនក្នុងពេលតែមួយ
System.out.println("Hello " + name);
```

---

## ៩. Java Data Types (ប្រភេទតម្លៃទិន្នន័យ)

![Slide 25 - Java Data Types Overview](./assets/slide-25.png "ទិដ្ឋភាពទូទៅនៃ Java Data Types")
![Slide 26 - Java Primitive Data Types Table](./assets/slide-26.png "តារាង Primitive Data Types ទាំង ៨")
![Slide 27 - Integer Types: byte & short](./assets/slide-27.png "ប្រភេទចំនួនគត់: byte និង short")
![Slide 28 - Integer Types: int & long](./assets/slide-28.png "ប្រភេទចំនួនគត់: int និង long")
![Slide 29 - Floating Point: float & double](./assets/slide-29.png "ប្រភេទចំនួនទសភាគ: float និង double")
![Slide 30 - Scientific Numbers](./assets/slide-30.png "លេខបែបវិទ្យាសាស្ត្រ e/E")
![Slide 31 - Boolean Data Type](./assets/slide-31.png "ប្រភេទ Boolean: true និង false")
![Slide 32 - Character Data Type](./assets/slide-32.png "ប្រភេទ Character: char និង ASCII")
![Slide 33 - String Data Type](./assets/slide-33.png "ប្រភេទខ្សែអក្សរ String")
![Slide 34 - Data Types Full Example](./assets/slide-34.png "កូដគំរូពេញលេញនៃ Data Types")

### សង្ខេបស្លាយទី ២៥ ដល់ ៣៤៖
| ប្រភេទ (Type) | ទំហំ (Size) | ដែនកំណត់តម្លៃ (Range) |
| :--- | :--- | :--- |
| `byte` | 1 byte | -128 ដល់ 127 |
| `short` | 2 bytes | -32,768 ដល់ 32,767 |
| `int` | 4 bytes | -2,147,483,648 ដល់ 2,147,483,647 |
| `long` | 8 bytes | -9 Quintillion ដល់ 9 Quintillion (បញ្ចប់ដោយ `L`) |
| `float` | 4 bytes | ៦ ទៅ ៧ ខ្ទង់ទសភាគ (បញ្ចប់ដោយ `f`) |
| `double` | 8 bytes | ១៥ ខ្ទង់ទសភាគ (បញ្ចប់ដោយ `d`) |
| `boolean` | 1 bit | `true` ឬ `false` |
| `char` | 2 bytes | តួអក្សរតែមួយគត់ (ឧ. `'A'`) ឬ ASCII |

---

## ១០. Java Type Casting (ការបំប្លែងប្រភេទតម្លៃ)

![Slide 35 - Type Casting Concept](./assets/slide-35.png "គំនិតនៃការធ្វើ Type Casting")
![Slide 36 - Widening Casting Example](./assets/slide-36.png "ឧទាហរណ៍ Widening Casting")
![Slide 37 - Narrowing Casting Example](./assets/slide-37.png "ឧទាហរណ៍ Narrowing Casting")
![Slide 38 - Real-life Type Casting Example](./assets/slide-38.png "ការគណនាជាក់ស្តែងជាមួយ Type Casting")

### សង្ខេបស្លាយទី ៣៥ ដល់ ៣៨៖
- **Widening Casting (ដោយស្វ័យប្រវត្តិ):** បំប្លែងពីតូចទៅធំ (`byte -> short -> char -> int -> long -> float -> double`)។

- **Narrowing Casting (ដោយផ្ទាល់ដៃ):** បំប្លែងពីធំមកតូច ត្រូវដាក់ឈ្មោះប្រភេទក្នុងវង់ក្រចក `(type)`។

```java
// Widening (Automatic)
int myInt = 9;
double myDouble = myInt; // 9.0

// Narrowing (Manual)
double d = 9.78;
int i = (int) d; // 9
```

---

## ១១. Java User Input (ការទទួលទិន្នន័យពី Keyboard)

![Slide 39 - Scanner Class Introduction](./assets/slide-39.png "Class Scanner សម្រាប់ទទួលទិន្នន័យ")
![Slide 40 - Scanner Input Methods](./assets/slide-40.png "Methods នៃ Class Scanner")
![Slide 41 - Input String with nextLine()](./assets/slide-41.png "ការទទួលអត្ថបទ String")
![Slide 42 - Input Integer with nextInt()](./assets/slide-42.png "ការទទួលលេខគត់ nextInt()")
![Slide 43 - Input Double with nextDouble()](./assets/slide-43.png "ការទទួលលេខទសភាគ nextDouble()")
![Slide 44 - Input Float with nextFloat()](./assets/slide-44.png "ការទទួល float nextFloat()")
![Slide 45 - Input Boolean with nextBoolean()](./assets/slide-45.png "ការទទួលតម្លៃ boolean")
![Slide 46 - Comprehensive Input Example](./assets/slide-46.png "ឧទាហរណ៍បញ្ចូលព័ត៌មានអ្នកប្រើប្រាស់")
![Slide 47 - Handling Multi-type Input](./assets/slide-47.png "ការបញ្ចូលទិន្នន័យចម្រុះ")

### សង្ខេបស្លាយទី ៣៩ ដល់ ៤៧៖
ប្រើប្រាស់ Class `java.util.Scanner` ដើម្បីទទួលទិន្នន័យពីអ្នកប្រើប្រាស់៖
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

---

## ១២. Java Operators (ប្រមាណវិធីក្នុង Java)

![Slide 48 - Operators Overview](./assets/slide-48.png "ប្រភេទប្រមាណវិធីក្នុង Java")
![Slide 49 - Arithmetic Operators](./assets/slide-49.png "ប្រមាណវិធីនព្វន្ធ Arithmetic")
![Slide 50 - Arithmetic Example Part 1](./assets/slide-50.png "ឧទាហរណ៍គណនានព្វន្ធ")
![Slide 51 - Increment & Decrement](./assets/slide-51.png "ប្រមាណវិធីបង្កើន និងបន្ថយ ++ --")
![Slide 52 - Comparison Operators](./assets/slide-52.png "ប្រមាណវិធីប្រៀបធៀប")
![Slide 53 - Assignment Operators](./assets/slide-53.png "ប្រមាណវិធីកំណត់តម្លៃ Assignment")

### សង្ខេបស្លាយទី ៤៨ ដល់ ៥៣៖
- **Arithmetic:** `+`, `-`, `*`, `/`, `%`, `++`, `--`
- **Comparison:** `==`, `!=`, `>`, `<`, `>=`, `<=`

- **Logical:** `&&` (AND), `||` (OR), `!` (NOT)
- **Assignment:** `=`, `+=`, `-=`, `*=`, `/=`, `%=`

---

## ១៣. Java Mathematics (Math Class)

![Slide 54 - Java Math Class Introduction](./assets/slide-54.png "Class Math ក្នុង java.lang")
![Slide 55 - Common Math Methods](./assets/slide-55.png "Methods សំខាន់ៗរបស់ Class Math")
![Slide 56 - Math.max() & Math.min()](./assets/slide-56.png "ឧទាហរណ៍ Math.max និង Math.min")
![Slide 57 - Math.sqrt()](./assets/slide-57.png "ឧទាហរណ៍ការរកឬសការេ Math.sqrt")
![Slide 58 - Math.abs()](./assets/slide-58.png "ឧទាហរណ៍តម្លៃដាច់ខាត Math.abs")
![Slide 59 - Math.random()](./assets/slide-59.png "ឧទាហរណ៍បង្កើតលេខចៃដន្យ Math.random")

### សង្ខេបស្លាយទី ៥៤ ដល់ ៥៩៖
```java
Math.max(5, 10);     // 10
Math.min(5, 10);     // 5
Math.sqrt(64);       // 8.0
Math.abs(-4.7);      // 4.7
int randomNum = (int)(Math.random() * 101); // 0 ដល់ 100
```

---

## ១៤. Java Strings (ខ្សែអក្សរ)

![Slide 60 - Java Strings Overview](./assets/slide-60.png "ទិដ្ឋភាពទូទៅនៃ String")
![Slide 61 - String length() Method](./assets/slide-61.png "វិធីរកប្រវែងអក្សរ length()")
![Slide 62 - toUpperCase() & toLowerCase()](./assets/slide-62.png "វិធីប្តូរតួអក្សរធំ និងតូច")
![Slide 63 - indexOf() Method](./assets/slide-63.png "វិធីស្វែងរកទីតាំងតួអក្សរ indexOf()")
![Slide 64 - String Concatenation](./assets/slide-64.png "ការភ្ជាប់អក្សរ + និង concat()")
![Slide 65 - Escape Characters](./assets/slide-65.png "តួអក្សរពិសេស Escape Characters")

### សង្ខេបស្លាយទី ៦០ ដល់ ៦៥៖
```java
String txt = "Hello World";
System.out.println(txt.length());        // 11
System.out.println(txt.toUpperCase());   // HELLO WORLD
System.out.println(txt.indexOf("World")); // 6
System.out.println("It's "Java"!");   // Escape Characters
```

---

## ១៥. Java If...Else (លក្ខខណ្ឌសម្រេចចិត្ត)

![Slide 66 - If Conditions Overview](./assets/slide-66.png "ទិដ្ឋភាពទូទៅនៃ If Conditions")
![Slide 67 - If Else Syntax](./assets/slide-67.png "Syntax នៃ If Else")
![Slide 68 - Simple If Example](./assets/slide-68.png "ឧទាហរណ៍ If ធម្មតា")
![Slide 69 - If Else Example](./assets/slide-69.png "ឧទាហរណ៍ If Else")
![Slide 70 - If Else If Example](./assets/slide-70.png "ឧទាហរណ៍ If Else If")
![Slide 71 - Short Hand Ternary Operator](./assets/slide-71.png "Ternary Operator ? :")

### សង្ខេបស្លាយទី ៦៦ ដល់ ៧១៖
```java
int time = 20;
// If...Else ធម្មតា
if (time < 18) {
    System.out.println("Good day.");
} else {
    System.out.println("Good evening.");
}

// Short-hand (Ternary Operator)
String result = (time < 18) ? "Good day." : "Good evening.";
System.out.println(result);
```

---

## ១៦. Java Switch Statement

![Slide 72 - Switch Statement Overview](./assets/slide-72.png "ទិដ្ឋភាពទូទៅនៃ Switch Statement")
![Slide 73 - Break & Default Keywords](./assets/slide-73.png "ពាក្យគន្លឹះ break និង default")
![Slide 74 - Switch Example: Days of Week](./assets/slide-74.png "ឧទាហរណ៍ Switch ថ្ងៃក្នុងសប្តាហ៍")
![Slide 75 - Switch with Default](./assets/slide-75.png "ឧទាហរណ៍ Switch ជាមួយ Default")
![Slide 76 - Multiple Cases Sharing Block](./assets/slide-76.png "ឧទាហរណ៍ Case ច្រើនប្រើ Block តែមួយ")

### សង្ខេបស្លាយទី ៧២ ដល់ ៧៦៖
```java
int day = 4;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    default:
        System.out.println("Looking forward to the Weekend");
}
```

---

## ១៧. Java Loops (រង្វិលជុំ)

![Slide 77 - Loops Overview](./assets/slide-77.png "ទិដ្ឋភាពទូទៅនៃ Loops ក្នុង Java")
![Slide 78 - While Loop Concept](./assets/slide-78.png "គោលការណ៍នៃ While Loop")
![Slide 79 - Do-While Loop Concept](./assets/slide-79.png "គោលការណ៍នៃ Do-While Loop")
![Slide 80 - For Loop Syntax](./assets/slide-80.png "Syntax នៃ For Loop")
![Slide 81 - While Loop Example](./assets/slide-81.png "ឧទាហរណ៍ While Loop")
![Slide 82 - Do-While Loop Example](./assets/slide-82.png "ឧទាហរណ៍ Do-While Loop")
![Slide 83 - For Loop Example](./assets/slide-83.png "ឧទាហរណ៍ For Loop")

### សង្ខេបស្លាយទី ៧៧ ដល់ ៨៣៖
```java
// While loop
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// Do-While loop (ដំណើរការយ៉ាងហោច ១ ដង)
int j = 0;
do {
    System.out.println(j);
    j++;
} while (j < 5);

// For loop
for (int k = 0; k < 5; k++) {
    System.out.println(k);
}
```

---

## ១៨. Java Arrays (អារេ)

![Slide 84 - Java Array Overview](./assets/slide-84.png "ទិដ្ឋភាពទូទៅនៃ Java Array")
![Slide 85 - Access & Length of Array](./assets/slide-85.png "ការទាញយកតម្លៃ និងប្រវែង Array")
![Slide 86 - Loop Through Array](./assets/slide-86.png "Loop កាត់ Array ដោយ For និង For-Each")
![Slide 87 - Multidimensional Arrays](./assets/slide-87.png "អារេពហុវិមាត្រ 2D Arrays")

### សង្ខេបស្លាយទី ៨៤ ដល់ ៨៧៖
```java
// 1D Array
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(cars[0]);       // Volvo
System.out.println(cars.length);   // 4

// For-Each loop
for (String car : cars) {
    System.out.println(car);
}

// 2D Multidimensional Array
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
System.out.println(myNumbers[1][2]); // 7
```

---

## 🎯 ការភ្ជាប់ទៅកាន់មេរៀនពាក់ព័ន្ធ (Related Resources)
- 📖 [Core Java Curriculum (១៨ ជំពូកពេញ)](../README.md)
- 💼 [Java & Spring Interview Handbook](https://github.com/sakousa856-sketch/java-spring-interview-handbook-khmer)
