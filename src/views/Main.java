package views;

import exceptions.MovementException;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.characters.Hero;
import model.collectibles.Supply;
import model.characters.Direction;
import engine.Game;
import javafx.scene.layout.CornerRadii;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Medic;
import model.characters.Zombie;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.collectibles.Vaccine;

public class Main extends Application {
	StackPane zomPane;
	int zomRow;
	int zomCol;
	Button Zombie;
	int cellRow;
	int cellCol;
	Button b;
	int heroRow;
	int heroCol;
	Button hero;
	
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Game.loadHeroes("Heroes.csv");
  //  	 Load the logo image
         Image logo = new Image("gamelogo2.jpg");

        // Set the logo of the primary stage
        primaryStage.getIcons().add(logo);
        // Load the image
        // Get the screen size
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Image backgroundImage1 = new Image("1background.png");
        ImageView imageView = new ImageView(backgroundImage1);

        // Scale the image to fit the screen size
        imageView.setFitWidth(screenBounds.getWidth());
        imageView.setFitHeight(screenBounds.getHeight());
        
        
        primaryStage.setTitle("The Last of Us");
        //start screen
        Button start = new Button("Start");
        start.setStyle("-fx-background-color: transparent;;");
        start.setPrefSize(500, 500);
        StackPane layout = new StackPane();
        layout.getChildren().add(imageView);               
        layout.getChildren().add(start);               
        Scene scene = new Scene(layout, 1000, 600);
        StackPane.setAlignment(start, javafx.geometry.Pos.BOTTOM_CENTER);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        Button Joel = new Button();
        Joel.setPrefSize(275, 275);
        Joel.setStyle("-fx-background-color: transparent;;");
        Button Ellie = new Button();
        Ellie.setPrefSize(275, 275);
        Ellie.setStyle("-fx-background-color: transparent;;");
        Button Tess = new Button();
        Tess.setPrefSize(275, 275);
        Tess.setStyle("-fx-background-color: transparent;;");
        Button Riley = new Button();
        Riley.setPrefSize(275, 275);
        Riley.setStyle("-fx-background-color: transparent;;");
        Button Tommy = new Button();
        Tommy.setPrefSize(275, 275);
        Tommy.setStyle("-fx-background-color: transparent;;");
        Button Bill = new Button();
        Bill.setPrefSize(275, 275);
        Bill.setStyle("-fx-background-color: transparent;;");
        Button David = new Button();
        David.setPrefSize(275, 275);
        David.setStyle("-fx-background-color: transparent;;");
        Button Henry = new Button();
        Henry.setPrefSize(275, 275);
        Henry.setStyle("-fx-background-color: transparent;;");
        GridPane characterGrid = new GridPane();
        characterGrid.setHgap(200);
        characterGrid.setVgap(200);
        characterGrid.addRow(0, Joel, Ellie, Tess, Riley);
        characterGrid.addRow(1, Tommy, Bill, David, Henry);
        characterGrid.setAlignment(Pos.CENTER);

