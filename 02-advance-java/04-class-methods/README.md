# មេរៀនទី ៤៖ Java Class Methods (វិធីសាស្ត្រនៃ Class)

### 🖥️ ស្លាយទី 16 ｜ Slide 16

> ## 📌 Java Class Methods
> 
> ---
>
> ### Java Class Methods
> Methods ត្រូវបានប្រកាសនៅក្នុង Class ហើយវាត្រូវបានប្រើប្រាស់ដើម្បីអនុវត្តនូវសកម្មភាព (actions) ជាក់លាក់ណាមួយ:
>
> ```java
> public class Main {
>     static void myMethod() {
>         System.out.println("Hello World!");
>     }
>
>     public static void main(String[] args) {
>         myMethod();
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 17 ｜ Slide 17

> ## 📌 ភាពខុសគ្នារវាង Static vs Public Methods
> 
> ---
>
> ### Static vs. Public Methods
> នៅក្នុងភាសា Java យើងច្រើនឃើញ methods ត្រូវបានប្រកាសជា `static` ឬ `public`:
> - **`static` method:** អាចហៅប្រើប្រាស់បានដោយផ្ទាល់ ដោយមិនចាំបាច់បង្កើត Object នៃ Class ឡើយ។
> - **`public` method:** អាចហៅប្រើប្រាស់បាន លុះត្រាតែយើងបង្កើត Object នៃ Class នោះជាមុនសិន។
>
> ```java
> public class Main {
>     // Static method
>     static void myStaticMethod() {
>         System.out.println("Static methods can be called without creating objects");
>     }
>
>     // Public method
>     public void myPublicMethod() {
>         System.out.println("Public methods must be called by creating objects");
>     }
>
>     // Main method
>     public static void main(String[] args) {
>         myStaticMethod(); // Call static method
>
>         Main myObj = new Main(); // Create an object
>         myObj.myPublicMethod(); // Call public method
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 18 ｜ Slide 18

> ## 📌 ការហៅ Methods តាមរយៈ Object
> 
> ---
>
> ### Access Methods With an Object
> ឧទាហរណ៍ជាក់ស្តែងអំពីការបង្កើត Object `myCar` និងហៅ methods របស់វា:
>
> ```java
> // Create a Main class
> public class Main {
>     // Create a fullThrottle() method
>     public void fullThrottle() {
>         System.out.println("The car is going as fast as it can!");
>     }
>
>     // Create a speed() method and add a parameter
>     public void speed(int maxSpeed) {
>         System.out.println("Max speed is: " + maxSpeed);
>     }
>
>     public static void main(String[] args) {
>         Main myCar = new Main();   // Create a myCar object
>         myCar.fullThrottle();      // Call the fullThrottle() method
>         myCar.speed(200);          // Call the speed() method
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 19 ｜ Slide 19

> ## 📌 Using Multiple Classes ជាមួយ Methods
> 
> ---
>
> ### Using Multiple Classes
> `Main.java`:
> ```java
> public class Main {
>     public void fullThrottle() {
>         System.out.println("The car is going as fast as it can!");
>     }
>
>     public void speed(int maxSpeed) {
>         System.out.println("Max speed is: " + maxSpeed);
>     }
> }
> ```
>
> `Second.java`:
> ```java
> class Second {
>     public static void main(String[] args) {
>         Main myCar = new Main();
>         myCar.fullThrottle();
>         myCar.speed(200);
>     }
> }
> ```

---

← [មេរៀនមុន](../03-class-attributes/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../05-constructors/README.md) →
