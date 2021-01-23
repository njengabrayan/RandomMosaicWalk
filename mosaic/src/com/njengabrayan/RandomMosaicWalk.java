package com.njengabrayan;
/*
    This program opens a window full of randomly colored squares.
    A 'disturbance' moves randomly in the window changing the color of each square that it visits.
    THE PROGRAM WILL RUN UNTIL THE WINDOW IS CLOSED
 */
public class RandomMosaicWalk {
    static int currentRow; //Row currently containing the disturbance
    static int currentColumn; //Column currently containing disturbance

    static void fillWithRandomColors(){
        /*
            *fills window with random colored squares
            * pre-condition: mosaic window is open
            * post-condition: each square has been set to a random color
         */
        int row, column;
        for (row = 0; row < 16; row++){
            for (column = 0; column < 20; column++){
                changeToRandomColor(row, column);
            }
        }
    } // end fillWithRandomColors

    static  void changeToRandomColor(int rowNum, int colNum ){
        /*
            *changes a single square to a new randomly selected color
            * pre-condition: specified rowNum and colNum are in the valid range of row and column numbers
                *rowNum - counting rows down from 0 at the top
                *colNum - counting columns over from 0 at the left
         * post-condition: square has been set to a random color
         */
        int red = (int)(256*Math.random());
        int green = (int)(256*Math.random());
        int blue = (int)(256*Math.random());
        Mosaic.setColor(rowNum,colNum,red,green,blue);
    } // end changeToRandomColor

    static  void randomMove(){
        /*
            *move the disturbance
            *
         */
        int directionNum;
        // Randomly set to 0,1,2 or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum){
            case 0: // move up
                currentRow--;
                if (currentRow < 0)
                    currentRow = 15;
                break;
            case 1:  // move right
                currentColumn++;
                if (currentColumn >= 20)
                    currentColumn = 0;
                break;
            case 2: // move down
                currentRow++;
                if (currentRow >= 16)
                    currentRow = 0;
                break;
            case 3: // move left
                currentColumn--;
                if(currentColumn < 0 )
                    currentColumn = 19;
                break;
        }
    } // end randomMove

    public static void main(String[] args) {
	/* the main program will: create the window,
	                          fill it with random colors,
	                          move the disturbance in random walk around the window as long as it is open
	 */
        Mosaic.open(16,20,25,25);
        fillWithRandomColors();
        currentRow = 8; //start at center of window
        currentColumn = 10;
        while (Mosaic.isOpen()) {
            changeToRandomColor(currentRow,currentColumn);
            randomMove();
            Mosaic.delay(1);
        }
    }   // end Main function
}   // end class RandomMosaicWalk
