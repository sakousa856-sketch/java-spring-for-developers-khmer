# មេរៀនទី ១៧៖ Java Abstraction (ការលាក់បាំងភាពស្មុគស្មាញ និង Abstract Class)

> **ស្វែងយល់ស៊ីជម្រៅអំពីសសរទ្រូងទី ៤ នៃ OOP គឺ Abstraction៖ និយមន័យ Abstract Class, Abstract Methods វិធានតឹងរ៉ឹងនៃការអនុវត្ត និងការប្រៀបធៀបជាមួយ Concrete Class ក្នុង Java**

[![Lesson](https://img.shields.io/badge/Lesson-17-orange?style=for-the-badge&logo=java&logoColor=white)](#)
[![Topic](https://img.shields.io/badge/Topic-Abstraction-blue?style=for-the-badge)](#)
[![Language](https://img.shields.io/badge/Language-Khmer-red?style=for-the-badge)](#)

---

## 🎭 ១. អ្វីជា Abstraction? (What is Abstraction?)

នៅក្នុង OOP, **Abstraction** គឺជាដំណើរការនៃការបង្ហាញជូននូវអ្វីដែលចាំបាច់បំផុត (Essential Details) ទៅកាន់អ្នកប្រើប្រាស់ និង **លាក់បាំងនូវភាពស្មុគស្មាញនៃ Implementation ខាងក្នុង**។

### 💡 ឧទាហរណ៍ក្នុងជីវិតពិត៖
នៅពេលអ្នកបញ្ឆេះម៉ាស៊ីនឡាន អ្នកគ្រាន់តែចុចប៊ូតុង Start ឬមួលកូនសោប៉ុណ្ណោះ។ អ្នកមិនចាំបាច់ដឹងថាប្រព័ន្ធភ្លើង Spark plug ដំណើរការរបៀបណា ឬប្រព័ន្ធបាញ់ប្រេង Fuel Injector ធ្វើការបែបណានោះទេ។ អ្វីដែលអ្នកដឹងគឺ *"ឡានបញ្ឆេះដំណើរការ"* នេះហើយគឺជា Abstraction!

នៅក្នុង Java, Abstraction អាចសម្រេចបានតាម ២ របៀប៖
1. 🏛️ **Abstract Classes:** ផ្តល់នូវ Partial Abstraction (ពី 0% ដល់ 100%)។
2. 🔌 **Interfaces:** ផ្តល់នូវ Full Abstraction (100% Abstraction)។

---

## 📜 ២. Abstract Class និង Abstract Methods

### ក. Abstract Class:
គឺជា Class មួយដែលត្រូវបានប្រកាសដោយពាក្យគន្លឹះ **`abstract`**។ លក្ខណៈពិសេសគឺ **មិនអាចយកទៅបង្កើត Object ផ្ទាល់ (Instantiate) តាមរយៈ `new` បានឡើយ** (វាបង្កើតឡើងដើម្បីឱ្យ Class ផ្សេងធ្វើការ `extends` ប៉ុណ្ណោះ)។

### ខ. Abstract Method:
គឺជា Method ដែលប្រកាសដោយពាក្យគន្លឹះ **`abstract`** ដោយ **គ្មាន Code Body `{}` ឡើយ** (បញ្ចប់ដោយសញ្ញា `;`)។ Method នេះមានតែ Signature ប៉ុណ្ណោះ ហើយការអនុវត្តជាក់ស្តែង (Body) ត្រូវតែប្រគល់ឱ្យ Subclass ជាអ្នក Override សរសេរបំពេញ។

```java
// Abstract Class
abstract class Animal {
    // Abstract Method (គ្មាន Body ទេ)
    public abstract void animalSound();

    // Regular Method (មាន Body ធម្មតា)
    public void sleep() {
        System.out.println("សត្វកំពុងដេកលក់: ហ្ស៊ឺ... ហ្ស៊ឺ... 💤");
    }
}
```

---

## 💻 ៣. កូដគំរូអនុវត្តជាក់ស្តែង (Practical Code Example)

ដើម្បីប្រើប្រាស់ Abstract Class យើងត្រូវបង្កើត Subclass មួយមក `extends` និង Override រាល់ Abstract Methods ទាំងអស់៖

```java
// ១. Abstract Class
abstract class Animal {
    public abstract void animalSound(); // Abstract Method

    public void sleep() {               // Regular Method
        System.out.println("សត្វកំពុងដេកលក់: ហ្ស៊ឺ... ហ្ស៊ឺ... 💤");
    }
}

// ២. Subclass ត្រូវតែ Override animalSound()
class Pig extends Animal {
    @Override
    public void animalSound() {
        System.out.println("ជ្រូកស្រែក: អ៊ូក! អ៊ូក! 🐷");
    }
}

public class Main {
    public static void main(String[] args) {
        // បន្ទាត់ខាងក្រោមនឹង Error ព្រោះមិនអាច instantiate Abstract Class បានទេ:
        // Animal myAnimal = new Animal(); // ❌ Error: Animal is abstract; cannot be instantiated

        // ត្រូវតែបង្កើត Object ចេញពី Subclass:
        Pig myPig = new Pig();
        myPig.animalSound(); // ដំណើរការកូដដែលបាន Override ក្នុង Pig
        myPig.sleep();       // ដំណើរការកូដធម្មតាពី Class Animal
    }
}
```

**Output:**
```text
ជ្រូកស្រែក: អ៊ូក! អ៊ូក! 🐷
សត្វកំពុងដេកលក់: ហ្ស៊ឺ... ហ្ស៊ឺ... 💤
```

---

## ⚖️ ៤. វិធានសំខាន់ៗនៃ Abstract Class (Strict Rules)

> [!IMPORTANT]
> 1. Abstract Class មិនអាចប្រើ `new` ដើម្បីបង្កើត Object បានឡើយ។
> 2. Abstract Method អាចកើតឡើងបាន **តែនៅក្នុង Abstract Class ប៉ុណ្ណោះ**។
> 3. ប្រសិនបើ Subclass ស្នងពី Abstract Class នោះ Subclass ត្រូវតែ **Override រាល់ Abstract Methods ទាំងអស់** (លើកលែងតែ Subclass នោះប្រកាសខ្លួនឯងជា `abstract` ដែរ)។
> 4. Abstract Class អាចមាន Constructors, Fields, Static Methods, និង Regular Methods បានដូច Class ធម្មតា។

---

## 💡 សេចក្តីសង្ខេបសំខាន់ (Key Takeaways)

> [!TIP]
> 1. **Abstraction** ផ្តោតលើ *"តើប្រព័ន្ធត្រូវធ្វើអ្វី (What to do)"* ជាជាង *"តើប្រព័ន្ធធ្វើវាដោយរបៀបណា (How to do it)"*។
> 2. ប្រើពាក្យគន្លឹះ **`abstract`** លើ Class និង Method។
> 3. ជួយការពារសុវត្ថិភាព និងកំណត់ស្តង់ដាររួម (Template/Contract) ឱ្យ Subclasses ទាំងអស់ត្រូវតែគោរពតាម។

---

← [មេរៀនមុន (១៦៖ Java Inner Classes)](../16-inner-classes/README.md) ｜ [មាតិការួម](../README.md) ｜ [មេរៀនបន្ទាប់ (១៨៖ Java Interfaces)](../18-interfaces/README.md) →
