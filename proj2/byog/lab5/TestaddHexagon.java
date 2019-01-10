package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 *  Draws a world that is mostly empty except for a small region.
 */
public class TestaddHexagon {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 50;

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        /*
        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = 20; x < 35; x += 1) {
            for (int y = 5; y < 10; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        //
        */

        location loc1 = new location(25, 5);
        location loc2 = new location(33, 20);
        location loc3 = new location(10, 24);
        addHexagon a = new addHexagon();
        a.addHexagon(4, loc1, world);
        a.addHexagon(2, loc2, world);
        a.addHexagon(8, loc3, world);



        //
        // draws the world to the screen
        ter.renderFrame(world);
    }


}
