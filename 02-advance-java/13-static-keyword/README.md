# មេរៀនទី ១៣៖ static Keyword ក្នុង Java (ការគ្រប់គ្រង Memory លើកម្រិត Class)

> **ស្វែងយល់ស៊ីជម្រៅអំពីពាក្យគន្លឹះ static ក្នុង Java៖ យន្តការចែករំលែក Memory រវាង Objects ភាពខុសគ្នារវាង Static Variables, Static Methods, និង Static Blocks**

[![Lesson](https://img.shields.io/badge/Lesson-13-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-static%20Keyword-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## ⚡ ១. អ្វីជាពាក្យគន្លឹះ `static`? (What is `static` Keyword?)

នៅក្នុង Java, **`static`** គឺជា Non-Access Modifier មួយដែលត្រូវបានប្រើប្រាស់សម្រាប់គ្រប់គ្រង Memory ប្រកបដោយប្រសិទ្ធភាពខ្ពស់។ នៅពេលដែល Variable ឬ Method មួយត្រូវបានប្រកាសជា `static` មានន័យថាវា **ជារបស់ Class ទាំងមូល (Class-Level)** មិនមែនជារបស់ Object ណាមួយដោយឡែកឡើយ។

### 🎯 ចំណុចពិសេសនៃ `static`៖
* 🧠 **Memory តែមួយគត់ (Shared Memory):** Java បង្កើត Memory សម្រាប់ static member តែមួយកន្លែងគត់ក្នុង Class Area (Metaspace) ហើយគ្រប់ Objects ទាំងអស់ដែលបង្កើតចេញពី Class នោះចែករំលែកទិន្នន័យរួមគ្នានេះ។
* ⚡ **មិនបាច់បង្កើត Object:** អាចហៅប្រើប្រាស់បានភ្លាមៗតាមរយៈឈ្មោះ Class (`ClassName.staticMember`)។

---

## 📊 ២. ការប្រៀបធៀប៖ Static vs Instance Members

| លក្ខណៈវិនិច្ឆ័យ | Instance Variable / Method (Non-static) | Static Variable / Method (`static`) |
| :--- | :--- | :--- |
| **ភាពជាម្ចាស់** | ជារបស់ **Object នីមួយៗ** ដាច់ដោយឡែក | ជារបស់ **Class ទាំងមូល** (ចែករំលែករួម) |
| **ការបម្រុងទុក Memory** | បង្កើតថ្មីរាល់ពេលហៅ `new` (ក្នុង Heap) | បង្កើតតែម្តងគត់នៅពេល Class ត្រូវ Load ចូល Memory |
| **របៀបហៅប្រើ** | តាមរយៈ Object (`myObj.member`) | តាមរយៈឈ្មោះ Class (`MyClass.member`) |
| **ការប្រើប្រាស់ `this`** | អាចប្រើ `this` និង `super` បាន | **ដាច់ខាតមិនអាចប្រើ `this` ឬ `super` បានទេ** |

---

## 💻 ៣. ឧទាហរណ៍ទី ១៖ Static Variable (រាប់ចំនួន Objects)

ខាងក្រោមនេះជាគំរូនៃការប្រើប្រាស់ `static` ដើម្បីបង្កើត Counter រាប់ចំនួនសិស្សដែលបានចុះឈ្មោះ៖

```java
public class Student {
    int id;
    String name;
    // static variable: គ្រប់ Object សុទ្ធតែចែករំលែក count នេះជាមួយគ្នា
    static int count = 0;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        count++; // រាល់ពេលបង្កើត Object ថ្មី count នឹងកើន ១
    }

    public void display() {
        System.out.println("ID: " + id + " | ឈ្មោះ: " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Sophea");
        Student s2 = new Student(102, "Vathanak");
        Student s3 = new Student(103, "Dara");

        s1.display();
        s2.display();
        s3.display();

        // ទាញយក static variable តាមរយៈឈ្មោះ Class
        System.out.println("---------------------------------");
        System.out.println("ចំនួនសិស្សសរុបទាំងអស់: " + Student.count);
    }
}
```

**Output:**
```text
ID: 101 | ឈ្មោះ: Sophea
ID: 102 | ឈ្មោះ: Vathanak
ID: 103 | ឈ្មោះ: Dara
---------------------------------
ចំនួនសិស្សសរុបទាំងអស់: 3
```

---

## ⚙️ ៤. Static Methods និង Static Blocks

### ក. Static Methods:
* អាចហៅបានដោយផ្ទាល់ដោយមិនបាច់មាន Object។
* អាចចូលប្រើប្រាស់បានតែ **Static Variables** និងហៅបានតែ **Static Methods** ផ្សេងទៀតប៉ុណ្ណោះ។
* មិនអាចប្រើ `this` ឬ `super` keyword បានឡើយ។

```java
public class MathUtil {
    public static int add(int a, int b) {
        return a + b;
    }
}

// ការហៅប្រើប្រាស់:
int result = MathUtil.add(10, 20); // 30
```

### ខ. Static Block (Static Initializer):
ប្រើសម្រាប់ Initialize តម្លៃ Static Variables ស្មុគស្មាញ ហើយដំណើរការតែមួយដងគត់ នៅពេល Class ត្រូវបាន Load ចូលក្នុង JVM (ដំណើរការមុន Constructor និង `main` method)៖

```java
public class StaticBlockDemo {
    static int value;

    static {
        System.out.println("១. Static Block ដំណើរការមុនគេបង្អស់! ⚡");
        value = 100 * 2;
    }

    public static void main(String[] args) {
        System.out.println("២. Main Method ដំណើរការបន្ទាប់: Value = " + value);
    }
}
```

**Output:**
```text
១. Static Block ដំណើរការមុនគេបង្អស់! ⚡
២. Main Method ដំណើរការបន្ទាប់: Value = 200
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **`static`** ភ្ជាប់សមាជិកទៅកាន់ Class ជាជាង Object។
> 2. ជួយសន្សំសំចៃ Memory ព្រោះមានការបង្កើតទំហំផ្ទុកតែម្តងគត់។
> 3. Static Methods អាចហៅបានតាម `ClassName.methodName()` ដោយមិនបាច់បង្កើត Object។
> 4. Static Methods មិនអាចហៅ Non-static fields ឬ methods ដោយផ្ទាល់បានឡើយ។

---

← [មេរៀនមុន (១២៖ Java Method Overriding)](../12-method-overriding/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៤៖ final Keyword ក្នុង Java)](../14-final-keyword/README.md) →
