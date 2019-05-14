package poziomy;

import com.Poziom;
import com.Game;
import com.Vector2d;
import fIgures.Brick;
import fIgures.Square;
import fIgures.Box;
import fIgures.Target;
import java.awt.*;
import java.util.ArrayList;

public class PoziomPierwszy extends Poziom {

    private Vector2d startingPoint;
    private boolean built = false;
    private Game game;
    private int currentPoints;

    public PoziomPierwszy(Game game){

        objects = new ArrayList<>();
        startingPoint = new Vector2d(0,-1);
        this.game = game;
        currentPoints=0;
    }

    private void build(Game game, Graphics gr){
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,-2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,-2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,-2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,-1),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,0),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,1),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(2,1),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,1),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,3),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(2,3),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,3),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,3),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,4),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,5),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,5),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,5),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,4),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,3),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-3,2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,2),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,1),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,0),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-3,0),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,0),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,0),game));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,-1),game));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(-3,1),game));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,4),game));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(2,2),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,1),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,2),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(0,2),game));
        //objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(0,1),game));
        this.built = true;
    }

    public void draw(Graphics gr) {
        if(!built)this.build(game, gr);

        for(Square square : objects){
            if(square instanceof Target){
                ((Target)square).draw(gr);
            }else{
                square.draw(gr);
            }
        }

    }

    public Vector2d getStartingPoint(){
        return startingPoint;
    }

}
