# មេរៀនទី ៨៖ Java Packages (កញ្ចប់កូដ)

### 🖥️ ស្លាយទី 35 ｜ Slide 35

> ## 📌 សេចក្តីផ្តើមអំពី Java Package
> 
> ---
>
> ### Package នៅក្នុងភាសា Java
> Package នៅក្នុងភាសា Java គឺប្រើសម្រាប់ក្តោបនូវបណ្តុំនៃ classes។ បើគិតមើលទៅវាដូចទៅនឹង folder ហើយយើងប្រើ package គឺដើម្បីការពារការដាក់ឈ្មោះ file ជាន់គ្នា ហើយមួយទៀតគឺវាជួយឱ្យកូដរបស់យើងកាន់តែមានសណ្តាប់ធ្នាប់ល្អ។
>
> Packages ត្រូវបានបែងចែកជាពីរប្រភេទគឺ:
> 1. **Built-in Packages:** packages ដែលមានស្រាប់នៅក្នុង Java API។
> 2. **User-defined Packages:** packages ដែលយើងបង្កើតឡើងដោយខ្លួនឯង។

---

### 🖥️ ស្លាយទី 36 ｜ Slide 36

> ## 📌 Built-in Packages និង Syntax
> 
> ---
>
> ### ➤ Built-in Packages
> សម្រាប់ Built-in នេះត្រូវបានបែងចែកជា packages និង classes ហើយអាចហៅវាប្រើប្រាស់បានដោយប្រើ keyword **`import`**:
>
> **Syntax:**
> ```java
> import package.name.Class;   // Import តែ class មួយគត់
> import package.name.*;       // Import classes ទាំងអស់ក្នុង package
> ```

---

### 🖥️ ស្លាយទី 37 ｜ Slide 37

> ## 📌 ការ Import Class ជាក់លាក់
> 
> ---
>
> ### Import a Class
> ប្រសិនបើយើងចង់ប្រើប្រាស់ Class ជាក់លាក់ណាមួយ ដូចជា `Scanner` ដែលប្រើសម្រាប់ទទួល input ពី user:
> ```java
> import java.util.Scanner;
> ```

---

### 🖥️ ស្លាយទី 38 ｜ Slide 38

> ## 📌 ការ Import Package ទាំងមូល
> 
> ---
>
> ### Import a Package
> មាន packages ជាច្រើនដែលអាចជ្រើសរើសប្រើបាន។ នៅក្នុង `java.util` មានផ្ទុកនូវ date and time, random number generator និង collections ជាច្រើន។ ដើម្បី import package ទាំងមូល យើងប្រើសញ្ញាផ្កាយ (`*`):
> ```java
> import java.util.*;
> ```

---

### 🖥️ ស្លាយទី 39 ｜ Slide 39

> ## 📌 ការបង្កើត User-defined Packages
> 
> ---
>
> ### ➤ User-defined Packages
> - សម្រាប់ user-defined គឺយើងត្រូវបង្កើត package ដោយខ្លួនឯង ហើយយើងត្រូវយល់ពី file system នៃ Java Project ឱ្យបានច្បាស់ដើម្បីអាចបង្កើត package បាន។
> - ឈ្មោះរបស់ package គួរតែជាអក្សរតូចទាំងអស់ ហើយបើពាក្យត្រូវដកឃ្លា គឺគួរតែប្រើសញ្ញា underscore (`_`) ដើម្បីការពារកុំឱ្យច្រឡំជាមួយឈ្មោះ Classes។

---

← [មេរៀនមុន](../07-encapsulation/README.md) | [មាតិការួម](../README.md) | [មេរៀនបន្ទាប់](../09-inheritance/README.md) →
