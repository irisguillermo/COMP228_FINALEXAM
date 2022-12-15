package com.example.finaltest2022;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.lang.Integer.parseInt;

public class BookController {

    public Button addBook_Brn;
    public Button filter_btn;

    public Button delete_btn;

    public TextField bookID_txtFld, BookTitle_txtFld, Author_txtFld, Category_txtFld, Year_txtFld;

    private String message;
    public void OnFilterButton(ActionEvent actionEvent) {
    }

    public void OnDeleteButton(ActionEvent actionEvent) {
    }

public void OnAddButton(ActionEvent actionEvent) throws SQLException
    {
        Connection connection = null;
        PreparedStatement statement = null;

        try
        {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);

            String query = "{CALL Book (?, ? , ? , ?, ?)}";
            statement = connection.prepareCall(query);
            statement = connection.prepareStatement(query);
            statement.setInt(1, parseInt(bookID_txtFld.getText()));
            statement.setString(2,BookTitle_txtFld.getText());
            statement.setString(3, Author_txtFld.getText());
            statement.setString(4, Category_txtFld.getText());
            statement.setInt(5,parseInt(Year_txtFld.getText()));
            int count = statement.executeUpdate();
            if (count == 1)
            {
                this.alert("Success", "New book item has been added", Alert.AlertType.INFORMATION);
            }
            else
            {
                this.alert("Failure", "Book item can not be added", Alert.AlertType.ERROR);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (null != statement)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (null != connection)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private void alert(String title, String message, Alert.AlertType alertType) {
    }
}
