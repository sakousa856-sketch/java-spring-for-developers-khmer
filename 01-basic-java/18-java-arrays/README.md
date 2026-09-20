# មេរៀនទី ១៨៖ Java Arrays (អារេក្នុង Java)

> **មគ្គុទ្ទេសក៍សិក្សាអំពី Java Arrays៖ ការប្រកាស Array ការទាញយក និងកែប្រែតម្លៃ ទំហំ Array (length) ការ Loop លើ Array និងអារេពហុវិមាត្រ (Multidimensional Arrays)**

[![Lesson](https://img.shields.io/badge/Lesson-18-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Arrays-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 📦 ១. អ្វីជា Java Arrays? (What is an Array?)

នៅក្នុងភាសា Java, **Array** គឺជាសំណុំទិន្នន័យ (Data Structure) ដែលប្រើសម្រាប់**រក្សាទុកនូវតម្លៃជាច្រើនដែលមានប្រភេទ (Data Type) ដូចគ្នា** នៅក្នុងអថេរតែមួយ ជំនួសឱ្យការបង្កើតអថេរដាច់ដោយឡែកពីគ្នាជាច្រើន។

> [!NOTE]
> ជំនួសឱ្យការប្រកាស៖
> ```java
> String car1 = "Volvo";
> String car2 = "BMW";
> String car3 = "Ford";
> ```
> យើងអាចប្រើ Array តែមួយគត់៖
> ```java
> String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
> ```

### 💻 ទម្រង់ Syntax ស្តង់ដារ៖

```java
// របៀបទី ១៖ ប្រកាស និងផ្ដល់តម្លៃភ្លាមៗ
dataType[] arrayName = {value1, value2, value3};

// របៀបទី ២៖ កំណត់ទំហំជាមុនដោយប្រើ keyword 'new'
dataType[] arrayName = new dataType[size];
```

---

## 🔍 ២. ការទាញយក និងកែប្រែតម្លៃ (Access & Modify Elements)

ធាតុនីមួយៗក្នុង Array ត្រូវបានសម្គាល់ដោយ **លេខរៀង Index** ដែលចាប់ផ្ដើមរាប់ពី **`0`** ជានិច្ច (Zero-based Indexing)៖
* ធាតុទី ១ = Index `0`
* ធាតុទី ២ = Index `1`
* ធាតុទី ៣ = Index `2` ...

### 💻 ឧទាហរណ៍ការអាន និងកែប្រែតម្លៃ៖

```java
public class ArrayAccessDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        // ១. ទាញយកតម្លៃតាម Index
        System.out.println("លេខនៅ Index 3: " + numbers[3]); // 40
        System.out.println("ឡាននៅ Index 0: " + cars[0]);      // Volvo

        // ២. កែប្រែតម្លៃក្នុង Array
        numbers[3] = 100;
        cars[0] = "Camry";

        // បង្ហាញតម្លៃក្រោយកែប្រែ
        System.out.println("លេខថ្មីនៅ Index 3: " + numbers[3]); // 100
        System.out.println("ឡានថ្មីនៅ Index 0: " + cars[0]);      // Camry
    }
}
```

```text
Output:
លេខនៅ Index 3: 40
ឡាននៅ Index 0: Volvo
លេខថ្មីនៅ Index 3: 100
ឡានថ្មីនៅ Index 0: Camry
```

---

## 📏 ៣. ប្រវែងនៃ Array (Array Length)

យើងអាចដឹងពីចំនួនធាតុសរុបដែលមាននៅក្នុង Array ដោយប្រើប្រាស់ Property **`.length`**៖

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println("ចំនួនធាតុក្នុង Array cars: " + cars.length); // 4
```

> [!TIP]
> ចំណាំ៖ សម្រាប់ Array យើងប្រើ **`.length`** (គ្មានវង់ក្រចក `()`) រីឯសម្រាប់ String យើងប្រើ **`.length()`** (មានវង់ក្រចក)។

---

## 🔁 ៤. ការ Loop លើ Array (Loop Through an Array)

ដើម្បីទាញយកគ្រប់ធាតុទាំងអស់ចេញពី Array មកបង្ហាញ យើងមានជម្រើស ២ ពេញនិយម៖

### របៀបទី ១៖ ប្រើប្រាស់ `for` Loop ធម្មតា
```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (int i = 0; i < cars.length; i++) {
    System.out.println("Index " + i + ": " + cars[i]);
}
```

### របៀបទី ២៖ ប្រើប្រាស់ `for-each` Loop (ណែនាំឱ្យប្រើ - ស្អាត និងខ្លី)
```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (String car : cars) {
    System.out.println("ម៉ាកឡាន: " + car);
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

## 🗂️ ៥. អារេពហុវិមាត្រ ២ វិមាត្រ (Multidimensional Arrays - 2D)

**2D Array (Multidimensional Array)** គឺជា Array នៃ Arrays ដែលមានរចនាសម្ព័ន្ធដូចជា តារាង (Matrix) ដែលមាន **ជួរដេក (Rows)** និង **ជួរឈរ (Columns)**។

### 💻 ទម្រង់ Syntax និងការបង្កើត៖

```java
// 2D Array តាងជួរដេក និងជួរឈរ
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
```

### 🔍 ការទាញយកតម្លៃ និង Loop លើ 2D Array៖

```java
public class TwoDimensionalArrayDemo {
    public static void main(String[] args) {
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

        // ១. ទាញយកតម្លៃជាក់លាក់ (Row 1, Column 2 -> តម្លៃ 7)
        System.out.println("តម្លៃនៅ Row 1, Col 2: " + myNumbers[1][2]);

        // ២. ប្រើ Nested Loop ដើម្បីបង្ហាញគ្រប់ធាតុទាំងអស់
        System.out.println("\n--- បង្ហាញគ្រប់ធាតុនៃ 2D Array ---");
        for (int i = 0; i < myNumbers.length; i++) {
            for (int j = 0; j < myNumbers[i].length; j++) {
                System.out.print(myNumbers[i][j] + " ");
            }
            System.out.println(); // ចុះបន្ទាត់សម្រាប់ជួរដេកបន្ទាប់
        }
    }
}
```

```text
Output:
តម្លៃនៅ Row 1, Col 2: 7

--- បង្ហាញគ្រប់ធាតុនៃ 2D Array ---
1 2 3 4 
5 6 7 
```

---

## 💡 សេចក្តីសង្ខេបសំខាន់ៗ (Key Takeaways)

> [!TIP]
> 1. **Index ចាប់ផ្ដើមពី 0:** ធាតុទីមួយគឺ index `0`, ធាតុចុងក្រោយគឺ index `length - 1`។
> 2. **ទំហំ Array ថេរ (Fixed Size):** នៅពេលដែលបង្កើតរួច ទំហំរបស់ Array មិនអាចពង្រីក ឬបង្រួមបានឡើយ។
> 3. **Array Length:** ប្រើ `array.length` ដើម្បីដឹងពីចំនួនសរុបនៃធាតុ។
> 4. **For-Each Loop:** ជាវិធីល្អ និងលឿនបំផុតក្នុងការ iterate លើធាតុទាំងអស់ក្នុង Array។
> 5. **2D Arrays:** តំណាងឱ្យទម្រង់ Grid/Matrix ដោយប្រើ index ពីរជាន់ `array[row][col]`។

---

← [មេរៀនមុន (Java Loops)](../17-java-loops/README.md) ｜ [មាតិការួម](../README.md) ｜ [🎉 បញ្ចប់វគ្គសិក្សា Java Basic](../README.md)
