# មេរៀនទី ៣៖ Java Class Attributes (លក្ខណៈនៃ Class)

### 🖥️ ស្លាយទី 08 ｜ Slide 08

> ## 📌 Class Members នៅក្នុង Class
> 
> ---
>
> ### ➤ Class Members នៅក្នុង Class
> - Class Members នៅក្នុង Class មានពីរគឺ: **Attributes** និង **Methods**។
>   - **Attributes:** គឺជាអថេរ (variable) ធម្មតា គ្រាន់តែនៅក្នុង Class គេហៅវាថា attribute។
>   - **Methods:** គឺជាអនុគមន៍ (function) ធម្មតា គ្រាន់តែនៅក្នុង Class គេហៅវាថា method។
> - លើសពីនេះទៅទៀត យើងអាចធ្វើការទាញយកតម្លៃមកប្រើ ក៏ដូចជាអាចធ្វើការផ្លាស់ប្តូរតម្លៃដូចគ្នា។

---

### 🖥️ ស្លាយទី 09 ｜ Slide 09

> ## 📌 Java Class Attributes
> 
> ---
>
> ### Java Class Attributes
> អថេរដែលត្រូវបានប្រកាសនៅក្នុង Class គឺជា attributes របស់ Class នោះ:
>
> ```java
> public class Main {
>     int x = 5;
>     int y = 3;
> }
> ```

---

### 🖥️ ស្លាយទី 10 ｜ Slide 10

> ## 📌 Accessing Attributes តាម dot syntax
> 
> ---
>
> ### Accessing Attributes
> យើងអាច access ទៅកាន់ attributes ដោយការបង្កើត Object នៃ Class និងប្រើប្រាស់ dot syntax (`.`):
>
> ```java
> public class Main {
>     int x = 5;
>
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         System.out.println(myObj.x);
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 12 ｜ Slide 12

> ## 📌 ការកែប្រែ ឬ Override តម្លៃនៃ Attributes
> 
> ---
>
> ### Modify Attributes (Override Existing Values)
> យើងអាចកំណត់តម្លៃថ្មីទៅឱ្យ attribute របស់ object បាន:
>
> ```java
> public class Main {
>     int x = 10;
>
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         myObj.x = 25; // x ឥឡូវមានតម្លៃស្មើ 25
>         System.out.println(myObj.x);
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 13 ｜ Slide 13

> ## 📌 ការប្រើប្រាស់ final លើ Attributes
> 
> ---
>
> ### final Attribute
> បើសិនជាយើងមិនចង់ឱ្យគេអាចផ្លាស់ប្តូរ ឬកែប្រែតម្លៃ attribute បានទេ យើងត្រូវប្រកាសវាជា **`final`**:
>
> ```java
> public class Main {
>     final int x = 10;
>
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         myObj.x = 25; // Error: cannot assign a value to a final variable
>         System.out.println(myObj.x);
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 14 ｜ Slide 14

> ## 📌 Multiple Objects ជាមួយ Attributes ដាច់ដោយឡែកពីគ្នា
> 
> ---
>
> ### Multiple Objects
> ប្រសិនបើយើងបង្កើត Objects ច្រើនពី Class តែមួយ យើងអាចកែប្រែ attribute ក្នុង Object មួយដោយមិនប៉ះពាល់ដល់តម្លៃ attribute ក្នុង Object មួយទៀតឡើយ:
>
> ```java
> public class Main {
>     int x = 5;
>
>     public static void main(String[] args) {
>         Main myObj1 = new Main(); // Object 1
>         Main myObj2 = new Main(); // Object 2
>         myObj2.x = 25;
>         System.out.println(myObj1.x); // Outputs 5
>         System.out.println(myObj2.x); // Outputs 25
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 15 ｜ Slide 15

> ## 📌 ការកំណត់ Attributes ច្រើនក្នុង Class តែមួយ
> 
> ---
>
> ### Multiple Attributes
> យើងអាចកំណត់ attributes ច្រើនតាមដែលយើងត្រូវការ:
>
> ```java
> public class Main {
>     String fname = "John";
>     String lname = "Doe";
>     int age = 24;
>
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         System.out.println("Name: " + myObj.fname + " " + myObj.lname);
>         System.out.println("Age: " + myObj.age);
>     }
> }
> ```

---

← [មេរៀនមុន](../02-classes-and-objects/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../04-class-methods/README.md) →
