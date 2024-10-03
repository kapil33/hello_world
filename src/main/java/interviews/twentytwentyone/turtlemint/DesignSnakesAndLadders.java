package interviews.twentytwentyone.turtlemint;

public class DesignSnakesAndLadders {
    /*
     * Problem Statement: Design Snakes and Ladders game. LLD.
     *
     * Actors: User, System, Admin(skip)
     *
     * Use Case:
     * 1. user starts a game
     * 2. User rolls a dice and moves n steps ahead
     * 3. system checks after each move whether its a snake or a ladder or none and take appropriate steps
     * 4. user reaches last index and game over
     *
     * Classes:
     * Abstract Person: id, name, Address, phone_number
     * User: position(i,j)
     * Game:
     * Attributes { TotalUser, List<User>, Winner, currentUser }
     * Behaviours {startGame, endGame, rollDice}
     * Board:
     * Attributes { Map<Pair<>, Pair<>> Ladders, Map<Pair<>, Pair<>> Snakes }
     * Behaviours {isSnake, isLadder, isLastIndex}
     *
     * UML:
     * Game --composition-- Board {Game has an instance of System}
     *
     * */
}
