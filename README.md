# JavaConsoleUI
**JavaConsoleUI** is a simple Java Console UI library for creating styled console output and input.

## Intention
I created this library to provide an intuitive and straightforward way to build a console UI. Existing libraries were either too outdated or unnecessarily complex for my requirements, so I built JavaConsoleUI to be lightweight and easy to use.

---

## Features
- **Styled Console Output**:
    ```
    ╔═══════════════════════════════════╗
    ║Hi there! This is a console window.║
    ╚═══════════════════════════════════╝
    ```
- **Text Input**: Prompt users to enter input.
- **Choice Input**: Allow users to select a single option.
- **Checkbox Input**: Enable multiple options to be selected interactively.
- **Progress Bar**: Display a progress bar in the console.

---

## Usage

### 1. **Styled Console Output**
Use the `Window` class to create styled console output.
```java
// Autosize the window to fit the content
Window window = new Window(true);
window.addContent("Hi there! This is a console window.");
window.render();

// Manually set the window size
Window window2 = new Window(40, 10);
window2.addContent("This window has a fixed size.");
window2.render();

// Custom border characters
Window window3 = new Window(40, 10);
window3.customizeBorder("|", "=", "=", "(", ")", "(", ")");
window3.addContent("This window has custom borders.");
window3.render();
```

---

### 2. **Text Input**
Prompt the user for text input.
```java
// Input without a prompt
String input = Input.getInput();

// Input with a prompt
String inputWithPrompt = Input.getInput("Enter something: ");
```

---

### 3. **Choice Input**
Let users select one option from a list of choices.
```java
List<Choice> choices = List.of(
        new Choice("First choice", "first", "1"),
        new Choice("Second choice", "second", "2"),
        new Choice("Third choice", "third", "3")
);

// Without prompt or displaying choices
Choice choice = ChoiceInput.choiceInput(choices);

// With a prompt
Choice choiceWithPrompt = ChoiceInput.choiceInput(choices, "Select a choice: ");

// With choices displayed
Choice choiceWithDisplay = ChoiceInput.choiceInput(choices, true);

// With both prompt and displayed choices
Choice choiceWithPromptAndDisplay = ChoiceInput.choiceInput(choices, "Select a choice: ", true);
```

---

### 4. **Checkbox Input**
Allow users to select multiple options interactively. They can toggle options by entering the corresponding number and finish by typing `done`.
```java
List<CheckBoxOption> options = List.of(
        new CheckBoxOption("Option 1", true, "1"), // Pre-selected
        new CheckBoxOption("Option 2", false, "2"),
        new CheckBoxOption("Option 3", false, "3")
);

List<CheckBoxOption> selectedOptions = CheckBox.input(options, "Select options:");
```

---
### 5. **Progress Bar**
Display a progress bar in the console.
```java
// Example usage:
ProgressBar progressBar = new ProgressBar(100, 50, '█', '░', false);
for (int i = 0; i <= 100; i++) {
    try {
        Thread.sleep(50);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    progressBar.updateProgress(i);
}
```

---
## Contribution
Feel free to fork the repository, create a pull request, or suggest features and improvements! Contributions are welcome.

---

## License
JavaConsoleUI is released under the **MIT License**. Use it freely in your projects!