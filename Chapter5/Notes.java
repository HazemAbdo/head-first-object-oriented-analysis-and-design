//*Abstract class */
//Abstract classes are placeholders for actual implementation classes. The abstract class defines behavior, 
//and the subclasses implement that behavior.
//--------------------------------------------------------------------------------------------
//*Aggregation*/
//Aggregation is a special form of association, and means that one thing is made up (in part) of another thing.
//So Instrument is partly made up of InstrumentSpec.
//--------------------------------------------------------------------------------------------
//*Generalization */
//generalization. You use a generalization to show that a class (like Mandolin) extends and inherits behavior 
//from a more generalized class (like Instrument)
//--------------------------------------------------------------------------------------------
//*Interface */
//This code construct has the dual role of defining behavior that applies to multiple types, 
//and also being the preferred focus of classes that use those types.
//Anytime you’re writing code that interacts with these classes, you have two choices.
//You can write code that interacts directly with a subclass,like FootballPlayer, 
//or you can write code that interacts with the interface, Athlete. When you run into a choice like this, you should
//always favor coding to the interface, not the implementation.
//--------------------------------------------------------------------------------------------
//*Encapsulation */
//It’s been responsible for preventing more maintenance problems than any other OO principle in history, 
//by localizing the changes required for the behavior of an object to vary
//--------------------------------------------------------------------------------------------
//*Change */
//Every class should attempt to make sure that it has only one reason to do this, the death of
//many a badly designed piece of software.
//you’re minimizing the chances that a class is going to have to change by reducing the number of things in 
//that class that can cause it to change.
//When you see a class that has more than one reason to change, it is probably trying to do too many things. See
//if you can break up the functionality into multiple classes, where each individual class does only one thing—and
//therefore has only one reason to change.
//--------------------------------------------------------------------------------------------
//* OO Principles
//1.Encapsulate what varies.
//2.Code to an interface rather than to an implementation.
//3.Each class in your application should have only one reason to change.
//4. Classes are about behavior and functionality
//--------------------------------------------------------------------------------------------
//* Analysis and Design 
//Well-designed software is easy to change and extend.
//Use basic OO principles like encapsulation and inheritance to make your software more flexible.
//If a design isn’t flexible, then CHANGE IT! Never settle on bad design, even if it’s your bad design that has to change.
//Make sure each of your classes is //* cohesive: each of your classes should focus on doing ONE THING really well.
//Always strive for higher cohesion as you move through your software’s design life cycle
//--------------------------------------------------------------------------------------------
//the higher the cohesion in your application, the better defined each object’s job is. And the better defined an
//object (and its job) is, the easier it is to pull that object out of one context,and have the object do the same job in
//another context.//* The object is happy to just keep on doing its very specific job, no matter where it’s being used