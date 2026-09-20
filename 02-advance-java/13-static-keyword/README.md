# មេរៀនទី ១៣៖ Java static Keyword (ពាក្យគន្លឹះ static)

### 🖥️ ស្លាយទី 75 ｜ Slide 75

> ## 📌 និយមន័យនៃ static Keyword
> 
> ---
>
> ### ពាក្យគន្លឹះ static ក្នុង Java
> នៅក្នុងភាសា Java សម្រាប់ keyword `static` គឺសំដៅទៅលើប្រភេទនៃ non-access modifier ដែលប្រើសម្រាប់ដាក់ទៅឱ្យ methods និង attributes។
> - អ្វីដែលពិសេសសម្រាប់ keyword `static` គឺយើងអាច **access នូវ methods និង attributes បានដោយមិនចាំបាច់បង្កើត object ចេញពី class នោះឡើយ**។

---

### 🖥️ ស្លាយទី 76 ｜ Slide 76

> ## 📌 គំរូកូដប្រើប្រាស់ static Keyword
> 
> ---
>
> ### Example: Static vs Public Method
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
>         myStaticMethod(); // Call the static method directly
>
>         Main myObj = new Main(); // Create an object of Main
>         myObj.myPublicMethod(); // Call the public method
>     }
> }
> ```

---

← [មេរៀនមុន](../12-method-overriding/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../14-final-keyword/README.md) →
