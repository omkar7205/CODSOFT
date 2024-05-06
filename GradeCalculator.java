import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculator extends JFrame implements ActionListener {
    // Components
    JLabel[] subjectLabels;
    JTextField[] marksFields;
    JButton calculateButton;
    JTextArea resultArea;

    // Constructor
    public GradeCalculator() {
        setTitle("Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        subjectLabels = new JLabel[3];
        marksFields = new JTextField[3];
        for (int i = 0; i < 3; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + ": ");
            marksFields[i] = new JTextField(5);
            add(subjectLabels[i]);
            add(marksFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    // Action performed when Calculate button is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateGrade();
        }
    }

    // Calculate total marks, average percentage, and grade
    private void calculateGrade() {
        int totalMarks = 0;
        int subjects = 3;

        // Calculate total marks
        for (int i = 0; i < subjects; i++) {
            try {
                totalMarks += Integer.parseInt(marksFields[i].getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks for all subjects.");
                return;
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Assign grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        resultArea.setText("Total Marks: " + totalMarks +
                           "\nAverage Percentage: " + String.format("%.2f", averagePercentage) +
                           "\nGrade: " + grade);
    }

    // Main method
    public static void main(String[] args) {
        new GradeCalculator();
    }
}

