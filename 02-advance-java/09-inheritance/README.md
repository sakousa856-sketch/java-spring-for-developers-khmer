# មេរៀនទី ៩៖ Java Inheritance (ការទទួលមរតក)

### 🖥️ ស្លាយទី 41 ｜ Slide 41

> ## 📌 សេចក្តីផ្តើមអំពី Java Inheritance
> 
> ---
>
> ### ➤ Inheritance នៅក្នុង Class
> **Inheritance** គឺជាផ្នែកមួយនៃ OOP ដែលអនុញ្ញាតឱ្យមានការបង្កើត Class ថ្មីចេញមកពី Class ដែលមានស្រាប់។ 
> - Class ដែលមានរួចស្រេចគេហៅថា: **Base Class** ឬ **Parent Class** ឬ **Super Class**។
> - Class ដែលបង្កើតថ្មីត្រូវបានគេហៅថា: **Derived Class** ឬ **Child Class** ឬ **Sub Class**។
>
> Inheritance គឺមកពីពាក្យ Inherit ដែលមានន័យថា Class មានស្រាប់ផ្ដល់មរតកមក Class ថ្មី។ មូលហេតុដែលយើងប្រើវាគឺដោយសារតែវាអាចកាត់បន្ថយការសរសេរកូដ ដោយយើងអាចប្រើ attributes និង methods ដែលមានក្នុង Super Class បាន។

---

### 🖥️ ស្លាយទី 42 ｜ Slide 42

> ## 📌 សារប្រយោជន៍នៃការប្រើប្រាស់ Inheritance
> 
> ---
>
> ### ➤ សារប្រយោជន៍នៃការប្រើប្រាស់ Inheritance:
> - ប្រើប្រាស់សមត្ថភាពរបស់កូដឡើងវិញដោយពុំចាំបាច់ត្រូវសរសេរម្តងទៀត (Code Reusability)
> - បង្កើនជំនឿចិត្តនៅលើកូដដោយមិនចាំបាច់បារម្ភអំពីកំហុស logic
> - អនុញ្ញាតឱ្យ Class ថ្មីប្រើប្រាស់ attributes និង methods ឡើងវិញពី Super Class
> - អនុញ្ញាតឱ្យ implement ក្នុង Class ថ្មី បើសិនត្រូវការ (អាចបន្ថែម attributes និង methods ថែមបាន)
> - ងាយស្រួលគ្រប់គ្រងនិងពង្រីកកូដទៅមុខ
>
> ---
>
> ### ឧទាហរណ៍គ្រឹះនៃ Inheritance (Fruit និង Apple):

---

### 🖥️ ស្លាយទី 43 ｜ Slide 43

> ## 📌 Super Class Fruit.java
> 
> ---
>
> `Fruit.java` (Super class):
> ```java
> // Super class
> public class Fruit {
>     // define attributes
>     protected String name;
>     protected Double price;
> }
> ```

---

### 🖥️ ស្លាយទី 44 ｜ Slide 44

