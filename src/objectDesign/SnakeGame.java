package objectDesign;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;
    private final int UNIT_SIZE = 20; // Size of each grid unit
    private final int GAME_SPEED = 300; // Milliseconds per game tick

    private LinkedList<Point> snake;
    private Point food;
    private char direction = 'R'; // 'U', 'D', 'L', 'R'
    private boolean running = false;
    private Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initGame();
    }

    private void initGame() {
        snake = new LinkedList<>();
        snake.add(new Point(5 * UNIT_SIZE, 5 * UNIT_SIZE)); // Initial snake head
        spawnFood();
        running = true;
        timer = new Timer(GAME_SPEED, this);
        timer.start();
    }

    private void spawnFood() {
        int foodX = (int) (Math.random() * (BOARD_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        int foodY = (int) (Math.random() * (BOARD_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        food = new Point(foodX, foodY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Draw food
            g.setColor(Color.RED);
            g.fillOval(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

            // Draw snake
            for (Point segment : snake) {
                g.setColor(Color.GREEN);
                g.fillRect(segment.x, segment.y, UNIT_SIZE, UNIT_SIZE);
            }
        } else {
            // Game over screen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Game Over", (BOARD_WIDTH - metrics.stringWidth("Game Over")) / 2, BOARD_HEIGHT / 2);
        }
    }

    public void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case 'U': newHead.y -= UNIT_SIZE; break;
            case 'D': newHead.y += UNIT_SIZE; break;
            case 'L': newHead.x -= UNIT_SIZE; break;
            case 'R': newHead.x += UNIT_SIZE; break;
        }

        snake.addFirst(newHead);

        if (newHead.equals(food)) {
            spawnFood();
        } else {
            snake.removeLast();
        }
    }

    public void checkCollisions() {
        Point head = snake.getFirst();

        // Wall collision
        if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT) {
            running = false;
        }

        // Self-collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
            }
        }

        if (!running) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollisions();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: if (direction != 'R') direction = 'L'; break;
            case KeyEvent.VK_RIGHT: if (direction != 'L') direction = 'R'; break;
            case KeyEvent.VK_UP: if (direction != 'D') direction = 'U'; break;
            case KeyEvent.VK_DOWN: if (direction != 'U') direction = 'D'; break;
        }
    }

    // Other KeyListener methods (keyTyped, keyReleased) can be left empty
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}