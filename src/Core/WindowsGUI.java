package Core;

import javax.swing.*;

public class WindowsGUI implements IGUIFactory{
    @Override
    public JButton CreateButton() {
        return  new JButton();
    }

    @Override
    public JTable CreateTable() {
        return new JTable();
    }
}
