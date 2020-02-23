package chess_v2;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is the main board program that drives the chess game.
 * @author Leon Wu
 * @version 1.0
 */
public class Boardv2 extends Application{
    /** Tiles to be laid onto the board. */
    private Tile[][] tiles;
    /** GridPane to be used. */
    static GridPane grid;
    /** Scene to be set. */
    private Scene scene;
    /** ImageView to be stored on mouse clicks. */
    ImageView stored;
    
    /** Initializes all aspects of the board. */
    public Boardv2() {
        tiles = new Tile[8][8];
        grid = new GridPane();
        createTiles();
        setTiles(Tile.getLength(), Tile.getWidth());
    }
    
    /**
     * Sets the tiles array onto the GridPane.
     * @param length of tiles
     * @param width of tiles
     */
    public void setTiles(int length, int width) {
        for (int i = 0; i < 8; i ++) {
            for (int j = 0; j < 8; j++) {
                grid.add(tiles[i][j].root, i, j);
                if (i % 2 == 0) {
                    if (j % 2 == 1) {
                        tiles[i][j].setWhite();
                        tiles[i][j].setColor();
                    }
                } else {
                    if (j % 2 == 0) {
                        tiles[i][j].setWhite();
                        tiles[i][j].setColor();
                    }
                }
            }
        }
    }
    
    /** Creates the tiles of the tiles array to be set onto the grid. */
    public void createTiles() {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                switch(row) {
                case 0:
                    if (col == 0 || col == 7)
                        tiles[col][row] = new Tile(3, col, row);
                    if (col == 1 || col == 6)
                        tiles[col][row] = new Tile(5, col, row);
                    if (col == 2 || col == 5)
                        tiles[col][row] = new Tile(7, col, row);
                    if (col == 3)
                        tiles[col][row] = new Tile(9, col, row);
                    if (col == 4)
                        tiles[col][row] = new Tile(11, col, row);
                    break;
                case 1:
                    tiles[col][row] = new Tile(1, col, row);
                    break;
                case 6:
                    tiles[col][row] = new Tile(2, col, row);
                    break;
                case 7:
                    if (col == 0 || col == 7)
                        tiles[col][row] = new Tile(4, col, row);
                    if (col == 1 || col == 6)
                        tiles[col][row] = new Tile(6, col, row);
                    if (col == 2 || col == 5)
                        tiles[col][row] = new Tile(8, col, row);
                    if (col == 3)
                        tiles[col][row] = new Tile(10, col, row);
                    if (col == 4)
                        tiles[col][row] = new Tile(12, col, row);
                    break;
                default:
                    tiles[col][row] = new Tile(-1, col, row);
                }
            }
        }
    }

    /** Sets the JavaFX scene and stage. 
     * @param stage sets the scene
     */
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(Boardv2.grid, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Tiles");
        stage.show();
        Alert tutorial = new Alert(AlertType.NONE);
        tutorial.setAlertType(AlertType.INFORMATION);
        tutorial.setContentText("Red goes first!\n\nClick once to store piece to be moved"
                + "\nClick again to move piece.\n\nNOTE: Game logic not yet implemented!");
        tutorial.show();
    }
    
    /**
     * Launches the JavaFX application.
     * @param args unused
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
