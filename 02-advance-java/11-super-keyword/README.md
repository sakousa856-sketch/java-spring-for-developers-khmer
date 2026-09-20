# មេរៀនទី ១១៖ super Keyword ក្នុង Java (ការសំដៅទៅកាន់ Superclass)

> **ស្វែងយល់ស៊ីជម្រៅអំពីពាក្យគន្លឹះ super ក្នុង Java៖ ការទាញយក Parent Attributes ការហៅ Parent Methods និងការដំណើរការ Constructor Chaining តាមរយៈ super()**

[![Lesson](https://img.shields.io/badge/Lesson-11-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-super%20Keyword-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 👴 ១. អ្វីជាពាក្យគន្លឹះ `super`? (What is `super` Keyword?)

នៅក្នុង Java, **`super`** គឺជា Reference Variable មួយដែលត្រូវបានប្រើប្រាស់ដោយ Subclass (Class កូន) ដើម្បី **សំដៅដោយផ្ទាល់ទៅកាន់ Object នៃ Superclass (Class មេ)**។

### 🎯 មុខងារចម្បងទាំង ៣ នៃ `super`៖
1. 🏷️ **សំដៅទៅកាន់ Instance Variable របស់ Parent Class:** នៅពេលដែល Class កូន និង Class មេមាន Field ឈ្មោះដូចគ្នា (`super.variableName`)។
2. ⚙️ **ហៅ Method របស់ Parent Class:** នៅពេលដែល Method ត្រូវបាន Override ក្នុង Class កូន ប៉ុន្តែយើងនៅតែចង់ដំណើរការ Method ដើមរបស់ Class មេ (`super.methodName()`)។
3. 🏗️ **ហៅ Constructor របស់ Parent Class:** ដំណើរការ Constructor របស់ Class មេចេញពី Class កូន (`super()` ឬ `super(parameters)`)។

---

## 💻 ២. ករណីទី ១៖ សំដៅទៅកាន់ Parent Attribute (`super.variable`)

```java
// Superclass
class Animal {
    String color = "ស (White)";
}

// Subclass
class Dog extends Animal {
    String color = "ខ្មៅ (Black)";

    void printColor() {
        System.out.println("ពណ៌របស់ Dog: " + color);              // ពណ៌របស់ Subclass
        System.out.println("ពណ៌របស់ Animal: " + super.color);     // ពណ៌របស់ Superclass
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printColor();
    }
}
```

**Output:**
```text
ពណ៌របស់ Dog: ខ្មៅ (Black)
ពណ៌របស់ Animal: ស (White)
```

---

## ⚙️ ៣. ករណីទី ២៖ ហៅ Method របស់ Parent Class (`super.method()`)

```java
class Person {
    void message() {
        System.out.println("នេះគឺជាសារចេញពី Class Person (Parent) 👤");
    }
}

class Student extends Person {
    @Override
    void message() {
        System.out.println("នេះគឺជាសារចេញពី Class Student (Child) 🎓");
    }

    void display() {
        message();       // ហៅ message() របស់ Student (Overridden)
        super.message(); // ហៅ message() ដើមរបស់ Person (Parent)
    }
}
```

---

## 🏗️ ៤. ករណីទី ៣៖ ហៅ Parent Constructor (`super()`)

នៅពេលយើងបង្កើត Object នៃ Subclass នោះ Constructor របស់ Superclass នឹងត្រូវដំណើរការមុនជានិច្ច ដើម្បីធានាថាគ្រឹះរបស់ Class មេត្រូវបានរៀបចំរួចរាល់៖

```java
class Animal {
    Animal(String name) {
        System.out.println("១. Animal Constructor ដំណើរការ: " + name);
    }
}

class Dog extends Animal {
    Dog() {
        super("ឆ្កែឆ្លាត"); // ហៅ Parameterized Constructor របស់ Animal
        System.out.println("២. Dog Constructor ដំណើរការបន្ទាប់");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

**Output:**
```text
១. Animal Constructor ដំណើរការ: ឆ្កែឆ្លាត
២. Dog Constructor ដំណើរការបន្ទាប់
```

> [!IMPORTANT]
> ដូចគ្នានឹង `this()` ដែរ ការហៅ **`super()`** ត្រូវតែជា **បន្ទាត់ទីមួយគេបង្អស់ (First Statement)** នៅក្នុង Subclass Constructor ជានិច្ច។

---

## ⚖️ ៥. ការប្រៀបធៀបរវាង `this` និង `super`

| លក្ខណៈវិនិច្ឆ័យ | `this` | `super` |
| :--- | :--- | :--- |
| **គោលដៅសំដៅ** | សំដៅទៅលើ **Current Class Object** | សំដៅទៅលើ **Immediate Parent Class Object** |
| **ការហៅ Variable** | `this.variable` (Field របស់ខ្លួនឯង) | `super.variable` (Field របស់មេ) |
| **ការហៅ Method** | `this.method()` (Method របស់ខ្លួនឯង) | `super.method()` (Method របស់មេ) |
| **ការហៅ Constructor** | `this()` (Constructor ក្នុង Class តែមួយ) | `super()` (Constructor របស់ Parent) |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **`super`** ប្រើប្រាស់សម្រាប់ទាញយក Field, Method, និង Constructor របស់ Superclass។
> 2. ប្រើ `super.methodName()` ដើម្បីហៅ Method របស់ Class មេដែលត្រូវបាន Override។
> 3. `super()` ត្រូវតែនៅបន្ទាត់ទីមួយក្នុង Constructor ជានិច្ច ដើម្បី Initialize Parent Class។

---

← [មេរៀនមុន (១០៖ this Keyword ក្នុង Java)](../10-this-keyword/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១២៖ Java Method Overriding)](../12-method-overriding/README.md) →