    	StackPane layout2= new StackPane();
        start.setOnMouseClicked(clickOnStart -> {
            //put character background image here
            Image backgroundImage2 = new Image("characterbackground.png");
            ImageView characterbackground = new ImageView(backgroundImage2);
            characterbackground.setMouseTransparent(true); // This line makes the image transparent to mouse events
            characterbackground.toBack();
           // Scale the image to fit the screen size
            characterbackground.setFitWidth(screenBounds.getWidth());
            characterbackground.setFitHeight(screenBounds.getHeight());
            //add back the background
            layout2.getChildren().addAll(characterGrid,characterbackground);
            Scene characterScene = new Scene(layout2, 1000, 600);
            primaryStage.setScene(characterScene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });
    

      //move buttons
        Button null1=new Button();
        null1.setPrefSize(150, 100);
        null1.setStyle("-fx-background-color: transparent;;");
        Button null2=new Button();
        null2.setPrefSize(150, 100);
        null2.setStyle("-fx-background-color: transparent;;");
        Button null3=new Button();
        null3.setPrefSize(150, 100);
        null3.setStyle("-fx-background-color: transparent;;");
        Button null4=new Button();
        null4.setPrefSize(150, 100);
        null4.setStyle("-fx-background-color: transparent;;");
        Button null5=new Button();
        null5.setPrefSize(150, 100);
        null5.setStyle("-fx-background-color: transparent;;");
        Button null6=new Button();
        null6.setPrefSize(150, 100);
        null6.setStyle("-fx-background-color: transparent;;");
        Button null7=new Button();
        null7.setPrefSize(150, 100);
        null7.setStyle("-fx-background-color: transparent;;");
        Button null8=new Button();
        null8.setPrefSize(150, 100);
        null8.setStyle("-fx-background-color: transparent;;");
        Button null9=new Button();
        null9.setPrefSize(150, 100);
        null9.setStyle("-fx-background-color: transparent;;");
        Button up = new Button();//move(RIGHT)
        Image image1 = new Image("UP.png");
		   ImageView image2 = new ImageView(image1);
		   image2.setFitWidth(100);
		   image2.setFitHeight(100);
		   up.setPrefWidth(100);
		   up.setPrefHeight(100);
		   up.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   up.setGraphic(image2);
        Button down = new Button();//move(LEFT)  each time you move you should update map
        Image image3 = new Image("DOWN.png");
		   ImageView image4 = new ImageView(image3);
		   image4.setFitWidth(100);
		   image4.setFitHeight(100);
		   down.setPrefWidth(100);
		   down.setPrefHeight(100);
		   down.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   down.setGraphic(image4);
        Button left = new Button();//move(DOWN)
        Image image5 = new Image("LEFT.png");
		   ImageView image6 = new ImageView(image5);
		   image6.setFitWidth(100);
		   image6.setFitHeight(100);
		   left.setPrefWidth(100);
		   left.setPrefHeight(100);
		   left.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   left.setGraphic(image6);
        Button right = new Button();//move(UP)
        Image image7 = new Image("RIGHT.png");
		   ImageView image8 = new ImageView(image7);
		   image8.setFitWidth(100);
		   image8.setFitHeight(100);
		   right.setPrefWidth(100);
		   right.setPrefHeight(100);
		   right.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   right.setGraphic(image8);
        Button cure = new Button();//only if medic else throw exception you pick your target first
            Image image9 = new Image("VACCINE.png");
		   ImageView image10 = new ImageView(image9);
		   image10.setFitWidth(100);
		   image10.setFitHeight(100);
		   cure.setPrefWidth(100);
		   cure.setPrefHeight(100);
		   cure.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   cure.setGraphic(image10);
        cure.setPrefSize(150, 100);
        Button attack = new Button();//click on the hero you want to attack then click on the target 
        Image image11 = new Image("ATTACK.png");
		   ImageView image12= new ImageView(image11);
		   image12.setFitWidth(100);
		   image12.setFitHeight(100);
		   attack.setPrefWidth(100);
		   attack.setPrefHeight(100);
		   attack.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   attack.setGraphic(image12);
        Button specialAction = new Button();//click on the hero you want then click on the target if needed
        Image image13 = new Image("SPECIAL ACTION.png");
		   ImageView image14= new ImageView(image13);
		   image14.setFitWidth(100);
		   image14.setFitHeight(100);
		   specialAction.setPrefWidth(100);
		   specialAction.setPrefHeight(100);
		   specialAction.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   specialAction.setGraphic(image14);
        Button EndTurn = new Button();//when clicked on we call endturn
        Image image15 = new Image("END TURN.png");
		   ImageView image16= new ImageView(image15);
		   image16.setFitWidth(100);
		   image16.setFitHeight(50);
		   EndTurn.setPrefWidth(100);
		   EndTurn.setPrefHeight(50);
		   EndTurn.setStyle("-fx-background-color: transparent; -fx-text-fill: WHITE;");
		   EndTurn.setGraphic(image16);
		   
		Image imageMapBackground = new Image("MAP BACKGROUND.png");
		ImageView imageMapBackground2 = new ImageView(imageMapBackground);
		imageView.setFitWidth(screenBounds.getWidth());
        imageView.setFitHeight(screenBounds.getHeight());
		        
//        //picking the hero & start button
    	Button play = new Button();
        Joel.setOnMouseClicked(chooseJoel -> {
        	play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(0);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playJoel -> {            
                //map        
                  // Create the GridPane layout                   
              	  BorderPane  map = new BorderPane ();
              	  map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();                                     
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show();                 
                  }); 
         
        });

