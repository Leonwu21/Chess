package chess_v2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class represents the square tiles on the chess board.
 * @author Leon Wu
 * @version 1.0
 */
public class Tile {
    /** Length of each tile. */
    static int length;
    /** Width of each tile. */
    static int width;
    /** True if tile is white. */
    private boolean white;
    /** Node used as tile representation. */
    public Rectangle rectangle;
    /** Groups the rectangles for the JavaFX scene. */
    public Group root;
    /** Stores the tileHandler event handler. */
    EventHandler tileHandler;
    /** Stores the chess piece. */
    ChessPiece piece;
    /** Stores a chess piece in memory. */
    static ChessPiece pieceInMemory;
    /** Stores the column coordinate in memory. */
    static int colInMemory;
    /** Stores the row coordinate in memory. */
    static int rowInMemory;
    /** Stores the last clicked column index. */
    static int colIndex;
    /** Stores the last clicked row index. */
    static int rowIndex;
    /** Stores the boolean representing whether or not red has last moved. */
    static boolean redMoved;

    /** Initializes all aspects of the Tile class. */
    public Tile(int whichPiece, int col, int row) {
        length = 50;
        width = 50;
        rectangle = new Rectangle(length, width);
        white = false;
        pieceInMemory = null;
        tileHandler = new EventHandler();
        root = new Group();
        root.getChildren().add(rectangle);
        setPiece(whichPiece);
        root.setOnMouseClicked(this.tileHandler::clickTile);
    }
    
    /**
     * Inner class of Tile handles mouse click event.
     * @author Leon Wu
     * @version 2.0
     */
    public class EventHandler {
        /**
         * Handles the mouse click event.
         * @param event
         */
        public void clickTile(MouseEvent event) {
            try {
                Node clickedNode = event.getPickResult().getIntersectedNode();
                Node parent = clickedNode;
                if (clickedNode != Boardv2.grid) {
                    parent = clickedNode.getParent();
                    while (parent != Boardv2.grid) {
                        clickedNode = parent;
                        parent = clickedNode.getParent(); 
                    }
                }
                colIndex = GridPane.getColumnIndex(clickedNode);
                rowIndex = GridPane.getRowIndex(clickedNode);      
                
                if (piece != null)
                    storePiece();
                else {
                    if (!redMoved) {
                        if (pieceInMemory.isRed()) {
                            move();
                            redMoved = true;
                        } else 
                            System.out.println("Wrong color's turn!");
                    } else {
                        if (!pieceInMemory.isRed()) {
                            move();
                            redMoved = false;
                        } else
                            System.out.println("Wrong color's turn!");
                    }
                }
            } catch (NullPointerException n) {;}
    }
    
        /** Stores the chess piece. */
        private void storePiece() {
                pieceInMemory = piece;
                colInMemory = colIndex;
                rowInMemory = rowIndex;
                piece = null;
                System.out.println("Piece stored");
        }
        
        /** Moves the chess piece. */
        private void move() {
                if (pieceInMemory != null
                    && pieceInMemory.isValidMove(colInMemory, rowInMemory,
                            colIndex, rowIndex)) {
                    try {
                    root.getChildren().add(pieceInMemory);
                    } catch (IllegalArgumentException i) {;}
                    System.out.println("Moved");
                } else
                    System.out.println("Invalid move");
                colInMemory = colIndex;
                rowInMemory = rowIndex;
        }
    }
    
    /**
     * Returns the length of the tile.
     * @return length
     */
    public static int getLength() {
        return length;
    }
    
    /**
     * Returns the width of the tile
     * @return width
     */
    public static int getWidth() {
        return width;
    }
    
    /** Sets the boolean white to be true. */
    public void setWhite() {
        white = true;
    }
    
    /** Sets the colors of the tiles. */
    public void setColor() {
        if (white) {
            rectangle.setFill(Color.WHITE);
        } else {
            rectangle.setFill(Color.BLACK);
        }
    }
    
    /**
     * Sets the initial chess pieces onto the relevant tiles.
     * @param whichPiece to set
     */
    public void setPiece(int whichPiece) {
        switch(whichPiece) {
        case 1:
            piece = new Pawn(true);
            root.getChildren().add(piece);
            break;
        case 2:
            piece = new Pawn(false);
            root.getChildren().add(piece);
            break;
        case 3:
            piece = new Rook(true);
            root.getChildren().add(piece);
            break;
        case 4:
            piece = new Rook(false);
            root.getChildren().add(piece);
            break;
        case 5:
            piece = new Knight(true);
            root.getChildren().add(piece);
            break;
        case 6:
            piece = new Knight(false);
            root.getChildren().add(piece);
            break;
        case 7:
            piece = new Bishop(true);
            root.getChildren().add(piece);
            break;
        case 8:
            piece = new Bishop(false);
            root.getChildren().add(piece);
            break;
        case 9:
            piece = new Queen(true);
            root.getChildren().add(piece);
            break;
        case 10:
            piece = new Queen(false);
            root.getChildren().add(piece);
            break;
        case 11:
            piece = new King(true);
            root.getChildren().add(piece);
            break;
        case 12:
            piece = new King(false);
            root.getChildren().add(piece);
            break;
        default:
            piece = null;
        }
    }
    
    /** Returns true if tile is white.
     * @return true if tile is white
     */
    public boolean isWhite() {
        return white;
    }
   
}
