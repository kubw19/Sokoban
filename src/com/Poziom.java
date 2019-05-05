package com;

import java.awt.*;
import com.Vector2d;

public interface Poziom {
    public void draw(Game game, Graphics gr);
    public Vector2d getStartingPoint();
}
