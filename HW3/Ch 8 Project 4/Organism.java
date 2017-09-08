import java.util.Random;

public class Organism
{
  private int breed_count, column, row;

  //constructors
  Organism(int x, int y)
  {
    this.column = x;
    this.row = y;
    this.breed_count = 0;
  }

//accessors
  public int getRow()
  {
    return row;
  }

  public int getColumn()
  {
    return column;
  }

  public int getBreedCount()
  {
    return breed_count;
  }

//mutators
  public void setX(int x)
  {
    this.column = x;
  }

  public void setY(int y)
  {
    this.row = y;
  }

  public void setBreedCount(int count)
  {
    this.breed_count = count;
  }

  //method to move locations and return 2d array map
  public Organism[][] move(Organism[][] map)
  {
    Random r = new Random();
    int i = 0;//r.nextInt(4);
    System.out.println(i);
    //i is used to determine random movement using 0 = up, 1 = right, 2 = left, 3 = right
    switch(i)
    {
      case 0:
        if((this.row - 1 >= 0) && map[this.row + 1][this.column] == null){
          System.out.println(map[this.row][this.column]);
          map[this.row+1][this.column] = map[this.row][this.column];
          map[this.row][this.column] = null;
          System.out.println("the new spot has " + map[this.row+1][this.column]);
          System.out.println("the old spot has " + map[this.row][this.column]);
        }
        System.out.println("ant tries to move up");
        break;
      case 1:
        if((this.column + 1 < 20) && map[row][column + 1] == null){
          System.out.println(map[this.row][this.column]);
          map[this.row][this.column + 1] = map[this.row][this.column];
          map[row][column] = null;
          System.out.println(map[this.row][this.column + 1]);
          System.out.println(map[this.row][this.column]);
        }

        System.out.println("ant tries to move right");
        break;
      case 2:
        System.out.println("ant tries to move down");
        break;
      case 3:
        System.out.println("ant tries to move left");
        break;
    }
    return map;
  }
  //method for breeding
  public Organism[][] breed(Organism[][] map)
  {
    //check to see where we can put the new bug
    //checking vertically
    for( int i = -1; i <= 1; i++)
    {
      for ( int j = -1; j <= 1; j++)
      {
        System.out.println(i + j);

        //check to see if new spot is off the map
        if(getRow() + i >= 20 || getRow() + i < 0 ||
        getColumn() + j >= 20 || getColumn() + i < 0 || (i + j)%2 == 0)
        {
          //the new place is off the map
          System.out.println("broke out " + (i + j));
        }
        else
        {
          //check for open spot
          if(map[getRow() + i][getColumn() + j] == null)
          {
            //make new bug
            Organism newBug = new Organism(getRow() + i, getColumn() + j);
            map[getRow() + i][getColumn() + j] = newBug;
            System.out.println("old bug " + map[getRow()][getColumn()]);
            System.out.println("new bug " + map[getRow() + i][getColumn() + j]);
            return map;
          }
        }
      }
    }
    //no space available so bug was not added
    return map;
  }
}
  //method for breed
  /*
  public Organism[][] breed(Organism[][])
  {
    if()
  }
*/
