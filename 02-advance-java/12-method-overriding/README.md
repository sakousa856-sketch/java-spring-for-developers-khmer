# មេរៀនទី ១២៖ Java Method Overriding (ការសរសេរជាន់លើ Method)

### 🖥️ ស្លាយទី 72 ｜ Slide 72

> ## 📌 ការប្រៀបធៀប Method Overloading
> 
> ---
>
> ### Method Overloading (រំលឹកឡើងវិញ)
> Method Overloading អនុញ្ញាតឱ្យយើងបង្កើត methods ច្រើនដែលមានឈ្មោះដូចគ្នា តែមានប៉ារ៉ាម៉ែត្រខុសគ្នា (ខុសចំនួន ឬខុសប្រភេទ data type) នៅក្នុង class តែមួយ:
> ```java
> int myMethod(int x)
> float myMethod(float x)
> double myMethod(double x, double y)
> ```

---

### 🖥️ ស្លាយទី 73 ｜ Slide 73

> ## 📌 និយមន័យ Method Overriding
> 
> ---
>
> ### Method Overriding
> ចំណែកឯ **Method Overriding** វិញ គឺជា methods ដែលត្រូវបានបង្កើតនៅក្នុង superclass (parent) ហើយយើងចង់បន្ថែមនូវអត្ថន័យថ្មីនៅក្នុង subclass (child)។
> - Method Overriding កើតចេញពី subclass ធ្វើការ implement នូវ methods របស់ superclass មកកែច្នៃបន្ថែមទៀត។
> - ឈ្មោះរបស់ method គឺត្រូវតែដូចគ្នាទៅនឹងឈ្មោះដើមនៅក្នុង superclass។
> - ប៉ារ៉ាម៉ែត្រ និង return type ត្រូវតែដូចគ្នាបេះបិទ។
> - ត្រូវតែស្ថិតនៅក្នុង **IS-A relationship** (Inheritance)។

---

### 🖥️ ស្លាយទី 74 ｜ Slide 74

> ## 📌 គំរូកូដ Method Overriding
> 
> ---
>
> ### Example:
> ```java
> class Human {
>     // Overridden method
>     public void eat() {
>         System.out.println("Human is eating");
>     }
> }
>
> class Boy extends Human {
>     // Overriding method
>     public void eat() {
>         System.out.println("Boy is eating");
>     }
>
>     public static void main(String[] args) {
>         Boy obj = new Boy();
>         // This will call the child class version of eat()
>         obj.eat(); // Output: Boy is eating
>     }
> }
> ```

---

← [មេរៀនមុន](../11-super-keyword/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../13-static-keyword/README.md) →
