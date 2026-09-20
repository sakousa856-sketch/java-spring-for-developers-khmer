# មេរៀនទី ១៥៖ Java If..Else (លក្ខខណ្ឌសម្រេចចិត្តក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពីការគ្រប់គ្រងលំហូរកម្មវិធី (Control Flow) តាមរយៈលក្ខខណ្ឌ If, If..Else, If..Else If និង Short-hand If..Else (Ternary Operator)**

[![Lesson](https://img.shields.io/badge/Lesson-15-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20If--Else-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🚦 ១. សេចក្តីផ្តើមអំពីលក្ខខណ្ឌសម្រេចចិត្ត (Conditional Statements)

នៅក្នុងការសរសេរកម្មវិធី យើងតែងតែត្រូវការឱ្យកុំព្យូទ័រធ្វើការសម្រេចចិត្តផ្អែកលើស្ថានភាពជាក់ស្តែង (ឧទាហរណ៍៖ ប្រសិនបើពិន្ទុលើសពី ៥០ ជាប់ បើមិនដូច្នោះទេធ្លាក់)។

Java គាំទ្រប្រមាណវិធីតក្កវិទ្យា (Logical Conditions) ពីគណិតវិទ្យា៖
* តូចជាង៖ `a < b`
* តូចជាង ឬស្មើ៖ `a <= b`
* ធំជាង៖ `a > b`

* ធំជាង ឬស្មើ៖ `a >= b`

* ស្មើគ្នា៖ `a == b`
* មិនស្មើគ្នា៖ `a != b`

### 📋 Statements សម្រាប់កំណត់លក្ខខណ្ឌក្នុង Java៖
1. **`if`**: ប្រើសម្រាប់ប្រតិបត្តិកូដ ប្រសិនបើលក្ខខណ្ឌដែលបានកំណត់គឺ **ពិត (`true`)**
2. **`else`**: ប្រើសម្រាប់ប្រតិបត្តិកូដ ប្រសិនបើលក្ខខណ្ឌខាងលើ **មិនពិត (`false`)**
3. **`else if`**: ប្រើសម្រាប់បន្ថែមលក្ខខណ្ឌថ្មីដើម្បីពិនិត្យ ប្រសិនបើលក្ខខណ្ឌដំបូងមិនពិត
4. **`switch`**: ប្រើសម្រាប់ជ្រើសរើសប្លុកកូដមួយក្នុងចំណោមជម្រើសជាច្រើន (សិក្សាលម្អិតនៅមេរៀនទី ១៦)

---

## ⚙️ ២. ទម្រង់ Syntax និងឧទាហរណ៍ (Syntax & Examples)

### ២.១ `if` Statement (លក្ខខណ្ឌទោល)

ប្រើនៅពេលយើងចង់ឱ្យកូដដំណើរការតែក្នុងករណីលក្ខខណ្ឌពិតតែមួយគត់៖

```java
if (condition) {
    // កូដនឹងដំណើរការ ប្រសិនបើ condition = true
}
```

```java
public class IfDemo {
    public static void main(String[] args) {
        int x = 20;
        int y = 18;

        if (x > y) {
            System.out.println("x is greater than y");
        }
    }
}
```

```text
Output:
x is greater than y
```

---

### ២.២ `if...else` Statement (លក្ខខណ្ឌពីរផ្លូវ)

ប្រើនៅពេលយើងមាន ២ ជម្រើស — បើពិតធ្វើរឿងមួយ បើមិនពិតធ្វើរឿងមួយទៀត៖

```java
if (condition) {
    // កូដដំណើរការ ប្រសិនបើ condition = true
} else {
    // កូដដំណើរការ ប្រសិនបើ condition = false
}
```

```java
public class IfElseDemo {
    public static void main(String[] args) {
        int time = 20;

        if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
    }
}
```

```text
Output:
Good evening.
```

---

### ២.៣ `if...else if...else` Statement (លក្ខខណ្ឌច្រើនជម្រើស)

ប្រើនៅពេលយើងមានលក្ខខណ្ឌជាច្រើនដែលត្រូវត្រួតពិនិត្យតាមលំដាប់លំដោយ៖

```java
if (condition1) {
    // កូដដំណើរការ ប្រសិនបើ condition1 = true
} else if (condition2) {
    // កូដដំណើរការ ប្រសិនបើ condition1 = false ហើយ condition2 = true
} else {
    // កូដដំណើរការ ប្រសិនបើគ្រប់លក្ខខណ្ឌខាងលើ = false
}
```

```java
public class IfElseIfDemo {
    public static void main(String[] args) {
        int time = 22;

        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 20) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
    }
}
```

```text
Output:
Good evening.
```

---

## ⚡ ៣. Short Hand If...Else (Ternary Operator)

**Ternary Operator (`? :`)** គឺជាវិធីកាត់បន្ថយកូដ `if...else` ធម្មតាឱ្យនៅសល់ត្រឹមតែ **១ បន្ទាត់** យ៉ាងខ្លី និងស្អាត។

### 💻 ទម្រង់ Syntax៖

```java
variable = (condition) ? expressionTrue : expressionFalse;
```

> [!NOTE]
> ប្រសិនបើ `condition` គឺ **`true`** នោះតម្លៃ `expressionTrue` នឹងត្រូវប្រគល់ឱ្យ `variable`។ បើ **`false`** នោះតម្លៃ `expressionFalse` នឹងត្រូវប្រគល់ឱ្យវិញ។

### 💻 ឧទាហរណ៍ប្រៀបធៀប៖

```java
public class TernaryDemo {
    public static void main(String[] args) {
        int time = 20;

        // ប្រើ Short Hand If...Else
        String result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

        // ឧទាហរណ៍ពិនិត្យលេខគូ ឬសេស
        int number = 15;
        String checkEvenOdd = (number % 2 == 0) ? "លេខគូ (Even)" : "លេខសេស (Odd)";
        System.out.println(number + " គឺជា " + checkEvenOdd);
    }
}
```

```text
Output:
Good evening.
15 គឺជា លេខសេស (Odd)
```

---

## 🎓 ៤. ឧទាហរណ៍អនុវត្តជាក់ស្តែង (Real-world Example)

កម្មវិធីគណនានិទ្ទេសសិស្សផ្អែកលើពិន្ទុ (Student Grade Evaluation)៖

```java
public class GradeEvaluation {
    public static void main(String[] args) {
        int score = 85;

        if (score >= 90) {
            System.out.println("Grade: A (ល្អប្រសើរ)");
        } else if (score >= 80) {
            System.out.println("Grade: B (ល្អណាស់)");
        } else if (score >= 70) {
            System.out.println("Grade: C (ល្អបង្គួរ)");
        } else if (score >= 50) {
            System.out.println("Grade: D (មធ្យម)");
        } else {
            System.out.println("Grade: F (ធ្លាក់)");
        }
    }
}
```

```text
Output:
Grade: B (ល្អណាស់)
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ៗ (Key Takeaways)

> [!TIP]
> 1. **`if`:** ពិនិត្យលក្ខខណ្ឌដំបូង (ដំណើរការតែពេលពិតប៉ុណ្ណោះ)។
> 2. **`else if`:** ពិនិត្យលក្ខខណ្ឌបន្ទាប់ទៀតនៅពេលដែលលក្ខខណ្ឌមុនៗមិនពិត។
> 3. **`else`:** ជម្រើសចុងក្រោយ (Fallback) នៅពេលដែលគ្មានលក្ខខណ្ឌណាមួយត្រឹមត្រូវ។
> 4. **Ternary Operator (`? :`):** ប្រើសម្រាប់ជំនួស `if...else` ងាយៗ ដើម្បីសរសេរកូដឱ្យខ្លី និងងាយអាន។
> 5. **សញ្ញាស្មើ (`==`):** ប្រើសញ្ញាពីរជាន់ `==` ដើម្បីប្រៀបធៀបតម្លៃ មិនមែនសញ្ញា `=` (ដែលជាការផ្តល់តម្លៃ) ឡើយ។

---

← [មេរៀនមុន (Java Strings)](../14-java-strings/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (Java Switch)](../16-java-switch/README.md) →
