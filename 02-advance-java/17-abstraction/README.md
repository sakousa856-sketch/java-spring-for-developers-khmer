# មេរៀនទី ១៧៖ Java Abstraction (អរូបីកម្ម)

### 🖥️ ស្លាយទី 86 ｜ Slide 86

> ## 📌 និយមន័យនៃ Abstraction
> 
> ---
>
> ### ➤ Abstraction នៅក្នុង Class
> **Abstraction** គឺជាដំណើរការមួយដែលលាក់ព័ត៌មានលម្អិតជាក់លាក់ និងបង្ហាញតែព័ត៌មានចាំបាច់ដល់អ្នកប្រើប្រាស់។ នៅក្នុង Abstraction មាន Class មួយនិង Method មួយដែលយើងត្រូវសម្គាល់គឺ:
> - **Abstract Class:** គឺជា class មួយដែល**មិនអាចបង្កើត object បានទេ**។ បើសិនជាចង់ប្រើ abstract class យើងត្រូវ inherited វាទៅប្រើក្នុង class ផ្សេង។
> - **Abstract Method:** គឺប្រើបានតែនៅក្នុង abstract class តែប៉ុណ្ណោះ ហើយវាជា function ដែល**គ្មាន body ឡើយ** (គ្មាន `{ }`) ហើយ body គឺត្រូវបានសរសេរបន្ថែមនៅក្នុង subclass ដែលបាន inherit ទៅ។

---

### 🖥️ ស្លាយទី 87 ｜ Slide 87

> ## 📌 គោលការណ៍សំខាន់ៗនៃ Abstract Class
> 
> ---
>
> ### អ្វីដែលយើងគួរចងចាំ នៅពេលដែលយើងប្រើ Abstract Class គឺ:
> - វាតែងតែបង្កើតដោយផ្ដើមជាមួយនឹង keyword `abstract`។
> - វាអាចមានទាំង abstract methods និង regular methods (methods ធម្មតា) រួមបញ្ចូលគ្នាបាន។
> - វាអាចមាន attributes។
> - វាមិនអាច instantiated (បង្កើត object) បាននោះទេ។
> - វាអាចមាន constructors និង static methods។
> - វាអាចមាន final methods ដែលការពារកុំឱ្យ Sub Class អាចធ្វើការកែប្រែបាន។
> - នៅពេលដែល Sub Class ធ្វើការ `extends` abstract class យកទៅប្រើ គឺ**ត្រូវតែ implemented នូវរាល់ abstract methods ទាំងអស់**។

---

### 🖥️ ស្លាយទី 88 ｜ Slide 88

> ## 📌 គំរូកូដ Abstract Class Animal និង Pig
> 
> ---
>
> ### Example:
> ```java
> // Abstract class
> abstract class Animal {
>     // Abstract method (does not have a body)
>     public abstract void animalSound();
>
>     // Regular method
>     public void sleep() {
>         System.out.println("Zzz");
>     }
> }
>
> // Subclass (inherit from Animal)
> class Pig extends Animal {
>     // The body of animalSound() is provided here
>     public void animalSound() {
>         System.out.println("The pig says: wee wee");
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

← [មេរៀនមុន](../16-inner-classes/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../18-interfaces/README.md) →
