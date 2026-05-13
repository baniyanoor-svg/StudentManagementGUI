import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementGUI {

    JFrame frame;

    JTextField idField;
    JTextField nameField;
    JTextField courseField;

    JTextArea displayArea;

    ArrayList<Student> list = new ArrayList<>();

    StudentManagementGUI() {

        frame = new JFrame("Student Management System");

        // Input Fields
        idField = new JTextField(10);
        nameField = new JTextField(10);
        courseField = new JTextField(10);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("View");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton clearBtn = new JButton("Clear");

        // Text Area
        displayArea = new JTextArea(12, 35);
        displayArea.setEditable(false);

        // Panel
        JPanel panel = new JPanel();

        panel.add(new JLabel("ID"));
        panel.add(idField);

        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("Course"));
        panel.add(courseField);

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        panel.add(clearBtn);

        // Add Components
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // ADD BUTTON
        addBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String course = courseField.getText();

            list.add(new Student(id, name, course));

            displayArea.setText(
                displayArea.getText() +
                "\nStudent Added Successfully!"
            );
        });

        // VIEW BUTTON
        viewBtn.addActionListener(e -> {

            displayArea.setText("");

            for (Student s : list) {

                displayArea.append(
                    "ID: " + s.id +
                    ", Name: " + s.name +
                    ", Course: " + s.course + "\n"
                );
            }
        });

        // UPDATE BUTTON
        updateBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());

            for (Student s : list) {

                if (s.id == id) {

                    s.name = nameField.getText();
                    s.course = courseField.getText();

                    displayArea.setText(
                        displayArea.getText() +
                        "\nUpdated Successfully!"
                    );
                }
            }
        });

        // DELETE BUTTON
        deleteBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());

            list.removeIf(s -> s.id == id);

            displayArea.setText(
                displayArea.getText() +
                "\nDeleted Successfully!"
            );
        });

        // CLEAR BUTTON
        clearBtn.addActionListener(e -> {

            idField.setText("");
            nameField.setText("");
            courseField.setText("");
        });

        // Frame Settings
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new StudentManagementGUI();
    }
}