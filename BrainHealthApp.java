import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrainHealthApp {

    // Components
    private JFrame frame;
    private JTextField userIdField;
    private JComboBox<String> testTypeComboBox;
    private JTextField testScoreField;

    private JTextField timeTakenField;
    private JTextArea outputArea;

    public BrainHealthApp() {
        // Set up the frame
        frame = new JFrame("Brain Health App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Adjust the frame size as needed
        frame.setLayout(new BorderLayout());

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false); // Make panel transparent

        // Create input fields
        userIdField = new JTextField(15);

        // Create test type dropdown
        String[] testTypes = {"Memory Test", "Attention Test", "Cognitive Flexibility Test"};
        testTypeComboBox = new JComboBox<>(testTypes);

        testScoreField = new JTextField(15);
        timeTakenField = new JTextField(15);

        // Create output area
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        // Create a submit button
        JButton submitButton = new JButton("Submit Test Result");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from fields
                String userId = userIdField.getText();
                String testType = (String) testTypeComboBox.getSelectedItem();
                String testScore = testScoreField.getText();
                String timeTaken = timeTakenField.getText();

                // Display the results in the output area
                outputArea.setText("User ID: " + userId + "\n"
                        + "Test Type: " + testType + "\n"
                        + "Test Score: " + testScore + "\n"
                        + "Time Taken: " + timeTaken + " seconds\n"
                        + "Advice: " + getAdvice(testType));
            }
        });

        // Add components to content panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 5, 10); // Padding
        contentPanel.add(new JLabel("Brain Health Monitoring and Analysis"), gbc);

        gbc.gridy = 1;
        contentPanel.add(new JLabel("How can I help you?"), gbc);

        gbc.gridy = 2;
        contentPanel.add(new JLabel("User ID:"), gbc);
        gbc.gridx = 1;
        contentPanel.add(userIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(new JLabel("Test Type:"), gbc);
        gbc.gridx = 1;
        contentPanel.add(testTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(new JLabel("Test Score:"), gbc);
        gbc.gridx = 1;
        contentPanel.add(testScoreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPanel.add(new JLabel("Time Taken (s):"), gbc);
        gbc.gridx = 1;
        contentPanel.add(timeTakenField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Make button span two columns
        contentPanel.add(submitButton, gbc);

        gbc.gridy = 7;
        contentPanel.add(new JScrollPane(outputArea), gbc); // Add output area below inputs

        // Set background image
        ImageIcon backgroundImage = new ImageIcon("C:/Users/oviya/Desktop/shyam.jpg"); // Use the correct path
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImg); // Set the scaled image

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.add(contentPanel, BorderLayout.CENTER);
        frame.setContentPane(backgroundLabel);

        // Set the frame visible
        frame.setVisible(true);
    }

    private String getAdvice(String testType) {
        switch (testType) {
            case "Memory Test":
                return "Try to engage in memory exercises such as puzzles and memory games.";
            case "Attention Test":
                return "Practice mindfulness techniques to improve your attention span.";
            case "Cognitive Flexibility Test":
                return "Engage in activities that require you to switch tasks frequently.";
            default:
                return "No advice available.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BrainHealthApp());
    }
}
