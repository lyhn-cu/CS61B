package byog.lab5;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/** add a hexagon to a world.
 *
 */
public class addHexagon {
    //private int size;

    public void addHexagon(int size, location l, TETile[][] world) {

        //error for size
        if (size < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        //error for x.bound
        if ((l.x - size) < 0 || (l.x + 2 * size - 1) > world.length) {
            throw new IllegalArgumentException("x Out of world.");
        }

        //error for y.bound
        if ((l.y + 2 * size) > world[0].length) {
            throw new IllegalArgumentException("y Out of world.");
        }

        //build Hexagon
        for (int j = 0; j < size ; j++) {
            for (int i = 0; i < (size + 2 * j); i++) {
                //base row [0] to lower middle row [size - 1]
                world[l.x - j + i][l.y + j] = Tileset.WALL;
                //top row [2 * size - 1] to upper middle row [size]
                world[l.x - j + i][l.y + 2 * size - 1 - j] = Tileset.WALL;
            }

        }
    }
}
