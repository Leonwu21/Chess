module chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires transitive javafx.graphics;
    requires javafx.base;
    
    opens chess to javafx.fxml;
    exports chess;
    opens chess_v2 to javafx.fxml;
    exports chess_v2;
}