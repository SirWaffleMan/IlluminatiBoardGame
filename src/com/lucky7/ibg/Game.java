package com.lucky7.ibg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.lucky7.ibg.card.Card;
import com.lucky7.ibg.card.group.*;
import com.lucky7.ibg.card.illuminati.*;
import com.lucky7.ibg.card.special.*;
import com.lucky7.ibg.gui.GamePanel;
import com.lucky7.ibg.player.Player;

public class Game implements Runnable{
	
	Thread thread;
	
	JFrame frame;
	GamePanel gamePanel;
	JPanel actionPanel;
	JPanel topPanel;
	JPanel bottomPanel;
	JSplitPane actionSplitPane;
	JSplitPane bottomSplitPane;
	JSplitPane rightSplitPane;
	JScrollPane scrollPane;
	JTextArea gameLogger;
	
	JLabel currentPlayerLabel;
	JLabel cardSelectedLabel;
	JComboBox<GroupCard> cardSelectedList;
	JButton attackToControlButton;
	JButton attackToNeutralizeButton;
	JButton attackToDestroyButton;
	JButton transferMoneyButton;
	JButton moveGroupButton;
	JButton dropGroupButton;
	JButton transferPowerButton;
	
	JLabel viewLabel;
	JComboBox<Object> viewList;
	JButton illuminatiAbilityButton;
	JButton endTurnButton;
	
	ArrayList<Player> players;
	ArrayList<IlluminatiCard> illuminatiCards;
	ArrayList<Card> deck;
	ArrayList<Card> discardPile;
	
	@Override
	public void run() {
		// Game main process
		init();
		configureWindow();
		notifyStartup();
		loadCards();
		shufflePlayers();
		assignIlluminatiCards();
		setupWindow();
	}
	
	private void setupWindow() {
		// setup window for every player
		cardSelectedList.addItem(players.get(0).getControlledGroups().get(0));
	}

	private void assignIlluminatiCards() {
		
		// Assign random illuminati cards and add initial income
		
		Collections.shuffle(illuminatiCards);
		for(Player p : players) {
			IlluminatiCard card = illuminatiCards.remove(0);
			addLog(p.getName() + " was assigned \"" + card.getName() + "\"");
			p.addCardToPowerStructure(card);
		}
		
		addLog("Adding initial income to all players...");
		for(Player p : players) {
			p.addIncome();
		}
	}

	public static boolean checkValidGame(ArrayList<Player> players) {
		if(players.size() >= 2) {
			return true;
		}
		return false;
	}
	
	public void addPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Game() {
		thread = new Thread(this);
	}
	
	public void start() {
		thread.start();
	}
	
	void init() {
		// Initialize
		deck = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
		illuminatiCards = new ArrayList<IlluminatiCard>();
		frame = new JFrame("Illuminati - Lucky7");
		actionPanel = new JPanel();
		gamePanel = new GamePanel();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(900, 650));
		gameLogger = new JTextArea();
		gameLogger.setEditable(false);
		gameLogger.setLineWrap(true);
		scrollPane = new JScrollPane(gameLogger);
		actionSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		bottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gamePanel, scrollPane);
		rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomSplitPane, actionSplitPane);
		
		currentPlayerLabel = new JLabel();
		currentPlayerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		currentPlayerLabel.setForeground(Color.BLUE);
		cardSelectedLabel = new JLabel("Card Selected:");
		viewLabel = new JLabel("View:");
		cardSelectedList = new JComboBox<GroupCard>();
		viewList = new JComboBox<Object>();
		viewList.setMaximumSize(new Dimension(200, 30));
		attackToControlButton = new JButton("Attack to Control");
		attackToNeutralizeButton = new JButton("Attack to Neutralize");
		attackToDestroyButton = new JButton("Attack to Destroy");
		transferMoneyButton = new JButton("Transfer Money");
		moveGroupButton = new JButton("Move Group");
		dropGroupButton = new JButton("Drop Group");
		transferPowerButton = new JButton("Transfer Power");
		illuminatiAbilityButton = new JButton("Use Illuminati Ability");
		illuminatiAbilityButton.setMaximumSize(new Dimension(300,30));
		endTurnButton = new JButton("End Turn");
		endTurnButton.setMaximumSize(new Dimension(300,30));
		
		// Configure top panel
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(currentPlayerLabel);
		topPanel.add(cardSelectedLabel);
		topPanel.add(cardSelectedList);
		topPanel.add(attackToControlButton);
		topPanel.add(attackToNeutralizeButton);
		topPanel.add(attackToDestroyButton);
		topPanel.add(transferMoneyButton);
		topPanel.add(moveGroupButton);
		topPanel.add(dropGroupButton);
		topPanel.add(transferPowerButton);
		
		// Configure bottom panel
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.add(viewLabel);
		bottomPanel.add(viewList);
		bottomPanel.add(illuminatiAbilityButton);
		bottomPanel.add(endTurnButton);
		
		actionSplitPane.setDividerSize(6);
		bottomSplitPane.setDividerSize(6);
		rightSplitPane.setDividerSize(6);
	}
	
	int rollDice() {
		// Simulates the roll of two dice
		Random random = new Random();
		int dice1Value = random.nextInt(6) + 1;
		int dice2Value = random.nextInt(6) + 1;
		return dice1Value + dice2Value;
	}
	
	void configureWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(rightSplitPane);
		frame.setVisible(true);
		frame.pack();
		bottomSplitPane.setDividerLocation(0.8);
		rightSplitPane.setDividerLocation(0.78);
		actionSplitPane.setDividerLocation(0.5);
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
	}
	
	void addLog(String message) {
		// Add message
		gameLogger.append(message + "\n");
		// Scroll to bottom of log
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
	
	void notifyStartup() {
		addLog("Game starting...");
		for(int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			addLog(p.getName() + " has joined the game.");
		}
	}
	
	void shufflePlayers() {
		Collections.shuffle(players);
		// Display order of players in logger
		addLog("Turn order determined:");
		for(int i = 0; i < players.size(); i++) {
			addLog(String.valueOf(i + 1) + ". " + players.get(i));
		}
		currentPlayerLabel.setText(players.get(0).getName());
		
		for(Player p : players) {
			viewList.addItem(p.getName());
		}
		viewList.addItem("Uncontrolled Groups");
	}
	
	void loadCards() {
		// Illuminati Cards
		illuminatiCards.add(new TheDiscordianSociety());
		illuminatiCards.add(new TheNetwork());
		illuminatiCards.add(new TheSocietyOfAssassins());
		illuminatiCards.add(new TheUFOs());
		illuminatiCards.add(new TheServantsOfCthulhu());
		illuminatiCards.add(new TheGnomesOfZurich());
		illuminatiCards.add(new TheBavarianIlluminati());
		illuminatiCards.add(new TheBermudaTriangle());
		
		// Group Cards
		deck.add(new AmericanAutoduelAssociation());
		deck.add(new AntiNuclearActivists());
		deck.add(new CloneArrangers());
		// Ability Cards
		deck.add(new Assassination());
		deck.add(new Bribery());
		deck.add(new ComputerEspionage());
		deck.add(new DeepAgent());
		deck.add(new Interference());
		deck.add(new Interference());
		deck.add(new MarketManipulation());
		deck.add(new MediaBlitz());
		deck.add(new MurphysLaw());
		deck.add(new Ninjas());
		deck.add(new SecretsManWasNotMeantToKnow());
		deck.add(new SenateInvestigatingCommittee());
		deck.add(new SlushFund());
		deck.add(new SwissBankAccount());
		deck.add(new TimeWarp());
		deck.add(new WhiteCollarCrime());
	}

}
