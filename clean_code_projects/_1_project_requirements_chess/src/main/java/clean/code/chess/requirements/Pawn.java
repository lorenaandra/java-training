package clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getColor() {
        return this.pieceColor;
    }

    private int getMovingDirection() {
        if (getColor() == PieceColor.BLACK) {
            return -1;
        }
        return +1;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        // check if x coordinate is valid + is y coordinate is valid
        if ((newX == getXCoordinate() ||
                newX == getXCoordinate() + getMovingDirection()) &&
                    (newY == getYCoordinate() - 1 || newY == getYCoordinate() ||
                                                            newY == getYCoordinate() + 1))
            this.chessBoard.updatePawnPositionOnChessBoard(this, newX, newY);
    }

    public void addPawnOnChessboard(ChessBoard chessBoard, int xCoordinate, int yCoordinate) {
        this.chessBoard = chessBoard;
        this.chessBoard.updatePawnPositionOnChessBoard(this, xCoordinate, yCoordinate);
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
