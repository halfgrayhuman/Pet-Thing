module com.codedotorg {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    opens com.codedotorg to javafx.fxml;
    exports com.codedotorg;
}
