package chess_v2;

import javafx.scene.image.Image;

public class Rook extends ChessPiece {
    
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the rook piece according to color.
     * @param red as a boolean
     */
    public Rook(boolean red) {
        super(new Image ((red) ? "File:src\\chess\\images\\RookR.png"
                : "File:src\\chess\\images\\RookB.png"));
        isRed = red;
    }

    @Override
    /**
     * Returns true if move attempted is a valid move.
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        if (colInMemory == colCompare)
            if (rowInMemory != rowCompare)
                return true;
        if (rowInMemory == rowCompare)
            if (colInMemory != colCompare)
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
