# មេរៀនទី ១៦៖ Java Inner Class (ថ្នាក់ខាងក្នុង)

### 🖥️ ស្លាយទី 81 ｜ Slide 81

> ## 📌 និយមន័យនៃ Inner Class
> 
> ---
>
> ### ➤ Inner Class
> - នៅក្នុងភាសា Java គឺអាចមាន **nested classes** ដែលមានន័យថាយើងអាចបង្កើត class ថ្មីនៅខាងក្នុង class ដែលមានស្រាប់។
> - គោលបំណងដែលយើងប្រើវាគឺដើម្បីជួយឱ្យកូដរបស់យើងងាយស្រួលក្នុងការមើល និងងាយស្រួលគ្រប់គ្រង។
> - ដើម្បីអាចចូលទៅប្រើ inner class បាន គឺយើងត្រូវបង្កើត object ឱ្យ outer class សិន ហើយបន្ទាប់មកទើបយើងអាចបង្កើត object ឱ្យ inner class បាន។

---

### 🖥️ ស្លាយទី 82 ｜ Slide 82

> ## 📌 គំរូកូដ Inner Class ធម្មតា
> 
> ---
>
> ### Example: Regular Inner Class
> ```java
> class OuterClass {
>     int x = 10;
>
>     class InnerClass {
>         int y = 5;
>     }
> }
>
> public class Main {
>     public static void main(String[] args) {
>         OuterClass myOuter = new OuterClass();
>         OuterClass.InnerClass myInner = myOuter.new InnerClass();
>         System.out.println(myInner.y + myOuter.x); // Outputs 15 (5 + 10)
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 84 ｜ Slide 84

> ## 📌 Static Inner Class
> 
> ---
>
> ### Static Inner Class
> Inner class ក៏អាចជា `static` ផងដែរ ដែលមានន័យថាយើងអាច access វាបានដោយមិនបាច់បង្កើត object របស់ outer class នោះឡើយ:
>
> ```java
> class OuterClass {
>     int x = 10;
>
>     static class InnerClass {
>         int y = 5;
>     }
> }
>
> public class Main {
>     public static void main(String[] args) {
>         OuterClass.InnerClass myInner = new OuterClass.InnerClass();
>         System.out.println(myInner.y); // Outputs 5
>     }
> }
> ```

---

### 🖥️ ស្លាយទី 85 ｜ Slide 85

> ## 📌 ការ Access Outer Class ពី Inner Class
> 
> ---
>
> ### Access Outer Class From Inner Class
> អត្ថប្រយោជន៍មួយទៀតនៃ inner classes គឺវាអាច access ទៅកាន់ attributes និង methods របស់ outer class បានដោយផ្ទាល់:
>
> ```java
> class OuterClass {
>     int x = 10;
>
>     class InnerClass {
>         public int myInnerMethod() {
>             return x; // Access attribute x from OuterClass
>         }
>     }
> }
>
> public class Main {
>     public static void main(String[] args) {
>         OuterClass myOuter = new OuterClass();
>         OuterClass.InnerClass myInner = myOuter.new InnerClass();
>         System.out.println(myInner.myInnerMethod()); // Outputs 10
>     }
> }
> ```

---

← [មេរៀនមុន](../15-polymorphism/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../17-abstraction/README.md) →
