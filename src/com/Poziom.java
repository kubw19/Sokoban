package com;

import java.awt.*;
import java.util.ArrayList;

import com.Vector2d;
import fIgures.Brick;
import fIgures.Square;

public abstract class Poziom {
    public abstract void draw(Graphics gr);
    public abstract Vector2d getStartingPoint();

    public ArrayList<Square> objects;
}