> ## 📌 Sub Class Apple.java
> 
> ---
>
> `Apple.java` (Sub class):
> ```java
> // Sub class
> public class Apple extends Fruit {
>     // implement method
>     public void output() {
>         System.out.println("Fruit name: " + name + " and price: $" + price);
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 45 ｜ Slide 45

> ## 📌 Main.java Class
> 
> ---
>
> `Main.java`:
> ```java
> public class Main {
>     public static void main(String[] args) {
>         // create an object
>         Apple apple = new Apple();
>         // add values to attribute of object
>         apple.name = "Apple";
>         apple.price = 1.0;
>         // output
>         apple.output();
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 46 ｜ Slide 46

> ## 📌 The final Keyword លើ Class
> 
> ---
>
> ### The final Keyword
> ប្រសិនបើយើងមិនចង់ឱ្យ Class ណាមួយត្រូវបាន inherit ទៅឱ្យគេទេ យើងត្រូវប្រើពាក្យគន្លឹះ `final`:
> ```java
> final class Vehicle {
>     ...
> }
>
> class Car extends Vehicle { // Error: cannot inherit from final Vehicle
>     ...
> }
> ```

---

### 🖥️ ស្លាយទី 47 ｜ Slide 47

> ## 📌 ប្រភេទនៃ Inheritance ទាំង ៥
> 
> ---
>
> ### ➤ ប្រភេទរបស់ Inheritance (Types of Inheritance)
> Inheritance នៅក្នុង OOP មាន ៥ ប្រភេទ:
> 1. **Single Inheritance**
> 2. **Multiple Inheritance** (តាមរយៈ Interface ក្នុង Java)
> 3. **Multilevel Inheritance**
> 4. **Hierarchical Inheritance**
> 5. **Hybrid Inheritance**
>
> ---
>
> ### ១. Single Inheritance
> Derived Class មួយ inherited ចេញពី Base Class តែមួយ:

---

### 🖥️ ស្លាយទី 48 ｜ Slide 48

> ## 📌 ដ្យាក្រាម Single Inheritance
> 
> ---
>
> ```
> [A : Super Class]
>        ↑
> [B : Sub Class]
> ```
>
> - `Fruit.java`:
> ```java
> // Super class
> public class Fruit {
>     protected String name;
>     protected Double price;
> }
> ```
> - `Banana.java`:
> ```java
> // Sub class
> public class Banana extends Fruit {
>     public void output() {
>         System.out.println("Fruit name: " + name + " and price: $" + price);
>     }
> }
> ```
> - `Main.java`:
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Banana banna = new Banana();
>         banna.name = "Banna";
>         banna.price = 0.5;
>         banna.output();
>     }
> }
> ```
>
> ---
>
> ### ២. Multiple Inheritance
> Derived Class មួយ inherited ចេញពី Base Class (Interfaces) ច្រើន:

---

### 🖥️ ស្លាយទី 52 ｜ Slide 52

> ## 📌 ដ្យាក្រាម Multiple Inheritance
> 
> ---
>
> ```
> [Super Class A]   [Super Class B]
>        ↑                 ↑
>        └────────┬────────┘
>           [Sub Class C]
> ```
>
> - `FruitName.java`:
> ```java
> public interface FruitName {
>     public void printFruitName();
> }
> ```
> - `FruitPrice.java`:
> ```java
> public interface FruitPrice {
>     public void printFruitPrice();
> }
> ```
> - `Apple.java`:
> ```java
> public class Apple implements FruitName, FruitPrice {
>     @Override
>     public void printFruitName() {
>         System.out.println("Fruit name: Apple");
>     }
>
>     @Override
>     public void printFruitPrice() {
>         System.out.println("Fruit price: $1.0");
>     }
> }
> ```
>
> ---
>
> ### ៣. Multilevel Inheritance
> Derived Class មួយ inherited ចេញពី Derived Class មួយទៀត ដែលមាន Base Class តែមួយគត់:

---

### 🖥️ ស្លាយទី 56 ｜ Slide 56

> ## 📌 ដ្យាក្រាម Multilevel Inheritance
> 
> ---
>
> ```
> [A : Super Class]
>        ↑
> [B : Other Sub Class]
>        ↑
> [C : Sub Class]
> ```
>
> - `Fruit.java` (Super Class)
> - `Juice.java` extends Fruit (Sub Class)
> - `Apple.java` extends Juice (Sub Class)
> - `Main.java`:
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Apple apple = new Apple();
>         apple.setName("Apple");
>         apple.setPrice(1.0);
>         apple.setFlavors("Sweet and sour");
>         apple.output();
>     }
> }
> ```
>
> ---
>
> ### ៤. Hierarchical Inheritance
> Derived Class ច្រើន inherited ចេញពី Base Class តែមួយ:

---

### 🖥️ ស្លាយទី 62 ｜ Slide 62

> ## 📌 ដ្យាក្រាម Hierarchical Inheritance
> 
> ---
>
> ```
>          [A : Super Class]
>        ┌────────┼────────┐
>        ↑        ↑        ↑
>      [Sub B]  [Sub C]  [Sub D]
> ```
>
> - `Fruit.java` (Super class)
> - `Apple.java` extends Fruit
> - `Banana.java` extends Fruit
> - `Orange.java` extends Fruit
> - `Main.java` បង្កើត objects និងប្រើប្រាស់ outputs រួមគ្នា។
>
> ---
>
> ### ៥. Hybrid Inheritance
> គឺជាសំណុំ ឬបណ្តុំនៃ Inheritance ដែលរួមបញ្ចូលគ្នានូវប្រភេទ Inheritance ទាំងបួនខាងលើ (Single, Multiple, Multilevel, Hierarchical)។

---

### 🖥️ ស្លាយទី 67 ｜ Slide 67

> ## 📌 ដ្យាក្រាម Hybrid Inheritance
> 
> ---
>
>

---

← [មេរៀនមុន](../08-packages/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../10-this-keyword/README.md) →
