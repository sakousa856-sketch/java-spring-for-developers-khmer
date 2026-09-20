# មេរៀនទី ១៨៖ Java Interfaces (កិច្ចសន្យា និង Multiple Inheritance ក្នុង Java)

> **ស្វែងយល់ស៊ីជម្រៅអំពី Java Interfaces៖ និយមន័យ 100% Full Abstraction ពាក្យគន្លឹះ implements ការអនុវត្ត Multiple Interfaces និងតារាងប្រៀបធៀប Abstract Class vs Interface**

[![Lesson](https://img.shields.io/badge/Lesson-18-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Java%20Interfaces-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🔌 ១. អ្វីជា Interface ក្នុង Java? (What is an Interface?)

នៅក្នុង Java, **Interface** គឺជាប្រភេទ Reference Type មួយស្រដៀងទៅនឹង Class ដែរ ប៉ុន្តែវាជា **កិច្ចសន្យាសុទ្ធសាធ (Pure Contract / 100% Full Abstraction)** ដែលផ្ទុកតែ Constants និង Method Signatures (គ្មាន Code Body)។

Interface កំណត់ថាតើ Class ត្រូវតែធ្វើអ្វីខ្លះ (`what to do`) ដោយមិនខ្វល់ថាតើ Class នោះធ្វើវាដោយរបៀបណាឡើយ (`how to do it`)។

### 🛠️ វាក្យសម្ព័ន្ធ៖
* ប្រើពាក្យគន្លឹះ **`interface`** ដើម្បីប្រកាស Interface។
* ប្រើពាក្យគន្លឹះ **`implements`** នៅក្នុង Class ដើម្បីយក Interface មកសរសេរ Code Implementation ជាក់ស្តែង។

---

## 📜 ២. វិធានតឹងរ៉ឹងរបស់ Interface (Interface Rules)

> [!IMPORTANT]
> 1. 🚫 **មិនអាចបង្កើត Object:** Interface មិនអាចប្រើ `new` ដើម្បី Instantiate បានឡើយ។
> 2. ⚙️ **Methods សុទ្ធតែជា Abstract:** រាល់ Methods ក្នុង Interface គឺស្វ័យប្រវត្តិជា **`public` និង `abstract`** (ទោះបីអ្នកមិនសរសេរពាក្យទាំងពីរក៏ដោយ)។
> 3. 🔒 **Variables សុទ្ធតែជា Constants:** រាល់ Variables ក្នុង Interface គឺស្វ័យប្រវត្តិជា **`public`, `static`, និង `final`**។
> 4. 🚫 **គ្មាន Constructor:** Interface មិនមាន Constructor ឡើយ។
> 5. 👥 **Multiple Interfaces:** Class មួយអាច **implements Interfaces ច្រើនក្នុងពេលតែមួយបាន** (ដំណោះស្រាយ Multiple Inheritance របស់ Java)។

---

## 💻 ៣. ឧទាហរណ៍ទី ១៖ Basic Interface Implementation

```java
// ១. ប្រកាស Interface
interface Animal {
    void animalSound(); // public abstract void animalSound();
    void sleep();       // public abstract void sleep();
}

// ២. Class Pig implements Interface Animal
class Pig implements Animal {
    @Override
    public void animalSound() {
        System.out.println("ជ្រូកស្រែក: អ៊ូក! អ៊ូក! 🐷");
    }

    @Override
    public void sleep() {
        System.out.println("ជ្រូកកំពុងដេក: ហ្ស៊ឺ... ហ្ស៊ឺ... 💤");
    }
}

public class Main {
    public static void main(String[] args) {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();
    }
}
```

**Output:**
```text
ជ្រូកស្រែក: អ៊ូក! អ៊ូក! 🐷
ជ្រូកកំពុងដេក: ហ្ស៊ឺ... ហ្ស៊ឺ... 💤
```

---

## 🧩 ៤. ឧទាហរណ៍ទី ២៖ Multiple Interfaces (ដោះស្រាយ Multiple Inheritance)

Java មិនអនុញ្ញាតឱ្យ Class មួយ `extends` ពី Class ច្រើនទេ ប៉ុន្តែអនុញ្ញាតឱ្យ `implements` Interfaces ច្រើនដោយប្រើសញ្ញាក្បៀស (`,`)៖

```java
interface FirstInterface {
    void myMethod();
}

interface SecondInterface {
    void myOtherMethod();
}

// Class DemoClass implements Interfaces ទាំងពីរ
class DemoClass implements FirstInterface, SecondInterface {
    @Override
    public void myMethod() {
        System.out.println("ដំណើរការ Method ទី ១ ពី FirstInterface 🌟");
    }

    @Override
    public void myOtherMethod() {
        System.out.println("ដំណើរការ Method ទី ២ ពី SecondInterface 🚀");
    }
}

public class Main {
    public static void main(String[] args) {
        DemoClass myObj = new DemoClass();
        myObj.myMethod();
        myObj.myOtherMethod();
    }
}
```

**Output:**
```text
ដំណើរការ Method ទី ១ ពី FirstInterface 🌟
ដំណើរការ Method ទី ២ ពី SecondInterface 🚀
```

---

## ⚖️ ៥. តារាងប្រៀបធៀប៖ Abstract Class vs Interface

នេះជាសំណួរសម្ភាសន៍ការងារដ៏ពេញនិយមបំផុតសម្រាប់ Java Developers៖

| លក្ខណៈវិនិច្ឆ័យ | Abstract Class | Interface |
| :--- | :--- | :--- |
| **កម្រិត Abstraction** | មិនពេញលេញ (Partial Abstraction: 0% ដល់ 100%) | **ពេញលេញ (Full Abstraction: 100%)** *(មុន Java 8)* |
| **ប្រភេទ Methods** | អាចមានទាំង Abstract និង Regular/Concrete methods | មានតែ Abstract methods *(Java 8+ មាន default/static)* |
| **ប្រភេទ Variables** | អាចមានគ្រប់ប្រភេទ (instance, static, final, non-final) | **មានតែ `public static final` (Constants) ប៉ុណ្ណោះ** |
| **ពាក្យគន្លឹះ** | ប្រើ `abstract class` និង `extends` | ប្រើ `interface` និង `implements` |
| **Multiple Inheritance** | **មិនគាំទ្រ** (extends បានតែមួយ Class) | **គាំទ្រយ៉ាងពេញលេញ** (implements បានច្រើន Interfaces) |
| **Constructor** | **មាន Constructor** សម្រាប់ Initialize | **គ្មាន Constructor ឡើយ** |
| **ល្បឿន Performance** | លឿនជាងបន្តិច | យឺតជាងបន្តិច (ដោយសារមាន Dynamic Indirection) |

---

## 🌟 ៦. ហេតុអ្វី Interface ជាឆ្អឹងខ្នងនៃ Spring Framework?

នៅក្នុងវិស្វកម្មសូហ្វវែរសហគ្រាស ការប្រើប្រាស់ Interface ជួយបង្កើត **Loose Coupling (កូដមិនចងភ្ជាប់គ្នាតឹងតែងពេក)**។ នៅក្នុង Spring Framework អ្នកនឹងឃើញទម្រង់នេះជានិច្ច ដូចជា `UserRepository (Interface)` និង `UserServiceImpl (Implementation Class)` ដែលធ្វើឱ្យប្រព័ន្ធងាយស្រួល Swap បច្ចេកវិទ្យា Database, Mock ទិន្នន័យពេលធ្វើ Unit Test និងគ្រប់គ្រង Dependency Injection។

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Interface** ជាកិច្ចសន្យាកូដ (Contract) ដែលផ្តល់នូវ Full Abstraction 100%។
> 2. Class ប្រើពាក្យគន្លឹះ **`implements`** ដើម្បីយក Interface ទៅបំពេញ Code Body។
> 3. អនុញ្ញាតឱ្យសម្រេចបាន **Multiple Inheritance** ក្នុង Java ដោយគ្មានបញ្ហា Diamond Problem។
> 4. ជាមូលដ្ឋានគ្រឹះដ៏រឹងមាំសម្រាប់ Interface-Driven Development និង Dependency Injection ក្នុង Spring Boot!

---

← [មេរៀនមុន (១៧៖ Java Abstraction)](../17-abstraction/README.md) ｜ [មាតិការួម](../README.md) ｜ [បញ្ចប់វគ្គ Advance Java (ឆ្ពោះទៅ Spring Framework) →](../../03-spring-framework/README.md)
