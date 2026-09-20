# មេរៀនទី ១៣៖ Java Math Class

> **ការប្រើប្រាស់អនុគមន៍គណិតវិទ្យាដែលមានស្រាប់ក្នុងភាសា Java តាមរយៈ Class `java.lang.Math`**

[![Lesson](https://img.shields.io/badge/Lesson-13-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Math-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 📐 ១. ស្វែងយល់អំពី `Math` Class ក្នុង Java

នៅក្នុងភាសា Java Class **`Math`** ស្ថិតនៅក្នុង Package `java.lang` ដែលផ្តល់នូវអនុគមន៍គណិតវិទ្យាជាច្រើនសម្រាប់ដោះស្រាយការគណនាស្មុគស្មាញ។

> [!NOTE]
> * **មិនបាច់ Import:** Class `Math` ស្ថិតក្នុង `java.lang` ដូច្នេះយើងអាចហៅប្រើបានភ្លាមៗដោយមិនបាច់សរសេរ `import` ឡើយ។
> * **Static Methods:** គ្រប់ Methods ទាំងអស់សុទ្ធតែជា `static` ដូច្នេះយើងហៅប្រើតាមរយៈឈ្មោះ Class ដោយផ្ទាល់៖ `Math.methodName(...)`។

---

## 📊 ២. តារាងអនុគមន៍គណិតវិទ្យាសំខាន់ៗ (Core Math Methods)

| Method | ការពិពណ៌នា (Description) | ឧទាហរណ៍ | លទ្ធផល |
| :--- | :--- | :--- | :---: |
| **`Math.max(x, y)`** | ស្វែងរកតម្លៃដែលធំជាងគេរវាង x និង y | `Math.max(10, 20)` | `20` |
| **`Math.min(x, y)`** | ស្វែងរកតម្លៃដែលតូចជាងគេរវាង x និង y | `Math.min(10, 20)` | `10` |
| **`Math.sqrt(x)`** | គណនារកឫសការេ (Square root) | `Math.sqrt(64)` | `8.0` |
| **`Math.abs(x)`** | រកតម្លៃដាច់ខាត (Absolute positive value) | `Math.abs(-55)` | `55` |
| **`Math.floor(x)`** | បង្គត់ទម្លាក់ចុះក្រោម | `Math.floor(5.9)` | `5.0` |
| **`Math.ceil(x)`** | បង្គត់ឡើងទៅលើ | `Math.ceil(5.1)` | `6.0` |
| **`Math.round(x)`** | បង្គត់តាមក្បួនគណិតវិទ្យា (>= .5 ឡើងលើ) | `Math.round(5.6)` | `6` |

| **`Math.random()`** | បង្កើតលេខចៃដន្យចន្លោះពី `0.0` ដល់ `0.9999...` | `Math.random()` | `0.7291...` |

---

## 💻 ៣. កូដគំរូអនុវត្តជាក់ស្តែង (Practical Code Demos)

```java
public class MathDemo {
    public static void main(String[] args) {
        // ១. រកតម្លៃធំ និងតូច
        System.out.println("Max (10, 20): " + Math.max(10, 20));       // 20
        System.out.println("Min (10, 20): " + Math.min(10, 20));       // 10

        // ២. រកឫសការេ
        System.out.println("Square Root of 64: " + Math.sqrt(64));     // 8.0
        System.out.println("Square Root of 144: " + Math.sqrt(144));   // 12.0

        // ៣. តម្លៃដាច់ខាត (Absolute)
        System.out.println("Absolute of -45.6: " + Math.abs(-45.6));   // 45.6

        // ៤. ការបង្គត់លេខ
        System.out.println("Floor of 5.9: " + Math.floor(5.9));        // 5.0
        System.out.println("Round of 5.6: " + Math.round(5.6));        // 6
        System.out.println("Round of 5.4: " + Math.round(5.4));        // 5

        // ៥. បង្កើតលេខចៃដន្យ (Random Number ចន្លោះ ០ ដល់ ១០០)
        int randomNum = (int)(Math.random() * 101); // 0 to 100
        System.out.println("Random Number (0 - 100): " + randomNum);
    }
}
```

---

## 🎲 ៤. របៀបបង្កើតលេខចៃដន្យ (Random Number Trick)

> [!TIP]
> `Math.random()` ផ្តល់តម្លៃលេខទសភាគចន្លោះពី `0.0` ដល់ `0.9999...`។ ដើម្បីបង្កើតលេខចំនួនគត់ចន្លោះពី `0` ដល់ `N` យើងប្រើរូបមន្ត៖
> ```java
> int randomNum = (int)(Math.random() * (max + 1));
> ```

---

← [មេរៀនមុន (១២៖ Java Operators)](../12-java-operators/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៤៖ Java Strings)](../14-java-strings/README.md) →
