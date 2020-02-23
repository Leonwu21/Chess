package chess_v2;

import javafx.scene.image.Image;

public class Pawn extends ChessPiece {
    
    /** Stores the boolean representing the first turn. */
    private boolean firstTurn;
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the pawn piece according to color.
     * @param red as a boolean
     */
    public Pawn(boolean red) {
        super(new Image ((red) ? "File:src\\chess\\images\\PawnR.png"
                : "File:src\\chess\\images\\PawnB.png"));
        isRed = red;
        firstTurn = true;
    }

    /**
     * Returns true if piece is red.
     * @return isRed as a boolean
     */
    public boolean isRed() {
        return isRed;
    }
    
    @Override
    /**
     * Returns true if move attempted is a valid move.
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        if (colInMemory != colCompare)
            return false;
        else if (colInMemory == colCompare && rowInMemory == rowCompare)
            return false;
        else if (!firstTurn) {
            if (isRed) {
                if (rowCompare == rowInMemory + 1)
                    return true;
            } else {
                if (rowCompare == rowInMemory - 1)
                    return true;
            }
        } else {
            firstTurn = false;
            if (isRed) {
                if (rowCompare == rowInMemory + 1 || rowCompare == rowInMemory + 2)
                    return true;
            } else {
                if (rowCompare == rowInMemory - 1 || rowCompare == rowInMemory - 2)
                    return true;
            }
            
        }
        return false;
    }
    
}
