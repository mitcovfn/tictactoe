package mfn.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fyodor on 02/09/2016.
 */
public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 510;
    private static final int WINDOW_HEIGHT = 555;
    private static final int PANEL_BOTTOM_ROWS = 1;
    private static final int PANEL_BOTTOM_COLS = 2;

    private final GameOptions start_new_game_window;
    private final PlayField playField;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - WINDOW_WIDTH) / 2;
        int y = (dim.height - WINDOW_HEIGHT) / 2;
        setLocation(x, y);
        setResizable(false);
        ImageIcon img = new ImageIcon("icon.gif");
        setIconImage(img.getImage());
        start_new_game_window = new GameOptions(this);
        JButton btn_new_game = new JButton("New Game");
        btn_new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start_new_game_window.setVisible(true);
            }
        });
        JButton btn_exit = new JButton("Exit");
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panel_bottom = new JPanel();
        panel_bottom.setLayout(new GridLayout(PANEL_BOTTOM_ROWS, PANEL_BOTTOM_COLS));
        panel_bottom.add(btn_new_game);
        panel_bottom.add(btn_exit);
        playField = new PlayField();
        add(playField, BorderLayout.CENTER);
        add(panel_bottom, BorderLayout.SOUTH);
        setVisible(true);
        start_new_game_window.setVisible(true);
    }

    void startNewGame(int mode, int field_size_x, int field_size_y, int win_len) {
        playField.startNewGame(mode, field_size_x, field_size_y, win_len);
    }
}
