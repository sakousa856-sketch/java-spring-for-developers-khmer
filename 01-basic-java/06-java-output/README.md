# មេរៀនទី ៦៖ Java Output (ការបញ្ចេញលទ្ធផល)

> **ស្វែងយល់ពីរបៀបបង្ហាញព័ត៌មាន និងសារអក្សរទៅកាន់ Console Screen ក្នុងភាសា Java៖ ភាពខុសគ្នារវាង `print()` និង `println()`**

[![Lesson](https://img.shields.io/badge/Lesson-06-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Output-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 📢 ១. ស្វែងយល់អំពី Output ក្នុង Java

ដើម្បីបញ្ចេញលទ្ធផល ឬបង្ហាញទិន្នន័យលើ Console Screen ក្នុងភាសា Java យើងប្រើប្រាស់ **`System.out`** ជាមួយ Methods សំខាន់ពីរគឺ៖
1. **`System.out.print()`**: បង្ហាញអត្ថបទ **ដោយមិនចុះបន្ទាត់** ឡើយ។
2. **`System.out.println()`**: បង្ហាញអត្ថបទ រួចហើយ **ចុះបន្ទាត់ថ្មី (Print Line)** ដោយស្វ័យប្រវត្តិ។

### 📊 តារាងប្រៀបធៀប `print()` vs `println()`

| Method | សកម្មភាព | ឥរិយាបថបន្ទាប់ពីបង្ហាញអត្ថបទ |
| :--- | :--- | :--- |
| `System.out.print()` | បង្ហាញទិន្នន័យ | ទ្រនិច Cursor នៅជាប់ចុងអត្ថបទដដែល (មិនចុះបន្ទាត់) |
| `System.out.println()` | បង្ហាញទិន្នន័យ | ទ្រនិច Cursor ផ្លាស់ទីទៅបន្ទាត់ថ្មី (ចុះបន្ទាត់) |

---

## 💻 ២. កូដគំរូជាក់ស្តែង (Practical Examples)

### ឧទាហរណ៍ទី ១៖ ការប្រើប្រាស់ `print()` (មិនចុះបន្ទាត់)

```java
public class OutputDemoOne {
    public static void main(String[] args) {
        System.out.print("Hello World");
        System.out.print("Hello Java");
    }
}
```

**Output:**
```text
HelloWorldHello Java
```
*(សម្គាល់៖ ពាក្យទាំងពីរបន្តជាប់គ្នាលើបន្ទាត់តែមួយ)*

---

### ឧទាហរណ៍ទី ២៖ ការប្រើប្រាស់ `println()` (ចុះបន្ទាត់ថ្មី)

```java
public class OutputDemoTwo {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello Java");
    }
}
```

**Output:**
```text
Hello World
Hello Java
```
*(សម្គាល់៖ ពាក្យ "Hello Java" ត្រូវបានបង្ហាញនៅលើបន្ទាត់ថ្មី)*

---

## 🔤 ៣. តួអក្សរពិសេសសម្រាប់រៀបចំអត្ថបទ (Escape Sequences)

ក្រៅពី `println()` យើងក៏អាចប្រើប្រាស់ **Escape Sequences** នៅក្នុងអត្ថបទបានផងដែរ៖

| Escape Sequence | អត្ថន័យ (Description) | ឧទាហរណ៍ |
| :---: | :--- | :--- |
| `\n` | ចុះបន្ទាត់ថ្មី (New Line) | `System.out.print("Hello\nWorld");` |
| `\t` | ដកឃ្លាមួយ Tab (Tab space) | `System.out.println("Name:\tSreang");` |
| `\"` | បង្ហាញសញ្ញា Double Quote (`"`) | `System.out.println("He said \"Hi\"");` |
| `\\` | បង្ហាញសញ្ញា Backslash (`\`) | `System.out.println("Path: C:\\Java");` |

---

## 💡 សេចក្តីសង្ខេប (Summary)

> [!TIP]
> * ប្រើ **`System.out.println()`** នៅពេលចង់ឱ្យសារបន្ទាប់ចុះបន្ទាត់ថ្មី (ប្រើញឹកញាប់បំផុត)។
> * ប្រើ **`System.out.print()`** នៅពេលចង់បង្ហាញអត្ថបទបន្តគ្នាលើបន្ទាត់តែមួយ (ឧទាហរណ៍៖ សួរនាំ User Input)។

---

← [មេរៀនមុន (០៥៖ ទម្រង់នៃកម្មវិធី Java)](../05-java-program-structure/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៧៖ Java Comments)](../07-java-comments/README.md) →
