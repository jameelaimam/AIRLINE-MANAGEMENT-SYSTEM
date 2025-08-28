import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
    JButton payButton, cancelButton;
    JLabel amountLabel;
    JTextField cardNumberField, cvvField;
    String bookingQuery; // The query to execute after payment
    Runnable onSuccess; // Callback on success

    public Payment(String amount, Runnable onSuccess) {
        this.onSuccess = onSuccess;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Payment");
        heading.setBounds(150, 20, 200, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 28));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(50, 80, 80, 25);
        add(lblAmount);

        amountLabel = new JLabel(amount);
        amountLabel.setBounds(130, 80, 150, 25);
        add(amountLabel);

        JLabel lblCard = new JLabel("Card Number:");
        lblCard.setBounds(50, 130, 100, 25);
        add(lblCard);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(160, 130, 150, 25);
        add(cardNumberField);

        JLabel lblCvv = new JLabel("CVV:");
        lblCvv.setBounds(50, 180, 80, 25);
        add(lblCvv);

        cvvField = new JTextField();
        cvvField.setBounds(130, 180, 60, 25);
        add(cvvField);

        payButton = new JButton("Pay");
        payButton.setBounds(50, 240, 100, 30);
        payButton.addActionListener(this);
        add(payButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 240, 100, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == payButton) {
            String card = cardNumberField.getText();
            String cvv = cvvField.getText();

            if (card.length() < 12 || cvv.length() < 3) {
                JOptionPane.showMessageDialog(this, "Invalid card details!");
                return;
            }
            JOptionPane.showMessageDialog(this, "Payment successful!");
            setVisible(false);
            if (onSuccess != null) {
                onSuccess.run();
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }
}