module com.ruftech.course_work {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
//    requires lombok;

    opens com.ruftech.course_work to javafx.fxml;
    opens com.ruftech.course_work.db_data to javafx.base;
    exports com.ruftech.course_work;
}