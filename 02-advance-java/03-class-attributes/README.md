# មេរៀនទី ៣៖ Java Class Attributes (លក្ខណៈសម្បត្តិរបស់ Class)

> **ស្វែងយល់អំពី Class Attributes (Fields) ក្នុង Java៖ របៀបកំណត់តម្លៃ ការកែប្រែទិន្នន័យ ភាពឯករាជ្យរវាង Objects និងការប្រើប្រាស់ពាក្យគន្លឹះ final**

[![Lesson](https://img.shields.io/badge/Lesson-03-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Class%20Attributes-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 📦 ១. អ្វីជា Class Attributes? (What are Attributes / Fields?)

នៅក្នុងភាសា Java, **Class Attributes** (ដែលគេច្រើនហៅថា **Fields** ឬ **Instance Variables**) គឺជាអថេរទាំងឡាយណាដែលត្រូវបានប្រកាសនៅខាងក្នុង Class ដោយផ្ទាល់ (នៅក្រៅ Methods)។ ពួកវាដើរតួជាអ្នកផ្ទុកស្ថានភាព (State) ឬលក្ខណៈសម្បត្តិរបស់ Object។

```java
public class Main {
    int x = 5;         // Attribute ប្រភេទ int
    String name = "John"; // Attribute ប្រភេទ String
}
```

---

## 🔍 ២. ការទាញយក និងកែប្រែតម្លៃ Attribute (Access & Modify)

### ក. ការទាញយកតម្លៃ (Accessing Attributes)
យើងអាចទាញយកតម្លៃរបស់ Attribute មកប្រើប្រាស់បានតាមរយៈការបង្កើត Object រួចប្រើ **Dot Operator (`.`)**៖

```java
public class Main {
    int x = 5;

    public static void main(String[] args) {
        Main myObj = new Main();
        System.out.println("តម្លៃ x: " + myObj.x);
    }
}
```

### ខ. ការកែប្រែតម្លៃ (Modifying Attributes)
យើងអាចកំណត់តម្លៃថ្មីទៅឱ្យ Attribute របស់ Object ណាមួយបានយ៉ាងងាយស្រួល៖

```java
public class Main {
    int x;

    public static void main(String[] args) {
        Main myObj = new Main();
        myObj.x = 40; // កំណត់តម្លៃ x ស្មើ 40
        System.out.println("តម្លៃថ្មីនៃ x: " + myObj.x);
    }
}
```

---

## 🔒 ៣. ការការពារ Attribute ជាមួយពាក្យគន្លឹះ `final`

ប្រសិនបើអ្នកចង់ឱ្យ Attribute មួយមានតម្លៃថេរជានិច្ច មិនអនុញ្ញាតឱ្យនរណាម្នាក់កែប្រែបានឡើយ សូមប្រើពាក្យគន្លឹះ **`final`** (Read-Only / Constant)៖

```java
public class Main {
    final int x = 10;

    public static void main(String[] args) {
        Main myObj = new Main();
        // បន្ទាត់ខាងក្រោមនឹងបណ្តាលឱ្យមាន Compile Error:
        // myObj.x = 25; // ❌ Error: cannot assign a value to final variable x
        System.out.println(myObj.x);
    }
}
```

> [!IMPORTANT]
> ពាក្យគន្លឹះ `final` មានសារៈសំខាន់ខ្លាំងណាស់នៅពេលអ្នកចង់បង្កើត Immutable Data ឬកំណត់តម្លៃថេរដែលមិនត្រូវឱ្យប្រែប្រួលក្នុង Program ដូចជាលេខ PI, អត្រាពន្ធ ឬ Max Limits។

---

## 👥 ៤. ភាពឯករាជ្យនៃ Attributes រវាង Multiple Objects

នៅពេលអ្នកបង្កើត Objects ច្រើនចេញពី Class តែមួយ ការកែប្រែតម្លៃ Attribute លើ Object មួយ **មិនប៉ះពាល់** ដល់តម្លៃរបស់ Object មួយទៀតឡើយ៖

```java
public class Main {
    int x = 5;

    public static void main(String[] args) {
        Main myObj1 = new Main(); // Object ទី ១
        Main myObj2 = new Main(); // Object ទី ២
        
        // កែប្រែតែលើ myObj2 ប៉ុណ្ណោះ
        myObj2.x = 25;

        System.out.println("Object 1 x: " + myObj1.x); // នៅតែ 5 ដដែល
        System.out.println("Object 2 x: " + myObj2.x); // ក្លាយជា 25
    }
}
```

**Output:**
```text
Object 1 x: 5
Object 2 x: 25
```

---

## 💻 ៥. គំរូអនុវត្តជាក់ស្តែង៖ Multiple Attributes

នៅក្នុងពិភពពិត Class មួយអាចផ្ទុក Attributes ច្រើនប្រភេទ ដើម្បីរៀបចំជាទិន្នន័យពេញលេញមួយ៖

```java
public class Person {
    String fname = "Dara";
    String lname = "Sok";
    int age = 22;

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("ឈ្មោះពេញ: " + person.fname + " " + person.lname);
        System.out.println("អាយុ: " + person.age + " ឆ្នាំ");
    }
}
```

**Output:**
```text
ឈ្មោះពេញ: Dara Sok
អាយុ: 22 ឆ្នាំ
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Attributes / Fields** គឺជាអថេរដែលកំណត់លក្ខណៈសម្បត្តិរបស់ Object នៅក្នុង Class។
> 2. ប្រើ **Dot Syntax (`object.attribute`)** ដើម្បីទាញយក ឬកែប្រែតម្លៃ។
> 3. Object នីមួយៗមាន Memory ផ្ទាល់ខ្លួន ដូច្នេះការកែប្រែ Attribute លើ Object មួយ មិនប៉ះពាល់ Object ដទៃឡើយ។
> 4. ប្រើ **`final`** នៅពីមុខ Attribute ប្រសិនបើអ្នកមិនចង់ឱ្យតម្លៃនោះត្រូវផ្លាស់ប្តូរ។

---

← [មេរៀនមុន (០២៖ Java Class និង Object)](../02-classes-and-objects/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៤៖ Java Class Methods)](../04-class-methods/README.md) →
