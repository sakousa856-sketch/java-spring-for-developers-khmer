# មេរៀនទី ៨៖ Java Variables (អថេរក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពីអថេរក្នុង Java៖ និយមន័យ ប្រភេទនៃទិន្នន័យ របៀបប្រកាស គោលការណ៍ដាក់ឈ្មោះ និងពាក្យគន្លឹះ final**

[![Lesson](https://img.shields.io/badge/Lesson-08-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Variables-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 📦 ១. អ្វីជាអថេរ? (What is a Variable?)

**Variable (អថេរ)** គឺជាឈ្មោះនៃទីតាំងអង្គចងចាំ (Memory Location) ដែលប្រើសម្រាប់**ផ្ទុក និងរក្សាទុកនូវទិន្នន័យ**នៅក្នុង Program កំឡុងពេលដំណើរការ។

### 📊 តារាងប្រភេទអថេរ និងទិន្នន័យចម្បងៗក្នុង Java

| ប្រភេទអថេរ (Type) | ការពិពណ៌នា និងទំហំផ្ទុក | ដែនកំណត់តម្លៃ (Range / Value) |
| :---: | :--- | :--- |
| `byte` | លេខចំនួនគត់តូច | -១២៨ ទៅ ១២៧ |
| `short` | លេខចំនួនគត់មធ្យម | -៣២,៧៦៨ ទៅ ៣២,៧៦៧ |
| `int` | លេខចំនួនគត់ស្តង់ដារ (ប្រើច្រើនបំផុត) | -២,១៤៧,៤៨៣,៦៤៨ ទៅ ២,១៤៧,៤៨៣,៦៤៧ |
| `long` | លេខចំនួនគត់ធំខ្លាំង | ច្រើនជាង `int` (សម្រាប់ទិន្នន័យលេខធំៗ) |
| `float` | លេខប្រភាគទសភាគ (Single precision) | ផ្ទុកទសភាគបាន ៦-៧ ខ្ទង់ |
| `double` | លេខប្រភាគទសភាគ (Double precision) | ផ្ទុកទសភាគបាន ១៥-១៦ ខ្ទង់ |
| `boolean` | តម្លៃតក្កវិទ្យា | `true` (ពិត) ឬ `false` (មិនពិត) |
| `char` | តួអក្សរទោល (Single character) | តួអក្សរតែមួយគត់ ក្នុងសញ្ញា `' '` (ឧទាហរណ៍ `'A'`) |
| `String` | ខ្សែអក្សរ (Text/Words) | សំណុំតួអក្សរជាច្រើន ក្នុងសញ្ញា `" "` (ឧទាហរណ៍ `"Java"`) |

---

## 📝 ២. របៀបប្រកាសអថេរ (Declaring Variables)

### 💻 ទម្រង់ Syntax ស្តង់ដារ:

```java
type variableName = value;
```

> [!NOTE]
> **ការពន្យល់ធាតុផ្សំនៃ Syntax:**
> * `type`: គឺជាប្រភេទនៃទិន្នន័យ (Data Type) ដូចជា `String`, `int`, `double`, `boolean`...
> * `variableName`: គឺជាឈ្មោះអថេរដែលយើងកំណត់ឱ្យសម្គាល់ទិន្នន័យនោះ
> * `value`: គឺជាតម្លៃជាក់ស្តែងដែលយើងកំណត់ទៅឱ្យអថេរ

### 🔍 ការបង្ហាញតម្លៃ និងការភ្ជាប់ String (Concatenation):
* យើងប្រើប្រាស់ Method `System.out.println()` ដើម្បីបង្ហាញតម្លៃអថេរលើ Console Screen។
* យើងប្រើប្រមាណវិធី `+` ដើម្បីភ្ជាប់ String ជាមួយ String ឬ String ជាមួយលេខ។ (តែបើលេខបូកលេខ វានឹងធ្វើប្រមាណវិធីបូកលេខធម្មតា)។

---

## 🎯 ៣. គោលការណ៍បង្កើតឈ្មោះអថេរ (Variable Naming Rules)

> [!IMPORTANT]
> **វិធានច្បាប់ដែលត្រូវតែគោរព (Strict Rules):**
> 1. 🔤 **តួអក្សរដើមគេ:** ត្រូវតែចាប់ផ្តើមដោយតួអក្សរ (a-z, A-Z), សញ្ញា underscore (`_`), ឬ dollar sign (`$`)។ មិនអាចចាប់ផ្តើមដោយលេខឡើយ។
> 2. 🔢 **តួអក្សរបន្ទាប់:** អាចផ្សំដោយតួអក្សរ និងលេខ (0-9) បាន។
> 3. 🚫 **សញ្ញាពិសេស:** មិនអនុញ្ញាតឱ្យប្រើសញ្ញាផ្សេងៗឡើយ (ដូចជា `-`, `@`, `!`, `%`) លើកលែងតែ `_` និង `$`។
> 4. ⛔ **ពាក្យបម្រុងទុក (Reserved Keywords):** មិនអាចយកពាក្យ Keyword របស់ Java មកធ្វើជាឈ្មោះអថេរបានទេ (ដូចជា `class`, `public`, `int`, `static`...)។

### 💡 ទម្លាប់សរសេរកូដល្អ (Best Practices & Case Sensitivity):
* **Case Sensitive:** ភាសា Java ប្រកាន់អក្សរតូចធំ ឧទាហរណ៍ `myVar` និង `myvar` គឺជាអថេរពីរផ្សេងគ្នាដាច់ស្រឡះ!
* **camelCase Convention:** គួរចាប់ផ្តើមដោយអក្សរតូច ហើយបើមានច្រើនពាក្យ ពាក្យបន្ទាប់ត្រូវផ្តើមដោយអក្សរធំ (ឧទាហរណ៍ `firstName`, `studentAge`)។ មិនអនុញ្ញាតឱ្យដកឃ្លាឡើយ។

---

## 💻 ៤. កូដគំរូអនុវត្តជាក់ស្តែង (Practical Code Examples)

### ឧទាហរណ៍ទី ១៖ ការប្រកាស និងភ្ជាប់ខ្សែអក្សរ (String Concatenation)

```java
public class VariableExample {
    public static void main(String[] args) {
        String firstName = "John ";
        String lastName = "Doe";
        
        // ភ្ជាប់ firstName និង lastName ចូលគ្នាដោយប្រើ +
        String fullName = firstName + lastName;
        
        System.out.println("Full Name: " + fullName);
    }
}
```

**Output:**
```text
Full Name: John Doe
```

---

### ឧទាហរណ៍ទី ២៖ អថេរថេរដែលមិនអាចកែប្រែបាន (Constant with `final` Keyword)

> [!TIP]
> នៅពេលយើងដាក់ Keyword **`final`** នៅពីមុខអថេរ មានន័យថាអថេរនោះក្លាយជា **Constant (តម្លៃថេរ)** ដែលមិនអាចផ្លាស់ប្តូរ ឬកែប្រែតម្លៃបានឡើយ។ បើយើងព្យាយាមកែប្រែ នោះ Compiler នឹងបោះ Error ភ្លាម។

```java
public class FinalVariableDemo {
    public static void main(String[] args) {
        final int MAX_SCORE = 100;
        
        System.out.println("Max Score: " + MAX_SCORE);
        
        // បន្ទាត់ខាងក្រោមនឹងបណ្តាលឱ្យមាន Error ព្រោះ MAX_SCORE ជា final:
        // MAX_SCORE = 200; // ❌ Compile Error: cannot assign a value to final variable
    }
}
```

---

## 💡 សេចក្តីសង្ខេប (Summary)
* អថេរប្រើសម្រាប់ផ្ទុកទិន្នន័យក្នុង Memory។
* ត្រូវកំណត់ប្រភេទ Data Type ឱ្យបានត្រឹមត្រូវមុននឹងប្រើប្រាស់ (`int`, `double`, `String`, etc.)។
* ឈ្មោះអថេរត្រូវអនុវត្តតាមទម្រង់ camelCase និងមានលក្ខណៈ Case Sensitive។
* ប្រើ `final` ដើម្បីការពារកុំឱ្យតម្លៃអថេរត្រូវផ្លាស់ប្តូរ។

---

← [មេរៀនមុន (០៧៖ Java Comments)](../07-java-comments/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៩៖ Java Data Types)](../09-java-data-types/README.md) →
