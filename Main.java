// original code from https://www.youtube.com/watch?v=IKB1hWWedMk
// this file is written by: Carter Brainerd <https://github.com/thecarterb> 

// !!!!!!!!PASTE THIS DIRECTLY INTO PROCESSING!!!!!!!!!!!!

int cols;      //columns
int rows;      //rows
int scl = 20;  //scale

void setup(){
   size(600,600,P3D); //setup size of dwaring canvas
    int w = 600; //height
    int h = 600; //width
    cols = w /scl;
    rows = h / scl;
  
}

void draw(){
  background(0); //set the background
  
  for (int y = 0; y < rows; y++){
    beginShape(TRIANGLE_STRIP); //spawn triangle strip shape
    for (int x = 0; x < cols; x++){
      vertex(x * scl, y * scl);        // draw vertices for previously spawned TRIANGLE_SHAPE
      vertex(x * scl, (y + 1) * scl);  //

      //rect(x*scl, y*scl, scl,scl);
    }
    endShape();
  }
  
}
