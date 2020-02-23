package chess_v2;

import javafx.scene.image.Image;

public class King extends ChessPiece {
    
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the King piece according to color.
     * @param red as a boolean
     */
    public King(boolean red) {
        super(new Image ((red) ? "File:src\\chess\\images\\KingR.png"
                : "File:src\\chess\\images\\KingB.png"));
        isRed = red;
    }

    @Override
    /**
     * Returns true if move attempted is a valid move.
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        if (Math.abs(colCompare - colInMemory) <= 1) {
            if (Math.abs(rowCompare - rowInMemory) <= 1)
                return true;
        } else if (Math.abs(rowCompare - rowInMemory) <= 1) {
            if (Math.abs(colCompare-colInMemory) <= 1)
                return true;
        }
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
