# មេរៀនទី ១៥៖ Java Polymorphism (ពហុរូបភាព)

### 🖥️ ស្លាយទី 79 ｜ Slide 79

> ## 📌 និយមន័យនៃ Polymorphism
> 
> ---
>
> ### ➤ Polymorphism នៅក្នុង Class
> **Polymorphism** កើតឡើងពីពាក្យក្រិចពីរគឺ:
> - `poly`: មានន័យថាច្រើន
> - `morphism`: មានន័យថាទម្រង់
>
> ហេតុនេះ **Polymorphism មានន័យថា "ច្រើនទម្រង់"**។ នៅក្នុង OOP, polymorphism គេសំដៅទៅរក methods ទាំងឡាយណាដែលមានឈ្មោះដូចគ្នានៅក្នុង Class Hierarchy ដែលមានការប្រព្រឹត្តផ្សេងៗគ្នា អាស្រ័យទៅតាម Object ដែលវានីមួយៗសំដៅទៅរក។

---

### 🖥️ ស្លាយទី 80 ｜ Slide 80

> ## 📌 គំរូកូដ Polymorphism ជាមួយសត្វផ្សេងៗ
> 
> ---
>
> ### Example:
> ```java
> class Animal {
>     public void animalSound() {
>         System.out.println("The animal makes a sound");
>     }
> }
>
> class Pig extends Animal {
>     public void animalSound() {
>         System.out.println("The pig says: wee wee");
>     }
> }
>
> class Dog extends Animal {
>     public void animalSound() {
>         System.out.println("The dog says: bow wow");
>     }
> }
>
> class Main {
>     public static void main(String[] args) {
>         Animal myAnimal = new Animal(); // Create an Animal object
>         Animal myPig = new Pig();       // Create a Pig object
>         Animal myDog = new Dog();       // Create a Dog object
>
>         myAnimal.animalSound(); // Outputs: The animal makes a sound
>         myPig.animalSound();    // Outputs: The pig says: wee wee
>         myDog.animalSound();    // Outputs: The dog says: bow wow
>     }
> }
> ```

---

← [មេរៀនមុន](../14-final-keyword/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../16-inner-classes/README.md) →
