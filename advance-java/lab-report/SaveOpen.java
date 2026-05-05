import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class SaveOpen extends JFrame {
    private JTextArea textArea;
    private String currentFilePath = null;
    public SaveOpen() {
        setTitle("Save / Open Editor");
        setSize(600,400);
        setLocationRelativeTo(null);
        textArea = new JTextArea();
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e->openFile());
        fileMenu.add(openItem);
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e->saveFile());
        fileMenu.add(saveItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e->System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textArea.read(br, null);
                currentFilePath = file.getAbsolutePath();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void saveFile() {
     
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(currentFilePath));
                textArea.write(writer);
                writer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving this file.");
            }
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            SaveOpen editor = new SaveOpen();
            editor.setVisible(true);
        });
    }
}