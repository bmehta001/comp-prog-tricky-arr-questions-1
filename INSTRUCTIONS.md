# Instructions

## Goal

For each problem, implement the **`solve()`** function so that all tests pass.
You only need to complete the problems in **one** programming language of your choice
(Java, Python, or C++).

## Problems

| # | File (Java / Python / C++) | Description |
|---|---------------------------|-------------|
| 1 | `Question1_CowSightings` | Find the most frequent cow sighting ID |
| 2 | `Question2_TwoSumBounded` | Check if any pair of elements sums to a target |
| 3 | `Question3_LargestKWithNegative` | Find the largest positive k where -k also exists |

Each problem's file contains:
- A detailed problem description in the header comment
- A `solve()` stub marked with `TODO` -- **this is the only function you need to implement**
- Pre-written tests that verify your solution

---

## Java

### Prerequisites

You need a **JDK** (Java Development Kit), not just a JRE. The JDK includes the
`javac` compiler. **JDK 8 or higher** is required.

| Distribution | Link | Notes |
|-------------|------|-------|
| Oracle JDK  | [oracle.com/java/technologies/downloads](https://www.oracle.com/java/technologies/downloads/) | Official. Free for development; production use may require a license for older versions. |
| Eclipse Temurin (Adoptium) | [adoptium.net](https://adoptium.net/) | Free and open-source. TCK-certified, backed by Eclipse Foundation, Microsoft, and IBM. Identical core functionality to Oracle JDK. |

Either is fine -- both include the full JDK (compiler + runtime). Adoptium is
popular in education and open-source because it has no licensing restrictions.

Verify your install:
```bash
javac -version     # should print "javac 1.8..." or higher
java -version      # should print the SAME major version as javac
```

> **Troubleshooting**: If `javac -version` and `java -version` show different
> versions (e.g. javac 21 but java 1.8), you have multiple Java installs and
> the wrong one is first in your PATH. Fix this by:
> - **Windows**: Open **System Properties -> Environment Variables**. In the
>   **System variables** section, edit `Path` and move your JDK's `bin` folder
>   (e.g. `C:\Program Files\...\jdk-21\bin`) above any older Java entries
>   (e.g. `Oracle\Java\java8path`). You may also want to add a `JAVA_HOME`
>   variable pointing to the JDK root folder.
> - **macOS/Linux**: Add `export JAVA_HOME=/path/to/jdk` and
>   `export PATH="$JAVA_HOME/bin:$PATH"` to your `~/.bashrc` or `~/.zshrc`.
>
> The error `UnsupportedClassVersionError: ... class file version 65.0 ...
> only recognizes class file versions up to 52.0` means you compiled with a
> newer JDK than the runtime. Ensure `javac` and `java` come from the same JDK.

### How to Run (Terminal)

```bash
cd java
javac *.java
java Question1_CowSightings
```

### IDE Setup: VSCode

1. Install the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
2. Open the repository folder in VSCode.
3. Open any `QuestionN_*.java` file.
4. Use the integrated terminal to compile and run:
   ```bash
   cd java && javac *.java && java Question1_CowSightings
   ```

> **Note**: The Run (play) button in VSCode runs a single file. Since each question
> depends on `TestHarness.java`, use the terminal command above or compile all files
> first with `javac *.java`.

### IDE Setup: IntelliJ IDEA

1. **File -> Open** and select the repository folder.
2. If prompted, choose **"Trust Project"**.
3. Mark the `java/` folder as a **Sources Root**: right-click `java/` -> **Mark Directory as -> Sources Root**.
4. Open any `QuestionN_*.java` file and click the green play button next to `public static void main`.

> IntelliJ auto-compiles all Java files in the sources root, so `TestHarness.java`
> will be included automatically.

> **Note**: Visual Studio does not have Java support. Use IntelliJ IDEA or VSCode
> for Java development.

### IDE Setup: Eclipse

1. Download [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/).
2. **File -> Open Projects from File System** and select the repository folder.
3. Eclipse may not recognize `java/` as a source folder automatically. If you see
   errors, right-click the project -> **Properties -> Java Build Path -> Source**
   tab -> **Add Folder** and select `java/`.
4. Open any `QuestionN_*.java` file and click the green **Run** button, or
   right-click -> **Run As -> Java Application**.

### IDE Setup: NetBeans

1. Download [Apache NetBeans](https://netbeans.apache.org/download/).
2. **File -> New Project -> Java Application with Existing Sources**.
3. In the wizard, add the `java/` folder as a **Source Package Folder**.
4. Right-click any `QuestionN_*.java` file -> **Run File** (Shift+F6).

### IDE Setup: BlueJ

[BlueJ](https://www.bluej.org/) is a beginner-friendly Java IDE popular in
introductory courses.

1. Download and install BlueJ.
2. **Project -> Open Non-BlueJ...** and select the `java/` folder.
3. BlueJ will display the classes visually. Right-click `QuestionN_*` ->
   **void main(String[] args)** to run.

> BlueJ compiles all classes in the project automatically, so `TestHarness`
> will be included.

---

## Python

### Prerequisites

**Python 3.9 or higher** is required.

Download from [python.org](https://www.python.org/downloads/) or use your
system's package manager. No additional packages are needed.

Verify your install:
```bash
python --version   # should print "Python 3.9..." or higher
```

### How to Run (Terminal)

```bash
cd python
python question1_cow_sightings.py
```

### IDE Setup: VSCode

1. Install the [Python extension](https://marketplace.visualstudio.com/items?itemName=ms-python.python).
2. Open the repository folder in VSCode.
3. Open any `questionN_*.py` file and click the **Run** (play) button, or use the terminal.

### IDE Setup: PyCharm

1. **File -> Open** and select the repository folder.
2. Open any `python/questionN_*.py` file and click the play button to run.

### IDE Setup: Visual Studio

Visual Studio 2019+ supports Python via the **Python development** workload.

1. Open the **Visual Studio Installer** and ensure the **Python development**
   workload is installed.
2. **File -> Open -> Folder** and select the repository folder.
3. In **Solution Explorer**, navigate to `python/`, right-click a `questionN_*.py`
   file and choose **Set as Startup File**.
4. Press **F5** (Debug) or **Ctrl+F5** (Run without debugging).

### IDE Setup: Eclipse (PyDev)

Eclipse supports Python via the [PyDev](https://www.pydev.org/) plugin.

1. In Eclipse, go to **Help -> Eclipse Marketplace** and search for **PyDev**.
   Install it and restart Eclipse.
2. **File -> New -> Project -> PyDev -> PyDev Project**. Point the project
   location to the repository folder.
3. Open any `python/questionN_*.py` file and right-click -> **Run As -> Python Run**.

---

## C++

### Prerequisites

A **C++17-compatible compiler** is required:

| Compiler | Minimum Version | Platform |
|----------|----------------|----------|
| GCC (g++) | 7+ | Linux, macOS, Windows (MinGW) |
| Clang    | 5+ | Linux, macOS |
| MSVC (cl.exe) | 2017+ (v19.14+) | Windows (Visual Studio) |

Verify your install:
```bash
g++ --version        # Linux/macOS/MinGW
cl                   # Windows (from Developer Command Prompt)
```

### How to Run (Terminal)

**GCC / Clang:**
```bash
cd cpp
g++ -std=c++17 -O2 question1_cow_sightings.cpp -o q1 && ./q1
```

**MSVC (Developer Command Prompt):**
```bash
cd cpp
cl /std:c++17 /EHsc /O2 question1_cow_sightings.cpp /Fe:q1.exe && q1.exe
```

**CMake (any platform):**
```bash
cd cpp
cmake -B build
cmake --build build --config Release
./build/q1_cow_sightings          # Linux/macOS
build\Release\q1_cow_sightings    # Windows
```

### IDE Setup: VSCode

1. Install the [C/C++ extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools)
   and optionally [CMake Tools](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cmake-tools).
2. Open the repository folder in VSCode.
3. **With CMake Tools**: open the Command Palette (`Ctrl+Shift+P`) -> **CMake: Configure**,
   then **CMake: Build**. Run any target from the status bar.
4. **Without CMake**: use the integrated terminal with the commands above.

### IDE Setup: Visual Studio

1. **File -> Open -> CMake...** and select `cpp/CMakeLists.txt`.
   Visual Studio 2017+ has built-in CMake support.
2. Select a build target (e.g. `q1_cow_sightings.exe`) from the
   **Select Startup Item** dropdown in the toolbar.
3. Press **F5** (Debug) or **Ctrl+F5** (Run without debugging).

> Alternatively, create a new empty C++ project, add the `.cpp` and `.h` files
> from `cpp/`, set the C++ standard to C++17 in project properties
> (**Configuration Properties -> C/C++ -> Language -> C++ Language Standard**),
> and build normally.

### IDE Setup: CLion

1. **File -> Open** and select the `cpp/` folder (or the repo root).
2. CLion auto-detects `CMakeLists.txt` and configures the project.
3. Select a run target (e.g. `q1_cow_sightings`) from the dropdown and click the play button.

### IDE Setup: Eclipse (CDT)

Eclipse supports C++ via the [CDT](https://www.eclipse.org/cdt/) (C/C++
Development Tooling) plugin, which is included in the
**Eclipse IDE for C/C++ Developers** download.

1. Download [Eclipse IDE for C/C++ Developers](https://www.eclipse.org/downloads/packages/)
   (or install the CDT plugin into an existing Eclipse).
2. **File -> New -> Project -> C/C++ -> Makefile Project with Existing Code**.
   Browse to the `cpp/` folder and select your toolchain (e.g. MinGW GCC or
   Linux GCC).
3. To build a single file: right-click the `.cpp` file -> **Properties ->
   C/C++ Build -> Settings** and add `-std=c++17` to the compiler flags.
4. Right-click the `.cpp` file -> **Run As -> Local C/C++ Application**.

> For CMake integration, install the **cmake4eclipse** plugin from the
> Eclipse Marketplace.

### IDE Setup: NetBeans (C++)

Apache NetBeans supports C++ with the C/C++ plugin (requires a separate
install on newer versions).

1. Go to **Tools -> Plugins -> Available Plugins** and install the
   **C/C++** plugin if it is not already present.
2. **File -> New Project -> C/C++ -> C/C++ Project with Existing Sources**.
   Point to the `cpp/` folder.
3. In project properties, ensure the C++ standard is set to **C++17**.
4. Right-click any `.cpp` file -> **Run File**.

---

## Using GitHub Codespaces (No Local Setup)

If you don't want to install anything on your machine, you can work entirely
in the browser using GitHub Codespaces.

### Launching a Codespace

1. Go to the repository on GitHub
2. Click the green **Code** button
3. Select the **Codespaces** tab
4. Click **Create codespace on master**

A VS Code editor opens in your browser with **everything pre-installed**:
Java (JDK), Python 3, g++, CMake, and the recommended VS Code extensions.

### Running Your Code

Open the integrated terminal (`` Ctrl+` ``) and use the same commands as
local development:

```bash
# Java
cd java && javac *.java && java Question1_CowSightings

# Python
cd python && python3 question1_cow_sightings.py

# C++
cd cpp && g++ -std=c++17 -O2 question1_cow_sightings.cpp -o q1 && ./q1
```

### Tips

- Codespaces auto-saves your work and preserves state between sessions
- You can commit and push directly from the Codespaces terminal or the
  Source Control panel
- Free GitHub accounts include a monthly allowance of Codespaces hours

---

## What "Done" Looks Like

When your solution is correct, the output will show:

```
Summary: 1,007 / 1,007 tests passed
```

This includes hand-written correctness tests **and** 1,000 randomly generated
stress tests verified against a reference solution.

The **Scaling** section shows how your solution's runtime and memory compare
to the reference (brute-force) solution at increasing input sizes. Use it to
confirm your approach has the right time complexity and lower memory usage.

## Quick Mode (Faster Feedback)

The full test suite includes benchmarks and scaling analysis that take extra time.
While developing, you can switch to **quick mode** which runs only the correctness
tests and random stress tests -- skipping benchmarks and scaling.

Change `.run()` to `.runQuick()` (Java/C++) or `.run_quick()` (Python) in your
question file:

```java
// Java
.runQuick();   // instead of .run()
```

```python
# Python
.run_quick()   # instead of .run()
```

```cpp
// C++
.runQuick();   // instead of .run()
```

Quick mode prints a header so you know it is active:

```
(quick mode -- skipping benchmarks & scaling)
```

Switch back to `.run()` before submitting to see the full performance analysis.

## Adding Your Own Tests

You can add extra test cases in your question file's `main()`. Chain
`.addTest(...)` calls before `.run()`:

```java
// Java
boolean passed = Question1_Tests.buildHarness(Question1_CowSightings::solve)
    .addTest("My edge case", () -> solve(new int[]{1}), new int[]{1, 1})
    .run();
```

```python
# Python
passed = build_harness(solve) \
    .add_test("My edge case", lambda: solve([1]), (1, 1)) \
    .run()
```

```cpp
// C++
auto h = q1_tests::newHarness();
bool passed = q1_tests::addTests(h, solve)
    .addTest("My edge case", [](){ return solve({1}); }, {1, 1})
    .run();
```

Test names are optional -- omit the name string for auto-naming ("Test N").

### Running Only Your Own Tests

If you want to skip the built-in tests and run only your own (useful when
debugging), create a fresh harness instead of using the infrastructure file:

```java
// Java -- custom tests only
boolean passed = TestHarness.<int[]>forProblem("My Tests")
    .addTest("My test", () -> solve(new int[]{1,2,1}), new int[]{1, 2})
    .run();
```

```python
# Python -- custom tests only
passed = TestHarness("My Tests") \
    .add_test("My test", lambda: solve([1,2,1]), (1, 2)) \
    .run()
```

```cpp
// C++ -- custom tests only
bool passed = harness::TestHarness<std::pair<int,int>>::forProblem("My Tests")
    .addTest("My test", [](){ return solve({1,2,1}); }, {1, 2})
    .run();
```

You can also look at the test infrastructure files (`*_Tests.java`,
`*_tests.py`, `*_tests.h`) to see exactly what test cases are included.

## Hints

Each problem can be solved optimally using a **plain array** instead of a
hash map or set. The key insight: when values fall in a small, bounded range,
a direct-index array is faster and uses less overhead. See the README for
the full "Array vs Dictionary" rule of thumb.

## Viewing Markdown Files

This repository includes `.md` files (like this one and `README.md`) with
formatted text, tables, and code blocks. To read them comfortably:

**On GitHub** (easiest): Navigate to the file on github.com -- GitHub
automatically renders markdown with full formatting.

**In VSCode**: Open any `.md` file and press `Ctrl+Shift+V` (Windows/Linux)
or `Cmd+Shift+V` (macOS) to open a rendered preview. For a side-by-side
view (edit on left, preview on right), press `Ctrl+K V`.

**In IntelliJ / PyCharm / CLion**: Open any `.md` file. The editor shows a
split view by default (code + preview). Use the icons in the top-right corner
of the editor tab to toggle between code-only, split, and preview-only modes.

**In Visual Studio**: Install the **Markdown Editor** extension from the
Extensions menu. Once installed, opening a `.md` file shows a preview pane.

## Rules

- Implement only the `solve()` function in each question file
- Do not modify the test harness files (`TestHarness.java`, `test_harness.py`, `test_harness.h`)
- Do not modify the test infrastructure files (`*_Tests.java`, `*_tests.py`, `*_tests.h`)
- You may add your own test cases (see "Adding Your Own Tests" above)
