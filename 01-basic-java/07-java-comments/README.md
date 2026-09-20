# មេរៀនទី ៧៖ Java Comments (កំណត់សម្គាល់កូដ)

> **ការប្រើប្រាស់ Comment ក្នុងភាសា Java ដើម្បីពន្យល់កូដ ធ្វើឱ្យកូដងាយយល់ និងបិទកូដបណ្តោះអាសន្នពេល Testing/Debugging**

[![Lesson](https://img.shields.io/badge/Lesson-07-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Comments-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 💬 ១. អ្វីទៅជា Comment ក្នុងភាសា Java?

**Comment (កំណត់សម្គាល់)** គឺជាអត្ថបទដែលយើងសរសេរនៅក្នុងកូដដើម្បី៖
1. 📝 **ពន្យល់ពី Logic នៃកូដ:** ទុកសម្រាប់ខ្លួនឯងអាននៅពេលក្រោយ ឬឱ្យសមាជិកក្រុមអានយល់ពីគោលបំណងនៃកូដ។
2. 🛠️ **បិទកូដបណ្តោះអាសន្ន:** ពេលកំពុងធ្វើតេស្ត ឬដោះស្រាយកំហុស (Debugging) ដោយមិនបាច់លុបកូដចោល។

> [!NOTE]
> **វិធានសំខាន់:** Java Compiler នឹង**មើលរំលង (Ignore) រាល់ Comment ទាំងអស់** ដោយមិនយកមកបង្កើតជា Bytecode ឬ Execute ឡើយ។ ដូច្នេះ Comment មិនប៉ះពាល់ដល់ល្បឿនដំណើរការកម្មវិធីឡើយ។

---

## 📑 ២. ប្រភេទនៃ Comment ក្នុងភាសា Java

ក្នុងភាសា Java មាន Comment ចម្បងៗដូចខាងក្រោម៖

### ១. Single-line Comment (កំណត់សម្គាល់មួយបន្ទាត់)
* ប្រើសញ្ញា Slash ពីរជាប់គ្នា៖ **`//`**
* រាល់អក្សរដែលសរសេរនៅខាងក្រោយ `//` រហូតដល់ចុងបន្ទាត់ នឹងត្រូវចាត់ទុកជា Comment។

### ២. Multi-line Comment (កំណត់សម្គាល់ច្រើនបន្ទាត់)
* ចាប់ផ្តើមដោយ **`/*`** និងបញ្ចប់ដោយ **`*/`**
* សមស្របសម្រាប់ការពន្យល់កថាខណ្ឌវែងៗដែលត្រូវចុះបន្ទាត់ច្រើនជួរ។

### ៣. Javadoc Documentation Comment (សម្រាប់បង្កើតឯកសារ API)
* ចាប់ផ្តើមដោយ **`/**`** និងបញ្ចប់ដោយ **`*/`**
* ប្រើសម្រាប់បង្កើតឯកសារពិពណ៌នា Method ឬ Class (API Documentation)។

---

## 💻 ៣. កូដគំរូជាក់ស្តែង (Practical Code Examples)

```java
public class CommentsDemo {
    public static void main(String[] args) {
        // ១. នេះជា Single-line comment នៅពីលើបន្ទាត់កូដ
        System.out.println("Hello World");

        System.out.println("Hello Java"); // ២. នេះជា Comment នៅចុងបន្ទាត់កូដ

        /* ៣. នេះជា Multi-line comment
           ដែលយើងអាចសរសេរពន្យល់បានច្រើនបន្ទាត់
           ដោយមិនមានបញ្ហាឡើយ */
        System.out.println("Clean Code");
        
        // System.out.println("បន្ទាត់នេះត្រូវបានបិទ មិនដំណើរការឡើយ");
    }
}
```

---

## 💡 ទម្លាប់ល្អក្នុងការសរសេរ Comment (Best Practices)

> [!TIP]
> * **កុំ Comment អ្វីដែលកូដប្រាប់ច្បាស់ហើយ:** កុំសរសេរ `int age = 20; // set age to 20` ព្រោះកូដវាបញ្ជាក់ច្បាស់ស្រាប់ហើយ។
> * **Comment ពន្យល់ពី "មូលហេតុ" (Why):** ចូរ Comment ពន្យល់ថា *ហេតុអ្វីបានជាយើងសរសេរកូដបែបនេះ* ជាជាងពន្យល់ថា *កូដនេះធ្វើអ្វី*។

---

← [មេរៀនមុន (០៦៖ Java Output)](../06-java-output/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៨៖ Java Variables)](../08-java-variables/README.md) →
