#Role Playing Game
##Problem Statement: 
Developed a simple role-playing game (RPG) using the concepts of Object-Oriented Programming (OOP). The game includes a hero, enemies, and items, allowing the hero to fight enemies and collect items. The implementation covers the following OOP concepts:

##Pillars of OOP:

###Encapsulation: 
Use private fields for classes and provide getter/setter methods.

###Inheritance: 
Create a base class Character and derive subclasses Hero and Enemy.

###Polymorphism: 
Use method overriding to allow different behaviors for the attack() method in Hero and Enemy classes.

###Abstraction: 
Create abstract methods in the Character class for actions like attack(), which are implemented differently in Hero and Enemy.

###Exception Handling (throw, throws, and finally):
Handle exceptions when the hero tries to use an item that is not in their inventory. Throw a custom exception ItemNotFoundException. Ensure that finally is used to display a message like "Action completed."

###Static Methods and Variables:
a static method to keep track of the total number of enemies defeated in the game.

###Type Casting:
certain types of items (e.g., HealthPotion) are type-cast from a base class Item to restore health.
String Functions:

Use string functions for hero and enemy names. For example, check if a hero’s name contains certain characters, or modify the hero’s name when they collect a special item.

###Array of Objects:
An array of Item objects in the hero’s inventory. The array can store different types of items (e.g., Weapon, Armor, Potion).
Association and Aggregation:

###Association: 
The Hero class should be associated with an Enemy during a battle.
###Aggregation: 
The Hero class aggregates multiple Item objects.


the ###final keyword is used to create a constant for maximum health of the hero.

##Requirements:

###Abstract Character Class (Base class for all characters in the game)

Attributes: name, health, attackPower
Methods: attack(), takeDamage(), isAlive()

###Hero Class (Inherits from Character)

Additional Attributes: inventory (Array of Item objects)
Methods: useItem(), addItem(), removeItem(), attack()
Enemy Class (Inherits from Character)

Different attack behavior than the Hero.
Item Class (Base class for items)

Attributes: name, type
HealthPotion Class (Inherits from Item)

Special behavior for restoring health.
Weapon and Armor Classes (Inherit from Item)

Weapons increase the hero’s attack power; Armor decreases damage taken.
Custom Exceptions:

###ItemNotFoundException: 
Thrown when the hero tries to use an item not in their inventory.

##Game Class:

Manages the game loop, handles battles between the hero and enemies, and displays the current game status.

##Scenario:

The hero battles an enemy, attacking and taking damage.
After defeating the enemy, the hero collects a prize which can be an armor, weapon or health potion.
The hero tries to use the potion, and the program handles an exception if the potion is not in the inventory.
The game tracks how many enemies have been defeated in total.
Different items in the inventory (like potions and weapons) are cast to their specific types to apply their effects.
Game gets over if all enemies are defeated or the hero is defeadted 