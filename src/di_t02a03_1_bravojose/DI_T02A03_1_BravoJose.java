/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t02a03_1_bravojose;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class DI_T02A03_1_BravoJose extends Application {
 
    private final TableView table = new TableView();
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        // Creamos la escena, compuesta por un grupo
        Scene scene = new Scene(new Group());
        // Asignamos titulo a la escena
        stage.setTitle("Table View Sample");
        // Le damos un ancho
        stage.setWidth(300);
        // Le damos un alto
        stage.setHeight(500);
 
        // Creamos una etiqueta con el titulo de la agenda
        final Label label = new Label("Address Book");
        // Le damos estilo a la fuente
        label.setFont(new Font("Arial", 20));
 
        // Hacemos que la tabla sea editable (el contenido)
        table.setEditable(true);
 
        // Creamos las columnas con sus nombres
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        
        // Ocultamos la columna email, no queremos mostrar el correo (false), queremos mostrarlo (true), o por defecto
        //emailCol.setVisible(false);
        
        // Creamos las dos subcolumnas de email primario y secundario
        TableColumn firstEmailCol = new TableColumn("Primary");
        TableColumn secondEmailCol = new TableColumn("Secondary");
        
        // Añadimos estas dos subcolunas (o colunas anidadas) a la columna del email
        emailCol.getColumns().addAll(firstEmailCol, secondEmailCol);
        
        // Añadimos las columnas a la tabla
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
 
        // Creamos un contendor al que le damos espacio entre componentes, un padding y añadimos los componentes
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        // Al grupo que es el nodo raiz de la escena le añadimos el contenedor (layout) donde estan los componentes
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        // Establecemos esa escena como la escena activa del escenario, y mostramos el escenario
        stage.setScene(scene);
        stage.show();
    }
}