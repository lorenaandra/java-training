package clean.code.chess.requirements;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Map<PawnPosition, Pawn> mapOfPositionAndPawn;
    private Map<Pawn, PawnPosition> mapOfPawnAndPosition;



    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
        this.mapOfPawnAndPosition = new HashMap<>(MAX_BOARD_WIDTH * MAX_BOARD_HEIGHT);
        this.mapOfPositionAndPawn = new HashMap<>(MAX_BOARD_WIDTH * MAX_BOARD_HEIGHT);
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        boolean isValid = false;
        if (pieceColor == PieceColor.WHITE) {
            isValid = ((xCoordinate == 0 || xCoordinate == 1) && (getPawn(new PawnPosition(xCoordinate, yCoordinate)) == null));
        } else if (pieceColor == PieceColor.BLACK) {
            isValid = ((xCoordinate == MAX_BOARD_HEIGHT - 1 || xCoordinate == MAX_BOARD_HEIGHT) && (getPawn(new PawnPosition(xCoordinate, yCoordinate)) == null));
        }

        if (isValid) {
            pawn.addPawnOnChessboard(this, xCoordinate, yCoordinate);
        }
    }

    public Pawn getPawn(PawnPosition position) {
        return this.mapOfPositionAndPawn.get(position);
    }

    public void updatePawnPositionOnChessBoard(Pawn pawn, int xCoordinate, int yCoordinate) {
        PawnPosition newPosition;
        if (IsLegalBoardPosition(xCoordinate, yCoordinate)) {
            newPosition = new PawnPosition(xCoordinate, yCoordinate);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
        }
        else {
            newPosition = new PawnPosition(-1, -1);
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }

        this.mapOfPawnAndPosition.put(pawn, newPosition);
        this.mapOfPositionAndPawn.put(newPosition, pawn);
    }


    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (getPawn(new PawnPosition(xCoordinate, yCoordinate)) == null) &&
                ((xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH) && (yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT));
    }
}
