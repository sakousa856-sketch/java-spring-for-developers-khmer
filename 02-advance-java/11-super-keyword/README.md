# មេរៀនទី ១១៖ Java super Keyword (ពាក្យគន្លឹះ super)

### 🖥️ ស្លាយទី 70 ｜ Slide 70

> ## 📌 និយមន័យនៃ super Keyword
> 
> ---
>
> ### ពាក្យគន្លឹះ super ក្នុង Java
> នៅក្នុងភាសា Java សម្រាប់ keyword `super` គឺសំដៅទៅលើ objects នៃ superclass (parent)។
> - ជានិច្ចកាលយើងប្រើវាដើម្បីហៅនូវ methods របស់ superclass មកប្រើ។
> - ក៏អាចប្រើសម្រាប់ access នូវ constructor របស់ superclass ផងដែរ។
> - មួយទៀតគឺដើម្បីលុបបំបាត់នូវការភាន់ច្រឡំចំពោះ methods ដែលមានឈ្មោះដូចគ្នា ប៉ារ៉ាម៉ែត្រដូចគ្នា តែមួយជារបស់ superclass ហើយមួយទៀតគឺជារបស់ subclass។

---

### 🖥️ ស្លាយទី 71 ｜ Slide 71

> ## 📌 គំរូកូដប្រើប្រាស់ super Keyword
> 
> ---
>
> ### Example: Using super to call the superclass method
> ```java
> class Animal { // Superclass (parent)
>     public void animalSound() {
>         System.out.println("The animal makes a sound");
>     }
> }
>
> class Dog extends Animal { // Subclass (child)
>     public void animalSound() {
>         super.animalSound(); // Call the superclass method
>         System.out.println("The dog says: bow wow");
>     }
> }
>
> public class Main {
>     public static void main(String[] args) {
>         Animal myDog = new Dog(); // Create a Dog object
>         myDog.animalSound(); // Call the method on the Dog object
>     }
> }
> ```

---

← [មេរៀនមុន](../10-this-keyword/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../12-method-overriding/README.md) →
