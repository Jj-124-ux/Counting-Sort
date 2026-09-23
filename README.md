How to Compile and Run
Files needed

Place all five files in the same folder (same package):

CountingSort.java
BubbleSort.java
SelectionSort.java
InsertionSort.java
SortTest.java ← this is the one you run

The first four each hold one sorting method. SortTest.java contains the main method and runs all four sorts on the same random data, printing runtime, comparisons/swaps, and space used for each.

Option A: Running in IntelliJ IDEA
Open the project folder in IntelliJ (or create a new Java project and copy all five .java files into the src folder).
Make sure all five files show up in the Project panel with no red error underlines.
Right-click SortTest.java in the Project panel.
Select Run 'SortTest.main()'.
The output appears in the Run panel at the bottom.

No setup beyond having the JDK installed (which IntelliJ normally bundles) is needed.

Option B: Running from the terminal / command line
Open a terminal and navigate to the folder containing all five .java files:
   cd path/to/your/folder
Compile all files at once:
   javac *.java

This produces a .class file for each .java file in the same folder. 3. Run the program:

   java SortTest
Output prints directly to the terminal.
What to expect when it runs

The program tests three sizes: 5, 1,000, and 1,000,000 items, using the same randomly generated data for every sort at a given size (via a fixed random seed, so results are repeatable).

Sizes 5 and 1,000 finish in well under a second.
Size 1,000,000 takes noticeably longer for Bubble, Selection, and Insertion sort (each is O(n²), so this size can take several minutes total), while Counting sort finishes in milliseconds. This is expected and not a bug, the program is not stuck, just working through the slower sorts. Do not close or restart it.

For each sort, you'll see a line like:

Bubble   : 4 ms  OK   comparisons = 498834   swaps = 248910   extra space ~ 4 bytes
ms — runtime
OK / WRONG — confirms the array was actually sorted correctly (a safety check, not a performance metric)
comparisons / swaps / movements / array accesses — operation counts specific to each algorithm
extra space — estimated memory used beyond the input array itself
Troubleshooting
"error: cannot find symbol" when compiling: make sure all five .java files are in the same folder and none were renamed (the file name must match the class name exactly, e.g. BubbleSort.java must contain public class BubbleSort).
Program seems frozen at size 1,000,000: it isn't, Bubble sort alone can take upwards of 15-30 minutes at this size on a typical laptop. Let it run; Counting sort's line will already have appeared quickly, confirming the program is working.
javac: command not found: the JDK isn't installed or isn't on your system PATH. Install a JDK (Java 17 or newer) or run through IntelliJ instead, which bundles its own.
