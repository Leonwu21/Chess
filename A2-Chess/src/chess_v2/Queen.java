package chess_v2;

import javafx.scene.image.Image;

public class Queen extends ChessPiece {
    
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the queen piece according to color.
     * @param red as a boolean
     */
    public Queen(boolean red) {
        super(new Image ((red) ? "File:src\\chess\\images\\QueenR.png"
                : "File:src\\chess\\images\\QueenB.png"));
        isRed = red;
    }

    @Override
    /**
     * Returns true if move attempted is a valid move.
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        if (colCompare == colInMemory || rowCompare == rowInMemory)
            return true;
        if (Math.abs(colCompare - colInMemory) == Math.abs(rowCompare - rowInMemory))
            return true;
        return false;
    }
    
    /**
     * Returns true if piece is red.
     * @return isRed as a boolean
     */
    public boolean isRed() {
        return isRed;
    }
}
