# SUDOKU BY USENKANOV ULARBEK
THIS WAS VERY AND VERY DIFFICULT BUT VERY INTERESTING TRYING TO UNDERSTAND MANY THINGS.
THIS IS A BASIC SUDOKU GAME 9X9 SIZE AND IT CAN quite MANY FEATURES INSIDE.
It has no bugs with Invalid values as for as I know, and if the Backtracking method won't create SudokuField (it usually will), it will tell you this. It has very easy CL interface and interesting thing: if there's a mistake in ur 3 last guessesm, it will say it to you. If u tired and don't want to continue u can leave anytime and close the game. Btw if you finish it'll show you Time you spent.
## Design choices
What can I say here, I used ArrayList only in makingBoard because i can't even do Tasks from vjudge with it, it's too complicated for me for now. I used arrays for the Board. I used backtracking for generating the Board (it's method when it checks does her random number fits the rules if it doesn't it will try again and again and again etc, if it's deadend it will say it). Separating the generation and the checking was necessary because I started to mess up.
### Functions: 
"main" is main :\

"startGame" says hello and suggest you to choose level

"play" shows board, takes your answer, quits if q, and says if there's problem with input. And congrats you if finished.

"generateGame" erases the board, uses "makeBoard" to generate Board in SOLUTION, and gives to NOSOLUTION same valuesm, then with "removeNUmbers" leaves numbers with these rules: 35 easy, 27 normal, 20 hard.

"makeBoard" creates Board by backtracking

"isSafe" checks the rules and gives boolean to makeBoard (Valid/No);

"removeNUmbers" in generategame

"canBe" checks can YOU put ur guess or not.

"isSolved" checks if Board is solved.

"ShowBoard" shows board.

## Challenges
The whole project was a challenge, it seems like I checked the all Internet. The feeling when you go to sleep and don't understand what you typed yesterday. if i didn't use Internet i'd never know how to create Sudokugame creator because it's too hard for me, + i had problems with Random and Time. + I used Chatgpt to check does even Sudoku have solution.

### SCREENSHOTS

![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(1).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(2).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(3).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(4).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(5).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(6).png)
![image alt](https://github.com/Phongare/UlarbekUSudoku/blob/71339dcafbec7407671cb1cadc6314262c9d0979/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(7).png)
