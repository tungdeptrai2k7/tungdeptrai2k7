package game.enemy;

import game.FrameCounter;
import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import game.physics.Physics;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import game.renderer.Animation;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter fireCounter;

    public Enemy() {
        super();
        this.position.set(0, -30);
        this.velocity.set(3, -1);
        this.createRenderer();
        this.fireCounter = new FrameCounter(30);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
		this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        if (this.fireCounter.run()){
            this.fire();
        }
    }
    private void move(){
        if(this.position.x > Settings.BACKGROUND_WIDTH - 14
                && this.velocity.x > 0) {
            this.velocity.set(-3, this.velocity.y);
        }
        if(this.position.x < 14 && this.velocity.x < 0) {
            this.velocity.set(3, this.velocity.y);
        }

        if(this.position.y > Settings.SCREEN_HEIGHT - 14
                && this.velocity.y > 0) {
            this.velocity.set(this.velocity.x, -1);
        }
        if(this.position.y < 14 && this.velocity.y < 0) {
            this.velocity.set(this.velocity.x, 1);
        }
    }
    private  void fire(){
        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
        bullet.position.set(this.position.x,this.position.y);
        this.fireCounter.reset();
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
