public class King extends ChessPiece{
    public King(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol(){
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line >= 0 && line < 8) && (column >= 0 && column < 8) && (toLine >= 0 && toLine < 8) &&
                (toColumn >= 0 && toColumn < 8)) {
            if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;

            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;

            if (chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }

            return true;
        } else return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(getColor())){
                        if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        } return isUnderAttack;

    }
}
