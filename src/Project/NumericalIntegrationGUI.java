package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Function;

public class NumericalIntegrationGUI extends JFrame {

    JComboBox<String> methodBox, functionBox;
    JTextField aField, bField, nField;
    JTextArea output;

    public NumericalIntegrationGUI() {
        setTitle("Numerical Integration Calculator");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- TOP PANEL ----------
        JPanel top = new JPanel(new GridLayout(6, 2, 10, 10));

        top.add(new JLabel("Select Method:"));
        methodBox = new JComboBox<>(new String[]{
                "Trapezoidal Rule",
                "Simpson 1/3 Rule",
                "Simpson 3/8 Rule"
        });
        top.add(methodBox);

        top.add(new JLabel("Select Function:"));
        functionBox = new JComboBox<>(new String[]{
                "sin(x)",
                "1 / (1 + x^2)",
                "x / (1 + x^2)",
                "x^2",
                "e^x"
        });
        top.add(functionBox);

        top.add(new JLabel("Lower Limit a:"));
        aField = new JTextField();
        top.add(aField);

        top.add(new JLabel("Upper Limit b:"));
        bField = new JTextField();
        top.add(bField);

        top.add(new JLabel("Number of Intervals n:"));
        nField = new JTextField();
        top.add(nField);

        JButton computeBtn = new JButton("Compute");
        top.add(computeBtn);

        add(top, BorderLayout.NORTH);

        // ---------- OUTPUT AREA ----------
        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(output);
        add(scroll, BorderLayout.CENTER);

        // ---------- ACTION ----------
        computeBtn.addActionListener(e -> compute());
    }

    // --------------------------- FUNCTION LIBRARY ---------------------------
    Function<Double, Double> getFunction(int choice) {
        switch (choice) {
            case 0: return Math::sin;
            case 1: return x -> 1.0 / (1.0 + x * x);
            case 2: return x -> x / (1.0 + x * x);
            case 3: return x -> x * x;
            case 4: return Math::exp;
        }
        return null;
    }

    // --------------------------- TRAPEZOIDAL ---------------------------
    double trapezoidal(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("h = ").append(h).append("\n");

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double y = f.apply(x);
            sum += y;
            sb.append(String.format("X%-2d = %-10.5f  Y = %f\n", i, x, y));
        }

        double res = (h / 2.0) * (f.apply(a) + f.apply(b) + 2 * sum);
        output.append(sb.toString());
        return res;
    }

    // --------------------------- SIMPSON 1/3 ---------------------------
    double simpson13(Function<Double, Double> f, double a, double b, int n) {
        if (n % 2 != 0) {
            output.append("ERROR: n must be EVEN for Simpson 1/3 rule!\n");
            return Double.NaN;
        }

        double h = (b - a) / n;
        double odd = 0, even = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("h = ").append(h).append("\n");

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double y = f.apply(x);
            if (i % 2 == 0) even += y; else odd += y;
            sb.append(String.format("X%-2d = %-10.5f  Y = %f\n", i, x, y));
        }

        double res = (h / 3.0) * (f.apply(a) + f.apply(b) + 4 * odd + 2 * even);
        output.append(sb.toString());
        return res;
    }

    // --------------------------- SIMPSON 3/8 ---------------------------
    double simpson38(Function<Double, Double> f, double a, double b, int n) {
        if (n % 3 != 0) {
            output.append("ERROR: n must be a multiple of 3 for Simpson 3/8 rule!\n");
            return Double.NaN;
        }

        double h = (b - a) / n;
        double sum3 = 0, sumRest = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("h = ").append(h).append("\n");

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double y = f.apply(x);

            if (i % 3 == 0) sum3 += y;
            else sumRest += y;

            sb.append(String.format("X%-2d = %-10.5f  Y = %f\n", i, x, y));
        }

        double res = (3 * h / 8.0) * (f.apply(a) + f.apply(b) + 3 * sumRest + 2 * sum3);
        output.append(sb.toString());
        return res;
    }

    // --------------------------- COMPUTE BUTTON HANDLER ---------------------------
    void compute() {
        output.setText("");

        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            int n = Integer.parseInt(nField.getText());

            Function<Double, Double> f = getFunction(functionBox.getSelectedIndex());
            int method = methodBox.getSelectedIndex();

            double ans = 0;

            switch (method) {
                case 0: ans = trapezoidal(f, a, b, n); break;
                case 1: ans = simpson13(f, a, b, n); break;
                case 2: ans = simpson38(f, a, b, n); break;
            }

            output.append("\n------------------------------------\n");
            output.append("RESULT = " + ans + "\n");

        } catch (Exception e) {
            output.append("Invalid Input!\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumericalIntegrationGUI().setVisible(true));
    }
}

