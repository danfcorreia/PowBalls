package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_SPACE;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public class Player2 implements KeyboardHandler {

    Picture ski = new Picture(350, 60, "resources/skiguy.png");
    private Picture menu2;
    private Game game;
    private Keyboard keyboard;
    private boolean gameStart2 = false;

    public void drawMenu2() throws InterruptedException {
        menu2 = new Picture(10, 10, "resources/backg3.png");
        menu2.draw();

        while (!gameStart2) {
            System.out.println("Again shit");
            System.out.println(gameStart2);
        }
       game.startSecondgame();
    }

    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent gameSTART = new KeyboardEvent();
        gameSTART.setKey(KeyboardEvent.KEY_Q);
        gameSTART.setKeyboardEventType(KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(gameSTART);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                if (gameStart2 == true) {
                    if (ski.getMaxX() <= 620) {
                        ski.translate(30, 0);
                    }
                }
                break;
            case KeyboardEvent.KEY_A:
                if (gameStart2 == true) {
                    if (ski.getX() >= 52) {
                        ski.translate(-30, 0);
                    }
                }
                break;
            case KeyboardEvent.KEY_Q:
                if (gameStart2 == false) {
                    menu2.delete();
                    this.gameStart2 = true;
                    System.out.println("batata" + gameStart2);
                    break;
                }
        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
        }

}