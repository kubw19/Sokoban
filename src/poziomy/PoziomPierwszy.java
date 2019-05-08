package poziomy;

import com.Poziom;
import com.Game;
import com.Vector2d;
import fIgures.Brick;

import java.awt.*;

public class PoziomPierwszy implements Poziom {

    private Vector2d startingPoint;

    public PoziomPierwszy(){
        startingPoint = new Vector2d(0,-1);
    }

    public void draw(Game game, Graphics gr) {

        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(1,2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(0,2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-1,2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(1,1));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(1,0));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(1,-1));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(2,-1));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(3,-1));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(3,-2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(3,-3));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(2,-3));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(1,-3));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(0,-3));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(0,-4));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(0,-5));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-1,-5));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-2,-5));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-2,-4));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-2,-3));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-2,-2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-3,-2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-4,-2));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-4,-1));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-4,0));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-3,0));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-2,0));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-1,0));
        new Brick(gr, game.getBrickSize()).draw(Game.getNormalizedPosition(-1,1));
    }

    public Vector2d getStartingPoint(){
        return startingPoint;
    }

}
