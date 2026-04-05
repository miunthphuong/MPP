import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookWindow extends JFrame {
    private JTextField txtIsbn = new JTextField(20);
    private JTextField txtTitle = new JTextField(20);
    private JTextField txtPrice = new JTextField(20);
    private JButton btnSubmit = new JButton("Add Book to Inventory");

    // UI Colors
    private static final Color COLOR_BG = new Color(245, 245, 245);
    private static final Color COLOR_PRIMARY = new Color(0, 102, 204);

    public BookWindow() {
        setTitle("Book Entry Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with Padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(new EmptyBorder(25, 25, 25, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Header Title
        JLabel lblHeader = new JLabel("Add New Book");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 10, 20, 10);
        mainPanel.add(lblHeader, gbc);

        // Reset gridwidth for labels and fields
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);

        // --- ISBN Row ---
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtIsbn, gbc);

        // --- Title Row ---
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTitle, gbc);

        // --- Price Row ---
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPrice, gbc);

        // --- Submit Button ---
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 13));
        btnSubmit.setForeground(Color.BLUE);
        btnSubmit.setBackground(COLOR_PRIMARY);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setPreferredSize(new Dimension(0, 40));

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 0, 10);
        mainPanel.add(btnSubmit, gbc);

        // Button Action
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitData();
            }
        });

        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center on screen
    }

    // GETTERS for RuleSet to access
    public String getIsbnValue() { return txtIsbn.getText(); }
    public String getTitleValue() { return txtTitle.getText(); }
    public String getPriceValue() { return txtPrice.getText(); }

    private void submitData() {
        try {
            // Get RuleSet from Factory
            RuleSet rules = RuleSetFactory.getRuleSet(this);

            // Apply validation rules
            rules.applyRules(this);

            // If success
            JOptionPane.showMessageDialog(this,
                    "Book successfully validated and added!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (RuleException ex) {
            // Show error from RuleSet
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        EventQueue.invokeLater(() -> {
            new BookWindow().setVisible(true);
        });
    }
}