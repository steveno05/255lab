/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg255project;

import java.awt.*;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        symbol = 'X';
        color = Color.RED; // Corrected syntax for setting color
    }
    
     public HumanPlayer(char symbol, Color color) {
        this.symbol = symbol;
        this.color = color; // Corrected syntax for setting color
    }

    @Override
    public void startTurn() {
        // Implementation for human player's turn if needed
    }
}
