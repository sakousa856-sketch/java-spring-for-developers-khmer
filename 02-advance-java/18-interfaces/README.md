# មេរៀនទី ១៨៖ Java Interface (ចំណុចប្រទាក់)

### 🖥️ ស្លាយទី 89 ｜ Slide 89

> ## 📌 និយមន័យនៃ Interface
> 
> ---
>
> ### ➤ Interface នៅក្នុង Class
> **Interface** គឺប្រើដើម្បីសម្រេចបាននូវ Abstraction ពេញលេញ (100% Abstraction) ក្នុង Java:
> - នៅក្នុង Interface គឺអាចផ្ទុកបានតែ **abstract methods** និង **attributes** តែប៉ុណ្ណោះ។
> - សម្រាប់ methods បើសិនជាយើងមិនដាក់អ្វីនៅពីមុខទេ វានឹងប្រើ keyword default គឺ `public` និង `abstract`។
> - សម្រាប់ attributes គឺដូចគ្នាដែរ វានឹងប្រើ keyword default គឺ `public`, `static` និង `final`។

---

### 🖥️ ស្លាយទី 90 ｜ Slide 90

> ## 📌 គោលការណ៍នៃ Interface
> 
> ---
>
> ### លក្ខណៈសម្បត្តិរបស់ Interface:
> - សម្រាប់ methods ដែលជាប្រភេទ abstract methods គឺត្រូវតែ `implemented` ទៅប្រើទាំងអស់នៅក្នុង Sub Class។
> - វាអាចមាន abstract methods និង regular methods (default methods) និង attributes ធម្មតា។
> - វាមិនអាចមាន constructors នោះទេ។
> - វាអាចជួយឱ្យ Sub Class អាច `implements` ចេញពី Interface បានច្រើន (Multiple Inheritance)។

---

### 🖥️ ស្លាយទី 91 ｜ Slide 91

> ## 📌 គំរូកូដ Interface Animal
> 
> ---
>
> ### Example: Interface Implementation
> ```java
> // Interface
> interface Animal {
>     public void animalSound(); // interface method (does not have a body)
>     public void sleep();       // interface method (does not have a body)
> }
>
> // Pig "implements" the Animal interface
> class Pig implements Animal {
>     public void animalSound() {
>         // The body of animalSound() is provided here
>         System.out.println("The pig says: wee wee");
>     }
>
>     public void sleep() {
>         // The body of sleep() is provided here
>         System.out.println("Zzz");
>     }
> }
>
> class Main {
>     public static void main(String[] args) {
>         Pig myPig = new Pig(); // Create a Pig object
>         myPig.animalSound();
>         myPig.sleep();
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 92 ｜ Slide 92

> ## 📌 ការប្រើ Multiple Interfaces ក្នុង Java
> 
> ---
>
> ### Multiple Interfaces
> ដើម្បី implement interfaces ច្រើន យើងបំបែកវាដោយប្រើសញ្ញាក្បៀស (`,`) :
>
> ```java
> interface FirstInterface {
>     public void myMethod(); // interface method
> }
>
> interface SecondInterface {
>     public void myOtherMethod(); // interface method
> }
>
> class DemoClass implements FirstInterface, SecondInterface {
>     public void myMethod() {
>         System.out.println("Some text..");
>     }
>
>     public void myOtherMethod() {
>         System.out.println("Some other text...");
>     }
> }
>
> class Main {
>     public static void main(String[] args) {
>         DemoClass myObj = new DemoClass();
>         myObj.myMethod();
>         myObj.myOtherMethod();
>     }
> }
> ```

---

← [មេរៀនមុន](../17-abstraction/README.md) | [មាតិការួម](../README.md) | បញ្ចប់ →
