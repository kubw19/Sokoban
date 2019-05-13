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
    private int neededWinPoints;
    private int currentWinPoints;

    public PoziomPierwszy(Game game){

        objects = new ArrayList<>();
        startingPoint = new Vector2d(0,-1);
        this.game = game;
        neededWinPoints=3;
        currentWinPoints=0;
    }

    private void build(Game game, Graphics gr){
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,-2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,-2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,-2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,-1)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,0)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,1)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(2,1)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,1)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(3,3)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(2,3)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(1,3)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,3)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,4)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(0,5)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,5)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,5)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,4)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,3)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-3,2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,2)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,1)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-4,0)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-3,0)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-2,0)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,0)));
        objects.add(new Brick(gr, game.getBrickSize(), Game.getNormalizedPosition(-1,-1)));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(-3,1),game));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,4),game));
        objects.add(new Target(gr,game.getBrickSize(),Game.getNormalizedPosition(2,2),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,1),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(-1,2),game));
        objects.add(new Box(gr,game.getBrickSize(),Game.getNormalizedPosition(0,2),game));
        this.built = true;
    }

    public void draw(Graphics gr) {
        if(!built)this.build(game, gr);

        for(Square square : objects){
            square.draw(gr);
        }

    }

    public Vector2d getStartingPoint(){
        return startingPoint;
    }

}
