import javax.swing.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-30
 * Time: 15:49
 * Project: Four-in-a-row
 * Copyright: MIT
 */
public class GameGUI extends JFrame {

    JFrame frame = new JFrame();

    JPanel gameGrid = new JPanel();

    public JLabel scoreLabel = new JLabel();
    public JLabel infoLabel = new JLabel();
    public JLabel p1ScoreCounter = new JLabel();
    public JLabel p2ScoreCounter = new JLabel();

    public JButton showRulesButton = new JButton();
    public JButton p1ColorButtongroup = new JButton();
    public JButton p2ColorButtongroup = new JButton();

    public JRadioButton p1Color1 = new JRadioButton();
    public JRadioButton p1Color2 = new JRadioButton();
    public JRadioButton p1Color3 = new JRadioButton();
    public JRadioButton p1Color4 = new JRadioButton();
    public JRadioButton p2Color1 = new JRadioButton();
    public JRadioButton p2Color2 = new JRadioButton();
    public JRadioButton p2Color3 = new JRadioButton();
    public JRadioButton p2Color4 = new JRadioButton();


    public GameGUI (){







    }

    public void refreshGameGrid (){

    }

}
