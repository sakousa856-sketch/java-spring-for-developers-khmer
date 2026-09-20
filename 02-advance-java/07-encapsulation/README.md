# មេរៀនទី ៧៖ Java Encapsulation (ការវេចខ្ចប់ទិន្នន័យ)

### 🖥️ ស្លាយទី 31 ｜ Slide 31

> ## 📌 Encapsulation នៅក្នុង Class
> 
> ---
>
> ### ➤ Encapsulation នៅក្នុង Class
> **Encapsulation** ប្រើសម្រាប់ `get` ឬ `set` តម្លៃរបស់ attributes ដែលមាន modifier ជា `private`។ 
> មូលហេតុដែលប្រើប្រាស់វា៖
> - ជាជម្រើសដ៏ល្អបំផុតក្នុងការគ្រប់គ្រង attributes និង methods របស់ Class។
> - ងាយស្រួលបែងចែកនៅពេលដែលចង់ទាញយកតម្លៃ (getter) និងកំណត់តម្លៃ (setter)។
> - ផ្ដល់ភាពបត់បែនខ្ពស់សម្រាប់អ្នកសរសេរកូដ ដោយសារតែអាចធ្វើការផ្លាស់ប្តូរផ្នែកមួយនៃកូដដោយមិនខ្លាចប៉ះពាល់ទៅលើផ្នែកផ្សេង។
> - ធ្វើឱ្យទិន្នន័យមានសុវត្ថិភាពខ្ពស់ (Data Hiding)។

---

### 🖥️ ស្លាយទី 32 ｜ Slide 32

> ## 📌 ការប្រើ Getter និង Setter
> 
> ---
>
> ### Get and Set:
> ```java
> public class Person {
>     private String name; // private = restricted access
>
>     // Getter
>     public String getName() {
>         return name;
>     }
>
>     // Setter
>     public void setName(String newName) {
>         this.name = newName;
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 33 ｜ Slide 33

> ## 📌 កំហុសនៅពេល access ទៅ attribute private ដោយផ្ទាល់
> 
> ---
>
> ### Error:
> ប្រសិនបើយើងព្យាយាម access ទៅ attribute ដែលជា `private` ដោយផ្ទាល់ វានឹងចេញ Error ភ្លាមៗ:
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Person myObj = new Person();
>         myObj.name = "John"; // error: name has private access in Person
>         System.out.println(myObj.name); // error
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 34 ｜ Slide 34

> ## 📌 ការប្រើប្រាស់ Get និង Set ត្រឹមត្រូវ
> 
> ---
>
> ### Using Get and Set instead of Access Direct:
> ដើម្បីកែប្រែ ឬអានតម្លៃ attribute ជា private យើងត្រូវប្រើ getter និង setter:
>
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Person myObj = new Person();
>         myObj.setName("John"); // Set the value of the name variable to "John"
>         System.out.println(myObj.getName()); // Outputs "John"
>     }
> }
> ```

---

← [មេរៀនមុន](../06-modifiers/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../08-packages/README.md) →
