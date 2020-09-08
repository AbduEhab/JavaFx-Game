## Table of contents
* [Overview](#overview)
* [Technologies](#technologies)
* [Setup](#setup)
* [Copyright](#copyright)
* [Introduction](#introduction)
* [Card-type Explenation](#Card-type-explenation)
* [Gameplay](#gameplay)
* [ToDo](#todo)

---

#Overview

This is a Hearthstone style game made with java using the FX library. Originaly made as a uni project, but i thought people might wanna look through it to learn more about java and oop in general. So I added a few quality of life features and I'm going to leave it here.

Special thanks to fad11 for adding his own touch here and there.

Note: Audio clips may cause a problem for some IDE's so I commented them out.

#Technologies

'JAVA SDK 11'
'OpenFX 14'

#Setup

Download the 'Java SDK' from oracle or from your linux repository.
Download JavaFX from the 'OpenFX' page or as an extention into your prefered editor.
Thats it!

#Copyright

As long as you don't add your name to it and redistribute or use it in a commercial setting without crediting me
(same goes for educational purposes), i'm ok with whatever you wanna to do with it.

#Introduction

1. Only one 'main' method exists and it is located in the "Main" file

2. Upon running the file, you will be greated with the start screen.
	a. select 2 characters (Non identical) and the game will automaticly start.
	b. selecting the same character will result in the deselection of said character.

3. once game has loaded, you will be greeted with a 3 card tipping sound effect.
	a. On the right side, you have your deck(towords your side), 
		the enemy deck(towords the enemy side) 
		and the "End Turn" button (between both decks).
	b. On the bottom, you have your own cards.
	c. On the left, you have your hero(towords your side) and the enemy hero(towords the enemy side).
	d. In the middle is the card fields, devided by a white line to difrentiate your field(south of the line)
		and the enemy field(north of the line).

#Card-type Explenation

1. 'The Minion Card':
	a. The minion's name is on the top of the card.
	b. The minion' HP is directly beneath the name on the left. 
		It has a green boarder that will change to yellow and red as its health depleats.
	c. The attack value is in red and is placed right next to the HP.
	d. The manacost of the minion is on the right of the attack value and has a cyan border.
	e. The third row diplayes if the minion is taunt, devine, or sleeping by the indicated letter.

2. 'The Spell Card':
	a. Name Same as minion
	b. The Spell card only has a manacost bar.

3. 'Hero':
	a. Name Same as minion
	b. Directly below that is the mana crystal that you have (Max 10).
	c. Even below that is the health of your hero which has a green boarder that changes color too.

#Gameplay

So... This is a quick guide on how to run and play the game.

1. To select any card you click on it. To deselect, you click again. Same applies to the hero.

2. To play a 'minion': select it and then click on your field.
	Note: If you try playing into the enemy field, or into your own hand,  an appropriat message will show up.

3. To play a 'spell': select it and then either select the field or the card to play it on (depends on the spell)
	Note: If you choose a card instead of choosing a field, or vise versa, a "-Null-" message will show up.
		a similar message will pop up if you tried to use it on a unplayed card etc...

4. To attack an 'enemy minion' or 'hero', select the 'minion' to attack with and then select the 'minion' or 'hero' to attack.
	Note: An appropriate message will show up if you clicked something you shouldn't.

5. To use 'Hero power': Select your 'hero', then select the 'enemy hero' or 'minion' to use it on.
	Note: An appropriate message will show up if you clicked something you shouldn't.

6. To end your turn your turn: Click on the "End Turn" button.
	Note: An appropriate message will show up if you'll burn a card.

7. On the end screen you will be presented with the winner of the game and will be given the option to either
	quit out of the game or to go to the main screen to choose diffrent characters and play again. 

#ToDo

* Redo the view to make it more appealing and optimize some code.
