# មេរៀនទី ១៧៖ Java Loops (រង្វិលជុំក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពីរង្វិលជុំក្នុង Java៖ ការប្រើប្រាស់ While Loop, Do-While Loop, For Loop, For-Each Loop និងពាក្យគន្លឹះ Break & Continue**

[![Lesson](https://img.shields.io/badge/Lesson-17-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Loops-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🔄 ១. សេចក្តីផ្តើមអំពីរង្វិលជុំ (Introduction to Loops)

នៅក្នុងការសរសេរកម្មវិធី **Loop (រង្វិលជុំ)** ត្រូវបានប្រើសម្រាប់ដំណើរការប្លុកកូដដដែលៗជាច្រើនដង ដរាបណាស្ថានភាព ឬលក្ខខណ្ឌដែលបានកំណត់នៅតែ **ពិត (`true`)**។

> [!NOTE]
> **អត្ថប្រយោជន៍នៃ Loops:**
> * ចំណេញពេលវេលា និងកាត់បន្ថយការសរសេរកូដស្ទួន (គោលការណ៍ DRY: Don't Repeat Yourself)។
> * ជួយឱ្យកូដមានភាពបត់បែនខ្ពស់ក្នុងការគ្រប់គ្រងទិន្នន័យជាសំណុំ (ដូចជា Arrays ឬ Collections)។

### 📋 ប្រភេទ Loops ចម្បងៗទាំង ៤ ក្នុង Java៖
1. **`while` loop:** ពិនិត្យលក្ខខណ្ឌជាមុនសិន ប្រសិនបើពិតទើបដំណើរការកូដ។
2. **`do-while` loop:** ដំណើរការកូដយ៉ាងហោចណាស់ ១ ដងជានិច្ច ទើបពិនិត្យលក្ខខណ្ឌតាមក្រោយ។
3. **`for` loop:** ប្រើនៅពេលយើងដឹងចំនួនជុំច្បាស់លាស់ជាមុន (ឧទាហរណ៍៖ រត់ ៥ ដង ឬ ១០ ដង)។
4. **`for-each` loop:** ប្រើជាពិសេសសម្រាប់ទាញយកធាតុនីមួយៗពី Arrays ឬ Collections។

---

## 🔁 ២. While Loop (ពិនិត្យលក្ខខណ្ឌជាមុន)

`while` loop នឹងដំណើរការប្លុកកូដដដែលៗ ដរាបណា `condition` នៅតែពិត (`true`)៖

### 💻 ទម្រង់ Syntax៖

```java
while (condition) {
    // ប្លុកកូដដែលត្រូវដំណើរការ
    // update statement (e.g. i++)
}
```

```java
public class WhileLoopDemo {
    public static void main(String[] args) {
        int i = 0;

        while (i < 5) {
            System.out.println("ជុំទី: " + i);
            i++; // បង្កើនតម្លៃ i ដើម្បីកុំឱ្យជាប់ Infinite Loop
        }
    }
}
```

```text
Output:
ជុំទី: 0
ជុំទី: 1
ជុំទី: 2
ជុំទី: 3
ជុំទី: 4
```

> [!WARNING]
> **ប្រយ័ត្ន Infinite Loop:** ប្រសិនបើអ្នកភ្លេចបង្កើនតម្លៃអថេរ (ដូចជា `i++`) នោះលក្ខខណ្ឌនឹងនៅតែ `true` រហូត ធ្វើឱ្យកម្មវិធីដំណើរការមិនចេះចប់ (គាំង Memory)។

---

## 🔂 ៣. Do-While Loop (ដំណើរការមុន ពិនិត្យក្រោយ)

ភាពខុសគ្នារវាង `while` និង `do-while` គឺថា `do-while` **នឹងដំណើរការប្លុកកូដយ៉ាងហោចណាស់ ១ ដងជានិច្ច** សូម្បីតែលក្ខខណ្ឌមិនពិតតាំងពីដំបូងក៏ដោយ (ពីព្រោះវាពិនិត្យលក្ខខណ្ឌនៅចុងបញ្ចប់)។

### 💻 ទម្រង់ Syntax៖

```java
do {
    // ប្លុកកូដដែលត្រូវដំណើរការ (យ៉ាងតិច ១ ដង)
} while (condition);
```

```java
public class DoWhileDemo {
    public static void main(String[] args) {
        int i = 0;

        do {
            System.out.println("តម្លៃ i = " + i);
            i++;
        } while (i < 5);
    }
}
```

```text
Output:
តម្លៃ i = 0
តម្លៃ i = 1
តម្លៃ i = 2
តម្លៃ i = 3
តម្លៃ i = 4
```

---

## 🔢 ៤. For Loop (រង្វិលជុំដឹងចំនួនច្បាស់លាស់)

នៅពេលយើងដឹងចំនួនដងជាក់លាក់ដែលត្រូវធ្វើការ loop ការប្រើប្រាស់ `for` loop គឺជាជម្រើសដ៏ល្អ និងពេញនិយមបំផុត។

### 💻 ទម្រង់ Syntax៖

```java
for (statement 1; statement 2; statement 3) {
    // ប្លុកកូដដែលត្រូវដំណើរការ
}
```

> [!NOTE]
> **ការពន្យល់ធាតុទាំង ៣ នៃ For Loop:**
> * **Statement 1 (Initialization):** កំណត់អថេរចាប់ផ្ដើម (ដំណើរការតែ **១ ដងគត់** នៅមុនពេលចាប់ផ្តើម loop)។
> * **Statement 2 (Condition):** លក្ខខណ្ឌត្រួតពិនិត្យមុនពេលដំណើរការរាល់ជុំ (បើ `true` ទើបដំណើរការ)។
> * **Statement 3 (Increment/Decrement):** បង្កើន ឬបន្ថយតម្លៃអថេររាល់ពេលដែលកូដក្នុង loop បានដំណើរការចប់មួយជុំ។

```java
public class ForLoopDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("For Loop Index: " + i);
        }
    }
}
```

```text
Output:
For Loop Index: 0
For Loop Index: 1
For Loop Index: 2
For Loop Index: 3
For Loop Index: 4
```

---

## 📦 ៥. For-Each Loop (Enhanced For Loop)

`for-each` loop ត្រូវបានបង្កើតឡើងជាពិសេសសម្រាប់ទាញយកទិន្នន័យចេញពី **Array** ឬ **Collection** យ៉ាងងាយស្រួល ដោយមិនចាំបាច់ប្រើលេខរៀង index ឡើយ។

### 💻 ទម្រង់ Syntax៖

```java
for (type variableName : arrayName) {
    // ប្លុកកូដដែលត្រូវដំណើរការ
}
```

```java
public class ForEachDemo {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (String car : cars) {
            System.out.println("ម៉ាកឡាន: " + car);
        }
    }
}
```

```text
Output:
ម៉ាកឡាន: Volvo
ម៉ាកឡាន: BMW
ម៉ាកឡាន: Ford
ម៉ាកឡាន: Mazda
```

---

## 🛑 ៦. ការគ្រប់គ្រង Loop ដោយ `break` និង `continue`

* **`break`:** ប្រើសម្រាប់បញ្ឈប់ ឬចាកចេញពី loop ទាំងស្រុងភ្លាមៗ។
* **`continue`:** ប្រើសម្រាប់រំលងជុំបច្ចុប្បន្ន (Skip current iteration) ហើយលោតទៅធ្វើជុំបន្ទាប់ភ្លាមៗ។

```java
public class BreakContinueDemo {
    public static void main(String[] args) {
        // ១. ឧទាហរណ៍ break (ឈប់ត្រឹម i == 3)
        System.out.println("--- ឧទាហរណ៍ break ---");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.print(i + " "); // 0 1 2
        }

        // ២. ឧទាហរណ៍ continue (រំលងលេខ 2)
        System.out.println("\n--- ឧទាហរណ៍ continue ---");
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue; // រំលងជុំទី ២
            }
            System.out.print(i + " "); // 0 1 3 4
        }
    }
}
```

```text
Output:
--- ឧទាហរណ៍ break ---
0 1 2 
--- ឧទាហរណ៍ continue ---
0 1 3 4 
```

---

## 📊 ៧. តារាងប្រៀបធៀបប្រភេទ Loops ក្នុង Java

| ប្រភេទ Loop | ពេលណាគួរប្រើប្រាស់? | ចំនួនជុំអប្បបរមា |
| :--- | :--- | :---: |
| **`while`** | មិនដឹងចំនួនជុំច្បាស់លាស់ អាស្រ័យលើលក្ខខណ្ឌ | 0 ដង |
| **`do-while`** | ចង់ឱ្យកូដដំណើរការយ៉ាងតិច ១ ដងជាមុនសិន | 1 ដង |
| **`for`** | ដឹងចំនួនដងនៃការរត់ច្បាស់លាស់ជាមុន | 0 ដង |
| **`for-each`** | សម្រាប់អានធាតុទាំងអស់ក្នុង Array ឬ Collection | 0 ដង (បើ Array ទទេ) |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ៗ (Key Takeaways)

> [!TIP]
> 1. **ជ្រើសរើស Loop ឱ្យត្រូវនឹងតម្រូវការ:** ដឹងចំនួនជុំប្រើ `for`, អាន Array ប្រើ `for-each`, ពិនិត្យលក្ខខណ្ឌប្រើ `while`។
> 2. **ការពារ Infinite Loop:** ត្រូវប្រាកដថាអថេរលក្ខខណ្ឌមានការកើនឡើង ឬថយចុះជានិច្ច (`i++` ឬ `i--`)។
> 3. **`break` vs `continue`:** `break` ចាកចេញពី loop ទាំងស្រុង ចំណែក `continue` រំលងតែជុំបច្ចុប្បន្នប៉ុណ្ណោះ។

---

← [មេរៀនមុន (Java Switch)](../16-java-switch/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (Java Arrays)](../18-java-arrays/README.md) →
