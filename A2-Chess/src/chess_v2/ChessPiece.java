package chess_v2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents the chess piece images to be set on the board.
 * @author Leon Wu
 * @version 1.0
 */
public abstract class ChessPiece extends ImageView {
    
    /** Stores the boolean representing whether or not the piece is red. */
    private boolean isRed;
    
    /**
     * Initializes the chess piece according to image passed in.
     * @param image as piece
     */
    public ChessPiece(Image image) {
        super(image);
    }
    
    /**
     * Returns true if move attempted is a valid move.
     * @param colInMemory stored column index
     * @param rowInMemory stored row index
     * @param colCompare column index to be compared to
     * @param rowCompare row index to be compared to
     * @return true if move is valid
     */
    public boolean isValidMove(int colInMemory, int rowInMemory,
            int colCompare, int rowCompare) {
        return true;
    }

    /**
     * Returns true if piece is red.
     * @return isRed as a boolean
     */
    public boolean isRed() {
        return isRed;
    }
}
