import javax.swing.SwingUtilities;

public class MatrixApp {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MatrixView view = new MatrixView();
                MatrixModel model = new MatrixModel();
                MatrixController controller = new MatrixController(view, model);
            }
        });
    }
}
