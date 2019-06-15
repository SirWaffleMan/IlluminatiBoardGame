package com.lucky7.ibg;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.lucky7.ibg.card.Card;
import com.lucky7.ibg.card.group.*;
import com.lucky7.ibg.card.illuminati.*;
import com.lucky7.ibg.card.special.*;
import com.lucky7.ibg.gui.ActionPanel;
import com.lucky7.ibg.gui.GamePanel;
import com.lucky7.ibg.gui.GlobalActionPanel;
import com.lucky7.ibg.player.Player;

public class Game implements Runnable{
	
	Thread thread;
	
	JFrame frame;
	GamePanel gamePanel;
	JPanel topPanel;
	ActionPanel actionPanel;
	JPanel bottomPanel;
	GlobalActionPanel globalActionPanel;
	JSplitPane actionSplitPane;
	JSplitPane bottomSplitPane;
	JSplitPane rightSplitPane;
	JScrollPane scrollPane;
	JTextArea gameLogger;
	
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
		actionPanel.updatePlayer(players.get(0));
		globalActionPanel.addPlayerList(players);
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
		gamePanel = new GamePanel();
		topPanel = new JPanel();
		actionPanel = new ActionPanel();
		bottomPanel = new JPanel();
		globalActionPanel = new GlobalActionPanel();
		gamePanel.setPreferredSize(new Dimension(900, 650));
		gameLogger = new JTextArea();
		gameLogger.setEditable(false);
		gameLogger.setLineWrap(true);
		scrollPane = new JScrollPane(gameLogger);
		actionSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		bottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gamePanel, scrollPane);
		rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomSplitPane, actionSplitPane);
		
		// Configure top panel
		topPanel.add(actionPanel);
		
		// Configure bottom panel
		bottomPanel.add(globalActionPanel);
		
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
		deck.add(new Airlines());
		deck.add(new AmericanAutoduelAssociation());
		deck.add(new Antifa());
		deck.add(new AntiNuclearActivists());
		deck.add(new AntiWarActivists());
		deck.add(new ArmsSmugglers());
		deck.add(new BigMedia());
		deck.add(new BoySprouts());
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
