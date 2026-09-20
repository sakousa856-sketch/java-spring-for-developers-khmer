# មេរៀនទី ៤៖ Java Class Methods (វិធីសាស្ត្រប្រតិបត្តិការក្នុង Class)

> **ស្វែងយល់អំពី Methods ក្នុង Class៖ របៀបប្រកាស ការប្រៀបធៀបរវាង static vs public methods ការបញ្ជូន Parameters និងការរៀបចំកូដតាមស្តង់ដារ OOP**

[![Lesson](https://img.shields.io/badge/Lesson-04-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Class%20Methods-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## ⚙️ ១. អ្វីជា Class Methods? (What are Class Methods?)

នៅក្នុង Java, **Methods** គឺជាបណ្តុំនៃកូដ (Block of code) ដែលសរសេរឡើងដើម្បីបំពេញមុខងារ ឬសកម្មភាពជាក់លាក់ណាមួយ (Behavior) ហើយដំណើរការនៅពេលណាដែលត្រូវបានគេហៅ (Call/Invoke) ប៉ុណ្ណោះ។ នៅក្នុង OOP, Method ដើរតួជាអ្នកកំណត់នូវសកម្មភាពដែល Object អាចធ្វើបាន។

```java
public class Main {
    // បង្កើត Method មួយឈ្មោះ myMethod
    static void myMethod() {
        System.out.println("Hello World! 👋");
    }

    public static void main(String[] args) {
        myMethod(); // ហៅ Method
    }
}
```

---

## ⚖️ ២. ការប្រៀបធៀប៖ `static` vs `public` Methods

ចំនុចខុសគ្នាដ៏សំខាន់បំផុតរវាង `static` method និង `public` (non-static) method គឺការទាមទារបង្កើត Object៖

| ប្រភេទ Method | ការបង្កើត Object | របៀបហៅប្រើប្រាស់ (Invocation) | ទីតាំងប្រើប្រាស់ទូទៅ |
| :--- | :---: | :--- | :--- |
| **`static`** | **មិនបាច់បង្កើត Object** | ហៅតាមរយៈឈ្មោះ Class ផ្ទាល់ (`ClassName.method()`) | Helper methods, Math functions, Utility classes |
| **`public` (Instance)** | **ត្រូវតែបង្កើត Object** | ហៅតាមរយៈ Object Reference (`objectName.method()`) | Business logic ដែលអាស្រ័យលើ State របស់ Object |

### 💻 កូដគំរូប្រៀបធៀបជាក់ស្តែង៖

```java
public class Main {
    // Static method
    static void myStaticMethod() {
        System.out.println("Static method អាចហៅបានដោយមិនបាច់បង្កើត Object!");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public method ត្រូវតែបង្កើត Object ជាមុនសិន!");
    }

    public static void main(String[] args) {
        // ១. ហៅ Static method ដោយផ្ទាល់
        myStaticMethod();

        // ២. ហៅ Public method តាមរយៈ Object
        Main myObj = new Main();
        myObj.myPublicMethod();
    }
}
```

**Output:**
```text
Static method អាចហៅបានដោយមិនបាច់បង្កើត Object!
Public method ត្រូវតែបង្កើត Object ជាមុនសិន!
```

---

## 🚀 ៣. គំរូអនុវត្តជាក់ស្តែង៖ Multiple Classes & Parameters

ខាងក្រោមនេះជាគំរូជាក់ស្តែងនៃការបំបែក Logic រវាង Class `Car` និង Class `Main` សម្រាប់ Run កម្មវិធី៖

### File ទី ១: `Car.java`
```java
public class Car {
    // Method គ្មាន Parameter
    public void fullThrottle() {
        System.out.println("ឡានកំពុងបើកបរក្នុងល្បឿនលឿនបំផុត! 🏎️💨");
    }

    // Method មាន Parameter
    public void speed(int maxSpeed) {
        System.out.println("ល្បឿនអតិបរមាគឺ: " + maxSpeed + " km/h");
    }
}
```

### File ទី ២: `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();     // បង្កើត Object
        myCar.fullThrottle();      // ហៅ Method
        myCar.speed(240);          // បញ្ជូន Parameter 240 ទៅ Method
    }
}
```

**Output:**
```text
ឡានកំពុងបើកបរក្នុងល្បឿនលឿនបំផុត! 🏎️💨
ល្បឿនអតិបរមាគឺ: 240 km/h
```

> [!TIP]
> ការបំបែក Logic ទៅក្នុង Method ជួយឱ្យកូដរបស់អ្នកមានភាពច្បាស់លាស់ ងាយស្រួលធ្វើ Unit Testing និងអាចប្រើប្រាស់ឡើងវិញបានច្រើនដង (High Reusability)។

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Methods** កំណត់នូវសកម្មភាព ឬអាកប្បកិរិយារបស់ Object ក្នុង Class។
> 2. **`static` Method** អាចហៅបានភ្លាមៗតាមរយៈឈ្មោះ Class ដោយមិនចាំបាច់បង្កើត Object ឡើយ។
> 3. **`public` (Non-static) Method** ទាមទារឱ្យបង្កើត Object ជាមុនសិន ទើបអាចហៅប្រើតាមរយៈ Dot Operator (`.`) បាន។
> 4. Methods អាចទទួលទិន្នន័យតាមរយៈ **Parameters** និងអាច Return តម្លៃត្រឡប់មកវិញបានតាមរយៈ `return` keyword។

---

← [មេរៀនមុន (០៣៖ Java Class Attributes)](../03-class-attributes/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (០៥៖ Java Constructors)](../05-constructors/README.md) →
