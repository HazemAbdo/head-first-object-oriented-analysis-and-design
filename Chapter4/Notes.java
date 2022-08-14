
//*delegation helps our applications stay loosely coupled. 
// That means that your objects are independent of each other; in other words, changes to one object
// don’t require you to make a bunch of changes to other objects
//---------
//* Delegation shields your objects from implementation changes to other objects in your software.
//------------------------------------------------------------------------------
//* some use case and class diagram stuff:
//* textual analysis.
// Looking at the nouns (and verbs) in your use case to figure out classes and methods is called 
//---------
//Maria’s figured out something really important: the nouns in a use case are usually the classes 
//you need to write and focus on in your system.
//---------
// The verbs in your use case are (usually) the methods of the objects in your system
//---------
//* Association:
// A solid line from one class(source) to another(target) is called an association. It means that one class is
// associated with another class, by //* reference, extension, inheritance, etc.
//---------
//* Multiplicity:
//This number is the multiplicity of this association. It’s how many of the target type is stored in
//the attribute of the source class. In this case, the door attribute stores a single DogDoor.

//------------------------------------------------------------------------------
//Here we have three engineers with three different ways to make a system that open the door based 
//on the barking of the dog.and the one with the most efficient system will win a MacBook pro.
//1.Randy: simple is best, right?
//Randy says that this operation is very simple and no need for OOP at all
//we will have a string represents the sound of our dog 
//and in the recognizer we will have a function that compare the heard voice(String) with our dog sound(String)
//if they are equal then we will open the door
//if they are not equal we will do nothing
//?where are the problems with this approach?
//!Randy didn't use any delegation so he make the recognizer responsible for the comparison
//what if we want the voice to be a more complex one for example Wav file and we will have a complex 
//compare function that will compare the heard voice with the Wav file
//!what if our dog have multiple sounds?
//all of these show that Randy didn't use a good approach.
//---------------------------------------------------------------------
// 2.Sam: object lover extraordinaire
//Sam make a Class called Bark that represent the sound of our dog and also make 
//the compare function that will compare the heard voice with the dog sound
//* so sam use delegation(Delegation ((((shields)))) your objects from implementation changes 
//to other objects in your software.)so if we change the formate then we will make no change to
//the recognizer Class
//?where are the problems with this approach?
//!what if our dog have multiple sounds?
//here Sam system doesn't handle this situation
//the problem is that sam didn't give that much attention to the use case so he focused on the wrong 
//thing he focus on bark not on the dog itself so he think if we handle case of one sound all is good
//---------------------------------------------------------------------
//3.Maria:Use case for rescue(she won the MacBook Pro!)
//maria focused on the use case and focus on the most important thing that is the dog itself not the bark
//so she make linked list of the dog sounds and make a compare function that will compare the heard voice with the dog sound
//* also maria make a class diagram to visualize the system and this help her to understand the system better
//and think in the //* real world context 