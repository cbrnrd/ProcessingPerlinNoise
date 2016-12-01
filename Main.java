// original code from https://www.youtube.com/watch?v=IKB1hWWedMk
// this file is written by: Carter Brainerd <https://github.com/thecarterb> 

// !!!!!!!!PASTE THIS DIRECTLY INTO PROCESSING!!!!!!!!!!!!

///////////////////GLOBALS
int cols;      //columns
int rows;      //rows
int scl = 20;  //scale

int w = 2500; //height
int h = 1500; //width

float flying = 0;

float[][] terrain;
///////////////////////////


void setup() { //required function!!!
  size(1920,1020, P3D); //setup size of drawing canvas
  cols  = w /scl;
  rows  = h / scl;

  //2d array for terrain grid
  terrain = new float[cols][rows];
}

void draw() {         //required function!!!

  flying -= 0.1;
  float yoff = flying; //y offset

  //generate random z axis values
  for (int y = 0; y < rows; y++) {
    float xoff = 0; //x offset
    for (int x = 0; x < cols; x++) {
      terrain[x][y] = map(noise(xoff, yoff), 0, 1, -150, 150); //noise(x, y) always returns something between 0-1
      xoff += 0.1;
    }
    yoff += 0.1;
  }

  background(0); //set the background
  stroke(255);   //set stroke to be white
  noFill();      //no fill for the triangle strip

  //center triangles on screen
  translate(width/2, height/2 + 50);
  rotateX(PI/3);
  translate(-w/2, -h/2);

  //main generation code
  for (int y = 0; y < rows - 1; y++) {
    beginShape(TRIANGLE_STRIP);                       //spawn triangle strip shape
    for (int x = 0; x < cols; x++) {
      vertex(x * scl, y * scl, terrain[x][y]);        // draw vertices for previously spawned TRIANGLE_SHAPE
      vertex(x * scl, (y + 1) * scl, terrain[x][y + 1]);  // [y + 1] is to cut out clipping if we were to just use [y]
    }
    endShape(); //ends production of the shape
  } //goes back and remakes shape
}
