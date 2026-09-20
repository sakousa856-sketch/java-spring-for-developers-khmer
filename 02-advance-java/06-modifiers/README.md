# មេរៀនទី ៦៖ Java Modifiers (កម្រិតសិទ្ធិ និងលក្ខខណ្ឌពិសេសក្នុង Java)

> **ស្វែងយល់លម្អិតអំពី Java Modifiers៖ ការកំណត់សិទ្ធិចូលប្រើប្រាស់ (Access Modifiers) និងលក្ខខណ្ឌពិសេសនៃកូដ (Non-Access Modifiers) ព្រមទាំងតារាង Accessibility Matrix ស្តង់ដារ**

[![Lesson](https://img.shields.io/badge/Lesson-06-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Modifiers-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🛡️ ១. អ្វីជា Java Modifiers? (Overview of Modifiers)

នៅក្នុង Java, **Modifiers** គឺជាពាក្យគន្លឹះ (Keywords) ដែលយើងបន្ថែមពីមុខ Class, Attribute, Method ឬ Constructor ដើម្បីកំណត់ **កម្រិតសិទ្ធិនៃការចូលប្រើប្រាស់ (Access Level)** ឬកំណត់ **លក្ខណៈពិសេសនៃដំណើរការ (Behavior)**។

Modifiers ត្រូវបានបែងចែកជា ២ ក្រុមធំៗ៖
1. 🔐 **Access Modifiers:** កំណត់កម្រិតសិទ្ធិចូលប្រើប្រាស់កូដ។
2. ⚙️ **Non-Access Modifiers:** កំណត់មុខងារពិសេសផ្សេងៗ (ដូចជា ភាពថេរ, ការគ្រប់គ្រង Memory, ការធ្វើ Thread Safety)។

---

## 🔐 ២. Access Modifiers ទាំង ៤ (Four Access Levels)

Java ផ្តល់នូវ Access Modifiers ចំនួន ៤ កម្រិត៖

| Modifier | Class ផ្ទាល់ | ក្នុង Package តែមួយ | Subclass (ក្រៅ Package) | ពិភពខាងក្រៅ (Everywhere) |
| :---: | :---: | :---: | :---: | :---: |
| **`public`** | ✅ | ✅ | ✅ | ✅ |
| **`protected`** | ✅ | ✅ | ✅ | ❌ |
| **`default`** *(គ្មាន keyword)* | ✅ | ✅ | ❌ | ❌ |
| **`private`** | ✅ | ❌ | ❌ | ❌ |

### ការពន្យល់លម្អិតអំពី Access Modifiers នីមួយៗ៖
* 🌐 **`public`:** អាចចូលប្រើបានពីគ្រប់ទីកន្លែងក្នុងគម្រោង (All Classes & All Packages)។
* 📦 **`default` (Package-Private):** បើមិនសរសេរ Modifier អ្វីទាំងអស់ មានន័យថាជា default ដែលអាចចូលប្រើបានតែ Classes ក្នុង Package ជាមួយគ្នាប៉ុណ្ណោះ។
* 🛡️ **`protected`:** អាចចូលប្រើបានដោយ Classes ក្នុង Package ជាមួយគ្នា និងដោយ **Subclasses** (កូនចៅដែល Inherit ទៅ) ទោះបីនៅក្រៅ Package ក៏ដោយ។
* 🔒 **`private`:** កម្រិតសុវត្ថិភាពខ្ពស់បំផុត អាចចូលប្រើបានតែនៅក្នុង Class ដែលបានប្រកាសនោះតែប៉ុណ្ណោះ។

---

## ⚙️ ៣. Non-Access Modifiers ចម្បងៗ (Non-Access Modifiers)

Non-Access Modifiers មិនគ្រប់គ្រងលើកម្រិតសិទ្ធិទេ ប៉ុន្តែគ្រប់គ្រងលើមុខងាររបស់កូដ៖

| Modifier | អនុវត្តលើ | ការពិពណ៌នា និងមុខងារ |
| :--- | :--- | :--- |
| **`final`** | Variable, Method, Class | មិនអាចកែប្រែតម្លៃបាន (Constant), មិនអាច Override បាន, មិនអាច Inherit បាន |
| **`static`** | Variable, Method, Block | ជារបស់ Class មិនមែនជារបស់ Object ឡើយ (ចែករំលែកទិន្នន័យរួមគ្នា) |
| **`abstract`** | Class, Method | ប្រើសម្រាប់ Abstraction (មិនអាច instantiate បាន, Method គ្មាន body) |
| **`synchronized`** | Method, Block | ប្រើក្នុង Multi-threading (អនុញ្ញាតឱ្យ Thread តែមួយដំណើរការក្នុងពេលតែមួយ) |
| **`transient`** | Variable | រំលងមិន Serialization ទៅកាន់ File ឬ Network ឡើយ |
| **`volatile`** | Variable | តម្លៃអថេរត្រូវអានចេញពី Main Memory ដោយផ្ទាល់ ( Thread Visibility) |

---

## 💻 ៤. កូដគំរូអនុវត្តជាក់ស្តែង (Practical Code Example)

ខាងក្រោមនេះជាគំរូនៃការប្រើប្រាស់ `public` និង `private` ក្នុង Class តែមួយ៖

```java
public class Account {
    // 1. public: នរណាក៏អាចមើលឃើញបាន
    public String accountHolder = "Sok San";

    // 2. private: អាចប្រើបានតែក្នុង Class Account នេះប៉ុណ្ណោះ
    private double balance = 1500.0;

    // Method បង្ហាញ balance (public method អាន private data)
    public void showBalance() {
        System.out.println("សមតុល្យគណនី: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Account acc = new Account();
        System.out.println("ម្ចាស់គណនី: " + acc.accountHolder); // ✅ អានបាន

        // បន្ទាត់ខាងក្រោមនឹងបណ្តាលឱ្យមាន Compile Error ព្រោះ balance ជា private:
        // System.out.println(acc.balance); // ❌ Error: balance has private access

        acc.showBalance(); // ✅ អានតាមរយៈ public method បានត្រឹមត្រូវ
    }
}
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Access Modifiers** រួមមាន `public`, `protected`, `default` (no modifier), និង `private`។
> 2. ដើម្បីធានាសុវត្ថិភាពទិន្នន័យ (Encapsulation) គួរតែប្រកាស Attributes ភាគច្រើនជា **`private`**។
> 3. **Non-Access Modifiers** ដូចជា `final`, `static`, និង `abstract` កំណត់លក្ខណៈពិសេសរបស់ Class, Method, និង Field។

---

← [មេរៀនមុន (០៥៖ Java Constructors)](../05-constructors/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៧៖ Java Encapsulation)](../07-encapsulation/README.md) →
