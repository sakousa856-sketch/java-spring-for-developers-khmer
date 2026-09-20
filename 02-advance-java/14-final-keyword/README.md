# មេរៀនទី ១៤៖ final Keyword ក្នុង Java (ការកំណត់លក្ខខណ្ឌមិនអាចកែប្រែបាន)

> **ស្វែងយល់ស៊ីជម្រៅអំពីពាក្យគន្លឹះ final ក្នុង Java៖ ការបង្កើត Constant Variables ការការពារកុំឱ្យ Override Method និងការទប់ស្កាត់ការធ្វើ Inheritance លើ Class**

[![Lesson](https://img.shields.io/badge/Lesson-14-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-final%20Keyword-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🔒 ១. អ្វីជាពាក្យគន្លឹះ `final`? (What is `final` Keyword?)

នៅក្នុង Java, **`final`** គឺជា Non-Access Modifier មួយដែលត្រូវបានប្រើប្រាស់ដើម្បី **ដាក់កម្រិត (Restrict)** មិនឱ្យមានការកែប្រែតម្លៃ ឬផ្លាស់ប្តូរទម្រង់កូដនៅពេលក្រោយ។ ពាក្យគន្លឹះ `final` អាចត្រូវបានអនុវត្តលើ ៣ ទីតាំងសំខាន់ៗ៖

1. 🔢 **Final Variable:** បង្កើតជា **តម្លៃថេរ (Constant)** ដែលមិនអាចកែប្រែតម្លៃបានឡើយ។
2. ⚙️ **Final Method:** ការពារកុំឱ្យ Subclass អាចធ្វើការ **Override** បាន។
3. 🏛️ **Final Class:** ការពារកុំឱ្យ Class ផ្សេងទៀតអាចធ្វើការ **Inherit (extends)** បាន។

---

## 🛑 ២. ការអនុវត្ត `final` លើ Variables, Methods និង Classes

### ក. Final Variable (មិនអាចផ្លាស់ប្តូរតម្លៃ)
```java
public class Main {
    public static void main(String[] args) {
        final int SPEED_LIMIT = 90; // Constant
        
        // ប្រសិនបើយើងព្យាយាមកែប្រែតម្លៃ:
        // SPEED_LIMIT = 120; // ❌ Compile Error: cannot assign a value to final variable
        
        System.out.println("ល្បឿនកំណត់: " + SPEED_LIMIT + " km/h");
    }
}
```

### ខ. Final Method (ការពារ Method Overriding)
```java
class SuperClass {
    // Subclass មិនអាច Override method នេះបានទេ
    public final void secureProcess() {
        System.out.println("ដំណើរការសុវត្ថិភាពសំខាន់ មិនអនុញ្ញាតឱ្យកែប្រែឡើយ! 🛡️");
    }
}

class SubClass extends SuperClass {
    // បន្ទាត់ខាងក្រោមនឹង Error ព្រោះ secureProcess() ជា final:
    // @Override
    // public void secureProcess() { ... } // ❌ Error: cannot override final method
}
```

### គ. Final Class (ការពារការផ្ទេរមរតក Inheritance)
```java
// Final Class មិនអនុញ្ញាតឱ្យនរណា extends បានឡើយ
final class ImmutableConfig {
    String appKey = "SECRET_12345";
}

// បន្ទាត់ខាងក្រោមនឹង Error ព្រោះ ImmutableConfig ជា final:
// class ChildConfig extends ImmutableConfig { } // ❌ Error: cannot inherit from final class
```

> [!NOTE]
> នៅក្នុង Java Standard Library, Class ដ៏ល្បីល្បាញជាច្រើនត្រូវបានប្រកាសជា `final` ដូចជា `java.lang.String`, `java.lang.Math`, និង Wrapper Classes (`Integer`, `Double`, etc.) ដើម្បីធានាសុវត្ថិភាពខ្ពស់ និងរក្សាភាព Immutable។

---

## ⚖️ ៣. តារាងសង្ខេបផលប៉ះពាល់នៃពាក្យគន្លឹះ `final`

| ទីតាំងអនុវត្ត | ស្ថានភាពធម្មតា (Without `final`) | នៅពេលប្រើប្រាស់ `final` |
| :--- | :--- | :--- |
| **Variable** | អាច Re-assign តម្លៃថ្មីបានគ្រប់ពេល | **មិនអាចកែប្រែតម្លៃបានឡើយ (Constant)** |
| **Method** | Subclass អាច Override បានតាមចិត្ត | **ហាមឃាត់ការ Override ដាច់ខាត** |
| **Class** | Class ផ្សេងអាច `extends` បាន | **ហាមឃាត់ការធ្វើ Inheritance ទាំងស្រុង** |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. ប្រើ **`final variable`** ដើម្បីបង្កើតតម្លៃថេរ (Constant) ដែលគួរតែសរសេរឈ្មោះជាអក្សរធំទាំងអស់ (ដូចជា `MAX_VALUE`)។
> 2. ប្រើ **`final method`** ដើម្បីធានាថា Logic ស្នូលរបស់ Class មេមិនត្រូវបានបំភ្លៃ ឬកែប្រែដោយកូនចៅ។
> 3. ប្រើ **`final class`** នៅពេលអ្នកចង់បង្កើត Class ដែលមានសុវត្ថិភាពខ្ពស់ មិនចង់ឱ្យនរណាពង្រីក (Subclass) បាន។

---

← [មេរៀនមុន (១៣៖ static Keyword ក្នុង Java)](../13-static-keyword/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៥៖ Java Polymorphism)](../15-polymorphism/README.md) →
