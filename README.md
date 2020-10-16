# :four_leaf_clover: MiniExcel :green_heart:
## Click on image to start demo-video:
[![Watch the video](https://github.com/SophiaYarmolenko/MiniExcel/blob/master/startPhoto.jpg)](https://youtu.be/wUbJSr8SITw)
## About project:
*    Implemented mini excel, that can analyze given formula in cell (another cells can be like parameters in formula)
*    Operation that you can use:
- [x] logical operation: '<', '<=', '>', '>=', '!', '!='
- [x] arithmetic operations: '+', '-', '*', '/', '%' - the remainder of the division, ':' - aimed division
- [x] constants: 'e', 'pi' 
## What was used:
*    ANTLR for analyze formula in cell
*    JavaFx for GUI
## Parse Tree in ANTLR:
You can see grammar and rules in "LibExp.g4"
### Example of parse tree of expresion "12-AO+3*(5+1/4) >= 1+3+B0"
![ParseTree](https://github.com/SophiaYarmolenko/MiniExcel/blob/master/ParseTree.png)
## Class diagram:
![ClassesDiagram](https://github.com/SophiaYarmolenko/MiniExcel/blob/master/ClassesDiagram.png)


