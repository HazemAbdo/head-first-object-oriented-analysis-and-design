//we found that each game that will be build on our framework will have a different algorithm
//to handle units movement and a different algorithm to check if a movement is legal or not.
//so we found that we will leave these algorithms to the game itself.
//----------------------------------------------------------------------------------------------
//?Q: But there is some commonality,isn’t there? A movement algorithm, 
//?and a check to see if a move is legal, right?
//A: You’re right. So, in theory, you could write a Movement interface,
//with a method like move() that took in a MovementAlgorithm and a
//LegalMoveCheck, or something similar. And then each game designer could
//extend MovementAlgorithm and LegalMoveCheck. If you thought of
//something like this, nice work! You’re really ahead of the game.
//But then ask yourself: what does this really gain? Game designers are going to have
//to learn your interfaces, and if they don’t have a legality check, they might pass
//in null for the LegalMoveCheck parameter, and what would the interface for
//MovementAlgorithm look like, and...well, //!you’re probably adding complexity,
//rather than really removing it.Your job is to reduce risk and complexity,
//not increase it. We decided that it would be simpler to let game designers handle
//movement, and just change the position of units on the board (using methods on
//Board, which we did take care of for them)