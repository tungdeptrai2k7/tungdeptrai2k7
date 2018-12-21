package game.enemy;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    public EnemyBullet(){
        super();
        this.createRenderer();
        this.velocity.set(0,10);
        this.boxCollider = new BoxCollider(this.position,this.anchor,20,20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y > Settings.SCREEN_HEIGHT) {
            this.destroy();
        }
        this.checkIntersect();
    }
    private void checkIntersect(){
        Player player = GameObject.findIntersected(Player.class,this.boxCollider);
        if (player!=null){
            this.destroy();
            player.destroy();
        }
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}