        Ellie.setOnMouseClicked(chooseEllie -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(1);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playEllie -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
                  map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show();                 
                  });
        });
         
        
        Tess.setOnMouseClicked(chooseTess -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            //play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(2);
            Game.startGame(selectedHero);
            
            play.setOnMouseClicked(playTess -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show();  
              });
        });
        
        Riley.setOnMouseClicked(chooseRiley -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(3);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playRiley -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show(); 
        });
        
        });
        Tommy.setOnMouseClicked(chooseTommy -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(4);
            Game.startGame(selectedHero);
            
            play.setOnMouseClicked(playTommy -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show(); 
              });
        });
       
        Bill.setOnMouseClicked(chooseBill -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(5);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playBill -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show(); 
              });
        });
                David.setOnMouseClicked(chooseDavid -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(6);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playDavid -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show(); 
              });
        });
        
        Henry.setOnMouseClicked(chooseHenry -> {
            play.setPrefSize(400, 100);
            StackPane.setAlignment(play, javafx.geometry.Pos.BOTTOM_RIGHT);
            play.setStyle("-fx-background-color: transparent;;");
            layout2.getChildren().addAll(play);
            Hero selectedHero = Game.availableHeroes.get(7);
            Game.startGame(selectedHero); 
            
            play.setOnMouseClicked(playHenry -> {            
                //map        
                  // Create the GridPane layout                   
              	BorderPane  map = new BorderPane ();
              	map.getChildren().add(imageMapBackground2);
                  GridPane mapUI = new GridPane();
                  GridPane directions = new GridPane();
                  map.setCenter(mapUI);
                  directions.addRow(0,null1,up,null2);
                  directions.addRow(1,left,null3,right);
                  directions.addRow(2,null4,down,null5);
                  directions.addRow(3,null8);
                  directions.addRow(4,attack,cure,specialAction);
                  directions.addRow(5,null9);
                  directions.addRow(6,null6,EndTurn,null7);
                  map.setRight(directions);
                  mapUI.setHgap(1);
                  mapUI.setVgap(1); 
                  // Set the colour of the cells based on the presence of the hero
                  updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                  updateCharacterDetails(map);
                  mapUI.setScaleY(-1);
                  Scene mapScene = new Scene(map,500,600);
                  primaryStage.setScene(mapScene);
                  primaryStage.setFullScreen(true);
                  primaryStage.show(); 
              }); 
        });
        
    }


    //put button with rectangle and text so that you can press of zombies and heros
    private void updateMap(GridPane mapUI, BorderPane map,Button up, Button down, Button left, Button right, Button cure, Button specialAction, Button EndTurn, Button attack,Stage primaryStage) 
    {
    	if(Game.checkWin()){
    		Image x1 = new Image("YOU WON.png");
    	    ImageView x2 = new ImageView(x1);
    	    StackPane x3 = new StackPane(x2);
    		//Button win = new Button("Win");
    	    Scene winScene = new Scene(x3,1000, 600);
            primaryStage.setScene(winScene);
            primaryStage.setFullScreen(true);
            primaryStage.show();    
            return;
        	}
    	else if(Game.checkGameOver()){
    		Image x4 = new Image("GAME OVER.png");
    	    ImageView x5 = new ImageView(x4);
    	    StackPane x6 = new StackPane(x5);
    		//Button lose = new Button("lose");
    	    Scene loseScene = new Scene(x6, 1000, 600);
            primaryStage.setScene(loseScene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
            return;
        }
    	else if(!(mapUI.getChildren().isEmpty())){
    		mapUI.getChildren().clear();
    	}
    	//try putting a button on the hero maybe attack will work
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
            	if(Game.map[row][col].isVisible()==true) {
            		if(Game.map[row][col] instanceof CharacterCell){
            			if(((CharacterCell) Game.map[row][col]).getCharacter() instanceof Hero) {
                			Rectangle rect = new Rectangle(65, 65, Color.DARKCYAN);
                			Text text = new Text(((CharacterCell)Game.map[row][col]).getCharacter().getName()); // create a new text node with some text
                			text.setFill(Color.WHITE); // set the fill color of the text to WHITE               			
                			text.setFont(Font.font("Arial", FontWeight.BOLD, 10)); // set the font of the text
                			hero = new Button();
                			hero.setPrefSize(65, 65);
                			hero.setPrefWidth(row);
                			hero.setPrefHeight(col);
                	        hero.setStyle("-fx-background-color: transparent;;");
                			StackPane stackPane = new StackPane(rect, text, hero); // create a new StackPane with the rectangle and text nodes
                            stackPane.setScaleY(-1);
                			final int finalRow = row;
    						final int finalCol = col;
    						final int finalRowUp = row+1;
    						final int finalRowDown = row-1;
    						final int finalColLeft = col-1;
    						final int finalColRight = col+1;
                			hero.setOnMouseClicked(Actions -> {
                            up.setOnMouseClicked(upButton -> {
//        						    if (Game.map[finalRowUp][finalCol] instanceof TrapCell) {
//        						    Label trapMessage = new Label("You've walked into a trap!");
//        						    Font font=Font.font("Impact",FontWeight.BOLD,22);
//        						    trapMessage.setTextFill(Color.WHITE); 
//        						    trapMessage.setFont(font);
//        						    trapMessage.setVisible(true);
//
//        						    // Create a new AnimationTimer with a startTime of -1
//        						    AnimationTimer timer = new AnimationTimer() {
//        						        private long startTime = -1;
//
//        						        @Override
//        						        public void handle(long now) {
//        						            if (startTime == -1) {
//        						                startTime = now;
//        						            }
//        						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
//        						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
//        						                // Hide the label and stop the timer
//        						                trapMessage.setVisible(false);
//        						                stop();
//        						            }
//        						        }
//        						    };
//
//        						    // Set the trap message label as the top node of the BorderPane
//        						    map.setTop(trapMessage);
//
//        						    // Start the timer
//        						    timer.start();
//        						}
                					try {
										((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).move(Direction.RIGHT);										
                					}catch (NotEnoughActionsException y) {
                						Label tiredMessage = new Label("try again next turn.");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    tiredMessage.setTextFill(Color.WHITE); 
            						    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                            													
									}catch (MovementException x) {
										Label outOfBoundsMessage = new Label("Try moving in a different direction.");
										Font font=Font.font("Impact",FontWeight.BOLD,22);
										outOfBoundsMessage.setTextFill(Color.WHITE); 
            						    outOfBoundsMessage.setFont(font);
            						    outOfBoundsMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	outOfBoundsMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };
            						    

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(outOfBoundsMessage);

            						    // Start the timer
            						    timer.start();
								    }
        						    if (Game.map[finalRow][finalColRight] instanceof TrapCell) {
        						    Label trapMessage = new Label("You've walked into a trap!");
        						    Font font=Font.font("Impact",FontWeight.BOLD,22);
        						    trapMessage.setTextFill(Color.WHITE); 
        						    trapMessage.setFont(font);
        						    trapMessage.setVisible(true);

        						    // Create a new AnimationTimer with a startTime of -1
        						    AnimationTimer timer = new AnimationTimer() {
        						        private long startTime = -1;

        						        @Override
        						        public void handle(long now) {
        						            if (startTime == -1) {
        						                startTime = now;
        						            }
        						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
        						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
        						                // Hide the label and stop the timer
        						                trapMessage.setVisible(false);
        						                stop();
        						            }
        						        }
        						    };

        						    // Set the trap message label as the top node of the BorderPane
        						    map.setTop(trapMessage);

        						    // Start the timer
        						    timer.start();
        						}
                					
                                    updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                        			updateCharacterDetails(map);

                    			});
                				
                				down.setOnMouseClicked(downButton -> {
//               					        if (Game.map[finalRowDown][finalCol] instanceof TrapCell) {
//            						    Label trapMessage = new Label("You've walked into a trap!");
//            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
//            						    trapMessage.setTextFill(Color.WHITE); 
//            						    trapMessage.setFont(font);
//            						    trapMessage.setVisible(true);
//
//            						    // Create a new AnimationTimer with a startTime of -1
//            						    AnimationTimer timer = new AnimationTimer() {
//            						        private long startTime = -1;
//
//            						        @Override
//            						        public void handle(long now) {
//            						            if (startTime == -1) {
//            						                startTime = now;
//            						            }
//            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
//            						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
//            						                // Hide the label and stop the timer
//            						                trapMessage.setVisible(false);
//            						                stop();
//            						            }
//            						        }
//            						    };
//
//            						    // Set the trap message label as the top node of the BorderPane
//            						    map.setTop(trapMessage);
//
//            						    // Start the timer
//            						    timer.start();
//            						}
                					
                					try {

										((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).move(Direction.LEFT);
										
                					}
                					catch (NotEnoughActionsException y) {
                						Label tiredMessage = new Label("try again next turn.");
                						Font font=Font.font("Impact",FontWeight.BOLD,22);
                						tiredMessage.setTextFill(Color.WHITE); 
										tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                            													
									}
                					catch (MovementException x) {
										Label outOfBoundsMessage = new Label("Try moving in a different direction.");
										Font font=Font.font("Impact",FontWeight.BOLD,22);
										outOfBoundsMessage.setTextFill(Color.WHITE); 
	        						    outOfBoundsMessage.setFont(font);
            						    outOfBoundsMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	outOfBoundsMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };
            						    

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(outOfBoundsMessage);

            						    // Start the timer
            						    timer.start();
								    }
           					        if (Game.map[finalRow][finalColLeft] instanceof TrapCell) {
        						    Label trapMessage = new Label("You've walked into a trap!");
        						    Font font=Font.font("Impact",FontWeight.BOLD,22);
        						    trapMessage.setTextFill(Color.WHITE); 
        						    trapMessage.setFont(font);
        						    trapMessage.setVisible(true);

        						    // Create a new AnimationTimer with a startTime of -1
        						    AnimationTimer timer = new AnimationTimer() {
        						        private long startTime = -1;

        						        @Override
        						        public void handle(long now) {
        						            if (startTime == -1) {
        						                startTime = now;
        						            }
        						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
        						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
        						                // Hide the label and stop the timer
        						                trapMessage.setVisible(false);
        						                stop();
        						            }
        						        }
        						    };

        						    // Set the trap message label as the top node of the BorderPane
        						    map.setTop(trapMessage);

        						    // Start the timer
        						    timer.start();
        						}
                                    updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);

});
                				left.setOnMouseClicked(leftButton -> {
//                                	if (Game.map[finalRow][finalColLeft] instanceof TrapCell) {
//            						    Label trapMessage = new Label("You've walked into a trap!");
//            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
//            						    trapMessage.setTextFill(Color.WHITE); 
//										trapMessage.setFont(font);
//            						    trapMessage.setVisible(true);
//
//            						    // Create a new AnimationTimer with a startTime of -1
//            						    AnimationTimer timer = new AnimationTimer() {
//            						        private long startTime = -1;
//
//            						        @Override
//            						        public void handle(long now) {
//            						            if (startTime == -1) {
//            						                startTime = now;
//            						            }
//            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
//            						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
//            						                // Hide the label and stop the timer
//            						                trapMessage.setVisible(false);
//            						                stop();
//            						            }
//            						        }
//            						    };
//
//            						    // Set the trap message label as the top node of the BorderPane
//            						    map.setTop(trapMessage);
//
//            						    // Start the timer
//            						    timer.start();
//            						}
                					try {

										((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).move(Direction.DOWN);
										
                					}catch (NotEnoughActionsException y) {
                						Label tiredMessage = new Label("try again next turn.");
                						Font font=Font.font("Impact",FontWeight.BOLD,22);
                						tiredMessage.setTextFill(Color.WHITE); 
             						    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                            													
									}catch (MovementException x) {
										Label outOfBoundsMessage = new Label("Try moving in a different direction.");
										Font font=Font.font("Impact",FontWeight.BOLD,22);
										outOfBoundsMessage.setTextFill(Color.WHITE); 
            						    outOfBoundsMessage.setFont(font);
            						    outOfBoundsMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	outOfBoundsMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };
            						    

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(outOfBoundsMessage);

            						    // Start the timer
            						    timer.start();
								    }
                                	if (Game.map[finalRowDown][finalCol] instanceof TrapCell) {
            						    Label trapMessage = new Label("You've walked into a trap!");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    trapMessage.setTextFill(Color.WHITE); 
										trapMessage.setFont(font);
            						    trapMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						                trapMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(trapMessage);

            						    // Start the timer
            						    timer.start();
            						}
                                    updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);

                    			});
                				right.setOnMouseClicked(rightButton -> {
//                                	if (Game.map[finalRow][finalColRight] instanceof TrapCell) {
//            						    Label trapMessage = new Label("You've walked into a trap!");
//            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
//            						    trapMessage.setTextFill(Color.WHITE); 
//										trapMessage.setFont(font);
//            						    trapMessage.setVisible(true);
//
//            						    // Create a new AnimationTimer with a startTime of -1
//            						    AnimationTimer timer = new AnimationTimer() {
//            						        private long startTime = -1;
//
//            						        @Override
//            						        public void handle(long now) {
//            						            if (startTime == -1) {
//            						                startTime = now;
//            						            }
//            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
//            						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
//            						                // Hide the label and stop the timer
//            						                trapMessage.setVisible(false);
//            						                stop();
//            						            }
//            						        }
//            						    };
//
//            						    // Set the trap message label as the top node of the BorderPane
//            						    map.setTop(trapMessage);
//
//            						    // Start the timer
//            						    timer.start();
//            						}
                					try {

										((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).move(Direction.UP);
										
                					}
                					catch (NotEnoughActionsException y) {
                						Label tiredMessage = new Label("try again next turn.");
                						Font font=Font.font("Impact",FontWeight.BOLD,22);
                						tiredMessage.setTextFill(Color.WHITE); 
            						    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                            													
									}catch (MovementException x) {
										Label outOfBoundsMessage = new Label("Try moving in a different direction.");
										Font font=Font.font("Impact",FontWeight.BOLD,22);
										outOfBoundsMessage.setTextFill(Color.WHITE); 
                						outOfBoundsMessage.setFont(font);
            						    outOfBoundsMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	outOfBoundsMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };
            						    

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(outOfBoundsMessage);

            						    // Start the timer
            						    timer.start();
								    }
                					
                                	if (Game.map[finalRowUp][finalCol] instanceof TrapCell) {
            						    Label trapMessage = new Label("You've walked into a trap!");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    trapMessage.setTextFill(Color.WHITE); 
										trapMessage.setFont(font);
            						    trapMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 5000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						                trapMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(trapMessage);

            						    // Start the timer
            						    timer.start();
            						}
                                    updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);

                    			});
                				attack.setOnMouseClicked(attackButton -> {
                					//add label that tells them to attack zombie
                						Zombie.setOnMouseClicked(defender -> {
                				            ((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().setTarget(((CharacterCell)Game.map[zomRow][zomCol]).getCharacter());
                				            try {
												((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().attack();
											} catch (NotEnoughActionsException a) {
												Label tiredMessage = new Label("try again next turn.");
												Font font=Font.font("Impact",FontWeight.BOLD,22);
												tiredMessage.setTextFill(Color.WHITE);		       
												tiredMessage.setFont(font);
												tiredMessage.setVisible(true);

		            						    // Create a new AnimationTimer with a startTime of -1
		            						    AnimationTimer timer = new AnimationTimer() {
		            						        private long startTime = -1;

		            						        @Override
		            						        public void handle(long now) {
		            						            if (startTime == -1) {
		            						                startTime = now;
		            						            }
		            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
		            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
		            						                // Hide the label and stop the timer
		            						            	tiredMessage.setVisible(false);
		            						                stop();
		            						            }
		            						        }
		            						    };

		            						    // Set the trap message label as the top node of the BorderPane
		            						    map.setTop(tiredMessage);

		            						    // Start the timer
		            						    timer.start();
											}
                				            catch (InvalidTargetException b) {
                				            	Label attackAnotherHeroMessage = new Label("Try attacking something else.");
                				            	Font font=Font.font("Impact",FontWeight.BOLD,22);
												attackAnotherHeroMessage.setTextFill(Color.WHITE);	
												attackAnotherHeroMessage.setFont(font);
                    						    attackAnotherHeroMessage.setVisible(true);

                    						    // Create a new AnimationTimer with a startTime of -1
                    						    AnimationTimer timer = new AnimationTimer() {
                    						        private long startTime = -1;

                    						        @Override
                    						        public void handle(long now) {
                    						            if (startTime == -1) {
                    						                startTime = now;
                    						            }
                    						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                    						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                    						                // Hide the label and stop the timer
                    						            	attackAnotherHeroMessage.setVisible(false);
                    						                stop();
                    						            }
                    						        }
                    						    };

                    						    // Set the trap message label as the top node of the BorderPane
                    						    map.setTop(attackAnotherHeroMessage);

                    						    // Start the timer
                    						    timer.start();
											}

                				            updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                            updateCharacterDetails(map);

                					});
                						
                						hero.setOnMouseClicked(defender -> {
                							int xwidth = (int) hero.getPrefWidth();
                							int ywidth = (int) hero.getPrefHeight();
                							((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().setTarget(((CharacterCell)Game.map[xwidth][ywidth]).getCharacter());
                				            try {
												((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().attack();
											} catch (NotEnoughActionsException a) {
												Label tiredMessage = new Label("try again next turn.");
												Font font=Font.font("Impact",FontWeight.BOLD,22);
												tiredMessage.setTextFill(Color.WHITE);
												tiredMessage.setFont(font);
		            						    tiredMessage.setVisible(true);

		            						    // Create a new AnimationTimer with a startTime of -1
		            						    AnimationTimer timer = new AnimationTimer() {
		            						        private long startTime = -1;

		            						        @Override
		            						        public void handle(long now) {
		            						            if (startTime == -1) {
		            						                startTime = now;
		            						            }
		            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
		            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
		            						                // Hide the label and stop the timer
		            						            	tiredMessage.setVisible(false);
		            						                stop();
		            						            }
		            						        }
		            						    };

		            						    // Set the trap message label as the top node of the BorderPane
		            						    map.setTop(tiredMessage);

		            						    // Start the timer
		            						    timer.start();
											}
                				            catch (InvalidTargetException b) {
                				            	Label attackAnotherHeroMessage = new Label("Try attacking something else.");
                				            	Font font=Font.font("Impact",FontWeight.BOLD,22);
                				            	attackAnotherHeroMessage.setTextFill(Color.WHITE);
												attackAnotherHeroMessage.setFont(font);
                    						    attackAnotherHeroMessage.setVisible(true);

                    						    // Create a new AnimationTimer with a startTime of -1
                    						    AnimationTimer timer = new AnimationTimer() {
                    						        private long startTime = -1;

                    						        @Override
                    						        public void handle(long now) {
                    						            if (startTime == -1) {
                    						                startTime = now;
                    						            }
                    						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                    						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                    						                // Hide the label and stop the timer
                    						            	attackAnotherHeroMessage.setVisible(false);
                    						                stop();
                    						            }
                    						        }
                    						    };

                    						    // Set the trap message label as the top node of the BorderPane
                    						    map.setTop(attackAnotherHeroMessage);

                    						    // Start the timer
                    						    timer.start();
											}

                				            updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                            updateCharacterDetails(map);

                						});
                						
                						b.setOnMouseClicked(defender -> {
                							int x = (int) b.getPrefWidth();
                							int y = (int) b.getPrefHeight();
                							((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().setTarget(((CharacterCell)Game.map[x][y]).getCharacter());
                				            try {
												((CharacterCell)Game.map[finalRow][finalCol]).getCharacter().attack();
											} catch (NotEnoughActionsException a) {
												Label tiredMessage = new Label("try again next turn.");
												Font font=Font.font("Impact",FontWeight.BOLD,22);
												tiredMessage.setTextFill(Color.WHITE);
												tiredMessage.setFont(font);
		            						    tiredMessage.setVisible(true);

		            						    // Create a new AnimationTimer with a startTime of -1
		            						    AnimationTimer timer = new AnimationTimer() {
		            						        private long startTime = -1;

		            						        @Override
		            						        public void handle(long now) {
		            						            if (startTime == -1) {
		            						                startTime = now;
		            						            }
		            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
		            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
		            						                // Hide the label and stop the timer
		            						            	tiredMessage.setVisible(false);
		            						                stop();
		            						            }
		            						        }
		            						    };

		            						    // Set the trap message label as the top node of the BorderPane
		            						    map.setTop(tiredMessage);

		            						    // Start the timer
		            						    timer.start();
											}
                				            catch (InvalidTargetException b) {
                				            	Label attackAnotherHeroMessage = new Label("Try attacking something else.");
                				            	Font font=Font.font("Impact",FontWeight.BOLD,22);
                				            	attackAnotherHeroMessage.setTextFill(Color.WHITE);
												attackAnotherHeroMessage.setFont(font);
                    						    attackAnotherHeroMessage.setVisible(true);

                    						    // Create a new AnimationTimer with a startTime of -1
                    						    AnimationTimer timer = new AnimationTimer() {
                    						        private long startTime = -1;

                    						        @Override
                    						        public void handle(long now) {
                    						            if (startTime == -1) {
                    						                startTime = now;
                    						            }
                    						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                    						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                    						                // Hide the label and stop the timer
                    						            	attackAnotherHeroMessage.setVisible(false);
                    						                stop();
                    						            }
                    						        }
                    						    };

                    						    // Set the trap message label as the top node of the BorderPane
                    						    map.setTop(attackAnotherHeroMessage);

                    						    // Start the timer
                    						    timer.start();
											}

                				            updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                            updateCharacterDetails(map);

                						});
                    				
                    			});
                				cure.setOnMouseClicked(cureButton -> {
                					Zombie.setOnMouseClicked(cured -> {
            				            (((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).setTarget(((CharacterCell)Game.map[zomRow][zomCol]).getCharacter());           				           
												try {
													((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).cure();
												} catch (NotEnoughActionsException c) {
													Label tiredMessage = new Label("try again next turn.");
													Font font=Font.font("Impact",FontWeight.BOLD,22);
													tiredMessage.setTextFill(Color.WHITE);
	                				            	tiredMessage.setFont(font);
			            						    tiredMessage.setVisible(true);

			            						    // Create a new AnimationTimer with a startTime of -1
			            						    AnimationTimer timer = new AnimationTimer() {
			            						        private long startTime = -1;

			            						        @Override
			            						        public void handle(long now) {
			            						            if (startTime == -1) {
			            						                startTime = now;
			            						            }
			            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
			            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
			            						                // Hide the label and stop the timer
			            						            	tiredMessage.setVisible(false);
			            						                stop();
			            						            }
			            						        }
			            						    };

			            						    // Set the trap message label as the top node of the BorderPane
			            						    map.setTop(tiredMessage);

			            						    // Start the timer
			            						    timer.start();
												}											
            				            catch(NoAvailableResourcesException d){
            				            	Label tiredMessage = new Label("try getting some vaccines first.");
            				            	Font font=Font.font("Impact",FontWeight.BOLD,22);
											tiredMessage.setTextFill(Color.WHITE);
                						    tiredMessage.setFont(font);
                						    tiredMessage.setVisible(true);

                						    // Create a new AnimationTimer with a startTime of -1
                						    AnimationTimer timer = new AnimationTimer() {
                						        private long startTime = -1;

                						        @Override
                						        public void handle(long now) {
                						            if (startTime == -1) {
                						                startTime = now;
                						            }
                						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                						                // Hide the label and stop the timer
                						            	tiredMessage.setVisible(false);
                						                stop();
                						            }
                						        }
                						    };

                						    // Set the trap message label as the top node of the BorderPane
                						    map.setTop(tiredMessage);

                						    // Start the timer
                						    timer.start();
            				            }
            				            	catch(InvalidTargetException e){
            				            	    Label attackAnotherHeroMessage = new Label("Try curing something else.");
            				            	    Font font=Font.font("Impact",FontWeight.BOLD,22);
            				            	    attackAnotherHeroMessage.setTextFill(Color.WHITE);
                    						    attackAnotherHeroMessage.setFont(font);
                    						    attackAnotherHeroMessage.setVisible(true);

                    						    // Create a new AnimationTimer with a startTime of -1
                    						    AnimationTimer timer = new AnimationTimer() {
                    						        private long startTime = -1;

                    						        @Override
                    						        public void handle(long now) {
                    						            if (startTime == -1) {
                    						                startTime = now;
                    						            }
                    						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                    						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                    						                // Hide the label and stop the timer
                    						            	attackAnotherHeroMessage.setVisible(false);
                    						                stop();
                    						            }
                    						        }
                    						    };

                    						    // Set the trap message label as the top node of the BorderPane
                    						    map.setTop(attackAnotherHeroMessage);

                    						    // Start the timer
                    						    timer.start();
                				            }            				            	
            				            updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                        updateCharacterDetails(map);

            					});
                					
                					
                					b.setOnMouseClicked(cured -> {
                						
                						(((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).setTarget(((CharacterCell)Game.map[cellRow][cellCol]).getCharacter());           				           
											try {
												((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).cure();
											} catch (NotEnoughActionsException c) {
												Label tiredMessage = new Label("try again next turn.");
												Font font=Font.font("Impact",FontWeight.BOLD,22);
												tiredMessage.setTextFill(Color.WHITE);
	            				            	tiredMessage.setFont(font);
		            						    tiredMessage.setVisible(true);

		            						    // Create a new AnimationTimer with a startTime of -1
		            						    AnimationTimer timer = new AnimationTimer() {
		            						        private long startTime = -1;

		            						        @Override
		            						        public void handle(long now) {
		            						            if (startTime == -1) {
		            						                startTime = now;
		            						            }
		            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
		            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
		            						                // Hide the label and stop the timer
		            						            	tiredMessage.setVisible(false);
		            						                stop();
		            						            }
		            						        }
		            						    };

		            						    // Set the trap message label as the top node of the BorderPane
		            						    map.setTop(tiredMessage);

		            						    // Start the timer
		            						    timer.start();
											}										
        				            catch(NoAvailableResourcesException d){
        				            	Label tiredMessage = new Label("try getting some vaccines first.");
        				            	Font font=Font.font("Impact",FontWeight.BOLD,22);
										tiredMessage.setTextFill(Color.WHITE);
            						    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
        				            }
        				            	catch(InvalidTargetException e){
        				            	    Label attackAnotherHeroMessage = new Label("Try curing something else.");
        				            	    Font font=Font.font("Impact",FontWeight.BOLD,22);
        				            	    attackAnotherHeroMessage.setTextFill(Color.WHITE);
                						    attackAnotherHeroMessage.setFont(font);
                						    attackAnotherHeroMessage.setVisible(true);

                						    // Create a new AnimationTimer with a startTime of -1
                						    AnimationTimer timer = new AnimationTimer() {
                						        private long startTime = -1;

                						        @Override
                						        public void handle(long now) {
                						            if (startTime == -1) {
                						                startTime = now;
                						            }
                						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
                						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
                						                // Hide the label and stop the timer
                						            	attackAnotherHeroMessage.setVisible(false);
                						                stop();
                						            }
                						        }
                						    };

                						    // Set the trap message label as the top node of the BorderPane
                						    map.setTop(attackAnotherHeroMessage);

                						    // Start the timer
                						    timer.start();
            				            }
//        				            	
        				            updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);
                                    
                					});
                    			});
                				specialAction.setOnMouseClicked(specialActionButton -> {
                					if(((CharacterCell) Game.map[finalRow][finalCol]).getCharacter() instanceof Medic){
                						Zombie.setOnMouseClicked(healZombie -> {
                				            (((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).setTarget(((CharacterCell)Game.map[zomRow][zomCol]).getCharacter());           				           
                						});
                						hero.setOnMouseClicked(healHero -> {
                				            (((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).setTarget(((CharacterCell)Game.map[heroRow][heroCol]).getCharacter());           				           

                						});
                						b.setOnMouseClicked(healNothing -> {
                				            (((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).setTarget(null);           				           

                						});
                					
                					if((((CharacterCell)Game.map[finalRow][finalCol]).getCharacter()).getTarget() == null){
                						Label tiredMessage = new Label("try actually heal something.");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    tiredMessage.setTextFill(Color.WHITE);
    				            	    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                					}
                				}
                					else{
                					try {                						
										((Hero) ((CharacterCell) Game.map[finalRow][finalCol]).getCharacter()).useSpecial();
									} 
                					catch (NoAvailableResourcesException x) {
										Label tiredMessage = new Label("try getting some supplies first.");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    tiredMessage.setTextFill(Color.WHITE);
    				            	    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
									}
                					catch(InvalidTargetException y){
                						Label tiredMessage = new Label("try healing someone else thing.");
            						    Font font=Font.font("Impact",FontWeight.BOLD,22);
            						    tiredMessage.setTextFill(Color.WHITE);
    				            	    tiredMessage.setFont(font);
            						    tiredMessage.setVisible(true);

            						    // Create a new AnimationTimer with a startTime of -1
            						    AnimationTimer timer = new AnimationTimer() {
            						        private long startTime = -1;

            						        @Override
            						        public void handle(long now) {
            						            if (startTime == -1) {
            						                startTime = now;
            						            }
            						            long elapsedMillis = (now - startTime) / 1_000_000; // convert nanoseconds to milliseconds
            						            if (elapsedMillis >= 6000) { // 5000 milliseconds = 5 seconds
            						                // Hide the label and stop the timer
            						            	tiredMessage.setVisible(false);
            						                stop();
            						            }
            						        }
            						    };

            						    // Set the trap message label as the top node of the BorderPane
            						    map.setTop(tiredMessage);

            						    // Start the timer
            						    timer.start();
                					}
                				}
                					updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);
                				
                    			});
                				EndTurn.setOnMouseClicked(EndTurnButton -> {            					
										try {
											Game.endTurn();
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
                					updateMap(mapUI, map, up, down, left, right, cure, specialAction, EndTurn,attack,primaryStage); 
                                    updateCharacterDetails(map);
                    			});
                			});
                			mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column 
                			
                		}
                		else if(((CharacterCell) Game.map[row][col]).getCharacter() instanceof Zombie){
                			zomRow = row;
                			zomCol = col;
                			Rectangle rect = new Rectangle(65,65, Color.BROWN);
                			Text text = new Text("Zombie"); // create a new text node with some text
                			text.setFill(Color.WHITE); // set the fill color of the text to WHITE
                			text.setFont(Font.font("Arial", FontWeight.BOLD, 10)); // set the font of the text
                			Zombie = new Button();
                			Zombie.setPrefSize(65, 65);
                			Zombie.setStyle("-fx-background-color: transparent;;");
                			StackPane zomPane = new StackPane(rect, text, Zombie); // create a new StackPane with the rectangle and text nodes
                            zomPane.setScaleY(-1);
                			mapUI.add(zomPane, row, col); // add the stackPane to the GridPane at row & column 
                		}
                		else{
                			cellRow = row;
                			cellCol = col;
                			b = new Button();
                			b.setPrefSize(65, 65);
                			b.setPrefWidth(row);
                			b.setPrefHeight(col);
                	        b.setStyle("-fx-background-color: transparent;;");
                			Rectangle rect = new Rectangle(65, 65, Color.ALICEBLUE);
                			StackPane stackPane = new StackPane(rect,b); // create a new StackPane with the rectangle only
                			mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column
                		}
            		}
            		else if(Game.map[row][col] instanceof CollectibleCell){
            			if(((CollectibleCell) Game.map[row][col]).getCollectible() instanceof Vaccine)
                        {
            				cellRow = row;
                			cellCol = col;
                			b = new Button();
                			b.setPrefSize(65, 65);
                	        b.setStyle("-fx-background-color: transparent;;");
                	        b.setPrefWidth(row);
                			b.setPrefHeight(col);
         			        Rectangle rect = new Rectangle(65, 65, Color.GREEN);
                            Text text = new Text("Vaccine"); // create a new text node with some text
                            text.setFill(Color.WHITE); // set the fill color of the text to WHITE
                            text.setFont(Font.font("Arial", FontWeight.BOLD, 10)); // set the font of the text
                            StackPane stackPane = new StackPane(rect, text,b); // create a new StackPane with the rectangle and text nodes
                            stackPane.setScaleY(-1);
                            mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column}
                    }
         	            else if(((CollectibleCell) Game.map[row][col]).getCollectible() instanceof Supply){
         	            	cellRow = row;
                			cellCol = col;
                			b = new Button();
                			b.setPrefSize(65, 65);
                	        b.setStyle("-fx-background-color: transparent;;");
                	        b.setPrefWidth(row);
                			b.setPrefHeight(col);
                            Rectangle rect = new Rectangle(65, 65, Color.DARKORCHID);
                            Text text = new Text("Supply"); // create a new text node with some text
                            text.setFill(Color.WHITE); // set the fill color of the text to WHITE
                            text.setFont(Font.font("Arial", FontWeight.BOLD, 10)); // set the font of the text
                            StackPane stackPane = new StackPane(rect, text, b); // create a new StackPane with the rectangle and text nodes
                            stackPane.setScaleY(-1);
                            mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column} 
         		}
            		}
            		 
            		else if(Game.map[row][col] instanceof TrapCell){
            			cellRow = row;
            			cellCol = col;
            			b = new Button();
            			b.setPrefSize(65, 65);
            			b.setPrefWidth(row);
            			b.setPrefHeight(col);
            	        b.setStyle("-fx-background-color: transparent;;");
            			Rectangle rect = new Rectangle(65, 65, Color.ALICEBLUE);           			
            			StackPane stackPane = new StackPane(rect, b); // create a new StackPane with the rectangle only
            			mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column 
            		     }
            		}
            	
        
            	   else {
            		   cellRow = row;
           			cellCol = col;
           			b = new Button();
        			b.setPrefSize(65, 65);
        			b.setPrefWidth(row);
        			b.setPrefHeight(col);
        	        b.setStyle("-fx-background-color: transparent;;");
            		Rectangle rect = new Rectangle(65,65, Color.DIMGRAY);
            		StackPane stackPane = new StackPane(rect,b); // create a new StackPane with the rectangle only
        			mapUI.add(stackPane, row, col); // add the stackPane to the GridPane at row & column 
            	        }
            }
        }
                }
        
        
    public void updateCharacterDetails(BorderPane map){ 
    	GridPane characterDetailsGrid = new GridPane();
    	for(int i = 0;i< Game.heroes.size(); i++){
    		Label characterDetails = new Label();
    		String type;
    		 if(Game.heroes.get(i) instanceof Fighter){
             	type = "Fighter";
             }
             else if (Game.heroes.get(i) instanceof Explorer) {
             	type = "Explorer";
             }
             else{
             	type = "Medic";
             }
             String details = "Name: " + Game.heroes.get(i).getName() + "\n" +
                              "Type: " + type  + "\n" +
                              "Current HP: " + Game.heroes.get(i).getCurrentHp()+ "/"+ Game.heroes.get(i).getMaxHp() + "\n" +
                              "Attack Dmg: " + Game.heroes.get(i).getAttackDmg()+ "\n" +
                              "Action Points: " + Game.heroes.get(i).getActionsAvailable() + "/" + Game.heroes.get(i).getMaxActions()+ "\n" +
                              "Supply: " + Game.heroes.get(i).getSupplyInventory().size()+ "\n" +
                              "Vaccine: " + Game.heroes.get(i).getVaccineInventory().size();
             
             Font font=Font.font("Impact",FontWeight.BOLD,20);
             characterDetails.setTextFill(Color.WHITE);            
             characterDetails.setFont(font);
             characterDetails.setText(details);
             characterDetails.setPrefSize(400,800);
             characterDetailsGrid.addRow(i,characterDetails);
    	}
  
            map.setLeft(characterDetailsGrid);          

    }
   
}

