package se.iths.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Model {
    private StringProperty name = new SimpleStringProperty();
private ObservableList<String> names = FXCollections.observableList(new ArrayList<>());

    public ObservableList<String> getNames() {
        return names;
    }

    public String addNames(String name) {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
