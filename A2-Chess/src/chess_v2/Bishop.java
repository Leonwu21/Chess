package chess_v2;

import javafx.scene.image.Image;

public class Bishop extends ChessPiece {
    
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the bishop piece according to color.
     * @param red as a boolean
     */
    public Bishop(boolean red) {
        super(new Image ((red) ? "File:src\\chess\\images\\BishopR.png"
                : "File:src\\chess\\images\\BishopB.png"));
        isRed = red;
    }

    @Override
    /**
     * Returns true if move attempted is a valid move.
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        if (colInMemory == colCompare || rowInMemory == rowCompare)
            return false;
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
