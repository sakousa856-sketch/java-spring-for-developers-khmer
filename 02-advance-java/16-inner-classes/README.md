# មេរៀនទី ១៦៖ Java Inner Classes (ថ្នាក់បង្កប់ក្នុង Java)

> **ស្វែងយល់អំពី Java Nested & Inner Classes៖ និយមន័យ របៀបបង្កើត Non-static Inner Class, Static Nested Class, Private Inner Class និងការទាញយកទិន្នន័យពី Outer Class**

[![Lesson](https://img.shields.io/badge/Lesson-16-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Inner%20Classes-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🏛️ ១. អ្វីជា Inner Class? (What is an Inner Class?)

នៅក្នុងភាសា Java, **Inner Class (ឬ Nested Class)** គឺជា Class មួយដែលត្រូវបានប្រកាសបង្កើតឡើងនៅ **ខាងក្នុង Class មួយផ្សេងទៀត** (Inside another Outer Class)។

### 🌟 ហេតុអ្វីត្រូវប្រើប្រាស់ Inner Classes?
1. 📦 **ការដាក់ជាក្រុមប្រកបដោយតក្កវិទ្យា (Logical Grouping):** ប្រសិនបើ Class មួយត្រូវបានប្រើប្រាស់ដោយ Class តែមួយគត់ វាជាការប្រសើរក្នុងការដាក់វាបញ្ចូលគ្នា។
2. 🔒 **បង្កើន Encapsulation:** Inner Class អាចចូលប្រើប្រាស់សូម្បីតែ `private` members របស់ Outer Class បាន ហើយខ្លួនវាក៏អាចកំណត់ជា `private` បានដែរ (ដែល Class ខាងក្រៅធម្មតាមិនអាចធ្វើបានឡើយ)។
3. 📖 **កូដងាយស្រួលអាន និងថែទាំ (Maintainability):** កូដដែលពាក់ព័ន្ធជិតស្និទ្ធស្ថិតនៅជិតគ្នា។

---

## 💻 ២. ការបង្កើត Inner Class ធម្មតា (Non-static Inner Class)

ដើម្បីបង្កើត Object នៃ Non-static Inner Class យើងត្រូវតែបង្កើត Object នៃ Outer Class ជាមុនសិន៖

```java
// Outer Class
class OuterClass {
    int x = 10;

    // Inner Class
    class InnerClass {
        int y = 5;
    }
}

public class Main {
    public static void main(String[] args) {
        // ១. បង្កើត Object នៃ OuterClass ជាមុន
        OuterClass myOuter = new OuterClass();

        // ២. បង្កើត Object នៃ InnerClass តាមរយៈ Outer Object
        OuterClass.InnerClass myInner = myOuter.new InnerClass();

        // ៣. បង្ហាញលទ្ធផល
        System.out.println("x + y = " + (myOuter.x + myInner.y));
    }
}
```

**Output:**
```text
x + y = 15
```

---

## 🔒 ៣. Private Inner Class (ការការពារមិនឱ្យក្រៅ Class ចូលប្រើ)

ផ្ទុយពី Class ធម្មតា Inner Class អាចត្រូវបានប្រកាសជា **`private`** ឬ **`protected`** បាន៖

```java
class OuterClass {
    int x = 10;

    // Private Inner Class: មិនអាច instantiate ចេញពី Main class បានទេ
    private class InnerClass {
        int y = 5;
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();
        // បន្ទាត់ខាងក្រោមនឹងបណ្តាលឱ្យមាន Compile Error:
        // OuterClass.InnerClass myInner = myOuter.new InnerClass(); // ❌ Error: InnerClass has private access
    }
}
```

---

## ⚡ ៤. Static Nested Class (មិនបាច់មាន Outer Object)

ប្រសិនបើ Inner Class ត្រូវបានប្រកាសជា **`static`** នោះយើងអាចបង្កើត Object របស់វាបានភ្លាមៗ ដោយមិនចាំបាច់បង្កើត Object នៃ Outer Class ឡើយ៖

```java
class OuterClass {
    int x = 10;

    // Static Nested Class
    static class InnerClass {
        int y = 5;
    }
}

public class Main {
    public static void main(String[] args) {
        // បង្កើត Inner Object បានភ្លាមៗដោយមិនបាច់មាន myOuter:
        OuterClass.InnerClass myInner = new OuterClass.InnerClass();
        System.out.println("y = " + myInner.y);
    }
}
```

> [!NOTE]
> Static Nested Class មិនអាចចូលប្រើប្រាស់ Non-static members (Instance variables) របស់ Outer Class ដោយផ្ទាល់បានឡើយ គឺអាចប្រើបានតែ Static members ប៉ុណ្ណោះ។

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Inner Class** គឺជា Class ដែលស្ថិតក្នុង Class មួយទៀត ដើម្បីបង្កើន Encapsulation និង Logical Grouping។
> 2. **Non-static Inner Class** ទាមទារ Outer Class Object (`myOuter.new InnerClass()`)។
> 3. **Static Nested Class** អាចបង្កើតបានភ្លាមៗ (`new OuterClass.InnerClass()`)។
> 4. Inner Class អាចទាញយក Attributes ទាំងអស់ (រួមទាំង `private`) របស់ Outer Class បាន។

---

← [មេរៀនមុន (១៥៖ Java Polymorphism)](../15-polymorphism/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៧៖ Java Abstraction)](../17-abstraction/README.md) →
