package com.star.app.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.star.app.screen.utils.Assets;

public class BotWeapon {
    private GameController gc;
    private Bot bot;
    private String title;
    private float firePeriod;
    private int damage;
    private float bulletSpeed;
//    private int maxBullets;
//    private int curBullets;
    private Vector3[] slots;
    private Sound shootSound;

    public float getFirePeriod() {
        return firePeriod;
    }

//    public int getMaxBullets() {
//        return maxBullets;
//    }

//    public int getCurBullets() {
//        return curBullets;
//    }

    public BotWeapon(GameController gc, Bot bot, String title,
                     float firePeriod, int damage, float bulletSpeed, Vector3[] slots) {
        this.gc = gc;
        this.bot = bot;
//        this.hero = hero;
        this.title = title;
        this.firePeriod = firePeriod;
        this.damage = damage;
        this.bulletSpeed = bulletSpeed;
//        this.maxBullets = maxBullets;
//        this.curBullets = maxBullets;
        this.slots = slots;
//        this.shootSound = Assets.getInstance().getAssetManager().get("audio/shoot.mp3");
    }

    public void fire() {
//        if (curBullets > 0) {
//            curBullets--;
//            shootSound.play();
            for (int i = 0; i < slots.length; i++) {
                float x, y, vx, vy;

                x = bot.getPosition().x + MathUtils.cosDeg(bot.getAngle() + slots[i].y) * slots[i].x;
                y = bot.getPosition().y + MathUtils.sinDeg(bot.getAngle() + slots[i].y) * slots[i].x;

                Hero hero = gc.getHero();

                // переделать скорость в сторону героя чтобы стрельба была

//                float dst = hero.getPosition().dst(bot.getPosition());
                Vector2 tmpVec = new Vector2(0, 0);
                tmpVec.set(hero.getPosition()).sub(bot.getPosition()).nor();
                Vector2 velocity = new Vector2(0, 0);
                velocity.mulAdd(tmpVec, 100.0f);
                vx = velocity.x;
                vy = velocity.y;

//                vx = hero.getVelocity().x + bulletSpeed * MathUtils.cosDeg(hero.getAngle() + slots[i].z);
//                vy = hero.getVelocity().y + bulletSpeed * MathUtils.sinDeg(hero.getAngle() + slots[i].z);

                gc.getBulletController().setup(x, y, vx, vy);

//                float dst = position.dst(gc.getHero().getPosition());
//                if (dst < DST_TO_TAKE) {
//                    tmpVec.set(gc.getHero().getPosition()).sub(position).nor();
//                    velocity.mulAdd(tmpVec, 10.0f);
//                }
            }
        }
//    }

//    public void addAmmos(int amount) {
//        curBullets += amount;
//        if (curBullets > maxBullets) {
//            curBullets = maxBullets;
//        }
//    }
}
