# មេរៀនទី ២៖ Java Class និង Object (Java Classes and Objects)

### 🖥️ ស្លាយទី 03 ｜ Slide 03

> ## 📌 Class និង Objects នៅក្នុង OOP
> 
> ---
>
> ### ➤ Class និង Objects នៅក្នុង OOP
> - **Classes** និង **Objects** គឺចំណុចពីរដ៏សំខាន់នៅក្នុង OOP។ ដែល **Class** គឺជា user defined type ឬការប្រមូលផ្តុំនៃ data variable និងអនុគមន៍ដែលគេរៀបចំឡើង ដើម្បីបង្កើតបានជាវត្ថុ Object អ្វីមួយ។
> - រីឯ **Object** វិញគឺជាការបង្កើតបាននូវវត្ថុរូបជាក់ស្តែងចេញមកពី Class។
>
> | Class | Objects |
> | :--- | :--- |
> | **Fruit** | Apple, Banana, Mango |
> | **Car** | Volvo, BMW, Ford, Mazda |

---

### 🖥️ ស្លាយទី 04 ｜ Slide 04

> ## 📌 ការបង្កើត Class ក្នុង Java
> 
> ---
>
> ### Create a Class
> ដើម្បីបង្កើត Class យើងប្រើប្រាស់ពាក្យគន្លឹះ (keyword) `class`:
>
> `Main.java`: បង្កើត Class មួយឈ្មោះថា `Main` ជាមួយ attribute `x`:
> ```java
> public class Main {
>     int x = 5;
> }
> ```

---

### 🖥️ ស្លាយទី 05 ｜ Slide 05

> ## 📌 ការបង្កើត Object ចេញពី Class
> 
> ---
>
> ### Create an Object
> នៅក្នុងភាសា Java, Object មួយត្រូវបានបង្កើតឡើងចេញពី Class។ ដើម្បីបង្កើត Object នៃ Main យើងបញ្ជាក់ឈ្មោះ Class បន្ទាប់មកឈ្មោះ Object និងប្រើប្រាស់ keyword `new`:
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

### 🖥️ ស្លាយទី 06 ｜ Slide 06

> ## 📌 ការបង្កើត Objects ច្រើនចេញពី Class តែមួយ
> 
> ---
>
> ### Create Multiple Objects
> យើងអាចបង្កើត Objects ជាច្រើនចេញពី Class តែមួយបាន:
>
> ```java
> public class Main {
>     int x = 5;
>
>     public static void main(String[] args) {
>         Main myObj1 = new Main(); // Object 1
>         Main myObj2 = new Main(); // Object 2
>         System.out.println(myObj1.x);
>         System.out.println(myObj2.x);
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 07 ｜ Slide 07

> ## 📌 ការប្រើប្រាស់ Multiple Classes ក្នុង Java
> 
> ---
>
> ### Using Multiple Classes
> យើងអាចបំបែក Class ទៅតាម file ផ្សេងៗគ្នាបាន ដើម្បីឱ្យកូដមានរបៀបរៀបរយ:
>
> `Main.java`:
> ```java
> public class Main {
>     int x = 5;
> }
> ```
>
> `Second.java`:
> ```java
> class Second {
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         System.out.println(myObj.x);
>     }
> }
> ```

---

← [មេរៀនមុន](../01-oop-introduction/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../03-class-attributes/README.md) →
