# មេរៀនទី ១០៖ Java this Keyword (ពាក្យគន្លឹះ this)

### 🖥️ ស្លាយទី 68 ｜ Slide 68

> ## 📌 និយមន័យនៃ this Keyword
> 
> ---
>
> ### ពាក្យគន្លឹះ this ក្នុង Java
> នៅក្នុងភាសា Java សម្រាប់ keyword `this` គឺសំដៅទៅលើ object បច្ចុប្បន្ននៅក្នុង method ឬក៏ constructor។ ជាទូទៅ យើងប្រើវាដើម្បីបញ្ចៀសនូវការហៅនូវ attribute ខុស និងភាពភាន់ច្រឡំទៅលើឈ្មោះប៉ារ៉ាម៉ែត្រ។
>
> **កន្លែងដែលអាចប្រើប្រាស់ `this` បាន:**
> - ប្រើនៅក្នុង constructor និង method
> - ប្រើសម្រាប់ return នៃ object បច្ចុប្បន្ន
> - ប្រើសម្រាប់ផ្តល់ជាអាគុយម៉ង់ទៅក្នុង method និង constructor

---

### 🖥️ ស្លាយទី 69 ｜ Slide 69

> ## 📌 គំរូកូដប្រើប្រាស់ this Keyword
> 
> ---
>
> ### Example: Using this with a class attribute (x):
> ```java
> public class Main {
>     int x;
>
>     // Constructor with a parameter
>     public Main(int x) {
>         this.x = x; // this.x សំដៅលើ attribute x របស់ class
>     }
>
>     // Call the constructor
>     public static void main(String[] args) {
>         Main myObj = new Main(5);
>         System.out.println("Value of x = " + myObj.x); // Outputs Value of x = 5
>     }
> }
> ```

---

← [មេរៀនមុន](../09-inheritance/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../11-super-keyword/README.md) →
