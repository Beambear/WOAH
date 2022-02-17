# WOAH
Project name:
  World of Aircraft Half-Life.


Motivation:
  When I developing this project, I am taking the class AdvancedProgramming Techniques. So this project is the class project to check my study process. I wanted to tried to challenge something more than the class. So I want to build a small game rather than just make some codes to match the class requirements. 


Class Contents；
  1. Object-Oriented FUndamentals
  2. Handling Text and Exceptions
  3. Generics
  4. Binary I/O, JavaFX, Lambdas and Streams
  5. Concurrency
  6. Database Connectivity / Networking Connectivity


Project describtion:
  Project 1[WOAH!] is a horizontal flight game. Player can control the aircraft with four direction keys (↑↓←→) and shoot the coming enemies. The target is getting more points
  until game over, player can gain points by shooting down enemies and getting reward items. Enemies will get stronger as time goes on. If possible, there could be a score board
  to show leaders’ scores and current player’s rank in system. The game will automatically save every 10 seconds.
  
  Special features:
    1.	Fuel point system: It’s a sort of health point. Player fuel point decreases as time goes on and will lose fuel point when player is hit by enemies. If fuel point 
    become 0 which means game over. Fuel jerry can will refresh on the screen randomly, hit it can gain the fuel point. 
    2.	Player can store maximum two weapons in inventory and select one to use.
    3.	Player have item box to store item and use selected item’s abilities (example: speed up, short distance blink).


Project set up:
  Clone this git repository to local file. Then run src/main/java/app/GameApp with IDE.
  Then there will be three options in IDE console. 
  (1)start new game
  (2)load
  (3)Exit
  type in the option number to the next step. like, input "1" to start a new game.
  Then the game frame will pop up. Use keyboards to control actions of charactor.
  
  Actions	     Input
  up	          ↑	
  down	        ↓	
  right	        →	
  Left	        ←	
  Fire	        D	
  Switch weapon	S	
  Use item	    E	
  Switch item	  W	
  Ultimate    	V	
  Pause	       ESC


Test:
  This project used Junit test.
  
Author:
  Jipeng Liu
  
Thanks:
  Professor Warren Mansur
  Facilitator Ed Orsini
  
