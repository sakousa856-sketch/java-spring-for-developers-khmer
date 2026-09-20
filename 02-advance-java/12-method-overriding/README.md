# មេរៀនទី ១២៖ Java Method Overriding (ការសរសេរបំប្លែងដំណើរការ Method)

> **ស្វែងយល់អំពី Method Overriding ក្នុង Java៖ និយមន័យ វិធានតឹងរ៉ឹងនៃការ Override ការប្រើប្រាស់ Annotation @Override និងការប្រៀបធៀបជាមួយ Method Overloading**

[![Lesson](https://img.shields.io/badge/Lesson-12-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Method%20Overriding-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🔄 ១. អ្វីជា Method Overriding? (What is Method Overriding?)

នៅក្នុង OOP, **Method Overriding** កើតឡើងនៅពេលដែល Subclass (Class កូន) បានផ្តល់នូវ **Implementation ជាក់លាក់ថ្មី** ទៅឱ្យ Method មួយដែលត្រូវបានប្រកាសរួចជាស្រេចនៅក្នុង Superclass (Class មេ)។

Overriding គឺជាបេះដូងនៃការបង្កើត **Runtime Polymorphism (Dynamic Method Dispatch)** ដែលអនុញ្ញាតឱ្យ Java សម្រេចចិត្តថាតើត្រូវដំណើរការកូដរបស់ Class ណានៅពេល Run កម្មវិធី។

---

## 📜 ២. វិធាននៃការធ្វើ Method Overriding (Rules of Overriding)

> [!IMPORTANT]
> ដើម្បី Override method បានត្រឹមត្រូវ អ្នកត្រូវតែគោរពតាមវិធានទាំងនេះជាដាច់ខាត៖
> 1. 🔤 **ឈ្មោះ Method:** ត្រូវតែដូចគ្នាទៅនឹង Method ក្នុង Class មេបេះបិទ។
> 2. 🔢 **Parameters:** ចំនួន និងប្រភេទនៃ Parameters ត្រូវតែដូចគ្នាបេះបិទ។
> 3. ↩️ **Return Type:** ត្រូវតែដូចគ្នា ឬជា Covariant Type (Subtype នៃ Return type ដើម)។
> 4. 🔐 **Access Modifier:** មិនអាចរឹតបន្តឹងសិទ្ធិឱ្យតូចជាង Class មេឡើយ (ឧទាហរណ៍៖ បើ Method មេជា `protected` នោះកូនអាចជា `protected` ឬ `public` តែមិនអាចជា `private` បានទេ)។
> 5. ⛔ **មិនអាច Override:** Method ដែលជា `private`, `static`, ឬ `final` មិនអាចធ្វើការ Override បានឡើយ។

---

## 🏷️ ៣. សារៈសំខាន់នៃ Annotation `@Override`

ការដាក់ **`@Override`** នៅពីលើ Method ក្នុង Subclass មិនមែនជាការបង្ខំឱ្យត្រូវតែមាននោះទេ ប៉ុន្តែវាជា **Best Practice ដ៏ចាំបាច់បំផុត** ព្រោះ៖
* 🛡️ **Compiler Check:** Java Compiler នឹងជួយពិនិត្យមើលថាតើ Method នោះពិតជាបាន Override ត្រឹមត្រូវពី Class មេឬអត់ (ការពារបញ្ហាភាន់ច្រឡំ វាយខុសអក្សរ Typo)។
* 📖 **Readability:** ជួយឱ្យ Developer ដទៃដឹងភ្លាមថា Method នេះជាការជំនួសដំណើរការរបស់ Class មេ។

---

## 💻 ៤. កូដគំរូអនុវត្តជាក់ស្តែង (Practical Code Example)

```java
// Superclass
class Animal {
    public void makeSound() {
        System.out.println("សត្វបញ្ចេញសំឡេងធម្មតា... 🐾");
    }
}

// Subclass ទី ១: Dog
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("ឆ្កែព្រុស: វូស! វូស! 🐶");
    }
}

// Subclass ទី ២: Cat
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("ឆ្មាស្រែក: ម៉េវ! ម៉េវ! 🐱");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Upcasting
        Animal myCat = new Cat(); // Upcasting

        myAnimal.makeSound();
        myDog.makeSound(); // ដំណើរការ makeSound() របស់ Dog
        myCat.makeSound(); // ដំណើរការ makeSound() របស់ Cat
    }
}
```

**Output:**
```text
សត្វបញ្ចេញសំឡេងធម្មតា... 🐾
ឆ្កែព្រុស: វូស! វូស! 🐶
ឆ្មាស្រែក: ម៉េវ! ម៉េវ! 🐱
```

---

## ⚖️ ៥. ការប្រៀបធៀប៖ Method Overloading vs Overriding

| លក្ខណៈវិនិច្ឆ័យ | Method Overloading (Compile-time) | Method Overriding (Runtime) |
| :--- | :--- | :--- |
| **ទីតាំងកើតឡើង** | ក្នុង **Class តែមួយ** | រវាង **Superclass និង Subclass** (Inheritance) |
| **ឈ្មោះ Method** | ដូចគ្នា | ដូចគ្នា |
| **Parameters** | **ត្រូវតែខុសគ្នា** (ចំនួន ឬ ប្រភេទ) | **ត្រូវតែដូចគ្នាបេះបិទ** |
| **Return Type** | អាចដូចគ្នា ឬខុសគ្នាបាន | ត្រូវតែដូចគ្នា (ឬ Covariant) |
| **Polymorphism** | Compile-time / Static Polymorphism | Runtime / Dynamic Polymorphism |

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Method Overriding** អនុញ្ញាតឱ្យ Subclass កែប្រែដំណើរការ Method របស់ Superclass តាមតម្រូវការជាក់ស្តែង។
> 2. ត្រូវតែមានឈ្មោះ, Parameters, និង Return Type ដូចគ្នានឹង Class មេ។
> 3. តែងតែប្រើប្រាស់ Annotation **`@Override`** ដើម្បីឱ្យ Compiler ជួយផ្ទៀងផ្ទាត់កូដ។
> 4. Method ដែលជា `final`, `static`, ឬ `private` មិនអាច Override បានឡើយ។

---

← [មេរៀនមុន (១១៖ super Keyword ក្នុង Java)](../11-super-keyword/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៣៖ static Keyword ក្នុង Java)](../13-static-keyword/README.md) →
