package com.mygdx.game.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.BunnyGame;

/**
 * Created by mariajoaomirapaulo on 26/05/16.
 */
public class Carrot extends InteractiveTileObject{

    public Carrot(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type= BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX()+bounds.getWidth()/2)/ BunnyGame.PPM,(bounds.getY()+bounds.getHeight()/2)/ BunnyGame.PPM);

        body = world.createBody(bdef);
        shape.setAsBox(bounds.getWidth()/2/ BunnyGame.PPM,bounds.getHeight()/2/ BunnyGame.PPM);
        fdef.shape=shape;
        fdef.isSensor=true;
        fixture = body.createFixture(fdef);
        fixture.setUserData(this);


        setCategoryFilter(BunnyGame.CARROT_BIT);
    }

    @Override
    public void bunnyHit() {
        Gdx.app.log("Carrot","Colison");
        setCategoryFilter(BunnyGame.DESTROYED_BIT);
        getCell().setTile(null);
    }

}
