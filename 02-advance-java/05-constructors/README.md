# មេរៀនទី ៥៖ Java Constructors (វិធីសាស្ត្របង្កើត និងផ្តល់តម្លៃដំបូងដល់ Object)

> **ស្វែងយល់ស៊ីជម្រៅអំពី Java Constructors៖ និយមន័យ វិធាននៃការបង្កើត Default vs Parameterized Constructors និង Constructor Overloading ក្នុង Java**

[![Lesson](https://img.shields.io/badge/Lesson-05-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Constructors-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🏗️ ១. អ្វីជា Constructor? (What is a Constructor?)

នៅក្នុង Java, **Constructor** គឺជា Special Method មួយដែលត្រូវបានហៅដំណើរការដោយស្វ័យប្រវត្តិនៅពេលដែល Object មួយត្រូវបានបង្កើតឡើង (តាមរយៈពាក្យគន្លឹះ `new`)។ គោលបំណងចម្បងនៃ Constructor គឺដើម្បី **ផ្តល់តម្លៃដំបូង (Initialize State)** ទៅឱ្យ Attributes របស់ Object នោះ។

### ⚠️ វិធានតឹងរ៉ឹងនៃការបង្កើត Constructor (Constructor Rules):
1. 🔤 **ឈ្មោះ:** ត្រូវតែមានឈ្មោះដូចគ្នាបេះបិទទៅនឹង **ឈ្មោះ Class** (រួមទាំងអក្សរតូចធំ)។
2. 🚫 **គ្មាន Return Type:** មិនមាន Return Type ឡើយ (សូម្បីតែពាក្យ `void` ក៏មិនត្រូវមានដែរ)។
3. ⚡ **ការដំណើរការ:** ដំណើរការភ្លាមៗដោយស្វ័យប្រវត្តិតែមួយដងគត់ នៅពេលបង្កើត Object។

---

## 💻 ២. ការបង្កើត Constructor ដំបូង (Basic Constructor Example)

```java
public class Main {
    int x; // Class attribute

    // បង្កើត Constructor សម្រាប់ Class Main
    public Main() {
        x = 5; // កំណត់តម្លៃដំបូងឱ្យ x ស្មើ 5
    }

    public static void main(String[] args) {
        // នៅពេលហៅ new Main() នោះ Constructor នឹងដំណើរការភ្លាម
        Main myObj = new Main();
        System.out.println("តម្លៃ x គឺ: " + myObj.x);
    }
}
```

**Output:**
```text
តម្លៃ x គឺ: 5
```

> [!NOTE]
> ប្រសិនបើអ្នកមិនបានសរសេរ Constructor ដោយខ្លួនឯងទេនោះ Java Compiler នឹងបង្កើត **Default Constructor (No-argument Constructor)** ដោយស្វ័យប្រវត្តិឱ្យអ្នក ដោយកំណត់តម្លៃលំនាំដើម (`0` សម្រាប់លេខ, `null` សម្រាប់ Object, `false` សម្រាប់ boolean)។

---

## 🎯 ៣. Constructor មាន Parameters (Parameterized Constructor)

យើងអាចបញ្ជូន Parameters ទៅកាន់ Constructor ដើម្បីផ្តល់តម្លៃជាក់លាក់ខុសៗគ្នាទៅឱ្យ Object នីមួយៗនៅពេលបង្កើត៖

```java
public class Car {
    int modelYear;
    String modelName;

    // Constructor ទទួល Parameters ចំនួន ២
    public Car(int year, String name) {
        modelYear = year;
        modelName = name;
    }

    public static void main(String[] args) {
        // បញ្ជូនទិន្នន័យជាក់ស្តែងពេលបង្កើត Object
        Car car1 = new Car(1969, "Mustang");
        Car car2 = new Car(2022, "Corolla");

        System.out.println("ឡានទី ១: " + car1.modelYear + " " + car1.modelName);
        System.out.println("ឡានទី ២: " + car2.modelYear + " " + car2.modelName);
    }
}
```

**Output:**
```text
ឡានទី ១: 1969 Mustang
ឡានទី ២: 2022 Corolla
```

---

## 🔄 ៤. ការបង្កើត Constructors ច្រើនទម្រង់ (Constructor Overloading)

ដូចគ្នានឹង Method ដែរ យើងអាចបង្កើត Constructor ច្រើនក្នុង Class តែមួយបាន ឱ្យតែចំនួន ឬប្រភេទ Parameters ខុសៗគ្នា (ហៅថា **Constructor Overloading**)៖

```java
public class Product {
    String name;
    double price;
    int stock;

    // Constructor ទី ១: គ្មាន Parameters
    public Product() {
        this.name = "Unknown";
        this.price = 0.0;
        this.stock = 0;
    }

    // Constructor ទី ២: មាន ២ Parameters
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.stock = 1;
    }

    // Constructor ទី ៣: មាន ៣ Parameters ពេញលេញ
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
```

---

## ⚖️ ៥. ការប្រៀបធៀប៖ Constructor vs Method

| លក្ខណៈវិនិច្ឆ័យ (Feature) | Constructor | Method |
| :--- | :--- | :--- |
| **គោលបំណង** | ប្រើសម្រាប់ផ្តល់តម្លៃដំបូងដល់ Object (Initialize) | ប្រើសម្រាប់បំពេញសកម្មភាព ឬ Logic (Action) |
| **Return Type** | **ដាច់ខាតគ្មាន Return Type** | ត្រូវតែមាន Return Type (ឬ `void`) |
| **ឈ្មោះ** | ត្រូវតែ**ដូចគ្នាទៅនឹងឈ្មោះ Class** | អាចដាក់ឈ្មោះអ្វីក៏បាន (ប្រើ camelCase) |
| **ពេលវេលាដំណើរការ** | ដំណើរការដោយស្វ័យប្រវត្តិតាមរយៈ `new` | ដំណើរការនៅពេលមានការហៅដោយផ្ទាល់ (Invoke) |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Constructor** ជា Method ពិសេសសម្រាប់ Initialize ទិន្នន័យដំបូងរបស់ Object។
> 2. ឈ្មោះ Constructor ត្រូវតែដូចឈ្មោះ Class បេះបិទ និងគ្មាន Return Type។
> 3. **Parameterized Constructor** ជួយឱ្យយើងអាចបង្កើត Object ដោយភ្ជាប់ទិន្នន័យជាក់លាក់ភ្លាមៗ។
> 4. **Constructor Overloading** អនុញ្ញាតឱ្យបង្កើត Object តាមច្រើនជម្រើសខុសៗគ្នា។

---

← [មេរៀនមុន (០៤៖ Java Class Methods)](../04-class-methods/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៦៖ Java Modifiers)](../06-modifiers/README.md) →
