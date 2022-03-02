package Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JulioL
 */
public class BlackJack extends Application {

    GamePlay game = new GamePlay();
    BorderPane mainB = new BorderPane();
    Pane backGround = new Pane();
    HBox user;
    HBox cpu;
    HBox toolBar = new HBox();
    Button startButton = new Button("Start");
    Button Hit = new Button("HIT");
    Label cpuScore = new Label("Dealer Score: ");
    Label userScore = new Label("User Score: ");
    Label cpuTag = new Label("DEALER ");
    Label userTag = new Label("USER");
    Button stayButton = new Button("STAY");
    Label winLoss = new Label();
    Button resetButton = new Button("Next Game");
    Button betButton = new Button("BET");
    HBox userControls = new HBox();
    Label betAmount = new Label();
    Spinner<Integer> oneSpinner = new Spinner<>();
    Spinner<Integer> fiveSpinner = new Spinner<>();
    Spinner<Integer> tenSpinner = new Spinner<>();
    Spinner<Integer> tfiveSpinner = new Spinner<>();
    Label oneChips = new Label("$1 Chips:");
    Label fiveChips = new Label("$5 Chips:");
    Label tenChips = new Label("$10 Chips:");
    Label tfiveChips = new Label("$25 Chips: ");
    Label totalMoney = new Label("Total: $");
    Button cashOut = new Button("Cash Out");
    Button distributeButton = new Button("Distribute Chips");
    Label firstRank = new Label("1st: ");
    Label secondRank = new Label("2nd: ");
    Label thirdRank = new Label("3rd: ");
    Label leaderBoard = new Label("Leaderboard\n"
            + "----------------");
    TextField leaderBoardName = new TextField();
    Label enterName = new Label("Enter Name: ");
    Label placeBet = new Label();
    String placeBetText = "Place Bet To Continue... ";
    Label gameOverLabel = new Label();

    ImageView back = new ImageView("/playing_cards_images/Back_of_Card.png");

    @Override
    public void start(Stage stage) throws Exception {

        //ToolBar
        resetButton.setDisable(true);
        toolBar.setSpacing(5);
        toolBar.getChildren().addAll(enterName, leaderBoardName, startButton);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setStyle("-fx-border-color: black");
        mainB.setTop(toolBar);

        //User Stats
        userControls.setStyle("-fx-border-color: black");
        userControls.setAlignment(Pos.CENTER);
        cashOut.setDisable(true);
        userControls.setSpacing(5);
        userControls.getChildren().addAll(Hit, stayButton, resetButton, cashOut);
        mainB.setBottom(userControls);

        //Hit button
        Hit.setLayoutX(640);
        Hit.setLayoutY(260);
        Hit.setDisable(true);

        //Stay Button
        stayButton.setLayoutX(680);
        stayButton.setLayoutY(260);
        stayButton.setDisable(true);

        //Reset Button
        resetButton.setAlignment(Pos.CENTER);

        //Betting Text Fields
        oneSpinner.setLayoutX(860);
        oneSpinner.setLayoutY(200);
        oneSpinner.setMaxWidth(80);

        fiveSpinner.setLayoutX(860);
        fiveSpinner.setLayoutY(240);
        fiveSpinner.setMaxWidth(80);

        tenSpinner.setLayoutX(860);
        tenSpinner.setLayoutY(280);
        tenSpinner.setMaxWidth(80);

        tfiveSpinner.setLayoutX(860);
        tfiveSpinner.setLayoutY(320);
        tfiveSpinner.setMaxWidth(80);

        //User Total Money
        totalMoney.setLayoutX(500);
        totalMoney.setLayoutY(430);

        //Betting Labels
        oneChips.setLayoutX(800);
        oneChips.setLayoutY(200);

        fiveChips.setLayoutX(800);
        fiveChips.setLayoutY(240);

        tenChips.setLayoutX(800);
        tenChips.setLayoutY(280);

        tfiveChips.setLayoutX(800);
        tfiveChips.setLayoutY(320);

        //Leader Board Labels
        leaderBoard.setLayoutX(970);
        leaderBoard.setLayoutY(200);

        firstRank.setLayoutX(970);
        firstRank.setLayoutY(230);

        secondRank.setLayoutX(970);
        secondRank.setLayoutY(250);

        thirdRank.setLayoutX(970);
        thirdRank.setLayoutY(270);

        //Place Bet Label
        placeBet.setLayoutX(440);
        placeBet.setLayoutY(200);

        placeBet.setFont(Font.font("Verdana", 20));
        
        //Game Over Label
        gameOverLabel.setLayoutX(480);
        gameOverLabel.setLayoutY(205);
        gameOverLabel.setFont(Font.font("Verdana", 20));

        //Bet Button
        betButton.setLayoutX(880);
        betButton.setLayoutY(380);

        //DistributeButton
        distributeButton.setLayoutX(850);
        distributeButton.setLayoutY(410);
        distributeButton.setDisable(true);

        //Deck Image
        back.setFitHeight(100);
        back.setFitWidth(90);
        back.setLayoutX(860);
        back.setLayoutY(80);

        //Labels (SCORE/NAME)
        cpuScore.setLayoutY(200);
        userScore.setLayoutY(230);

        userTag.setLayoutX(515);
        userTag.setLayoutY(410);

        cpuTag.setLayoutX(515);
        cpuTag.setLayoutY(30);

        //Label win/lost
        winLoss.setLayoutX(360);
        winLoss.setLayoutY(205);

        //Label Bet Amount
        betAmount.setLayoutX(800);
        betAmount.setLayoutY(360);
        betAmount.setText("Bet Amount: $0");

        //UserHBOX
        user = game.getUser().getHandImages();
        game.getUser().setUserHBox();

        //cpuHBOX
        cpu = game.getCpu().getHandImages();
        game.getCpu().setCpuHBox();

        //Add to Background
        backGround.getChildren().addAll(user, back, userScore, cpuScore,
                userTag, cpuTag, cpu, winLoss, placeBet, gameOverLabel,
                betButton, betAmount, oneChips, fiveChips, tenChips, tfiveChips,
                oneSpinner, fiveSpinner, tenSpinner, tfiveSpinner, totalMoney,
                distributeButton, leaderBoard, firstRank, secondRank, thirdRank);

        //Set Scene and Stage
        mainB.setCenter(backGround);
        mainB.setStyle("-fx-background-color: grey;");
        Scene mainScene = new Scene(mainB, 1100, 500);
        stage.setScene(mainScene);
        stage.show();

        //Actions for Buttons
        setOnAction();

        // Disable Betting Until Start Button Is Pressed
        disableBetting();

    }

