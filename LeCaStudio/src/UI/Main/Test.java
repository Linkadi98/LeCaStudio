package UI.Main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;

public class Test implements Initializable{

    @FXML
    private JFXTreeTableView<Person> table;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        JFXTreeTableColumn<Person,String> name = new JFXTreeTableColumn("Name");
        name.setPrefWidth(100);

        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Person, String> param) {
                return param.getValue().getValue().name;
            }
        });

        JFXTreeTableColumn<Person,String> age = new JFXTreeTableColumn("Age");
        age.setPrefWidth(100);

        age.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Person, String> param) {
                return param.getValue().getValue().age;
            }
        });

        JFXTreeTableColumn<Person,String> address = new JFXTreeTableColumn("Address");
        address.setPrefWidth(100);

        address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Person, String> param) {
                return param.getValue().getValue().address;
            }
        });


        ObservableList<Person> person = FXCollections.observableArrayList();
        person.add(new Person("Genius Coders","20","Pune"));
        person.add(new Person("Nilesh Kadam","20","Hadapsar"));
        person.add(new Person("Shailesh Kadam","18","Gondhalenagar"));
        person.add(new Person("Subscirbers","21","All World"));

        final TreeItem<Person> root = new RecursiveTreeItem<Person>(person, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(name,age,address);
        table.setRoot(root);
        table.setShowRoot(false);



    }

    class Person extends RecursiveTreeObject<Person>{
        StringProperty name;
        StringProperty age;
        StringProperty address;

        public Person(String name,String age,String address)
        {
            this.name = new SimpleStringProperty(name);
            this.age  = new SimpleStringProperty(age);
            this.address = new SimpleStringProperty(address);

        }


    }

}