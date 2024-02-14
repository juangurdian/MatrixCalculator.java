import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MatrixView extends JFrame {
    JButton calculateButton, clearButton;
    JLabel label, operationLabel;
    JComboBox<String> matrixOneRows, matrixOneColumns, matrixTwoRows, matrixTwoColumns, operationBox;
    JTextArea resultArea;
    int[][] matrixOne, matrixTwo, resultMatrix;
    Color tcuPurple = new Color(52, 42, 123);

    public MatrixView() {
        setTitle("Matrix Calculator");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        handleNorth();
        handleCenter();
        handleSouth();

        getContentPane().setBackground(tcuPurple);

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.EAST);

        setVisible(true);
    }

    public void handleNorth() {
        label = new JLabel("Matrix Calculator");
        label.setForeground(Color.WHITE);
        add(label, BorderLayout.NORTH);
    }

    public void handleCenter() {
        JPanel centerPanel = new JPanel(new GridLayout(3, 1));

        JPanel dimensionPanel = new JPanel(new FlowLayout());
        matrixOneRows = new JComboBox<>(new String[] { "1", "2", "3", "4" });
        matrixOneColumns = new JComboBox<>(new String[] { "1", "2", "3", "4" });
        matrixTwoRows = new JComboBox<>(new String[] { "1", "2", "3", "4" });
        matrixTwoColumns = new JComboBox<>(new String[] { "1", "2", "3", "4" });
        dimensionPanel.add(new JLabel("Matrix 1: Rows"));
        dimensionPanel.add(matrixOneRows);
        dimensionPanel.add(new JLabel("Cols"));
        dimensionPanel.add(matrixOneColumns);
        dimensionPanel.add(new JLabel("Matrix 2: Rows"));
        dimensionPanel.add(matrixTwoRows);
        dimensionPanel.add(new JLabel("Cols"));
        dimensionPanel.add(matrixTwoColumns);

        JPanel operationPanel = new JPanel(new FlowLayout());
        operationLabel = new JLabel("Operation:");
        operationBox = new JComboBox<>(new String[] { "Add", "Subtract", "Multiply" });
        operationPanel.add(operationLabel);
        operationPanel.add(operationBox);

        centerPanel.add(dimensionPanel);
        centerPanel.add(operationPanel);

        centerPanel.setBackground(tcuPurple);
        dimensionPanel.setBackground(tcuPurple);
        operationPanel.setBackground(tcuPurple);
        matrixOneRows.setBackground(tcuPurple);
        matrixOneColumns.setBackground(tcuPurple);
        matrixTwoRows.setBackground(tcuPurple);
        matrixTwoColumns.setBackground(tcuPurple);
        operationBox.setBackground(tcuPurple);

        matrixOneRows.setForeground(Color.BLACK);
        matrixOneColumns.setForeground(Color.BLACK);
        matrixTwoRows.setForeground(Color.BLACK);
        matrixTwoColumns.setForeground(Color.BLACK);
        operationBox.setForeground(Color.BLACK);
        operationLabel.setForeground(Color.WHITE);

        add(centerPanel, BorderLayout.CENTER);
    }

    public void handleSouth() {
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener());

        JPanel southPanel = new JPanel();
        southPanel.add(calculateButton);
        southPanel.add(clearButton);

        southPanel.setBackground(tcuPurple);
        calculateButton.setBackground(tcuPurple);
        clearButton.setBackground(tcuPurple);
        calculateButton.setForeground(Color.BLACK);
        clearButton.setForeground(Color.BLACK);

        add(southPanel, BorderLayout.SOUTH);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button clicks for calculateButton
            // Implement matrix calculations and result display here
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button clicks for clearButton
            resultArea.setText(""); // Clear the resultArea
        }
    }

    // You can add getter methods to retrieve user input and selected operations

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MatrixView();
            }
        });
    }
}

