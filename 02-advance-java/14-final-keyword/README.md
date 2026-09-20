# មេរៀនទី ១៤៖ Java final Keyword (ពាក្យគន្លឹះ final)

### 🖥️ ស្លាយទី 77 ｜ Slide 77

> ## 📌 និយមន័យនៃ final Keyword
> 
> ---
>
> ### ពាក្យគន្លឹះ final ក្នុង Java
> នៅក្នុងភាសា Java សម្រាប់ keyword `final` គឺសំដៅទៅលើប្រភេទនៃ non-access modifier ដែលប្រើសម្រាប់ដាក់ទៅឱ្យ classes, methods និង attributes:
> - **`final variable/attribute`:** មិនអាចកែប្រែ ឬផ្លាស់ប្តូរតម្លៃបានឡើយ (តម្លៃថេរ - Constant)។
> - **`final method`:** មិនអាចត្រូវបាន overridden ដោយ subclass បានឡើយ។
> - **`final class`:** មិនអាចត្រូវបាន inherited ដោយ class ផ្សេងបានឡើយ។

---

### 🖥️ ស្លាយទី 78 ｜ Slide 78

> ## 📌 គំរូកូដប្រើប្រាស់ final Keyword
> 
> ---
>
> ### Example: Set a variable to final
> ```java
> public class Main {
>     final int x = 10;
>
>     public static void main(String[] args) {
>         Main myObj = new Main();
>         myObj.x = 25; // will generate an error: cannot assign a value to a final variable
>         System.out.println(myObj.x);
>     }
> }
> ```

---

← [មេរៀនមុន](../13-static-keyword/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../15-polymorphism/README.md) →