    public void setOnAction() {
        startButton.setOnAction(e -> startGame());
        Hit.setOnAction(e -> userHit());
        stayButton.setOnAction(e -> userStay());
        resetButton.setOnAction(e -> reset());
        oneSpinner.setOnMousePressed(e -> updateBetAmountLabel());
        fiveSpinner.setOnMousePressed(e -> updateBetAmountLabel());
        tenSpinner.setOnMousePressed(e -> updateBetAmountLabel());
        tfiveSpinner.setOnMousePressed(e -> updateBetAmountLabel());
        betButton.setOnAction(e -> startPlay(oneSpinner.getValue(), fiveSpinner.getValue(),
                tenSpinner.getValue(), tfiveSpinner.getValue()));
        cashOut.setOnAction(e -> cashOutMoney());
    }

    public void startGame() {

        placeBet.setText(placeBetText);

        if (!leaderBoardName.getText().equals("")) {
            game.getUser().setName(leaderBoardName.getText());
            userTag.setText(leaderBoardName.getText());
            userScore.setText(game.getUser().getName() + "'s Score: ");
        }

        cpuScore.setText("Dealer Score: ");
        userScore.setText(game.getUser().getName() + "'s Score: ");

        leaderBoardName.setDisable(true);

        winLoss.setText("");

        startButton.setDisable(true);
        resetButton.setDisable(true);
        betAmount.setText("Bet Amount: $0");
        updateSpinner();
        enableBetting();
        disableHitStayButtons();
        updateTotalMoneyLabel();
        updateChipCount();
        updateRanks();
        cashOut.setDisable(true);

    }

