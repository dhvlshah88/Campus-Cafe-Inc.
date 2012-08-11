/**
 * 
 */
package smartVendingMachine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author ADS Team
 * 
 */

public class VendingMachine extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JPanel scuLogoPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel foodItemsPanel = new JPanel();
	JPanel collectItnPanel = new JPanel();
	JPanel changePanel = new JPanel();
	JPanel menuPanel = new JPanel();
	JPanel itemImage = new JPanel();
	JScrollPane scrollPanel = new JScrollPane(foodItemsPanel);
	JButton[] foodItemBtn;
	BufferedImage horizontalPic;
	JLabel horizontalPicLabel;

	// This are item details area components
	JPanel subRightPanel1 = new JPanel();
	JPanel payCashPanel = new JPanel();
	JLabel selectedItemsLabel = new JLabel(
			"<html><u>LIST OF SELECTED ITEMS</u></html>"); // changes
	JLabel displayItemsLabel = new JLabel("---------------------");
	JLabel totalAmtLabel = new JLabel("<html><em>TOTAL AMOUNT: </em></html>"); // changes
	JLabel displayAmtLabel = new JLabel("$ 0.0");
	JLabel totalQtyLabel = new JLabel("<html><em>TOTAL ITEMS: </em></html>"); // changes
	JLabel displayTotalQty = new JLabel("0");
	JLabel cashLabel = new JLabel("<html><u>PAY BY CASH</u></html>");
	JLabel cardLabel = new JLabel("<html><u>PAY BY CARD</u></html>");
	JLabel amtEntered = new JLabel("Enter Cash :");
	JTextField enterAmtText = new JTextField("0.0");
	JLabel changeLabel = new JLabel("CHANGE"); // changes
	JLabel displayChangeLabel = new JLabel("$ 0.0");
	JButton pBCashButton = new JButton("Pay");
	JButton buyFoodButton = new JButton("Buy Food");
	JButton orderFoodButton = new JButton("Order food");
	JButton clearOrderButton = new JButton("Clear Order");
	
	// This are map area components.
	JPanel centerPanel = new JPanel();
	JPanel mapPanel = new JPanel();
	JPanel mapPanel1 = new JPanel();
	JPanel mapPanel2 = new JPanel();
	JPanel mapPanel3 = new JPanel();
	JPanel mapPanel4 = new JPanel();
	JPanel mapPanel5 = new JPanel();
	JPanel mapPanel6 = new JPanel();
	BufferedImage mapPic;
	JLabel mapPicLabel;
	JLabel blankLabel = new JLabel();

	// JPanel[] mapPanel = new JPanel[7];
	JPanel outletPanel = new JPanel();
	JPanel graphPanelD = new JPanel();
	JPanel graphPanelE = new JPanel();
	JButton vm1Button = new JButton("Vending M/C 1");
	JButton vm2Button = new JButton("Vending M/C 2");
	JButton vm3Button = new JButton("Vending M/C 3");
	JButton c1Button = new JButton("Cafe1");
	JButton c2Button = new JButton("Cafe2");
	JButton fsButton = new JButton("Food Store");

	// This are user details components.
	JPanel subRightPanel2 = new JPanel();
	JPanel userOptionsPanel = new JPanel();
	JPanel welcomePanel = new JPanel();
	JPanel setPrefPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JButton viewExpenseButton = new JButton("Expense Profile");
	JButton viewDietButton = new JButton("Dietary Profile");
	JButton setPrefButton = new JButton(" Set Preferences");
	JButton viewMapButton = new JButton("View Map");
	JLabel welcomeLabel = new JLabel("WELCOME TO SCU!");
	JLabel dCLabel = new JLabel("Daily Calories :");
	JTextField dCText = new JTextField(4);
	JLabel mFLabel = new JLabel("Monthly Funds :");
	JTextField mFText = new JTextField(4);
	JButton savePrefButton = new JButton("Set");
	JButton backButton = new JButton("Go Back");
	JLabel infoLabel = new JLabel(
			"Note: Maximum calories limit for male is 10000 and female is 7000. And maximum funds limit is to $2000 per person.");

	// This are login area components.
	JPanel loginPanel = new JPanel();
	JLabel cardNoLabel = new JLabel("CARD NUMBER");
	JLabel pinLabel = new JLabel("PIN");
	JLabel emptyLabel = new JLabel("");
	JTextField cardNoTxt = new JTextField(10);
	JPasswordField pinTxt = new JPasswordField(10);
	JButton loginButton = new JButton("LOGIN");
	JPanel logoutPanel = new JPanel();
	JButton logoutButton = new JButton("Logout");
	JLabel totCalLabel = new JLabel("TOTAL CALORIES");
	JLabel dispTotCalLabel = new JLabel("0");

	JLabel calLmtLabel = new JLabel("Daily Calories Limit: ");
	JLabel calSpntLabel = new JLabel("Calories spent: ");
	JLabel calRemLabel = new JLabel("Calories remaining: ");
	JLabel fundsLmtLabel = new JLabel("Funds Limit: ");
	JLabel fundsSpntLabel = new JLabel("Funds spent: ");
	JLabel fundsRemLabel = new JLabel("Balance funds: ");

	JLabel dispCalLmtLabel = new JLabel("0");
	JLabel dispCalSpntLabel = new JLabel("0");
	JLabel dispCalRemLabel = new JLabel("0 ");
	JLabel dispFundsLmtLabel = new JLabel("0.0");
	JLabel dispFundsSpntLabel = new JLabel("0.0");
	JLabel dispFundsRemLabel = new JLabel("0.0");

	JPanel dietDetailsPanel = new JPanel();
	JPanel fundsDetailsPanel = new JPanel();

	// This are the instance of BarChart for dietory and expenses profile.
	private BarChart dietChart = new BarChart();
	private BarChart expenseChart = new BarChart();

	Border loweredbevel = BorderFactory.createLoweredBevelBorder();

	private static SortedMap<String, FoodItems> purFoodItem = new TreeMap<String, FoodItems>();

	private static List<FoodItems> foodItemList = new ArrayList<FoodItems>();

	// This variable is used to store all campus card user details.
	private List<CampusCardUser> campusCardUsers = new ArrayList<CampusCardUser>();

	// This variable is used to store the instance of CampusCardUser which is
	// authenticated successfully.
	private static CampusCardUser authenticatedUser = new CampusCardUser();

	// This variable is used to store and add all the details of the food items
	// purchased by valid user.
	private static List<PurchasedDetails> userPurchasedDetails = new ArrayList<PurchasedDetails>();

	// This hashMap is used to store all the location of xml files.
	private Map<String, String> xmlMap = new HashMap<String, String>();

	private Map<String, Object> outletMap = new HashMap<String, Object>();

	// This is the instance of SerializeToXML which is use to deserialize the
	// XML.
	private SerializeToXML deSerializer = new SerializeToXML();

	// Ordered food item array
	private static List<FoodItems> foodOrdered = new ArrayList<FoodItems>();

	private static FoodOutlet selectedOutlet = new FoodOutlet();

	private static int authenticated = 0;
	private static int selItemId = 0;
	private static String selOutletId = "";
	private static int totalQty = 0;
	private static int totalOrderedQty = 0;
	private static double totalAmount = 0;
	private static int totalCalories = 0;
	private static String strOrderList = "";

	Calendar calender;
	Date dateTime;
	DateFormat dateFormatter, dayFormatter;
	DecimalFormat deciFormatter = new DecimalFormat("0.00");

	/**
	 * This constant variables:
	 * 
	 * that stores maximum calories and funds that should be consumed daily for
	 * men and women.
	 * 
	 * that stores days name.
	 */
	final int MAXM_DAILY_CALORIES = 10000;
	final int MAXF_DAILY_CALORIES = 7000;
	final double MAX_MONTHLY_FUNDS = 2000.00;
	final static String days[] = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
			"THURSDAY", "FRIDAY", "SATURDAY" };

	/**
     * 
     */
	public VendingMachine() {

		// Title of the main window Vending Machine.
		super("VENDING MACHINE 1");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.setBackground(Color.white);

		xmlMap.put("u", "src/data/users.xml");
		xmlMap.put("pd", "src/data/purchaseddetails.xml");
		xmlMap.put("vm1", "src/xml/VendingMachineMenu1.XML");
		xmlMap.put("vm2", "src/xml/VendingMachineMenu2.XML");
		xmlMap.put("vm3", "src/xml/VendingMachineMenu3.XML");
		xmlMap.put("fs1", "src/xml/FoodStoreMenu.xml");
		xmlMap.put("c1", "src/xml/CafeMenu1.xml");
		xmlMap.put("c2", "src/xml/CafeMenu2.xml");

		// SCU Logo Panel
		container.add(scuLogoPanel);
		scuLogoPanel.setPreferredSize(new Dimension(1355, 700));
		scuLogoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		scuLogoPanel.setBackground(Color.black);
		scuLogoPanel.setVisible(true);

		try {

			BufferedImage pic = ImageIO.read(new File(
					"src/images/welcomeImage.jpg"));
			JLabel piclabel = new JLabel(new ImageIcon(pic));
			piclabel.setPreferredSize(new Dimension(1000, 600));
			scuLogoPanel.add(piclabel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Image problems");
		}

		container.add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(1355, 700));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		mainPanel.setVisible(false);

		// Left Panel
		mainPanel.add(leftPanel);// ------------------------------------------------change
		leftPanel.setPreferredSize(new Dimension(480, 662));
		leftPanel.setBorder(BorderFactory.createTitledBorder("Food Items"));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		leftPanel.setBackground(Color.black);

		// Menu Panel
		mainPanel.add(menuPanel);
		menuPanel.setPreferredSize(new Dimension(480, 662));
		menuPanel.setLayout(new GridLayout(0, 1, 10, 10));
		menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		menuPanel.setBackground(Color.black);
		menuPanel.setVisible(false);

		// Right Panel
		mainPanel.add(rightPanel);// ------------------------------------------------change
		rightPanel.setPreferredSize(new Dimension(850, 662));
		rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		rightPanel.setBackground(new Color(128, 0, 0));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		/*
		 * // Left Panel container.add(leftPanel);
		 * leftPanel.setPreferredSize(new Dimension(480, 662));
		 * leftPanel.setBorder(BorderFactory.createTitledBorder("Food Items"));
		 * leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		 * leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		 * leftPanel.setBackground(Color.black); leftPanel.setVisible(true);
		 */

		// Right Panel
		/*
		 * container.add(rightPanel); rightPanel.setPreferredSize(new
		 * Dimension(850, 662)); rightPanel.setLayout(new
		 * FlowLayout(FlowLayout.LEFT, 0, 0)); rightPanel.setBackground(new
		 * Color(128, 0, 0));
		 * rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		 */

		// Vending Panel
		leftPanel.add(foodItemsPanel);
		foodItemsPanel.setLayout(new GridLayout(4, 5, 12, 12));
		foodItemsPanel.setPreferredSize(new Dimension(300, 500));
		foodItemsPanel.setBackground(Color.black);
		foodItemsPanel.setBorder(BorderFactory
				.createEmptyBorder(20, 10, 20, 10));

		foodItemList.clear();
		readXML(xmlMap.get("vm1"), foodItemList);

		SIHandler selectHandler = new SIHandler();
		for (int i = 0; i < foodItemBtn.length; ++i) {
			foodItemsPanel.add(foodItemBtn[i]);
			foodItemBtn[i].addActionListener(selectHandler);
		}

		// Transaction Panel
		leftPanel.add(collectItnPanel);
		collectItnPanel.setPreferredSize(new Dimension(100, 100));
		collectItnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		collectItnPanel.setBackground(Color.black);
		collectItnPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		collectItnPanel.add(itemImage);
		itemImage.add(blankLabel);
		itemImage.setPreferredSize(new Dimension(180, 70));
		itemImage.setBorder(loweredbevel);

		// Sub Right Panel 1
		rightPanel.add(subRightPanel1);
		subRightPanel1.setPreferredSize(new Dimension(185, 700));
		subRightPanel1
				.setLayout(new BoxLayout(subRightPanel1, BoxLayout.Y_AXIS));
		subRightPanel1.setBackground(Color.black);
		subRightPanel1.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		subRightPanel1.setBorder(BorderFactory.createTitledBorder(""));
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 15))); // changes
		subRightPanel1.add(selectedItemsLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(displayItemsLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
		subRightPanel1.add(totalQtyLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(displayTotalQty);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
		subRightPanel1.add(totalAmtLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(displayAmtLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(totCalLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(dispTotCalLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(payCashPanel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
	    subRightPanel1.add(clearOrderButton);
	    subRightPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
	    subRightPanel1.add(cardLabel);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(orderFoodButton); //----change
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
		subRightPanel1.add(buyFoodButton);
		subRightPanel1.add(Box.createRigidArea(new Dimension(0, 250)));

		// Pay Cash panel
		payCashPanel.setPreferredSize(new Dimension(180, 300));
		payCashPanel.setLayout(new BoxLayout(payCashPanel, BoxLayout.Y_AXIS));
		payCashPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80));
		payCashPanel.setBackground(Color.black);
		payCashPanel.add(cashLabel);
		payCashPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		payCashPanel.add(amtEntered);
		payCashPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		payCashPanel.add(enterAmtText);
		payCashPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		payCashPanel.add(pBCashButton);
		payCashPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		payCashPanel.add(changeLabel);
		payCashPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		payCashPanel.add(displayChangeLabel);

		selectedItemsLabel.setForeground(Color.white);
		displayItemsLabel.setForeground(Color.white);
		totalQtyLabel.setForeground(Color.white);
		displayTotalQty.setForeground(Color.white);
		displayAmtLabel.setForeground(Color.white);
		cashLabel.setForeground(Color.white);
		amtEntered.setForeground(Color.white);
		totalAmtLabel.setForeground(Color.white);
		changeLabel.setForeground(Color.white);
		displayChangeLabel.setForeground(Color.white);
		cardLabel.setForeground(Color.white);
		orderFoodButton.setEnabled(false); // only show it once logged in
		buyFoodButton.setEnabled(false); // make it invisible initially
		totCalLabel.setForeground(Color.white);
		dispTotCalLabel.setForeground(Color.white);
		totCalLabel.setVisible(true);
		dispTotCalLabel.setVisible(true);
		clearOrderButton.setVisible(false);


		// Sub Right Panel 2
		rightPanel.add(subRightPanel2);
		subRightPanel2.setPreferredSize(new Dimension(665, 700));
		subRightPanel2
				.setLayout(new BoxLayout(subRightPanel2, BoxLayout.Y_AXIS));
		subRightPanel2.setBackground(new Color(28, 0, 0));

		// Login Panel
		subRightPanel2.add(loginPanel);
		loginPanel.setPreferredSize(new Dimension(400, 45));
		loginPanel.setLayout(new GridLayout(2, 2, 5, 0));
		loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
		loginPanel.setBackground(Color.black);
		loginPanel.add(cardNoLabel);
		loginPanel.add(pinLabel);
		loginPanel.add(emptyLabel);
		loginPanel.add(cardNoTxt);
		loginPanel.add(pinTxt);
		loginPanel.add(loginButton);
		loginButton.setPreferredSize(new Dimension(40, 20));

		subRightPanel2.add(logoutPanel);
		logoutPanel.setPreferredSize(new Dimension(380, 20));
		logoutPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 0, 120));
		logoutPanel.setBackground(Color.black);
		logoutPanel.setVisible(false);
		logoutPanel.add(logoutButton);

		cardNoLabel.setForeground(Color.white);
		pinLabel.setForeground(Color.white);

		// Center Panel
		subRightPanel2.add(centerPanel);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		centerPanel.setPreferredSize(new Dimension(630, 525));
		centerPanel.setBackground(Color.black);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

		// Diet Details Panel
		subRightPanel2.add(dietDetailsPanel);
		dietDetailsPanel.setPreferredSize(new Dimension(680, 10));
		dietDetailsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		dietDetailsPanel.setBackground(Color.black);
		dietDetailsPanel.setVisible(false);

		dietDetailsPanel.add(calLmtLabel);
		dietDetailsPanel.add(dispCalLmtLabel);
		dietDetailsPanel.add(calSpntLabel);
		dietDetailsPanel.add(dispCalSpntLabel);
		dietDetailsPanel.add(calRemLabel);
		dietDetailsPanel.add(dispCalRemLabel);

		calLmtLabel.setForeground(Color.white);
		calSpntLabel.setForeground(Color.white);
		calRemLabel.setForeground(Color.white);
		dispCalLmtLabel.setForeground(Color.white);
		dispCalSpntLabel.setForeground(Color.white);
		dispCalRemLabel.setForeground(Color.white);

		// Funds Details Panel
		subRightPanel2.add(fundsDetailsPanel);
		fundsDetailsPanel.setPreferredSize(new Dimension(680, 10));
		fundsDetailsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		fundsDetailsPanel.setBackground(Color.black);
		fundsDetailsPanel.setVisible(false);

		fundsDetailsPanel.add(fundsLmtLabel);
		fundsDetailsPanel.add(dispFundsLmtLabel);
		fundsDetailsPanel.add(fundsSpntLabel);
		fundsDetailsPanel.add(dispFundsSpntLabel);
		fundsDetailsPanel.add(fundsRemLabel);
		fundsDetailsPanel.add(dispFundsRemLabel);

		fundsLmtLabel.setForeground(Color.white);
		fundsSpntLabel.setForeground(Color.white);
		fundsRemLabel.setForeground(Color.white);
		dispFundsLmtLabel.setForeground(Color.white);
		dispFundsSpntLabel.setForeground(Color.white);
		dispFundsRemLabel.setForeground(Color.white);

		// Outlet Panel
		centerPanel.add(outletPanel);
		outletPanel.setPreferredSize(new Dimension(120, 515));
		outletPanel.setLayout(new GridLayout(6, 1, 1, 1));
		outletPanel.add(vm1Button);
		outletPanel.add(vm2Button);
		outletPanel.add(vm3Button);
		outletPanel.add(c1Button);
		outletPanel.add(c2Button);
		outletPanel.add(fsButton);
		outletPanel.setVisible(false);

		vm1Button.setActionCommand("vm1");
		vm2Button.setActionCommand("vm2");
		vm3Button.setActionCommand("vm3");
		c1Button.setActionCommand("c1");
		c2Button.setActionCommand("c2");
		fsButton.setActionCommand("fs1");

		// Map Panel
		centerPanel.add(mapPanel);
		mapPanel.setPreferredSize(new Dimension(520, 515));
		mapPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel.setBackground(Color.black);
		mapPanel.setVisible(true);

		centerPanel.add(mapPanel1);
		mapPanel1.setPreferredSize(new Dimension(520, 515));
		mapPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel1.setBackground(Color.black);
		mapPanel1.setVisible(false);

		centerPanel.add(mapPanel2);
		mapPanel2.setPreferredSize(new Dimension(520, 515));
		mapPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel2.setBackground(Color.black);
		mapPanel2.setVisible(false);

		centerPanel.add(mapPanel3);
		mapPanel3.setPreferredSize(new Dimension(520, 515));
		mapPanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel3.setBackground(Color.black);
		mapPanel3.setVisible(false);

		centerPanel.add(mapPanel4);
		mapPanel4.setPreferredSize(new Dimension(520, 515));
		mapPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel4.setBackground(Color.black);
		mapPanel4.setVisible(false);

		centerPanel.add(mapPanel5);
		mapPanel5.setPreferredSize(new Dimension(520, 515));
		mapPanel5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel5.setBackground(Color.black);
		mapPanel5.setVisible(false);

		centerPanel.add(mapPanel6);
		mapPanel6.setPreferredSize(new Dimension(520, 515));
		mapPanel6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.white));
		mapPanel6.setBackground(Color.black);
		mapPanel6.setVisible(false);

		try {
			mapPic = ImageIO.read(new File("src/images/mapImages/scumap2.jpg"));
			mapPicLabel = new JLabel(new ImageIcon(mapPic));
			mapPicLabel.setPreferredSize(new Dimension(520, 515));
			// mapPicLabel.setBorder(BorderFactory.createTitledBorder(""));
			mapPanel.add(mapPicLabel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Image problems");
		}

		// Dietory Graph Panel
		centerPanel.add(graphPanelD);
		graphPanelD.setPreferredSize(new Dimension(580, 450));
		graphPanelD.setBackground(Color.black);
		graphPanelD.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0,
				Color.white));
		graphPanelD.setVisible(false);

		// Expense Graph Panel
		centerPanel.add(graphPanelE);
		graphPanelE.setPreferredSize(new Dimension(580, 450));
		graphPanelE.setBackground(Color.black);
		graphPanelE.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0,
				Color.white));
		graphPanelE.setVisible(false);

		// Bar chart
		graphPanelD.add(dietChart);
		graphPanelD.setVisible(false);
		graphPanelE.add(expenseChart);
		graphPanelE.setVisible(false);

		// User Options Panel
		subRightPanel2.add(userOptionsPanel);
		userOptionsPanel.setPreferredSize(new Dimension(630, 80));
		userOptionsPanel.setBorder(BorderFactory
				.createEmptyBorder(10, 0, 0, 10));
		userOptionsPanel.setBackground(Color.black);
		userOptionsPanel.add(setPrefButton);
		userOptionsPanel.add(viewDietButton);
		userOptionsPanel.add(viewExpenseButton);
		userOptionsPanel.add(viewMapButton);
		userOptionsPanel.setVisible(false);

		// Welcome Panel
		subRightPanel2.add(welcomePanel);
		welcomePanel.setPreferredSize(new Dimension(630, 80));
		welcomePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
		welcomePanel.setBackground(Color.black);
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
		welcomePanel.add(welcomeLabel);

		// Set Preference Panel
		subRightPanel2.add(setPrefPanel);
		setPrefPanel.setPreferredSize(new Dimension(630, 80));
		setPrefPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		setPrefPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		setPrefPanel.setBackground(Color.black);
		setPrefPanel.setForeground(Color.white);
		setPrefPanel.setVisible(false);
		setPrefPanel.add(dCLabel);
		setPrefPanel.add(dCText);
		setPrefPanel.add(mFLabel);
		setPrefPanel.add(mFText);
		setPrefPanel.add(savePrefButton);
		setPrefPanel.add(backButton);
		infoPanel.setPreferredSize(new Dimension(630, 30));
		infoPanel.setBackground(Color.black);
		infoLabel.setForeground(Color.red);
		infoLabel.setFont(new Font("Serif", Font.ITALIC, 13));
		infoPanel.add(infoLabel);
		setPrefPanel.add(infoPanel);
		dCLabel.setForeground(Color.white);
		mFLabel.setForeground(Color.white);

		/****************************** Event Listener Code ************************/
		scuLogoPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scuLogoPanel.setVisible(false); //
				mainPanel.setVisible(true);

			}

			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		pBCashButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (payByCash()) {

					Component[] components = itemImage.getComponents();
					Component component = null;

					for (int i = 0; i < components.length; i++) {
						component = components[i];
						if (component instanceof JLabel) {
							itemImage.remove(component);

						}
					}

					itemImage.setBackground(Color.white);
					itemImage.add(horizontalPicLabel);
					itemImage.revalidate();
					JOptionPane.showMessageDialog(null, "Collect your food!!");
					return;
				}

				/*
				 * JOptionPane.showMessageDialog(null,
				 * "Something went wrong. Try again later!!"); return;
				 */
			}
		});

		setPrefButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				userOptionsPanel.setVisible(false);
				setPrefPanel.setVisible(true);
				graphPanelE.setVisible(false);
				graphPanelD.setVisible(false);
				mapPanel.setVisible(true);
				mapPanel1.setVisible(false);
				mapPanel2.setVisible(false);
				mapPanel3.setVisible(false);
				mapPanel4.setVisible(false);
				mapPanel5.setVisible(false);
				mapPanel6.setVisible(false);
				dCText.setText(Integer.toString(authenticatedUser.getCalories()));
				mFText.setText(Double.toString(authenticatedUser.getFunds()));
				dietDetailsPanel.setVisible(false); // ---------change
				fundsDetailsPanel.setVisible(false);// ---------change
				buyFoodButton.setEnabled(false); // ---------change
				orderFoodButton.setEnabled(false); // ---------change
				initializeValues();
				displayChangeLabel.setText("$ 0.0");

			}

		});

		viewMapButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				displayChangeLabel.setText("$ 0.0");
				graphPanelE.setVisible(false);
				graphPanelD.setVisible(false);
				outletPanel.setVisible(true);
				mapPanel.setVisible(true);
				mapPanel1.setVisible(false);
				mapPanel2.setVisible(false);
				mapPanel3.setVisible(false);
				mapPanel4.setVisible(false);
				mapPanel5.setVisible(false);
				mapPanel6.setVisible(false);
				dietDetailsPanel.setVisible(false); // ---------change
				fundsDetailsPanel.setVisible(false);// ---------change
				initializeValues();
				displayChangeLabel.setText("$ 0.0");
			}

		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				payCashPanel.setVisible(true);
				outletPanel.setVisible(false);
				userOptionsPanel.setVisible(false);
				setPrefPanel.setVisible(false);
				logoutPanel.setVisible(false);
				loginPanel.setVisible(true);
				welcomePanel.setVisible(true);
				orderFoodButton.setEnabled(false);
				buyFoodButton.setEnabled(false);
				mapPanel1.setVisible(false);
				mapPanel2.setVisible(false);
				mapPanel3.setVisible(false);
				mapPanel4.setVisible(false);
				mapPanel5.setVisible(false);
				mapPanel6.setVisible(false);
				mapPanel.setVisible(true);
				leftPanel.setVisible(true);
				menuPanel.setVisible(false);
				collectItnPanel.setVisible(true); // ---------change
				dietDetailsPanel.setVisible(false); // ---------change
				fundsDetailsPanel.setVisible(false);// ---------change

				Component[] components = itemImage.getComponents();
				Component component = null;

				for (int i = 0; i < components.length; i++) {
					component = components[i];
					if (component instanceof JLabel) {
						itemImage.remove(component);

					}
				}
				itemImage.repaint();
				//itemImage.revalidate();
				displayChangeLabel.setText("$ 0.0");

				initializeValues();
				foodItemList.clear();
				authenticated = 0;
				authenticatedUser = null;
				for (int i = 0; i < foodItemBtn.length; ++i) {
					foodItemsPanel.remove(foodItemBtn[i]);
				}
				foodItemsPanel.revalidate();
				foodOrdered.clear();
				readXML(xmlMap.get("vm1"), foodItemList);

				SIHandler selectHandler = new SIHandler();
				for (int i = 0; i < foodItemBtn.length; ++i) {
					foodItemsPanel.add(foodItemBtn[i]);
					foodItemBtn[i].addActionListener(selectHandler);
				}
				foodItemsPanel.repaint();
			}

		});

		enterAmtText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				numericaValidation(enterAmtText, event);
			}
		});

		dCText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				numericaValidation(dCText, event);
			}
		});

		mFText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				numericaValidation(mFText, event);
			}
		});

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				savePrefButton.setText("Set");
				savePrefButton.setEnabled(true);
				userOptionsPanel.setVisible(true);
				setPrefPanel.setVisible(false);
				buyFoodButton.setEnabled(true); // ---------change
				orderFoodButton.setEnabled(true); // ---------change
			}

		});
		
		clearOrderButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				displayItemsLabel.setText("---------------------");
				displayTotalQty.setText("0");
				displayAmtLabel.setText("$ 0.0");
				dispTotCalLabel.setText("0");
				foodOrdered.clear();

			}
		});

		campusCardUsers = getUsers(xmlMap.get("u"));

		LoginHandler loginHandler = new LoginHandler();
		loginButton.addActionListener(loginHandler);

		PreferencesHandler preferenceHandler = new PreferencesHandler();
		savePrefButton.addActionListener(preferenceHandler);

		EPHandler expProfHandler = new EPHandler();
		viewExpenseButton.addActionListener(expProfHandler);

		DPHandler dietProfHandler = new DPHandler();
		viewDietButton.addActionListener(dietProfHandler);

		MapHandler mapHandler = new MapHandler();
		vm1Button.addActionListener(mapHandler);
		vm2Button.addActionListener(mapHandler);
		vm3Button.addActionListener(mapHandler);
		c1Button.addActionListener(mapHandler);
		c2Button.addActionListener(mapHandler);
		fsButton.addActionListener(mapHandler);

		buyFoodButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (buyFood()) {

					Component[] components = itemImage.getComponents();
					Component component = null;

					for (int i = 0; i < components.length; i++) {
						component = components[i];
						if (component instanceof JLabel) {
							itemImage.remove(component);

						}
					}
					itemImage.setBackground(Color.white);
					itemImage.add(horizontalPicLabel);
					itemImage.revalidate();
					JOptionPane.showMessageDialog(null, "Collect your food!!");
					return;
				}

				/*
				 * JOptionPane.showMessageDialog(null,
				 * "Something went wrong. Try again later!!"); return;
				 */
			}
		});

		orderFoodButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayChangeLabel.setText("$ 0.0");
				if (orderFood()) {
					JOptionPane.showMessageDialog(null, "Enjoy your food!!");
					return;
				}

				/*
				 * JOptionPane.showMessageDialog(null,
				 * "Something went wrong. Try again later!!"); return;
				 */
			}
		});

		pack();
		setSize(1355, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	// This method deserializes the xml file and returns campus card users.
	private List<CampusCardUser> getUsers(String xmlFileLocation) {
		List<CampusCardUser> users = new ArrayList<CampusCardUser>();
		try {
			users = (List<CampusCardUser>) deSerializer
					.deserializeXMLToObject(xmlFileLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	// This method deserializes the xml file and returns valid user's purchased
	// details.
	private List<PurchasedDetails> getPurchasedDetails(String xmlFileLocation,
			String cardNo) {

		List<PurchasedDetails> purchasedDetails = new ArrayList<PurchasedDetails>();

		try {
			List<PurchasedDetails> allPurchasedDetails = new ArrayList<PurchasedDetails>();
			allPurchasedDetails = (List<PurchasedDetails>) deSerializer
					.deserializeXMLToObject(xmlFileLocation);

			Iterator<PurchasedDetails> iterator = allPurchasedDetails
					.iterator();

			while (iterator.hasNext()) {

				PurchasedDetails singlePurDetail = iterator.next();

				if (singlePurDetail.getCardNo().equals(cardNo)) {
					purchasedDetails.add(singlePurDetail);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return purchasedDetails;
	}

	private class SIHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				FoodItems selectedFood = new FoodItems();
				Iterator<FoodItems> iterator = foodItemList.iterator();
				String uniqueId;

				while (iterator.hasNext()) {

					selectedFood = iterator.next();

					selItemId = selectedFood.getFoodId();
					selOutletId = selectedFood.getOutletId();
					uniqueId = (selOutletId + selItemId).trim();

					if (e.getActionCommand().equals(uniqueId)) {
						String name = selectedFood.getFoodName()
								.replace(" ", "").toLowerCase().toString()
								+ "H.png";
						horizontalPic = ImageIO.read(new File("src/images/"
								+ name));
						horizontalPicLabel = new JLabel(new ImageIcon(
								horizontalPic));
						horizontalPicLabel.setPreferredSize(new Dimension(180,
								70));

						purFoodItem.put(uniqueId, selectedFood);

						totalQty = 1;
						displayItemsLabel.setText(selectedFood.getFoodName()
								+ "  -  " + totalQty);
						displayTotalQty.setText(Integer.toString(totalQty));
						displayAmtLabel.setText("$ "
								+ selectedFood.getFoodPrice() * totalQty);
						dispTotCalLabel.setText(Integer.toString(selectedFood
								.getFoodCalories()));
						break;

					}
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Image problems");
			}
			displayChangeLabel.setText("$ 0.0");
		}
	}

	// This is a handler class which handles LOGIN button click.
	private class LoginHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			Login lg = new Login(campusCardUsers);
			String cardNo = cardNoTxt.getText();
			char[] pinPieces = pinTxt.getPassword();
			String wholePin = new String(pinPieces);

			try {
				if (authenticated == 0) {

					authenticated = lg.authenticateUser(cardNo, wholePin);

					if (authenticated == 1) {
						// Authenticated
						authenticatedUser = lg.getValidUser(campusCardUsers,
								cardNo);
						userPurchasedDetails = getPurchasedDetails(
								xmlMap.get("pd"), cardNo);

						loginPanel.setVisible(false);
						welcomePanel.setVisible(false);
						payCashPanel.setVisible(false);

						userOptionsPanel.setVisible(true);
						outletPanel.setVisible(true);
						logoutPanel.setVisible(true);
						orderFoodButton.setEnabled(false);
						buyFoodButton.setEnabled(true);
						cardNoTxt.setText("");
						pinTxt.setText("");
						setOutletObject();
						
						Component[] components = itemImage.getComponents();
						Component component = null;

						for (int i = 0; i < components.length; i++) {
							component = components[i];
							if (component instanceof JLabel) {
								itemImage.remove(component);

							}
						}
						itemImage.repaint();
						//itemImage.revalidate();

					} else if (authenticated == 2) {
						// Invalid Student ID/Card Number!!
						cardNoTxt.setBackground(Color.red);
						authenticated = 0;
					} else {
						// Invalid Pin/Password!!
						cardNoTxt.setBackground(Color.white);
						pinTxt.setBackground(Color.red);
						authenticated = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Authenticate flag not cleared");
					return;
				}

			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Oops!! Something went wrong while login into the system. Try Again.",
								"Error", JOptionPane.ERROR_MESSAGE);

				e.printStackTrace();
			}

			// Zero out the possible password, for security.
			Arrays.fill(pinPieces, '0');
			wholePin = "";
			initializeValues();
			displayChangeLabel.setText("$ 0.0");
		}

	}

	// This is a handler class which handles SET PREFERENCES button click.
	private class PreferencesHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			try {

				if (authenticated != 1) {
					JOptionPane.showMessageDialog(null,
							"Session Expired!! Login Again");
					return;
				}

				int dailyCalories = Integer.parseInt(dCText.getText());
				double monthlyFunds = Double.parseDouble(mFText.getText());

				if (authenticatedUser.getGender() == 'M'
						&& MAXM_DAILY_CALORIES < dailyCalories) {
					JOptionPane.showMessageDialog(null,
							"You are exceeding calories limit!", "Warning", 0);
					dCText.setBackground(Color.red);
					return;
				}

				if (authenticatedUser.getGender() == 'F'
						&& MAXF_DAILY_CALORIES < dailyCalories) {
					JOptionPane.showMessageDialog(null,
							"You are exceeding calories limit!", "Warning", 0);
					dCText.setBackground(Color.red);
					return;
				}

				dCText.setBackground(Color.white);

				if (MAX_MONTHLY_FUNDS < monthlyFunds) {
					JOptionPane.showMessageDialog(null,
							"You are exceeding monthly funds limit!",
							"Warning", 0);
					mFText.setBackground(Color.red);
					return;
				}

				mFText.setBackground(Color.white);
				authenticatedUser.setCalories(dailyCalories);
				authenticatedUser.setFunds(Double.parseDouble(deciFormatter
						.format(monthlyFunds)));
				authenticatedUser.setCaloriesSpent(0);
				authenticatedUser.setFundsSpent(0);
				savePrefButton.setText("Saved!!");
				savePrefButton.setEnabled(false);

			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Oops!! Something went wrong while login into the system. Try Again.",
								"Error", JOptionPane.ERROR_MESSAGE);

				e.printStackTrace();
			}
		}
	}

	// This is a handler class which handles EXPENSE PROFILE button click.
	private class EPHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mapPanel.setVisible(false);
			mapPanel1.setVisible(false);
			mapPanel2.setVisible(false);
			mapPanel3.setVisible(false);
			mapPanel4.setVisible(false);
			mapPanel5.setVisible(false);
			mapPanel6.setVisible(false);
			outletPanel.setVisible(false);
			graphPanelD.setVisible(false);
			graphPanelE.setVisible(true);
			graphPanelE.revalidate();
			graphPanelE.repaint();
			initializeValues();
			displayChangeLabel.setText("$ 0.0");
			fundsDetailsPanel.setVisible(true);
			dietDetailsPanel.setVisible(false);

			dispFundsLmtLabel.setText(deciFormatter.format(authenticatedUser
					.getFunds() + authenticatedUser
					.getFundsSpent()));
			dispFundsSpntLabel.setText(deciFormatter.format(authenticatedUser
					.getFundsSpent()));
			dispFundsRemLabel.setText(deciFormatter.format(authenticatedUser
					.getFunds()));

			try {

				// expenseChart = new BarChart();
				Iterator<PurchasedDetails> eIterator = userPurchasedDetails
						.iterator();
				PurchasedDetails singleDtl = new PurchasedDetails();
				double totalExpPerWeek = 0.0;
				double[] totalExpPerDay = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
				calender = Calendar.getInstance();
				dateTime = calender.getTime();
				dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				dayFormatter = new SimpleDateFormat("EEEE");

				calender.add(Calendar.DATE, -7);
				Date datePriorWeek = calender.getTime();
				Date purchasedDate;

				while (eIterator.hasNext()) {

					singleDtl = eIterator.next();

					if (authenticatedUser.getCardno().equals(
							singleDtl.getCardNo())) {
						purchasedDate = dateFormatter.parse(singleDtl
								.getFoodPurchasedDateTime());

						if (purchasedDate.after(datePriorWeek)
								&& purchasedDate.before(dateTime)) {

							String day = dayFormatter.format(purchasedDate);
							day = day.toUpperCase();
							double totalForDay = singleDtl.getFoodItemPrice()
									* 1;
							totalExpPerWeek += singleDtl.getFoodQuantity();

							if (day.equals("MONDAY")) {
								totalExpPerDay[1] += totalForDay;
							}

							if (day.equals("TUESDAY")) {
								totalExpPerDay[2] += totalForDay;
							}

							if (day.equals("WEDNESDAY")) {
								totalExpPerDay[3] += totalForDay;
							}

							if (day.equals("THURSDAY")) {
								totalExpPerDay[4] += totalForDay;
							}

							if (day.equals("FRIDAY")) {
								totalExpPerDay[5] += totalForDay;
							}

							if (day.equals("SATURDAY")) {
								totalExpPerDay[6] += totalForDay;
							}

							if (day.equals("SUNDAY")) {
								totalExpPerDay[0] += totalForDay;
							}
						}

					}
				}

				for (int j = 0; j < totalExpPerDay.length; j++) {
					expenseChart.addBar(days[j],
							(int) Math.round(totalExpPerDay[j]));
				}

				expenseChart.setVisible(true);

			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// This is a handler class which handles DIETORY PROFILE button click.
	private class DPHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			mapPanel.setVisible(false);
			mapPanel1.setVisible(false);
			mapPanel2.setVisible(false);
			mapPanel3.setVisible(false);
			mapPanel4.setVisible(false);
			mapPanel5.setVisible(false);
			mapPanel6.setVisible(false);
			outletPanel.setVisible(false);
			graphPanelE.setVisible(false);
			graphPanelD.setVisible(true);
			graphPanelD.revalidate();
			graphPanelD.repaint();
			dietDetailsPanel.setVisible(true);
			fundsDetailsPanel.setVisible(false);

			dispCalLmtLabel.setText(Integer.toString(authenticatedUser
					.getCalories() + authenticatedUser
					.getCaloriesSpent()));
			dispCalSpntLabel.setText(Integer.toString(authenticatedUser
					.getCaloriesSpent()));
			dispCalRemLabel.setText(Integer.toString(authenticatedUser
					.getCalories()));

			initializeValues();
			displayChangeLabel.setText("$ 0.0");

			try {
				Iterator<PurchasedDetails> dIterator = userPurchasedDetails
						.iterator();
				PurchasedDetails singleDtl = new PurchasedDetails();
				double totalCalPerWeek = 0.0;
				double[] totalCalPerDay = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
				calender = Calendar.getInstance();
				dateTime = calender.getTime();
				dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				dayFormatter = new SimpleDateFormat("EEEE");

				calender.add(Calendar.DATE, -7);
				Date datePriorWeek = calender.getTime();
				Date purchasedDate;

				while (dIterator.hasNext()) {

					singleDtl = dIterator.next();

					if (authenticatedUser.getCardno().equals(
							singleDtl.getCardNo())) {
						purchasedDate = dateFormatter.parse(singleDtl
								.getFoodPurchasedDateTime());

						if (purchasedDate.after(datePriorWeek)
								&& purchasedDate.before(dateTime)) {

							String day = dayFormatter.format(purchasedDate);
							day = day.toUpperCase();
							double totalForDay = singleDtl
									.getFoodItemCalories()
									* 1;
							totalCalPerWeek += singleDtl.getFoodQuantity();

							if (day.equals("MONDAY")) {
								totalCalPerDay[1] += totalForDay;
							}

							if (day.equals("TUESDAY")) {
								totalCalPerDay[2] += totalForDay;
							}

							if (day.equals("WEDNESDAY")) {
								totalCalPerDay[3] += totalForDay;
							}

							if (day.equals("THURSDAY")) {
								totalCalPerDay[4] += totalForDay;
							}

							if (day.equals("FRIDAY")) {
								totalCalPerDay[5] += totalForDay;
							}

							if (day.equals("SATURDAY")) {
								totalCalPerDay[6] += totalForDay;
							}

							if (day.equals("SUNDAY")) {
								totalCalPerDay[0] += totalForDay;
							}
						}
					}
				}

				// dietChart = new BarChart();
				for (int j = 0; j < totalCalPerDay.length; j++) {
					dietChart.addBar(days[j],
							(int) Math.round(totalCalPerDay[j]));
				}
				dietChart.setVisible(true);

			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private class OIHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			FoodItems selectedItem = new FoodItems();
			Iterator<FoodItems> iterator = foodItemList.iterator();
			String uniqueId;
			displayChangeLabel.setText("$ 0.0");

			if (totalOrderedQty < 5) {
				while (iterator.hasNext()) {

					selectedItem = iterator.next();
					selItemId = selectedItem.getFoodId();
					selOutletId = selectedItem.getOutletId();
					uniqueId = (selOutletId + selItemId).trim();

					if (e.getActionCommand().equals(uniqueId)) {

						foodOrdered.add(selectedItem);

						strOrderList += selectedItem.getFoodName()
								+ "          -          " + 1 + "<br>";
						displayItemsLabel.setText("<html>" + strOrderList
								+ "</html>");

						totalOrderedQty += 1;
						displayTotalQty.setText(Integer
								.toString(totalOrderedQty));

						totalAmount += selectedItem.getFoodPrice();
						totalAmount = Double.parseDouble(deciFormatter
								.format(totalAmount));
						displayAmtLabel.setText("$ " + totalAmount);

						totalCalories += selectedItem.getFoodCalories();
						dispTotCalLabel
								.setText(Integer.toString(totalCalories));
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"You can't order more than 5 food item!");
			}
		}
	}

	private boolean payByCash() {

		if (purFoodItem.size() < 0) {
			JOptionPane.showMessageDialog(null, "Select the items first!!");
			return false;
		}

		if (enterAmtText.getText() == "" || enterAmtText.getText() == "0") {
			JOptionPane.showMessageDialog(null, "Enter cash please!");
			return false;
		}

		FoodItems selectedFood = new FoodItems();
		Iterator<FoodItems> iterator = foodItemList.iterator();
		int index;
		double totalAmt = 0.0;
		double enteredAmt = Double.parseDouble(enterAmtText.getText());
		double leftAmt = 0.0;
		String uniqueId = "";
		uniqueId = selOutletId + Integer.toString(selItemId);

		while (iterator.hasNext()) {

			selectedFood = iterator.next();

			if (purFoodItem.get(uniqueId).equals(selectedFood)) {

				totalAmt = selectedFood.getFoodPrice() * totalQty;
				leftAmt = enteredAmt - totalAmt;

				if (leftAmt < 0) {
					JOptionPane.showMessageDialog(null,
							"Entered Amt is less than Total Amt.", "Error",
							JOptionPane.ERROR_MESSAGE);
					enterAmtText.setBackground(Color.red);
					return false;
				}

				enterAmtText.setBackground(Color.white);

				if (leftAmt == 0 || leftAmt > 0) {
					displayChangeLabel.setText("$ " + deciFormatter.format(leftAmt));

					index = foodItemList.indexOf(selectedFood);
					selectedFood.setFoodQty(selectedFood.getFoodQty() - 1);
					foodItemList.set(index, selectedFood);
					break;
				}

			}
		}
		initializeValues();
		return true;
	}

	private boolean buyFood() {
		try {

			if (authenticatedUser.getFunds() == 0) {
				JOptionPane.showMessageDialog(null,
						"Your funds are nil, refill your card!");
				return false;
			}

			if (authenticatedUser.getFunds() < 0) {
				JOptionPane.showMessageDialog(null,
						"Your funds is in negative, refill your card first!");
				return false;
			}

			if (authenticatedUser.getCalories() == 0) {
				JOptionPane.showConfirmDialog(null,
						"You consumed all your daily calories!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}

			FoodItems selectedFood = new FoodItems();
			Iterator<FoodItems> iterator = foodItemList.iterator();

			while (iterator.hasNext()) {
				selectedFood = iterator.next();

				if (selectedFood.getOutletId() == selOutletId
						&& selectedFood.getFoodId() == selItemId) {

					if (selectedFood.getFoodCalories() > authenticatedUser
							.getCalories()) {
						JOptionPane
								.showMessageDialog(
										null,
										"You are exceeding your daily calorific limit!",
										"Warning", JOptionPane.WARNING_MESSAGE);
						return false;
					}

					if (selectedFood.getFoodPrice() > authenticatedUser
							.getFunds()) {
						JOptionPane
								.showMessageDialog(
										null,
										"You are exceeding your available funds limit!",
										"Error", JOptionPane.WARNING_MESSAGE);
						return false;
					}

					calender = Calendar.getInstance();
					dateTime = calender.getTime();
					dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

					PurchasedDetails purchasedDtl = new PurchasedDetails(
							authenticatedUser.getCardno(),
							selectedFood.getOutletId(),
							selectedFood.getFoodId(),
							selectedFood.getFoodQty(),
							selectedFood.getFoodCalories(),
							selectedFood.getFoodPrice(),
							dateFormatter.format(dateTime));

					userPurchasedDetails.add(purchasedDtl);

					int caloriesSpent = authenticatedUser.getCaloriesSpent();
					caloriesSpent += selectedFood.getFoodCalories();
					int caloriesLeft = authenticatedUser.getCalories()
							- selectedFood.getFoodCalories();
					authenticatedUser.setCalories(caloriesLeft);
					authenticatedUser.setCaloriesSpent(caloriesSpent);

					double fundsSpent = authenticatedUser.getFundsSpent();
					fundsSpent += selectedFood.getFoodPrice();
					double fundsLeft = authenticatedUser.getFunds()
							- selectedFood.getFoodPrice();
					authenticatedUser.setFunds(Double.parseDouble(deciFormatter
							.format(fundsLeft)));
					authenticatedUser.setFundsSpent(fundsSpent);

					/*
					 * Iterator<CampusCardUser> uIterator = campusCardUsers
					 * .iterator();
					 * 
					 * while (uIterator.hasNext()) { CampusCardUser aUser =
					 * uIterator.next(); if
					 * (authenticatedUser.getAccountNo().equals(
					 * aUser.getAccountNo())) { //
					 * authenticatedUser.setFundsSpent(fundsSpent);
					 * aUser.setFundsSpent(fundsSpent); } }
					 */

					Login lg = new Login(campusCardUsers);
					authenticatedUser = lg.getValidUser(campusCardUsers,
							authenticatedUser.getCardno());

					int index = foodItemList.indexOf(selectedFood);
					selectedFood.setFoodQty(selectedFood.getFoodQty() - 1);
					foodItemList.set(index, selectedFood);

					initializeValues();
					break;
				}
			}

			deSerializer.serializeObjectToXML(xmlMap.get("u"), campusCardUsers);
			deSerializer.serializeObjectToXML(xmlMap.get("pd"),
					userPurchasedDetails);
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oops!! Something went wrong while ordering the food. Try Again.",
							"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oops!! Something went wrong while ordering the food. Try Again.",
							"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}
		initializeValues();
		return true;
	}

	private boolean orderFood() {

		try {
			
			if(foodOrdered.size() == 0){
				JOptionPane.showMessageDialog(null,
						"Please select the items to order!!");
				return false;
			}

			if (authenticatedUser.getFunds() == 0) {
				JOptionPane.showMessageDialog(null,
						"Your funds are nil, set your funds!");
				return false;
			}

			if (authenticatedUser.getFunds() < 0) {
				JOptionPane.showMessageDialog(null,
						"Your funds is in negative, set your funds!");
				return false;
			}

			if (authenticatedUser.getCalories() == 0) {
				JOptionPane.showConfirmDialog(null,
						"You consumed all your daily calories!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}

			if (totalCalories > authenticatedUser.getCalories()) {
				JOptionPane.showMessageDialog(null,
						"You are exceeding your daily calorific limit!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				return false;
			}

			if (totalAmount > authenticatedUser.getFunds()) {
				JOptionPane.showMessageDialog(null,
						"You are exceeding your available funds limit!",
						"Error", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			

			int orderList = foodOrdered.size();
			calender = Calendar.getInstance();
			dateTime = calender.getTime();
			dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			PurchasedDetails purchasedDtl;

			for (int i = 0; i < orderList; i++) {

				purchasedDtl = new PurchasedDetails(
						authenticatedUser.getCardno(), foodOrdered.get(i)
								.getOutletId(), foodOrdered.get(i).getFoodId(),
						foodOrdered.get(i).getFoodQty(), foodOrdered.get(i)
								.getFoodCalories(), foodOrdered.get(i)
								.getFoodPrice(), dateFormatter.format(dateTime));

				userPurchasedDetails.add(purchasedDtl);

				int caloriesSpent = authenticatedUser.getCaloriesSpent();
				caloriesSpent += foodOrdered.get(i).getFoodCalories();
				int caloriesLeft = authenticatedUser.getCalories()
						- foodOrdered.get(i).getFoodCalories();
				authenticatedUser.setCalories(caloriesLeft);
				authenticatedUser.setCaloriesSpent(caloriesSpent);

				double fundsSpent = authenticatedUser.getFundsSpent();
				fundsSpent += foodOrdered.get(i).getFoodPrice();
				double fundsLeft = authenticatedUser.getFunds()
						- foodOrdered.get(i).getFoodPrice();
				authenticatedUser.setFunds(Double.parseDouble(deciFormatter
						.format(fundsLeft)));
				authenticatedUser.setFundsSpent(fundsSpent);

				/*
				 * Iterator<CampusCardUser> uIterator =
				 * campusCardUsers.iterator();
				 * 
				 * while (uIterator.hasNext()) { CampusCardUser aUser =
				 * uIterator.next(); if
				 * (authenticatedUser.getAccountNo().equals(
				 * aUser.getAccountNo())) { aUser.setFundsSpent(fundsSpent); } }
				 */

				Login lg = new Login(campusCardUsers);
				authenticatedUser = lg.getValidUser(campusCardUsers,
						authenticatedUser.getCardno());

			}

			deSerializer.serializeObjectToXML(xmlMap.get("u"), campusCardUsers);
			deSerializer.serializeObjectToXML(xmlMap.get("pd"),
					userPurchasedDetails);

			Random randomGenerator = new Random();

			int randomInt = randomGenerator.nextInt(50);
			randomInt = randomInt < 15 ? randomGenerator.nextInt(50)
					: randomInt;

			FoodOutlet currentOutlet = (FoodOutlet) outletMap.get("vm1");

			initializeValues();

			JOptionPane
					.showMessageDialog(
							null,
							"<html>Order is placed!!<br>Order ready in " + randomInt + " mins."
									+ "<br>Distance from current location : " + currentOutlet.getDistance(selectedOutlet.getOutletID()) +" miles</html>");

		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oops!! Something went wrong while ordering the food. Try Again.",
							"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oops!! Something went wrong while ordering the food. Try Again.",
							"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void numericaValidation(JTextField textField, KeyEvent event) {
		if (event.getKeyChar() >= '0' && event.getKeyChar() <= '9'
				|| event.getKeyChar() == '\b' || event.getKeyChar() == '.') {
			textField.setEditable(true);
		} else {
			textField.setEditable(false);
		}
	}

	private class MapHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				selectedOutlet = (FoodOutlet) outletMap.get(e
						.getActionCommand());
				foodItemList.clear();

				if (e.getActionCommand().equals("vm1")) {

					menuPanel.setVisible(false);
					leftPanel.setVisible(true);
					orderFoodButton.setEnabled(false);
					buyFoodButton.setEnabled(true);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();

					}

					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					SIHandler selectHandler = new SIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.add(foodItemBtn[i]);
						foodItemBtn[i].addActionListener(selectHandler);
						foodItemsPanel.repaint();
					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/Engineeringmap.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));

					mapPanel1.add(engPiclabel);
					mapPanel1.setVisible(true);
					mapPanel.setVisible(false);
					mapPanel2.setVisible(false);
					mapPanel3.setVisible(false);
					mapPanel4.setVisible(false);
					mapPanel5.setVisible(false);
					mapPanel6.setVisible(false);
					clearOrderButton.setVisible(false);
					collectItnPanel.setVisible(true);
					return;
				}

				if (e.getActionCommand().equals("vm2")) {

					menuPanel.setVisible(false);
					leftPanel.setVisible(true);
					orderFoodButton.setEnabled(false);
					buyFoodButton.setEnabled(false);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();

					}

					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					SIHandler selectHandler = new SIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.add(foodItemBtn[i]);
						foodItemsPanel.repaint();
						foodItemBtn[i].addActionListener(selectHandler);
					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/oconnormap.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));
					mapPanel2.add(engPiclabel);
					mapPanel2.setVisible(true);
					mapPanel.setVisible(false);
					mapPanel1.setVisible(false);
					mapPanel3.setVisible(false);
					mapPanel4.setVisible(false);
					mapPanel5.setVisible(false);
					mapPanel6.setVisible(false);
					collectItnPanel.setVisible(false);
					clearOrderButton.setVisible(false);

				}

				if (e.getActionCommand().equals("vm3")) {

					menuPanel.setVisible(false);
					leftPanel.setVisible(true);

					orderFoodButton.setEnabled(false);
					buyFoodButton.setEnabled(false);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();

					}

					// foodItemList.clear();
					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					SIHandler selectHandler = new SIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.add(foodItemBtn[i]);
						foodItemsPanel.repaint();
						foodItemBtn[i].addActionListener(selectHandler);
					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/kennamap.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));

					mapPanel3.add(engPiclabel);
					mapPanel3.setVisible(true);
					mapPanel.setVisible(false);
					mapPanel1.setVisible(false);
					mapPanel2.setVisible(false);
					mapPanel4.setVisible(false);
					mapPanel5.setVisible(false);
					mapPanel6.setVisible(false);
					collectItnPanel.setVisible(false);
					clearOrderButton.setVisible(false);

				}

				// readXML(xmlMap.get(e.getActionCommand()), foodItemList);

				if (e.getActionCommand().equals("c1")) {

					leftPanel.setVisible(false);
					menuPanel.setVisible(true);
					orderFoodButton.setEnabled(true);
					buyFoodButton.setEnabled(false);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();

					}

					// foodItemList.clear();
					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					OIHandler selectHandler = new OIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						menuPanel.add(foodItemBtn[i]);
						menuPanel.repaint();
						foodItemBtn[i].addActionListener(selectHandler);
					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/bensonmap.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));

					mapPanel4.add(engPiclabel);
					mapPanel.setVisible(false);
					mapPanel1.setVisible(false);
					mapPanel2.setVisible(false);
					mapPanel3.setVisible(false);
					mapPanel5.setVisible(false);
					mapPanel6.setVisible(false);
					mapPanel4.setVisible(true);
					clearOrderButton.setVisible(true);

				}

				if (e.getActionCommand().equals("c2")) {

					leftPanel.setVisible(false);
					menuPanel.setVisible(true);
					orderFoodButton.setEnabled(true);
					buyFoodButton.setEnabled(false);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();
					}

					// foodItemList.clear();
					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					OIHandler selectHandler = new OIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						menuPanel.add(foodItemBtn[i]);
						menuPanel.repaint();
						foodItemBtn[i].addActionListener(selectHandler);
					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/library.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));

					mapPanel5.add(engPiclabel);
					mapPanel5.setVisible(true);
					mapPanel.setVisible(false);
					mapPanel1.setVisible(false);
					mapPanel2.setVisible(false);
					mapPanel3.setVisible(false);
					mapPanel4.setVisible(false);
					mapPanel6.setVisible(false);
					clearOrderButton.setVisible(true);
				}

				if (e.getActionCommand().equals("fs1")) {

					leftPanel.setVisible(false);
					menuPanel.setVisible(true);
					orderFoodButton.setEnabled(true);
					buyFoodButton.setEnabled(false);

					for (int i = 0; i < foodItemBtn.length; ++i) {
						foodItemsPanel.remove(foodItemBtn[i]);
						menuPanel.remove(foodItemBtn[i]);
						foodItemsPanel.revalidate();

					}

					//foodItemList.clear();
					readXML(xmlMap.get(e.getActionCommand()), foodItemList);

					OIHandler selectHandler = new OIHandler();
					for (int i = 0; i < foodItemBtn.length; ++i) {
						menuPanel.add(foodItemBtn[i]);
						menuPanel.repaint();
						foodItemBtn[i].addActionListener(selectHandler);

					}

					BufferedImage engPic = ImageIO.read(new File(
							"src/images/mapImages/Artsciencemap.jpg"));
					JLabel engPiclabel = new JLabel(new ImageIcon(engPic));
					engPiclabel.setPreferredSize(new Dimension(520, 515));

					mapPanel6.add(engPiclabel);
					mapPanel6.setVisible(true);
					mapPanel.setVisible(false);
					mapPanel1.setVisible(false);
					mapPanel2.setVisible(false);
					mapPanel3.setVisible(false);
					mapPanel4.setVisible(false);
					mapPanel5.setVisible(false);
					clearOrderButton.setVisible(true);
				}

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Image problems");
				ex.printStackTrace();
			}
		}
	}

	/*
	 * private class MapHandler implements ActionListener { public void
	 * actionPerformed(ActionEvent e) { try { initializeValues(); SIHandler
	 * selectHandler = new SIHandler(); OIHandler orderHandler = new
	 * OIHandler(); selectedOutlet = (FoodOutlet) outletMap.get(e
	 * .getActionCommand());
	 * 
	 * String outletID = selectedOutlet.getOutletID();
	 * 
	 * if (outletID.equals("vm1")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/Engineeringmap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515));
	 * 
	 * mapPanel1.add(engPiclabel); mapPanel1.setVisible(true);
	 * mapPanel.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * collectItnPanel.setVisible(true); }
	 * 
	 * if (outletID.equals("vm2")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/oconnormap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel2.add(engPiclabel);
	 * mapPanel2.setVisible(true); mapPanel.setVisible(false);
	 * mapPanel1.setVisible(false); mapPanel3.setVisible(false);
	 * mapPanel4.setVisible(false); mapPanel5.setVisible(false);
	 * mapPanel6.setVisible(false); collectItnPanel.setVisible(false); }
	 * 
	 * if (outletID.equals("vm3")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/kennamap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel3.add(engPiclabel);
	 * mapPanel3.setVisible(true); mapPanel.setVisible(false);
	 * mapPanel1.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel4.setVisible(false); mapPanel5.setVisible(false);
	 * mapPanel6.setVisible(false); collectItnPanel.setVisible(false); }
	 * 
	 * if (outletID.equals("c1")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/bensonmap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel4.add(engPiclabel);
	 * mapPanel.setVisible(false); mapPanel1.setVisible(false);
	 * mapPanel2.setVisible(false); mapPanel3.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * mapPanel4.setVisible(true); }
	 * 
	 * if (outletID.equals("c2")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/library.jpg")); JLabel engPiclabel = new JLabel(new
	 * ImageIcon(engPic)); engPiclabel.setPreferredSize(new Dimension(520,
	 * 515)); mapPanel5.add(engPiclabel); mapPanel5.setVisible(true);
	 * mapPanel.setVisible(false); mapPanel1.setVisible(false);
	 * mapPanel2.setVisible(false); mapPanel3.setVisible(false);
	 * mapPanel4.setVisible(false); mapPanel6.setVisible(false);
	 * 
	 * }
	 * 
	 * if (outletID.equals("fs1")) { BufferedImage engPic = ImageIO.read(new
	 * File( "src/images/mapImages/Artsciencemap.jpg")); JLabel engPiclabel =
	 * new JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel6.add(engPiclabel);
	 * mapPanel6.setVisible(true); mapPanel.setVisible(false);
	 * mapPanel1.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false);
	 * 
	 * }
	 * 
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * foodItemsPanel.remove(foodItemBtn[i]); } foodItemsPanel.repaint();
	 * foodItemsPanel.validate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * if (outletID == "vm1" || outletID == "fs1") { for (int i = 0; i <
	 * foodItemBtn.length; ++i) { foodItemsPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(selectHandler); } }
	 * 
	 * if(outletID == "c1" || outletID == "c2"){ for (int i = 0; i <
	 * foodItemBtn.length; ++i) { foodItemsPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(orderHandler); } }
	 * 
	 * if(outletID == "vm2" || outletID == "vm3"){ for (int i = 0; i <
	 * foodItemBtn.length; ++i) { foodItemBtn[i].setEnabled(false);
	 * foodItemsPanel.add(foodItemBtn[i]);
	 * //foodItemBtn[i].addActionListener(orderHandler); } }
	 * 
	 * foodItemsPanel.validate();
	 * 
	 * } catch (IOException ex) { JOptionPane.showMessageDialog(null,
	 * "Image problems"); ex.printStackTrace(); }
	 * 
	 * try { initializeValues(); SIHandler selectHandler = new SIHandler();
	 * OIHandler orderHandler = new OIHandler(); selectedOutlet = (FoodOutlet)
	 * outletMap.get(e .getActionCommand());
	 * 
	 * String outletID = selectedOutlet.getOutletID();
	 * 
	 * if (outletID.equals("vm1")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/Engineeringmap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515));
	 * 
	 * mapPanel1.add(engPiclabel); mapPanel1.setVisible(true);
	 * mapPanel.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * menuPanel.setVisible(false); leftPanel.setVisible(true);
	 * collectItnPanel.setVisible(true);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.remove(foodItemBtn[i]); foodItemsPanel.remove(foodItemBtn[i]);
	 * } foodItemsPanel.revalidate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * foodItemsPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(selectHandler); }
	 * foodItemsPanel.repaint(); // foodItemsPanel.validate(); }
	 * 
	 * if (outletID.equals("vm2")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/oconnormap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515));
	 * 
	 * mapPanel2.add(engPiclabel); mapPanel2.setVisible(true);
	 * mapPanel.setVisible(false); mapPanel1.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * menuPanel.setVisible(false); leftPanel.setVisible(true);
	 * collectItnPanel.setVisible(false);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.remove(foodItemBtn[i]); foodItemsPanel.remove(foodItemBtn[i]);
	 * } foodItemsPanel.revalidate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * //foodItemBtn[i].setEnabled(false); foodItemsPanel.add(foodItemBtn[i]);
	 * // foodItemBtn[i].addActionListener(orderHandler); }
	 * 
	 * foodItemsPanel.repaint(); //foodItemsPanel.validate(); }
	 * 
	 * if (outletID.equals("vm3")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/library.jpg")); JLabel engPiclabel = new JLabel(new
	 * ImageIcon(engPic)); engPiclabel.setPreferredSize(new Dimension(520,
	 * 515)); mapPanel3.add(engPiclabel); mapPanel3.setVisible(true);
	 * mapPanel.setVisible(false); mapPanel1.setVisible(false);
	 * mapPanel2.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * menuPanel.setVisible(false); leftPanel.setVisible(true);
	 * collectItnPanel.setVisible(false);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.remove(foodItemBtn[i]); foodItemsPanel.remove(foodItemBtn[i]);
	 * } //foodItemsPanel.repaint(); foodItemsPanel.revalidate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * //foodItemBtn[i].setEnabled(false); foodItemsPanel.add(foodItemBtn[i]);
	 * // foodItemBtn[i].addActionListener(orderHandler); }
	 * foodItemsPanel.repaint(); //foodItemsPanel.validate(); }
	 * 
	 * if (outletID.equals("c1")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/Artsciencemap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel4.add(engPiclabel);
	 * mapPanel.setVisible(false); mapPanel1.setVisible(false);
	 * mapPanel2.setVisible(false); mapPanel3.setVisible(false);
	 * mapPanel5.setVisible(false); mapPanel6.setVisible(false);
	 * mapPanel4.setVisible(true); leftPanel.setVisible(false);
	 * menuPanel.setVisible(true);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * foodItemsPanel.remove(foodItemBtn[i]); menuPanel.remove(foodItemBtn[i]);
	 * } menuPanel.revalidate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(orderHandler); } menuPanel.repaint();
	 * menuPanel.revalidate(); }
	 * 
	 * if (outletID.equals("c2")) {
	 * 
	 * BufferedImage engPic = ImageIO.read(new File(
	 * "src/images/mapImages/kennamap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel5.add(engPiclabel);
	 * mapPanel5.setVisible(true); mapPanel.setVisible(false);
	 * mapPanel1.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel6.setVisible(false); leftPanel.setVisible(false);
	 * menuPanel.setVisible(true);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * foodItemsPanel.remove(foodItemBtn[i]); menuPanel.remove(foodItemBtn[i]);
	 * 
	 * } menuPanel.revalidate();
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(orderHandler); } menuPanel.repaint();
	 * menuPanel.revalidate();
	 * 
	 * }
	 * 
	 * if (outletID.equals("fs1")) { BufferedImage engPic = ImageIO.read(new
	 * File( "src/images/mapImages/bensonmap.jpg")); JLabel engPiclabel = new
	 * JLabel(new ImageIcon(engPic)); engPiclabel.setPreferredSize(new
	 * Dimension(520, 515)); mapPanel6.add(engPiclabel);
	 * mapPanel6.setVisible(true); mapPanel.setVisible(false);
	 * mapPanel1.setVisible(false); mapPanel2.setVisible(false);
	 * mapPanel3.setVisible(false); mapPanel4.setVisible(false);
	 * mapPanel5.setVisible(false); leftPanel.setVisible(false);
	 * menuPanel.setVisible(true);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.remove(foodItemBtn[i]); foodItemsPanel.remove(foodItemBtn[i]);
	 * menuPanel.revalidate(); }
	 * 
	 * 
	 * foodItemList.clear(); readXML(xmlMap.get(outletID), foodItemList);
	 * 
	 * for (int i = 0; i < foodItemBtn.length; ++i) {
	 * menuPanel.add(foodItemBtn[i]);
	 * foodItemBtn[i].addActionListener(orderHandler); } menuPanel.repaint();
	 * menuPanel.revalidate();
	 * 
	 * }
	 * 
	 * } catch (IOException ex) { JOptionPane.showMessageDialog(null,
	 * "Image problems"); ex.printStackTrace(); } } }
	 */

	// This method read value from XML and inserts into the FoodItem object.
	private void readXML(String xmlLocation, List<FoodItems> itemList) {

		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(xmlLocation));
			StringBuilder strToolTip = new StringBuilder();

			FoodItems foodItem;
			String name, desc;
			double price;
			int id, qty, calories;

			// normalize text representation
			doc.getDocumentElement().normalize();
			String rootName = doc.getDocumentElement().getNodeName();

			NodeList foodNodeList = doc.getElementsByTagName("food_items");
			int len = foodNodeList.getLength();

			foodItemBtn = new JButton[len];
			Node nameNode;

			/*
			 * Vending Machine Menu
			 */
			if (rootName == "vm1" || rootName == "vm2" || rootName == "vm3") {

				for (int i = 0; i < len; i++) {

					foodItem = new FoodItems();
					strToolTip.setLength(0);
					strToolTip.append("<html>");
					nameNode = foodNodeList.item(i);

					if (nameNode.getNodeType() == Node.ELEMENT_NODE) {

						foodItemBtn[i] = new JButton();
						foodItem.setOutletId(rootName);

						Element nameElement = (Element) nameNode;
						NodeList nameList = nameElement
								.getElementsByTagName("name");
						Element namesElement = (Element) nameList.item(0);
						NodeList textNList = namesElement.getChildNodes();

						name = ((Node) textNList.item(0)).getNodeValue().trim();
						foodItem.setFoodName(name);

						strToolTip.append(" Name : " + name);
						strToolTip.append("<br>");

						Element idElement = (Element) nameNode;
						NodeList idList = idElement.getElementsByTagName("id");
						Element idsElement = (Element) idList.item(0);
						NodeList textIList = idsElement.getChildNodes();

						id = Integer.parseInt(((Node) textIList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodId(id);

						foodItemBtn[i].setActionCommand(rootName + id);

						strToolTip.append(" ID : " + id);
						strToolTip.append("<br>");

						NodeList descriptionList = nameElement
								.getElementsByTagName("description");
						Element descriptionElement = (Element) descriptionList
								.item(0);
						NodeList textDList = descriptionElement.getChildNodes();

						desc = ((Node) textDList.item(0)).getNodeValue().trim();
						foodItem.setFoodDesc(desc);

						strToolTip.append(" Desc : " + desc);
						strToolTip.append("<br>");

						NodeList priceList = nameElement
								.getElementsByTagName("price");
						Element priceElement = (Element) priceList.item(0);
						NodeList textPList = priceElement.getChildNodes();

						price = Double.parseDouble(((Node) textPList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodPrice(price);

						strToolTip.append(" Price : $" + price);
						strToolTip.append("<br>");

						NodeList calorieList = nameElement
								.getElementsByTagName("calories");
						Element caloriesElement = (Element) calorieList.item(0);
						NodeList textCList = caloriesElement.getChildNodes();

						calories = Integer.parseInt(((Node) textCList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodCalories(calories);

						strToolTip.append(" Calorie : " + calories);
						strToolTip.append("<br>");

						NodeList quantityList = nameElement
								.getElementsByTagName("quantity");
						Element quantitiesList = (Element) quantityList.item(0);
						NodeList textQList = quantitiesList.getChildNodes();

						qty = Integer.parseInt(((Node) textQList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodQty(qty);

						/*
						 * strToolTip.append(" Qty : " + qty);
						 * strToolTip.append("<br>");
						 */
						strToolTip.append("</html>");

						NodeList imageList = nameElement
								.getElementsByTagName("image");
						Element imagesElement = (Element) imageList.item(0);
						NodeList textImList = imagesElement.getChildNodes();

						ImageIcon image = new ImageIcon(
								((Node) textImList.item(0)).getNodeValue()
										.trim());
						foodItemBtn[i].setIcon(image);
						foodItemBtn[i].setBackground(Color.white);
						itemList.add(foodItem);
						foodItemBtn[i].setToolTipText(strToolTip.toString());
					}
				}
			}

			/*
			 * Food Store Menu
			 */
			if (rootName == "fs1") {

				for (int i = 0; i < len; i++) {
					foodItem = new FoodItems();
					strToolTip.setLength(0);
					strToolTip.append("<html>");
					nameNode = foodNodeList.item(i);

					if (nameNode.getNodeType() == Node.ELEMENT_NODE) {
						foodItemBtn[i] = new JButton();
						foodItem.setOutletId(rootName);

						Element nameElement = (Element) nameNode;
						NodeList nameList = nameElement
								.getElementsByTagName("name");
						Element namesElement = (Element) nameList.item(0);
						NodeList textNList = namesElement.getChildNodes();

						name = ((Node) textNList.item(0)).getNodeValue().trim();
						foodItem.setFoodName(name);

						strToolTip.append(" Name : " + name);
						strToolTip.append("<br>");

						NodeList descriptionList = nameElement
								.getElementsByTagName("description");
						Element descriptionElement = (Element) descriptionList
								.item(0);
						NodeList textDList = descriptionElement.getChildNodes();

						desc = ((Node) textDList.item(0)).getNodeValue().trim();
						foodItem.setFoodDesc(desc);

						strToolTip.append(" Desc : " + desc);
						strToolTip.append("<br>");

						NodeList idList = nameElement
								.getElementsByTagName("id");
						Element idsElement = (Element) idList.item(0);
						NodeList textIList = idsElement.getChildNodes();

						id = Integer.parseInt(((Node) textIList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodId(id);

						foodItemBtn[i].setActionCommand(rootName + id);

						strToolTip.append(" ID : " + id);
						strToolTip.append("<br>");

						NodeList priceList = nameElement
								.getElementsByTagName("price");
						Element priceElement = (Element) priceList.item(0);
						NodeList textPList = priceElement.getChildNodes();

						price = Double.parseDouble(((Node) textPList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodPrice(price);

						strToolTip.append(" Price : $" + price);
						strToolTip.append("<br>");

						NodeList calorieList = nameElement
								.getElementsByTagName("calories");
						Element caloriesElement = (Element) calorieList.item(0);
						NodeList textCList = caloriesElement.getChildNodes();

						calories = Integer.parseInt(((Node) textCList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodCalories(calories);

						strToolTip.append(" Calorie : " + calories);
						strToolTip.append("<br>");

						NodeList quantityList = nameElement
								.getElementsByTagName("quantity");
						Element quantitiesList = (Element) quantityList.item(0);
						NodeList textQList = quantitiesList.getChildNodes();

						qty = Integer.parseInt(((Node) textQList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodQty(qty);

						strToolTip.append(" Qty : " + qty);
						strToolTip.append("<br>");
						strToolTip.append("</html>");

						itemList.add(foodItem);
						foodItemBtn[i].setToolTipText(strToolTip.toString());
						foodItemBtn[i].setText(name);
						// foodItemBtn[i].setBackground(Color.white);
					}
				}
			}

			/*
			 * Cafe
			 */
			if (rootName == "c1" || rootName == "c2") {

				for (int i = 0; i < len; i++) {
					foodItem = new FoodItems();

					strToolTip.setLength(0);
					strToolTip.append("<html>");
					nameNode = foodNodeList.item(i);

					if (nameNode.getNodeType() == Node.ELEMENT_NODE) {
						foodItemBtn[i] = new JButton();
						foodItem.setOutletId(rootName);

						Element nameElement = (Element) nameNode;
						NodeList nameList = nameElement
								.getElementsByTagName("name");
						Element namesElement = (Element) nameList.item(0);
						NodeList textNList = namesElement.getChildNodes();

						name = ((Node) textNList.item(0)).getNodeValue().trim();
						foodItem.setFoodName(name);

						strToolTip.append(" Name : " + name);
						strToolTip.append("<br>");

						Element idElement = (Element) nameNode;
						NodeList idList = idElement.getElementsByTagName("id");
						Element idsElement = (Element) idList.item(0);
						NodeList textIList = idsElement.getChildNodes();

						id = Integer.parseInt(((Node) textIList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodId(id);

						foodItemBtn[i].setActionCommand(rootName + id);

						strToolTip.append(" ID : " + id);
						strToolTip.append("<br>");

						NodeList descriptionList = nameElement
								.getElementsByTagName("description");
						Element descriptionElement = (Element) descriptionList
								.item(0);
						NodeList textDList = descriptionElement.getChildNodes();

						desc = ((Node) textDList.item(0)).getNodeValue().trim();
						foodItem.setFoodDesc(desc);

						strToolTip.append(" Desc : " + desc);
						strToolTip.append("<br>");

						NodeList priceList = nameElement
								.getElementsByTagName("price");
						Element priceElement = (Element) priceList.item(0);
						NodeList textPList = priceElement.getChildNodes();

						price = Double.parseDouble(((Node) textPList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodPrice(price);

						strToolTip.append(" Price : $" + price);
						strToolTip.append("<br>");

						NodeList calorieList = nameElement
								.getElementsByTagName("calories");
						Element caloriesElement = (Element) calorieList.item(0);
						NodeList textCList = caloriesElement.getChildNodes();

						calories = Integer.parseInt(((Node) textCList.item(0))
								.getNodeValue().trim());
						foodItem.setFoodCalories(calories);

						strToolTip.append(" Calorie : " + calories);
						strToolTip.append("<br>");

						strToolTip.append("</html>");

						itemList.add(foodItem);
						foodItemBtn[i].setToolTipText(strToolTip.toString());
						foodItemBtn[i].setText(name);
					}
				}
			}

		} catch (SAXParseException err) {
			JOptionPane.showMessageDialog(null, "** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId() + " "
					+ err.getMessage());
		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	private void setOutletObject() {
		FoodOutlet[] foodOutlets = new FoodOutlet[6];

		foodOutlets[0] = new FoodOutlet("vm1", "Vending Machine 1",
				"Near to Bannan Engineering Dept.");
		foodOutlets[1] = new FoodOutlet("vm2", "Vending Machine 2",
				"Inside O'Connor Building.");
		foodOutlets[2] = new FoodOutlet("vm3", "Vending Machine 3",
				"Inside Kenna Hall.");
		foodOutlets[3] = new FoodOutlet("c1", "Bronchos", "Inside Benson Center.");
		foodOutlets[4] = new FoodOutlet("c2", "Sun Stream",
				"Inside Future Learning Commons and Library");
		foodOutlets[5] = new FoodOutlet("fs1", "Cellar Market",
				"Near to Art Science Building");

		vm1Button.setText("<html><em>" + foodOutlets[0].getOutletName()
				+ "</em></html>");
		vm2Button.setText("<html><em>" + foodOutlets[1].getOutletName()
				+ "</em></html>");
		vm3Button.setText("<html><em>" + foodOutlets[2].getOutletName()
				+ "</em></html>");
		vm1Button.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[0].getOutletAdd() + "</html>");
		vm2Button.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[1].getOutletAdd() + "</html>");
		vm3Button.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[2].getOutletAdd() + "</html>");

		c1Button.setText("<html><em>" + foodOutlets[3].getOutletName()
				+ "</em></html>");
		c1Button.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[3].getOutletAdd() + "</html>");

		c2Button.setText("<html><em>" + foodOutlets[4].getOutletName()
				+ "</em></html>");
		c2Button.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[4].getOutletAdd() + "</html>");

		fsButton.setText("<html><em>" + foodOutlets[5].getOutletName()
				+ "</em></html>");
		fsButton.setToolTipText("<html><b>Location:</b> "
				+ foodOutlets[5].getOutletAdd() + "</html>");

		for (int i = 0; i < foodOutlets.length; i++) {
			outletMap.put(foodOutlets[i].getOutletID(), foodOutlets[i]);
		}
	}

	private void initializeValues() {
		displayItemsLabel.setText("---------------------");
		displayTotalQty.setText("0");
		displayAmtLabel.setText("$ 0.0");
		dispTotCalLabel.setText("0");
		// displayChangeLabel.setText("$ 0.0");
		enterAmtText.setText("0.0");
		totalCalories = 0;
		totalAmount = 0.0;
		totalOrderedQty = 0;
		strOrderList = "";
		selItemId = 0;
		selOutletId = "";
		totalQty = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VendingMachine one = new VendingMachine();

	}

}
