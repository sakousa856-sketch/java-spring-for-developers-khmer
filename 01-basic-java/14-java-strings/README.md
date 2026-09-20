# មេរៀនទី ១៤៖ Java Strings (ខ្សែអក្សរក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពី Java Strings៖ ការប្រកាសខ្សែអក្សរ String Methods សំខាន់ៗ ការតភ្ជាប់ String (Concatenation) និង Escape Sequences ពិសេស**

[![Lesson](https://img.shields.io/badge/Lesson-14-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Strings-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🔤 ១. អ្វីជា Java Strings? (What is a String?)

នៅក្នុងភាសា Java, **String** គឺជាប្រភេទនៃទិន្នន័យ (Data Type) សម្រាប់រក្សាទុកនូវបណ្តុំតួអក្សរ ពាក្យ ឬឃ្លា (Text/Characters)។ តម្លៃនៃ String ត្រូវតែស្ថិតនៅក្នុងរង្វង់សញ្ញាសម្រង់ពីរ (`" "`)។

> [!NOTE]
> * មិនដូច Primitive types (ដូចជា `int`, `double`, `boolean`) នោះទេ **String** គឺជា **Object / Reference Type** ដែលភ្ជាប់មកជាមួយនូវ built-in methods ជាច្រើនសម្រាប់ដំណើរការលើទិន្នន័យអក្សរ។
> * String ក្នុង Java មានលក្ខណៈ **Immutable** (នៅពេលបង្កើតរួច តម្លៃដើមមិនអាចកែប្រែបានឡើយ ការផ្លាស់ប្តូរណាមួយនឹងបង្កើត Object ថ្មី)។

### 💻 ទម្រង់ Syntax និងការប្រកាស String:

```java
String variableName = "Hello World";
```

---

## 🛠️ ២. Methods សំខាន់ៗរបស់ String (Common String Methods)

Java បានផ្ដល់ជូននូវ Method ជាច្រើនដើម្បីសម្រួលដល់ការគ្រប់គ្រង និងទាញទិន្នន័យពី String៖

| Method | ការពិពណ៌នា (Description) | ឧទាហរណ៍កូដ | លទ្ធផល (Output) |
| :--- | :--- | :--- | :--- |
| **`length()`** | រាប់ចំនួនតួអក្សរសរុបក្នុង String | `"Hello".length()` | `5` |
| **`toUpperCase()`** | បំប្លែងតួអក្សរទាំងអស់ទៅជាអក្សរធំ | `"Hello".toUpperCase()` | `"HELLO"` |
| **`toLowerCase()`** | បំប្លែងតួអក្សរទាំងអស់ទៅជាអក្សរតូច | `"Hello".toLowerCase()` | `"hello"` |
| **`indexOf(str)`** | រកទីតាំង index ដំបូងនៃពាក្យ/អក្សរ (គិតពី 0) | `"Hello".indexOf("e")` | `1` |
| **`charAt(index)`** | ទាញយកតួអក្សរមួយតាមរយៈ index | `"Hello".charAt(0)` | `'H'` |
| **`concat(str)`** | ភ្ជាប់ String មួយជាមួយ String មួយទៀត | `"Hi".concat(" World")` | `"Hi World"` |

### 💻 ឧទាហរណ៍កូដបង្ហាញពី String Methods:

```java
public class StringMethodsDemo {
    public static void main(String[] args) {
        String greeting = "Hello World";

        // ១. រាប់ចំនួនតួអក្សរ
        System.out.println("Length: " + greeting.length());

        // ២. បំប្លែងទៅជាអក្សរធំ
        System.out.println("Upper Case: " + greeting.toUpperCase());

        // ៣. បំប្លែងទៅជាអក្សរតូច
        System.out.println("Lower Case: " + greeting.toLowerCase());

        // ៤. ស្វែងរក index នៃពាក្យ "World"
        System.out.println("Index of 'World': " + greeting.indexOf("World"));
    }
}
```

```text
Output:
Length: 11
Upper Case: HELLO WORLD
Lower Case: hello world
Index of 'World': 6
```

---

## 🔗 ៣. ការតភ្ជាប់ Strings (String Concatenation)

យើងអាចធ្វើការតភ្ជាប់ String ពីរ ឬច្រើនបញ្ចូលគ្នាបានតាម ២ វិធីចម្បង៖

### របៀបទី ១៖ ប្រើប្រាស់សញ្ញាបូក (`+`) — និយមប្រើបំផុត
```java
String firstName = "John";
String lastName = "Doe";
String fullName = firstName + " " + lastName;
System.out.println(fullName); // John Doe
```

### របៀបទី ២៖ ប្រើប្រាស់ Method `concat()`
```java
String firstName = "John ";
String lastName = "Doe";
System.out.println(firstName.concat(lastName)); // John Doe
```

---

## 🔢 ៤. ការបូកលេខ និងតួអក្សរ (Adding Numbers and Strings)

> [!WARNING]
> **ប្រុងប្រយ័ត្ន៖** សញ្ញា `+` នៅក្នុង Java ដើរតួជា **ការបូកលេខ (Addition)** ផង និងជា **ការតភ្ជាប់ខ្សែអក្សរ (Concatenation)** ផង៖
> * លេខ + លេខ = លេខ (គណិតវិទ្យា)
> * String + String = String (តភ្ជាប់)
> * លេខ + String = String (Java នឹងបំប្លែងលេខទៅជា String រួចតភ្ជាប់គ្នា)

### 💻 ឧទាហរណ៍ប្រៀបធៀប៖

```java
public class StringAdditionDemo {
    public static void main(String[] args) {
        int x = 10;
        String y = "20";
        String z = "30";

        System.out.println("x + y = " + (x + y));       // 1020 (String)
        System.out.println("y + z = " + (y + z));       // 2030 (String)

        int a = 10;
        int b = 20;
        System.out.println("a + b = " + (a + b));       // 30 (គណិតវិទ្យា)
        System.out.println("a + b + y = " + (a + b + y)); // 3020 (30 + "20")
    }
}
```

```text
Output:
x + y = 1020
y + z = 2030
a + b = 30
a + b + y = 3020
```

---

## 🔣 ៥. សញ្ញាពិសេស និង Escape Sequences (Special Characters)

ដោយសារតែ String ត្រូវបានរុំព័ទ្ធដោយសញ្ញាសម្រង់ពីរ (`" "`) ប្រសិនបើយើងចង់សរសេរពាក្យដែលមាន `"` ឬ `'` ឬ `\` នៅខាងក្នុងនោះ Java នឹងបង្កើតជា syntax error។ ដើម្បីដោះស្រាយ យើងត្រូវប្រើ **Escape Character (`\`)** (Backslash)។

### 📊 តារាង Escape Sequences សំខាន់ៗក្នុង Java

| Escape Sequence | តួអក្សរដែលទទួលបាន (Character) | ការពិពណ៌នា (Description) |
| :---: | :---: | :--- |
| `\"` | `"` | សញ្ញាសម្រង់ពីរ (Double quote) |
| `\'` | `'` | សញ្ញាសម្រង់ទោល (Single quote) |
| `\\` | `\` | សញ្ញា Backslash |
| `\n` | Newline | ចុះបន្ទាត់ថ្មី |
| `\t` | Tab | គម្លាតថេប (Tab space) |

### 💻 ឧទាហរណ៍កូដជាក់ស្តែង៖

```java
public class EscapeCharactersDemo {
    public static void main(String[] args) {
        // ១. ប្រើប្រាស់ Double Quote ក្នុង String
        String quote = "We are the so-called \"Vikings\" from the north.";
        System.out.println(quote);

        // ២. ប្រើប្រាស់ Single Quote និង Backslash
        String text = "It\'s alright. The character \\ is called backslash.";
        System.out.println(text);

        // ៣. ប្រើប្រាស់ Newline (\n) និង Tab (\t)
        System.out.println("\n--- បង្ហាញការចុះបន្ទាត់ និង Tab ---");
        System.out.println("Hello\nWorld");
        System.out.println("Column1\tColumn2\tColumn3");
    }
}
```

```text
Output:
We are the so-called "Vikings" from the north.
It's alright. The character \ is called backslash.

--- បង្ហាញការចុះបន្ទាត់ និង Tab ---
Hello
World
Column1	Column2	Column3
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ៗ (Key Takeaways)

> [!TIP]
> 1. **String ជា Reference Type:** ប្រើ double quotes (`"..."`) ដើម្បីប្រកាសតម្លៃ។
> 2. **Methods ចម្បងៗ:** `length()` រាប់ចំនួនអក្សរ, `toUpperCase()` / `toLowerCase()` ប្ដូរទម្រង់អក្សរ, `indexOf()` រកទីតាំង index។
> 3. **Concatenation:** ប្រើប្រមាណវិធី `+` ឬ method `concat()` ដើម្បីភ្ជាប់ String ចូលគ្នា។
> 4. **Operator `+` ជាមួយ String:** កាលណាមាន String ចូលរួម ការបូកលេខនឹងក្លាយជាការភ្ជាប់អក្សរភ្លាមៗ។
> 5. **Escape Sequences:** ប្រើ `\"` សម្រាប់សម្រង់ពីរ, `\n` សម្រាប់ចុះបន្ទាត់, និង `\t` សម្រាប់ដកឃ្លា tab។

---

← [មេរៀនមុន (Java Mathematic)](../13-java-mathematic/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (Java If..Else)](../15-java-if-else/README.md) →
