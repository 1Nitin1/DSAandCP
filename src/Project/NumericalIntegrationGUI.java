package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.DoubleUnaryOperator;

public class NumericalIntegrationGUI extends JFrame {

    private JComboBox<String> methodBox, functionBox;
    private JTextField aField, bField, nField;
    private JTextArea output;

    public NumericalIntegrationGUI() {
        setTitle("Numerical Integration Solver");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------------- TOP PANEL ----------------
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(5, 2, 10, 10));
        top.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Method Dropdown
        top.add(new JLabel("Select Method:", JLabel.RIGHT));
        methodBox = new JComboBox<>(new String[]{
                "Trapezoidal Rule",
                "Simpson 1/3 Rule",
                "Simpson 3/8 Rule"
        });
        top.add(methodBox);

        // Function Dropdown
        top.add(new JLabel("Select Function:", JLabel.RIGHT));
        functionBox = new JComboBox<>(new String[]{
                "sin(x)",
                "cos(x)",
                "e^x",
                "ln(x+1)",
                "x^2",
                "x^3",
                "1/(1 + x^2)",
                "x/(1 + x^2)"
        });
        top.add(functionBox);

        // a input
        top.add(new JLabel("Lower Limit (a):", JLabel.RIGHT));
        aField = new JTextField("0");
        top.add(aField);

        // b input
        top.add(new JLabel("Upper Limit (b):", JLabel.RIGHT));
        bField = new JTextField("1");
        top.add(bField);

        // n input
        top.add(new JLabel("Number of Intervals (n):", JLabel.RIGHT));
        nField = new JTextField("10");
        top.add(nField);

        add(top, BorderLayout.NORTH);

        // ---------------- OUTPUT AREA ----------------
        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(output);
        scroll.setBorder(BorderFactory.createTitledBorder("Result"));
        add(scroll, BorderLayout.CENTER);

        // ---------------- SOLVE BUTTON ----------------
        JButton solve = new JButton("Compute");
        solve.setFont(new Font("Arial", Font.BOLD, 18));
        solve.addActionListener(e -> solveIntegration());
        add(solve, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ---------------- GET FUNCTION ----------------
    public DoubleUnaryOperator getFunction(int choice) {
        return switch (choice) {
            case 0 -> Math::sin;
            case 1 -> Math::cos;
            case 2 -> Math::exp;
            case 3 -> (x -> Math.log(x + 1));
            case 4 -> (x -> x * x);
            case 5 -> (x -> x * x * x);
            case 6 -> (x -> 1.0 / (1.0 + x * x));
            case 7 -> (x -> x / (1.0 + x * x));
            default -> (x -> 0);
        };
    }

    // ---------------- SOLVE NUMERICAL INTEGRATION ----------------
    private void solveIntegration() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            int n = Integer.parseInt(nField.getText());

            DoubleUnaryOperator f = getFunction(functionBox.getSelectedIndex());

            String method = (String) methodBox.getSelectedItem();
            double result = 0;

            if (method.equals("Trapezoidal Rule")) {
                result = trapezoidal(f, a, b, n);
            } else if (method.equals("Simpson 1/3 Rule")) {
                if (n % 2 != 0) {
                    output.setText("ERROR: n must be EVEN for Simpson 1/3");
                    return;
                }
                result = simpson13(f, a, b, n);
            } else {
                if (n % 3 != 0) {
                    output.setText("ERROR: n must be MULTIPLE OF 3 for Simpson 3/8");
                    return;
                }
                result = simpson38(f, a, b, n);
            }

            output.setText("Method: " + method +
                    "\nFunction: " + functionBox.getSelectedItem() +
                    "\n\nResult = " + result);

        } catch (Exception ex) {
            output.setText("Invalid Input! Please enter numeric values.");
        }
    }

    // ---------------- METHODS ----------------

    double trapezoidal(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            sum += 2 * f.applyAsDouble(a + i * h);
        }
        return (h / 2) * sum;
    }

    double simpson13(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            sum += (i % 2 == 0 ? 2 : 4) * f.applyAsDouble(a + i * h);
        }
        return (h / 3) * sum;
    }

    double simpson38(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            sum += (i % 3 == 0 ? 2 : 3) * f.applyAsDouble(a + i * h);
        }
        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        new NumericalIntegrationGUI();
    }
}
