import java.awt.event.*;
import javax.swing.JOptionPane;

public class MatrixController implements ActionListener {
    private MatrixView view;
    private MatrixModel model;

    public MatrixController(MatrixView view, MatrixModel model) {
        this.view = view;
        this.model = model;

        // Add action listeners to the view's components
        this.view.calculateButton.addActionListener(this);
        this.view.clearButton.addActionListener(new ClearButtonListener());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.calculateButton) {
            // Handle button clicks for calculateButton
            // Use methods from the model to perform matrix operations
            // Update the view with the results

            // Get user input for matrix one
            int rows1 = view.matrixOneRows.getSelectedIndex() + 1;
            int cols1 = view.matrixOneColumns.getSelectedIndex() + 1;
            int[][] matrixOne = getUserInput(rows1, cols1, "Enter values for Matrix 1");

            // Get user input for matrix two
            int rows2 = view.matrixTwoRows.getSelectedIndex() + 1;
            int cols2 = view.matrixTwoColumns.getSelectedIndex() + 1;
            int[][] matrixTwo = getUserInput(rows2, cols2, "Enter values for Matrix 2");

            // Perform matrix addition (you can extend this for subtraction and multiplication)
            int[][] result = model.add(matrixOne, matrixTwo);

            // Display the result in the resultArea
            displayMatrix(result);
        }
        // Handle other actions as needed
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button clicks for clearButton
            // Clear the resultArea
            view.resultArea.setText("");
        }
    }

    private int[][] getUserInput(int rows, int cols, String title) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String input = JOptionPane.showInputDialog(view, title + " - Enter value at row " + (i + 1) + ", column " + (j + 1));
                try {
                    matrix[i][j] = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    // Handle invalid input (e.g., show an error message)
                    JOptionPane.showMessageDialog(view, "Invalid input. Please enter a valid number.");
                    // You can choose to handle this differently based on your requirements
                }
            }
        }
        return matrix;
    }

    private void displayMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]).append("\t");
            }
            sb.append("\n");
        }
        view.resultArea.setText(sb.toString());
    }
}

