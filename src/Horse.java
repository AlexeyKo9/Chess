public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line >= 0 && line < 8) && (column >= 0 && column < 8) && (toLine >= 0 && toLine < 8) &&
                (toColumn >= 0 && toColumn < 8)) {
            if ((chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                    chessBoard.board[line][column] != null) {
                int diffLine = Math.abs(toLine - line);
                int diffColumn = Math.abs(toColumn - column);
                if ((diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2)) {
                    if ((column != toColumn) && (line != toLine)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
