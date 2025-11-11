package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.function.DoubleUnaryOperator;

public class NumericalIntegrationWithPlot extends JFrame {

    private JComboBox<String> methodBox, functionBox;
    private JTextField aField, bField, nField;
    private JTextArea output;
    private PlotPanel plotPanel;

    public NumericalIntegrationWithPlot() {
        setTitle("Numerical Integration + Plot (Java2D)");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel controls = new JPanel(new GridBagLayout());
        controls.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        methodBox = new JComboBox<>(new String[] {
                "Trapezoidal Rule",
                "Simpson 1/3 Rule",
                "Simpson 3/8 Rule"
        });

        functionBox = new JComboBox<>(new String[] {
                "sin(x)",
                "cos(x)",
                "e^x",
                "ln(x+1)",
                "x^2",
                "x^3",
                "1/(1+x^2)",
                "x/(1+x^2)",
                "sqrt(x)",
                "|x|",
                "sin(x^2)",
                "cos(x^2)",
                "x^4",
                "x^5",
                "e^(-x^2)",
                "1/sqrt(1+x^2)",
                "atan(x)",
                "sinh(x)"
        });

        aField = new JTextField("0");
        bField = new JTextField("1");
        nField = new JTextField("100");

        c.gridx = 0; c.gridy = 0; controls.add(new JLabel("Method:"), c);
        c.gridx = 1; c.gridy = 0; controls.add(methodBox, c);
        c.gridx = 0; c.gridy = 1; controls.add(new JLabel("Function:"), c);
        c.gridx = 1; c.gridy = 1; controls.add(functionBox, c);
        c.gridx = 0; c.gridy = 2; controls.add(new JLabel("Lower a:"), c);
        c.gridx = 1; c.gridy = 2; controls.add(aField, c);
        c.gridx = 0; c.gridy = 3; controls.add(new JLabel("Upper b:"), c);
        c.gridx = 1; c.gridy = 3; controls.add(bField, c);
        c.gridx = 0; c.gridy = 4; controls.add(new JLabel("Intervals n:"), c);
        c.gridx = 1; c.gridy = 4; controls.add(nField, c);

        JButton computeBtn = new JButton("Compute & Plot");
        c.gridx = 0; c.gridy = 5; c.gridwidth = 2;
        controls.add(computeBtn, c);

        output = new JTextArea(6, 30);
        output.setFont(new Font("Monospaced", Font.PLAIN, 12));
        output.setEditable(false);
        JScrollPane outScroll = new JScrollPane(output);
        outScroll.setBorder(BorderFactory.createTitledBorder("Output"));

        JPanel left = new JPanel(new BorderLayout(8,8));
        left.add(controls, BorderLayout.NORTH);
        left.add(outScroll, BorderLayout.CENTER);

        plotPanel = new PlotPanel();
        plotPanel.setPreferredSize(new Dimension(600, 600));
        plotPanel.setBorder(BorderFactory.createTitledBorder("Function Plot"));

        add(left, BorderLayout.WEST);
        add(plotPanel, BorderLayout.CENTER);

        computeBtn.addActionListener(ev -> onCompute());

        setVisible(true);
    }

    private DoubleUnaryOperator getFunction(int idx) {
        return switch (idx) {
            case 0 -> Math::sin;
            case 1 -> Math::cos;
            case 2 -> Math::exp;
            case 3 -> x -> Math.log(x + 1.0);
            case 4 -> x -> x * x;
            case 5 -> x -> x * x * x;
            case 6 -> x -> 1.0 / (1.0 + x * x);
            case 7 -> x -> x / (1.0 + x * x);
            case 8 -> x -> Math.sqrt(Math.max(0, x));
            case 9 -> Math::abs;
            case 10 -> x -> Math.sin(x * x);
            case 11 -> x -> Math.cos(x * x);
            case 12 -> x -> x * x * x * x;
            case 13 -> x -> Math.pow(x, 5);
            case 14 -> x -> Math.exp(-x * x);
            case 15 -> x -> 1.0 / Math.sqrt(1 + x * x);
            case 16 -> Math::atan;
            case 17 -> Math::sinh;
            default -> x -> 0;
        };
    }

