package my_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Board 
{
	public static void main(String args[])
	{
        Game white = new Game("White");
        Game black = new Game("Black");
        white.isPlayingWith(black);
        white.isPlayingWith(white);
    }


}
