# មេរៀនទី ១៦៖ Java Switch (ការសម្រេចចិត្តតាមជម្រើសក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពី Java Switch Statement៖ ទម្រង់ Syntax ពាក្យគន្លឹះ break & default និងការប្រៀបធៀបរវាង Switch និង If..Else**

[![Lesson](https://img.shields.io/badge/Lesson-16-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Switch-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🎛️ ១. សេចក្តីផ្តើមអំពី Switch Statement (Introduction to Switch)

នៅក្នុងភាសា Java, **Switch Statement** ត្រូវបានប្រើសម្រាប់ជ្រើសរើសប្លុកកូដណាមួយក្នុងចំណោមប្លុកកូដជាច្រើនមកដំណើរការ ដោយផ្អែកលើតម្លៃជាក់លាក់នៃអថេរ ឬកន្សោម (Expression) មួយ។

> [!NOTE]
> **ហេតុអ្វីបានជាយើងប្រើប្រាស់ Switch?**
> នៅពេលដែលយើងមានលក្ខខណ្ឌប្រៀបធៀបតម្លៃច្រើនជម្រើស ការប្រើប្រាស់ `if...else if...else if` អាចធ្វើឱ្យកូដស្មុគស្មាញ និងពិបាកអាន។ ដូច្នេះ **Switch Statement** គឺជាជម្រើសដ៏ល្អបំផុតដើម្បីធ្វើឱ្យកូដមានរបៀបរៀបរយ ស្អាត (Clean Code) និងងាយស្រួលយល់។

---

## ⚙️ ២. ទម្រង់ Syntax និងដំណើរការ (Syntax & How It Works)

### 💻 ទម្រង់ Syntax ស្តង់ដារ៖

```java
switch (expression) {
    case x:
        // ប្លុកកូដដំណើរការនៅពេល expression == x
        break;
    case y:
        // ប្លុកកូដដំណើរការនៅពេល expression == y
        break;
    default:
        // ប្លុកកូដដំណើរការនៅពេលគ្មាន case ណាត្រូវគ្នា
}
```

### 🔍 របៀបដែល Switch ដំណើរការ៖
1. តម្លៃនៃកន្សោម **`expression`** ត្រូវបានគណនាតែមួយដងគត់។
2. តម្លៃនោះត្រូវបានយកទៅប្រៀបធៀបជាមួយតម្លៃនៅតាម **`case`** នីមួយៗ (`case x`, `case y`...)។
3. ប្រសិនបើមាន `case` ណាមួយត្រូវគ្នា ប្លុកកូដនៅក្រោម `case` នោះនឹងចាប់ផ្តើមដំណើរការ។
4. ពាក្យគន្លឹះ **`break`**: ជួយបញ្ចប់ការដំណើរការរបស់ `switch block` ភ្លាមៗ (មិនឱ្យធ្លាក់ទៅដំណើរការ case បន្ទាប់)។
5. ពាក្យគន្លឹះ **`default`**: ជាជម្រើសជំនួសចុងក្រោយ (ស្រដៀងនឹង `else`) ប្រសិនបើគ្មាន `case` ណាត្រូវគ្នាសោះ។

---

## 💻 ៣. ឧទាហរណ៍អនុវត្តជាក់ស្តែង (Practical Examples)

### ៣.១ ឧទាហរណ៍កំណត់ឈ្មោះថ្ងៃក្នុងសប្តាហ៍ (Day of the Week)

```java
public class SwitchDayDemo {
    public static void main(String[] args) {
        int day = 4;

        switch (day) {
            case 1:
                System.out.println("Monday (ថ្ងៃចន្ទ)");
                break;
            case 2:
                System.out.println("Tuesday (ថ្ងៃអង្គារ)");
                break;
            case 3:
                System.out.println("Wednesday (ថ្ងៃពុធ)");
                break;
            case 4:
                System.out.println("Thursday (ថ្ងៃព្រហស្បតិ៍)");
                break;
            case 5:
                System.out.println("Friday (ថ្ងៃសុក្រ)");
                break;
            case 6:
                System.out.println("Saturday (ថ្ងៃសៅរ៍)");
                break;
            case 7:
                System.out.println("Sunday (ថ្ងៃអាទិត្យ)");
                break;
            default:
                System.out.println("Invalid day (លេខថ្ងៃមិនត្រឹមត្រូវ)");
        }
    }
}
```

```text
Output:
Thursday (ថ្ងៃព្រហស្បតិ៍)
```

---

### ៣.២ ឧទាហរណ៍ប្រើប្រាស់ Default Case

នៅពេលដែលតម្លៃមិនត្រូវគ្នានឹង `case` ណាមួយ Java នឹងរត់ចូលទៅកាន់ `default` ដោយស្វ័យប្រវត្តិ៖

```java
public class SwitchDefaultDemo {
    public static void main(String[] args) {
        int day = 4;

        switch (day) {
            case 6:
                System.out.println("Saturday (ថ្ងៃសៅរ៍ - សម្រាក)");
                break;
            case 7:
                System.out.println("Sunday (ថ្ងៃអាទិត្យ - សម្រាក)");
                break;
            default:
                System.out.println("Looking forward to the Weekend (ថ្ងៃធ្វើការ)");
        }
    }
}
```

```text
Output:
Looking forward to the Weekend (ថ្ងៃធ្វើការ)
```

---

## 🛑 ៤. សារៈសំខាន់នៃពាក្យគន្លឹះ `break` (The break Keyword)

> [!WARNING]
> **ចៀសវាងកំហុស Fall-Through៖**
> នៅពេល Java រកឃើញ `case` ដែលត្រូវគ្នា ហើយបើគ្មានពាក្យ **`break`** ទេនោះ វានឹង**បន្តដំណើរការប្លុកកូដនៃ case បន្ទាប់ៗទាំងអស់**ដោយស្វ័យប្រវត្តិ ទោះបីជា case ទាំងនោះមិនត្រូវគ្នាក៏ដោយ!
> * ដូច្នេះ សូមកុំភ្លេចដាក់ `break;` នៅចុងបញ្ចប់នៃគ្រប់ `case`។
> * ចំណែកឯនៅចុងបញ្ចប់នៃ `default` គឺមិនចាំបាច់ដាក់ `break` ក៏បាន ពីព្រោះវាស្ថិតនៅចុងក្រោយបង្អស់នៃ switch block ស្រាប់។

---

## 📊 ៥. ការប្រៀបធៀបរវាង Switch និង If..Else

| លក្ខណៈវិនិច្ឆ័យ | `switch` Statement | `if...else` Statement |
| :--- | :--- | :--- |
| **ប្រភេទនៃការប្រៀបធៀប** | ប្រៀបធៀបតម្លៃស្មើគ្នាជាក់លាក់ (`==`) | អាចប្រៀបធៀបបានគ្រប់លក្ខខណ្ឌ (`>`, `<`, `==`, `!=`, `&&`, `\|\|`) |

| **Data Types ដែលគាំទ្រ** | `byte`, `short`, `char`, `int`, `String`, `enum` | គាំទ្រគ្រប់ Data Types ទាំងអស់ |
| **ភាពងាយស្រួលក្នុងការអាន** | ស្អាត រៀបរយល្អ ពេលមានជម្រើសតម្លៃច្រើន | ស្មុគស្មាញ និងវែងអន្លាយ ពេលមានលក្ខខណ្ឌច្រើន |
| **ភាពសមស្រប** | សមស្របសម្រាប់ Menu, Choices, Commands ថេរ | សមស្របសម្រាប់ចន្លោះតម្លៃ (Range e.g., `score >= 80`) |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ៗ (Key Takeaways)

> [!TIP]
> 1. **ជំនួស `if..else` ច្រើនជាន់:** ប្រើ `switch` នៅពេលអ្នកចង់ផ្ទៀងផ្ទាត់អថេរមួយធៀបនឹងតម្លៃថេរច្រើនជម្រើស។
> 2. **កុំភ្លេច `break`:** ប្រើ `break` ដើម្បីចេញពី switch block ភ្លាមៗក្រោយពេលសម្រេចកូដក្នុង case។
> 3. **ប្រើ `default`:** ទុកសម្រាប់ចាប់យកករណីដែលគ្មាន case ណាមួយផ្ទៀងផ្ទាត់ត្រូវ។
> 4. **Data Types:** ចាប់ពី Java 7 ឡើងទៅ `switch` អាចប្រើជាមួយ `String` បានយ៉ាងរលូន។

---

← [មេរៀនមុន (Java If..Else)](../15-java-if-else/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (Java Loops)](../17-java-loops/README.md) →
