# មេរៀនទី ៥៖ Java Constructor (កុងស្ត្រាក់ទ័រ)

### 🖥️ ស្លាយទី 20 ｜ Slide 20

> ## 📌 Constructor នៅក្នុង Class
> 
> ---
>
> ### ➤ Constructor នៅក្នុង Class
> - **Constructor** គឺជា Method ពិសេសដែលអនុវត្តសំរាប់ផ្ដើមចេញនូវតម្លៃរបស់ Object មួយដោយស្វ័យប្រវត្តិ។
> - Constructor **មានឈ្មោះដូចគ្នាទៅនឹង Class** ហើយ**ពុំមាន return type នោះទេ** (សូម្បីតែ `void` ក៏គ្មានដែរ)។
> - ផលប្រយោជន៍នៃការប្រើប្រាស់ Constructor គឺកំណត់តម្លៃចាប់ផ្តើមនៃ Attributes និងសំរាប់ផ្តល់តម្លៃទៅឱ្យ Object ពេលត្រូវបានបង្កើត។
>
> Constructor មានពីរប្រភេទគឺ:
> 1. **Default Constructor:** សំដៅទៅលើ Constructor ដែលពុំមានប៉ារ៉ាម៉ែត្រ (No-argument constructor)។
> 2. **Parameterized Constructor:** សំដៅទៅលើ Constructor ដែលមានទទួលប៉ារ៉ាម៉ែត្រ។

---

### 🖥️ ស្លាយទី 21 ｜ Slide 21

> ## 📌 Parameterized Constructor និងការបង្កើតស្វ័យប្រវត្តិ
> 
> ---
>
> - **Parameterized Constructor:** សំដៅទៅលើ Constructor ដែលមានប៉ារ៉ាម៉ែត្រ ក្នុងគោលបំណង set (កំណត់) តម្លៃចាប់ផ្តើមឱ្យ instance variables នៅពេលបង្កើត Object។
> - ❖ **បញ្ជាក់:** នៅក្នុងភាសា Java បើសិនជាយើងបង្កើត Class រួចរាល់ហើយ ហើយយើងមិនបានបង្កើត Constructor ណាមួយទេ នោះ Java វានឹងបង្កើតនូវ **Default Constructor** ដោយស្វ័យប្រវត្តិតែម្តង។

---

### 🖥️ ស្លាយទី 22 ｜ Slide 22

> ## 📌 គំរូ Default Constructor
> 
> ---
>
> ### Default Constructor:
> ```java
> // Create a Main class
> public class Main {
>     int x; // Create a class attribute
>
>     // Create a class constructor for the Main class
>     public Main() {
>         x = 5; // Set the initial value for the class attribute x
>     }
>
>     public static void main(String[] args) {
>         Main myObj = new Main(); // Create an object (This will call the constructor)
>         System.out.println(myObj.x); // Outputs 5
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 23 ｜ Slide 23

> ## 📌 គំរូ Parameterized Constructor
> 
> ---
>
> ### Parameterized Constructor:
> ```java
> public class Main {
>     int x;
>
>     public Main(int y) {
>         x = y;
>     }
>
>     public static void main(String[] args) {
>         Main myObj = new Main(5);
>         System.out.println(myObj.x); // Outputs 5
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 24 ｜ Slide 24

> ## 📌 គំរូ Parameterized Constructor មានប៉ារ៉ាម៉ែត្រច្រើន
> 
> ---
>
> ### Parameterized Constructor (Many Parameters):
> ```java
> public class Main {
>     int modelYear;
>     String modelName;
>
>     public Main(int year, String name) {
>         modelYear = year;
>         modelName = name;
>     }
>
>     public static void main(String[] args) {
>         Main myCar = new Main(1969, "Mustang");
>         System.out.println(myCar.modelYear + " " + myCar.modelName); // Outputs 1969 Mustang
>     }
> }
> ```

---

← [មេរៀនមុន](../04-class-methods/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../06-modifiers/README.md) →
