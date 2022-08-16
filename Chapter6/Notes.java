// ? We need a lot more information
// ------------------------------
// What is the system like? //*commonality
// What is the system not like? //*variability
// ---------------------------------------------------------------
// *Features*/
// A feature is just a //* high-level description of something a system needs to do.
// A lot of times, you can take one feature, and come up with several different
// requirements that you can use to satisfy that feature.
// ---------------------------------------------------------------
// *Use Case Diagram */
// Use case diagrams are the //* blueprints for your system.
// Use your feature list to make sure your use case diagram is complete.
// An actor is actually any external entity (it doesn’t have to be a person)
// that interacts with the system.
// ---------------------------------------------------------------
// ! we’d never be sure we were building the right thing if we started talking
// ! about classes and variables.
// ---------------------------------------------------------------
// *Domain Analysis */
// That’s really what domain analysis is all about. We can talk to the customer
// *about their system, in terms that they understand.
// For Gary, that means talking about units, and terrain,
// and tiles, instead of classes, objects, and methods
// Domain analysis helps you avoid building parts of a system that aren’t your
// job to build.
// ---------------------------------------------------------------
// ! you don’t want a module to have just one class in it, or one that will have
// ! one or two hundred.
// ---------------------------------------------------------------
//*Solving Big Problems*/
//1. Listen to the customer, and figure out what they want you to build.
//2. put together feature list, in language the customer understands
//3. Make sure your features are what the customer actually wants
//4. Create blueprints of the system using use case diagrams(and use cases).
//5. Break the big system up into lots of smaller sections
//6. Apply design patterns to the smaller sections of the system
//7. Use basic OOA&D principles to design and code each smaller section