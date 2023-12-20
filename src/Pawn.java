public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line >= 0 && line < 8) && (column >= 0 && column < 8) && (toLine >= 0 && toLine < 8) &&
                (toColumn >= 0 && toColumn < 8) && chessBoard.board[line][column] != null) {
            if (column == toColumn) {
                int x;
                int start;

                if (color.equals("White")) {
                    x = 1;
                    start = 1;
                } else {
                    x = -1;
                    start = 6;
                }

                if (line + x == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }

                if (line == start && line + 2 * x == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + x][column] == null;
                }

            } else { // want to eat piece

                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) &&
                        chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }
}