    private void onCompute() {
        output.setText("");
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            int n = Integer.parseInt(nField.getText());
            if (n <= 0) { output.setText("n must be positive"); return; }
            if (b == a) { output.setText("a and b must differ"); return; }

            int funcIdx = functionBox.getSelectedIndex();
            DoubleUnaryOperator f = getFunction(funcIdx);

            String method = (String)methodBox.getSelectedItem();
            double res;
            long start = System.nanoTime();

            if (method.equals("Trapezoidal Rule")) {
                res = trapezoidal(f, a, b, n);
            } else if (method.equals("Simpson 1/3 Rule")) {
                if (n % 2 != 0) { output.setText("n must be even for Simpson 1/3"); return; }
                res = simpson13(f, a, b, n);
            } else {
                if (n % 3 != 0) { output.setText("n must be multiple of 3 for Simpson 3/8"); return; }
                res = simpson38(f, a, b, n);
            }

            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            StringBuilder sb = new StringBuilder();
            sb.append("Method: ").append(method).append("\n");
            sb.append("Function: ").append(functionBox.getSelectedItem()).append("\n");
            sb.append(String.format("a = %.6f, b = %.6f, n = %d%n", a, b, n));
            sb.append(String.format("Result = %.12f%n", res));
            sb.append(String.format("Execution time: %.3f ms%n", ms));
            output.setText(sb.toString());

            // send data to plot
            plotPanel.setData(f, a, b, n, method);
            plotPanel.repaint();

        } catch (NumberFormatException ex) {
            output.setText("Invalid numeric input.");
        } catch (Exception ex) {
            output.setText("Error: " + ex.getMessage());
        }
    }

    // numerical methods
    private double trapezoidal(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.applyAsDouble(a) + f.applyAsDouble(b));
        for (int i = 1; i < n; i++) sum += f.applyAsDouble(a + i * h);
        return h * sum;
    }

    private double simpson13(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double s = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            s += (i % 2 == 0) ? 2 * f.applyAsDouble(x) : 4 * f.applyAsDouble(x);
        }
        return s * h / 3.0;
    }

    private double simpson38(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double s = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            s += (i % 3 == 0) ? 2 * f.applyAsDouble(x) : 3 * f.applyAsDouble(x);
        }
        return s * 3 * h / 8.0;
    }

    // ---------------- PLOTTING PANEL ----------------
    private static class PlotPanel extends JPanel {
        DoubleUnaryOperator f;
        double a, b;
        int n;
        String method;

        // viewport padding, samples etc
        private final int leftPad = 60, rightPad = 20, topPad = 20, bottomPad = 60;

        void setData(DoubleUnaryOperator f, double a, double b, int n, String method) {
            this.f = f; this.a = a; this.b = b; this.n = n; this.method = method;
        }

        @Override
        protected void paintComponent(Graphics g0) {
            super.paintComponent(g0);
            Graphics2D g = (Graphics2D) g0;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, w, h);

            if (f == null) {
                g.setColor(Color.DARK_GRAY);
                g.drawString("Compute something to see the plot", leftPad + 10, topPad + 20);
                return;
            }

            // sample the function to find y-range
            int samples = Math.max(200, getWidth());
            double minX = Math.min(a, b), maxX = Math.max(a, b);
            double paddingX = (maxX - minX) * 0.05;
            double plotMinX = minX - paddingX, plotMaxX = maxX + paddingX;

            double minY = Double.POSITIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY;
            double[] xs = new double[samples+1], ys = new double[samples+1];
            for (int i = 0; i <= samples; i++) {
                double x = plotMinX + i * (plotMaxX - plotMinX)/samples;
                double y;
                try { y = f.applyAsDouble(x); }
                catch (Exception ex) { y = Double.NaN; }
                xs[i] = x; ys[i] = y;
                if (!Double.isFinite(y)) continue;
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            if (!Double.isFinite(minY) || !Double.isFinite(maxY)) { minY = -1; maxY = 1; }
            if (maxY - minY < 1e-6) { maxY += 0.5; minY -= 0.5; }

            // mapping functions
            double xToPixel = (w - leftPad - rightPad) / (plotMaxX - plotMinX);
            double yToPixel = (h - topPad - bottomPad) / (maxY - minY);

            int ox = leftPad;
            int oy = topPad;

            // draw axes
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(ox, oy, w - leftPad - rightPad, h - topPad - bottomPad);

            g.setColor(Color.GRAY);
            // x ticks
            int xticks = 8;
            for (int i = 0; i <= xticks; i++) {
                double xv = plotMinX + i * (plotMaxX - plotMinX)/xticks;
                int px = ox + (int)Math.round((xv - plotMinX) * xToPixel);
                g.drawLine(px, oy, px, oy + h - topPad - bottomPad);
                String s = String.format("%.2f", xv);
                g.setColor(Color.DARK_GRAY);
                g.drawString(s, px - g.getFontMetrics().stringWidth(s)/2, oy + h - topPad - bottomPad + 18);
                g.setColor(Color.GRAY);
            }
            // y ticks
            int yticks = 6;
            for (int i = 0; i <= yticks; i++) {
                double yv = minY + i * (maxY - minY)/yticks;
                int py = oy + (int)Math.round((maxY - yv) * yToPixel);
                g.drawLine(ox, py, ox + w - leftPad - rightPad, py);
                String s = String.format("%.2f", yv);
                g.setColor(Color.DARK_GRAY);
                g.drawString(s, ox - g.getFontMetrics().stringWidth(s) - 6, py + 4);
                g.setColor(Color.GRAY);
            }

            // draw function curve
            Path2D curve = new Path2D.Double();
            boolean started = false;
            for (int i = 0; i <= samples; i++) {
                double y = ys[i];
                if (!Double.isFinite(y)) { started = false; continue; }
                int px = ox + (int)Math.round((xs[i] - plotMinX) * xToPixel);
                int py = oy + (int)Math.round((maxY - y) * yToPixel);
                if (!started) { curve.moveTo(px, py); started = true; }
                else curve.lineTo(px, py);
            }
            g.setStroke(new BasicStroke(2f));
            g.setColor(new Color(24, 120, 240));
            g.draw(curve);

            // shade area between a and b under the curve
            double left = Math.min(a, b), right = Math.max(a, b);
            int steps = Math.max(60, n * 4);
            Polygon poly = new Polygon();
            for (int i = 0; i <= steps; i++) {
                double x = left + i * (right - left)/steps;
                double y = f.applyAsDouble(x);
                if (!Double.isFinite(y)) y = 0;
                int px = ox + (int)Math.round((x - plotMinX) * xToPixel);
                int py = oy + (int)Math.round((maxY - y) * yToPixel);
                poly.addPoint(px, py);
            }
            // baseline points
            int bx1 = ox + (int)Math.round((right - plotMinX) * xToPixel);
            int by1 = oy + (int)Math.round((maxY - 0) * yToPixel);
            int bx0 = ox + (int)Math.round((left - plotMinX) * xToPixel);
            int by0 = oy + (int)Math.round((maxY - 0) * yToPixel);
            poly.addPoint(bx1, by1);
            poly.addPoint(bx0, by0);

            g.setColor(new Color(24, 120, 240, 45));
            g.fillPolygon(poly);

            // draw vertical lines at partition points used by method
            g.setColor(new Color(180, 0, 0, 160));
            g.setStroke(new BasicStroke(1f));
            for (int i = 0; i <= n; i++) {
                double x = left + i * (right - left)/n;
                int px = ox + (int)Math.round((x - plotMinX) * xToPixel);
                g.drawLine(px, oy, px, oy + h - topPad - bottomPad);
            }

            // draw labels
            g.setColor(Color.BLACK);
            g.drawString("x", w - rightPad - 10, oy + h - topPad - bottomPad + 35);
            g.drawString("f(x)", ox - 40, topPad + 12);

            // draw a & b markers
            g.setColor(Color.MAGENTA.darker());
            int pa = ox + (int)Math.round((a - plotMinX) * xToPixel);
            int pb = ox + (int)Math.round((b - plotMinX) * xToPixel);
            g.drawLine(pa, oy + h - topPad - bottomPad + 2, pa, oy + h - topPad - bottomPad + 10);
            g.drawString("a", pa - 6, oy + h - topPad - bottomPad + 26);
            g.drawLine(pb, oy + h - topPad - bottomPad + 2, pb, oy + h - topPad - bottomPad + 10);
            g.drawString("b", pb - 6, oy + h - topPad - bottomPad + 26);

            // title of method
            g.setColor(Color.DARK_GRAY);
            g.drawString(method + " (n=" + n + ")", ox + 6, topPad + 12);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumericalIntegrationWithPlot::new);
    }
}
