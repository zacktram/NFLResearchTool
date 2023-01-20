import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class MainPanel extends JPanel
{
    JLabel offenseLabel;
    JLabel defenseLabel;
    JLabel searchLabel;
    JLabel playerSearchLabel;
    JLabel rosterSearchLabel;
    
    JButton passLeadButton;
    JButton rushLeadButton;
    JButton recLeadButton;
    
    JButton teamDefButton;
    JButton passDefButton;
    JButton rushDefButton;
    
    JButton playerNameButton;
    JButton teamNameButton;
    
    JTextField playerSearchText;
    JTextField rosterSearchText;
    
    JPanel offensePanel;
    JPanel defensePanel;
    JPanel playerSearchPanel;
    JPanel rosterSearchPanel;
    JPanel playerSearchTextPanel;
    JPanel rosterSearchTextPanel;
    public MainPanel()
    {
        // Adds Offenive Leaders Buttons
        offensePanel = new JPanel();
        
        offenseLabel = new JLabel("Offensive Leaders", SwingConstants.CENTER);
        
        passLeadButton = new JButton("Passing Leaders");
        rushLeadButton = new JButton("Rushing Leaders");
        recLeadButton = new JButton("Receiving Leaders");
        
        offensePanel.setLayout(new GridLayout(4, 1));
        offensePanel.add(offenseLabel);
        offensePanel.add(passLeadButton);
        offensePanel.add(rushLeadButton);
        offensePanel.add(recLeadButton);
        
        add(offensePanel);
        
        // Adds Defensive Leaders Buttons
        defensePanel = new JPanel();
        
        defenseLabel = new JLabel("Defensive Leaders", SwingConstants.CENTER);
        
        teamDefButton = new JButton("Team Defense Leaders");
        passDefButton = new JButton("Pass Defense Leaders");
        rushDefButton = new JButton("Rush Defense Leaders");
        
        defensePanel.setLayout(new GridLayout(4, 1));
        defensePanel.add(defenseLabel);
        defensePanel.add(teamDefButton);
        defensePanel.add(passDefButton);
        defensePanel.add(rushDefButton);
        
        add(defensePanel);
        
        // Adds Search Tools Text Panel
        playerSearchTextPanel = new JPanel();
        playerSearchTextPanel.setLayout(new GridLayout(2, 1));
        searchLabel = new JLabel("Search Tools", SwingConstants.CENTER);
        playerSearchTextPanel.add(searchLabel);
        playerSearchLabel = new JLabel("Enter the desired player's full name", SwingConstants.CENTER);
        playerSearchTextPanel.add(playerSearchLabel);
        add(playerSearchTextPanel);
        
        // Adds Search Player Stats Button/Text Area
        playerSearchPanel = new JPanel();
        playerSearchPanel.setLayout(new GridLayout(1, 2, 10, 0));
        playerNameButton = new JButton("Search Player Stats");
        playerSearchText = new JTextField(10);
        playerSearchPanel.add(playerNameButton);
        playerSearchPanel.add(playerSearchText);
        
        add(playerSearchPanel);
        
        // Adds rosterSearchTextPanel
        rosterSearchTextPanel = new JPanel();
        rosterSearchLabel = new JLabel("Enter the team's abbreviation", SwingConstants.CENTER);
        rosterSearchTextPanel.add(rosterSearchLabel);
        add(rosterSearchTextPanel);
        
        
        // Adds Roster Search Button/Text Area
        rosterSearchPanel = new JPanel();
        rosterSearchPanel.setLayout(new GridLayout(1, 2, 10, 0));
        teamNameButton = new JButton("Search Team Roster");
        rosterSearchText = new JTextField(10);
        rosterSearchPanel.add(teamNameButton);
        rosterSearchPanel.add(rosterSearchText);
        
        add(rosterSearchPanel);
 
        
        // Adds Event Handler
        passLeadButton.addActionListener(new buttonListener());
        rushLeadButton.addActionListener(new buttonListener());
        recLeadButton.addActionListener(new buttonListener());
        
        teamDefButton.addActionListener(new buttonListener());
        passDefButton.addActionListener(new buttonListener());
        rushDefButton.addActionListener(new buttonListener());
        
        playerNameButton.addActionListener(new buttonListener());
        teamNameButton.addActionListener(new buttonListener());
        
        this.setPreferredSize(new Dimension(300, 300));
        this.setVisible(true);
    }
    
    
     private class buttonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == passLeadButton)
            {
                GetMethods.getPassLeaders();
            }
            else if(e.getSource() == rushLeadButton)
            {
                GetMethods.getRushLeaders();
            }
            else if(e.getSource() == recLeadButton)
            {
                GetMethods.getRecLeaders();
            }
            else if(e.getSource() == teamDefButton)
            {
                GetMethods.getTeamDefense();
            }
            else if(e.getSource() == passDefButton)
            {
                GetMethods.getPassDefense();
            }
            else if(e.getSource() == rushDefButton)
            {
                GetMethods.getRushDefense();
            }
            else if(e.getSource() == playerNameButton)
            {
                String playerName = playerSearchText.getText();
                SearchMethods.searchPlayerStats(playerName);
                playerSearchText.setText("");
            }
            else if(e.getSource() == teamNameButton)
            {
                String teamName = rosterSearchText.getText();
                SearchMethods.searchTeamRoster(teamName);
                rosterSearchText.setText("");
            }
        }
    }
}
