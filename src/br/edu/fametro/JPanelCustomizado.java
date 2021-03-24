package br.edu.fametro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class JPanelCustomizado extends JPanel {

    private BufferedImage bufferedImage;

    public JPanelCustomizado(String caminhoImagem) {
        try {

            URL imageSource = this.getClass().getClassLoader().getResource(caminhoImagem);
            if (imageSource == null) {
                // Handle the resource being missing
            }else{
                bufferedImage = ImageIO.read(imageSource);
            }
        } catch (IOException ioException) {
            System.out.println("Ocorreu um erro ao tentar instanciar o JPanel Customizado.\nErro: " + ioException.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(bufferedImage, 0, 0, this);
    }
}
