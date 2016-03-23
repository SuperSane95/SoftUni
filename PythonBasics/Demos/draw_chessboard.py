import turtle


def move_to_beginning(chess):
    chess.penup()
    chess.backward(300)
    chess.left(90)
    chess.forward(50)
    chess.forward(200)
    chess.right(90)
    chess.pendown()


def draw_black_square(chess, size):
    chess.begin_fill()
    for i in range(4):
        chess.forward(size)
        chess.right(90)
    chess.end_fill()


def draw_white_square(chess, size):
    for i in range(4):
        chess.forward(size)
        chess.right(90)


def draw_row_black(chess, size):
    black = True
    for i in range(8):
        if black:
            draw_black_square(chess, size)
            black = False
        else:
            draw_white_square(chess, size)
            black = True
        chess.forward(size)


def draw_row_white(chess, size):
    black = False
    for i in range(8):
        if black:
            draw_black_square(chess, size)
            black = False
        else:
            draw_white_square(chess, size)
            black = True
        chess.forward(size)


def go_back(chess, size):
    back = size * 8
    chess.right(180)
    chess.forward(back)
    chess.left(90)
    chess.forward(size)
    chess.left(180)
    chess.right(90)


def main():
    size = int(input("Enter size: "))
    chess = turtle.Turtle()
    start_black = True
    chess.speed('fast')
    move_to_beginning(chess)

    for i in range(8):
        if start_black:
            draw_row_black(chess, size)
            go_back(chess, size)
            start_black = False
        else:
            draw_row_white(chess, size)
            go_back(chess, size)
            start_black = True

    turtle.exitonclick()

if __name__ == '__main__':
    main()

