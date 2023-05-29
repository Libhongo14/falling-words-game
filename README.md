# Falling-words-game

Computer Science students doing the CSC2002S course in 2021 were required to design a 
multithreaded java program. The Assignment is under the Parallel and Concurrency section. The 
program has to ensure thread safety and concurrency in order for it to work well. 
The program is a typing game whereby the user is provided a Textbox for typing the words. The game 
had to follow the Model-View-Controller pattern . The Model-View-Controller pattern is an 
architectural pattern that helps in separating the system into three layers mainly the Model, View and 
Controller. The Model handles all the data logic meaning the source code, while the View is what the 
user sees which is the User interface. The Controller controls the flow of data to the objects that are 
created in the model, so as to update the user interface. The document will provide a description of all 
classes used; description of the java concurrency features used. Explanation of how the system was 
validated and debugged and also additional features that are used.

To run on the command line directory:
	first run make clean to clean the bin directory
	secondly run make to compile the files
        thirdly run java -cp bin WordApp <totalWords> <NoOfWords falling>
	For running another textfile make sure that it is in the bin directory first
