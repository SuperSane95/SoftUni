import turtle

chess = turtle.Turtle()
chess.penup()
chess.backward(300)
chess.left(90)
chess.forward(50)
chess.forward(200)
chess.right(90)
chess.pendown()


def drawBlackSquare():
    chess.begin_fill()
    for i in range(4):
        chess.forward(size)
        chess.right(90)
    chess.end_fill()


def drawWhiteSquare():
    for i in range(4):
        chess.forward(size)
        chess.right(90)


def drawRowBlack():
    black = True
    for i in range(8):
        if black:
            drawBlackSquare()
            black = False
        else:
            drawWhiteSquare()
            black = True
        chess.forward(size)


def drawRowWhite():
    black = False
    for i in range(8):
        if black:
            drawBlackSquare()
            black = False
        else:
            drawWhiteSquare()
            black = True
        chess.forward(size)


def goBack():
    back = size * 8
    chess.right(180)
    chess.forward(back)
    chess.left(90)
    chess.forward(size)
    chess.left(180)
    chess.right(90)


size = int(input("Enter size: "))
startBlack = True
chess.speed('fast')
for i in range(8):
    if startBlack:
        drawRowBlack()
        goBack()
        startBlack = False
    else:
        drawRowWhite()
        goBack()
        startBlack = True

input()

# handmade
