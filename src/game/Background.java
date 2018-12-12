package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, 600 - image.getHeight());
        this.anchor.set(0, 0);
        this.velocity.set(0, 10);
    }

    @Override
    public void run() {
        super.run();
        if(this.position.y > 0) {
            this.position.set(0, 0);
            this.velocity.set(0, 0);
        }
    }
}
