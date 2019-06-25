package com.lucky7.ibg;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
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
import com.lucky7.ibg.gui.AttackWindow;
import com.lucky7.ibg.gui.TransferWindow;
import com.lucky7.ibg.gui.GamePanel;
import com.lucky7.ibg.gui.GlobalActionPanel;
import com.lucky7.ibg.input.GameInput;
import com.lucky7.ibg.player.Player;

public class Game implements Runnable{
	
	Thread thread;
	
	public JFrame frame;
	public GamePanel gamePanel;
	JPanel topPanel;
	public ActionPanel actionPanel;
	JPanel bottomPanel;
	public GlobalActionPanel globalActionPanel;
	JSplitPane actionSplitPane;
	JSplitPane bottomSplitPane;
	JSplitPane rightSplitPane;
	JScrollPane scrollPane;
	JTextArea gameLogger;
	GameInput input;
	
	ArrayList<Player> players;
	int playerIndex = 0;
	ArrayList<IlluminatiCard> illuminatiCards;
	ArrayList<Card> deck;
	public ArrayList<GroupCard> uncontrolled;
	ArrayList<Card> discardPile;
	
	@Override
	public void run() {
		// Game prep
		init();
		configureWindow();
		notifyStartup();
		loadCards();
		shufflePlayers();
		assignIlluminatiCards();
		setupWindow();
		shuffleDeck();
		
		// Main game process
		populateMinimumUncontrolled();
		
	}
	
	private void setupWindow() {
		actionPanel.updatePlayer(players.get(0));
		globalActionPanel.addPlayerList(players);
	}
	
	void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void attackToControl() {
		new AttackWindow(this);
	}
	
	public void attackToNeutralize() {
		new AttackWindow(this);
	}
	
	public void attackToDestory() {
		new AttackWindow(this);
	}
	
	public void transferMoney() {
		new TransferWindow(this);
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
		input = new GameInput(this);
		deck = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
		uncontrolled = new ArrayList<GroupCard>();
		illuminatiCards = new ArrayList<IlluminatiCard>();
		frame = new JFrame("Illuminati - Lucky7");
		frame.setIconImage(new ImageIcon("res/illuminati_icon.png").getImage());
		gamePanel = new GamePanel(this);
		topPanel = new JPanel();
		actionPanel = new ActionPanel(input);
		bottomPanel = new JPanel();
		globalActionPanel = new GlobalActionPanel(input);
		gamePanel.setPreferredSize(new Dimension(900, 650));
		gameLogger = new JTextArea();
		gameLogger.setEditable(false);
		gameLogger.setLineWrap(true);
		scrollPane = new JScrollPane(gameLogger);
		actionSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		bottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gamePanel, scrollPane);
		rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomSplitPane, actionSplitPane);
		
		// Configure Logger
		gameLogger.setBackground(new Color(60,60,60));
		gameLogger.setForeground(Color.WHITE);
		
		// Configure top panel
		topPanel.add(actionPanel);
		topPanel.setBackground(new Color(60,60,60));
		
		// Configure bottom panel
		bottomPanel.add(globalActionPanel);
		bottomPanel.setBackground(new Color(60,60,60));
		
		actionSplitPane.setDividerSize(2);
		bottomSplitPane.setDividerSize(2);
		rightSplitPane.setDividerSize(2);
	}
	
	public void endTurn() {
		addLog(players.get(playerIndex).getName() + " finished his turn.");
		playerIndex = (playerIndex + 1) % players.size();
		readyNextPlayer();
	}
	
	public void resign() {
		addLog(players.get(playerIndex).getName() + " has resigned!");
		players.remove(playerIndex);
		readyNextPlayer();
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
		actionSplitPane.setDividerLocation(0.55);
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
	
	void populateMinimumUncontrolled() {
		while(uncontrolled.size() < 4) {
			Card card = deck.remove(0);
			if(card instanceof GroupCard) {
				addLog("Added \"" + card.getName() + "\" to uncontrolled groups.");
				uncontrolled.add((GroupCard)card);
			}else {
				deck.add(card);
			}
		}
	}
	
	void readyNextPlayer() {
		actionPanel.updatePlayer(players.get(playerIndex));
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
		deck.add(new AlienAbductors());
		deck.add(new AmericanAutoduelAssociation());
		deck.add(new Antifa());
		deck.add(new AntiNuclearActivists());
		deck.add(new AntiWarActivists());
		deck.add(new ArmsSmugglers());
		deck.add(new BigMedia());
		deck.add(new Bloggers());
		deck.add(new BoySprouts());
		deck.add(new CableCompanies());
		deck.add(new California());
		deck.add(new ChainLetters());
		deck.add(new CIA());
		deck.add(new CloneArrangers());
		deck.add(new CoffeeShops());
		deck.add(new CongressionalWives());
		deck.add(new ConvenienceStores());
		deck.add(new Cosplayers());
		deck.add(new CycleGangs());
		deck.add(new Democrats());
		deck.add(new EcoGuerrillas());
		deck.add(new EvilGeniusesForABetterTomorrow());
		deck.add(new FastFoodChains());
		deck.add(new FBI());
		deck.add(new FederalReserve());
		deck.add(new FEMA());
		deck.add(new FiendishFluidators());
		deck.add(new FlatEarthers());
		deck.add(new FnordMotorCompany());
		deck.add(new FraternalOrders());
		deck.add(new GoldfishFanciers());

		
		
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
