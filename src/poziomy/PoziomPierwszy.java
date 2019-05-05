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

        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 1 * game.getGridSize(), game.getRelativeY() + 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 0 * game.getGridSize(), game.getRelativeY() + 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 1 * game.getGridSize(), game.getRelativeY() + 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 1 * game.getGridSize(), game.getRelativeY() + 1 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 1 * game.getGridSize(), game.getRelativeY() + 0 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 1 * game.getGridSize(), game.getRelativeY() - 1 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 2 * game.getGridSize(), game.getRelativeY() - 1 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 3 * game.getGridSize(), game.getRelativeY() - 1 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 3 * game.getGridSize(), game.getRelativeY() - 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 3 * game.getGridSize(), game.getRelativeY() - 3 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 2 * game.getGridSize(), game.getRelativeY() - 3 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 1 * game.getGridSize(), game.getRelativeY() - 3 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 0 * game.getGridSize(), game.getRelativeY() - 3 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 0 * game.getGridSize(), game.getRelativeY() - 4 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() + 0 * game.getGridSize(), game.getRelativeY() - 5 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 1 * game.getGridSize(), game.getRelativeY() - 5 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 2 * game.getGridSize(), game.getRelativeY() - 5 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 2 * game.getGridSize(), game.getRelativeY() - 4 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 2 * game.getGridSize(), game.getRelativeY() - 3 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 2 * game.getGridSize(), game.getRelativeY() - 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 3 * game.getGridSize(), game.getRelativeY() - 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 4 * game.getGridSize(), game.getRelativeY() - 2 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 4 * game.getGridSize(), game.getRelativeY() - 1 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 4 * game.getGridSize(), game.getRelativeY() - 0 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 3 * game.getGridSize(), game.getRelativeY() - 0 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 2 * game.getGridSize(), game.getRelativeY() - 0 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 1 * game.getGridSize(), game.getRelativeY() - 0 * game.getGridSize(), true);
        new Brick(gr, game.getBrickSize()).draw(game.getRelativeX() - 1 * game.getGridSize(), game.getRelativeY() + 1 * game.getGridSize(), true);
    }

    public Vector2d getStartingPoint(){
        return startingPoint;
    }

}
