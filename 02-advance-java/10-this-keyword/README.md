# មេរៀនទី ១០៖ this Keyword ក្នុង Java (ការសំដៅទៅកាន់ Current Object)

> **ស្វែងយល់លម្អិតអំពីពាក្យគន្លឹះ this ក្នុង Java៖ ការដោះស្រាយបញ្ហា Variable Shadowing ការហៅ Constructor Chaining តាមរយៈ this() និងករណីប្រើប្រាស់ជាក់ស្តែង**

[![Lesson](https://img.shields.io/badge/Lesson-10-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-this%20Keyword-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🎯 ១. អ្វីជាពាក្យគន្លឹះ `this`? (What is `this` Keyword?)

នៅក្នុងភាសា Java, **`this`** គឺជា Reference Variable ពិសេសមួយដែល **សំដៅដោយផ្ទាល់ទៅកាន់ Object បច្ចុប្បន្ន (Current Class Instance)** ដែលកំពុងដំណើរការកូដនោះ។

### 🌟 ករណីប្រើប្រាស់ចម្បងៗនៃ `this`៖
1. 🏷️ សំដៅទៅកាន់ **Instance Variable** របស់ Class នៅពេលដែលឈ្មោះ Parameter មានឈ្មោះដូចគ្នា (ដោះស្រាយបញ្ហា Variable Shadowing)។
2. 🏗️ ហៅ **Constructor មួយទៀត** នៅក្នុង Class ជាមួយគ្នា (`this()`) ដែលគេហៅថា Constructor Chaining។
3. ⚙️ ហៅ **Method ផ្សេងទៀត** ក្នុង Class ជាមួយគ្នា (`this.display()`)។
4. 🔄 **Return Object បច្ចុប្បន្ន** ត្រឡប់មកវិញពី Method (ប្រើច្រើនក្នុង Method Chaining / Builder Pattern)។

---

## ⚠️ ២. ការដោះស្រាយបញ្ហា Variable Shadowing

នៅពេលដែលឈ្មោះ Parameter ក្នុង Constructor ឬ Method មានឈ្មោះដូចគ្នានឹង Instance Variable បើយើងមិនប្រើ `this` ទេនោះ Java Compiler នឹងច្រឡំថាជាការផ្តល់តម្លៃឱ្យ Parameter ខ្លួនឯង (Shadowing) ជាហេតុធ្វើឱ្យ Instance Variable មិនទទួលបានតម្លៃអ្វីទាំងអស់៖

### ❌ កូដខុស (គ្មាន `this`):
```java
public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        id = id;     // ❌ Parameter ផ្តល់តម្លៃឱ្យ Parameter ខ្លួនឯង (Instance variable នៅតែ null/0)
        name = name; // ❌ មិនដំណើរការ
    }
}
```

### ✅ កូដត្រឹមត្រូវ (ប្រើ `this`):
```java
public class Student {
    int id;
    String name;

    // ប្រើ this ដើម្បីបែងចែកឱ្យដាច់រវាង Instance Variable និង Parameter
    public Student(int id, String name) {
        this.id = id;       // this.id សំដៅលើ attribute របស់ Object
        this.name = name;   // this.name សំដៅលើ attribute របស់ Object
    }

    public void display() {
        System.out.println("ID: " + this.id + " | ឈ្មោះ: " + this.name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Sokha");
        s1.display();
    }
}
```

**Output:**
```text
ID: 101 | ឈ្មោះ: Sokha
```

---

## 🔗 ៣. Constructor Chaining តាមរយៈ `this()`

យើងអាចប្រើប្រាស់ `this()` ដើម្បីហៅ Constructor មួយចេញពី Constructor មួយទៀតក្នុង Class តែមួយ ដើម្បីកាត់បន្ថយការសរសេរកូដច្រំដែល៖

```java
public class Employee {
    int id;
    String name;
    double salary;

    // Constructor ទី ១: ទទួលតែ id និង name
    public Employee(int id, String name) {
        this(id, name, 500.0); // ហៅ Constructor ទី ២ ដោយផ្តល់ Default salary
    }

    // Constructor ទី ២: ទទួល ៣ Parameters ពេញលេញ
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
```

> [!IMPORTANT]
> ការហៅ `this()` ត្រូវតែស្ថិតនៅ **បន្ទាត់ទីមួយគេបង្អស់ (First Statement)** នៅក្នុង Constructor body ជានិច្ច បើមិនដូច្នេះទេ Compiler នឹងបោះ Error ភ្លាម។

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **`this`** សំដៅលើ Current Object Instance ជានិច្ច។
> 2. ប្រើ `this.variableName` ដើម្បីដោះស្រាយបញ្ហាជាន់ឈ្មោះរវាង Parameter និង Field។
> 3. ប្រើ `this(...)` សម្រាប់ធ្វើ Constructor Chaining ដោយត្រូវដាក់នៅបន្ទាត់ដំបូងគេជានិច្ច។

---

← [មេរៀនមុន (០៩៖ Java Inheritance)](../09-inheritance/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១១៖ super Keyword ក្នុង Java)](../11-super-keyword/README.md) →
