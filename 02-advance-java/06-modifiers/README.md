# មេរៀនទី ៦៖ Java Modifiers (ម៉ូឌីហ្វាយអឺ)

### 🖥️ ស្លាយទី 25 ｜ Slide 25

> ## 📌 Modifier នៅក្នុង Class
> 
> ---
>
> ### ➤ Modifier នៅក្នុង Class
> Modifier គឺប្រើសម្រាប់កំណត់កម្រិតដែលអាច access ចូលសម្រាប់ classes, attributes, methods និង constructors។ នៅក្នុងភាសា Java, modifiers ត្រូវបានបែងចែកជាពីរក្រុមធំៗ:
> 1. **Access Modifiers:** គ្រប់គ្រងកម្រិតនៃការ access ចូលប្រើប្រាស់។
> 2. **Non-Access Modifiers:** មិនគ្រប់គ្រងកម្រិតនៃការ access ចូលនោះទេ តែផ្តល់នូវមុខងារ និងលក្ខណៈពិសេសផ្សេងៗ (ដូចជា `static`, `final`, `abstract`, `synchronized`...)។

---

### 🖥️ ស្លាយទី 26 ｜ Slide 26

> ## 📌 តារាង Access Modifiers ក្នុង Java
> 
> ---
>
> ### Access Modifiers
>
> #### សម្រាប់ Classes:
> | Modifier | Description |
> | :--- | :--- |
> | **`public`** | Class អាចត្រូវបាន access ដោយ class ដទៃទៀតទាំងអស់ |
> | **`default`** | Class អាច access បានតែដោយ classes ដែលស្ថិតនៅក្នុង package ជាមួយគ្នាតែប៉ុណ្ណោះ (នៅពេលមិនបានសរសេរ modifier) |
>
> #### សម្រាប់ Attributes, Methods និង Constructors:
> | Modifier | Description |
> | :--- | :--- |
> | **`public`** | កូដអាចត្រូវបាន access ដោយគ្រប់ classes ទាំងអស់ |
> | **`private`** | កូដអាចត្រូវបាន access តែនៅក្នុង Class ដែលបានប្រកាសវាប៉ុណ្ណោះ |
> | **`default`** | កូដអាចត្រូវបាន access តែនៅក្នុង package ជាមួយគ្នាប៉ុណ្ណោះ (នៅពេលមិនបានសរសេរ modifier) |
> | **`protected`** | កូដអាចត្រូវបាន access នៅក្នុង package ជាមួយគ្នា និងនៅក្នុង subclasses (Inheritance) |

---

← [មេរៀនមុន](../05-constructors/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../07-encapsulation/README.md) →