    public void setHandStyles() {
        user.setStyle("-fx-padding: 20;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 2;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");

        cpu.setStyle("-fx-padding: 20;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 2;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
    }

    public void startPlay(int oneChips, int fiveChips, int tenChips, int tfiveChips) {

        setHandStyles();

        placeBet.setText("");
        cpuScore.setText("Dealer Score: N/A");
        game.dealCards();

        userScore.setText(game.getUser().getName() + "'s Score: " + game.getUser().getScore());

        game.userBet(oneChips, fiveChips, tenChips, tfiveChips);
        updateTotalMoneyLabel();
        updateChipCount();

        if (game.getUser().getScore() == 21) {
            Hit.setDisable(true);

        } else {
            Hit.setDisable(false);

        }
        stayButton.setDisable(false);

        disableBetting();
    }

    public void reset() {
        game.resetGame();
        startGame();
    }

    public void userHit() {
        game.hitUser();
        updateUserScore();
        if (game.over21(game.getUser())) {
            disableHitStayButtons();
            findWinner();
        } else if (game.getUser().getScore() == 21) {
            Hit.setDisable(true);
        }

    }

    public void userStay() {

        Hand user = game.getUser();
        Hand cpu = game.getCpu();

        if (user.getScore() != 21) {
            game.setCpuFirstCard();
            game.cpuHit();
            updateCpuScore();
        }

        findWinner();

        updateTotalMoneyLabel();

    }

    public void findWinner() {
        Hand winner = game.winner();
        cashOut.setDisable(false);
        if (winner == null) {
            winLoss.setText("\tDraw");
            game.drawPayout();
            disableHitStayButtons();
        } else {

            disableHitStayButtons();
            if (winner.getName().equals(game.getCpu().getName())) {
                winLoss.setText("Winner: " + game.getCpu().getName());
                

            } else {
                winLoss.setText("Winner: " + game.getUser().getName());
                game.regularPayout();
            }
        }
        
        gameOver();


    }

    public void gameOver() {
        Hand user = game.getUser();

        if (user.getOneChips() == 0 && user.getTenChips() == 0
                && user.getFiveChips() == 0 && user.getTfiveChips() == 0)
        {   
            resetButton.setDisable(true);
            cashOut.setDisable(true);
            gameOverLabel.setText("Game Over!");
        }else{
            resetButton.setDisable(false);
        }

    }

    public void disableHitStayButtons() {
        Hit.setDisable(true);
        stayButton.setDisable(true);

    }

    public void enableHitStayButton() {
        Hit.setDisable(false);
        stayButton.setDisable(false);
    }

    public void updateUserScore() {
        Hand userTemp = game.getUser();
        userScore.setText("User Score: " + userTemp.getScore());
    }

    public void updateCpuScore() {
        Hand cpuTemp = game.getCpu();
        cpuScore.setText("Dealer Score: " + cpuTemp.getScore());
    }

    public void updateSpinner() {
        Hand user = game.getUser();

        SpinnerValueFactory<Integer> one
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, user.getOneChips(), 0);

        oneSpinner.setValueFactory(one);

        SpinnerValueFactory<Integer> five
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, user.getFiveChips(), 0);

        fiveSpinner.setValueFactory(five);

        SpinnerValueFactory<Integer> ten
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, user.getTenChips(), 0);

        tenSpinner.setValueFactory(ten);

        SpinnerValueFactory<Integer> tfive
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, user.getTfiveChips(), 0);

        tfiveSpinner.setValueFactory(tfive);

    }

    public void updateTotalMoneyLabel() {
        Hand user = game.getUser();
        totalMoney.setText("Total: $" + user.getTotalMoney());
    }

    public void disableBetting() {
        oneSpinner.setDisable(true);
        tenSpinner.setDisable(true);
        fiveSpinner.setDisable(true);
        tfiveSpinner.setDisable(true);
        betButton.setDisable(true);
        distributeButton.setDisable(true);
    }

    public void enableBetting() {
        oneSpinner.setDisable(false);
        tenSpinner.setDisable(false);
        fiveSpinner.setDisable(false);
        tfiveSpinner.setDisable(false);
        betButton.setDisable(true);
        distributeButton.setDisable(false);
    }

    public void updateBetAmountLabel() {
        int total = 0;
        total += oneSpinner.getValue();
        total += fiveSpinner.getValue() * 5;
        total += tenSpinner.getValue() * 10;
        total += tfiveSpinner.getValue() * 25;
        betAmount.setText("Bet Amount: $" + total);

        if (total != 0) {
            betButton.setDisable(false);
        } else {
            betButton.setDisable(true);
        }

    }

    public void updateChipCount() {
        Hand user = game.getUser();
        oneChips.setText("$1 Chips:\n" + "       (" + user.getOneChips() + ") ");
        fiveChips.setText("$5 Chips:\n" + "       (" + user.getFiveChips() + ") ");
        tenChips.setText("$10 Chips:\n" + "       (" + user.getTenChips() + ") ");
        tfiveChips.setText("$25 Chips:\n" + "       (" + user.getTfiveChips() + ") ");
    }

    public void updateRanks() {

        Rank[] ranks = game.getTopThree();

        if (ranks[0] != null) {
            firstRank.setText("1st: " + ranks[0]);
        } else {
            firstRank.setText("1st: N/A");
        }

        if (ranks[1] != null) {
            secondRank.setText("2nd: " + ranks[1]);
        } else {
            secondRank.setText("2nd: N/A");
        }

        if (ranks[2] != null) {
            thirdRank.setText("3rd: " + ranks[2]);
        } else {
            thirdRank.setText("3rd: N/A");
        }

    }

    public void cashOutMoney() {
        Hand user = game.getUser();

        game.updateFileRankings(user.getName(), user.getTotalMoney());

        updateRanks();

        cashOut.setDisable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
