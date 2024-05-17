/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author roshmelcreer
 */


public class DarkButton extends JButton {

    private boolean hover = false;

    public DarkButton() {
        setContentAreaFilled(false);
        setForeground(new Color(54, 117, 136)); // Text color
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setFont(new Font("Arial", Font.BOLD, 14)); // Font

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                setBackground(new Color(54, 117, 136)); // Button color on hover
                setForeground(Color.WHITE); // Text color on hover
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                setBackground(null); // Reset button color when not hovering
                setForeground(new Color(54, 117, 136)); // Reset text color when not hovering
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (hover) {
            // Button color on hover
            g2.setColor(new Color(54, 117, 136)); // (54, 117, 136)
        } else {
            // Default button color
            g2.setColor(Color.WHITE);
        }

        g2.fillRoundRect(0, 0, width, height, height, height);
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}
